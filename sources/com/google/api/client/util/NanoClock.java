package com.google.api.client.util;

/* JADX INFO: loaded from: classes2.dex */
public interface NanoClock {
    public static final NanoClock SYSTEM = new a();

    public static class a implements NanoClock {
        @Override // com.google.api.client.util.NanoClock
        public long nanoTime() {
            return System.nanoTime();
        }
    }

    long nanoTime();
}
