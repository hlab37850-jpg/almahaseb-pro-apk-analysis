package defpackage;

import com.itextpdf.text.Annotation;
import java.io.Serializable;

/* JADX INFO: renamed from: Zk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1172Zk implements InterfaceC0988Vf, Serializable {
    public static final C1172Zk a = new C1172Zk();

    @Override // defpackage.InterfaceC0988Vf
    public Object fold(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
        return obj;
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf.b get(InterfaceC0988Vf.c cVar) {
        AbstractC4492zt.h(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        AbstractC4492zt.h(cVar, "key");
        return this;
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        return interfaceC0988Vf;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
