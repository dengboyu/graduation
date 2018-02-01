package com.leng.sguide.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;

/**
 * Created by by@Deng on 2017/7/11.
 */
public class ImgUtils {

    /**
     *合并图片
     * @param qrPosition_x
     * @param qrPosition_y
     * @param mainImg
     * @param slaveImg
     * @param qrWidth
     * @param qrHeight
     * @return String 上传到七牛云的链接
     */
    public void createPicTwo2(int qrPosition_x,int qrPosition_y,String mainImg, String slaveImg,int qrWidth,int qrHeight)
    {
        try
        {
            URL mainImgURL = new URL(mainImg);
            URL slaveImgURL = new URL(slaveImg);
            //读取第一张图片
            BufferedImage ImageOne = ImageIO.read(mainImgURL);
            int width = ImageOne.getWidth();//图片宽度
            int height = ImageOne.getHeight();//图片高度
            //从图片中读取RGB
            int[] ImageArrayOne = new int[width*height];
            ImageArrayOne = ImageOne.getRGB(0,0,width,height,ImageArrayOne,0,width);
            //对第二张图片做相同的处理
            BufferedImage ImageTwo = ImageIO.read(slaveImgURL);
            //新图片
            BufferedImage newImageTwo = resizeImg(qrWidth, qrHeight, ImageTwo);
            int widthTwo = newImageTwo.getWidth();//图片宽度
            int heightTwo = newImageTwo.getHeight();//图片高度
            int[] ImageArrayTwo = new int[widthTwo*heightTwo];
            ImageArrayTwo = newImageTwo.getRGB(0,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);

            //生成新图片
            BufferedImage ImageNew = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            ImageNew.setRGB(0,0,width,height,ImageArrayOne,0,width);//设置左半部分的RGB  第一张图片
            ImageNew.setRGB(qrPosition_x,qrPosition_y,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);//设置右半部分的RGB


            File outFile = new File("G:\\out.png");
            ImageIO.write(ImageNew, "png", outFile);//写图片

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     *对图片进行缩放
     * @param tagetWidth 目标宽度
     * @param tagetHeight 目标高度
     * @param newImg
     * @return
     */
    public static BufferedImage resizeImg(int tagetWidth, int tagetHeight, BufferedImage newImg) {
        BufferedImage newImageTwo = new BufferedImage(tagetWidth, tagetHeight, newImg.getType());
        Graphics g = newImageTwo.getGraphics();
        g.drawImage(newImg, 0, 0, tagetWidth, tagetHeight, null); //画图
        g.dispose();
        return newImageTwo;
    }

    /**
     * 合成图片并且返回字节数组
     * @param qrPosition_x
     * @param qrPosition_y
     * @param mainImg
     * @param slaveImg
     * @param qrWidth
     * @param qrHeight
     * @auther zeal
     * @return
     */
    public static byte[]  getSlaveImg(int qrPosition_x,int qrPosition_y,String mainImg, String slaveImg,int qrWidth,int qrHeight) {
        byte[] uploadBytes=null;
        try {
            URL mainImgURL = new URL(mainImg);
            URL slaveImgURL = new URL(slaveImg);
            //读取第一张图片
            BufferedImage ImageOne = ImageIO.read(mainImgURL);
            int width = ImageOne.getWidth();//图片宽度
            int height = ImageOne.getHeight();//图片高度
            //从图片中读取RGB
            int[] ImageArrayOne = new int[width * height];
            ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);
            //对第二张图片做相同的处理
            BufferedImage ImageTwo = ImageIO.read(slaveImgURL);
            //新图片
            BufferedImage newImageTwo = resizeImg(qrWidth, qrHeight, ImageTwo);
            int widthTwo = newImageTwo.getWidth();//图片宽度
            int heightTwo = newImageTwo.getHeight();//图片高度
            int[] ImageArrayTwo = new int[widthTwo * heightTwo];
            ImageArrayTwo = newImageTwo.getRGB(0, 0, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);

            //生成新图片
            BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);//设置左半部分的RGB  第一张图片
            ImageNew.setRGB(qrPosition_x, qrPosition_y, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);//设置右半部分的RGB


            //File outFile = new File("G:\\out.png");
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            ImageIO.write(ImageNew, "png", byteArrayOutputStream);//写图片
            uploadBytes =byteArrayOutputStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploadBytes;
    }

    public static void main(String[] args) {

        ImgUtils img = new ImgUtils();
        img.createPicTwo2(30, 30 ,
                "http://pics.ctripfair.com/o_1bi8vjume7r41uba1k19pcl1dsj24.jpg?imageslim",
                "http://pics.ctripfair.com/FjLn6BB3RO82Ezmv1qS3JvP4eVfL",200,200);
    }


}
