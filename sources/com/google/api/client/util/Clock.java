package com.google.api.client.util;

/* JADX INFO: loaded from: classes2.dex */
public interface Clock {
    public static final Clock SYSTEM = new a();

    public static class a implements Clock {
        @Override // com.google.api.client.util.Clock
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    long currentTimeMillis();
}
