package defpackage;

/* JADX INFO: renamed from: hx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2399hx extends AbstractC1040Xf {
    public abstract AbstractC2399hx G();

    public final String H() {
        AbstractC2399hx abstractC2399hxG;
        AbstractC2399hx abstractC2399hxC = C0368Bj.c();
        if (this == abstractC2399hxC) {
            return "Dispatchers.Main";
        }
        try {
            abstractC2399hxG = abstractC2399hxC.G();
        } catch (UnsupportedOperationException unused) {
            abstractC2399hxG = null;
        }
        if (this == abstractC2399hxG) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // defpackage.AbstractC1040Xf
    public AbstractC1040Xf limitedParallelism(int i) {
        AbstractC0458Ev.a(i);
        return this;
    }
}
