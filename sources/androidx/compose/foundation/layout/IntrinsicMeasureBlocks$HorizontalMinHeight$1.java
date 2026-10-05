package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class IntrinsicMeasureBlocks$HorizontalMinHeight$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final IntrinsicMeasureBlocks$HorizontalMinHeight$1 INSTANCE = new IntrinsicMeasureBlocks$HorizontalMinHeight$1();

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1$1, reason: invalid class name */
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
            AbstractC4492zt.h(intrinsicMeasurable, "$this$intrinsicSize");
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.IntrinsicMeasureBlocks$HorizontalMinHeight$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            AbstractC4492zt.h(intrinsicMeasurable, "$this$intrinsicSize");
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i));
        }
    }

    public IntrinsicMeasureBlocks$HorizontalMinHeight$1() {
        super(3);
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
    }

    public final Integer invoke(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        AbstractC4492zt.h(list, "measurables");
        return Integer.valueOf(RowColumnImplKt.intrinsicSize(list, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, i, i2, LayoutOrientation.Horizontal, LayoutOrientation.Vertical));
    }
}
