package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.DO;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC4362yO;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final long contentOffset;
    private final Density density;
    private final InterfaceC0526Fp onPositionCalculated;

    /* JADX INFO: renamed from: androidx.compose.material.DropdownMenuPositionProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        public final void invoke(IntRect intRect, IntRect intRect2) {
            AbstractC4492zt.h(intRect, "<anonymous parameter 0>");
            AbstractC4492zt.h(intRect2, "<anonymous parameter 1>");
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((IntRect) obj, (IntRect) obj2);
            return FW.a;
        }
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, InterfaceC0526Fp interfaceC0526Fp, AbstractC0419Di abstractC0419Di) {
        this(j, density, interfaceC0526Fp);
    }

    /* JADX INFO: renamed from: copy-rOJDEFc$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m1107copyrOJDEFc$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        if ((i & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        if ((i & 4) != 0) {
            interfaceC0526Fp = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m1109copyrOJDEFc(j, density, interfaceC0526Fp);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo883calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        InterfaceC4362yO interfaceC4362yOH;
        Object obj;
        Object next;
        AbstractC4492zt.h(intRect, "anchorBounds");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        int iMo327roundToPx0680j_4 = this.density.mo327roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        int iMo327roundToPx0680j_5 = this.density.mo327roundToPx0680j_4(DpOffset.m5221getXD9Ej5fM(this.contentOffset));
        int iMo327roundToPx0680j_6 = this.density.mo327roundToPx0680j_4(DpOffset.m5223getYD9Ej5fM(this.contentOffset));
        int left = intRect.getLeft() + iMo327roundToPx0680j_5;
        int right = (intRect.getRight() - iMo327roundToPx0680j_5) - IntSize.m5320getWidthimpl(j2);
        int iM5320getWidthimpl = IntSize.m5320getWidthimpl(j) - IntSize.m5320getWidthimpl(j2);
        if (layoutDirection == LayoutDirection.Ltr) {
            Integer numValueOf = Integer.valueOf(left);
            Integer numValueOf2 = Integer.valueOf(right);
            if (intRect.getLeft() < 0) {
                iM5320getWidthimpl = 0;
            }
            interfaceC4362yOH = DO.h(numValueOf, numValueOf2, Integer.valueOf(iM5320getWidthimpl));
        } else {
            Integer numValueOf3 = Integer.valueOf(right);
            Integer numValueOf4 = Integer.valueOf(left);
            if (intRect.getRight() <= IntSize.m5320getWidthimpl(j)) {
                iM5320getWidthimpl = 0;
            }
            interfaceC4362yOH = DO.h(numValueOf3, numValueOf4, Integer.valueOf(iM5320getWidthimpl));
        }
        Iterator it = interfaceC4362yOH.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int iIntValue = ((Number) next).intValue();
            if (iIntValue >= 0 && iIntValue + IntSize.m5320getWidthimpl(j2) <= IntSize.m5320getWidthimpl(j)) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num != null) {
            right = num.intValue();
        }
        int iMax = Math.max(intRect.getBottom() + iMo327roundToPx0680j_6, iMo327roundToPx0680j_4);
        int top = (intRect.getTop() - iMo327roundToPx0680j_6) - IntSize.m5319getHeightimpl(j2);
        for (Object obj2 : DO.h(Integer.valueOf(iMax), Integer.valueOf(top), Integer.valueOf(intRect.getTop() - (IntSize.m5319getHeightimpl(j2) / 2)), Integer.valueOf((IntSize.m5319getHeightimpl(j) - IntSize.m5319getHeightimpl(j2)) - iMo327roundToPx0680j_4))) {
            int iIntValue2 = ((Number) obj2).intValue();
            if (iIntValue2 >= iMo327roundToPx0680j_4 && iIntValue2 + IntSize.m5319getHeightimpl(j2) <= IntSize.m5319getHeightimpl(j) - iMo327roundToPx0680j_4) {
                obj = obj2;
                break;
            }
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            top = num2.intValue();
        }
        this.onPositionCalculated.mo13invoke(intRect, new IntRect(right, top, IntSize.m5320getWidthimpl(j2) + right, IntSize.m5319getHeightimpl(j2) + top));
        return IntOffsetKt.IntOffset(right, top);
    }

    /* JADX INFO: renamed from: component1-RKDOV3M, reason: not valid java name */
    public final long m1108component1RKDOV3M() {
        return this.contentOffset;
    }

    public final Density component2() {
        return this.density;
    }

    public final InterfaceC0526Fp component3() {
        return this.onPositionCalculated;
    }

    /* JADX INFO: renamed from: copy-rOJDEFc, reason: not valid java name */
    public final DropdownMenuPositionProvider m1109copyrOJDEFc(long j, Density density, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(interfaceC0526Fp, "onPositionCalculated");
        return new DropdownMenuPositionProvider(j, density, interfaceC0526Fp, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.m5220equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && AbstractC4492zt.d(this.density, dropdownMenuPositionProvider.density) && AbstractC4492zt.d(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    /* JADX INFO: renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m1110getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final InterfaceC0526Fp getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public int hashCode() {
        return (((DpOffset.m5225hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m5228toStringimpl(this.contentOffset)) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    private DropdownMenuPositionProvider(long j, Density density, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(interfaceC0526Fp, "onPositionCalculated");
        this.contentOffset = j;
        this.density = density;
        this.onPositionCalculated = interfaceC0526Fp;
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, InterfaceC0526Fp interfaceC0526Fp, int i, AbstractC0419Di abstractC0419Di) {
        this(j, density, (i & 4) != 0 ? AnonymousClass1.INSTANCE : interfaceC0526Fp, null);
    }
}
