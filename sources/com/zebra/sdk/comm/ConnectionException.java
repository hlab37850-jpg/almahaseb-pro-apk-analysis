package com.zebra.sdk.comm;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectionException extends Exception {
    private static final long serialVersionUID = 4214445194732355173L;

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(String str, Throwable th) {
        super(str, th);
    }

    public ConnectionException(Throwable th) {
        super(th);
    }
}
