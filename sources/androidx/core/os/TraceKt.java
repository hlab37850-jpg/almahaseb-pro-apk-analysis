package androidx.core.os;

import android.os.Trace;
import defpackage.AbstractC0703Ks;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class TraceKt {
    public static final <T> T trace(String str, InterfaceC3588op interfaceC3588op) {
        Trace.beginSection(str);
        try {
            return (T) interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            Trace.endSection();
            AbstractC0703Ks.a(1);
        }
    }
}
