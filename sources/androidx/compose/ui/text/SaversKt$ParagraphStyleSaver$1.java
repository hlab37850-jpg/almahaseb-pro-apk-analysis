package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$ParagraphStyleSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$ParagraphStyleSaver$1 INSTANCE = new SaversKt$ParagraphStyleSaver$1();

    public SaversKt$ParagraphStyleSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SaverScope saverScope, ParagraphStyle paragraphStyle) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(paragraphStyle, "it");
        return AbstractC1886cc.g(SaversKt.save(paragraphStyle.m4620getTextAlignbuA522U()), SaversKt.save(paragraphStyle.m4622getTextDirectionmmuk1to()), SaversKt.save(TextUnit.m5331boximpl(paragraphStyle.m4619getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope), SaversKt.save(paragraphStyle.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), saverScope));
    }
}
