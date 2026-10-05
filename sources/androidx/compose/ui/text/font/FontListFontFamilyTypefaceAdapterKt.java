package androidx.compose.ui.text.font;

import defpackage.AbstractC1886cc;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC3750qp;
import defpackage.KL;
import defpackage.LL;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final C2020dG firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, InterfaceC3750qp interfaceC3750qp) {
        Object objLoadBlocking;
        Object objA;
        int size = list.size();
        List listS = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int iMo4747getLoadingStrategyPKNRLFQ = font.mo4747getLoadingStrategyPKNRLFQ();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
            if (FontLoadingStrategy.m4788equalsimpl0(iMo4747getLoadingStrategyPKNRLFQ, companion.m4793getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objLoadBlocking = asyncTypefaceResult.m4766unboximpl();
                        } else {
                            FW fw = FW.a;
                            try {
                                objLoadBlocking = platformFontLoader.loadBlocking(font);
                                AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objLoadBlocking, false, 8, null);
                            } catch (Exception e) {
                                throw new IllegalStateException("Unable to load font " + font, e);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objLoadBlocking != null) {
                    return HV.a(listS, FontSynthesis_androidKt.m4820synthesizeTypefaceFxwP2eA(typefaceRequest.m4843getFontSynthesisGVVA2EU(), objLoadBlocking, font, typefaceRequest.getFontWeight(), typefaceRequest.m4842getFontStyle_LCdwA()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m4788equalsimpl0(iMo4747getLoadingStrategyPKNRLFQ, companion.m4794getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                        if (asyncTypefaceResult2 == null) {
                            asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                        }
                        if (asyncTypefaceResult2 != null) {
                            objA = asyncTypefaceResult2.m4766unboximpl();
                        } else {
                            FW fw2 = FW.a;
                            try {
                                KL.a aVar = KL.a;
                                objA = KL.a(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th2) {
                                KL.a aVar2 = KL.a;
                                objA = KL.a(LL.a(th2));
                            }
                            if (KL.c(objA)) {
                                objA = null;
                            }
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objA, false, 8, null);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (objA != null) {
                    return HV.a(listS, FontSynthesis_androidKt.m4820synthesizeTypefaceFxwP2eA(typefaceRequest.m4843getFontSynthesisGVVA2EU(), objA, font, typefaceRequest.getFontWeight(), typefaceRequest.m4842getFontStyle_LCdwA()));
                }
            } else {
                if (!FontLoadingStrategy.m4788equalsimpl0(iMo4747getLoadingStrategyPKNRLFQ, companion.m4792getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM4758get1ASDuI8 = asyncTypefaceCache.m4758get1ASDuI8(font, platformFontLoader);
                if (asyncTypefaceResultM4758get1ASDuI8 != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.m4764isPermanentFailureimpl(asyncTypefaceResultM4758get1ASDuI8.m4766unboximpl()) && asyncTypefaceResultM4758get1ASDuI8.m4766unboximpl() != null) {
                        return HV.a(listS, FontSynthesis_androidKt.m4820synthesizeTypefaceFxwP2eA(typefaceRequest.m4843getFontSynthesisGVVA2EU(), asyncTypefaceResultM4758get1ASDuI8.m4766unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m4842getFontStyle_LCdwA()));
                    }
                } else if (listS == null) {
                    listS = AbstractC1886cc.s(font);
                } else {
                    listS.add(font);
                }
            }
        }
        return HV.a(listS, interfaceC3750qp.invoke(typefaceRequest));
    }
}
