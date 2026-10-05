package com.zebra.sdk.printer.operations.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public interface PrinterOperation<T> extends Serializable {
    T execute();
}
