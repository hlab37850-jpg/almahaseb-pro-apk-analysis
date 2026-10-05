package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.util.internal.Sleeper;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrinterConnectionInputStreamBase extends InputStream {
    private long lastDataReceivedTime;
    private long maxTimeToWaitForMoreData;
    private Connection printerConnection;
    private StringBuffer terminationQueue;
    private boolean endStreamOnNextRead = false;
    protected String terminator = null;

    public PrinterConnectionInputStreamBase(Connection connection, long j) {
        this.lastDataReceivedTime = 0L;
        this.terminationQueue = null;
        this.printerConnection = connection;
        this.maxTimeToWaitForMoreData = j;
        this.terminationQueue = new StringBuffer();
        this.lastDataReceivedTime = System.currentTimeMillis();
    }

    private void handleTerminationOfStream(char c) {
        if (this.terminator != null) {
            if (this.terminationQueue.length() >= this.terminator.length()) {
                this.terminationQueue.deleteCharAt(0);
            }
            this.terminationQueue.append(c);
            if (this.terminator.equals(this.terminationQueue.toString())) {
                this.endStreamOnNextRead = true;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i;
        long jCurrentTimeMillis;
        if (this.endStreamOnNextRead) {
            return -1;
        }
        do {
            try {
                i = this.printerConnection.readChar();
                jCurrentTimeMillis = System.currentTimeMillis() - this.lastDataReceivedTime;
                if (i != -1) {
                    this.lastDataReceivedTime = System.currentTimeMillis();
                    setTerminatorBasedOnData(i);
                    handleTerminationOfStream((char) i);
                } else {
                    Sleeper.sleep(50L);
                }
                if (i != -1) {
                    break;
                }
            } catch (ConnectionException e) {
                throw new IOException(e.getLocalizedMessage());
            }
        } while (jCurrentTimeMillis < this.maxTimeToWaitForMoreData);
        return i;
    }

    public abstract void setTerminatorBasedOnData(int i);
}
