package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.MathHelpersKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final InterfaceC3750qp onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14321 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C14321 INSTANCE = new C14321();

        public C14321() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14331 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C14331 INSTANCE = new C14331();

        public C14331() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14341 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C14341 INSTANCE = new C14341();

        public C14341() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasurable, "intrinsicMeasurable");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i));
        }
    }

    public OutlinedTextFieldMeasurePolicy(InterfaceC3750qp interfaceC3750qp, boolean z, float f, PaddingValues paddingValues) {
        AbstractC4492zt.h(interfaceC3750qp, "onLabelMeasured");
        AbstractC4492zt.h(paddingValues, "paddingValues");
        this.onLabelMeasured = interfaceC3750qp;
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, InterfaceC0526Fp interfaceC0526Fp) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj2 : list2) {
            if (AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "TextField")) {
                int iIntValue = ((Number) interfaceC0526Fp.mo13invoke(obj2, Integer.valueOf(i))).intValue();
                Iterator<T> it = list2.iterator();
                do {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Label"));
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it2 = list2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), "Trailing"));
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable2, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it3 = list2.iterator();
                do {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), "Leading"));
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
                for (Object obj3 : list2) {
                    if (AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Hint")) {
                        obj = obj3;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.m1170calculateHeightO3s9Psw(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable4 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, InterfaceC0526Fp interfaceC0526Fp) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj2 : list2) {
            if (AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), "TextField")) {
                int iIntValue = ((Number) interfaceC0526Fp.mo13invoke(obj2, Integer.valueOf(i))).intValue();
                Iterator<T> it = list2.iterator();
                do {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Label"));
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) next;
                int iIntValue2 = intrinsicMeasurable != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it2 = list2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next2), "Trailing"));
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) next2;
                int iIntValue3 = intrinsicMeasurable2 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable2, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it3 = list2.iterator();
                do {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), "Leading"));
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
                for (Object obj3 : list2) {
                    if (AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Hint")) {
                        obj = obj3;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.m1171calculateWidthO3s9Psw(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable4 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0, this.animationProgress, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i, AnonymousClass1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, list, i, C14321.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(list, "measurables");
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(this.paddingValues.mo435calculateBottomPaddingD9Ej5fM());
        long jM5119copyZbe2FdA$default = Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        Iterator<T> it = list2.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next), "Leading"));
        Measurable measurable = (Measurable) next;
        Placeable placeableMo4159measureBRTryo0 = measurable != null ? measurable.mo4159measureBRTryo0(jM5119copyZbe2FdA$default) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo0);
        Iterator<T> it2 = list2.iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next2), "Trailing"));
        Measurable measurable2 = (Measurable) next2;
        Placeable placeableMo4159measureBRTryo1 = measurable2 != null ? measurable2.mo4159measureBRTryo0(ConstraintsKt.m5145offsetNN6EwU$default(jM5119copyZbe2FdA$default, -iWidthOrZero, 0, 2, null)) : null;
        int iWidthOrZero2 = iWidthOrZero + TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo1);
        int iMo327roundToPx0680j_5 = measureScope.mo327roundToPx0680j_4(this.paddingValues.mo436calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo327roundToPx0680j_4(this.paddingValues.mo437calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int i = -iWidthOrZero2;
        int i2 = -iMo327roundToPx0680j_4;
        long jM5144offsetNN6EwU = ConstraintsKt.m5144offsetNN6EwU(jM5119copyZbe2FdA$default, MathHelpersKt.lerp(i - iMo327roundToPx0680j_5, -iMo327roundToPx0680j_5, this.animationProgress), i2);
        Iterator<T> it3 = list2.iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next3), "Label"));
        Measurable measurable3 = (Measurable) next3;
        Placeable placeableMo4159measureBRTryo2 = measurable3 != null ? measurable3.mo4159measureBRTryo0(jM5144offsetNN6EwU) : null;
        if (placeableMo4159measureBRTryo2 != null) {
            this.onLabelMeasured.invoke(Size.m2855boximpl(SizeKt.Size(placeableMo4159measureBRTryo2.getWidth(), placeableMo4159measureBRTryo2.getHeight())));
        }
        long jM5119copyZbe2FdA$default2 = Constraints.m5119copyZbe2FdA$default(ConstraintsKt.m5144offsetNN6EwU(j, i, i2 - Math.max(TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo2) / 2, measureScope.mo327roundToPx0680j_4(this.paddingValues.mo438calculateTopPaddingD9Ej5fM()))), 0, 0, 0, 0, 11, null);
        for (Measurable measurable4 : list2) {
            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable4), "TextField")) {
                Placeable placeableMo4159measureBRTryo3 = measurable4.mo4159measureBRTryo0(jM5119copyZbe2FdA$default2);
                long jM5119copyZbe2FdA$default3 = Constraints.m5119copyZbe2FdA$default(jM5119copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
                Iterator<T> it4 = list2.iterator();
                do {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next4), "Hint"));
                Measurable measurable5 = (Measurable) next4;
                Placeable placeableMo4159measureBRTryo4 = measurable5 != null ? measurable5.mo4159measureBRTryo0(jM5119copyZbe2FdA$default3) : null;
                int iM1171calculateWidthO3s9Psw = OutlinedTextFieldKt.m1171calculateWidthO3s9Psw(TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo1), placeableMo4159measureBRTryo3.getWidth(), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo2), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo4), this.animationProgress, j, measureScope.getDensity(), this.paddingValues);
                int iM1170calculateHeightO3s9Psw = OutlinedTextFieldKt.m1170calculateHeightO3s9Psw(TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo1), placeableMo4159measureBRTryo3.getHeight(), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo2), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo4), this.animationProgress, j, measureScope.getDensity(), this.paddingValues);
                for (Measurable measurable6 : list2) {
                    if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable6), "border")) {
                        return MeasureScope.CC.q(measureScope, iM1171calculateWidthO3s9Psw, iM1170calculateHeightO3s9Psw, null, new OutlinedTextFieldMeasurePolicy$measure$2(iM1170calculateHeightO3s9Psw, iM1171calculateWidthO3s9Psw, placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo3, placeableMo4159measureBRTryo2, placeableMo4159measureBRTryo4, measurable6.mo4159measureBRTryo0(ConstraintsKt.Constraints(iM1171calculateWidthO3s9Psw != Integer.MAX_VALUE ? iM1171calculateWidthO3s9Psw : 0, iM1171calculateWidthO3s9Psw, iM1170calculateHeightO3s9Psw != Integer.MAX_VALUE ? iM1170calculateHeightO3s9Psw : 0, iM1170calculateHeightO3s9Psw)), this, measureScope), 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i, C14331.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, list, i, C14341.INSTANCE);
    }
}
