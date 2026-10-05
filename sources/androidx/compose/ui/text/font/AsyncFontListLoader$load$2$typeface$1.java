package androidx.compose.ui.text.font;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {TIFFConstants.TIFFTAG_DOCUMENTNAME}, m = "invokeSuspend")
public final class AsyncFontListLoader$load$2$typeface$1 extends XS implements InterfaceC3750qp {
    final /* synthetic */ Font $font;
    int label;
    final /* synthetic */ AsyncFontListLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncFontListLoader$load$2$typeface$1(AsyncFontListLoader asyncFontListLoader, Font font, InterfaceC0793Of interfaceC0793Of) {
        super(1, interfaceC0793Of);
        this.this$0 = asyncFontListLoader;
        this.$font = font;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
        return new AsyncFontListLoader$load$2$typeface$1(this.this$0, this.$font, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
        return ((AsyncFontListLoader$load$2$typeface$1) create(interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            AsyncFontListLoader asyncFontListLoader = this.this$0;
            Font font = this.$font;
            this.label = 1;
            obj = asyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(font, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return obj;
    }
}
