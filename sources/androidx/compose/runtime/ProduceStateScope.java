package androidx.compose.runtime;

import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public interface ProduceStateScope<T> extends MutableState<T>, InterfaceC2052dg {
    Object awaitDispose(InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of);

    @Override // defpackage.InterfaceC2052dg
    /* synthetic */ InterfaceC0988Vf getCoroutineContext();
}
