package defpackage;

import com.itextpdf.tool.xml.html.HTML;

/* JADX INFO: renamed from: ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2152ew extends FV {
    public boolean c;
    public int[] d;

    public C2152ew(EV ev) {
        super(1819239265);
        int iU = ((C2015dB) ev.h("maxp")).u();
        this.c = ((C3671pr) ev.h(HTML.Tag.HEAD)).m() == 1;
        this.d = new int[iU + 1];
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(g());
        for (int i = 0; i < this.d.length; i++) {
            if (j()) {
                t8B.B(this.d[i]);
            } else {
                t8B.E((short) (this.d[i] / 2));
            }
        }
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        for (int i = 0; i < this.d.length; i++) {
            if (j()) {
                this.d[i] = t8.n();
            } else {
                this.d[i] = (65535 & t8.p()) * 2;
            }
        }
    }

    public int g() {
        return j() ? this.d.length * 4 : this.d.length * 2;
    }

    public int h(int i) {
        return this.d[i];
    }

    public int i(int i) {
        int[] iArr = this.d;
        return iArr[i + 1] - iArr[i];
    }

    public boolean j() {
        return this.c;
    }
}
