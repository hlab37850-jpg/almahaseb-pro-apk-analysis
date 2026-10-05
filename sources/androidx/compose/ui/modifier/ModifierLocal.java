package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@Stable
public abstract class ModifierLocal<T> {
    public static final int $stable = 0;
    private final InterfaceC3588op defaultFactory;

    public /* synthetic */ ModifierLocal(InterfaceC3588op interfaceC3588op, AbstractC0419Di abstractC0419Di) {
        this(interfaceC3588op);
    }

    public final InterfaceC3588op getDefaultFactory$ui_release() {
        return this.defaultFactory;
    }

    private ModifierLocal(InterfaceC3588op interfaceC3588op) {
        this.defaultFactory = interfaceC3588op;
    }
}
