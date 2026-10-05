package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    private final InterfaceC3750qp createDefaultTypeface;
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final PlatformFontLoader platformFontLoader;
    private final PlatformResolveInterceptor platformResolveInterceptor;
    private final TypefaceRequestCache typefaceRequestCache;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", f = "FontFamilyResolver.kt", l = {45}, m = "preload")
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
            return FontFamilyResolverImpl.this.preload(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            public final void invoke(TypefaceResult.Immutable immutable) {
                AbstractC4492zt.h(immutable, "it");
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TypefaceResult.Immutable) obj);
                return FW.a;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01382 extends AbstractC2233fv implements InterfaceC3750qp {
            public static final C01382 INSTANCE = new C01382();

            public C01382() {
                super(1);
            }

            public final void invoke(TypefaceResult.Immutable immutable) {
                AbstractC4492zt.h(immutable, "it");
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TypefaceResult.Immutable) obj);
                return FW.a;
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final TypefaceResult invoke(TypefaceRequest typefaceRequest) {
            AbstractC4492zt.h(typefaceRequest, "typeRequest");
            TypefaceResult typefaceResultResolve = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), AnonymousClass1.INSTANCE, FontFamilyResolverImpl.this.createDefaultTypeface);
            if (typefaceResultResolve == null && (typefaceResultResolve = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), C01382.INSTANCE, FontFamilyResolverImpl.this.createDefaultTypeface)) == null) {
                throw new IllegalStateException("Could not load font");
            }
            return typefaceResultResolve;
        }
    }

    public FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        AbstractC4492zt.h(platformFontLoader, "platformFontLoader");
        AbstractC4492zt.h(platformResolveInterceptor, "platformResolveInterceptor");
        AbstractC4492zt.h(typefaceRequestCache, "typefaceRequestCache");
        AbstractC4492zt.h(fontListFontFamilyTypefaceAdapter, "fontListFontFamilyTypefaceAdapter");
        AbstractC4492zt.h(platformFontFamilyTypefaceAdapter, "platformFamilyTypefaceAdapter");
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new FontFamilyResolverImpl$createDefaultTypeface$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State<Object> resolve(TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new FontFamilyResolverImpl$resolve$result$1(this, typefaceRequest));
    }

    public final PlatformFontLoader getPlatformFontLoader$ui_text_release() {
        return this.platformFontLoader;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    public Object preload(FontFamily fontFamily, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FontFamilyResolverImpl fontFamilyResolverImpl;
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
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(obj);
            if (!(fontFamily instanceof FontListFontFamily)) {
                return FW.a;
            }
            FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.fontListFontFamilyTypefaceAdapter;
            PlatformFontLoader platformFontLoader = this.platformFontLoader;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = fontFamily;
            anonymousClass1.label = 1;
            if (fontListFontFamilyTypefaceAdapter.preload(fontFamily, platformFontLoader, anonymousClass1) == objD) {
                return objD;
            }
            fontFamilyResolverImpl = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fontFamily = (FontFamily) anonymousClass1.L$1;
            fontFamilyResolverImpl = (FontFamilyResolverImpl) anonymousClass1.L$0;
            LL.b(obj);
        }
        List<Font> fonts = ((FontListFontFamily) fontFamily).getFonts();
        ArrayList arrayList = new ArrayList(fonts.size());
        int size = fonts.size();
        for (int i3 = 0; i3 < size; i3++) {
            Font font = fonts.get(i3);
            arrayList.add(new TypefaceRequest(fontFamilyResolverImpl.platformResolveInterceptor.interceptFontFamily(fontFamily), fontFamilyResolverImpl.platformResolveInterceptor.interceptFontWeight(font.getWeight()), fontFamilyResolverImpl.platformResolveInterceptor.mo4754interceptFontStyleT2F_aPo(font.mo4757getStyle_LCdwA()), FontSynthesis.Companion.m4816getAllGVVA2EU(), fontFamilyResolverImpl.platformFontLoader.getCacheKey(), null));
        }
        fontFamilyResolverImpl.typefaceRequestCache.preWarmCache(arrayList, fontFamilyResolverImpl.new AnonymousClass2());
        return FW.a;
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /* JADX INFO: renamed from: resolve-DPcqOEQ */
    public State<Object> mo4776resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
        AbstractC4492zt.h(fontWeight, "fontWeight");
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.mo4754interceptFontStyleT2F_aPo(i), this.platformResolveInterceptor.mo4755interceptFontSynthesisMscr08Y(i2), this.platformFontLoader.getCacheKey(), null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i, AbstractC0419Di abstractC0419Di) {
        this(platformFontLoader, (i & 2) != 0 ? PlatformResolveInterceptor.Companion.getDefault$ui_text_release() : platformResolveInterceptor, (i & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache, (i & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, 0 == true ? 1 : 0) : fontListFontFamilyTypefaceAdapter, (i & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }
}
