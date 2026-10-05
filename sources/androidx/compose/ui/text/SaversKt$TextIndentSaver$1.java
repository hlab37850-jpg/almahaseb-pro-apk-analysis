package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextIndentSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$TextIndentSaver$1 INSTANCE = new SaversKt$TextIndentSaver$1();

    public SaversKt$TextIndentSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SaverScope saverScope, TextIndent textIndent) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(textIndent, "it");
        TextUnit textUnitM5331boximpl = TextUnit.m5331boximpl(textIndent.m5088getFirstLineXSAIIZE());
        TextUnit.Companion companion = TextUnit.Companion;
        return AbstractC1886cc.g(SaversKt.save(textUnitM5331boximpl, SaversKt.getSaver(companion), saverScope), SaversKt.save(TextUnit.m5331boximpl(textIndent.m5089getRestLineXSAIIZE()), SaversKt.getSaver(companion), saverScope));
    }
}
