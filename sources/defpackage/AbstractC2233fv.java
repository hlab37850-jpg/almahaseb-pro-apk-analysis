package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: fv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2233fv implements InterfaceC0829Pp, Serializable {
    private final int arity;

    public AbstractC2233fv(int i) {
        this.arity = i;
    }

    @Override // defpackage.InterfaceC0829Pp
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strI = QJ.i(this);
        AbstractC4492zt.g(strI, "renderLambdaToString(...)");
        return strI;
    }
}
