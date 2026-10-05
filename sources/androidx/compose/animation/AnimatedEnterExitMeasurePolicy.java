package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FO;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private final AnimatedVisibilityScopeImpl scope;

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$width = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
            AbstractC4492zt.h(intrinsicMeasurable, "it");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(this.$width));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12671 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12671(int i) {
            super(1);
            this.$height = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
            AbstractC4492zt.h(intrinsicMeasurable, "it");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(this.$height));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12681 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12681(int i) {
            super(1);
            this.$width = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
            AbstractC4492zt.h(intrinsicMeasurable, "it");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(this.$width));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12691 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12691(int i) {
            super(1);
            this.$height = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
            AbstractC4492zt.h(intrinsicMeasurable, "it");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(this.$height));
        }
    }

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl) {
        AbstractC4492zt.h(animatedVisibilityScopeImpl, "scope");
        this.scope = animatedVisibilityScopeImpl;
    }

    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        Integer num = (Integer) FO.t(FO.r(AbstractC3240kc.T(list), new AnonymousClass1(i)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        Integer num = (Integer) FO.t(FO.r(AbstractC3240kc.T(list), new C12671(i)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(list, "measurables");
        List<? extends Measurable> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo4159measureBRTryo0(j));
        }
        Object obj2 = null;
        int i = 1;
        if (!arrayList.isEmpty()) {
            obj = arrayList.get(0);
            int width = ((Placeable) obj).getWidth();
            int iO = AbstractC1886cc.o(arrayList);
            if (1 <= iO) {
                int i2 = 1;
                while (true) {
                    Object obj3 = arrayList.get(i2);
                    int width2 = ((Placeable) obj3).getWidth();
                    if (width < width2) {
                        obj = obj3;
                        width = width2;
                    }
                    if (i2 == iO) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            obj = null;
        }
        Placeable placeable = (Placeable) obj;
        int width3 = placeable != null ? placeable.getWidth() : 0;
        if (!arrayList.isEmpty()) {
            Object obj4 = arrayList.get(0);
            int height = ((Placeable) obj4).getHeight();
            int iO2 = AbstractC1886cc.o(arrayList);
            if (1 <= iO2) {
                while (true) {
                    Object obj5 = arrayList.get(i);
                    int height2 = ((Placeable) obj5).getHeight();
                    if (height < height2) {
                        obj4 = obj5;
                        height = height2;
                    }
                    if (i == iO2) {
                        break;
                    }
                    i++;
                }
            }
            obj2 = obj4;
        }
        Placeable placeable2 = (Placeable) obj2;
        int height3 = placeable2 != null ? placeable2.getHeight() : 0;
        this.scope.getTargetSize$animation_release().setValue(IntSize.m5312boximpl(IntSizeKt.IntSize(width3, height3)));
        return MeasureScope.CC.q(measureScope, width3, height3, null, new AnimatedEnterExitMeasurePolicy$measure$1(arrayList), 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        Integer num = (Integer) FO.t(FO.r(AbstractC3240kc.T(list), new C12681(i)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        Integer num = (Integer) FO.t(FO.r(AbstractC3240kc.T(list), new C12691(i)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
