package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1165Zd;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.GC;
import defpackage.IC;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1038Xd;
import defpackage.InterfaceC3252ki;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
public final class UnbatchedFlowCombiner<T1, T2> {
    private final InterfaceC1038Xd initialDispatched;
    private final GC lock;
    private final InterfaceC0578Hp send;
    private final InterfaceC1038Xd[] valueReceived;
    private final Object[] values;

    /* JADX INFO: renamed from: androidx.paging.UnbatchedFlowCombiner$onNext$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.UnbatchedFlowCombiner", f = "FlowExt.kt", l = {191, 230, 208}, m = "onNext")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ UnbatchedFlowCombiner<T1, T2> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = unbatchedFlowCombiner;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onNext(0, null, this);
        }
    }

    public UnbatchedFlowCombiner(InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(interfaceC0578Hp, "send");
        this.send = interfaceC0578Hp;
        this.initialDispatched = AbstractC1165Zd.b(null, 1, null);
        this.lock = IC.b(false, 1, null);
        InterfaceC1038Xd[] interfaceC1038XdArr = new InterfaceC1038Xd[2];
        for (int i = 0; i < 2; i++) {
            interfaceC1038XdArr[i] = AbstractC1165Zd.b(null, 1, null);
        }
        this.valueReceived = interfaceC1038XdArr;
        Object[] objArr = new Object[2];
        for (int i2 = 0; i2 < 2; i2++) {
            objArr[i2] = FlowExtKt.NULL;
        }
        this.values = objArr;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b2 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc A[Catch: all -> 0x00be, LOOP:0: B:35:0x00b0->B:39:0x00bc, LOOP_END, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ca A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d4 A[Catch: all -> 0x00be, LOOP:1: B:44:0x00c8->B:48:0x00d4, LOOP_END, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d8 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00dd A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e0 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object onNext(int i, Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object obj2;
        UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner;
        Object obj3;
        GC gc;
        int i2;
        UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner2;
        GC gc2;
        Object[] objArr;
        int length;
        int i3;
        boolean z;
        Object[] objArr2;
        int length2;
        int i4;
        CombineSource combineSource;
        InterfaceC0578Hp interfaceC0578Hp;
        Object obj4;
        Object obj5;
        int i5 = i;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i6 = anonymousClass1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i6 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
        }
        Object obj6 = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i7 = anonymousClass1.label;
        if (i7 == 0) {
            LL.b(obj6);
            if (this.valueReceived[i5].z()) {
                InterfaceC1038Xd interfaceC1038Xd = this.initialDispatched;
                anonymousClass1.L$0 = this;
                obj2 = obj;
                anonymousClass1.L$1 = obj2;
                anonymousClass1.I$0 = i5;
                anonymousClass1.label = 1;
                if (interfaceC1038Xd.u(anonymousClass1) == objD) {
                    return objD;
                }
            } else {
                obj2 = obj;
                this.valueReceived[i5].v(FW.a);
            }
            unbatchedFlowCombiner = this;
        } else {
            if (i7 != 1) {
                if (i7 != 2) {
                    if (i7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    gc2 = (GC) anonymousClass1.L$1;
                    unbatchedFlowCombiner2 = (UnbatchedFlowCombiner) anonymousClass1.L$0;
                    try {
                        LL.b(obj6);
                        unbatchedFlowCombiner2.initialDispatched.v(FW.a);
                        FW fw = FW.a;
                        gc2.b(null);
                        return FW.a;
                    } catch (Throwable th) {
                        th = th;
                        gc2.b(null);
                        throw th;
                    }
                }
                i5 = anonymousClass1.I$0;
                gc = (GC) anonymousClass1.L$2;
                obj3 = anonymousClass1.L$1;
                unbatchedFlowCombiner = (UnbatchedFlowCombiner) anonymousClass1.L$0;
                LL.b(obj6);
                i2 = i5;
                unbatchedFlowCombiner2 = unbatchedFlowCombiner;
                try {
                    objArr = unbatchedFlowCombiner2.values;
                    length = objArr.length;
                    i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            z = false;
                            break;
                        }
                        if (objArr[i3] == FlowExtKt.NULL) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    objArr2 = unbatchedFlowCombiner2.values;
                    objArr2[i2] = obj3;
                    length2 = objArr2.length;
                    i4 = 0;
                    while (true) {
                        if (i4 < length2) {
                            if (z) {
                                combineSource = CombineSource.INITIAL;
                            } else if (i2 == 0) {
                                combineSource = CombineSource.RECEIVER;
                            } else {
                                combineSource = CombineSource.OTHER;
                            }
                            interfaceC0578Hp = unbatchedFlowCombiner2.send;
                            Object[] objArr3 = unbatchedFlowCombiner2.values;
                            obj4 = objArr3[0];
                            obj5 = objArr3[1];
                            anonymousClass1.L$0 = unbatchedFlowCombiner2;
                            anonymousClass1.L$1 = gc;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.label = 3;
                            if (interfaceC0578Hp.invoke(obj4, obj5, combineSource, anonymousClass1) == objD) {
                                gc2 = gc;
                                unbatchedFlowCombiner2.initialDispatched.v(FW.a);
                                break;
                            }
                            return objD;
                        }
                        if (objArr2[i4] == FlowExtKt.NULL) {
                            gc2 = gc;
                            break;
                        }
                        i4++;
                    }
                    FW fw2 = FW.a;
                    gc2.b(null);
                    return FW.a;
                } catch (Throwable th2) {
                    th = th2;
                    gc2 = gc;
                    gc2.b(null);
                    throw th;
                }
            }
            i5 = anonymousClass1.I$0;
            obj2 = anonymousClass1.L$1;
            unbatchedFlowCombiner = (UnbatchedFlowCombiner) anonymousClass1.L$0;
            LL.b(obj6);
        }
        GC gc3 = unbatchedFlowCombiner.lock;
        anonymousClass1.L$0 = unbatchedFlowCombiner;
        anonymousClass1.L$1 = obj2;
        anonymousClass1.L$2 = gc3;
        anonymousClass1.I$0 = i5;
        anonymousClass1.label = 2;
        if (gc3.c(null, anonymousClass1) == objD) {
            return objD;
        }
        obj3 = obj2;
        gc = gc3;
        i2 = i5;
        unbatchedFlowCombiner2 = unbatchedFlowCombiner;
        objArr = unbatchedFlowCombiner2.values;
        length = objArr.length;
        i3 = 0;
        while (true) {
            if (i3 < length) {
                z = false;
                break;
            }
            if (objArr[i3] == FlowExtKt.NULL) {
                z = true;
                break;
            }
            i3++;
        }
        objArr2 = unbatchedFlowCombiner2.values;
        objArr2[i2] = obj3;
        length2 = objArr2.length;
        i4 = 0;
        while (true) {
            if (i4 < length2) {
                if (z) {
                    combineSource = CombineSource.INITIAL;
                } else if (i2 == 0) {
                    combineSource = CombineSource.RECEIVER;
                } else {
                    combineSource = CombineSource.OTHER;
                }
                interfaceC0578Hp = unbatchedFlowCombiner2.send;
                Object[] objArr4 = unbatchedFlowCombiner2.values;
                obj4 = objArr4[0];
                obj5 = objArr4[1];
                anonymousClass1.L$0 = unbatchedFlowCombiner2;
                anonymousClass1.L$1 = gc;
                anonymousClass1.L$2 = null;
                anonymousClass1.label = 3;
                if (interfaceC0578Hp.invoke(obj4, obj5, combineSource, anonymousClass1) == objD) {
                    gc2 = gc;
                    unbatchedFlowCombiner2.initialDispatched.v(FW.a);
                    break;
                }
                return objD;
            }
            if (objArr2[i4] == FlowExtKt.NULL) {
                gc2 = gc;
                break;
            }
            i4++;
        }
        FW fw3 = FW.a;
        gc2.b(null);
        return FW.a;
    }
}
