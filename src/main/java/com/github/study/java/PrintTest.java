package com.github.study.java;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/6/24.
 */
public class PrintTest {
    public static void main(String[] args) {
        File file = new File("pom.xml"); // 获取选择的文件
        // 构建打印请求属性集
        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        // 设置打印格式，因为未确定类型，所以选择autosense
        DocFlavor flavor = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
        DocAttributeSet das = new HashDocAttributeSet();
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, das);
        for (PrintService printService : printServices) {
            try {
                DocPrintJob job = printService.createPrintJob(); // 创建打印作业
                FileInputStream fis = new FileInputStream(file); // 构造待打印的文件流
                Doc doc = new SimpleDoc(fis, flavor, das);
                job.print(doc, pras);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
