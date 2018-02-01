package com.leng.sguide.utils;

import com.leng.sguide.common.exception.ByException ;
import com.leng.sguide.common.exception.CodeEnum ;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by by@Deng on 2017/7/11.
 */
public class ExportFileUtils {

    /**
     * 设置下载文件编码
     * @param response
     * @param fileName
     * @throws UnsupportedEncodingException
     */
    public final static void setAttachmentFileName(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {

        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    }



    /**
     * 读取出excel中的所有数据信息
     *
     * @author by@Deng
     * @date 2017/12/13 下午9:28
     */
    public static void getDataFromExcel(String filePath) throws Exception {

        //获取一个绝对路径地址流
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workBook = null;


        if (filePath.endsWith(".xls")) {
            workBook = new HSSFWorkbook(fis);//07版以前的excel，用.xls结尾
        } else if (filePath.endsWith(".xlsx")) {
            workBook = new XSSFWorkbook(fis);//07版以后的excel，用.xlsx结尾
        } else {
            throw new ByException(CodeEnum.CUSTOMIZED.getCode(), "文件不是excel类型");
        }

        if (workBook == null) throw new ByException(CodeEnum.CUSTOMIZED.getCode(), "解析excel异常");

        //得到共有几个sheet
        int sheetNum = workBook.getNumberOfSheets();

        //sheet页循环
        for (int i = 0; i < sheetNum; i++) {

            Sheet sheet = workBook.getSheetAt(i);   //得到一个工作表
            String sheetName = sheet.getSheetName();    //获取sheet页的名称
            int totalRow = sheet.getLastRowNum() + 1;   //获取最后一行的行号

            //每行循环
            for (int j = 0; j < totalRow; j++) {
                Row row = sheet.getRow(j);  //获取每一行

                //得到该行的所有列
                Iterator<Cell> cellIterator = row.cellIterator();

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();    //每一列

                    switch (cell.getCellType()) {
                        case 1: //字符串
                            System.out.println(cell.getRichStringCellValue().getString());
                            break;
                        case 0: //数字
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case 4: //布尔
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case 2:
                            System.out.println(cell.getCellFormula());
                            break;
                        case 3: //空格
                            System.out.println();
                            break;
                        default:
                            System.out.println();
                    }
                }
            }
        }

    }

}
