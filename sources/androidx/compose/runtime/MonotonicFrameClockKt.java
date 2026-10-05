package androidx.compose.runtime;

import androidx.compose.animation.core.AnimationKt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class MonotonicFrameClockKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.MonotonicFrameClockKt$withFrameMillis$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$onFrame = interfaceC3750qp;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [R, java.lang.Object] */
        public final R invoke(long j) {
            return this.$onFrame.invoke(Long.valueOf(j / AnimationKt.MillisToNanos));
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }
    }

    public static final MonotonicFrameClock getMonotonicFrameClock(InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0988Vf, "<this>");
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) interfaceC0988Vf.get(MonotonicFrameClock.Key);
        if (monotonicFrameClock != null) {
            return monotonicFrameClock;
        }
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
    }

    public static final <R> Object withFrameMillis(MonotonicFrameClock monotonicFrameClock, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return monotonicFrameClock.withFrameNanos(new AnonymousClass2(interfaceC3750qp), interfaceC0793Of);
    }

    private static final <R> Object withFrameMillis$$forInline(MonotonicFrameClock monotonicFrameClock, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC3750qp);
        AbstractC0703Ks.c(0);
        Object objWithFrameNanos = monotonicFrameClock.withFrameNanos(anonymousClass2, interfaceC0793Of);
        AbstractC0703Ks.c(1);
        return objWithFrameNanos;
    }

    public static final <R> Object withFrameNanos(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return getMonotonicFrameClock(interfaceC0793Of.getContext()).withFrameNanos(interfaceC3750qp, interfaceC0793Of);
    }

    public static final <R> Object withFrameMillis(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return getMonotonicFrameClock(interfaceC0793Of.getContext()).withFrameNanos(new AnonymousClass2(interfaceC3750qp), interfaceC0793Of);
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getMonotonicFrameClock$annotations(InterfaceC0988Vf interfaceC0988Vf) {
    }
}
