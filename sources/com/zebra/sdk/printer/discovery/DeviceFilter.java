package com.zebra.sdk.printer.discovery;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes3.dex */
public interface DeviceFilter {
    boolean shouldAddPrinter(BluetoothDevice bluetoothDevice);
}
