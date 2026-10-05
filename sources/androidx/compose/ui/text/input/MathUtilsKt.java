package androidx.compose.ui.text.input;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i2, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "defaultValue");
        int i3 = i + i2;
        return ((i ^ i3) & (i2 ^ i3)) < 0 ? ((Number) interfaceC3588op.invoke()).intValue() : i3;
    }

    public static final int subtractExactOrElse(int i, int i2, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "defaultValue");
        int i3 = i - i2;
        return ((i ^ i3) & (i2 ^ i)) < 0 ? ((Number) interfaceC3588op.invoke()).intValue() : i3;
    }
}
