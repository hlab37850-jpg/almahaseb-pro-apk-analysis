package androidx.compose.material;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;
import defpackage.J6;
import defpackage.NJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float fM5160constructorimpl = Dp.m5160constructorimpl((float) 0.125d);
        mouseSlop = fM5160constructorimpl;
        float fM5160constructorimpl2 = Dp.m5160constructorimpl(18);
        defaultTouchSlop = fM5160constructorimpl2;
        mouseToTouchSlopRatio = fM5160constructorimpl / fM5160constructorimpl2;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:29:0x00dc A[LOOP:0: B:25:0x00c5->B:29:0x00dc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e4 A[EDGE_INSN: B:64:0x00e4->B:31:0x00e4 BREAK  A[LOOP:0: B:25:0x00c5->B:29:0x00dc], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x011b -> B:47:0x0126). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x015c -> B:54:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x017f -> B:47:0x0126). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    public static final java.lang.Object m1087awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, int r23, defpackage.InterfaceC0526Fp r24, defpackage.InterfaceC0793Of r25) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.m1087awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, Fp, Of):java.lang.Object");
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m1088awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        float f;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (m1089isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float fM1090pointerSlopE8SPZFQ = m1090pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        NJ nj = new NJ();
        nj.a = j;
        float f2 = 0.0f;
        while (true) {
            AbstractC0703Ks.c(0);
            Object objT = J6.t(awaitPointerEventScope, null, interfaceC0793Of, 1, null);
            AbstractC0703Ks.c(1);
            PointerEvent pointerEvent = (PointerEvent) objT;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    f = f2;
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                f = f2;
                if (Boolean.valueOf(PointerId.m4037equalsimpl0(pointerInputChange.m4053getIdJ3iCeTQ(), nj.a)).booleanValue()) {
                    break;
                }
                i2++;
                f2 = f;
            }
            AbstractC4492zt.e(pointerInputChange);
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                nj.a = pointerInputChange4.m4053getIdJ3iCeTQ();
            } else {
                float fFloatValue = f + (((Number) interfaceC3750qp.invoke(Offset.m2787boximpl(pointerInputChange3.m4054getPositionF1C5BW0()))).floatValue() - ((Number) interfaceC3750qp.invoke(Offset.m2787boximpl(pointerInputChange3.m4055getPreviousPositionF1C5BW0()))).floatValue());
                if (Math.abs(fFloatValue) < fM1090pointerSlopE8SPZFQ) {
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    AbstractC0703Ks.c(0);
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass, interfaceC0793Of);
                    AbstractC0703Ks.c(1);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                    f = fFloatValue;
                } else {
                    interfaceC0526Fp.mo13invoke(pointerInputChange3, Float.valueOf(fFloatValue - (Math.signum(fFloatValue) * fM1090pointerSlopE8SPZFQ)));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    f = 0.0f;
                }
                f2 = f;
            }
            f2 = f;
        }
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m1089isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m4037equalsimpl0(pointerInputChange.m4053getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m1090pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        AbstractC4492zt.h(viewConfiguration, "$this$pointerSlop");
        return PointerType.m4112equalsimpl0(i, PointerType.Companion.m4117getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }
}
