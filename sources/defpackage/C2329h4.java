package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import com.joanzapata.pdfview.PDFView;

/* JADX INFO: renamed from: h4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2329h4 {
    public PDFView a;
    public ValueAnimator b;

    /* JADX INFO: renamed from: h4$a */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2329h4.this.a.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), C2329h4.this.a.getCurrentYOffset());
        }
    }

    /* JADX INFO: renamed from: h4$b */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2329h4.this.a.m(C2329h4.this.a.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public C2329h4(PDFView pDFView) {
        this.a = pDFView;
    }

    public void b(float f, float f2) {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        this.b.addUpdateListener(new a());
        this.b.setDuration(400L);
        this.b.start();
    }

    public void c(float f, float f2) {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        this.b.addUpdateListener(new b());
        this.b.setDuration(400L);
        this.b.start();
    }

    public void d(float f, float f2) {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.b = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        c cVar = new c();
        this.b.addUpdateListener(cVar);
        this.b.addListener(cVar);
        this.b.setDuration(400L);
        this.b.start();
    }

    public void e() {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.b = null;
        }
    }

    /* JADX INFO: renamed from: h4$c */
    public class c implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C2329h4.this.a.k();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2329h4.this.a.t(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(C2329h4.this.a.getWidth() / 2, C2329h4.this.a.getHeight() / 2));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
