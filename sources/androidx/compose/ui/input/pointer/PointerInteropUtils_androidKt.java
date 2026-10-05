package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setSource(0);
        AbstractC4492zt.g(motionEventObtain, "motionEvent");
        interfaceC3750qp.invoke(motionEventObtain);
        motionEventObtain.recycle();
    }

    public static /* synthetic */ void emptyCancelMotionEventScope$default(long j, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            j = SystemClock.uptimeMillis();
        }
        emptyCancelMotionEventScope(j, interfaceC3750qp);
    }

    /* JADX INFO: renamed from: toCancelMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m4099toCancelMotionEventScoped4ec7I(PointerEvent pointerEvent, long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pointerEvent, "$this$toCancelMotionEventScope");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        m4101toMotionEventScopeubNVwUQ(pointerEvent, j, interfaceC3750qp, true);
    }

    /* JADX INFO: renamed from: toMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m4100toMotionEventScoped4ec7I(PointerEvent pointerEvent, long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pointerEvent, "$this$toMotionEventScope");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        m4101toMotionEventScopeubNVwUQ(pointerEvent, j, interfaceC3750qp, false);
    }

    /* JADX INFO: renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    private static final void m4101toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j, InterfaceC3750qp interfaceC3750qp, boolean z) {
        MotionEvent motionEvent$ui_release = pointerEvent.getMotionEvent$ui_release();
        if (motionEvent$ui_release == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.");
        }
        int action = motionEvent$ui_release.getAction();
        if (z) {
            motionEvent$ui_release.setAction(3);
        }
        motionEvent$ui_release.offsetLocation(-Offset.m2798getXimpl(j), -Offset.m2799getYimpl(j));
        interfaceC3750qp.invoke(motionEvent$ui_release);
        motionEvent$ui_release.offsetLocation(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
        motionEvent$ui_release.setAction(action);
    }
}
