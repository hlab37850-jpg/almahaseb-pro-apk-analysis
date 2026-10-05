package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TextKt$LocalTextStyle$1 extends AbstractC2233fv implements InterfaceC3588op {
    public static final TextKt$LocalTextStyle$1 INSTANCE = new TextKt$LocalTextStyle$1();

    public TextKt$LocalTextStyle$1() {
        super(0);
    }

    @Override // defpackage.InterfaceC3588op
    public final TextStyle invoke() {
        return TypographyKt.getDefaultTextStyle();
    }
}
