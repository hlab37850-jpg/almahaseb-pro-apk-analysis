package com.zebra.sdk.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public class Sleeper {
    static Sleeper sleeper;

    private static Sleeper getInstance() {
        if (sleeper == null) {
            sleeper = new Sleeper();
        }
        return sleeper;
    }

    public static void sleep(long j) {
        getInstance().performSleep(j);
    }

    public void performSleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }
}
