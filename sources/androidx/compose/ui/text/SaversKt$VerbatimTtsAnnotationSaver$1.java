package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$VerbatimTtsAnnotationSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$VerbatimTtsAnnotationSaver$1 INSTANCE = new SaversKt$VerbatimTtsAnnotationSaver$1();

    public SaversKt$VerbatimTtsAnnotationSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(verbatimTtsAnnotation, "it");
        return SaversKt.save(verbatimTtsAnnotation.getVerbatim());
    }
}
