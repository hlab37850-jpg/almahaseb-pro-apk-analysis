package defpackage;

/* JADX INFO: renamed from: kS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3228kS {
    public static void a(Appendable appendable, Object obj, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(appendable, "<this>");
        if (interfaceC3750qp != null) {
            appendable.append((CharSequence) interfaceC3750qp.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }
}
