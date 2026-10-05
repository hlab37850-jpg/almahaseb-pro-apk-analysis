package androidx.compose.ui.util;

import android.os.Trace;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTrace_androidKt {
    public static final <T> T trace(String str, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(str, "sectionName");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
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
