package com.zebra.sdk.comm.internal;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraBluetoothSocket implements ZebraSocket {
    private final int MAX_TIMEOUT = 35000;
    private BluetoothSocket bSocket;

    public ZebraBluetoothSocket(BluetoothSocket bluetoothSocket) {
        this.bSocket = bluetoothSocket;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unpairDevice(BluetoothDevice bluetoothDevice) {
        try {
            bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void close() throws IOException {
        this.bSocket.close();
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void connect() {
        Runnable runnable = new Runnable() { // from class: com.zebra.sdk.comm.internal.ZebraBluetoothSocket.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BluetoothDevice remoteDevice = ZebraBluetoothSocket.this.bSocket.getRemoteDevice();
                    ZebraBluetoothSocket.this.close();
                    ZebraBluetoothSocket.this.unpairDevice(remoteDevice);
                } catch (IOException e) {
                    System.out.println("Exception Thrown during runnable: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(runnable, 35000L);
        try {
            this.bSocket.connect();
        } finally {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public InputStream getInputStream() {
        return this.bSocket.getInputStream();
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public OutputStream getOutputStream() {
        return this.bSocket.getOutputStream();
    }

    @Override // com.zebra.sdk.comm.internal.ZebraSocket
    public void setReadTimeout(int i) {
    }
}
