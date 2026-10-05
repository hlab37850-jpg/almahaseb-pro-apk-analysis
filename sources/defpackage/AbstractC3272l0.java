package defpackage;

import java.util.Arrays;

/* JADX INFO: renamed from: l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3272l0 {
    public AbstractC3436n0[] a;
    public int b;
    public int c;
    public QS d;

    public final AbstractC3436n0 g() {
        AbstractC3436n0 abstractC3436n0H;
        QS qs;
        synchronized (this) {
            try {
                AbstractC3436n0[] abstractC3436n0ArrJ = this.a;
                if (abstractC3436n0ArrJ == null) {
                    abstractC3436n0ArrJ = j(2);
                    this.a = abstractC3436n0ArrJ;
                } else if (this.b >= abstractC3436n0ArrJ.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(abstractC3436n0ArrJ, abstractC3436n0ArrJ.length * 2);
                    AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
                    this.a = (AbstractC3436n0[]) objArrCopyOf;
                    abstractC3436n0ArrJ = (AbstractC3436n0[]) objArrCopyOf;
                }
                int i = this.c;
                do {
                    abstractC3436n0H = abstractC3436n0ArrJ[i];
                    if (abstractC3436n0H == null) {
                        abstractC3436n0H = h();
                        abstractC3436n0ArrJ[i] = abstractC3436n0H;
                    }
                    i++;
                    if (i >= abstractC3436n0ArrJ.length) {
                        i = 0;
                    }
                } while (!abstractC3436n0H.a(this));
                this.c = i;
                this.b++;
                qs = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (qs != null) {
            qs.Z(1);
        }
        return abstractC3436n0H;
    }

    public abstract AbstractC3436n0 h();

    public final CR i() {
        QS qs;
        synchronized (this) {
            qs = this.d;
            if (qs == null) {
                qs = new QS(this.b);
                this.d = qs;
            }
        }
        return qs;
    }

    public abstract AbstractC3436n0[] j(int i);

    public final void k(AbstractC3436n0 abstractC3436n0) {
        QS qs;
        int i;
        InterfaceC0793Of[] interfaceC0793OfArrB;
        synchronized (this) {
            try {
                int i2 = this.b - 1;
                this.b = i2;
                qs = this.d;
                if (i2 == 0) {
                    this.c = 0;
                }
                interfaceC0793OfArrB = abstractC3436n0.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (InterfaceC0793Of interfaceC0793Of : interfaceC0793OfArrB) {
            if (interfaceC0793Of != null) {
                KL.a aVar = KL.a;
                interfaceC0793Of.resumeWith(KL.a(FW.a));
            }
        }
        if (qs != null) {
            qs.Z(-1);
        }
    }

    public final int l() {
        return this.b;
    }

    public final AbstractC3436n0[] m() {
        return this.a;
    }
}
