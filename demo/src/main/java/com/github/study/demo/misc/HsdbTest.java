package com.github.study.demo.misc;

import sun.jvmstat.monitor.HostIdentifier;
import sun.jvmstat.monitor.MonitoredHost;

import java.util.Set;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class HsdbTest {
    public static void main(String[] args) throws Exception {
        MonitoredHost monitoredHost = MonitoredHost.getMonitoredHost(new HostIdentifier((String) null));
        Set<Integer> x = monitoredHost.activeVms();
    }
}
