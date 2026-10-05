package androidx.compose.ui.text.font;

import android.content.Context;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidPreloadedFont extends AndroidFont {
    private boolean didInitWithContext;
    private final int style;
    private android.graphics.Typeface typeface;
    private final FontWeight weight;

    public /* synthetic */ AndroidPreloadedFont(FontWeight fontWeight, int i, FontVariation.Settings settings, AbstractC0419Di abstractC0419Di) {
        this(fontWeight, i, settings);
    }

    public abstract android.graphics.Typeface doLoad$ui_text_release(Context context);

    public abstract String getCacheKey();

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: not valid java name */
    public final int mo4757getStyle_LCdwA() {
        return this.style;
    }

    public final android.graphics.Typeface getTypeface$ui_text_release() {
        return this.typeface;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final FontWeight getWeight() {
        return this.weight;
    }

    public final android.graphics.Typeface loadCached$ui_text_release(Context context) {
        AbstractC4492zt.h(context, "context");
        if (!this.didInitWithContext && this.typeface == null) {
            this.typeface = doLoad$ui_text_release(context);
        }
        this.didInitWithContext = true;
        return this.typeface;
    }

    public final void setTypeface$ui_text_release(android.graphics.Typeface typeface) {
        this.typeface = typeface;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AndroidPreloadedFont(FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.Companion.m4793getBlockingPKNRLFQ(), AndroidPreloadedFontTypefaceLoader.INSTANCE, settings, null);
        AbstractC4492zt.h(fontWeight, "weight");
        AbstractC4492zt.h(settings, "variationSettings");
        this.weight = fontWeight;
        this.style = i;
    }
}
