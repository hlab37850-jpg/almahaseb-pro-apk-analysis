package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import defpackage.AD;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$StandardBottomSheet$2$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ float $layoutHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ SheetState $state;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$StandardBottomSheet$2$1(SheetState sheetState, float f, float f2) {
        super(2);
        this.$state = sheetState;
        this.$layoutHeight = f;
        this.$peekHeightPx = f2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m1355invokeO0kMr_c((SheetValue) obj, ((IntSize) obj2).m5324unboximpl());
    }

    /* JADX INFO: renamed from: invoke-O0kMr_c, reason: not valid java name */
    public final Float m1355invokeO0kMr_c(SheetValue sheetValue, long j) {
        AbstractC4492zt.h(sheetValue, "value");
        int i = WhenMappings.$EnumSwitchMapping$0[sheetValue.ordinal()];
        if (i == 1) {
            if (this.$state.getSkipPartiallyExpanded$material3_release()) {
                return null;
            }
            return Float.valueOf(this.$layoutHeight - this.$peekHeightPx);
        }
        if (i == 2) {
            if (IntSize.m5319getHeightimpl(j) == AbstractC1210aB.c(this.$peekHeightPx)) {
                return null;
            }
            return Float.valueOf(Math.max(0.0f, this.$layoutHeight - IntSize.m5319getHeightimpl(j)));
        }
        if (i != 3) {
            throw new AD();
        }
        if (this.$state.getSkipHiddenState$material3_release()) {
            return null;
        }
        return Float.valueOf(this.$layoutHeight);
    }
}
