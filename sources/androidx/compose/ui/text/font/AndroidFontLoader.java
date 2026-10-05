package androidx.compose.ui.text.font;

import android.content.Context;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.KL;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    private final Object cacheKey;
    private final Context context;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.ui.text.font.AndroidFontLoader", f = "AndroidFontLoader.android.kt", l = {61, 62}, m = "awaitLoad")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidFontLoader.this.awaitLoad(null, this);
        }
    }

    public AndroidFontLoader(Context context) {
        AbstractC4492zt.h(context, "context");
        this.context = context.getApplicationContext();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object awaitLoad(Font font, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        AndroidFontLoader androidFontLoader;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        Object objLoadAsync = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                LL.b(objLoadAsync);
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            font = (Font) anonymousClass1.L$1;
            androidFontLoader = (AndroidFontLoader) anonymousClass1.L$0;
            LL.b(objLoadAsync);
            FontVariation.Settings variationSettings = ((ResourceFont) font).getVariationSettings();
            Context context = androidFontLoader.context;
            AbstractC4492zt.g(context, "context");
            return PlatformTypefacesKt.setFontVariationSettings((android.graphics.Typeface) objLoadAsync, variationSettings, context);
        }
        LL.b(objLoadAsync);
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
            Context context2 = this.context;
            AbstractC4492zt.g(context2, "context");
            anonymousClass1.label = 1;
            objLoadAsync = typefaceLoader.awaitLoad(context2, androidFont, anonymousClass1);
            return objLoadAsync == objD ? objD : objLoadAsync;
        }
        if (!(font instanceof ResourceFont)) {
            throw new IllegalArgumentException("Unknown font type: " + font);
        }
        Context context3 = this.context;
        AbstractC4492zt.g(context3, "context");
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = font;
        anonymousClass1.label = 2;
        objLoadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context3, anonymousClass1);
        if (objLoadAsync == objD) {
            return objD;
        }
        androidFontLoader = this;
        FontVariation.Settings variationSettings2 = ((ResourceFont) font).getVariationSettings();
        Context context4 = androidFontLoader.context;
        AbstractC4492zt.g(context4, "context");
        return PlatformTypefacesKt.setFontVariationSettings((android.graphics.Typeface) objLoadAsync, variationSettings2, context4);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public android.graphics.Typeface loadBlocking(Font font) {
        Object objA;
        android.graphics.Typeface typefaceLoad;
        AbstractC4492zt.h(font, "font");
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
            Context context = this.context;
            AbstractC4492zt.g(context, "context");
            return typefaceLoader.loadBlocking(context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int iMo4747getLoadingStrategyPKNRLFQ = font.mo4747getLoadingStrategyPKNRLFQ();
        FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
        if (FontLoadingStrategy.m4788equalsimpl0(iMo4747getLoadingStrategyPKNRLFQ, companion.m4793getBlockingPKNRLFQ())) {
            Context context2 = this.context;
            AbstractC4492zt.g(context2, "context");
            typefaceLoad = AndroidFontLoader_androidKt.load((ResourceFont) font, context2);
        } else {
            if (!FontLoadingStrategy.m4788equalsimpl0(iMo4747getLoadingStrategyPKNRLFQ, companion.m4794getOptionalLocalPKNRLFQ())) {
                if (FontLoadingStrategy.m4788equalsimpl0(iMo4747getLoadingStrategyPKNRLFQ, companion.m4792getAsyncPKNRLFQ())) {
                    throw new UnsupportedOperationException("Unsupported Async font load path");
                }
                throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m4790toStringimpl(font.mo4747getLoadingStrategyPKNRLFQ())));
            }
            try {
                KL.a aVar = KL.a;
                Context context3 = this.context;
                AbstractC4492zt.g(context3, "context");
                objA = KL.a(AndroidFontLoader_androidKt.load((ResourceFont) font, context3));
            } catch (Throwable th) {
                KL.a aVar2 = KL.a;
                objA = KL.a(LL.a(th));
            }
            typefaceLoad = (android.graphics.Typeface) (KL.c(objA) ? null : objA);
        }
        FontVariation.Settings variationSettings = ((ResourceFont) font).getVariationSettings();
        Context context4 = this.context;
        AbstractC4492zt.g(context4, "context");
        return PlatformTypefacesKt.setFontVariationSettings(typefaceLoad, variationSettings, context4);
    }
}
