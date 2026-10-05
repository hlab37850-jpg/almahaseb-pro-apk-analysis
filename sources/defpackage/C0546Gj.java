package defpackage;

import android.graphics.Rect;
import java.util.List;

/* JADX INFO: renamed from: Gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0546Gj {
    public NQ a;
    public int b;
    public boolean c = false;
    public NH d = new C0575Hm();

    public C0546Gj(int i, NQ nq) {
        this.b = i;
        this.a = nq;
    }

    public NQ a(List list, boolean z) {
        return this.d.b(list, b(z));
    }

    public NQ b(boolean z) {
        NQ nq = this.a;
        if (nq == null) {
            return null;
        }
        return z ? nq.b() : nq;
    }

    public int c() {
        return this.b;
    }

    public Rect d(NQ nq) {
        return this.d.d(nq, this.a);
    }

    public void e(NH nh) {
        this.d = nh;
    }
}
