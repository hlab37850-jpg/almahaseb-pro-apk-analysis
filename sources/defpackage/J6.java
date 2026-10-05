package defpackage;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class J6 {
    public static long a(AwaitPointerEventScope awaitPointerEventScope) {
        return Size.Companion.m2876getZeroNHjbRc();
    }

    public static Object b(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        return u(awaitPointerEventScope, j, interfaceC0526Fp, interfaceC0793Of);
    }

    public static Object c(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        return v(awaitPointerEventScope, j, interfaceC0526Fp, interfaceC0793Of);
    }

    public static /* synthetic */ Object t(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitPointerEventScope.awaitPointerEvent(pointerEventPass, interfaceC0793Of);
    }

    public static /* synthetic */ Object u(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        return interfaceC0526Fp.mo13invoke(awaitPointerEventScope, interfaceC0793Of);
    }

    public static /* synthetic */ Object v(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        return interfaceC0526Fp.mo13invoke(awaitPointerEventScope, interfaceC0793Of);
    }
}
