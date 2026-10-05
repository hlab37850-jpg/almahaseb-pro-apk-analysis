package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class O6 {
    public P6 a;
    public Paint b;
    public final View c;
    public final N6 d;

    public O6(View view, N6 n6) {
        this.c = view;
        this.d = n6;
    }

    public final void a() {
        this.d.K((!this.d.p() || this.d.n() <= this.d.h()) ? this.b.measureText(String.valueOf(this.d.n())) : this.b.measureText(String.valueOf(this.d.h()).concat("+")));
    }

    public void b(Canvas canvas) {
        if (this.d.t() || this.d.n() > 0) {
            e();
            a();
            this.a = new P6(this.c, this.d).b();
            c(canvas);
            if (this.d.s()) {
                d(canvas);
            }
        }
    }

    public final void c(Canvas canvas) {
        this.b.setColor(this.d.c());
        if (this.d.a() == null) {
            canvas.drawCircle(this.a.n(), this.a.o(), this.d.k(), this.b);
            return;
        }
        this.d.a().setBounds(0, 0, (int) this.a.m(), (int) this.a.l());
        canvas.save();
        canvas.translate(this.a.n() - (this.a.m() / 2.0f), this.a.o() - (this.a.l() / 2.0f));
        this.d.a().draw(canvas);
        canvas.restore();
    }

    public final void d(Canvas canvas) {
        this.b.setColor(this.d.d());
        if (!this.d.p() || this.d.n() <= this.d.h()) {
            canvas.drawText(String.valueOf(this.d.n()), this.a.n() - (this.d.m() / 2.0f), this.a.o() + (this.d.f() / 3.0f), this.b);
        } else {
            canvas.drawText(String.valueOf(this.d.h()).concat("+"), this.a.n() - (this.d.m() / 2.0f), this.a.o() + (this.d.f() / 3.0f), this.b);
        }
    }

    public final void e() {
        if (this.b == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setAntiAlias(true);
            this.b.setTypeface(Typeface.create(this.d.e(), this.d.l()));
            this.b.setTextSize(this.d.f());
        }
    }
}
