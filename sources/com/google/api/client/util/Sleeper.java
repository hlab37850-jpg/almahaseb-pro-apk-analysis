package com.google.api.client.util;

/* JADX INFO: loaded from: classes2.dex */
public interface Sleeper {
    public static final Sleeper DEFAULT = new a();

    public static class a implements Sleeper {
        @Override // com.google.api.client.util.Sleeper
        public void sleep(long j) throws InterruptedException {
            Thread.sleep(j);
        }
    }

    void sleep(long j);
}
