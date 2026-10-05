package defpackage;

import android.graphics.PointF;
import com.joanzapata.pdfview.PDFView;

/* JADX INFO: renamed from: dk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2059dk implements ViewOnTouchListenerC1901ck.c, ViewOnTouchListenerC1901ck.d, ViewOnTouchListenerC1901ck.b {
    public PDFView a;
    public ViewOnTouchListenerC1901ck b;
    public long c;
    public float d;
    public float e;
    public boolean f = false;
    public boolean g;

    public C2059dk(PDFView pDFView) {
        this.a = pDFView;
        this.g = pDFView.i();
        ViewOnTouchListenerC1901ck viewOnTouchListenerC1901ck = new ViewOnTouchListenerC1901ck();
        this.b = viewOnTouchListenerC1901ck;
        viewOnTouchListenerC1901ck.f(this);
        this.b.g(this);
        this.b.e(this);
        pDFView.setOnTouchListener(this.b);
    }

    @Override // defpackage.ViewOnTouchListenerC1901ck.b
    public void a(float f, float f2) {
        if (h()) {
            this.a.p();
        }
    }

    @Override // defpackage.ViewOnTouchListenerC1901ck.d
    public void b(float f, PointF pointF) {
        float zoom;
        float zoom2 = this.a.getZoom() * f;
        float f2 = 1.0f;
        if (zoom2 >= 1.0f) {
            f2 = 10.0f;
            if (zoom2 > 10.0f) {
                zoom = this.a.getZoom();
            }
            this.a.s(f, pointF);
        }
        zoom = this.a.getZoom();
        f = f2 / zoom;
        this.a.s(f, pointF);
    }

    @Override // defpackage.ViewOnTouchListenerC1901ck.c
    public void c(float f, float f2) {
        if (h()) {
            this.a.k();
            return;
        }
        if (this.f) {
            float f3 = this.g ? f2 - this.e : f - this.d;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
            int i = f3 > 0.0f ? -1 : 1;
            if (g(f3, jCurrentTimeMillis) || f(f3)) {
                PDFView pDFView = this.a;
                pDFView.q(pDFView.getCurrentPage() + i);
            } else {
                PDFView pDFView2 = this.a;
                pDFView2.q(pDFView2.getCurrentPage());
            }
        }
    }

    @Override // defpackage.ViewOnTouchListenerC1901ck.c
    public void d(float f, float f2) {
        if (h() || this.f) {
            this.a.l(f, f2);
        }
    }

    @Override // defpackage.ViewOnTouchListenerC1901ck.c
    public void e(float f, float f2) {
        this.c = System.currentTimeMillis();
        this.d = f;
        this.e = f2;
    }

    public final boolean f(float f) {
        float fAbs = Math.abs(f);
        PDFView pDFView = this.a;
        return fAbs > Math.abs(pDFView.r(pDFView.getOptimalPageWidth()) / 2.0f);
    }

    public final boolean g(float f, long j) {
        return Math.abs(f) >= 50.0f && j <= 250;
    }

    public boolean h() {
        return this.a.j();
    }
}
