package androidx.compose.ui.text;

import androidx.compose.ui.text.android.selection.WordBoundary;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraph$wordBoundary$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AndroidParagraph this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidParagraph$wordBoundary$2(AndroidParagraph androidParagraph) {
        super(0);
        this.this$0 = androidParagraph;
    }

    @Override // defpackage.InterfaceC3588op
    public final WordBoundary invoke() {
        return new WordBoundary(this.this$0.getTextLocale$ui_text_release(), this.this$0.layout.getText());
    }
}
