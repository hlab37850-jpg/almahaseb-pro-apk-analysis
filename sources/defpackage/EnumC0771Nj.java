package defpackage;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Nj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC0771Nj implements InterfaceC0624Jj {
    DISPOSED;

    public static boolean a(AtomicReference atomicReference) {
        InterfaceC0624Jj interfaceC0624Jj;
        InterfaceC0624Jj interfaceC0624Jj2 = (InterfaceC0624Jj) atomicReference.get();
        EnumC0771Nj enumC0771Nj = DISPOSED;
        if (interfaceC0624Jj2 == enumC0771Nj || (interfaceC0624Jj = (InterfaceC0624Jj) atomicReference.getAndSet(enumC0771Nj)) == enumC0771Nj) {
            return false;
        }
        if (interfaceC0624Jj == null) {
            return true;
        }
        interfaceC0624Jj.dispose();
        return true;
    }

    public static boolean b(InterfaceC0624Jj interfaceC0624Jj) {
        return interfaceC0624Jj == DISPOSED;
    }

    public static boolean c(AtomicReference atomicReference, InterfaceC0624Jj interfaceC0624Jj) {
        InterfaceC0624Jj interfaceC0624Jj2;
        do {
            interfaceC0624Jj2 = (InterfaceC0624Jj) atomicReference.get();
            if (interfaceC0624Jj2 == DISPOSED) {
                if (interfaceC0624Jj == null) {
                    return false;
                }
                interfaceC0624Jj.dispose();
                return false;
            }
        } while (!FC.a(atomicReference, interfaceC0624Jj2, interfaceC0624Jj));
        return true;
    }

    public static void e() {
        FM.m(new C4447zI("Disposable already set!"));
    }

    public static boolean f(AtomicReference atomicReference, InterfaceC0624Jj interfaceC0624Jj) {
        InterfaceC0624Jj interfaceC0624Jj2;
        do {
            interfaceC0624Jj2 = (InterfaceC0624Jj) atomicReference.get();
            if (interfaceC0624Jj2 == DISPOSED) {
                if (interfaceC0624Jj == null) {
                    return false;
                }
                interfaceC0624Jj.dispose();
                return false;
            }
        } while (!FC.a(atomicReference, interfaceC0624Jj2, interfaceC0624Jj));
        if (interfaceC0624Jj2 == null) {
            return true;
        }
        interfaceC0624Jj2.dispose();
        return true;
    }

    public static boolean h(AtomicReference atomicReference, InterfaceC0624Jj interfaceC0624Jj) {
        Objects.requireNonNull(interfaceC0624Jj, "d is null");
        if (FC.a(atomicReference, null, interfaceC0624Jj)) {
            return true;
        }
        interfaceC0624Jj.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        e();
        return false;
    }

    public static boolean i(InterfaceC0624Jj interfaceC0624Jj, InterfaceC0624Jj interfaceC0624Jj2) {
        if (interfaceC0624Jj2 == null) {
            FM.m(new NullPointerException("next is null"));
            return false;
        }
        if (interfaceC0624Jj == null) {
            return true;
        }
        interfaceC0624Jj2.dispose();
        e();
        return false;
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return true;
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
    }
}
