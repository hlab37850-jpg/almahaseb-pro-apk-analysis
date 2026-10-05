package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.R5;
import defpackage.S4;
import defpackage.T4;
import defpackage.U4;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Arrangement {
    public static final int $stable = 0;
    public static final Arrangement INSTANCE = new Arrangement();
    private static final Horizontal Start = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Start$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo405getSpacingD9Ej5fM() {
            return S4.a(this);
        }

        public String toString() {
            return "Arrangement#Start";
        }
    };
    private static final Horizontal End = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo405getSpacingD9Ej5fM() {
            return S4.a(this);
        }

        public String toString() {
            return "Arrangement#End";
        }
    };
    private static final Vertical Top = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(iArr2, "outPositions");
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo405getSpacingD9Ej5fM() {
            return U4.a(this);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    };
    private static final Vertical Bottom = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Bottom$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(iArr2, "outPositions");
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo405getSpacingD9Ej5fM() {
            return U4.a(this);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    };
    private static final HorizontalOrVertical Center = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$Center$1
        private final float spacing = Dp.m5160constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo405getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#Center";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(iArr2, "outPositions");
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
        }
    };
    private static final HorizontalOrVertical SpaceEvenly = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1
        private final float spacing = Dp.m5160constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo405getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(iArr2, "outPositions");
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
        }
    };
    private static final HorizontalOrVertical SpaceBetween = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceBetween$1
        private final float spacing = Dp.m5160constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo405getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(iArr2, "outPositions");
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
        }
    };
    private static final HorizontalOrVertical SpaceAround = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceAround$1
        private final float spacing = Dp.m5160constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo405getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(iArr2, "outPositions");
            Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
        }
    };

    @Immutable
    public static final class Absolute {
        public static final int $stable = 0;
        public static final Absolute INSTANCE = new Absolute();
        private static final Horizontal Left = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Left$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                AbstractC4492zt.h(density, "<this>");
                AbstractC4492zt.h(iArr, "sizes");
                AbstractC4492zt.h(layoutDirection, "layoutDirection");
                AbstractC4492zt.h(iArr2, "outPositions");
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo405getSpacingD9Ej5fM() {
                return S4.a(this);
            }

            public String toString() {
                return "AbsoluteArrangement#Left";
            }
        };
        private static final Horizontal Center = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Center$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                AbstractC4492zt.h(density, "<this>");
                AbstractC4492zt.h(iArr, "sizes");
                AbstractC4492zt.h(layoutDirection, "layoutDirection");
                AbstractC4492zt.h(iArr2, "outPositions");
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public /* synthetic */ float mo405getSpacingD9Ej5fM() {
                return S4.a(this);
            }

            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        };
        private static final Horizontal Right = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Right$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                AbstractC4492zt.h(density, "<this>");
                AbstractC4492zt.h(iArr, "sizes");
                AbstractC4492zt.h(layoutDirection, "layoutDirection");
                AbstractC4492zt.h(iArr2, "outPositions");
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo405getSpacingD9Ej5fM() {
                return S4.a(this);
            }

            public String toString() {
                return "AbsoluteArrangement#Right";
            }
        };
        private static final Horizontal SpaceBetween = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceBetween$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                AbstractC4492zt.h(density, "<this>");
                AbstractC4492zt.h(iArr, "sizes");
                AbstractC4492zt.h(layoutDirection, "layoutDirection");
                AbstractC4492zt.h(iArr2, "outPositions");
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo405getSpacingD9Ej5fM() {
                return S4.a(this);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceBetween";
            }
        };
        private static final Horizontal SpaceEvenly = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceEvenly$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                AbstractC4492zt.h(density, "<this>");
                AbstractC4492zt.h(iArr, "sizes");
                AbstractC4492zt.h(layoutDirection, "layoutDirection");
                AbstractC4492zt.h(iArr2, "outPositions");
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo405getSpacingD9Ej5fM() {
                return S4.a(this);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceEvenly";
            }
        };
        private static final Horizontal SpaceAround = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceAround$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                AbstractC4492zt.h(density, "<this>");
                AbstractC4492zt.h(iArr, "sizes");
                AbstractC4492zt.h(layoutDirection, "layoutDirection");
                AbstractC4492zt.h(iArr2, "outPositions");
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, iArr, iArr2, false);
            }

            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
            public /* synthetic */ float mo405getSpacingD9Ej5fM() {
                return S4.a(this);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceAround";
            }
        };

        private Absolute() {
        }

        @Stable
        public static /* synthetic */ void getCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getLeft$annotations() {
        }

        @Stable
        public static /* synthetic */ void getRight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        @Stable
        public final Horizontal aligned(Alignment.Horizontal horizontal) {
            AbstractC4492zt.h(horizontal, CellUtil.ALIGNMENT);
            return new SpacedAligned(Dp.m5160constructorimpl(0), false, new Arrangement$Absolute$aligned$1(horizontal), null);
        }

        public final Horizontal getCenter() {
            return Center;
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getRight() {
            return Right;
        }

        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Stable
        /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
        public final HorizontalOrVertical m402spacedBy0680j_4(float f) {
            return new SpacedAligned(f, false, null, 0 == true ? 1 : 0);
        }

        @Stable
        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Horizontal m403spacedByD5KLDUw(float f, Alignment.Horizontal horizontal) {
            AbstractC4492zt.h(horizontal, CellUtil.ALIGNMENT);
            return new SpacedAligned(f, false, new Arrangement$Absolute$spacedBy$1(horizontal), null);
        }

        @Stable
        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Vertical m404spacedByD5KLDUw(float f, Alignment.Vertical vertical) {
            AbstractC4492zt.h(vertical, CellUtil.ALIGNMENT);
            return new SpacedAligned(f, false, new Arrangement$Absolute$spacedBy$2(vertical), null);
        }
    }

    @Stable
    public interface Horizontal {

        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m406getSpacingD9Ej5fM(Horizontal horizontal) {
                return S4.a(horizontal);
            }
        }

        void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo405getSpacingD9Ej5fM();
    }

    @Stable
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m407getSpacingD9Ej5fM(HorizontalOrVertical horizontalOrVertical) {
                return T4.a(horizontalOrVertical);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo405getSpacingD9Ej5fM();
    }

    @Immutable
    public static final class SpacedAligned implements HorizontalOrVertical {
        private final InterfaceC0526Fp alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f, boolean z, InterfaceC0526Fp interfaceC0526Fp, AbstractC0419Di abstractC0419Di) {
            this(f, z, interfaceC0526Fp);
        }

        /* JADX INFO: renamed from: copy-8Feqmps$default, reason: not valid java name */
        public static /* synthetic */ SpacedAligned m408copy8Feqmps$default(SpacedAligned spacedAligned, float f, boolean z, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
            if ((i & 1) != 0) {
                f = spacedAligned.space;
            }
            if ((i & 2) != 0) {
                z = spacedAligned.rtlMirror;
            }
            if ((i & 4) != 0) {
                interfaceC0526Fp = spacedAligned.alignment;
            }
            return spacedAligned.m410copy8Feqmps(f, z, interfaceC0526Fp);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            int i2;
            int i3;
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(iArr2, "outPositions");
            if (iArr.length == 0) {
                return;
            }
            int iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(this.space);
            boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement arrangement = Arrangement.INSTANCE;
            if (z) {
                int length = iArr.length - 1;
                i2 = 0;
                i3 = 0;
                while (-1 < length) {
                    int i4 = iArr[length];
                    int iMin = Math.min(i2, i - i4);
                    iArr2[length] = iMin;
                    int iMin2 = Math.min(iMo327roundToPx0680j_4, (i - iMin) - i4);
                    int i5 = iArr2[length] + i4 + iMin2;
                    length--;
                    i3 = iMin2;
                    i2 = i5;
                }
            } else {
                int length2 = iArr.length;
                int i6 = 0;
                i2 = 0;
                i3 = 0;
                int i7 = 0;
                while (i6 < length2) {
                    int i8 = iArr[i6];
                    int iMin3 = Math.min(i2, i - i8);
                    iArr2[i7] = iMin3;
                    int iMin4 = Math.min(iMo327roundToPx0680j_4, (i - iMin3) - i8);
                    int i9 = iArr2[i7] + i8 + iMin4;
                    i6++;
                    i7++;
                    i3 = iMin4;
                    i2 = i9;
                }
            }
            int i10 = i2 - i3;
            InterfaceC0526Fp interfaceC0526Fp = this.alignment;
            if (interfaceC0526Fp == null || i10 >= i) {
                return;
            }
            int iIntValue = ((Number) interfaceC0526Fp.mo13invoke(Integer.valueOf(i - i10), layoutDirection)).intValue();
            int length3 = iArr2.length;
            for (int i11 = 0; i11 < length3; i11++) {
                iArr2[i11] = iArr2[i11] + iIntValue;
            }
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
        public final float m409component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        public final InterfaceC0526Fp component3() {
            return this.alignment;
        }

        /* JADX INFO: renamed from: copy-8Feqmps, reason: not valid java name */
        public final SpacedAligned m410copy8Feqmps(float f, boolean z, InterfaceC0526Fp interfaceC0526Fp) {
            return new SpacedAligned(f, z, interfaceC0526Fp, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.m5165equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && AbstractC4492zt.d(this.alignment, spacedAligned.alignment);
        }

        public final InterfaceC0526Fp getAlignment() {
            return this.alignment;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        /* JADX INFO: renamed from: getSpace-D9Ej5fM, reason: not valid java name */
        public final float m411getSpaceD9Ej5fM() {
            return this.space;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo405getSpacingD9Ej5fM() {
            return this.spacing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iM5166hashCodeimpl = Dp.m5166hashCodeimpl(this.space) * 31;
            boolean z = this.rtlMirror;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int i = (iM5166hashCodeimpl + r1) * 31;
            InterfaceC0526Fp interfaceC0526Fp = this.alignment;
            return i + (interfaceC0526Fp == null ? 0 : interfaceC0526Fp.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rtlMirror ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.m5171toStringimpl(this.space));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(')');
            return sb.toString();
        }

        private SpacedAligned(float f, boolean z, InterfaceC0526Fp interfaceC0526Fp) {
            this.space = f;
            this.rtlMirror = z;
            this.alignment = interfaceC0526Fp;
            this.spacing = f;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            AbstractC4492zt.h(density, "<this>");
            AbstractC4492zt.h(iArr, "sizes");
            AbstractC4492zt.h(iArr2, "outPositions");
            arrange(density, i, iArr, LayoutDirection.Ltr, iArr2);
        }
    }

    @Stable
    public interface Vertical {

        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m412getSpacingD9Ej5fM(Vertical vertical) {
                return U4.a(vertical);
            }
        }

        void arrange(Density density, int i, int[] iArr, int[] iArr2);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo405getSpacingD9Ej5fM();
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$aligned$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ Alignment.Horizontal $alignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Alignment.Horizontal horizontal) {
            super(2);
            this.$alignment = horizontal;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
        }

        public final Integer invoke(int i, LayoutDirection layoutDirection) {
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            return Integer.valueOf(this.$alignment.align(0, i, layoutDirection));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$aligned$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ Alignment.Vertical $alignment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Alignment.Vertical vertical) {
            super(2);
            this.$alignment = vertical;
        }

        public final Integer invoke(int i, LayoutDirection layoutDirection) {
            AbstractC4492zt.h(layoutDirection, "<anonymous parameter 1>");
            return Integer.valueOf(this.$alignment.align(0, i));
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
        }
    }

    private Arrangement() {
    }

    private final void forEachIndexed(int[] iArr, boolean z, InterfaceC0526Fp interfaceC0526Fp) {
        if (!z) {
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                interfaceC0526Fp.mo13invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i]));
                i++;
                i2++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            } else {
                interfaceC0526Fp.mo13invoke(Integer.valueOf(length2), Integer.valueOf(iArr[length2]));
            }
        }
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getCenter$annotations() {
    }

    @Stable
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    @Stable
    public static /* synthetic */ void getStart$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @Stable
    public final Horizontal aligned(Alignment.Horizontal horizontal) {
        AbstractC4492zt.h(horizontal, CellUtil.ALIGNMENT);
        return new SpacedAligned(Dp.m5160constructorimpl(0), true, new AnonymousClass1(horizontal), null);
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Vertical getTop() {
        return Top;
    }

    public final void placeCenter$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        AbstractC4492zt.h(iArr, "size");
        AbstractC4492zt.h(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float f = (i - i3) / 2;
        if (!z) {
            int length = iArr.length;
            int i5 = 0;
            while (i2 < length) {
                int i6 = iArr[i2];
                iArr2[i5] = AbstractC1210aB.c(f);
                f += i6;
                i2++;
                i5++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i7 = iArr[length2];
            iArr2[length2] = AbstractC1210aB.c(f);
            f += i7;
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] iArr, int[] iArr2, boolean z) {
        AbstractC4492zt.h(iArr, "size");
        AbstractC4492zt.h(iArr2, "outPosition");
        int i = 0;
        if (!z) {
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                int i4 = iArr[i];
                iArr2[i2] = i3;
                i3 += i4;
                i++;
                i2++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i5 = iArr[length2];
            iArr2[length2] = i;
            i += i5;
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        AbstractC4492zt.h(iArr, "size");
        AbstractC4492zt.h(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        int i5 = i - i3;
        if (!z) {
            int length = iArr.length;
            int i6 = 0;
            while (i2 < length) {
                int i7 = iArr[i2];
                iArr2[i6] = i5;
                i5 += i7;
                i2++;
                i6++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i8 = iArr[length2];
            iArr2[length2] = i5;
            i5 += i8;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        AbstractC4492zt.h(iArr, "size");
        AbstractC4492zt.h(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = !(iArr.length == 0) ? (i - i3) / iArr.length : 0.0f;
        float f = length / 2;
        if (z) {
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i5 = iArr[length2];
                iArr2[length2] = AbstractC1210aB.c(f);
                f += i5 + length;
            }
            return;
        }
        int length3 = iArr.length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = iArr[i2];
            iArr2[i6] = AbstractC1210aB.c(f);
            f += i7 + length;
            i2++;
            i6++;
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        AbstractC4492zt.h(iArr, "size");
        AbstractC4492zt.h(iArr2, "outPosition");
        if (iArr.length == 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float fMax = (i - i3) / Math.max(R5.N(iArr), 1);
        float f = (z && iArr.length == 1) ? fMax : 0.0f;
        if (z) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i5 = iArr[length];
                iArr2[length] = AbstractC1210aB.c(f);
                f += i5 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i6 = 0;
        while (i2 < length2) {
            int i7 = iArr[i2];
            iArr2[i6] = AbstractC1210aB.c(f);
            f += i7 + fMax;
            i2++;
            i6++;
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        AbstractC4492zt.h(iArr, "size");
        AbstractC4492zt.h(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = (i - i3) / (iArr.length + 1);
        if (z) {
            float f = length;
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i5 = iArr[length2];
                iArr2[length2] = AbstractC1210aB.c(f);
                f += i5 + length;
            }
            return;
        }
        int length3 = iArr.length;
        float f2 = length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = iArr[i2];
            iArr2[i6] = AbstractC1210aB.c(f2);
            f2 += i7 + length;
            i2++;
            i6++;
        }
    }

    @Stable
    /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
    public final HorizontalOrVertical m399spacedBy0680j_4(float f) {
        return new SpacedAligned(f, true, Arrangement$spacedBy$1.INSTANCE, null);
    }

    @Stable
    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Horizontal m400spacedByD5KLDUw(float f, Alignment.Horizontal horizontal) {
        AbstractC4492zt.h(horizontal, CellUtil.ALIGNMENT);
        return new SpacedAligned(f, true, new Arrangement$spacedBy$2(horizontal), null);
    }

    @Stable
    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Vertical m401spacedByD5KLDUw(float f, Alignment.Vertical vertical) {
        AbstractC4492zt.h(vertical, CellUtil.ALIGNMENT);
        return new SpacedAligned(f, false, new Arrangement$spacedBy$3(vertical), null);
    }

    @Stable
    public final Vertical aligned(Alignment.Vertical vertical) {
        AbstractC4492zt.h(vertical, CellUtil.ALIGNMENT);
        return new SpacedAligned(Dp.m5160constructorimpl(0), false, new AnonymousClass2(vertical), null);
    }
}
