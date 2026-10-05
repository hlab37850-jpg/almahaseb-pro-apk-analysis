package androidx.compose.runtime;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public class ThreadLocal<T> extends java.lang.ThreadLocal<T> {
    private final InterfaceC3588op initialValue;

    public ThreadLocal(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "initialValue");
        this.initialValue = interfaceC3588op;
    }

    @Override // java.lang.ThreadLocal
    public T get() {
        return (T) super.get();
    }

    @Override // java.lang.ThreadLocal
    public T initialValue() {
        return (T) this.initialValue.invoke();
    }

    @Override // java.lang.ThreadLocal
    public void remove() {
        super.remove();
    }

    @Override // java.lang.ThreadLocal
    public void set(T t) {
        super.set(t);
    }
}
