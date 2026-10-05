package androidx.compose.ui.platform;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.C2359hS;
import defpackage.InterfaceC3588op;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class JvmActuals_jvmKt {
    public static final Object nativeClass(Object obj) {
        AbstractC4492zt.h(obj, "<this>");
        return obj.getClass();
    }

    public static final String simpleIdentityToString(Object obj, String str) {
        AbstractC4492zt.h(obj, "obj");
        if (str == null) {
            str = obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('@');
        C2359hS c2359hS = C2359hS.a;
        String str2 = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
        AbstractC4492zt.g(str2, "format(format, *args)");
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m4497synchronized(Object obj, InterfaceC3588op interfaceC3588op) {
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
