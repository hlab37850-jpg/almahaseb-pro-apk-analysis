package com.zebra.sdk.printer.internal;

import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface GraphicsConvertionUtil {
    void sendImageToStream(String str, ZebraImageInternal zebraImageInternal, int i, int i2, OutputStream outputStream);
}
