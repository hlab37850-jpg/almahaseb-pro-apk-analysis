package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class SheetBottomTokens {
    public static final float DockedDragHandleOpacity = 0.4f;
    private static final float DockedModalContainerElevation;
    private static final float DockedStandardContainerElevation;
    public static final SheetBottomTokens INSTANCE = new SheetBottomTokens();
    private static final ColorSchemeKeyTokens DockedContainerColor = ColorSchemeKeyTokens.Surface;
    private static final ShapeKeyTokens DockedContainerShape = ShapeKeyTokens.CornerExtraLargeTop;
    private static final ColorSchemeKeyTokens DockedContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
    private static final ColorSchemeKeyTokens DockedDragHandleColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final float DockedDragHandleHeight = Dp.m5160constructorimpl((float) 4.0d);
    private static final float DockedDragHandleWidth = Dp.m5160constructorimpl((float) 32.0d);
    private static final ShapeKeyTokens DockedMinimizedContainerShape = ShapeKeyTokens.CornerNone;

    static {
        ElevationTokens elevationTokens = ElevationTokens.INSTANCE;
        DockedModalContainerElevation = elevationTokens.m2205getLevel1D9Ej5fM();
        DockedStandardContainerElevation = elevationTokens.m2205getLevel1D9Ej5fM();
    }

    private SheetBottomTokens() {
    }

    public final ColorSchemeKeyTokens getDockedContainerColor() {
        return DockedContainerColor;
    }

    public final ShapeKeyTokens getDockedContainerShape() {
        return DockedContainerShape;
    }

    public final ColorSchemeKeyTokens getDockedContainerSurfaceTintLayerColor() {
        return DockedContainerSurfaceTintLayerColor;
    }

    public final ColorSchemeKeyTokens getDockedDragHandleColor() {
        return DockedDragHandleColor;
    }

    /* JADX INFO: renamed from: getDockedDragHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m2496getDockedDragHandleHeightD9Ej5fM() {
        return DockedDragHandleHeight;
    }

    /* JADX INFO: renamed from: getDockedDragHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m2497getDockedDragHandleWidthD9Ej5fM() {
        return DockedDragHandleWidth;
    }

    public final ShapeKeyTokens getDockedMinimizedContainerShape() {
        return DockedMinimizedContainerShape;
    }

    /* JADX INFO: renamed from: getDockedModalContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2498getDockedModalContainerElevationD9Ej5fM() {
        return DockedModalContainerElevation;
    }

    /* JADX INFO: renamed from: getDockedStandardContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2499getDockedStandardContainerElevationD9Ej5fM() {
        return DockedStandardContainerElevation;
    }
}
