package androidx.compose.runtime;

import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableState<T> extends State<T> {
    T component1();

    InterfaceC3750qp component2();

    @Override // androidx.compose.runtime.State
    T getValue();

    void setValue(T t);
}
