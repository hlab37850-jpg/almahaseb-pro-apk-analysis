package com.google.api.client.http;

import com.google.api.client.util.Beta;

/* JADX INFO: loaded from: classes2.dex */
@Beta
@Deprecated
public interface BackOffPolicy {
    public static final long STOP = -1;

    long getNextBackOffMillis();

    boolean isBackOffRequired(int i);

    void reset();
}
