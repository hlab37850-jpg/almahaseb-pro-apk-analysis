package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class DecoyKt {
    @ComposeCompilerApi
    public static final Void illegalDecoyCallException(String str) {
        AbstractC4492zt.h(str, "fName");
        throw new IllegalStateException("Function " + str + " should have been replaced by compiler.");
    }
}
