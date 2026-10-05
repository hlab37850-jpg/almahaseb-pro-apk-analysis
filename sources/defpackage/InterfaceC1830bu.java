package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC1830bu extends InterfaceC0988Vf.b {
    public static final b s = b.a;

    /* JADX INFO: renamed from: bu$a */
    public static final class a {
        public static /* synthetic */ void a(InterfaceC1830bu interfaceC1830bu, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            interfaceC1830bu.cancel(cancellationException);
        }

        public static Object b(InterfaceC1830bu interfaceC1830bu, Object obj, InterfaceC0526Fp interfaceC0526Fp) {
            return InterfaceC0988Vf.b.a.a(interfaceC1830bu, obj, interfaceC0526Fp);
        }

        public static InterfaceC0988Vf.b c(InterfaceC1830bu interfaceC1830bu, InterfaceC0988Vf.c cVar) {
            return InterfaceC0988Vf.b.a.b(interfaceC1830bu, cVar);
        }

        public static /* synthetic */ InterfaceC0745Mj d(InterfaceC1830bu interfaceC1830bu, boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return interfaceC1830bu.c(z, z2, interfaceC3750qp);
        }

        public static InterfaceC0988Vf e(InterfaceC1830bu interfaceC1830bu, InterfaceC0988Vf.c cVar) {
            return InterfaceC0988Vf.b.a.c(interfaceC1830bu, cVar);
        }

        public static InterfaceC0988Vf f(InterfaceC1830bu interfaceC1830bu, InterfaceC0988Vf interfaceC0988Vf) {
            return InterfaceC0988Vf.b.a.d(interfaceC1830bu, interfaceC0988Vf);
        }
    }

    /* JADX INFO: renamed from: bu$b */
    public static final class b implements InterfaceC0988Vf.c {
        public static final /* synthetic */ b a = new b();
    }

    InterfaceC4214wb A(InterfaceC4376yb interfaceC4376yb);

    InterfaceC0745Mj C(InterfaceC3750qp interfaceC3750qp);

    Object F(InterfaceC0793Of interfaceC0793Of);

    InterfaceC0745Mj c(boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp);

    void cancel(CancellationException cancellationException);

    InterfaceC4362yO getChildren();

    CancellationException i();

    boolean isActive();

    boolean start();

    boolean z();
}
