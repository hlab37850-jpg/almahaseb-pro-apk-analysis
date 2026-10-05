package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldValue$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final TextFieldValue$Companion$Saver$2 INSTANCE = new TextFieldValue$Companion$Saver$2();

    public TextFieldValue$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final TextFieldValue invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<AnnotatedString, Object> annotatedStringSaver = SaversKt.getAnnotatedStringSaver();
        Boolean bool = Boolean.FALSE;
        TextRange textRangeRestore = null;
        AnnotatedString annotatedStringRestore = (AbstractC4492zt.d(obj2, bool) || obj2 == null) ? null : annotatedStringSaver.restore(obj2);
        AbstractC4492zt.e(annotatedStringRestore);
        Object obj3 = list.get(1);
        Saver<TextRange, Object> saver = SaversKt.getSaver(TextRange.Companion);
        if (!AbstractC4492zt.d(obj3, bool) && obj3 != null) {
            textRangeRestore = saver.restore(obj3);
        }
        AbstractC4492zt.e(textRangeRestore);
        return new TextFieldValue(annotatedStringRestore, textRangeRestore.m4709unboximpl(), (TextRange) null, 4, (AbstractC0419Di) null);
    }
}
