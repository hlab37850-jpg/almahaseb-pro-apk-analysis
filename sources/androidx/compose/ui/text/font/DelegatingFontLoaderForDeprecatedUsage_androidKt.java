package androidx.compose.ui.text.font;

import android.content.Context;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class DelegatingFontLoaderForDeprecatedUsage_androidKt {
    public static final FontFamily.Resolver createFontFamilyResolver(Font.ResourceLoader resourceLoader, Context context) {
        AbstractC4492zt.h(resourceLoader, "fontResourceLoader");
        AbstractC4492zt.h(context, "context");
        Context applicationContext = context.getApplicationContext();
        AbstractC4492zt.g(applicationContext, "context.applicationContext");
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForBridgeUsage(resourceLoader, applicationContext), null, null, null, null, 30, null);
    }

    public static final FontFamily.Resolver createFontFamilyResolver(Font.ResourceLoader resourceLoader) {
        AbstractC4492zt.h(resourceLoader, "fontResourceLoader");
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForDeprecatedUsage(resourceLoader), null, null, null, null, 30, null);
    }
}
