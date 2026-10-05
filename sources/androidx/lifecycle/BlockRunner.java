package androidx.lifecycle;

import androidx.annotation.MainThread;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1043Xi;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public final class BlockRunner<T> {
    private final InterfaceC0526Fp block;
    private InterfaceC1830bu cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final InterfaceC3588op onDone;
    private InterfaceC1830bu runningJob;
    private final InterfaceC2052dg scope;
    private final long timeoutInMs;

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {188}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BlockRunner<T> blockRunner, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = blockRunner;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.this$0, interfaceC0793Of);
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
                long j = ((BlockRunner) this.this$0).timeoutInMs;
                this.label = 1;
                if (AbstractC1043Xi.a(j, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            if (!((BlockRunner) this.this$0).liveData.hasActiveObservers()) {
                InterfaceC1830bu interfaceC1830bu = ((BlockRunner) this.this$0).runningJob;
                if (interfaceC1830bu != null) {
                    InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
                }
                ((BlockRunner) this.this$0).runningJob = null;
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {ShapeTypes.MATH_MINUS}, m = "invokeSuspend")
    public static final class C16871 extends XS implements InterfaceC0526Fp {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16871(BlockRunner<T> blockRunner, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = blockRunner;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C16871 c16871 = new C16871(this.this$0, interfaceC0793Of);
            c16871.L$0 = obj;
            return c16871;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C16871) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(((BlockRunner) this.this$0).liveData, ((InterfaceC2052dg) this.L$0).getCoroutineContext());
                InterfaceC0526Fp interfaceC0526Fp = ((BlockRunner) this.this$0).block;
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(liveDataScopeImpl, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            ((BlockRunner) this.this$0).onDone.invoke();
            return FW.a;
        }
    }

    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, InterfaceC0526Fp interfaceC0526Fp, long j, InterfaceC2052dg interfaceC2052dg, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(coroutineLiveData, "liveData");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        AbstractC4492zt.h(interfaceC3588op, "onDone");
        this.liveData = coroutineLiveData;
        this.block = interfaceC0526Fp;
        this.timeoutInMs = j;
        this.scope = interfaceC2052dg;
        this.onDone = interfaceC3588op;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
        }
        this.cancellationJob = O8.d(this.scope, C0368Bj.c().I(), null, new AnonymousClass1(this, null), 2, null);
    }

    @MainThread
    public final void maybeRun() {
        InterfaceC1830bu interfaceC1830bu = this.cancellationJob;
        if (interfaceC1830bu != null) {
            InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = O8.d(this.scope, null, null, new C16871(this, null), 3, null);
    }
}
