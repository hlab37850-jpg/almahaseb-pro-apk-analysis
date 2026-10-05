package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class BR implements InterfaceC2110eP {
    public final long b;
    public final long c;

    public static final class a extends XS implements InterfaceC0552Gp {
        public int a;
        public /* synthetic */ Object b;
        public /* synthetic */ int c;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return l((InterfaceC0995Vm) obj, ((Number) obj2).intValue(), (InterfaceC0793Of) obj3);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x007c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x008d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x009b A[RETURN] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC0995Vm interfaceC0995Vm;
            EnumC1871cP enumC1871cP;
            long j;
            EnumC1871cP enumC1871cP2;
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        interfaceC0995Vm = (InterfaceC0995Vm) this.b;
                        LL.b(obj);
                        if (BR.this.c > 0) {
                            enumC1871cP = EnumC1871cP.STOP;
                            this.b = interfaceC0995Vm;
                            this.a = 3;
                            if (interfaceC0995Vm.emit(enumC1871cP, this) == objD) {
                                return objD;
                            }
                            j = BR.this.c;
                            this.b = interfaceC0995Vm;
                            this.a = 4;
                            if (AbstractC1043Xi.a(j, this) == objD) {
                                return objD;
                            }
                        }
                    } else if (i == 3) {
                        interfaceC0995Vm = (InterfaceC0995Vm) this.b;
                        LL.b(obj);
                        j = BR.this.c;
                        this.b = interfaceC0995Vm;
                        this.a = 4;
                        if (AbstractC1043Xi.a(j, this) == objD) {
                            return objD;
                        }
                    } else if (i == 4) {
                        interfaceC0995Vm = (InterfaceC0995Vm) this.b;
                        LL.b(obj);
                    } else if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    enumC1871cP2 = EnumC1871cP.STOP_AND_RESET_REPLAY_CACHE;
                    this.b = null;
                    this.a = 5;
                    if (interfaceC0995Vm.emit(enumC1871cP2, this) == objD) {
                        return objD;
                    }
                }
                LL.b(obj);
            } else {
                LL.b(obj);
                interfaceC0995Vm = (InterfaceC0995Vm) this.b;
                if (this.c > 0) {
                    EnumC1871cP enumC1871cP3 = EnumC1871cP.START;
                    this.a = 1;
                    if (interfaceC0995Vm.emit(enumC1871cP3, this) == objD) {
                        return objD;
                    }
                } else {
                    long j2 = BR.this.b;
                    this.b = interfaceC0995Vm;
                    this.a = 2;
                    if (AbstractC1043Xi.a(j2, this) == objD) {
                        return objD;
                    }
                    if (BR.this.c > 0) {
                        enumC1871cP = EnumC1871cP.STOP;
                        this.b = interfaceC0995Vm;
                        this.a = 3;
                        if (interfaceC0995Vm.emit(enumC1871cP, this) == objD) {
                            return objD;
                        }
                        j = BR.this.c;
                        this.b = interfaceC0995Vm;
                        this.a = 4;
                        if (AbstractC1043Xi.a(j, this) == objD) {
                            return objD;
                        }
                    }
                    enumC1871cP2 = EnumC1871cP.STOP_AND_RESET_REPLAY_CACHE;
                    this.b = null;
                    this.a = 5;
                    if (interfaceC0995Vm.emit(enumC1871cP2, this) == objD) {
                        return objD;
                    }
                }
            }
            return FW.a;
        }

        public final Object l(InterfaceC0995Vm interfaceC0995Vm, int i, InterfaceC0793Of interfaceC0793Of) {
            a aVar = BR.this.new a(interfaceC0793Of);
            aVar.b = interfaceC0995Vm;
            aVar.c = i;
            return aVar.invokeSuspend(FW.a);
        }
    }

    public static final class b extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;

        public b(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            b bVar = new b(interfaceC0793Of);
            bVar.b = obj;
            return bVar;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return E8.a(((EnumC1871cP) this.b) != EnumC1871cP.START);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(EnumC1871cP enumC1871cP, InterfaceC0793Of interfaceC0793Of) {
            return ((b) create(enumC1871cP, interfaceC0793Of)).invokeSuspend(FW.a);
        }
    }

    public BR(long j, long j2) {
        this.b = j;
        this.c = j2;
        if (j < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
        }
        if (j2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
    }

    @Override // defpackage.InterfaceC2110eP
    public InterfaceC0939Tm a(CR cr) {
        return AbstractC1047Xm.j(AbstractC1047Xm.l(AbstractC1047Xm.H(cr, new a(null)), new b(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof BR) {
            BR br = (BR) obj;
            if (this.b == br.b && this.c == br.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (AbstractC0723Lm.a(this.b) * 31) + AbstractC0723Lm.a(this.c);
    }

    public String toString() {
        List listD = AbstractC1805bc.d(2);
        if (this.b > 0) {
            listD.add("stopTimeout=" + this.b + "ms");
        }
        if (this.c < LocationRequestCompat.PASSIVE_INTERVAL) {
            listD.add("replayExpiration=" + this.c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + AbstractC3240kc.j0(AbstractC1805bc.a(listD), null, null, null, 0, null, null, 63, null) + ')';
    }
}
