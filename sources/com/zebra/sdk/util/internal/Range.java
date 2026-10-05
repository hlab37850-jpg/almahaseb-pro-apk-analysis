package com.zebra.sdk.util.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class Range implements Serializable {
    private static final long serialVersionUID = 1320173035526099847L;
    private int begin;
    private int end;

    public Range(int i, int i2) {
        this.begin = i;
        this.end = i2;
    }

    public boolean containsInt(int i) {
        return i >= this.begin && i <= this.end;
    }
}
