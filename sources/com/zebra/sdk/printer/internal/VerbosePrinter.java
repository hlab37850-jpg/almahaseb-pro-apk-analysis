package com.zebra.sdk.printer.internal;

/* JADX INFO: loaded from: classes3.dex */
public class VerbosePrinter {
    private boolean shouldPrint;

    public VerbosePrinter(boolean z) {
        this.shouldPrint = z;
    }

    public void print(String str) {
        if (this.shouldPrint) {
            System.out.print(str);
        }
    }

    public void println(String str) {
        if (this.shouldPrint) {
            System.out.println(str);
        }
    }
}
