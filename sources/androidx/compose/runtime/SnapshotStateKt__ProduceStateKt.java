package androidx.compose.runtime;

import com.itextpdf.text.Meta;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__ProduceStateKt {

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1", f = "ProduceState.kt", l = {83}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, MutableState<T> mutableState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$producer = interfaceC0526Fp;
            this.$result = mutableState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$producer, this.$result, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                InterfaceC0526Fp interfaceC0526Fp = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, interfaceC2052dg.getCoroutineContext());
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(produceStateScopeImpl, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$2", f = "ProduceState.kt", l = {116}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0526Fp interfaceC0526Fp, MutableState<T> mutableState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$producer = interfaceC0526Fp;
            this.$result = mutableState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$producer, this.$result, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                InterfaceC0526Fp interfaceC0526Fp = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, interfaceC2052dg.getCoroutineContext());
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(produceStateScopeImpl, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$3", f = "ProduceState.kt", l = {150}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, MutableState<T> mutableState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$producer = interfaceC0526Fp;
            this.$result = mutableState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$producer, this.$result, interfaceC0793Of);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass3) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                InterfaceC0526Fp interfaceC0526Fp = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, interfaceC2052dg.getCoroutineContext());
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(produceStateScopeImpl, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$4, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$4", f = "ProduceState.kt", l = {ShapeTypes.CHART_X}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC0526Fp interfaceC0526Fp, MutableState<T> mutableState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$producer = interfaceC0526Fp;
            this.$result = mutableState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$producer, this.$result, interfaceC0793Of);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass4) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                InterfaceC0526Fp interfaceC0526Fp = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, interfaceC2052dg.getCoroutineContext());
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(produceStateScopeImpl, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$5", f = "ProduceState.kt", l = {219}, m = "invokeSuspend")
    public static final class AnonymousClass5 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $producer;
        final /* synthetic */ MutableState<T> $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(InterfaceC0526Fp interfaceC0526Fp, MutableState<T> mutableState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$producer = interfaceC0526Fp;
            this.$result = mutableState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$producer, this.$result, interfaceC0793Of);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass5) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                InterfaceC0526Fp interfaceC0526Fp = this.$producer;
                ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(this.$result, interfaceC2052dg.getCoroutineContext());
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(produceStateScopeImpl, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    @Composable
    public static final <T> State<T> produceState(T t, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0526Fp, Meta.PRODUCER);
        composer.startReplaceableGroup(10454275);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10454275, i, -1, "androidx.compose.runtime.produceState (ProduceState.kt:76)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(FW.a, new AnonymousClass1(interfaceC0526Fp, mutableState, null), composer, 70);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object obj, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0526Fp, Meta.PRODUCER);
        composer.startReplaceableGroup(-1928268701);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928268701, i, -1, "androidx.compose.runtime.produceState (ProduceState.kt:108)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(obj, new AnonymousClass2(interfaceC0526Fp, mutableState, null), composer, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object obj, Object obj2, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0526Fp, Meta.PRODUCER);
        composer.startReplaceableGroup(-1703169085);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1703169085, i, -1, "androidx.compose.runtime.produceState (ProduceState.kt:141)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(obj, obj2, new AnonymousClass3(interfaceC0526Fp, mutableState, null), composer, 584);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object obj, Object obj2, Object obj3, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0526Fp, Meta.PRODUCER);
        composer.startReplaceableGroup(1807205155);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1807205155, i, -1, "androidx.compose.runtime.produceState (ProduceState.kt:175)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(obj, obj2, obj3, new AnonymousClass4(interfaceC0526Fp, mutableState, null), composer, 4680);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object[] objArr, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        AbstractC4492zt.h(objArr, "keys");
        AbstractC4492zt.h(interfaceC0526Fp, Meta.PRODUCER);
        composer.startReplaceableGroup(490154582);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(490154582, i, -1, "androidx.compose.runtime.produceState (ProduceState.kt:210)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(Arrays.copyOf(objArr, objArr.length), (InterfaceC0526Fp) new AnonymousClass5(interfaceC0526Fp, mutableState, null), composer, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
