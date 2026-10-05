package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: aj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1253aj implements InterfaceC4362yO {
    public final CharSequence a;
    public final int b;
    public final int c;
    public final InterfaceC0526Fp d;

    /* JADX INFO: renamed from: aj$a */
    public static final class a implements Iterator, InterfaceC0756Mu {
        public int a = -1;
        public int b;
        public int c;
        public C1001Vs d;
        public int e;

        public a() {
            int iL = AbstractC3871sJ.l(C1253aj.this.b, 0, C1253aj.this.a.length());
            this.b = iL;
            this.c = iL;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:17:0x0098  */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        private final void a() {
            C2020dG c2020dG;
            if (this.c < 0) {
                this.a = 0;
                this.d = null;
                return;
            }
            if (C1253aj.this.c > 0) {
                int i = this.e + 1;
                this.e = i;
                if (i >= C1253aj.this.c) {
                    this.d = new C1001Vs(this.b, AbstractC3961tS.L(C1253aj.this.a));
                    this.c = -1;
                } else if (this.c > C1253aj.this.a.length() && (c2020dG = (C2020dG) C1253aj.this.d.mo13invoke(C1253aj.this.a, Integer.valueOf(this.c))) != null) {
                    int iIntValue = ((Number) c2020dG.a()).intValue();
                    int iIntValue2 = ((Number) c2020dG.b()).intValue();
                    this.d = AbstractC3871sJ.s(this.b, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.b = i2;
                    this.c = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.d = new C1001Vs(this.b, AbstractC3961tS.L(C1253aj.this.a));
                    this.c = -1;
                }
            } else if (this.c > C1253aj.this.a.length()) {
                this.d = new C1001Vs(this.b, AbstractC3961tS.L(C1253aj.this.a));
                this.c = -1;
            } else {
                int iIntValue3 = ((Number) c2020dG.a()).intValue();
                int iIntValue4 = ((Number) c2020dG.b()).intValue();
                this.d = AbstractC3871sJ.s(this.b, iIntValue3);
                int i3 = iIntValue3 + iIntValue4;
                this.b = i3;
                this.c = i3 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.a = 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1001Vs next() {
            if (this.a == -1) {
                a();
            }
            if (this.a == 0) {
                throw new NoSuchElementException();
            }
            C1001Vs c1001Vs = this.d;
            AbstractC4492zt.f(c1001Vs, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.d = null;
            this.a = -1;
            return c1001Vs;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C1253aj(CharSequence charSequence, int i, int i2, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(charSequence, HTML.Tag.INPUT);
        AbstractC4492zt.h(interfaceC0526Fp, "getNextMatch");
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        return new a();
    }
}
