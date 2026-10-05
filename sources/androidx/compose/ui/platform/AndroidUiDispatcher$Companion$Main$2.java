package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3588op;
import defpackage.M8;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidUiDispatcher$Companion$Main$2 extends AbstractC2233fv implements InterfaceC3588op {
    public static final AndroidUiDispatcher$Companion$Main$2 INSTANCE = new AndroidUiDispatcher$Companion$Main$2();

    public AndroidUiDispatcher$Companion$Main$2() {
        super(0);
    }

    @Override // defpackage.InterfaceC3588op
    public final InterfaceC0988Vf invoke() {
        Choreographer choreographer = AndroidUiDispatcher_androidKt.isMainThread() ? Choreographer.getInstance() : (Choreographer) M8.e(C0368Bj.c(), new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(null));
        AbstractC4492zt.g(choreographer, "if (isMainThread()) Chor…eographer.getInstance() }");
        Handler handlerCreateAsync = HandlerCompat.createAsync(Looper.getMainLooper());
        AbstractC4492zt.g(handlerCreateAsync, "createAsync(Looper.getMainLooper())");
        AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, handlerCreateAsync, null);
        return androidUiDispatcher.plus(androidUiDispatcher.getFrameClock());
    }
}
