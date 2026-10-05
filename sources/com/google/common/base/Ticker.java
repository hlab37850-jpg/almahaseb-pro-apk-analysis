package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import defpackage.AG;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new a();

    public class a extends Ticker {
        @Override // com.google.common.base.Ticker
        public long read() {
            return AG.i();
        }
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }

    public abstract long read();
}
