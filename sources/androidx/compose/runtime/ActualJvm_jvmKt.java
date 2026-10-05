package androidx.compose.runtime;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.NV;

/* JADX INFO: loaded from: classes.dex */
public final class ActualJvm_jvmKt {
    public static final void ensureMutable(Object obj) {
        AbstractC4492zt.h(obj, "it");
    }

    public static final int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    public static final void invokeComposable(Composer composer, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(composer, "composer");
        AbstractC4492zt.h(interfaceC0526Fp, "composable");
        ((InterfaceC0526Fp) NV.d(interfaceC0526Fp, 2)).mo13invoke(composer, 1);
    }

    public static final <T> T invokeComposableForResult(Composer composer, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(composer, "composer");
        AbstractC4492zt.h(interfaceC0526Fp, "composable");
        return (T) ((InterfaceC0526Fp) NV.d(interfaceC0526Fp, 2)).mo13invoke(composer, 1);
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m2626synchronized(Object obj, InterfaceC3588op interfaceC3588op) {
        R r;
        AbstractC4492zt.h(obj, "lock");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        synchronized (obj) {
            try {
                r = (R) interfaceC3588op.invoke();
                AbstractC0703Ks.b(1);
            } finally {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
            }
        }
        return r;
    }
}
