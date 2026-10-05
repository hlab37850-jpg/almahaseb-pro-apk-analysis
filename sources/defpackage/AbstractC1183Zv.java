package defpackage;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;

/* JADX INFO: renamed from: Zv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1183Zv {

    /* JADX INFO: renamed from: Zv$a */
    public static final class a extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ ListenableFuture a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ListenableFuture listenableFuture) {
            super(1);
            this.a = listenableFuture;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) {
            this.a.cancel(false);
        }
    }

    public static final Object b(ListenableFuture listenableFuture, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        try {
            if (listenableFuture.isDone()) {
                return Uninterruptibles.getUninterruptibly(listenableFuture);
            }
            C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
            c4374ya.A();
            listenableFuture.addListener(new PU(listenableFuture, c4374ya), MoreExecutors.directExecutor());
            c4374ya.e(new a(listenableFuture));
            Object objX = c4374ya.x();
            if (objX == AbstractC0378Bt.d()) {
                AbstractC3416mi.c(interfaceC0793Of);
            }
            return objX;
        } catch (ExecutionException e) {
            throw c(e);
        }
    }

    public static final Throwable c(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        AbstractC4492zt.e(cause);
        return cause;
    }
}
