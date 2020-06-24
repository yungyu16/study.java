package com.github.study.java;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/6/24.
 */
public class PrintTest {
    public static void main(String[] args) {
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintService[] pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 200, 200, pservices,
                defaultService, flavor, aset);
        if (service != null) {
            try {
                DocPrintJob pj = service.createPrintJob();
                aset.add(MediaSizeName.ISO_A4);
                FileInputStream fis = new FileInputStream(Paths.get("pom.xml").toFile());
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das);
                pj.print(doc, aset);
                Thread.sleep(10 * 1000);
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            } catch (PrintException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("打印失败");
        }

    }
}
