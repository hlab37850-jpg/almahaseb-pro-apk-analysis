package androidx.compose.ui.text.font;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolverImpl$resolve$result$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ TypefaceRequest $typefaceRequest;
    final /* synthetic */ FontFamilyResolverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$resolve$result$1(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        super(1);
        this.this$0 = fontFamilyResolverImpl;
        this.$typefaceRequest = typefaceRequest;
    }

    @Override // defpackage.InterfaceC3750qp
    public final TypefaceResult invoke(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onAsyncCompletion");
        TypefaceResult typefaceResultResolve = this.this$0.fontListFontFamilyTypefaceAdapter.resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), interfaceC3750qp, this.this$0.createDefaultTypeface);
        if (typefaceResultResolve == null && (typefaceResultResolve = this.this$0.platformFamilyTypefaceAdapter.resolve(this.$typefaceRequest, this.this$0.getPlatformFontLoader$ui_text_release(), interfaceC3750qp, this.this$0.createDefaultTypeface)) == null) {
            throw new IllegalStateException("Could not load font");
        }
        return typefaceResultResolve;
    }
}
