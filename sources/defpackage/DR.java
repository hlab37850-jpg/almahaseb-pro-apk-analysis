package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class DR extends AbstractC3272l0 implements DC, InterfaceC0939Tm, InterfaceC1826bq {
    private volatile /* synthetic */ Object _state;
    public int e;

    public static final class a extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int h;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return DR.this.collect(null, this);
        }
    }

    public DR(Object obj) {
        this._state = obj;
    }

    @Override // defpackage.InterfaceC1826bq
    public InterfaceC0939Tm a(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return ER.d(this, interfaceC0988Vf, i, i8);
    }

    @Override // defpackage.DC
    public boolean b(Object obj, Object obj2) {
        if (obj == null) {
            obj = VD.a;
        }
        if (obj2 == null) {
            obj2 = VD.a;
        }
        return p(obj, obj2);
    }

    @Override // defpackage.CC
    public void c() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00af A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00af, B:40:0x00b4, B:50:0x00d5, B:52:0x00db, B:42:0x00ba, B:46:0x00c1, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b4 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00af, B:40:0x00b4, B:50:0x00d5, B:52:0x00db, B:42:0x00ba, B:46:0x00c1, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ba A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00af, B:40:0x00b4, B:50:0x00d5, B:52:0x00db, B:42:0x00ba, B:46:0x00c1, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00be  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00db A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00af, B:40:0x00b4, B:50:0x00d5, B:52:0x00db, B:42:0x00ba, B:46:0x00c1, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [n0] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [FR, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [l0] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6, types: [DR, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00d9 -> B:36:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00eb -> B:36:0x00ab). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x00b4
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // defpackage.YO, defpackage.InterfaceC0939Tm
    public java.lang.Object collect(defpackage.InterfaceC0995Vm r11, defpackage.InterfaceC0793Of r12) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.DR.collect(Vm, Of):java.lang.Object");
    }

    @Override // defpackage.CC, defpackage.InterfaceC0995Vm
    public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
        setValue(obj);
        return FW.a;
    }

    @Override // defpackage.CC
    public boolean f(Object obj) {
        setValue(obj);
        return true;
    }

    @Override // defpackage.DC, defpackage.CR
    public Object getValue() {
        YS ys = VD.a;
        Object obj = this._state;
        if (obj == ys) {
            return null;
        }
        return obj;
    }

    @Override // defpackage.AbstractC3272l0
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public FR h() {
        return new FR();
    }

    @Override // defpackage.AbstractC3272l0
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public FR[] j(int i) {
        return new FR[i];
    }

    public final boolean p(Object obj, Object obj2) {
        int i;
        AbstractC3436n0[] abstractC3436n0ArrM;
        m();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !AbstractC4492zt.d(obj3, obj)) {
                return false;
            }
            if (AbstractC4492zt.d(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i2 = this.e;
            if ((i2 & 1) != 0) {
                this.e = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.e = i3;
            AbstractC3436n0[] abstractC3436n0ArrM2 = m();
            FW fw = FW.a;
            while (true) {
                FR[] frArr = (FR[]) abstractC3436n0ArrM2;
                if (frArr != null) {
                    for (FR fr : frArr) {
                        if (fr != null) {
                            fr.f();
                        }
                    }
                }
                synchronized (this) {
                    i = this.e;
                    if (i == i3) {
                        this.e = i3 + 1;
                        return true;
                    }
                    abstractC3436n0ArrM = m();
                    FW fw2 = FW.a;
                }
                abstractC3436n0ArrM2 = abstractC3436n0ArrM;
                i3 = i;
            }
        }
    }

    @Override // defpackage.DC
    public void setValue(Object obj) {
        if (obj == null) {
            obj = VD.a;
        }
        p(null, obj);
    }
}
