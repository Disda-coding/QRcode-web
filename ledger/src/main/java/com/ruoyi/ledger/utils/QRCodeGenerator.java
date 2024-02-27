package com.ruoyi.ledger.utils;

import com.beust.jcommander.internal.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ruoyi.common.utils.sign.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @program: qrcode-ruoyi
 * @description: 用于生成二维码
 * @author: Disda
 * @create: 2024-02-27 10:30
 */
public class QRCodeGenerator {
//    public static void main(String[] args) {
//        ArrayList<String> res = new ArrayList<String>();
//        res.add("STS静态转换开关");
//        res.add("Ⅰ区横向防火墙(600内网专用2）");
//        res.add("Ⅰ区横向防火墙(600内网专用1）");
//        res.add("内网监测平台网关");
//        res.add("一平面一区交换机");
//        res.add("二平面一区交换机");
//        res.add("Ⅱ区交换机");
//        res.add("一平面二区交换机1");
//        res.add("二平面二区交换机1");
//        res.add("Ⅰ区内网交换机A");
//        res.add("Ⅰ区内网交换机B");
//        StringBuilder rec = new StringBuilder();
//        for (String tmp : res) {
//            rec.append(tmp).append("\n");
//        }
//        try {
//            generateQRCodeImage(rec.toString(),"02B3",400,200);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//
//    }


    public static String generateDevQRCode(ArrayList<String> list, String name) {
        String res = new String();
        StringBuilder rec = new StringBuilder();
        for (String tmp : list) {
            rec.append(tmp).append("\n");
        }
        try {
            res = generateQRCodeImage(rec.toString(), name, 400, 200);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return res;
    }


    public static String generateQRCodeImage(String text, String qrText, int width, int height) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = Maps.newHashMap();
        // 设置参数
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 2);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 600, 200, hints);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        // ------------------------------------------自定义文本描述-------------------------------------------------
        //在内存创建图片缓冲区 这里设置画板的宽高和类型
        BufferedImage outImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        //创建画布
        Graphics2D outg = outImage.createGraphics();
        // 在画布上画上二维码 X轴Y轴，宽度高度
        outg.drawImage(image, -200, 0, image.getWidth(), image.getHeight(), null);
        // 画文字到新的面板
        outg.setColor(Color.BLACK);
        // 字体、字型、字号
        Font fontChinese = new Font("微软雅黑", Font.PLAIN, 35);
        outg.setFont(fontChinese);
        //drawString(文字信息、x轴、y轴)方法根据参数设置文字的坐标轴 ，根据需要来进行调整
        outg.drawString(qrText, (width - 150), (height + 20) / 2);
        outg.dispose();
        outImage.flush();
        image = outImage;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            boolean flag = ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.encode(baos.toByteArray());
    }

}