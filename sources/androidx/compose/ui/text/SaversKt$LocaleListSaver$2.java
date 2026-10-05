package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$LocaleListSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$LocaleListSaver$2 INSTANCE = new SaversKt$LocaleListSaver$2();

    public SaversKt$LocaleListSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final LocaleList invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            Saver<Locale, Object> saver = SaversKt.getSaver(Locale.Companion);
            Locale localeRestore = null;
            if (!AbstractC4492zt.d(obj2, Boolean.FALSE) && obj2 != null) {
                localeRestore = saver.restore(obj2);
            }
            AbstractC4492zt.e(localeRestore);
            arrayList.add(localeRestore);
        }
        return new LocaleList(arrayList);
    }
}
