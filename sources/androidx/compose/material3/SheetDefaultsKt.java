package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SheetDefaultsKt {
    private static final float DragHandleVerticalPadding = Dp.m5160constructorimpl(22);
    private static final float BottomSheetMaxWidth = Dp.m5160constructorimpl(640);

    /* JADX INFO: renamed from: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15431 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C15431 INSTANCE = new C15431();

        public C15431() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(SheetValue sheetValue) {
            AbstractC4492zt.h(sheetValue, "it");
            return Boolean.TRUE;
        }
    }

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(final SheetState sheetState, final Orientation orientation, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(sheetState, "sheetState");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(interfaceC3750qp, "onFling");
        return new NestedScrollConnection() { // from class: androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1
            private final float offsetToFloat(long j) {
                return orientation == Orientation.Horizontal ? Offset.m2798getXimpl(j) : Offset.m2799getYimpl(j);
            }

            private final long toOffset(float f) {
                Orientation orientation2 = orientation;
                float f2 = orientation2 == Orientation.Horizontal ? f : 0.0f;
                if (orientation2 != Orientation.Vertical) {
                    f = 0.0f;
                }
                return OffsetKt.Offset(f2, f);
            }

            private final float velocityToFloat(long j) {
                return orientation == Orientation.Horizontal ? Velocity.m5385getXimpl(j) : Velocity.m5386getYimpl(j);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
            public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) {
                interfaceC3750qp.invoke(E8.b(velocityToFloat(j2)));
                return Velocity.m5376boximpl(j2);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
            public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
                return NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3963getDragWNlRxjI()) ? toOffset(sheetState.getSwipeableState$material3_release().dispatchRawDelta(offsetToFloat(j2))) : Offset.Companion.m2814getZeroF1C5BW0();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreFling-QWom1Mo */
            public Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = sheetState.requireOffset();
                if (fVelocityToFloat >= 0.0f || fRequireOffset <= sheetState.getSwipeableState$material3_release().getMinOffset()) {
                    j = Velocity.Companion.m5396getZero9UxMQ8M();
                } else {
                    interfaceC3750qp.invoke(E8.b(fVelocityToFloat));
                }
                return Velocity.m5376boximpl(j);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
            public long mo343onPreScrollOzD1aCk(long j, int i) {
                float fOffsetToFloat = offsetToFloat(j);
                return (fOffsetToFloat >= 0.0f || !NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3963getDragWNlRxjI())) ? Offset.Companion.m2814getZeroF1C5BW0() : toOffset(sheetState.getSwipeableState$material3_release().dispatchRawDelta(fOffsetToFloat));
            }
        };
    }

    public static final float getBottomSheetMaxWidth() {
        return BottomSheetMaxWidth;
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final SheetState rememberSheetState(boolean z, InterfaceC3750qp interfaceC3750qp, SheetValue sheetValue, boolean z2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1032784200);
        boolean z3 = (i2 & 1) != 0 ? false : z;
        InterfaceC3750qp interfaceC3750qp2 = (i2 & 2) != 0 ? C15431.INSTANCE : interfaceC3750qp;
        SheetValue sheetValue2 = (i2 & 4) != 0 ? SheetValue.Hidden : sheetValue;
        boolean z4 = (i2 & 8) != 0 ? false : z2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1032784200, i, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:410)");
        }
        Object[] objArr = {Boolean.valueOf(z3), interfaceC3750qp2};
        Saver<SheetState, SheetValue> Saver = SheetState.Companion.Saver(z3, interfaceC3750qp2);
        Object[] objArr2 = {Boolean.valueOf(z3), sheetValue2, interfaceC3750qp2, Boolean.valueOf(z4)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i3 = 0; i3 < 4; i3++) {
            zChanged |= composer.changed(objArr2[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SheetDefaultsKt$rememberSheetState$2$1(z3, sheetValue2, interfaceC3750qp2, z4);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SheetState sheetState = (SheetState) RememberSaveableKt.m2674rememberSaveable(objArr, (Saver) Saver, (String) null, (InterfaceC3588op) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sheetState;
    }
}
