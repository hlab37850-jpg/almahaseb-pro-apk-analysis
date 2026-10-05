package androidx.compose.ui.platform;

import android.os.Handler;
import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.InternalComposeUiApi;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC0773Nl;
import defpackage.AbstractC2147er;
import defpackage.AbstractC4492zt;
import defpackage.C3343lq;
import defpackage.FC;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3588op;
import defpackage.O8;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeUiApi
public final class WindowRecomposerPolicy {
    public static final WindowRecomposerPolicy INSTANCE = new WindowRecomposerPolicy();
    private static final AtomicReference<WindowRecomposerFactory> factory = new AtomicReference<>(WindowRecomposerFactory.Companion.getLifecycleAware());
    public static final int $stable = 8;

    private WindowRecomposerPolicy() {
    }

    public final boolean compareAndSetFactory(WindowRecomposerFactory windowRecomposerFactory, WindowRecomposerFactory windowRecomposerFactory2) {
        AbstractC4492zt.h(windowRecomposerFactory, "expected");
        AbstractC4492zt.h(windowRecomposerFactory2, "factory");
        return FC.a(factory, windowRecomposerFactory, windowRecomposerFactory2);
    }

    public final Recomposer createAndInstallWindowRecomposer$ui_release(View view) {
        AbstractC4492zt.h(view, "rootView");
        Recomposer recomposerCreateRecomposer = factory.get().createRecomposer(view);
        WindowRecomposer_androidKt.setCompositionContext(view, recomposerCreateRecomposer);
        C3343lq c3343lq = C3343lq.a;
        Handler handler = view.getHandler();
        AbstractC4492zt.g(handler, "rootView.handler");
        final InterfaceC1830bu interfaceC1830buD = O8.d(c3343lq, AbstractC2147er.b(handler, "windowRecomposer cleanup").I(), null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(recomposerCreateRecomposer, view, null), 2, null);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                AbstractC4492zt.h(view2, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                AbstractC4492zt.h(view2, "v");
                view2.removeOnAttachStateChangeListener(this);
                InterfaceC1830bu.a.a(interfaceC1830buD, null, 1, null);
            }
        });
        return recomposerCreateRecomposer;
    }

    public final WindowRecomposerFactory getAndSetFactory(WindowRecomposerFactory windowRecomposerFactory) {
        AbstractC4492zt.h(windowRecomposerFactory, "factory");
        WindowRecomposerFactory andSet = factory.getAndSet(windowRecomposerFactory);
        AbstractC4492zt.g(andSet, "factory.getAndSet(factory)");
        return andSet;
    }

    public final void setFactory(WindowRecomposerFactory windowRecomposerFactory) {
        AbstractC4492zt.h(windowRecomposerFactory, "factory");
        factory.set(windowRecomposerFactory);
    }

    public final <R> R withFactory(WindowRecomposerFactory windowRecomposerFactory, InterfaceC3588op interfaceC3588op) throws IllegalAccessException, InvocationTargetException {
        AbstractC4492zt.h(windowRecomposerFactory, "factory");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        WindowRecomposerFactory andSetFactory = getAndSetFactory(windowRecomposerFactory);
        try {
            R r = (R) interfaceC3588op.invoke();
            AbstractC0703Ks.b(1);
            if (!compareAndSetFactory(windowRecomposerFactory, andSetFactory)) {
                throw new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state");
            }
            AbstractC0703Ks.a(1);
            return r;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0703Ks.b(1);
                if (compareAndSetFactory(windowRecomposerFactory, andSetFactory)) {
                    AbstractC0703Ks.a(1);
                    throw th2;
                }
                AbstractC0773Nl.a(th, new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state"));
                throw th;
            }
        }
    }
}
