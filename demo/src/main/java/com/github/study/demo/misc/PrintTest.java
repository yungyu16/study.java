package com.github.study.demo.misc;

import org.apache.commons.lang3.StringUtils;

import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

/**
 * @author Yungyu
 * @description Created by Yungyu on 2020/6/24.
 */
public class PrintTest {
    public static void main(String[] args) throws Exception {

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
