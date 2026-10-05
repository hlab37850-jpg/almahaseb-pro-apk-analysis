package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ExpectKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.ExpectKt$ThreadLocal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final T invoke() {
            return null;
        }
    }

    public static final <T> ThreadLocal<T> ThreadLocal() {
        return new ThreadLocal<>(AnonymousClass1.INSTANCE);
    }

    public static final int postIncrement(AtomicInt atomicInt) {
        AbstractC4492zt.h(atomicInt, "<this>");
        return atomicInt.add(1) - 1;
    }
}
