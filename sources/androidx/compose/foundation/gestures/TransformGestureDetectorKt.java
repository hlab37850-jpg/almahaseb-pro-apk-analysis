package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.JL;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TransformGestureDetectorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", l = {59, 61}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends JL implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0578Hp $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z, InterfaceC0578Hp interfaceC0578Hp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$panZoomLock = z;
            this.$onGesture = interfaceC0578Hp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$panZoomLock, this.$onGesture, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:22:0x00bc A[LOOP:0: B:18:0x00ac->B:22:0x00bc, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:75:0x00bf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:76:0x00ba A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x009e -> B:17:0x00a1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 443
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m360anglek4lQ0M(long j) {
        if (Offset.m2798getXimpl(j) == 0.0f && Offset.m2799getYimpl(j) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j)))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z) {
        AbstractC4492zt.h(pointerEvent, "<this>");
        long jM2814getZeroF1C5BW0 = Offset.Companion.m2814getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                jM2814getZeroF1C5BW0 = Offset.m2803plusMKHz9U(jM2814getZeroF1C5BW0, z ? pointerInputChange.m4054getPositionF1C5BW0() : pointerInputChange.m4055getPreviousPositionF1C5BW0());
                i++;
            }
        }
        return i == 0 ? Offset.Companion.m2813getUnspecifiedF1C5BW0() : Offset.m2793divtuRUvjQ(jM2814getZeroF1C5BW0, i);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z) {
        AbstractC4492zt.h(pointerEvent, "<this>");
        long jCalculateCentroid = calculateCentroid(pointerEvent, z);
        float fM2796getDistanceimpl = 0.0f;
        if (Offset.m2795equalsimpl0(jCalculateCentroid, Offset.Companion.m2813getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                fM2796getDistanceimpl += Offset.m2796getDistanceimpl(Offset.m2802minusMKHz9U(z ? pointerInputChange.m4054getPositionF1C5BW0() : pointerInputChange.m4055getPreviousPositionF1C5BW0(), jCalculateCentroid));
                i++;
            }
        }
        return fM2796getDistanceimpl / i;
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        AbstractC4492zt.h(pointerEvent, "<this>");
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        Offset.Companion companion = Offset.Companion;
        return Offset.m2795equalsimpl0(jCalculateCentroid, companion.m2813getUnspecifiedF1C5BW0()) ? companion.m2814getZeroF1C5BW0() : Offset.m2802minusMKHz9U(jCalculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        AbstractC4492zt.h(pointerEvent, "<this>");
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        long jCalculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < size2; i4++) {
            PointerInputChange pointerInputChange2 = changes2.get(i4);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long jM4054getPositionF1C5BW0 = pointerInputChange2.m4054getPositionF1C5BW0();
                long jM2802minusMKHz9U = Offset.m2802minusMKHz9U(pointerInputChange2.m4055getPreviousPositionF1C5BW0(), jCalculateCentroid2);
                long jM2802minusMKHz9U2 = Offset.m2802minusMKHz9U(jM4054getPositionF1C5BW0, jCalculateCentroid);
                float fM360anglek4lQ0M = m360anglek4lQ0M(jM2802minusMKHz9U2) - m360anglek4lQ0M(jM2802minusMKHz9U);
                float fM2796getDistanceimpl = Offset.m2796getDistanceimpl(Offset.m2803plusMKHz9U(jM2802minusMKHz9U2, jM2802minusMKHz9U)) / 2.0f;
                if (fM360anglek4lQ0M > 180.0f) {
                    fM360anglek4lQ0M -= 360.0f;
                } else if (fM360anglek4lQ0M < -180.0f) {
                    fM360anglek4lQ0M += 360.0f;
                }
                f2 += fM360anglek4lQ0M * fM2796getDistanceimpl;
                f += fM2796getDistanceimpl;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        AbstractC4492zt.h(pointerEvent, "<this>");
        float fCalculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float fCalculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (fCalculateCentroidSize == 0.0f || fCalculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return fCalculateCentroidSize / fCalculateCentroidSize2;
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z, InterfaceC0578Hp interfaceC0578Hp, InterfaceC0793Of interfaceC0793Of) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass2(z, interfaceC0578Hp, null), interfaceC0793Of);
        return objAwaitEachGesture == AbstractC0378Bt.d() ? objAwaitEachGesture : FW.a;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, InterfaceC0578Hp interfaceC0578Hp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, interfaceC0578Hp, interfaceC0793Of);
    }
}
