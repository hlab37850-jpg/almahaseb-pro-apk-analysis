package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextIndentSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$TextIndentSaver$2 INSTANCE = new SaversKt$TextIndentSaver$2();

    public SaversKt$TextIndentSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final TextIndent invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextUnit.Companion companion = TextUnit.Companion;
        Saver<TextUnit, Object> saver = SaversKt.getSaver(companion);
        Boolean bool = Boolean.FALSE;
        TextUnit textUnitRestore = null;
        TextUnit textUnitRestore2 = (AbstractC4492zt.d(obj2, bool) || obj2 == null) ? null : saver.restore(obj2);
        AbstractC4492zt.e(textUnitRestore2);
        long jM5350unboximpl = textUnitRestore2.m5350unboximpl();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver2 = SaversKt.getSaver(companion);
        if (!AbstractC4492zt.d(obj3, bool) && obj3 != null) {
            textUnitRestore = saver2.restore(obj3);
        }
        AbstractC4492zt.e(textUnitRestore);
        return new TextIndent(jM5350unboximpl, textUnitRestore.m5350unboximpl(), null);
    }
}
