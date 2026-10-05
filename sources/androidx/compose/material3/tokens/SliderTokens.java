package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderTokens {
    private static final ColorSchemeKeyTokens ActiveTrackColor;
    private static final float ActiveTrackHeight;
    private static final ShapeKeyTokens ActiveTrackShape;
    private static final ColorSchemeKeyTokens DisabledActiveTrackColor;
    public static final float DisabledActiveTrackOpacity = 0.38f;
    private static final ColorSchemeKeyTokens DisabledHandleColor;
    private static final float DisabledHandleElevation;
    public static final float DisabledHandleOpacity = 0.38f;
    private static final ColorSchemeKeyTokens DisabledInactiveTrackColor;
    public static final float DisabledInactiveTrackOpacity = 0.12f;
    private static final ColorSchemeKeyTokens FocusHandleColor;
    private static final ColorSchemeKeyTokens HandleColor;
    private static final float HandleElevation;
    private static final float HandleHeight;
    private static final ShapeKeyTokens HandleShape;
    private static final float HandleWidth;
    private static final ColorSchemeKeyTokens HoverHandleColor;
    public static final SliderTokens INSTANCE = new SliderTokens();
    private static final ColorSchemeKeyTokens InactiveTrackColor;
    private static final float InactiveTrackHeight;
    private static final ShapeKeyTokens InactiveTrackShape;
    private static final ColorSchemeKeyTokens LabelContainerColor;
    private static final float LabelContainerElevation;
    private static final float LabelContainerHeight;
    private static final ColorSchemeKeyTokens LabelTextColor;
    private static final TypographyKeyTokens LabelTextFont;
    private static final ColorSchemeKeyTokens OverlapHandleOutlineColor;
    private static final float OverlapHandleOutlineWidth;
    private static final ColorSchemeKeyTokens PressedHandleColor;
    private static final float StateLayerSize;
    private static final ColorSchemeKeyTokens TickMarksActiveContainerColor;
    public static final float TickMarksActiveContainerOpacity = 0.38f;
    private static final ShapeKeyTokens TickMarksContainerShape;
    private static final float TickMarksContainerSize;
    private static final ColorSchemeKeyTokens TickMarksDisabledContainerColor;
    public static final float TickMarksDisabledContainerOpacity = 0.38f;
    private static final ColorSchemeKeyTokens TickMarksInactiveContainerColor;
    public static final float TickMarksInactiveContainerOpacity = 0.38f;
    private static final float TrackElevation;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        ActiveTrackColor = colorSchemeKeyTokens;
        float f = (float) 4.0d;
        ActiveTrackHeight = Dp.m5160constructorimpl(f);
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        ActiveTrackShape = shapeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurface;
        DisabledActiveTrackColor = colorSchemeKeyTokens2;
        DisabledHandleColor = colorSchemeKeyTokens2;
        ElevationTokens elevationTokens = ElevationTokens.INSTANCE;
        DisabledHandleElevation = elevationTokens.m2204getLevel0D9Ej5fM();
        DisabledInactiveTrackColor = colorSchemeKeyTokens2;
        FocusHandleColor = colorSchemeKeyTokens;
        HandleColor = colorSchemeKeyTokens;
        HandleElevation = elevationTokens.m2205getLevel1D9Ej5fM();
        float f2 = (float) 20.0d;
        HandleHeight = Dp.m5160constructorimpl(f2);
        HandleShape = shapeKeyTokens;
        HandleWidth = Dp.m5160constructorimpl(f2);
        HoverHandleColor = colorSchemeKeyTokens;
        InactiveTrackColor = ColorSchemeKeyTokens.SurfaceVariant;
        InactiveTrackHeight = Dp.m5160constructorimpl(f);
        InactiveTrackShape = shapeKeyTokens;
        LabelContainerColor = colorSchemeKeyTokens;
        LabelContainerElevation = elevationTokens.m2204getLevel0D9Ej5fM();
        LabelContainerHeight = Dp.m5160constructorimpl((float) 28.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnPrimary;
        LabelTextColor = colorSchemeKeyTokens3;
        LabelTextFont = TypographyKeyTokens.LabelMedium;
        PressedHandleColor = colorSchemeKeyTokens;
        StateLayerSize = Dp.m5160constructorimpl((float) 40.0d);
        TrackElevation = elevationTokens.m2204getLevel0D9Ej5fM();
        OverlapHandleOutlineColor = colorSchemeKeyTokens3;
        OverlapHandleOutlineWidth = Dp.m5160constructorimpl((float) 1.0d);
        TickMarksActiveContainerColor = colorSchemeKeyTokens3;
        TickMarksContainerShape = shapeKeyTokens;
        TickMarksContainerSize = Dp.m5160constructorimpl((float) 2.0d);
        TickMarksDisabledContainerColor = colorSchemeKeyTokens2;
        TickMarksInactiveContainerColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    }

    private SliderTokens() {
    }

    public final ColorSchemeKeyTokens getActiveTrackColor() {
        return ActiveTrackColor;
    }

    /* JADX INFO: renamed from: getActiveTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m2500getActiveTrackHeightD9Ej5fM() {
        return ActiveTrackHeight;
    }

    public final ShapeKeyTokens getActiveTrackShape() {
        return ActiveTrackShape;
    }

    public final ColorSchemeKeyTokens getDisabledActiveTrackColor() {
        return DisabledActiveTrackColor;
    }

    public final ColorSchemeKeyTokens getDisabledHandleColor() {
        return DisabledHandleColor;
    }

    /* JADX INFO: renamed from: getDisabledHandleElevation-D9Ej5fM, reason: not valid java name */
    public final float m2501getDisabledHandleElevationD9Ej5fM() {
        return DisabledHandleElevation;
    }

    public final ColorSchemeKeyTokens getDisabledInactiveTrackColor() {
        return DisabledInactiveTrackColor;
    }

    public final ColorSchemeKeyTokens getFocusHandleColor() {
        return FocusHandleColor;
    }

    public final ColorSchemeKeyTokens getHandleColor() {
        return HandleColor;
    }

    /* JADX INFO: renamed from: getHandleElevation-D9Ej5fM, reason: not valid java name */
    public final float m2502getHandleElevationD9Ej5fM() {
        return HandleElevation;
    }

    /* JADX INFO: renamed from: getHandleHeight-D9Ej5fM, reason: not valid java name */
    public final float m2503getHandleHeightD9Ej5fM() {
        return HandleHeight;
    }

    public final ShapeKeyTokens getHandleShape() {
        return HandleShape;
    }

    /* JADX INFO: renamed from: getHandleWidth-D9Ej5fM, reason: not valid java name */
    public final float m2504getHandleWidthD9Ej5fM() {
        return HandleWidth;
    }

    public final ColorSchemeKeyTokens getHoverHandleColor() {
        return HoverHandleColor;
    }

    public final ColorSchemeKeyTokens getInactiveTrackColor() {
        return InactiveTrackColor;
    }

    /* JADX INFO: renamed from: getInactiveTrackHeight-D9Ej5fM, reason: not valid java name */
    public final float m2505getInactiveTrackHeightD9Ej5fM() {
        return InactiveTrackHeight;
    }

    public final ShapeKeyTokens getInactiveTrackShape() {
        return InactiveTrackShape;
    }

    public final ColorSchemeKeyTokens getLabelContainerColor() {
        return LabelContainerColor;
    }

    /* JADX INFO: renamed from: getLabelContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2506getLabelContainerElevationD9Ej5fM() {
        return LabelContainerElevation;
    }

    /* JADX INFO: renamed from: getLabelContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2507getLabelContainerHeightD9Ej5fM() {
        return LabelContainerHeight;
    }

    public final ColorSchemeKeyTokens getLabelTextColor() {
        return LabelTextColor;
    }

    public final TypographyKeyTokens getLabelTextFont() {
        return LabelTextFont;
    }

    public final ColorSchemeKeyTokens getOverlapHandleOutlineColor() {
        return OverlapHandleOutlineColor;
    }

    /* JADX INFO: renamed from: getOverlapHandleOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2508getOverlapHandleOutlineWidthD9Ej5fM() {
        return OverlapHandleOutlineWidth;
    }

    public final ColorSchemeKeyTokens getPressedHandleColor() {
        return PressedHandleColor;
    }

    /* JADX INFO: renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m2509getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }

    public final ColorSchemeKeyTokens getTickMarksActiveContainerColor() {
        return TickMarksActiveContainerColor;
    }

    public final ShapeKeyTokens getTickMarksContainerShape() {
        return TickMarksContainerShape;
    }

    /* JADX INFO: renamed from: getTickMarksContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m2510getTickMarksContainerSizeD9Ej5fM() {
        return TickMarksContainerSize;
    }

    public final ColorSchemeKeyTokens getTickMarksDisabledContainerColor() {
        return TickMarksDisabledContainerColor;
    }

    public final ColorSchemeKeyTokens getTickMarksInactiveContainerColor() {
        return TickMarksInactiveContainerColor;
    }

    /* JADX INFO: renamed from: getTrackElevation-D9Ej5fM, reason: not valid java name */
    public final float m2511getTrackElevationD9Ej5fM() {
        return TrackElevation;
    }
}
