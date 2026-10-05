package androidx.compose.ui.text.font;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public final class DelegatingFontLoaderForDeprecatedUsage implements PlatformFontLoader {
    private final Object cacheKey;
    private final Font.ResourceLoader loader;

    public DelegatingFontLoaderForDeprecatedUsage(Font.ResourceLoader resourceLoader) {
        AbstractC4492zt.h(resourceLoader, "loader");
        this.loader = resourceLoader;
        this.cacheKey = new Object();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object awaitLoad(Font font, InterfaceC0793Of interfaceC0793Of) {
        return this.loader.load(font);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    public final Font.ResourceLoader getLoader$ui_text_release() {
        return this.loader;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object loadBlocking(Font font) {
        AbstractC4492zt.h(font, "font");
        return this.loader.load(font);
    }
}
