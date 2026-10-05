package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PaddingKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.PaddingKt$padding$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $bottom;
        final /* synthetic */ float $end;
        final /* synthetic */ float $start;
        final /* synthetic */ float $top;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f, float f2, float f3, float f4) {
            super(1);
            this.$start = f;
            this.$top = f2;
            this.$end = f3;
            this.$bottom = f4;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName(CSS.Property.PADDING);
            inspectorInfo.getProperties().set(HTML.Attribute.START, Dp.m5158boximpl(this.$start));
            inspectorInfo.getProperties().set("top", Dp.m5158boximpl(this.$top));
            inspectorInfo.getProperties().set("end", Dp.m5158boximpl(this.$end));
            inspectorInfo.getProperties().set("bottom", Dp.m5158boximpl(this.$bottom));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.PaddingKt$padding$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $horizontal;
        final /* synthetic */ float $vertical;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, float f2) {
            super(1);
            this.$horizontal = f;
            this.$vertical = f2;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName(CSS.Property.PADDING);
            inspectorInfo.getProperties().set("horizontal", Dp.m5158boximpl(this.$horizontal));
            inspectorInfo.getProperties().set("vertical", Dp.m5158boximpl(this.$vertical));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.PaddingKt$padding$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ float $all;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(float f) {
            super(1);
            this.$all = f;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName(CSS.Property.PADDING);
            inspectorInfo.setValue(Dp.m5158boximpl(this.$all));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.PaddingKt$padding$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ PaddingValues $paddingValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(PaddingValues paddingValues) {
            super(1);
            this.$paddingValues = paddingValues;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return FW.a;
        }

        public final void invoke(InspectorInfo inspectorInfo) {
            AbstractC4492zt.h(inspectorInfo, "$this$$receiver");
            inspectorInfo.setName(CSS.Property.PADDING);
            inspectorInfo.getProperties().set("paddingValues", this.$paddingValues);
        }
    }

    @Stable
    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m478PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, null);
    }

    @Stable
    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m479PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m480PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5160constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5160constructorimpl(0);
        }
        return m479PaddingValuesYgX7TsA(f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m481PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4, null);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m482PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5160constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5160constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m5160constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5160constructorimpl(0);
        }
        return m481PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    @Stable
    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m483absolutePaddingqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        AbstractC4492zt.h(modifier, "$this$absolutePadding");
        return modifier.then(new PaddingElement(f, f2, f3, f4, false, new PaddingKt$absolutePadding$1(f, f2, f3, f4), null));
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m484absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5160constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5160constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m5160constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5160constructorimpl(0);
        }
        return m483absolutePaddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    @Stable
    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(paddingValues, "<this>");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo437calculateRightPaddingu2uoSUM(layoutDirection) : paddingValues.mo436calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    @Stable
    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(paddingValues, "<this>");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo436calculateLeftPaddingu2uoSUM(layoutDirection) : paddingValues.mo437calculateRightPaddingu2uoSUM(layoutDirection);
    }

    @Stable
    public static final Modifier padding(Modifier modifier, PaddingValues paddingValues) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesElement(paddingValues, new AnonymousClass4(paddingValues)));
    }

    @Stable
    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m485padding3ABfNKs(Modifier modifier, float f) {
        AbstractC4492zt.h(modifier, "$this$padding");
        return modifier.then(new PaddingElement(f, f, f, f, true, new AnonymousClass3(f), null));
    }

    @Stable
    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m486paddingVpY3zN4(Modifier modifier, float f, float f2) {
        AbstractC4492zt.h(modifier, "$this$padding");
        return modifier.then(new PaddingElement(f, f2, f, f2, true, new AnonymousClass2(f, f2), null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m487paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5160constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5160constructorimpl(0);
        }
        return m486paddingVpY3zN4(modifier, f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m488paddingqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        AbstractC4492zt.h(modifier, "$this$padding");
        return modifier.then(new PaddingElement(f, f2, f3, f4, true, new AnonymousClass1(f, f2, f3, f4), null));
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m489paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5160constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m5160constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m5160constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5160constructorimpl(0);
        }
        return m488paddingqDBjuR0(modifier, f, f2, f3, f4);
    }
}
