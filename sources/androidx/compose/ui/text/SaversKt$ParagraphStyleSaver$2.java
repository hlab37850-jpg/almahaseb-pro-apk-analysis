package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$ParagraphStyleSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$ParagraphStyleSaver$2 INSTANCE = new SaversKt$ParagraphStyleSaver$2();

    public SaversKt$ParagraphStyleSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final ParagraphStyle invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
        Object obj3 = list.get(1);
        TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
        Object obj4 = list.get(2);
        Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.Companion);
        Boolean bool = Boolean.FALSE;
        TextUnit textUnitRestore = (AbstractC4492zt.d(obj4, bool) || obj4 == null) ? null : saver.restore(obj4);
        AbstractC4492zt.e(textUnitRestore);
        long jM5350unboximpl = textUnitRestore.m5350unboximpl();
        Object obj5 = list.get(3);
        return new ParagraphStyle(textAlign, textDirection, jM5350unboximpl, (AbstractC4492zt.d(obj5, bool) || obj5 == null) ? null : SaversKt.getSaver(TextIndent.Companion).restore(obj5), null, null, null, null, null, MetaDo.META_DELETEOBJECT, null);
    }
}
