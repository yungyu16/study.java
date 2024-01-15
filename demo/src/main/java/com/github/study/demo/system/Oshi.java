package com.github.study.demo.system;

import com.alibaba.fastjson.JSON;
import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.ComputerSystem;
import oshi.hardware.Firmware;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.io.IOException;

/**
 * <a>https://atovk.github.io/post/java/oshi_system_and_hardware_information/</a>
 * CreatedDate: 2020/11/13
 * Author: songjialin
 */
public class Oshi {
    public static void main(String[] args) throws IOException {
        // 初始化系统信息对象
        SystemInfo systemInfo = new SystemInfo();
        // 获取硬件信息
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        // 获取操作系统进程相关信息
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        ComputerSystem computerSystem = hardware.getComputerSystem();
        System.out.println("hardware:" + JSON.toJSONString(hardware));
        System.out.println("computerSystem:" + JSON.toJSONString(computerSystem));
        Baseboard baseboard = computerSystem.getBaseboard();
        System.out.println("baseboard:" + JSON.toJSONString(baseboard));
        Firmware firmware = computerSystem.getFirmware();
        System.out.println("firmware:" + JSON.toJSONString(firmware));
        System.out.println("getProcessCount:" + operatingSystem.getProcessCount());
        System.out.println("getProcessId:" + operatingSystem.getProcessId());
        System.out.println("getCpuTemperature:" + hardware.getSensors().getCpuTemperature());
        System.out.println("getCpuVoltage:" + hardware.getSensors().getCpuVoltage());
        hardware.getNetworkIFs().stream().forEach(it -> System.out.println(JSON.toJSONString(it)));
        System.out.println(hardware.getPowerSources());
        System.in.read();

    }
}
