package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: li, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3334li {
    public static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    public static final InterfaceC3252ki b(AbstractC2171f7 abstractC2171f7) {
        return (InterfaceC3252ki) abstractC2171f7.getClass().getAnnotation(InterfaceC3252ki.class);
    }

    public static final int c(AbstractC2171f7 abstractC2171f7) {
        try {
            Field declaredField = abstractC2171f7.getClass().getDeclaredField(HTML.Tag.LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC2171f7);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(AbstractC2171f7 abstractC2171f7) {
        String strC;
        AbstractC4492zt.h(abstractC2171f7, "<this>");
        InterfaceC3252ki interfaceC3252kiB = b(abstractC2171f7);
        if (interfaceC3252kiB == null) {
            return null;
        }
        a(1, interfaceC3252kiB.v());
        int iC = c(abstractC2171f7);
        int i = iC < 0 ? -1 : interfaceC3252kiB.l()[iC];
        String strB = C2016dC.a.b(abstractC2171f7);
        if (strB == null) {
            strC = interfaceC3252kiB.c();
        } else {
            strC = strB + '/' + interfaceC3252kiB.c();
        }
        return new StackTraceElement(strC, interfaceC3252kiB.m(), interfaceC3252kiB.f(), i);
    }
}
