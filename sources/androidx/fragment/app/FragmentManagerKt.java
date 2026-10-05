package androidx.fragment.app;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(fragmentManager, "$this$commit");
        AbstractC4492zt.h(interfaceC3750qp, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        AbstractC4492zt.g(fragmentTransactionBeginTransaction, "beginTransaction()");
        interfaceC3750qp.invoke(fragmentTransactionBeginTransaction);
        if (z) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        AbstractC4492zt.h(fragmentManager, "$this$commit");
        AbstractC4492zt.h(interfaceC3750qp, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        AbstractC4492zt.g(fragmentTransactionBeginTransaction, "beginTransaction()");
        interfaceC3750qp.invoke(fragmentTransactionBeginTransaction);
        if (z) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(fragmentManager, "$this$commitNow");
        AbstractC4492zt.h(interfaceC3750qp, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        AbstractC4492zt.g(fragmentTransactionBeginTransaction, "beginTransaction()");
        interfaceC3750qp.invoke(fragmentTransactionBeginTransaction);
        if (z) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        AbstractC4492zt.h(fragmentManager, "$this$commitNow");
        AbstractC4492zt.h(interfaceC3750qp, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        AbstractC4492zt.g(fragmentTransactionBeginTransaction, "beginTransaction()");
        interfaceC3750qp.invoke(fragmentTransactionBeginTransaction);
        if (z) {
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager fragmentManager, boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(fragmentManager, "$this$transaction");
        AbstractC4492zt.h(interfaceC3750qp, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        AbstractC4492zt.g(fragmentTransactionBeginTransaction, "beginTransaction()");
        interfaceC3750qp.invoke(fragmentTransactionBeginTransaction);
        if (z) {
            if (z2) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z2) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        AbstractC4492zt.h(fragmentManager, "$this$transaction");
        AbstractC4492zt.h(interfaceC3750qp, "body");
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        AbstractC4492zt.g(fragmentTransactionBeginTransaction, "beginTransaction()");
        interfaceC3750qp.invoke(fragmentTransactionBeginTransaction);
        if (z) {
            if (z2) {
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionBeginTransaction.commitNow();
                return;
            }
        }
        if (z2) {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransactionBeginTransaction.commit();
        }
    }
}
