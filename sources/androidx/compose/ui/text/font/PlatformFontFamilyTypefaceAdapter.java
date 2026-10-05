package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.AndroidTypeface;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    private final PlatformTypefaces platformTypefaceResolver = PlatformTypefacesKt.PlatformTypefaces();

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        android.graphics.Typeface typefaceMo4925getNativeTypefacePYhJU0U;
        AbstractC4492zt.h(typefaceRequest, "typefaceRequest");
        AbstractC4492zt.h(platformFontLoader, "platformFontLoader");
        AbstractC4492zt.h(interfaceC3750qp, "onAsyncCompletion");
        AbstractC4492zt.h(interfaceC3750qp2, "createDefaultTypeface");
        FontFamily fontFamily = typefaceRequest.getFontFamily();
        if (fontFamily == null ? true : fontFamily instanceof DefaultFontFamily) {
            typefaceMo4925getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo4824createDefaultFO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.m4842getFontStyle_LCdwA());
        } else if (fontFamily instanceof GenericFontFamily) {
            typefaceMo4925getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo4825createNamedRetOiIg((GenericFontFamily) typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.m4842getFontStyle_LCdwA());
        } else {
            if (!(fontFamily instanceof LoadedFontFamily)) {
                return null;
            }
            Typeface typeface = ((LoadedFontFamily) typefaceRequest.getFontFamily()).getTypeface();
            AbstractC4492zt.f(typeface, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            typefaceMo4925getNativeTypefacePYhJU0U = ((AndroidTypeface) typeface).mo4925getNativeTypefacePYhJU0U(typefaceRequest.getFontWeight(), typefaceRequest.m4842getFontStyle_LCdwA(), typefaceRequest.m4843getFontSynthesisGVVA2EU());
        }
        return new TypefaceResult.Immutable(typefaceMo4925getNativeTypefacePYhJU0U, false, 2, null);
    }
}
