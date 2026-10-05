package androidx.compose.ui.text.font;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolverImpl$createDefaultTypeface$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$createDefaultTypeface$1(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Object invoke(TypefaceRequest typefaceRequest) {
        AbstractC4492zt.h(typefaceRequest, "it");
        return this.this$0.resolve(TypefaceRequest.m4838copye1PVR60$default(typefaceRequest, null, null, 0, 0, null, 30, null)).getValue();
    }
}
