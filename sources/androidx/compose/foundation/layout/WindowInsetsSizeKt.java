package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsSizeKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsBottomHeight$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer mo13invoke(WindowInsets windowInsets, Density density) {
            AbstractC4492zt.h(windowInsets, "$this$$receiver");
            AbstractC4492zt.h(density, "it");
            return Integer.valueOf(windowInsets.getBottom(density));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsEndWidth$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13512 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C13512 INSTANCE = new C13512();

        public C13512() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Integer invoke(WindowInsets windowInsets, LayoutDirection layoutDirection, Density density) {
            AbstractC4492zt.h(windowInsets, "$this$$receiver");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(density, "density");
            return Integer.valueOf(layoutDirection == LayoutDirection.Rtl ? windowInsets.getLeft(density, layoutDirection) : windowInsets.getRight(density, layoutDirection));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsStartWidth$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13522 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final C13522 INSTANCE = new C13522();

        public C13522() {
            super(3);
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Integer invoke(WindowInsets windowInsets, LayoutDirection layoutDirection, Density density) {
            AbstractC4492zt.h(windowInsets, "$this$$receiver");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(density, "density");
            return Integer.valueOf(layoutDirection == LayoutDirection.Ltr ? windowInsets.getLeft(density, layoutDirection) : windowInsets.getRight(density, layoutDirection));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsTopHeight$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13532 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final C13532 INSTANCE = new C13532();

        public C13532() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer mo13invoke(WindowInsets windowInsets, Density density) {
            AbstractC4492zt.h(windowInsets, "$this$$receiver");
            AbstractC4492zt.h(density, "it");
            return Integer.valueOf(windowInsets.getTop(density));
        }
    }

    @Stable
    public static final Modifier windowInsetsBottomHeight(Modifier modifier, WindowInsets windowInsets) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(windowInsets, "insets");
        return modifier.then(new DerivedHeightModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), AnonymousClass2.INSTANCE));
    }

    @Stable
    public static final Modifier windowInsetsEndWidth(Modifier modifier, WindowInsets windowInsets) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(windowInsets, "insets");
        return modifier.then(new DerivedWidthModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsEndWidth$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), C13512.INSTANCE));
    }

    @Stable
    public static final Modifier windowInsetsStartWidth(Modifier modifier, WindowInsets windowInsets) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(windowInsets, "insets");
        return modifier.then(new DerivedWidthModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsStartWidth$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), C13522.INSTANCE));
    }

    @Stable
    public static final Modifier windowInsetsTopHeight(Modifier modifier, WindowInsets windowInsets) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(windowInsets, "insets");
        return modifier.then(new DerivedHeightModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), C13532.INSTANCE));
    }
}
