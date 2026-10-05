package defpackage;

/* JADX INFO: renamed from: Zm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC1174Zm {

    /* JADX INFO: renamed from: Zm$a */
    public static final class a extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public boolean c;
        public /* synthetic */ Object d;
        public int e;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return AbstractC1174Zm.d(null, null, false, this);
        }
    }

    public static final InterfaceC0939Tm b(IJ ij) {
        return new C1035Xa(ij, true, null, 0, null, 28, null);
    }

    public static final Object c(InterfaceC0995Vm interfaceC0995Vm, IJ ij, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objD = d(interfaceC0995Vm, ij, true, interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0075 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #1 {all -> 0x0039, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:20:0x004d), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x007d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0084 A[Catch: all -> 0x0039, TRY_ENTER, TryCatch #1 {all -> 0x0039, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:20:0x004d), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0085 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #1 {all -> 0x0039, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:20:0x004d), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0097 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v0, types: [Vm] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v3, types: [Vm, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0095 -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(defpackage.InterfaceC0995Vm r6, defpackage.IJ r7, boolean r8, defpackage.InterfaceC0793Of r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof defpackage.AbstractC1174Zm.a
            if (r0 == 0) goto L13
            r0 = r9
            Zm$a r0 = (defpackage.AbstractC1174Zm.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            Zm$a r0 = new Zm$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L57
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            boolean r6 = r0.c
            java.lang.Object r7 = r0.b
            IJ r7 = (defpackage.IJ) r7
            java.lang.Object r8 = r0.a
            Vm r8 = (defpackage.InterfaceC0995Vm) r8
            defpackage.LL.b(r9)     // Catch: java.lang.Throwable -> L39
        L35:
            r5 = r8
            r8 = r6
            r6 = r5
            goto L5d
        L39:
            r8 = move-exception
            goto L9c
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            boolean r6 = r0.c
            java.lang.Object r7 = r0.b
            IJ r7 = (defpackage.IJ) r7
            java.lang.Object r8 = r0.a
            Vm r8 = (defpackage.InterfaceC0995Vm) r8
            defpackage.LL.b(r9)     // Catch: java.lang.Throwable -> L39
            ib r9 = (defpackage.C2451ib) r9     // Catch: java.lang.Throwable -> L39
            java.lang.Object r9 = r9.l()     // Catch: java.lang.Throwable -> L39
            goto L6f
        L57:
            defpackage.LL.b(r9)
            defpackage.AbstractC1047Xm.o(r6)
        L5d:
            r0.a = r6     // Catch: java.lang.Throwable -> L98
            r0.b = r7     // Catch: java.lang.Throwable -> L98
            r0.c = r8     // Catch: java.lang.Throwable -> L98
            r0.e = r4     // Catch: java.lang.Throwable -> L98
            java.lang.Object r9 = r7.b(r0)     // Catch: java.lang.Throwable -> L98
            if (r9 != r1) goto L6c
            return r1
        L6c:
            r5 = r8
            r8 = r6
            r6 = r5
        L6f:
            boolean r2 = defpackage.C2451ib.i(r9)     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L85
            java.lang.Throwable r8 = defpackage.C2451ib.e(r9)     // Catch: java.lang.Throwable -> L39
            if (r8 != 0) goto L84
            if (r6 == 0) goto L81
            r6 = 0
            defpackage.AbstractC3156jb.a(r7, r6)
        L81:
            FW r6 = defpackage.FW.a
            return r6
        L84:
            throw r8     // Catch: java.lang.Throwable -> L39
        L85:
            java.lang.Object r9 = defpackage.C2451ib.g(r9)     // Catch: java.lang.Throwable -> L39
            r0.a = r8     // Catch: java.lang.Throwable -> L39
            r0.b = r7     // Catch: java.lang.Throwable -> L39
            r0.c = r6     // Catch: java.lang.Throwable -> L39
            r0.e = r3     // Catch: java.lang.Throwable -> L39
            java.lang.Object r9 = r8.emit(r9, r0)     // Catch: java.lang.Throwable -> L39
            if (r9 != r1) goto L35
            return r1
        L98:
            r6 = move-exception
            r5 = r8
            r8 = r6
            r6 = r5
        L9c:
            throw r8     // Catch: java.lang.Throwable -> L9d
        L9d:
            r9 = move-exception
            if (r6 == 0) goto La3
            defpackage.AbstractC3156jb.a(r7, r8)
        La3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC1174Zm.d(Vm, IJ, boolean, Of):java.lang.Object");
    }
}
