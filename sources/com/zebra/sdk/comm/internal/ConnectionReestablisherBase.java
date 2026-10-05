package com.zebra.sdk.comm.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.ConnectionReestablisher;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.util.internal.SGDUtilities;
import com.zebra.sdk.util.internal.Sleeper;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectionReestablisherBase implements ConnectionReestablisher {
    protected long startTime;
    protected long thresholdTime;
    protected Connection zebraPrinterConnection;

    public ConnectionReestablisherBase(Connection connection, long j) {
        this.zebraPrinterConnection = connection;
        this.thresholdTime = j;
    }

    public void timeoutCheck() {
        if (System.currentTimeMillis() <= this.startTime + this.thresholdTime) {
            return;
        }
        throw new TimeoutException("Task timed out waiting for '" + this.zebraPrinterConnection + "' to come back online");
    }

    public String waitForPrinterToComeOnlineViaSgdAndGetFwVer(Connection connection) {
        this.startTime = System.currentTimeMillis();
        while (true) {
            try {
                try {
                    connection.open();
                    String strGET = SGD.GET(SGDUtilities.APPL_NAME, connection);
                    if (strGET == null || strGET.trim().isEmpty()) {
                        throw new ConnectionException("Printer is not responding");
                    }
                    return strGET;
                } catch (ConnectionException unused) {
                }
            } catch (ConnectionException unused2) {
                connection.close();
                Sleeper.sleep(2500L);
                timeoutCheck();
            }
            Sleeper.sleep(2500L);
            timeoutCheck();
        }
    }
}
