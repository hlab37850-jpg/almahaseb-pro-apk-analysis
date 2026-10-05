package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class ShapeTokens {
    private static final RoundedCornerShape CornerExtraLarge;
    private static final RoundedCornerShape CornerExtraLargeTop;
    private static final RoundedCornerShape CornerExtraSmall;
    private static final RoundedCornerShape CornerExtraSmallTop;
    private static final RoundedCornerShape CornerLarge;
    private static final RoundedCornerShape CornerLargeEnd;
    private static final RoundedCornerShape CornerLargeTop;
    public static final ShapeTokens INSTANCE = new ShapeTokens();
    private static final RoundedCornerShape CornerFull = RoundedCornerShapeKt.getCircleShape();
    private static final RoundedCornerShape CornerMedium = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(Dp.m5160constructorimpl((float) 12.0d));
    private static final Shape CornerNone = RectangleShapeKt.getRectangleShape();
    private static final RoundedCornerShape CornerSmall = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(Dp.m5160constructorimpl((float) 8.0d));

    static {
        float f = (float) 28.0d;
        CornerExtraLarge = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(Dp.m5160constructorimpl(f));
        float f2 = (float) 0.0d;
        CornerExtraLargeTop = RoundedCornerShapeKt.m738RoundedCornerShapea9UjIt4(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2));
        float f3 = (float) 4.0d;
        CornerExtraSmall = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(Dp.m5160constructorimpl(f3));
        CornerExtraSmallTop = RoundedCornerShapeKt.m738RoundedCornerShapea9UjIt4(Dp.m5160constructorimpl(f3), Dp.m5160constructorimpl(f3), Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2));
        float f4 = (float) 16.0d;
        CornerLarge = RoundedCornerShapeKt.m737RoundedCornerShape0680j_4(Dp.m5160constructorimpl(f4));
        CornerLargeEnd = RoundedCornerShapeKt.m738RoundedCornerShapea9UjIt4(Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f2));
        CornerLargeTop = RoundedCornerShapeKt.m738RoundedCornerShapea9UjIt4(Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f4), Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2));
    }

    private ShapeTokens() {
    }

    public final RoundedCornerShape getCornerExtraLarge() {
        return CornerExtraLarge;
    }

    public final RoundedCornerShape getCornerExtraLargeTop() {
        return CornerExtraLargeTop;
    }

    public final RoundedCornerShape getCornerExtraSmall() {
        return CornerExtraSmall;
    }

    public final RoundedCornerShape getCornerExtraSmallTop() {
        return CornerExtraSmallTop;
    }

    public final RoundedCornerShape getCornerFull() {
        return CornerFull;
    }

    public final RoundedCornerShape getCornerLarge() {
        return CornerLarge;
    }

    public final RoundedCornerShape getCornerLargeEnd() {
        return CornerLargeEnd;
    }

    public final RoundedCornerShape getCornerLargeTop() {
        return CornerLargeTop;
    }

    public final RoundedCornerShape getCornerMedium() {
        return CornerMedium;
    }

    public final Shape getCornerNone() {
        return CornerNone;
    }

    public final RoundedCornerShape getCornerSmall() {
        return CornerSmall;
    }
}
