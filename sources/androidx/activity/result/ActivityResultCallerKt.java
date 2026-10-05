package androidx.activity.result;

import androidx.activity.result.ActivityResultCallerKt;
import androidx.activity.result.contract.ActivityResultContract;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<FW> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, ActivityResultRegistry activityResultRegistry, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(activityResultCaller, "<this>");
        AbstractC4492zt.h(activityResultContract, "contract");
        AbstractC4492zt.h(activityResultRegistry, "registry");
        AbstractC4492zt.h(interfaceC3750qp, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCallback() { // from class: k2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResultCallerKt.registerForActivityResult$lambda$0(interfaceC3750qp, obj);
            }
        }), activityResultContract, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$0(InterfaceC3750qp interfaceC3750qp, Object obj) {
        AbstractC4492zt.h(interfaceC3750qp, "$callback");
        interfaceC3750qp.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$1(InterfaceC3750qp interfaceC3750qp, Object obj) {
        AbstractC4492zt.h(interfaceC3750qp, "$callback");
        interfaceC3750qp.invoke(obj);
    }

    public static final <I, O> ActivityResultLauncher<FW> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(activityResultCaller, "<this>");
        AbstractC4492zt.h(activityResultContract, "contract");
        AbstractC4492zt.h(interfaceC3750qp, "callback");
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallback() { // from class: l2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResultCallerKt.registerForActivityResult$lambda$1(interfaceC3750qp, obj);
            }
        }), activityResultContract, i);
    }
}
