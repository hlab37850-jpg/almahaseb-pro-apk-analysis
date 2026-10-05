package com.zebra.sdk.comm;

import com.zebra.sdk.comm.internal.ZebraConnector;
import com.zebra.sdk.comm.internal.ZebraSocket;
import com.zebra.sdk.util.internal.Sleeper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConnectionA implements ConnectionWithWriteLogging {
    protected static final int DEFAULT_MAX_TIMEOUT_FOR_READ = 5000;
    protected static final int DEFAULT_TIME_TO_WAIT_FOR_MORE_DATA = 500;
    private static int SIZE_OF_STREAM_BUFFERS = 16384;
    protected ZebraSocket commLink;
    protected InputStream inputStream;
    protected OutputStream myWriteLogStream;
    protected OutputStream outputStream;
    protected ZebraConnector zebraConnector;
    private int MAX_DATA_TO_WRITE_TO_STREAM_AT_ONCE = 1024;
    protected int maxTimeoutForRead = 0;
    protected int timeToWaitForMoreData = 0;
    protected boolean isConnected = false;

    private boolean shouldWaitForData(String str, String str2) {
        if (str2 == null) {
            return true;
        }
        return !str.contains(str2);
    }

    private void throwAsConnectionException(String str, Exception exc) throws ConnectionException {
        if (str == null) {
            str = "";
        }
        throw new ConnectionException(str + (exc.getMessage() != null ? exc.getMessage() : exc.getClass().getSimpleName()), exc);
    }

    @Override // com.zebra.sdk.comm.ConnectionWithWriteLogging
    public void addWriteLogStream(OutputStream outputStream) {
        this.myWriteLogStream = outputStream;
    }

    @Override // com.zebra.sdk.comm.Connection
    public int bytesAvailable() throws ConnectionException {
        try {
            return this.inputStream.available();
        } catch (IOException e) {
            throwAsConnectionException("Error reading from connection: ", e);
            return -1;
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public void close() {
        if (this.isConnected) {
            this.isConnected = false;
            try {
                this.outputStream.close();
                this.inputStream.close();
                this.commLink.close();
            } catch (IOException e) {
                throwAsConnectionException("Could not disconnect from device: ", e);
            }
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public ConnectionReestablisher getConnectionReestablisher(long j) throws ConnectionException {
        throw new ConnectionException("Automatic reconnection is not supported for this connection type");
    }

    public String getManufacturer() {
        return "";
    }

    public int getMaxDataToWrite() {
        return this.MAX_DATA_TO_WRITE_TO_STREAM_AT_ONCE;
    }

    @Override // com.zebra.sdk.comm.Connection
    public int getMaxTimeoutForRead() {
        return this.maxTimeoutForRead;
    }

    @Override // com.zebra.sdk.comm.Connection
    public int getTimeToWaitForMoreData() {
        return this.timeToWaitForMoreData;
    }

    @Override // com.zebra.sdk.comm.Connection
    public boolean isConnected() {
        return this.isConnected;
    }

    @Override // com.zebra.sdk.comm.Connection
    public void open() throws ConnectionException {
        if (this.isConnected) {
            return;
        }
        try {
            ZebraSocket zebraSocketOpen = this.zebraConnector.open();
            this.commLink = zebraSocketOpen;
            this.outputStream = zebraSocketOpen.getOutputStream();
            this.inputStream = this.commLink.getInputStream();
            this.isConnected = true;
        } catch (Exception e) {
            this.isConnected = false;
            throwAsConnectionException("Could not connect to device: ", e);
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public void read(OutputStream outputStream) throws ConnectionException {
        while (bytesAvailable() > 0) {
            try {
                outputStream.write(read(16384));
            } catch (IOException e) {
                throwAsConnectionException("Error reading from connection: ", e);
            }
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public int readChar() throws ConnectionException {
        try {
            return this.inputStream.read();
        } catch (IOException e) {
            throwAsConnectionException("Error reading from connection: ", e);
            return -1;
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public void sendAndWaitForResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, String str) throws ConnectionException {
        if (!isConnected()) {
            throw new ConnectionException("No Printer Connection");
        }
        write(inputStream);
        waitForData(i);
        ByteArrayOutputStream byteArrayOutputStream = str != null ? new ByteArrayOutputStream() : null;
        while (bytesAvailable() > 0) {
            byte[] bArr = read(SIZE_OF_STREAM_BUFFERS);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    throwAsConnectionException(e.getMessage(), e);
                }
            }
            outputStream.write(bArr);
            if (str == null || shouldWaitForData(byteArrayOutputStream.toString(), str)) {
                waitForData(i2);
            }
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public void sendAndWaitForValidResponse(OutputStream outputStream, InputStream inputStream, int i, int i2, ResponseValidator responseValidator) throws ConnectionException {
        if (!isConnected()) {
            throw new ConnectionException("No Printer Connection");
        }
        write(inputStream);
        waitForData(i);
        ByteArrayOutputStream byteArrayOutputStream = responseValidator != null ? new ByteArrayOutputStream() : null;
        while (bytesAvailable() > 0) {
            byte[] bArr = read(SIZE_OF_STREAM_BUFFERS);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (IOException e) {
                    throwAsConnectionException(e.getMessage(), e);
                }
            }
            outputStream.write(bArr);
            if (responseValidator == null || !responseValidator.isResponseComplete(byteArrayOutputStream.toByteArray())) {
                waitForData(i2);
            }
        }
    }

    public void setMaxDataToWrite(int i) {
        this.MAX_DATA_TO_WRITE_TO_STREAM_AT_ONCE = i;
    }

    @Override // com.zebra.sdk.comm.Connection
    public void setMaxTimeoutForRead(int i) {
        this.maxTimeoutForRead = i;
    }

    public void setReadTimeout(int i) throws ConnectionException {
        ZebraSocket zebraSocket = this.commLink;
        if (zebraSocket != null) {
            try {
                zebraSocket.setReadTimeout(i);
            } catch (IOException e) {
                throwAsConnectionException(e.getMessage(), e);
            }
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public void setTimeToWaitForMoreData(int i) {
        this.timeToWaitForMoreData = i;
    }

    @Override // com.zebra.sdk.comm.Connection
    public void waitForData(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) i);
        while (bytesAvailable() == 0 && System.currentTimeMillis() < jCurrentTimeMillis) {
            Sleeper.sleep(50L);
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(InputStream inputStream) throws ConnectionException {
        byte[] bArr = new byte[16384];
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i <= -1) {
                    return;
                } else {
                    write(bArr, 0, i);
                }
            } catch (IOException e) {
                throwAsConnectionException("Error writing to connection: ", e);
                return;
            }
        }
    }

    public void writeToLogStream(byte[] bArr, int i, int i2) throws LogStreamException {
        OutputStream outputStream = this.myWriteLogStream;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new LogStreamException("Error writing to log: " + e.getLocalizedMessage());
            }
        }
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] read() {
        return read(-1);
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] sendAndWaitForResponse(byte[] bArr, int i, int i2, String str) throws ConnectionException {
        if (!isConnected()) {
            throw new ConnectionException("No Printer Connection");
        }
        write(bArr);
        waitForData(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (bytesAvailable() > 0) {
            try {
                byteArrayOutputStream.write(read());
            } catch (IOException e) {
                throwAsConnectionException(e.getMessage(), e);
            }
            if (shouldWaitForData(byteArrayOutputStream.toString(), str)) {
                waitForData(i2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.zebra.sdk.comm.Connection
    public byte[] sendAndWaitForValidResponse(byte[] bArr, int i, int i2, ResponseValidator responseValidator) throws ConnectionException {
        if (!isConnected()) {
            throw new ConnectionException("No Printer Connection");
        }
        write(bArr);
        waitForData(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (bytesAvailable() > 0) {
            try {
                byteArrayOutputStream.write(read());
            } catch (IOException e) {
                throwAsConnectionException(e.getMessage(), e);
            }
            if (!responseValidator.isResponseComplete(byteArrayOutputStream.toByteArray())) {
                waitForData(i2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public byte[] read(int i) throws ConnectionException {
        int iBytesAvailable = bytesAvailable();
        if (iBytesAvailable <= 0) {
            return null;
        }
        if (i >= 0) {
            iBytesAvailable = Math.min(i, iBytesAvailable);
        }
        byte[] bArr = new byte[iBytesAvailable];
        try {
            this.inputStream.read(bArr);
        } catch (IOException e) {
            throwAsConnectionException("Error reading from connection: ", e);
        }
        return bArr;
    }

    @Override // com.zebra.sdk.comm.Connection
    public void write(byte[] bArr, int i, int i2) {
        if (this.outputStream == null || !isConnected()) {
            throw new ConnectionException("The connection is not open");
        }
        while (i2 > 0) {
            try {
                int i3 = this.MAX_DATA_TO_WRITE_TO_STREAM_AT_ONCE;
                if (i2 <= i3) {
                    i3 = i2;
                }
                this.outputStream.write(bArr, i, i3);
                writeToLogStream(bArr, i, i3);
                this.outputStream.flush();
                Sleeper.sleep(10L);
                i += i3;
                i2 -= i3;
            } catch (IOException e) {
                throwAsConnectionException("Error writing to connection: ", e);
                return;
            }
        }
    }

    public byte[] read(int i, boolean z) throws ConnectionException {
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        do {
            try {
                int i5 = this.inputStream.read(bArr, i3, i2);
                if (i5 > 0) {
                    i4 += i5;
                    i3 += i5;
                    i2 -= i5;
                }
                if (z && i4 > 0) {
                    break;
                }
            } catch (IOException e) {
                throwAsConnectionException("Error reading from connection: ", e);
            }
        } while (i4 < i);
        if (i4 <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        return bArr2;
    }
}
