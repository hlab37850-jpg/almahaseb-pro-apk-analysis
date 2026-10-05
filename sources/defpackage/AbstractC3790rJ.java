package defpackage;

/* JADX INFO: renamed from: rJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3790rJ {
    public static final void a(boolean z, Number number) {
        AbstractC4492zt.h(number, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }

    public static InterfaceC0789Ob b(float f, float f2) {
        return new C0763Nb(f, f2);
    }
}
