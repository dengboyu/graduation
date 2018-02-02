package com.leng.sguide.module.leung.controller;

import com.leng.sguide.common.annotation.Result;
import com.leng.sguide.common.exception.ByException;
import com.leng.sguide.common.sysconstant.Constants;
import com.leng.sguide.module.leung.entity.ProductEntity;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import com.leng.sguide.utils.FileUtils;
import com.leng.sguide.utils.UUIDUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leng.sguide.module.leung.service.ProductService;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


/**
* product表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-29 01:47:55
*/
@RestController
@RequestMapping("product")
@Result
public class ProductController{

    @Resource
    private ProductService productService;



    /**
     * 解析图片
     * @author by@Deng
     * @date 2018/1/30 上午7:46
     */
    @PostMapping("parseProductImg")
    public Object parseProductImg(HttpServletRequest request) throws Exception{
        String pic = "";

        //保存文件地址
        String savePath = request.getServletContext().getRealPath("/WEB-INF/download");

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding(Constants.DEFAULTCHARSET);  //解决上传文件名的中文乱码问题

        List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
        for(FileItem fileItem :fileItemList){
            if(fileItem.isFormField()){
                //普通输入项
                String name = fileItem.getFieldName();
                String value = fileItem.getString();
                value = new String(value.getBytes("ISO-8859-1"),Constants.DEFAULTCHARSET);  //中文乱码问题
                System.out.println("key="+name+",value="+value);
            }else{
                String name = fileItem.getName();   //上传文件名称(不同浏览器上传名称不同)
                if(StringUtils.isEmpty(name)) continue;

                name = name.substring(name.lastIndexOf(File.separator)+1);
                name = makeFileName(name);
                String finalSavePath = makeDirectory(name,savePath);    //最终文件保存目录

                pic =  name;

                InputStream inputStream = fileItem.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(finalSavePath+File.separator+name);

                //读取流文件
                byte[] buffer = new byte[1024];
                int len =0;
                while ((len = inputStream.read(buffer))>0){
                    outputStream.write(buffer,0,len);
                }

                outputStream.close();
                inputStream.close();
                fileItem.delete();  //删除临时文件(必须在关闭流后边)
            }
        }

        return pic;
    }


    /**
     * 产生文件夹
     * @author by@Deng
     * @date 2017/10/12 下午10:58
     */
    public String makeDirectory(String filename,String savePath){
        //哈希打散算法

        int hashcode = filename.hashCode(); //哈希地址
        int dir1 =hashcode&0xf; //第4位
        int dir2 = (hashcode&0xf0)>>4;   //5-8位

        String dir =savePath +File.separator + dir1 + File.separator + dir2 ;

        FileUtils.createDirectory(dir); //创建目录

        return dir;
    }

    /**
     * 产生唯一文件名
     * @author by@Deng
     * @date 2017/10/12 下午10:49
     */
    public String makeFileName(String filename){
        return UUIDUtils.getUUID()+"_"+filename;
    }


    /**
     * 下载文件
     * @author by@Deng
     * @date 2018/1/30 上午11:04
     */
    @GetMapping("downLoadFile")
    public void downLoadFile(@RequestParam String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {


        fileName = new String(fileName.getBytes("iso8859-1"),"utf-8");
        String path = makeDirectory(fileName,request.getServletContext().getRealPath("/WEB-INF/download"));

        File file = new File(path+File.separator+fileName);
        if(!file.exists()) throw new ByException("文件不存在");


        String realName =fileName.substring(fileName.indexOf("_")+1);
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(realName,"UTF-8"));

        FileInputStream fileInputStream = new FileInputStream(path+File.separator+fileName);
        OutputStream outputStream = response.getOutputStream();
        byte buffer[] = new byte[1024];
        int len = 0;
        while((len = fileInputStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }

        fileInputStream.close();
        outputStream.close();
    }


    /**
     * 添加产品图片
     * @author by@Deng
     * @date 2018/1/30 下午2:52
     */
    @PostMapping("insertProductEntity")
    public Object insertProductEntity(@RequestBody ProductEntity productEntity) throws Exception{
        Object object= SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object==null) throw new ByException("请先登录");

        UserInfoEntity userInfoEntity = (UserInfoEntity) object;
        productEntity.setUserId(userInfoEntity.getId());
        productEntity.setSaleAmount(0);
        productEntity.setScanAmount(0);
        productEntity.setScore(4d);

        return  productService.insertEntity(productEntity);
    }


    /**
     * 搜索商品
     * @author by@Deng
     * @date 2018/1/31 下午3:10
     */
    @GetMapping("getProductList")
    public Object getProductList(@RequestParam Map<String,Object> map) throws Exception{
        Integer userId=null;
        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object!=null){
            UserInfoEntity userInfoEntity = (UserInfoEntity) object;
            userId = userInfoEntity.getId();
        }
        map.put("userId",userId);

        return productService.getProductList(map);
    }


    /**
     * 根据产品id查询产品详情
     * @author by@Deng
     * @date 2018/1/31 下午4:22
     */
    @GetMapping("getProductDetail")
    public Object getProductDetail(@RequestParam String id) throws Exception{
        Integer userId = null;
        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object!=null){
            UserInfoEntity userInfoEntity = (UserInfoEntity) object;
            userId = userInfoEntity.getId();
        }
        return productService.getProductDetail(id,userId);
    }


    /**
     * 获取下单地址
     * @author by@Deng
     * @date 2018/1/31 下午8:45
     */
    @GetMapping("getProductAddress")
    public Object getProductAddress() throws Exception{
        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object==null) throw new ByException("请先登录");

        UserInfoEntity userInfoEntity = (UserInfoEntity) object;
        return userInfoEntity;
    }


}