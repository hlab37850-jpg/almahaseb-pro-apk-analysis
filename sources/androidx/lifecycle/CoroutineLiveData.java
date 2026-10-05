package androidx.lifecycle;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.TS;

/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ CoroutineLiveData<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoroutineLiveData<T> coroutineLiveData) {
            super(0);
            this.this$0 = coroutineLiveData;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5420invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5420invoke() {
            ((CoroutineLiveData) this.this$0).blockRunner = null;
        }
    }

    public /* synthetic */ CoroutineLiveData(InterfaceC0988Vf interfaceC0988Vf, long j, InterfaceC0526Fp interfaceC0526Fp, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? C1172Zk.a : interfaceC0988Vf, (i & 2) != 0 ? CoroutineLiveDataKt.DEFAULT_TIMEOUT : j, interfaceC0526Fp);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object clearSource$lifecycle_livedata_ktx_release(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        CoroutineLiveData<T> coroutineLiveData;
        if (interfaceC0793Of instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) interfaceC0793Of;
            int i = coroutineLiveData$clearSource$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, interfaceC0793Of);
            }
        } else {
            coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, interfaceC0793Of);
        }
        Object obj = coroutineLiveData$clearSource$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = coroutineLiveData$clearSource$1.label;
        if (i2 == 0) {
            LL.b(obj);
            EmittedSource emittedSource = this.emittedSource;
            if (emittedSource != null) {
                coroutineLiveData$clearSource$1.L$0 = this;
                coroutineLiveData$clearSource$1.label = 1;
                if (emittedSource.disposeNow(coroutineLiveData$clearSource$1) == objD) {
                    return objD;
                }
            }
            coroutineLiveData = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
            LL.b(obj);
        }
        coroutineLiveData.emittedSource = null;
        return FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        if (interfaceC0793Of instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) interfaceC0793Of;
            int i = coroutineLiveData$emitSource$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, interfaceC0793Of);
            }
        } else {
            coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, interfaceC0793Of);
        }
        Object objAddDisposableSource = coroutineLiveData$emitSource$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = coroutineLiveData$emitSource$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                LiveData<T> liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                CoroutineLiveData<T> coroutineLiveData2 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                LL.b(objAddDisposableSource);
                liveData2 = liveData3;
                coroutineLiveData = coroutineLiveData2;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                LL.b(objAddDisposableSource);
            }
            EmittedSource emittedSource = (EmittedSource) objAddDisposableSource;
            coroutineLiveData.emittedSource = emittedSource;
            return emittedSource;
        }
        LL.b(objAddDisposableSource);
        coroutineLiveData$emitSource$1.L$0 = this;
        coroutineLiveData$emitSource$1.L$1 = liveData;
        coroutineLiveData$emitSource$1.label = 1;
        if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == objD) {
            return objD;
        }
        liveData2 = liveData;
        coroutineLiveData = this;
        coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
        coroutineLiveData$emitSource$1.L$1 = null;
        coroutineLiveData$emitSource$1.label = 2;
        objAddDisposableSource = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
        if (objAddDisposableSource == objD) {
            return objD;
        }
        EmittedSource emittedSource2 = (EmittedSource) objAddDisposableSource;
        coroutineLiveData.emittedSource = emittedSource2;
        return emittedSource2;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }

    public CoroutineLiveData(InterfaceC0988Vf interfaceC0988Vf, long j, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        this.blockRunner = new BlockRunner<>(this, interfaceC0526Fp, j, AbstractC2133eg.a(C0368Bj.c().I().plus(interfaceC0988Vf).plus(TS.a((InterfaceC1830bu) interfaceC0988Vf.get(InterfaceC1830bu.s)))), new AnonymousClass1(this));
    }
}
