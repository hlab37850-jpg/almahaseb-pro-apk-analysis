package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.animation.core.InfiniteTransition$run$1", f = "InfiniteTransition.kt", l = {ShapeTypes.MATH_NOT_EQUAL, 205}, m = "invokeSuspend")
public final class InfiniteTransition$run$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ MutableState<State<Long>> $toolingOverride;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InfiniteTransition this$0;

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC2052dg $$this$LaunchedEffect;
        final /* synthetic */ LJ $durationScale;
        final /* synthetic */ MutableState<State<Long>> $toolingOverride;
        final /* synthetic */ InfiniteTransition this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MutableState<State<Long>> mutableState, InfiniteTransition infiniteTransition, LJ lj, InterfaceC2052dg interfaceC2052dg) {
            super(1);
            this.$toolingOverride = mutableState;
            this.this$0 = infiniteTransition;
            this.$durationScale = lj;
            this.$$this$LaunchedEffect = interfaceC2052dg;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).longValue());
            return FW.a;
        }

        public final void invoke(long j) {
            State<Long> value = this.$toolingOverride.getValue();
            long jLongValue = value != null ? value.getValue().longValue() : j;
            int i = 0;
            if (this.this$0.startTimeNanos == Long.MIN_VALUE || this.$durationScale.a != SuspendAnimationKt.getDurationScale(this.$$this$LaunchedEffect.getCoroutineContext())) {
                this.this$0.startTimeNanos = j;
                MutableVector mutableVector = this.this$0._animations;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i2 = 0;
                    do {
                        ((InfiniteTransition.TransitionAnimationState) content[i2]).reset$animation_core_release();
                        i2++;
                    } while (i2 < size);
                }
                this.$durationScale.a = SuspendAnimationKt.getDurationScale(this.$$this$LaunchedEffect.getCoroutineContext());
            }
            if (this.$durationScale.a != 0.0f) {
                this.this$0.onFrame((long) ((jLongValue - this.this$0.startTimeNanos) / this.$durationScale.a));
                return;
            }
            MutableVector mutableVector2 = this.this$0._animations;
            int size2 = mutableVector2.getSize();
            if (size2 > 0) {
                Object[] content2 = mutableVector2.getContent();
                do {
                    ((InfiniteTransition.TransitionAnimationState) content2[i]).skipToEnd$animation_core_release();
                    i++;
                } while (i < size2);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC2052dg $$this$LaunchedEffect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC2052dg interfaceC2052dg) {
            super(0);
            this.$$this$LaunchedEffect = interfaceC2052dg;
        }

        @Override // defpackage.InterfaceC3588op
        public final Float invoke() {
            return Float.valueOf(SuspendAnimationKt.getDurationScale(this.$$this$LaunchedEffect.getCoroutineContext()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$3, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.InfiniteTransition$run$1$3", f = "InfiniteTransition.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
        /* synthetic */ float F$0;
        int label;

        public AnonymousClass3(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(interfaceC0793Of);
            anonymousClass3.F$0 = ((Number) obj).floatValue();
            return anonymousClass3;
        }

        public final Object invoke(float f, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass3) create(Float.valueOf(f), interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return E8.a(this.F$0 > 0.0f);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).floatValue(), (InterfaceC0793Of) obj2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfiniteTransition$run$1(MutableState<State<Long>> mutableState, InfiniteTransition infiniteTransition, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$toolingOverride = mutableState;
        this.this$0 = infiniteTransition;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        InfiniteTransition$run$1 infiniteTransition$run$1 = new InfiniteTransition$run$1(this.$toolingOverride, this.this$0, interfaceC0793Of);
        infiniteTransition$run$1.L$0 = obj;
        return infiniteTransition$run$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((InfiniteTransition$run$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x005d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0078 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005b -> B:11:0x0040). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0076 -> B:11:0x0040). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.AbstractC2171f7
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r7.L$1
            LJ r1 = (defpackage.LJ) r1
            java.lang.Object r4 = r7.L$0
            dg r4 = (defpackage.InterfaceC2052dg) r4
            defpackage.LL.b(r8)
            r8 = r4
            goto L40
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L23:
            java.lang.Object r1 = r7.L$1
            LJ r1 = (defpackage.LJ) r1
            java.lang.Object r4 = r7.L$0
            dg r4 = (defpackage.InterfaceC2052dg) r4
            defpackage.LL.b(r8)
            r8 = r4
            goto L56
        L30:
            defpackage.LL.b(r8)
            java.lang.Object r8 = r7.L$0
            dg r8 = (defpackage.InterfaceC2052dg) r8
            LJ r1 = new LJ
            r1.<init>()
            r4 = 1065353216(0x3f800000, float:1.0)
            r1.a = r4
        L40:
            androidx.compose.animation.core.InfiniteTransition$run$1$1 r4 = new androidx.compose.animation.core.InfiniteTransition$run$1$1
            androidx.compose.runtime.MutableState<androidx.compose.runtime.State<java.lang.Long>> r5 = r7.$toolingOverride
            androidx.compose.animation.core.InfiniteTransition r6 = r7.this$0
            r4.<init>(r5, r6, r1, r8)
            r7.L$0 = r8
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r4 = androidx.compose.animation.core.InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r4, r7)
            if (r4 != r0) goto L56
            return r0
        L56:
            float r4 = r1.a
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L40
            androidx.compose.animation.core.InfiniteTransition$run$1$2 r4 = new androidx.compose.animation.core.InfiniteTransition$run$1$2
            r4.<init>(r8)
            Tm r4 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r4)
            androidx.compose.animation.core.InfiniteTransition$run$1$3 r5 = new androidx.compose.animation.core.InfiniteTransition$run$1$3
            r6 = 0
            r5.<init>(r6)
            r7.L$0 = r8
            r7.L$1 = r1
            r7.label = r2
            java.lang.Object r4 = defpackage.AbstractC1047Xm.q(r4, r5, r7)
            if (r4 != r0) goto L40
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.InfiniteTransition$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
