package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerTokens {
    private static final ColorSchemeKeyTokens ClockDialColor;
    private static final float ClockDialContainerSize;
    private static final TypographyKeyTokens ClockDialLabelTextFont;
    private static final ColorSchemeKeyTokens ClockDialSelectedLabelTextColor;
    private static final ColorSchemeKeyTokens ClockDialSelectorCenterContainerColor;
    private static final ShapeKeyTokens ClockDialSelectorCenterContainerShape;
    private static final float ClockDialSelectorCenterContainerSize;
    private static final ColorSchemeKeyTokens ClockDialSelectorHandleContainerColor;
    private static final ShapeKeyTokens ClockDialSelectorHandleContainerShape;
    private static final float ClockDialSelectorHandleContainerSize;
    private static final ColorSchemeKeyTokens ClockDialSelectorTrackContainerColor;
    private static final float ClockDialSelectorTrackContainerWidth;
    private static final ShapeKeyTokens ClockDialShape;
    private static final ColorSchemeKeyTokens ClockDialUnselectedLabelTextColor;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens HeadlineColor;
    private static final TypographyKeyTokens HeadlineFont;
    public static final TimePickerTokens INSTANCE = new TimePickerTokens();
    private static final ShapeKeyTokens PeriodSelectorContainerShape;
    private static final float PeriodSelectorHorizontalContainerHeight;
    private static final float PeriodSelectorHorizontalContainerWidth;
    private static final TypographyKeyTokens PeriodSelectorLabelTextFont;
    private static final ColorSchemeKeyTokens PeriodSelectorOutlineColor;
    private static final float PeriodSelectorOutlineWidth;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedContainerColor;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedFocusLabelTextColor;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedHoverLabelTextColor;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedLabelTextColor;
    private static final ColorSchemeKeyTokens PeriodSelectorSelectedPressedLabelTextColor;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedFocusLabelTextColor;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedHoverLabelTextColor;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedLabelTextColor;
    private static final ColorSchemeKeyTokens PeriodSelectorUnselectedPressedLabelTextColor;
    private static final float PeriodSelectorVerticalContainerHeight;
    private static final float PeriodSelectorVerticalContainerWidth;
    private static final ColorSchemeKeyTokens SurfaceTintLayerColor;
    private static final float TimeSelector24HVerticalContainerWidth;
    private static final float TimeSelectorContainerHeight;
    private static final ShapeKeyTokens TimeSelectorContainerShape;
    private static final float TimeSelectorContainerWidth;
    private static final TypographyKeyTokens TimeSelectorLabelTextFont;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedContainerColor;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedFocusLabelTextColor;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedHoverLabelTextColor;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedLabelTextColor;
    private static final ColorSchemeKeyTokens TimeSelectorSelectedPressedLabelTextColor;
    private static final ColorSchemeKeyTokens TimeSelectorSeparatorColor;
    private static final TypographyKeyTokens TimeSelectorSeparatorFont;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedContainerColor;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedFocusLabelTextColor;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedHoverLabelTextColor;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedLabelTextColor;
    private static final ColorSchemeKeyTokens TimeSelectorUnselectedPressedLabelTextColor;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.SurfaceVariant;
        ClockDialColor = colorSchemeKeyTokens;
        ClockDialContainerSize = Dp.m5160constructorimpl((float) 256.0d);
        ClockDialLabelTextFont = TypographyKeyTokens.BodyLarge;
        ClockDialSelectedLabelTextColor = ColorSchemeKeyTokens.OnPrimary;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.Primary;
        ClockDialSelectorCenterContainerColor = colorSchemeKeyTokens2;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        ClockDialSelectorCenterContainerShape = shapeKeyTokens;
        ClockDialSelectorCenterContainerSize = Dp.m5160constructorimpl((float) 8.0d);
        ClockDialSelectorHandleContainerColor = colorSchemeKeyTokens2;
        ClockDialSelectorHandleContainerShape = shapeKeyTokens;
        ClockDialSelectorHandleContainerSize = Dp.m5160constructorimpl((float) 48.0d);
        ClockDialSelectorTrackContainerColor = colorSchemeKeyTokens2;
        ClockDialSelectorTrackContainerWidth = Dp.m5160constructorimpl((float) 2.0d);
        ClockDialShape = shapeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurface;
        ClockDialUnselectedLabelTextColor = colorSchemeKeyTokens3;
        ContainerColor = ColorSchemeKeyTokens.Surface;
        ContainerElevation = ElevationTokens.INSTANCE.m2207getLevel3D9Ej5fM();
        ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        ColorSchemeKeyTokens colorSchemeKeyTokens4 = ColorSchemeKeyTokens.OnSurfaceVariant;
        HeadlineColor = colorSchemeKeyTokens4;
        HeadlineFont = TypographyKeyTokens.LabelMedium;
        ShapeKeyTokens shapeKeyTokens2 = ShapeKeyTokens.CornerSmall;
        PeriodSelectorContainerShape = shapeKeyTokens2;
        PeriodSelectorHorizontalContainerHeight = Dp.m5160constructorimpl((float) 38.0d);
        PeriodSelectorHorizontalContainerWidth = Dp.m5160constructorimpl((float) 216.0d);
        PeriodSelectorLabelTextFont = TypographyKeyTokens.TitleMedium;
        PeriodSelectorOutlineColor = ColorSchemeKeyTokens.Outline;
        PeriodSelectorOutlineWidth = Dp.m5160constructorimpl((float) 1.0d);
        PeriodSelectorSelectedContainerColor = ColorSchemeKeyTokens.TertiaryContainer;
        ColorSchemeKeyTokens colorSchemeKeyTokens5 = ColorSchemeKeyTokens.OnTertiaryContainer;
        PeriodSelectorSelectedFocusLabelTextColor = colorSchemeKeyTokens5;
        PeriodSelectorSelectedHoverLabelTextColor = colorSchemeKeyTokens5;
        PeriodSelectorSelectedLabelTextColor = colorSchemeKeyTokens5;
        PeriodSelectorSelectedPressedLabelTextColor = colorSchemeKeyTokens5;
        PeriodSelectorUnselectedFocusLabelTextColor = colorSchemeKeyTokens4;
        PeriodSelectorUnselectedHoverLabelTextColor = colorSchemeKeyTokens4;
        PeriodSelectorUnselectedLabelTextColor = colorSchemeKeyTokens4;
        PeriodSelectorUnselectedPressedLabelTextColor = colorSchemeKeyTokens4;
        float f = (float) 80.0d;
        PeriodSelectorVerticalContainerHeight = Dp.m5160constructorimpl(f);
        PeriodSelectorVerticalContainerWidth = Dp.m5160constructorimpl((float) 52.0d);
        SurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
        TimeSelector24HVerticalContainerWidth = Dp.m5160constructorimpl((float) 114.0d);
        TimeSelectorContainerHeight = Dp.m5160constructorimpl(f);
        TimeSelectorContainerShape = shapeKeyTokens2;
        TimeSelectorContainerWidth = Dp.m5160constructorimpl((float) 96.0d);
        TypographyKeyTokens typographyKeyTokens = TypographyKeyTokens.DisplayLarge;
        TimeSelectorLabelTextFont = typographyKeyTokens;
        TimeSelectorSelectedContainerColor = ColorSchemeKeyTokens.PrimaryContainer;
        ColorSchemeKeyTokens colorSchemeKeyTokens6 = ColorSchemeKeyTokens.OnPrimaryContainer;
        TimeSelectorSelectedFocusLabelTextColor = colorSchemeKeyTokens6;
        TimeSelectorSelectedHoverLabelTextColor = colorSchemeKeyTokens6;
        TimeSelectorSelectedLabelTextColor = colorSchemeKeyTokens6;
        TimeSelectorSelectedPressedLabelTextColor = colorSchemeKeyTokens6;
        TimeSelectorSeparatorColor = colorSchemeKeyTokens3;
        TimeSelectorSeparatorFont = typographyKeyTokens;
        TimeSelectorUnselectedContainerColor = colorSchemeKeyTokens;
        TimeSelectorUnselectedFocusLabelTextColor = colorSchemeKeyTokens3;
        TimeSelectorUnselectedHoverLabelTextColor = colorSchemeKeyTokens3;
        TimeSelectorUnselectedLabelTextColor = colorSchemeKeyTokens3;
        TimeSelectorUnselectedPressedLabelTextColor = colorSchemeKeyTokens3;
    }

    private TimePickerTokens() {
    }

    public final ColorSchemeKeyTokens getClockDialColor() {
        return ClockDialColor;
    }

    /* JADX INFO: renamed from: getClockDialContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m2549getClockDialContainerSizeD9Ej5fM() {
        return ClockDialContainerSize;
    }

    public final TypographyKeyTokens getClockDialLabelTextFont() {
        return ClockDialLabelTextFont;
    }

    public final ColorSchemeKeyTokens getClockDialSelectedLabelTextColor() {
        return ClockDialSelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getClockDialSelectorCenterContainerColor() {
        return ClockDialSelectorCenterContainerColor;
    }

    public final ShapeKeyTokens getClockDialSelectorCenterContainerShape() {
        return ClockDialSelectorCenterContainerShape;
    }

    /* JADX INFO: renamed from: getClockDialSelectorCenterContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m2550getClockDialSelectorCenterContainerSizeD9Ej5fM() {
        return ClockDialSelectorCenterContainerSize;
    }

    public final ColorSchemeKeyTokens getClockDialSelectorHandleContainerColor() {
        return ClockDialSelectorHandleContainerColor;
    }

    public final ShapeKeyTokens getClockDialSelectorHandleContainerShape() {
        return ClockDialSelectorHandleContainerShape;
    }

    /* JADX INFO: renamed from: getClockDialSelectorHandleContainerSize-D9Ej5fM, reason: not valid java name */
    public final float m2551getClockDialSelectorHandleContainerSizeD9Ej5fM() {
        return ClockDialSelectorHandleContainerSize;
    }

    public final ColorSchemeKeyTokens getClockDialSelectorTrackContainerColor() {
        return ClockDialSelectorTrackContainerColor;
    }

    /* JADX INFO: renamed from: getClockDialSelectorTrackContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2552getClockDialSelectorTrackContainerWidthD9Ej5fM() {
        return ClockDialSelectorTrackContainerWidth;
    }

    public final ShapeKeyTokens getClockDialShape() {
        return ClockDialShape;
    }

    public final ColorSchemeKeyTokens getClockDialUnselectedLabelTextColor() {
        return ClockDialUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2553getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getHeadlineColor() {
        return HeadlineColor;
    }

    public final TypographyKeyTokens getHeadlineFont() {
        return HeadlineFont;
    }

    public final ShapeKeyTokens getPeriodSelectorContainerShape() {
        return PeriodSelectorContainerShape;
    }

    /* JADX INFO: renamed from: getPeriodSelectorHorizontalContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2554getPeriodSelectorHorizontalContainerHeightD9Ej5fM() {
        return PeriodSelectorHorizontalContainerHeight;
    }

    /* JADX INFO: renamed from: getPeriodSelectorHorizontalContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2555getPeriodSelectorHorizontalContainerWidthD9Ej5fM() {
        return PeriodSelectorHorizontalContainerWidth;
    }

    public final TypographyKeyTokens getPeriodSelectorLabelTextFont() {
        return PeriodSelectorLabelTextFont;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorOutlineColor() {
        return PeriodSelectorOutlineColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2556getPeriodSelectorOutlineWidthD9Ej5fM() {
        return PeriodSelectorOutlineWidth;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedContainerColor() {
        return PeriodSelectorSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedFocusLabelTextColor() {
        return PeriodSelectorSelectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedHoverLabelTextColor() {
        return PeriodSelectorSelectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedLabelTextColor() {
        return PeriodSelectorSelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorSelectedPressedLabelTextColor() {
        return PeriodSelectorSelectedPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedFocusLabelTextColor() {
        return PeriodSelectorUnselectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedHoverLabelTextColor() {
        return PeriodSelectorUnselectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedLabelTextColor() {
        return PeriodSelectorUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getPeriodSelectorUnselectedPressedLabelTextColor() {
        return PeriodSelectorUnselectedPressedLabelTextColor;
    }

    /* JADX INFO: renamed from: getPeriodSelectorVerticalContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2557getPeriodSelectorVerticalContainerHeightD9Ej5fM() {
        return PeriodSelectorVerticalContainerHeight;
    }

    /* JADX INFO: renamed from: getPeriodSelectorVerticalContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2558getPeriodSelectorVerticalContainerWidthD9Ej5fM() {
        return PeriodSelectorVerticalContainerWidth;
    }

    public final ColorSchemeKeyTokens getSurfaceTintLayerColor() {
        return SurfaceTintLayerColor;
    }

    /* JADX INFO: renamed from: getTimeSelector24HVerticalContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2559getTimeSelector24HVerticalContainerWidthD9Ej5fM() {
        return TimeSelector24HVerticalContainerWidth;
    }

    /* JADX INFO: renamed from: getTimeSelectorContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2560getTimeSelectorContainerHeightD9Ej5fM() {
        return TimeSelectorContainerHeight;
    }

    public final ShapeKeyTokens getTimeSelectorContainerShape() {
        return TimeSelectorContainerShape;
    }

    /* JADX INFO: renamed from: getTimeSelectorContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2561getTimeSelectorContainerWidthD9Ej5fM() {
        return TimeSelectorContainerWidth;
    }

    public final TypographyKeyTokens getTimeSelectorLabelTextFont() {
        return TimeSelectorLabelTextFont;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedContainerColor() {
        return TimeSelectorSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedFocusLabelTextColor() {
        return TimeSelectorSelectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedHoverLabelTextColor() {
        return TimeSelectorSelectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedLabelTextColor() {
        return TimeSelectorSelectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSelectedPressedLabelTextColor() {
        return TimeSelectorSelectedPressedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorSeparatorColor() {
        return TimeSelectorSeparatorColor;
    }

    public final TypographyKeyTokens getTimeSelectorSeparatorFont() {
        return TimeSelectorSeparatorFont;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedContainerColor() {
        return TimeSelectorUnselectedContainerColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedFocusLabelTextColor() {
        return TimeSelectorUnselectedFocusLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedHoverLabelTextColor() {
        return TimeSelectorUnselectedHoverLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedLabelTextColor() {
        return TimeSelectorUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getTimeSelectorUnselectedPressedLabelTextColor() {
        return TimeSelectorUnselectedPressedLabelTextColor;
    }
}
