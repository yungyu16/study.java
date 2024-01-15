package com.github.study.demo.misc;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import org.springframework.util.StopWatch;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * CreatedDate: 2020/8/19
 * Author: songjialin
 */
public class SocketTest {
    public static void main(String[] args) throws UnknownHostException {
        StopWatch inet = new StopWatch("inet");
        inet.start("addressByName");
        InetAddress x = addressByName("www.50lion.com");
        inet.stop();
        inet.start("allAddressesByName");
        InetAddress[] y = allAddressesByName("www.baidu.com");
        inet.stop();
        inet.start("getCanonicalHostName");
        System.out.println(x.getCanonicalHostName());
        inet.stop();
        inet.start("getHostAddress");
        System.out.println(x.getHostAddress());
        inet.stop();
        inet.start("getHostName");
        System.out.println(x.getHostName());
        inet.stop();
        inet.start("getAddress");
        System.out.println(Arrays.toString(x.getAddress()));
        inet.stop();
        System.out.println(Arrays.toString(y));
        System.out.println(inet.prettyPrint());
    }

    public static InetAddress addressByName(final String hostname) throws UnknownHostException {
        try {
            return AccessController.doPrivileged(new PrivilegedExceptionAction<InetAddress>() {
                @Override
                public InetAddress run() throws UnknownHostException {
                    return InetAddress.getByName(hostname);
                }
            });
        } catch (PrivilegedActionException e) {
            throw (UnknownHostException) e.getCause();
        }
    }

    public static InetAddress[] allAddressesByName(final String hostname) throws UnknownHostException {
        try {
            return AccessController.doPrivileged(new PrivilegedExceptionAction<InetAddress[]>() {
                @Override
                public InetAddress[] run() throws UnknownHostException {
                    return InetAddress.getAllByName(hostname);
                }
            });
        } catch (PrivilegedActionException e) {
            throw (UnknownHostException) e.getCause();
        }
    }

    public static InetSocketAddress socketAddress(final String hostname, final int port) {
        return AccessController.doPrivileged(new PrivilegedAction<InetSocketAddress>() {
            @Override
            public InetSocketAddress run() {
                return new InetSocketAddress(hostname, port);
            }
        });
    }

    public static Enumeration<InetAddress> addressesFromNetworkInterface(final NetworkInterface intf) {
        Enumeration<InetAddress> addresses =
                AccessController.doPrivileged(new PrivilegedAction<Enumeration<InetAddress>>() {
                    @Override
                    public Enumeration<InetAddress> run() {
                        return intf.getInetAddresses();
                    }
                });
        // Android seems to sometimes return null even if this is not a valid return value by the api docs.
        // Just return an empty Enumeration in this case.
        // See https://github.com/netty/netty/issues/10045
        if (addresses == null) {
            return null;
        }
        return addresses;
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static InetAddress loopbackAddress() {
        return AccessController.doPrivileged(new PrivilegedAction<InetAddress>() {
            @Override
            public InetAddress run() {
                if (PlatformDependent.javaVersion() >= 7) {
                    return InetAddress.getLoopbackAddress();
                }
                try {
                    return InetAddress.getByName(null);
                } catch (UnknownHostException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
    }

    public static byte[] hardwareAddressFromNetworkInterface(final NetworkInterface intf) throws SocketException {
        try {
            return AccessController.doPrivileged(new PrivilegedExceptionAction<byte[]>() {
                @Override
                public byte[] run() throws SocketException {
                    return intf.getHardwareAddress();
                }
            });
        } catch (PrivilegedActionException e) {
            throw (SocketException) e.getCause();
        }
    }
}
