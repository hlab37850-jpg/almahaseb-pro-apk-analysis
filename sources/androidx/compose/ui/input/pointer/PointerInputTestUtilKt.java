package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;
import defpackage.R5;
import java.util.List;
import org.apache.poi.hssf.record.BOFRecord;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInputTestUtilKt {
    public static final PointerInputChange down(long j, long j2, float f, float f2) {
        return new PointerInputChange(PointerId.m4035constructorimpl(j), j2, OffsetKt.Offset(f, f2), true, 1.0f, j2, OffsetKt.Offset(f, f2), false, false, 0, 0L, BOFRecord.VERSION, (AbstractC0419Di) null);
    }

    public static /* synthetic */ PointerInputChange down$default(long j, long j2, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = 0;
        }
        return down(j, j2, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? 0.0f : f2);
    }

    /* JADX INFO: renamed from: invokeOverAllPasses-H0pRuoY, reason: not valid java name */
    public static final void m4091invokeOverAllPassesH0pRuoY(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, long j) {
        AbstractC4492zt.h(interfaceC0552Gp, "$this$invokeOverAllPasses");
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        m4095invokeOverPasseshUlJWOE(interfaceC0552Gp, pointerEvent, (List<? extends PointerEventPass>) AbstractC1886cc.p(PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final), j);
    }

    /* JADX INFO: renamed from: invokeOverAllPasses-H0pRuoY$default, reason: not valid java name */
    public static /* synthetic */ void m4092invokeOverAllPassesH0pRuoY$default(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4091invokeOverAllPassesH0pRuoY(interfaceC0552Gp, pointerEvent, j);
    }

    /* JADX INFO: renamed from: invokeOverPass-hUlJWOE, reason: not valid java name */
    public static final void m4093invokeOverPasshUlJWOE(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        AbstractC4492zt.h(interfaceC0552Gp, "$this$invokeOverPass");
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        AbstractC4492zt.h(pointerEventPass, "pointerEventPass");
        m4095invokeOverPasseshUlJWOE(interfaceC0552Gp, pointerEvent, (List<? extends PointerEventPass>) AbstractC1805bc.e(pointerEventPass), j);
    }

    /* JADX INFO: renamed from: invokeOverPass-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m4094invokeOverPasshUlJWOE$default(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4093invokeOverPasshUlJWOE(interfaceC0552Gp, pointerEvent, pointerEventPass, j);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m4096invokeOverPasseshUlJWOE(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j) {
        AbstractC4492zt.h(interfaceC0552Gp, "$this$invokeOverPasses");
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        AbstractC4492zt.h(pointerEventPassArr, "pointerEventPasses");
        m4095invokeOverPasseshUlJWOE(interfaceC0552Gp, pointerEvent, (List<? extends PointerEventPass>) R5.l0(pointerEventPassArr), j);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m4098invokeOverPasseshUlJWOE$default(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4096invokeOverPasseshUlJWOE(interfaceC0552Gp, pointerEvent, pointerEventPassArr, j);
    }

    public static final PointerInputChange moveBy(PointerInputChange pointerInputChange, long j, float f, float f2) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        long jM4053getIdJ3iCeTQ = pointerInputChange.m4053getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(jM4053getIdJ3iCeTQ, pointerInputChange.getUptimeMillis() + j, OffsetKt.Offset(Offset.m2798getXimpl(pointerInputChange.m4054getPositionF1C5BW0()) + f, Offset.m2799getYimpl(pointerInputChange.m4054getPositionF1C5BW0()) + f2), true, 1.0f, uptimeMillis, pointerInputChange.m4054getPositionF1C5BW0(), pressed, false, 0, 0L, BOFRecord.VERSION, (AbstractC0419Di) null);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveBy(pointerInputChange, j, f, f2);
    }

    public static final PointerInputChange moveTo(PointerInputChange pointerInputChange, long j, float f, float f2) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        long jM4053getIdJ3iCeTQ = pointerInputChange.m4053getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(jM4053getIdJ3iCeTQ, j, OffsetKt.Offset(f, f2), true, 1.0f, uptimeMillis, pointerInputChange.m4054getPositionF1C5BW0(), pressed, false, 0, 0L, BOFRecord.VERSION, (AbstractC0419Di) null);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange pointerInputChange, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return moveTo(pointerInputChange, j, f, f2);
    }

    public static final PointerInputChange up(PointerInputChange pointerInputChange, long j) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        long jM4053getIdJ3iCeTQ = pointerInputChange.m4053getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(jM4053getIdJ3iCeTQ, j, pointerInputChange.m4054getPositionF1C5BW0(), false, 1.0f, uptimeMillis, pointerInputChange.m4054getPositionF1C5BW0(), pressed, false, 0, 0L, BOFRecord.VERSION, (AbstractC0419Di) null);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m4095invokeOverPasseshUlJWOE(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, List<? extends PointerEventPass> list, long j) {
        AbstractC4492zt.h(interfaceC0552Gp, "$this$invokeOverPasses");
        AbstractC4492zt.h(pointerEvent, "pointerEvent");
        AbstractC4492zt.h(list, "pointerEventPasses");
        if (pointerEvent.getChanges().isEmpty()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            interfaceC0552Gp.invoke(pointerEvent, list.get(i), IntSize.m5312boximpl(j));
        }
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m4097invokeOverPasseshUlJWOE$default(InterfaceC0552Gp interfaceC0552Gp, PointerEvent pointerEvent, List list, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m4095invokeOverPasseshUlJWOE(interfaceC0552Gp, pointerEvent, (List<? extends PointerEventPass>) list, j);
    }
}
