package androidx.compose.material3;

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

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15401 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C15401 INSTANCE = new C15401();

        public C15401() {
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

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15411 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C15411 INSTANCE = new C15411();

        public C15411() {
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

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15421 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C15421 INSTANCE = new C15421();

        public C15421() {
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
                return OutlinedTextFieldKt.m1694calculateHeightDHJA7U0(iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, iIntValue7, intrinsicMeasurable7 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable7, Integer.valueOf(i))).intValue() : 0, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, InterfaceC0526Fp interfaceC0526Fp) {
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
                for (Object obj3 : list2) {
                    if (AbstractC4492zt.d(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Hint")) {
                        obj = obj3;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.m1695calculateWidthDHJA7U0(iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, intrinsicMeasurable6 != null ? ((Number) interfaceC0526Fp.mo13invoke(intrinsicMeasurable6, Integer.valueOf(i))).intValue() : 0, this.animationProgress < 1.0f, TextFieldImplKt.getZeroConstraints(), intrinsicMeasureScope.getDensity(), this.paddingValues);
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
        return intrinsicWidth(intrinsicMeasureScope, list, i, C15401.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Placeable placeable;
        Object next5;
        Object obj;
        Object next6;
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
        boolean z = this.animationProgress < 1.0f;
        int iMo327roundToPx0680j_5 = measureScope.mo327roundToPx0680j_4(this.paddingValues.mo436calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo327roundToPx0680j_4(this.paddingValues.mo437calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int i = z ? (-iWidthOrZero4) - iMo327roundToPx0680j_5 : -iMo327roundToPx0680j_5;
        int i2 = -iMo327roundToPx0680j_4;
        long jM5144offsetNN6EwU = ConstraintsKt.m5144offsetNN6EwU(jM5119copyZbe2FdA$default, i, i2);
        Iterator<T> it5 = list2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                placeable = placeableMo4159measureBRTryo3;
                next5 = null;
                break;
            }
            next5 = it5.next();
            placeable = placeableMo4159measureBRTryo3;
            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next5), "Label")) {
                break;
            }
            placeableMo4159measureBRTryo3 = placeable;
        }
        Measurable measurable5 = (Measurable) next5;
        Placeable placeableMo4159measureBRTryo4 = measurable5 != null ? measurable5.mo4159measureBRTryo0(jM5144offsetNN6EwU) : null;
        if (placeableMo4159measureBRTryo4 != null) {
            this.onLabelMeasured.invoke(Size.m2855boximpl(SizeKt.Size(placeableMo4159measureBRTryo4.getWidth(), placeableMo4159measureBRTryo4.getHeight())));
        }
        int iMax5 = Math.max(TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo4) / 2, measureScope.mo327roundToPx0680j_4(this.paddingValues.mo438calculateTopPaddingD9Ej5fM()));
        long jM5119copyZbe2FdA$default2 = Constraints.m5119copyZbe2FdA$default(ConstraintsKt.m5144offsetNN6EwU(j, -iWidthOrZero4, i2 - iMax5), 0, 0, 0, 0, 11, null);
        Iterator it6 = list2.iterator();
        while (it6.hasNext()) {
            Measurable measurable6 = (Measurable) it6.next();
            Iterator it7 = it6;
            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable6), "TextField")) {
                Placeable placeableMo4159measureBRTryo5 = measurable6.mo4159measureBRTryo0(jM5119copyZbe2FdA$default2);
                long jM5119copyZbe2FdA$default3 = Constraints.m5119copyZbe2FdA$default(jM5119copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
                Iterator it8 = list2.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next7 = it8.next();
                    Iterator it9 = it8;
                    if (AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next7), "Hint")) {
                        obj = next7;
                        break;
                    }
                    it8 = it9;
                }
                Measurable measurable7 = (Measurable) obj;
                Placeable placeableMo4159measureBRTryo6 = measurable7 != null ? measurable7.mo4159measureBRTryo0(jM5119copyZbe2FdA$default3) : null;
                long jM5119copyZbe2FdA$default4 = Constraints.m5119copyZbe2FdA$default(ConstraintsKt.m5145offsetNN6EwU$default(jM5119copyZbe2FdA$default, 0, -Math.max(iMax4, Math.max(TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo5), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo6)) + iMax5 + iMo327roundToPx0680j_4), 1, null), 0, 0, 0, 0, 11, null);
                Iterator<T> it10 = list2.iterator();
                do {
                    if (!it10.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it10.next();
                } while (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) next6), TextFieldImplKt.SupportingId));
                Measurable measurable8 = (Measurable) next6;
                Placeable placeableMo4159measureBRTryo7 = measurable8 != null ? measurable8.mo4159measureBRTryo0(jM5119copyZbe2FdA$default4) : null;
                int iHeightOrZero = TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo7);
                int iM1695calculateWidthDHJA7U0 = OutlinedTextFieldKt.m1695calculateWidthDHJA7U0(TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo1), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo2), TextFieldImplKt.widthOrZero(placeable), placeableMo4159measureBRTryo5.getWidth(), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo4), TextFieldImplKt.widthOrZero(placeableMo4159measureBRTryo6), z, j, measureScope.getDensity(), this.paddingValues);
                int iM1694calculateHeightDHJA7U0 = OutlinedTextFieldKt.m1694calculateHeightDHJA7U0(TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo1), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo2), TextFieldImplKt.heightOrZero(placeable), placeableMo4159measureBRTryo5.getHeight(), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo4), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo6), TextFieldImplKt.heightOrZero(placeableMo4159measureBRTryo7), j, measureScope.getDensity(), this.paddingValues);
                int i3 = iM1694calculateHeightDHJA7U0 - iHeightOrZero;
                for (Measurable measurable9 : list2) {
                    if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable9), TextFieldImplKt.ContainerId)) {
                        return MeasureScope.CC.q(measureScope, iM1695calculateWidthDHJA7U0, iM1694calculateHeightDHJA7U0, null, new OutlinedTextFieldMeasurePolicy$measure$2(iM1694calculateHeightDHJA7U0, iM1695calculateWidthDHJA7U0, placeableMo4159measureBRTryo0, placeableMo4159measureBRTryo1, placeableMo4159measureBRTryo2, placeable, placeableMo4159measureBRTryo5, placeableMo4159measureBRTryo4, placeableMo4159measureBRTryo6, measurable9.mo4159measureBRTryo0(ConstraintsKt.Constraints(iM1695calculateWidthDHJA7U0 != Integer.MAX_VALUE ? iM1695calculateWidthDHJA7U0 : 0, iM1695calculateWidthDHJA7U0, i3 != Integer.MAX_VALUE ? i3 : 0, i3)), placeableMo4159measureBRTryo7, this, measureScope), 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            it6 = it7;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, list, i, C15411.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, list, i, C15421.INSTANCE);
    }
}
