package androidx.compose.ui.text;

import androidx.compose.ui.text.caches.LruCache;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutCache {
    private final LruCache<CacheTextLayoutInput, TextLayoutResult> lruCache;

    public TextLayoutCache() {
        this(0, 1, null);
    }

    public final TextLayoutResult get(TextLayoutInput textLayoutInput) {
        AbstractC4492zt.h(textLayoutInput, "key");
        TextLayoutResult textLayoutResult = this.lruCache.get(new CacheTextLayoutInput(textLayoutInput));
        if (textLayoutResult == null || textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return null;
        }
        return textLayoutResult;
    }

    public final TextLayoutResult put(TextLayoutInput textLayoutInput, TextLayoutResult textLayoutResult) {
        AbstractC4492zt.h(textLayoutInput, "key");
        AbstractC4492zt.h(textLayoutResult, "value");
        return this.lruCache.put(new CacheTextLayoutInput(textLayoutInput), textLayoutResult);
    }

    public final TextLayoutResult remove(TextLayoutInput textLayoutInput) {
        AbstractC4492zt.h(textLayoutInput, "key");
        return this.lruCache.remove(new CacheTextLayoutInput(textLayoutInput));
    }

    public TextLayoutCache(int i) {
        this.lruCache = new LruCache<>(i);
    }

    public /* synthetic */ TextLayoutCache(int i, int i2, AbstractC0419Di abstractC0419Di) {
        this((i2 & 1) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }
}
