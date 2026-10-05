package androidx.compose.runtime;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@Stable
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableCompositionLocal(InterfaceC3588op interfaceC3588op) {
        super(interfaceC3588op, null);
        AbstractC4492zt.h(interfaceC3588op, "defaultFactory");
    }

    public final ProvidedValue<T> provides(T t) {
        return new ProvidedValue<>(this, t, true);
    }

    public final ProvidedValue<T> providesDefault(T t) {
        return new ProvidedValue<>(this, t, false);
    }
}
