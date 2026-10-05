package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class O8 {
    public static final InterfaceC0857Qi a(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, EnumC2379hg enumC2379hg, InterfaceC0526Fp interfaceC0526Fp) {
        InterfaceC0988Vf interfaceC0988VfE = AbstractC1014Wf.e(interfaceC2052dg, interfaceC0988Vf);
        C0883Ri c3512nv = enumC2379hg.c() ? new C3512nv(interfaceC0988VfE, interfaceC0526Fp) : new C0883Ri(interfaceC0988VfE, true);
        c3512nv.G0(enumC2379hg, c3512nv, interfaceC0526Fp);
        return c3512nv;
    }

    public static /* synthetic */ InterfaceC0857Qi b(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, EnumC2379hg enumC2379hg, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        if ((i & 2) != 0) {
            enumC2379hg = EnumC2379hg.DEFAULT;
        }
        return M8.a(interfaceC2052dg, interfaceC0988Vf, enumC2379hg, interfaceC0526Fp);
    }

    public static final InterfaceC1830bu c(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, EnumC2379hg enumC2379hg, InterfaceC0526Fp interfaceC0526Fp) {
        InterfaceC0988Vf interfaceC0988VfE = AbstractC1014Wf.e(interfaceC2052dg, interfaceC0988Vf);
        C4122vR c4241wv = enumC2379hg.c() ? new C4241wv(interfaceC0988VfE, interfaceC0526Fp) : new C4122vR(interfaceC0988VfE, true);
        c4241wv.G0(enumC2379hg, c4241wv, interfaceC0526Fp);
        return c4241wv;
    }

    public static /* synthetic */ InterfaceC1830bu d(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, EnumC2379hg enumC2379hg, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        if ((i & 2) != 0) {
            enumC2379hg = EnumC2379hg.DEFAULT;
        }
        return M8.c(interfaceC2052dg, interfaceC0988Vf, enumC2379hg, interfaceC0526Fp);
    }

    public static final Object e(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objI0;
        InterfaceC0988Vf context = interfaceC0793Of.getContext();
        InterfaceC0988Vf interfaceC0988VfD = AbstractC1014Wf.d(context, interfaceC0988Vf);
        AbstractC3347lu.j(interfaceC0988VfD);
        if (interfaceC0988VfD == context) {
            ON on = new ON(interfaceC0988VfD, interfaceC0793Of);
            objI0 = AbstractC4461zW.b(on, on, interfaceC0526Fp);
        } else {
            InterfaceC0854Qf.b bVar = InterfaceC0854Qf.o;
            if (AbstractC4492zt.d(interfaceC0988VfD.get(bVar), context.get(bVar))) {
                C4370yW c4370yW = new C4370yW(interfaceC0988VfD, interfaceC0793Of);
                Object objC = AbstractC4368yU.c(interfaceC0988VfD, null);
                try {
                    Object objB = AbstractC4461zW.b(c4370yW, c4370yW, interfaceC0526Fp);
                    AbstractC4368yU.a(interfaceC0988VfD, objC);
                    objI0 = objB;
                } catch (Throwable th) {
                    AbstractC4368yU.a(interfaceC0988VfD, objC);
                    throw th;
                }
            } else {
                C4148vj c4148vj = new C4148vj(interfaceC0988VfD, interfaceC0793Of);
                AbstractC0385Ca.e(interfaceC0526Fp, c4148vj, c4148vj, null, 4, null);
                objI0 = c4148vj.I0();
            }
        }
        if (objI0 == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objI0;
    }
}
