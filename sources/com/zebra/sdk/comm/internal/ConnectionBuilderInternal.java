package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionBuilder;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.internal.VerbosePrinter;
import com.zebra.sdk.util.internal.Sleeper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectionBuilderInternal {
    private static final String MULTICHANNEL_BLUETOOTH_CONNECTION = "com.zebra.sdk.comm.MultichannelBluetoothConnection";
    public static Set<Class<?>> implementingClasses = null;
    private static boolean isConnBuilderVerbose = false;

    static {
        try {
            reflectivelyLoadImplementingClasses();
        } catch (Exception unused) {
        }
    }

    public static void addConnectionType(Class<? extends Connection> cls) {
        if (implementingClasses == null) {
            implementingClasses = new LinkedHashSet();
        }
        implementingClasses.add(cls);
    }

    public static Connection build(String str) throws ConnectionException {
        if (implementingClasses == null) {
            throw new RuntimeException("Builder not correctly implemented");
        }
        VerbosePrinter verbosePrinter = new VerbosePrinter(isConnBuilderVerbose);
        verbosePrinter.println("Building connection for the string \"" + str + "\"");
        ConnectionInfo connectionInfo = new ConnectionInfo(str);
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls : implementingClasses) {
            try {
                arrayList.add(reflectivelyInstatiateConnection(connectionInfo, cls));
            } catch (NoSuchMethodException unused) {
                throw new ConnectionException(cls.getName() + " does not implement a constructor that takes a ConnectionInfo object");
            } catch (InvocationTargetException unused2) {
            } catch (Exception e) {
                throw new ConnectionException(e.getMessage());
            }
        }
        if (arrayList.isEmpty()) {
            verbosePrinter.println("Could not determine connection type of the value \"" + str + "\"");
            throw new ConnectionException("Invalid connection type");
        }
        if (arrayList.size() == 1) {
            verbosePrinter.println("Determined connection string \"" + str + "\" is of type " + ((Connection) arrayList.get(0)).getClass().getSimpleName());
            return (Connection) arrayList.get(0);
        }
        Connection connectionDetermineConnectionToTry = determineConnectionToTry(arrayList, verbosePrinter);
        if (connectionDetermineConnectionToTry != null) {
            verbosePrinter.println("Success!" + System.getProperty("line.separator"));
            return connectionDetermineConnectionToTry;
        }
        throw new ConnectionException("Could not open connection string \"" + str + "\"");
    }

    private static String createClassesToTestMessage(List<Connection> list) {
        String str = "The following are possible connection types:" + System.getProperty("line.separator");
        Iterator<Connection> it = list.iterator();
        while (it.hasNext()) {
            str = str + "   " + it.next().getClass().getSimpleName() + System.getProperty("line.separator");
        }
        return str;
    }

    private static Connection determineConnectionToTry(List<Connection> list, VerbosePrinter verbosePrinter) {
        verbosePrinter.println(createClassesToTestMessage(list));
        for (Connection connection : list) {
            try {
                verbosePrinter.print("Trying " + connection.getClass().getSimpleName() + "... ");
                connection.open();
                connection.close();
                if (!connection.getClass().getName().equals(MULTICHANNEL_BLUETOOTH_CONNECTION)) {
                    return connection;
                }
                Sleeper.sleep(1000L);
                return connection;
            } catch (ConnectionException e) {
                verbosePrinter.println("Failed - " + e.getLocalizedMessage());
            }
        }
        return null;
    }

    public static boolean isConnBuilderVerbose() {
        return isConnBuilderVerbose;
    }

    private static Connection reflectivelyInstatiateConnection(ConnectionInfo connectionInfo, Class<?> cls) throws NoSuchMethodException {
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(ConnectionInfo.class);
        declaredConstructor.setAccessible(true);
        return (Connection) declaredConstructor.newInstance(connectionInfo);
    }

    private static void reflectivelyLoadImplementingClasses() {
        try {
            Method declaredMethod = ConnectionBuilder.class.getDeclaredMethod("initializeClasses", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void removeConnectionType(Class<? extends Connection> cls) {
        implementingClasses.remove(cls);
    }

    public static void setConnBuilderVerbosity(boolean z) {
        isConnBuilderVerbose = z;
    }
}
