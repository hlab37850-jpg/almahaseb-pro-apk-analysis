package defpackage;

import androidx.compose.ui.Modifier;
import com.itextpdf.text.Annotation;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ZB {
    public static boolean a(Modifier.Element element, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return ((Boolean) interfaceC3750qp.invoke(element)).booleanValue();
    }

    public static boolean b(Modifier.Element element, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return ((Boolean) interfaceC3750qp.invoke(element)).booleanValue();
    }

    public static Object c(Modifier.Element element, Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
        return interfaceC0526Fp.mo13invoke(obj, element);
    }

    public static Object d(Modifier.Element element, Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
        return interfaceC0526Fp.mo13invoke(element, obj);
    }
}
