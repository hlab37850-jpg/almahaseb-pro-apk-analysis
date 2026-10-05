package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerModalTokens {
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens ContainerSurfaceTintLayerColor;
    private static final float ContainerWidth;
    private static final float DateContainerHeight;
    private static final ShapeKeyTokens DateContainerShape;
    private static final float DateContainerWidth;
    private static final TypographyKeyTokens DateLabelTextFont;
    private static final ColorSchemeKeyTokens DateSelectedContainerColor;
    private static final ColorSchemeKeyTokens DateSelectedLabelTextColor;
    private static final float DateStateLayerHeight;
    private static final ShapeKeyTokens DateStateLayerShape;
    private static final float DateStateLayerWidth;
    private static final ColorSchemeKeyTokens DateTodayContainerOutlineColor;
    private static final float DateTodayContainerOutlineWidth;
    private static final ColorSchemeKeyTokens DateTodayLabelTextColor;
    private static final ColorSchemeKeyTokens DateUnselectedLabelTextColor;
    private static final float HeaderContainerHeight;
    private static final float HeaderContainerWidth;
    private static final ColorSchemeKeyTokens HeaderHeadlineColor;
    private static final TypographyKeyTokens HeaderHeadlineFont;
    private static final ColorSchemeKeyTokens HeaderSupportingTextColor;
    private static final TypographyKeyTokens HeaderSupportingTextFont;
    private static final ColorSchemeKeyTokens RangeSelectionActiveIndicatorContainerColor;
    private static final float RangeSelectionActiveIndicatorContainerHeight;
    private static final ShapeKeyTokens RangeSelectionActiveIndicatorContainerShape;
    private static final float RangeSelectionContainerElevation;
    private static final ShapeKeyTokens RangeSelectionContainerShape;
    private static final float RangeSelectionHeaderContainerHeight;
    private static final TypographyKeyTokens RangeSelectionHeaderHeadlineFont;
    private static final ColorSchemeKeyTokens RangeSelectionMonthSubheadColor;
    private static final TypographyKeyTokens RangeSelectionMonthSubheadFont;
    private static final ColorSchemeKeyTokens SelectionDateInRangeLabelTextColor;
    private static final float SelectionYearContainerHeight;
    private static final float SelectionYearContainerWidth;
    private static final TypographyKeyTokens SelectionYearLabelTextFont;
    private static final ColorSchemeKeyTokens SelectionYearSelectedContainerColor;
    private static final ColorSchemeKeyTokens SelectionYearSelectedLabelTextColor;
    private static final float SelectionYearStateLayerHeight;
    private static final ShapeKeyTokens SelectionYearStateLayerShape;
    private static final float SelectionYearStateLayerWidth;
    private static final ColorSchemeKeyTokens SelectionYearUnselectedLabelTextColor;
    private static final ColorSchemeKeyTokens WeekdaysLabelTextColor;
    private static final TypographyKeyTokens WeekdaysLabelTextFont;
    public static final DatePickerModalTokens INSTANCE = new DatePickerModalTokens();
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.Surface;

    static {
        ElevationTokens elevationTokens = ElevationTokens.INSTANCE;
        ContainerElevation = elevationTokens.m2207getLevel3D9Ej5fM();
        ContainerHeight = Dp.m5160constructorimpl((float) 568.0d);
        ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
        float f = (float) 360.0d;
        ContainerWidth = Dp.m5160constructorimpl(f);
        float f2 = (float) 40.0d;
        DateContainerHeight = Dp.m5160constructorimpl(f2);
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        DateContainerShape = shapeKeyTokens;
        DateContainerWidth = Dp.m5160constructorimpl(f2);
        TypographyKeyTokens typographyKeyTokens = TypographyKeyTokens.BodyLarge;
        DateLabelTextFont = typographyKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        DateSelectedContainerColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnPrimary;
        DateSelectedLabelTextColor = colorSchemeKeyTokens2;
        DateStateLayerHeight = Dp.m5160constructorimpl(f2);
        DateStateLayerShape = shapeKeyTokens;
        DateStateLayerWidth = Dp.m5160constructorimpl(f2);
        DateTodayContainerOutlineColor = colorSchemeKeyTokens;
        DateTodayContainerOutlineWidth = Dp.m5160constructorimpl((float) 1.0d);
        DateTodayLabelTextColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens3 = ColorSchemeKeyTokens.OnSurface;
        DateUnselectedLabelTextColor = colorSchemeKeyTokens3;
        HeaderContainerHeight = Dp.m5160constructorimpl((float) 120.0d);
        HeaderContainerWidth = Dp.m5160constructorimpl(f);
        ColorSchemeKeyTokens colorSchemeKeyTokens4 = ColorSchemeKeyTokens.OnSurfaceVariant;
        HeaderHeadlineColor = colorSchemeKeyTokens4;
        HeaderHeadlineFont = TypographyKeyTokens.HeadlineLarge;
        HeaderSupportingTextColor = colorSchemeKeyTokens4;
        HeaderSupportingTextFont = TypographyKeyTokens.LabelLarge;
        RangeSelectionActiveIndicatorContainerColor = ColorSchemeKeyTokens.SecondaryContainer;
        RangeSelectionActiveIndicatorContainerHeight = Dp.m5160constructorimpl(f2);
        RangeSelectionActiveIndicatorContainerShape = shapeKeyTokens;
        RangeSelectionContainerElevation = elevationTokens.m2204getLevel0D9Ej5fM();
        RangeSelectionContainerShape = ShapeKeyTokens.CornerNone;
        SelectionDateInRangeLabelTextColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        RangeSelectionHeaderContainerHeight = Dp.m5160constructorimpl((float) 128.0d);
        RangeSelectionHeaderHeadlineFont = TypographyKeyTokens.TitleLarge;
        RangeSelectionMonthSubheadColor = colorSchemeKeyTokens4;
        RangeSelectionMonthSubheadFont = TypographyKeyTokens.TitleSmall;
        WeekdaysLabelTextColor = colorSchemeKeyTokens3;
        WeekdaysLabelTextFont = typographyKeyTokens;
        float f3 = (float) 36.0d;
        SelectionYearContainerHeight = Dp.m5160constructorimpl(f3);
        float f4 = (float) 72.0d;
        SelectionYearContainerWidth = Dp.m5160constructorimpl(f4);
        SelectionYearLabelTextFont = typographyKeyTokens;
        SelectionYearSelectedContainerColor = colorSchemeKeyTokens;
        SelectionYearSelectedLabelTextColor = colorSchemeKeyTokens2;
        SelectionYearStateLayerHeight = Dp.m5160constructorimpl(f3);
        SelectionYearStateLayerShape = shapeKeyTokens;
        SelectionYearStateLayerWidth = Dp.m5160constructorimpl(f4);
        SelectionYearUnselectedLabelTextColor = colorSchemeKeyTokens4;
    }

    private DatePickerModalTokens() {
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2170getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2171getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getContainerSurfaceTintLayerColor() {
        return ContainerSurfaceTintLayerColor;
    }

    /* JADX INFO: renamed from: getContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2172getContainerWidthD9Ej5fM() {
        return ContainerWidth;
    }

    /* JADX INFO: renamed from: getDateContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2173getDateContainerHeightD9Ej5fM() {
        return DateContainerHeight;
    }

    public final ShapeKeyTokens getDateContainerShape() {
        return DateContainerShape;
    }

    /* JADX INFO: renamed from: getDateContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2174getDateContainerWidthD9Ej5fM() {
        return DateContainerWidth;
    }

    public final TypographyKeyTokens getDateLabelTextFont() {
        return DateLabelTextFont;
    }

    public final ColorSchemeKeyTokens getDateSelectedContainerColor() {
        return DateSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getDateSelectedLabelTextColor() {
        return DateSelectedLabelTextColor;
    }

    /* JADX INFO: renamed from: getDateStateLayerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2175getDateStateLayerHeightD9Ej5fM() {
        return DateStateLayerHeight;
    }

    public final ShapeKeyTokens getDateStateLayerShape() {
        return DateStateLayerShape;
    }

    /* JADX INFO: renamed from: getDateStateLayerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2176getDateStateLayerWidthD9Ej5fM() {
        return DateStateLayerWidth;
    }

    public final ColorSchemeKeyTokens getDateTodayContainerOutlineColor() {
        return DateTodayContainerOutlineColor;
    }

    /* JADX INFO: renamed from: getDateTodayContainerOutlineWidth-D9Ej5fM, reason: not valid java name */
    public final float m2177getDateTodayContainerOutlineWidthD9Ej5fM() {
        return DateTodayContainerOutlineWidth;
    }

    public final ColorSchemeKeyTokens getDateTodayLabelTextColor() {
        return DateTodayLabelTextColor;
    }

    public final ColorSchemeKeyTokens getDateUnselectedLabelTextColor() {
        return DateUnselectedLabelTextColor;
    }

    /* JADX INFO: renamed from: getHeaderContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2178getHeaderContainerHeightD9Ej5fM() {
        return HeaderContainerHeight;
    }

    /* JADX INFO: renamed from: getHeaderContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2179getHeaderContainerWidthD9Ej5fM() {
        return HeaderContainerWidth;
    }

    public final ColorSchemeKeyTokens getHeaderHeadlineColor() {
        return HeaderHeadlineColor;
    }

    public final TypographyKeyTokens getHeaderHeadlineFont() {
        return HeaderHeadlineFont;
    }

    public final ColorSchemeKeyTokens getHeaderSupportingTextColor() {
        return HeaderSupportingTextColor;
    }

    public final TypographyKeyTokens getHeaderSupportingTextFont() {
        return HeaderSupportingTextFont;
    }

    public final ColorSchemeKeyTokens getRangeSelectionActiveIndicatorContainerColor() {
        return RangeSelectionActiveIndicatorContainerColor;
    }

    /* JADX INFO: renamed from: getRangeSelectionActiveIndicatorContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2180getRangeSelectionActiveIndicatorContainerHeightD9Ej5fM() {
        return RangeSelectionActiveIndicatorContainerHeight;
    }

    public final ShapeKeyTokens getRangeSelectionActiveIndicatorContainerShape() {
        return RangeSelectionActiveIndicatorContainerShape;
    }

    /* JADX INFO: renamed from: getRangeSelectionContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2181getRangeSelectionContainerElevationD9Ej5fM() {
        return RangeSelectionContainerElevation;
    }

    public final ShapeKeyTokens getRangeSelectionContainerShape() {
        return RangeSelectionContainerShape;
    }

    /* JADX INFO: renamed from: getRangeSelectionHeaderContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() {
        return RangeSelectionHeaderContainerHeight;
    }

    public final TypographyKeyTokens getRangeSelectionHeaderHeadlineFont() {
        return RangeSelectionHeaderHeadlineFont;
    }

    public final ColorSchemeKeyTokens getRangeSelectionMonthSubheadColor() {
        return RangeSelectionMonthSubheadColor;
    }

    public final TypographyKeyTokens getRangeSelectionMonthSubheadFont() {
        return RangeSelectionMonthSubheadFont;
    }

    public final ColorSchemeKeyTokens getSelectionDateInRangeLabelTextColor() {
        return SelectionDateInRangeLabelTextColor;
    }

    /* JADX INFO: renamed from: getSelectionYearContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2183getSelectionYearContainerHeightD9Ej5fM() {
        return SelectionYearContainerHeight;
    }

    /* JADX INFO: renamed from: getSelectionYearContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2184getSelectionYearContainerWidthD9Ej5fM() {
        return SelectionYearContainerWidth;
    }

    public final TypographyKeyTokens getSelectionYearLabelTextFont() {
        return SelectionYearLabelTextFont;
    }

    public final ColorSchemeKeyTokens getSelectionYearSelectedContainerColor() {
        return SelectionYearSelectedContainerColor;
    }

    public final ColorSchemeKeyTokens getSelectionYearSelectedLabelTextColor() {
        return SelectionYearSelectedLabelTextColor;
    }

    /* JADX INFO: renamed from: getSelectionYearStateLayerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2185getSelectionYearStateLayerHeightD9Ej5fM() {
        return SelectionYearStateLayerHeight;
    }

    public final ShapeKeyTokens getSelectionYearStateLayerShape() {
        return SelectionYearStateLayerShape;
    }

    /* JADX INFO: renamed from: getSelectionYearStateLayerWidth-D9Ej5fM, reason: not valid java name */
    public final float m2186getSelectionYearStateLayerWidthD9Ej5fM() {
        return SelectionYearStateLayerWidth;
    }

    public final ColorSchemeKeyTokens getSelectionYearUnselectedLabelTextColor() {
        return SelectionYearUnselectedLabelTextColor;
    }

    public final ColorSchemeKeyTokens getWeekdaysLabelTextColor() {
        return WeekdaysLabelTextColor;
    }

    public final TypographyKeyTokens getWeekdaysLabelTextFont() {
        return WeekdaysLabelTextFont;
    }
}
