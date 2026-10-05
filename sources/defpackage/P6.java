package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class P6 {
    public final View a;
    public final N6 b;
    public boolean c = false;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;

    public P6(View view, N6 n6) {
        this.a = view;
        this.b = n6;
        p();
        d();
        c();
        h();
    }

    public final boolean a() {
        return this.b.g() != -1.0f || this.b.o();
    }

    public P6 b() {
        int iJ = this.b.j();
        if (iJ == 0) {
            i();
        } else if (iJ == 1) {
            j();
        } else if (iJ == 2) {
            e();
        } else if (iJ == 3) {
            f();
        } else if (iJ == 4) {
            g();
        }
        return this;
    }

    public final void c() {
        if (this.b.g() != -1.0f) {
            this.i = (int) (this.b.g() * 2.0f);
        } else {
            this.i = (int) (this.b.f() + (this.b.i() * 2.0f));
        }
    }

    public final void d() {
        if (this.b.g() != -1.0f) {
            this.h = (int) (this.b.g() * 2.0f);
            return;
        }
        if (!this.c || this.b.n() <= 9 || !this.b.q() || this.b.o()) {
            this.h = (int) (this.b.m() + (this.b.i() * 2.0f));
        } else {
            this.h = (int) (this.b.m() + (this.b.i() * 4.0f));
        }
    }

    public final void e() {
        if (!this.c) {
            this.j = (this.d - (this.g / 2.0f)) + this.b.k();
            this.k = (this.e + (this.f / 2.0f)) - this.b.k();
        } else {
            k();
            this.j = (this.d - (this.g / 2.0f)) + (this.h / 2.0f);
            this.k = (this.e + (this.f / 2.0f)) - (this.i / 2.0f);
        }
    }

    public final void f() {
        if (!this.c) {
            this.j = (this.d + (this.g / 2.0f)) - this.b.k();
            this.k = (this.e + (this.f / 2.0f)) - this.b.k();
        } else {
            k();
            this.j = (this.d + (this.g / 2.0f)) - (this.h / 2.0f);
            this.k = (this.e + (this.f / 2.0f)) - (this.i / 2.0f);
        }
    }

    public final void g() {
        this.j = this.g / 2.0f;
        this.k = this.f / 2.0f;
        if (this.c) {
            k();
        }
    }

    public final void h() {
        if (this.b.g() == -1.0f) {
            this.b.G(this.h / 2.0f);
        } else {
            N6 n6 = this.b;
            n6.G(n6.g());
        }
    }

    public final void i() {
        if (!this.c) {
            this.j = (this.d - (this.g / 2.0f)) + this.b.k();
            this.k = (this.e - (this.f / 2.0f)) + this.b.k();
        } else {
            k();
            this.j = (this.d - (this.g / 2.0f)) + (this.h / 2.0f);
            this.k = (this.e - (this.f / 2.0f)) + (this.i / 2.0f);
        }
    }

    public final void j() {
        if (!this.c) {
            this.j = (this.d + (this.g / 2.0f)) - this.b.k();
            this.k = (this.e - (this.f / 2.0f)) + this.b.k();
        } else {
            k();
            this.j = (this.d + (this.g / 2.0f)) - (this.h / 2.0f);
            this.k = (this.e - (this.f / 2.0f)) + (this.i / 2.0f);
        }
    }

    public final void k() {
        if (a()) {
            float fMax = Math.max(this.h, this.i);
            this.h = fMax;
            this.i = fMax;
        } else {
            if ((!this.b.q() || this.b.n() > 9) && (!this.b.r() || this.h >= this.i)) {
                return;
            }
            this.h = this.i;
        }
    }

    public float l() {
        return this.i;
    }

    public float m() {
        return this.h;
    }

    public float n() {
        return this.j;
    }

    public float o() {
        return this.k;
    }

    public final void p() {
        this.c = this.b.a() != null;
        this.d = this.a.getPivotX();
        this.e = this.a.getPivotY();
        this.f = this.a.getMeasuredHeight();
        this.g = this.a.getMeasuredWidth();
    }
}
