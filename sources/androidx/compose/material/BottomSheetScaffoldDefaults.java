package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class BottomSheetScaffoldDefaults {
    public static final int $stable = 0;
    public static final BottomSheetScaffoldDefaults INSTANCE = new BottomSheetScaffoldDefaults();
    private static final float SheetElevation = Dp.m5160constructorimpl(8);
    private static final float SheetPeekHeight = Dp.m5160constructorimpl(56);

    private BottomSheetScaffoldDefaults() {
    }

    /* JADX INFO: renamed from: getSheetElevation-D9Ej5fM, reason: not valid java name */
    public final float m1004getSheetElevationD9Ej5fM() {
        return SheetElevation;
    }

    /* JADX INFO: renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m1005getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }
}
