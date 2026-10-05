package defpackage;

import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: yk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public class C4392yk {
    public C1201a6 a;
    public O6 b;

    public C4392yk(View view, AttributeSet attributeSet) {
        c(view, attributeSet);
    }

    public void a(Canvas canvas) {
        this.b.b(canvas);
    }

    public N6 b() {
        return this.a.a();
    }

    public final void c(View view, AttributeSet attributeSet) {
        C1201a6 c1201a6 = new C1201a6(view, attributeSet);
        this.a = c1201a6;
        this.b = new O6(view, c1201a6.a());
    }
}
