package androidx.compose.ui.text.font;

import defpackage.AbstractC0819Pf;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.ui.text.font.AsyncFontListLoader", f = "FontListFontFamilyTypefaceAdapter.kt", l = {300}, m = "loadWithTimeoutOrNull$ui_text_release")
public final class AsyncFontListLoader$loadWithTimeoutOrNull$1 extends AbstractC0819Pf {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncFontListLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncFontListLoader$loadWithTimeoutOrNull$1(AsyncFontListLoader asyncFontListLoader, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of);
        this.this$0 = asyncFontListLoader;
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadWithTimeoutOrNull$ui_text_release(null, this);
    }
}
