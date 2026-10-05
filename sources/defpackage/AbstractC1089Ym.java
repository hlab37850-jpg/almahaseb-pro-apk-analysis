package defpackage;

/* JADX INFO: renamed from: Ym, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC1089Ym {

    /* JADX INFO: renamed from: Ym$a */
    public static final class a implements InterfaceC0939Tm {
        public final /* synthetic */ Object[] a;

        /* JADX INFO: renamed from: Ym$a$a, reason: collision with other inner class name */
        public static final class C0027a extends AbstractC0819Pf {
            public /* synthetic */ Object a;
            public int b;
            public Object d;
            public Object e;
            public int f;
            public int g;

            public C0027a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return a.this.collect(null, this);
            }
        }

        public a(Object[] objArr) {
            this.a = objArr;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x004b  */
        /* JADX WARN: Code duplicated, block: B:18:0x005f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005d -> B:19:0x0060). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.InterfaceC0939Tm
        public java.lang.Object collect(defpackage.InterfaceC0995Vm r8, defpackage.InterfaceC0793Of r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof defpackage.AbstractC1089Ym.a.C0027a
                if (r0 == 0) goto L13
                r0 = r9
                Ym$a$a r0 = (defpackage.AbstractC1089Ym.a.C0027a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                Ym$a$a r0 = new Ym$a$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.a
                java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L3e
                if (r2 != r3) goto L36
                int r8 = r0.g
                int r2 = r0.f
                java.lang.Object r4 = r0.e
                Vm r4 = (defpackage.InterfaceC0995Vm) r4
                java.lang.Object r5 = r0.d
                Ym$a r5 = (defpackage.AbstractC1089Ym.a) r5
                defpackage.LL.b(r9)
                r9 = r4
                goto L60
            L36:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3e:
                defpackage.LL.b(r9)
                java.lang.Object[] r9 = r7.a
                int r9 = r9.length
                r2 = 0
                r5 = r7
                r6 = r9
                r9 = r8
                r8 = r6
            L49:
                if (r2 >= r8) goto L62
                java.lang.Object[] r4 = r5.a
                r4 = r4[r2]
                r0.d = r5
                r0.e = r9
                r0.f = r2
                r0.g = r8
                r0.b = r3
                java.lang.Object r4 = r9.emit(r4, r0)
                if (r4 != r1) goto L60
                return r1
            L60:
                int r2 = r2 + r3
                goto L49
            L62:
                FW r8 = defpackage.FW.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC1089Ym.a.collect(Vm, Of):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: Ym$b */
    public static final class b implements InterfaceC0939Tm {
        public final /* synthetic */ Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            Object objEmit = interfaceC0995Vm.emit(this.a, interfaceC0793Of);
            return objEmit == AbstractC0378Bt.d() ? objEmit : FW.a;
        }
    }

    public static final InterfaceC0939Tm a(InterfaceC0526Fp interfaceC0526Fp) {
        return new C3482na(interfaceC0526Fp, null, 0, null, 14, null);
    }

    public static final InterfaceC0939Tm b(InterfaceC0526Fp interfaceC0526Fp) {
        return new C3714qN(interfaceC0526Fp);
    }

    public static final InterfaceC0939Tm c(Object obj) {
        return new b(obj);
    }

    public static final InterfaceC0939Tm d(Object... objArr) {
        return new a(objArr);
    }
}
