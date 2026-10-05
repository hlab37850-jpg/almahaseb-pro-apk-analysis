package androidx.compose.ui.text.font;

import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformFontLoader {
    Object awaitLoad(Font font, InterfaceC0793Of interfaceC0793Of);

    Object getCacheKey();

    Object loadBlocking(Font font);
}
