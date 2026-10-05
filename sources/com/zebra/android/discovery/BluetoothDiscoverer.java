package com.zebra.android.discovery;

import android.content.Context;
import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.internal.LegacyDiscoveryHandlerConverter;
import com.zebra.sdk.comm.ConnectionException;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothDiscoverer {
    private BluetoothDiscoverer() {
    }

    public static void findPrinters(Context context, DiscoveryHandler discoveryHandler) throws ZebraPrinterConnectionException {
        try {
            com.zebra.sdk.printer.discovery.BluetoothDiscoverer.findPrinters(context, new LegacyDiscoveryHandlerConverter(discoveryHandler));
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }
}
