package com.github.study.java;

import javax.print.*;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/6/24.
 */
public class PrintTest {
    public static void main(String[] args) throws Exception {

        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        Path path = Paths.get("test.png");
        System.out.println(path.toAbsolutePath());
        for (DocFlavor flavor : printService.getSupportedDocFlavors()) {
            System.out.println(flavor.toString());
        }
        Doc doc = new SimpleDoc(Files.readAllBytes(path), DocFlavor.BYTE_ARRAY.AUTOSENSE, new HashDocAttributeSet());
        DocPrintJob printJob = printService.createPrintJob();
        printJob.addPrintJobListener(new JobCompleteMonitor());
        PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
        attrs.add(new Copies(1));
        attrs.add(MediaSizeName.ISO_A4);
        printJob.print(doc, attrs);
        TimeUnit.SECONDS.sleep(30);
    }

    private static class JobCompleteMonitor extends PrintJobAdapter {
        public JobCompleteMonitor() {
            super();
        }

        @Override
        public void printDataTransferCompleted(PrintJobEvent pje) {
            System.out.println("printDataTransferCompleted");
        }

        @Override
        public void printJobFailed(PrintJobEvent pje) {
            System.out.println("printJobFailed");
        }

        @Override
        public void printJobCanceled(PrintJobEvent pje) {
            System.out.println("printJobCanceled");
        }

        @Override
        public void printJobNoMoreEvents(PrintJobEvent pje) {
            System.out.println("printJobNoMoreEvents");
        }

        @Override
        public void printJobRequiresAttention(PrintJobEvent pje) {
            System.out.println("printJobRequiresAttention");
        }

        @Override
        public void printJobCompleted(PrintJobEvent jobEvent) {
            System.out.println("printJobCompleted");
        }
    }
}
