package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntRect;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class PopupLayout$dismissOnOutsideClick$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final PopupLayout$dismissOnOutsideClick$1 INSTANCE = new PopupLayout$dismissOnOutsideClick$1();

    public PopupLayout$dismissOnOutsideClick$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke-KMgbckE, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Boolean mo13invoke(Offset offset, IntRect intRect) {
        AbstractC4492zt.h(intRect, "bounds");
        boolean z = false;
        if (offset != null && (Offset.m2798getXimpl(offset.m2808unboximpl()) < intRect.getLeft() || Offset.m2798getXimpl(offset.m2808unboximpl()) > intRect.getRight() || Offset.m2799getYimpl(offset.m2808unboximpl()) < intRect.getTop() || Offset.m2799getYimpl(offset.m2808unboximpl()) > intRect.getBottom())) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
