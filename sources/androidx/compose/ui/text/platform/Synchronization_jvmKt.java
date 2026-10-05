package androidx.compose.ui.text.platform;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class Synchronization_jvmKt {
    public static final SynchronizedObject createSynchronizedObject() {
        return new SynchronizedObject();
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m4941synchronized(SynchronizedObject synchronizedObject, InterfaceC3588op interfaceC3588op) {
        R r;
        AbstractC4492zt.h(synchronizedObject, "lock");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        synchronized (synchronizedObject) {
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
