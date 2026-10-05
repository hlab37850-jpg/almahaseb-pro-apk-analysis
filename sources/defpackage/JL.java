package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JL extends IL implements InterfaceC0829Pp {
    private final int arity;

    public JL(int i, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
        this.arity = i;
    }

    @Override // defpackage.InterfaceC0829Pp
    public int getArity() {
        return this.arity;
    }

    @Override // defpackage.AbstractC2171f7
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strH = QJ.h(this);
        AbstractC4492zt.g(strH, "renderLambdaToString(...)");
        return strH;
    }
}
