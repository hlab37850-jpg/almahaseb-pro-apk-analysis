package com.zebra.sdk.util.internal;

import com.itextpdf.text.xml.xmp.XmpWriter;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.comm.UsbConnection;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.UsbDiscoverer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes3.dex */
public class ReflectionUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static List<Class<?>> findClasses(File file, String str) {
        ArrayList arrayList = new ArrayList();
        if (!file.exists()) {
            return arrayList;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                arrayList.addAll(findClasses(file2, str + "." + file2.getName()));
            } else if (file2.getName().endsWith(".class")) {
                arrayList.add(Class.forName(str + '.' + file2.getName().substring(0, file2.getName().length() - 6)));
            }
        }
        return arrayList;
    }

    private static Class<?>[] getClasses(String str) throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String strReplace = str.replace('.', '/');
        URL resource = contextClassLoader.getResource(strReplace);
        ArrayList arrayList = new ArrayList();
        if (resource.getProtocol().equals("jar")) {
            String strDecode = URLDecoder.decode(resource.getFile(), XmpWriter.UTF8);
            JarFile jarFile = new JarFile(strDecode.substring(5, strDecode.indexOf("!")));
            Enumeration<JarEntry> enumerationEntries = jarFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                String name = enumerationEntries.nextElement().getName();
                if (name.startsWith(strReplace) && name.length() > strReplace.length() + 5 && name.endsWith(".class")) {
                    String strReplace2 = name.replace('/', '.');
                    arrayList.add(Class.forName(strReplace2.substring(0, strReplace2.length() - 6)));
                }
            }
            jarFile.close();
        } else {
            Enumeration<URL> resources = contextClassLoader.getResources(strReplace);
            ArrayList arrayList2 = new ArrayList();
            while (resources.hasMoreElements()) {
                arrayList2.add(new File(resources.nextElement().getFile()));
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.addAll(findClasses((File) it.next(), str));
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public static Set<Class<?>> getClassesInPackage(String str) {
        return new HashSet(Arrays.asList(getClasses(str)));
    }

    public static Set<Class<?>> getClassesInPackageExtending(String str, Class<?> cls) {
        Set<Class<?>> classesInPackage = getClassesInPackage(str);
        Iterator<Class<?>> it = classesInPackage.iterator();
        while (it.hasNext()) {
            Class<?> next = it.next();
            if (Modifier.isAbstract(next.getModifiers()) || !cls.isAssignableFrom(next)) {
                it.remove();
            }
        }
        return classesInPackage;
    }

    public static String getSymbolicNameFromSerialNumber(String str) {
        try {
            for (DiscoveredPrinter discoveredPrinter : (DiscoveredPrinter[]) UsbDiscoverer.class.getDeclaredMethod("getZebraUsbPrinters", new Class[0]).invoke(null, new Object[0])) {
                Map<String, String> discoveryDataMap = discoveredPrinter.getDiscoveryDataMap();
                if (str.equalsIgnoreCase(discoveryDataMap.get("SERIAL_NUMBER"))) {
                    return discoveryDataMap.get("ADDRESS");
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map<String, String> invokeUsbConnection_getConnectionAttributes(Connection connection) throws IOException {
        try {
            int i = UsbConnection.a;
            Method declaredMethod = UsbConnection.class.getDeclaredMethod("getConnectionAttributes", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(connection, new Object[0]);
            if (objInvoke instanceof Map) {
                return (Map) objInvoke;
            }
            return null;
        } catch (Exception e) {
            throw new IOException(e.getCause().getLocalizedMessage());
        }
    }

    public static ZebraImageI invokeZebraImageFactory_getImage(InputStream inputStream) throws IOException {
        try {
            return (ZebraImageI) Thread.currentThread().getContextClassLoader().loadClass("com.zebra.sdk.graphics.ZebraImageFactory").getMethod("getImage", InputStream.class).invoke(null, inputStream);
        } catch (Exception e) {
            throw new IOException(e.getCause().getLocalizedMessage());
        }
    }

    public static boolean isDriverConnection(Connection connection) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass("com.zebra.sdk.comm.DriverPrinterConnection").isInstance(connection);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isUsbConnection(Connection connection) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass("com.zebra.sdk.comm.UsbConnection").isInstance(connection);
        } catch (Exception unused) {
            return false;
        }
    }

    public static ConnectionReestablisher loadTcpCardConnectionReestablisher(Connection connection, long j) {
        try {
            Constructor<?> declaredConstructor = Class.forName("com.zebra.sdk.common.card.comm.internal.TcpCardConnectionReestablisher").getDeclaredConstructor(Connection.class, Long.class);
            declaredConstructor.setAccessible(true);
            return (ConnectionReestablisher) declaredConstructor.newInstance(connection, Long.valueOf(j));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ConnectionReestablisher loadUsbCardConnectionReestablisher(Connection connection, long j) {
        try {
            Constructor<?> declaredConstructor = Class.forName("com.zebra.sdk.common.card.comm.internal.UsbCardConnectionReestablisher").getDeclaredConstructor(Connection.class, Long.class);
            declaredConstructor.setAccessible(true);
            return (ConnectionReestablisher) declaredConstructor.newInstance(connection, Long.valueOf(j));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ZebraImageI invokeZebraImageFactory_getImage(String str) throws IOException {
        try {
            return (ZebraImageI) Thread.currentThread().getContextClassLoader().loadClass("com.zebra.sdk.graphics.ZebraImageFactory").getMethod("getImage", String.class).invoke(null, str);
        } catch (Exception e) {
            throw new IOException(e.getCause().getLocalizedMessage());
        }
    }
}
