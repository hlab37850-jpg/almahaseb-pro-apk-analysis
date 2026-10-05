package defpackage;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: Si, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class ViewTreeObserverOnPreDrawListenerC0909Si implements ViewTreeObserver.OnPreDrawListener {
    public final C4035uL a;
    public final WeakReference b;

    public ViewTreeObserverOnPreDrawListenerC0909Si(C4035uL c4035uL, ImageView imageView, InterfaceC3400ma interfaceC3400ma) {
        this.a = c4035uL;
        this.b = new WeakReference(imageView);
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void a() {
        ImageView imageView = (ImageView) this.b.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            this.a.f().e(width, height).d(imageView, null);
        }
        return true;
    }
}
