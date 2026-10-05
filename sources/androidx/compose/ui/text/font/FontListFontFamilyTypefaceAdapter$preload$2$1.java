package androidx.compose.ui.text.font;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapter$preload$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final FontListFontFamilyTypefaceAdapter$preload$2$1 INSTANCE = new FontListFontFamilyTypefaceAdapter$preload$2$1();

    public FontListFontFamilyTypefaceAdapter$preload$2$1() {
        super(1);
    }

    public final void invoke(TypefaceRequest typefaceRequest) {
        AbstractC4492zt.h(typefaceRequest, "it");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypefaceRequest) obj);
        return FW.a;
    }
}
