package com.github.study.javase;

import javafx.print.Printer;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.Arrays;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/6/24.
 */
public class PrintTest {
    public static void main(String[] args) throws Exception {
        PDDocument document = PDDocument.load(new File("print.pdf"));
        PrintService printService = Arrays.stream(PrintServiceLookup.lookupPrintServices(null, null))
                .filter(it -> it.getName().contains("HP"))
                .findAny().orElseThrow(() -> new RuntimeException("HP打印机不存在"));
        System.out.println(printService.toString());
        System.out.println(Printer.getDefaultPrinter()
                .getName());
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintService(printService);
        printerJob.setPageable(new PDFPageable(document));
        printerJob.print();
    }

    private static void newLine() {
        System.out.println(StringUtils.repeat("#", 100));
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
