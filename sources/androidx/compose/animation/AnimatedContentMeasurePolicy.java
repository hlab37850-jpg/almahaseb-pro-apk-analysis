package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.FO;
import defpackage.InterfaceC3750qp;
import defpackage.R5;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentTransitionScopeImpl<?> rootScope;

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12641 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12641(int i) {
            super(1);
            this.$height = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
            AbstractC4492zt.h(intrinsicMeasurable, "it");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(this.$height));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12651 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12651(int i) {
            super(1);
            this.$width = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
            AbstractC4492zt.h(intrinsicMeasurable, "it");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(this.$width));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12661 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $height;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12661(int i) {
            super(1);
            this.$height = i;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
            AbstractC4492zt.h(intrinsicMeasurable, "it");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(this.$height));
        }
    }

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl<?> animatedContentTransitionScopeImpl) {
        AbstractC4492zt.h(animatedContentTransitionScopeImpl, "rootScope");
        this.rootScope = animatedContentTransitionScopeImpl;
    }

    public final AnimatedContentTransitionScopeImpl<?> getRootScope() {
        return this.rootScope;
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
        Integer num = (Integer) FO.t(FO.r(AbstractC3240kc.T(list), new C12641(i)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Placeable placeable;
        Placeable placeable2;
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(list, "measurables");
        int size = list.size();
        Placeable[] placeableArr = new Placeable[size];
        int size2 = list.size();
        int i = 0;
        while (true) {
            placeable = null;
            if (i >= size2) {
                break;
            }
            Measurable measurable = list.get(i);
            Object parentData = measurable.getParentData();
            AnimatedContentTransitionScopeImpl.ChildData childData = parentData instanceof AnimatedContentTransitionScopeImpl.ChildData ? (AnimatedContentTransitionScopeImpl.ChildData) parentData : null;
            if (childData != null && childData.isTarget()) {
                placeableArr[i] = measurable.mo4159measureBRTryo0(j);
            }
            i++;
        }
        int size3 = list.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Measurable measurable2 = list.get(i2);
            if (placeableArr[i2] == null) {
                placeableArr[i2] = measurable2.mo4159measureBRTryo0(j);
            }
        }
        if (size == 0) {
            placeable2 = null;
        } else {
            placeable2 = placeableArr[0];
            int iO = R5.O(placeableArr);
            if (iO != 0) {
                int width = placeable2 != null ? placeable2.getWidth() : 0;
                AbstractC0919Ss it = new C1001Vs(1, iO).iterator();
                while (it.hasNext()) {
                    Placeable placeable3 = placeableArr[it.nextInt()];
                    int width2 = placeable3 != null ? placeable3.getWidth() : 0;
                    if (width < width2) {
                        placeable2 = placeable3;
                        width = width2;
                    }
                }
            }
        }
        int width3 = placeable2 != null ? placeable2.getWidth() : 0;
        if (size != 0) {
            placeable = placeableArr[0];
            int iO2 = R5.O(placeableArr);
            if (iO2 != 0) {
                int height = placeable != null ? placeable.getHeight() : 0;
                AbstractC0919Ss it2 = new C1001Vs(1, iO2).iterator();
                while (it2.hasNext()) {
                    Placeable placeable4 = placeableArr[it2.nextInt()];
                    int height2 = placeable4 != null ? placeable4.getHeight() : 0;
                    if (height < height2) {
                        placeable = placeable4;
                        height = height2;
                    }
                }
            }
        }
        int height3 = placeable != null ? placeable.getHeight() : 0;
        this.rootScope.m40setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(width3, height3));
        return MeasureScope.CC.q(measureScope, width3, height3, null, new AnimatedContentMeasurePolicy$measure$3(placeableArr, this, width3, height3), 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        Integer num = (Integer) FO.t(FO.r(AbstractC3240kc.T(list), new C12651(i)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(list, "measurables");
        Integer num = (Integer) FO.t(FO.r(AbstractC3240kc.T(list), new C12661(i)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
