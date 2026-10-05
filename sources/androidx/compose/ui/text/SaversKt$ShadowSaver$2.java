package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$ShadowSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$ShadowSaver$2 INSTANCE = new SaversKt$ShadowSaver$2();

    public SaversKt$ShadowSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Shadow invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<Color, Object> saver = SaversKt.getSaver(Color.Companion);
        Boolean bool = Boolean.FALSE;
        Color colorRestore = (AbstractC4492zt.d(obj2, bool) || obj2 == null) ? null : saver.restore(obj2);
        AbstractC4492zt.e(colorRestore);
        long jM3042unboximpl = colorRestore.m3042unboximpl();
        Object obj3 = list.get(1);
        Offset offsetRestore = (AbstractC4492zt.d(obj3, bool) || obj3 == null) ? null : SaversKt.getSaver(Offset.Companion).restore(obj3);
        AbstractC4492zt.e(offsetRestore);
        long jM2808unboximpl = offsetRestore.m2808unboximpl();
        Object obj4 = list.get(2);
        Float f = obj4 != null ? (Float) obj4 : null;
        AbstractC4492zt.e(f);
        return new Shadow(jM3042unboximpl, jM2808unboximpl, f.floatValue(), null);
    }
}
