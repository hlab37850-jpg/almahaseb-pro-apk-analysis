package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
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
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15851 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C15851 INSTANCE = new C15851();

        public C15851() {
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

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15861 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C15861 INSTANCE = new C15861();

        public C15861() {
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

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15871 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C15871 INSTANCE = new C15871();

        public C15871() {
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

    public TextFieldMeasurePolicy(boolean z, float f, PaddingValues paddingValues) {
        AbstractC4492zt.h(paddingValues, "paddingValues");
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, InterfaceC0526Fp interfaceC0526Fp) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Object next6;
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
                Iterator<T> it4 = list2.iterator();
                do {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), TextFieldImplKt.PrefixId));
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) next4;
                int iIntValue5 = intrinsicMeasurable4 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it5 = list2.iterator();
                do {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next5), TextFieldImplKt.SuffixId));
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) next5;
                int iIntValue6 = intrinsicMeasurable5 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it6 = list2.iterator();
                do {
                    if (!it6.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it6.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next6), "Hint"));
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) next6;
                int iIntValue7 = intrinsicMeasurable6 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable6, Integer.valueOf(i))).intValue() : 0;
                for (Object obj3 : list2) {
                    if (AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), TextFieldImplKt.SupportingId)) {
                        obj = obj3;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable7 = (IntrinsicMeasurable) obj;
                return TextFieldKt.m1926calculateHeightmKXJcVc(iIntValue, iIntValue2, iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue7, intrinsicMeasurable7 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable7, Integer.valueOf(i))).intValue() : 0, this.animationProgress == 1.0f, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> list, int i, InterfaceC0526Fp interfaceC0526Fp) {
        Object obj;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
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
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next3), TextFieldImplKt.PrefixId));
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) next3;
                int iIntValue4 = intrinsicMeasurable3 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it4 = list2.iterator();
                do {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next4), TextFieldImplKt.SuffixId));
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) next4;
                int iIntValue5 = intrinsicMeasurable4 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0;
                Iterator<T> it5 = list2.iterator();
                do {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                } while (!AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next5), "Leading"));
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) next5;
                int iIntValue6 = intrinsicMeasurable5 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue() : 0;
                for (Object obj3 : list2) {
                    if (AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Hint")) {
                        obj = obj3;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj;
                return TextFieldKt.m1927calculateWidthyeHjK3Y(iIntValue6, iIntValue3, iIntValue4, iIntValue5, iIntValue, iIntValue2, intrinsicMeasurable6 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable6, Integer.valueOf(i))).intValue() : 0, TextFieldImplKt.getZeroConstraints());
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
        return intrinsicWidth(list, i, C15851.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        Object obj;
        Object next6;
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(list, "measurables");
        int iMo327roundToPx0680j_4 = measureScope.mo327roundToPx0680j_4(this.paddingValues.mo438calculateTopPaddingD9Ej5fM());
        int iMo327roundToPx0680j_5 = measureScope.mo327roundToPx0680j_4(this.paddingValues.mo435calculateBottomPaddingD9Ej5fM());
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
        int iMax = Math.max(0, TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo0));
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
        int iMax2 = Math.max(iMax, TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo1));
        Iterator<T> it3 = list2.iterator();
        do {
            if (!it3.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it3.next();
        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next3), TextFieldImplKt.PrefixId));
        Measurable measurable3 = (Measurable) next3;
        Placeable placeableMo4159measureBRTryo2 = measurable3 != null ? measurable3.mo4159measureBRTryo0(ConstraintsKt.m5145offsetNN6EwU$default(jM5119copyZbe2FdA$default, -iWidthOrZero2, 0, 2, null)) : null;
        int iWidthOrZero3 = iWidthOrZero2 + TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo2);
        int iMax3 = Math.max(iMax2, TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo2));
        Iterator<T> it4 = list2.iterator();
        do {
            if (!it4.hasNext()) {
                next4 = null;
                break;
            }
            next4 = it4.next();
        } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next4), TextFieldImplKt.SuffixId));
        Measurable measurable4 = (Measurable) next4;
        Placeable placeableMo4159measureBRTryo3 = measurable4 != null ? measurable4.mo4159measureBRTryo0(ConstraintsKt.m5145offsetNN6EwU$default(jM5119copyZbe2FdA$default, -iWidthOrZero3, 0, 2, null)) : null;
        int iWidthOrZero4 = iWidthOrZero3 + TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo3);
        int iMax4 = Math.max(iMax3, TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo3));
        int i = -iWidthOrZero4;
        long jM5144offsetNN6EwU = ConstraintsKt.m5144offsetNN6EwU(jM5119copyZbe2FdA$default, i, -iMo327roundToPx0680j_5);
        Iterator it5 = list2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next5 = null;
                break;
            }
            next5 = it5.next();
            Iterator it6 = it5;
            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next5), "Label")) {
                break;
            }
            it5 = it6;
        }
        Measurable measurable5 = (Measurable) next5;
        Placeable placeableMo4159measureBRTryo4 = measurable5 != null ? measurable5.mo4159measureBRTryo0(jM5144offsetNN6EwU) : null;
        int iHeightOrZero = TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo4) + iMo327roundToPx0680j_4;
        long jM5144offsetNN6EwU2 = ConstraintsKt.m5144offsetNN6EwU(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null), i, (-iHeightOrZero) - iMo327roundToPx0680j_5);
        Iterator it7 = list2.iterator();
        while (true) {
            int i2 = iMo327roundToPx0680j_4;
            if (!it7.hasNext()) {
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            Measurable measurable6 = (Measurable) it7.next();
            Iterator it8 = it7;
            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable6), "TextField")) {
                Placeable placeableMo4159measureBRTryo5 = measurable6.mo4159measureBRTryo0(jM5144offsetNN6EwU2);
                long jM5119copyZbe2FdA$default2 = Constraints.m5119copyZbe2FdA$default(jM5144offsetNN6EwU2, 0, 0, 0, 0, 14, null);
                Iterator it9 = list2.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next7 = it9.next();
                    Iterator it10 = it9;
                    if (AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next7), "Hint")) {
                        obj = next7;
                        break;
                    }
                    it9 = it10;
                }
                Measurable measurable7 = (Measurable) obj;
                Placeable placeableMo4159measureBRTryo6 = measurable7 != null ? measurable7.mo4159measureBRTryo0(jM5119copyZbe2FdA$default2) : null;
                long jM5119copyZbe2FdA$default3 = Constraints.m5119copyZbe2FdA$default(ConstraintsKt.m5145offsetNN6EwU$default(jM5119copyZbe2FdA$default, 0, -Math.max(iMax4, Math.max(TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo5), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo6)) + iHeightOrZero + iMo327roundToPx0680j_5), 1, null), 0, 0, 0, 0, 11, null);
                Iterator<T> it11 = list2.iterator();
                do {
                    if (!it11.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it11.next();
                } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next6), TextFieldImplKt.SupportingId));
                Measurable measurable8 = (Measurable) next6;
                Placeable placeableMo4159measureBRTryo7 = measurable8 != null ? measurable8.mo4159measureBRTryo0(jM5119copyZbe2FdA$default3) : null;
                int iHeightOrZero2 = TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo7);
                int iM1927calculateWidthyeHjK3Y = TextFieldKt.m1927calculateWidthyeHjK3Y(TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo1), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo2), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo3), placeableMo4159measureBRTryo5.getWidth(), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo4), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo6), j);
                int iM1926calculateHeightmKXJcVc = TextFieldKt.m1926calculateHeightmKXJcVc(placeableMo4159measureBRTryo5.getHeight(), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo4), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo1), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo2), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo3), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo6), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo7), this.animationProgress == 1.0f, j, measureScope.getDensity(), this.paddingValues);
                int i3 = iM1926calculateHeightmKXJcVc - iHeightOrZero2;
                for (Measurable measurable9 : list2) {
                    if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable9), TextFieldImplKt.ContainerId)) {
                        return MeasureScope.CC.q(measureScope, iM1927calculateWidthyeHjK3Y, iM1926calculateHeightmKXJcVc, null, new TextFieldMeasurePolicy$measure$1(placeableMo4159measureBRTryo4, iM1927calculateWidthyeHjK3Y, iM1926calculateHeightmKXJcVc, placeableMo4159measureBRTryo5, placeableMo4159measureBRTryo6, placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo2, placeableMo4159measureBRTryo3, measurable9.mo4159measureBRTryo0(ConstraintsKt.Constraints(iM1927calculateWidthyeHjK3Y != Integer.MAX_VALUE ? iM1927calculateWidthyeHjK3Y : 0, iM1927calculateWidthyeHjK3Y, i3 != Integer.MAX_VALUE ? i3 : 0, i3)), placeableMo4159measureBRTryo7, this, i2, measureScope), 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            it7 = it8;
            iMo327roundToPx0680j_4 = i2;
        }
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i, C15861.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicWidth(list, i, C15871.INSTANCE);
    }
}
