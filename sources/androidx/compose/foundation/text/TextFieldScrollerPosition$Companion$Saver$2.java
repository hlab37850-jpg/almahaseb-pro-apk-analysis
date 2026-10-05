package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldScrollerPosition$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final TextFieldScrollerPosition$Companion$Saver$2 INSTANCE = new TextFieldScrollerPosition$Companion$Saver$2();

    public TextFieldScrollerPosition$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final TextFieldScrollerPosition invoke(List<? extends Object> list) {
        AbstractC4492zt.h(list, "restored");
        Object obj = list.get(1);
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Boolean");
        Orientation orientation = ((Boolean) obj).booleanValue() ? Orientation.Vertical : Orientation.Horizontal;
        Object obj2 = list.get(0);
        AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Float");
        return new TextFieldScrollerPosition(orientation, ((Float) obj2).floatValue());
    }
}
