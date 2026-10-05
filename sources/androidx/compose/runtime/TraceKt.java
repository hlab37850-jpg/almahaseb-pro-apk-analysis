package androidx.compose.runtime;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(String str, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(str, "sectionName");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        Object objBeginSection = Trace.INSTANCE.beginSection(str);
        try {
            T t = (T) interfaceC3588op.invoke();
            AbstractC0703Ks.b(1);
            return t;
        } finally {
            AbstractC0703Ks.b(1);
            Trace.INSTANCE.endSection(objBeginSection);
            AbstractC0703Ks.a(1);
        }
    }
}
