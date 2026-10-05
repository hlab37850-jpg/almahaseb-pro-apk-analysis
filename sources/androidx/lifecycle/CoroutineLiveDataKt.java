package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;
import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ LiveData<T> $source;
        final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MediatorLiveData<T> mediatorLiveData) {
                super(1);
                this.$this_addDisposableSource = mediatorLiveData;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m5421invoke(obj);
                return FW.a;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m5421invoke(T t) {
                this.$this_addDisposableSource.setValue(t);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.$this_addDisposableSource, this.$source, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            MediatorLiveData<T> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.addSource(this.$source, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(mediatorLiveData)));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, InterfaceC0793Of interfaceC0793Of) {
        return M8.g(C0368Bj.c().I(), new AnonymousClass2(mediatorLiveData, liveData, null), interfaceC0793Of);
    }

    public static final <T> LiveData<T> liveData(InterfaceC0988Vf interfaceC0988Vf, long j, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return new CoroutineLiveData(interfaceC0988Vf, j, interfaceC0526Fp);
    }

    public static /* synthetic */ LiveData liveData$default(InterfaceC0988Vf interfaceC0988Vf, long j, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        if ((i & 2) != 0) {
            j = DEFAULT_TIMEOUT;
        }
        return liveData(interfaceC0988Vf, j, interfaceC0526Fp);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(InterfaceC0988Vf interfaceC0988Vf, Duration duration, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        AbstractC4492zt.h(duration, "timeout");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return new CoroutineLiveData(interfaceC0988Vf, Api26Impl.INSTANCE.toMillis(duration), interfaceC0526Fp);
    }

    public static /* synthetic */ LiveData liveData$default(InterfaceC0988Vf interfaceC0988Vf, Duration duration, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        return liveData(interfaceC0988Vf, duration, interfaceC0526Fp);
    }
}
