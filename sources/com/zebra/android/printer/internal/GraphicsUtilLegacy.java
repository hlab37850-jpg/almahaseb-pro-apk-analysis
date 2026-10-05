package com.zebra.android.printer.internal;

import android.graphics.Bitmap;
import com.zebra.android.comm.ZebraPrinterConnectionException;
import com.zebra.android.printer.GraphicsUtil;
import com.zebra.android.printer.ZebraIllegalArgumentException;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.graphics.internal.ZebraImageAndroid;
import com.zebra.sdk.printer.ZebraPrinter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicsUtilLegacy implements GraphicsUtil {
    private ZebraPrinter newTypePrinter;

    public GraphicsUtilLegacy(ZebraPrinter zebraPrinter) {
        this.newTypePrinter = zebraPrinter;
    }

    @Override // com.zebra.android.printer.GraphicsUtil
    public void printImage(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printImage(new ZebraImageAndroid(bitmap), i, i2, i3, i4, z);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.GraphicsUtil
    public void storeImage(String str, Bitmap bitmap, int i, int i2) throws ZebraPrinterConnectionException, ZebraIllegalArgumentException {
        try {
            this.newTypePrinter.storeImage(str, new ZebraImageAndroid(bitmap), i, i2);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        } catch (com.zebra.sdk.device.ZebraIllegalArgumentException e2) {
            throw new ZebraIllegalArgumentException(e2.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.GraphicsUtil
    public void printImage(String str, int i, int i2) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printImage(str, i, i2);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        } catch (IOException e2) {
            throw new ZebraPrinterConnectionException(e2.getLocalizedMessage());
        }
    }

    @Override // com.zebra.android.printer.GraphicsUtil
    public void printImage(String str, int i, int i2, int i3, int i4, boolean z) throws ZebraPrinterConnectionException {
        try {
            this.newTypePrinter.printImage(str, i, i2, i3, i4, z);
        } catch (ConnectionException e) {
            throw new ZebraPrinterConnectionException(e.getLocalizedMessage());
        } catch (IOException e2) {
            throw new ZebraPrinterConnectionException(e2.getLocalizedMessage());
        }
    }
}
