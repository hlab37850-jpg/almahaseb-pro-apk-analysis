package defpackage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PJ extends AtomicReference implements InterfaceC0624Jj {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PJ(Object obj) {
        super(obj);
        Objects.requireNonNull(obj, "value is null");
    }

    public abstract void a(Object obj);

    @Override // defpackage.InterfaceC0624Jj
    public final void dispose() {
        Object andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // defpackage.InterfaceC0624Jj
    public final boolean isDisposed() {
        return get() == null;
    }
}
