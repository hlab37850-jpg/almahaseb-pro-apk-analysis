package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;

/* JADX INFO: loaded from: classes.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final Activity activity, View view, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = AbstractC1047Xm.e(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new InterfaceC0995Vm() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(Rect rect, InterfaceC0793Of interfaceC0793Of2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return FW.a;
            }
        }, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
