package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: pN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3633pN implements InterfaceC0793Of, InterfaceC2297gg {
    public static final a b = new a(null);
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C3633pN.class, Object.class, "result");
    public final InterfaceC0793Of a;
    private volatile Object result;

    /* JADX INFO: renamed from: pN$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public C3633pN(InterfaceC0793Of interfaceC0793Of, Object obj) {
        AbstractC4492zt.h(interfaceC0793Of, "delegate");
        this.a = interfaceC0793Of;
        this.result = obj;
    }

    public final Object b() throws Throwable {
        Object obj = this.result;
        EnumC2215fg enumC2215fg = EnumC2215fg.UNDECIDED;
        if (obj == enumC2215fg) {
            if (AbstractC2403i0.a(c, this, enumC2215fg, AbstractC0378Bt.d())) {
                return AbstractC0378Bt.d();
            }
            obj = this.result;
        }
        if (obj == EnumC2215fg.RESUMED) {
            return AbstractC0378Bt.d();
        }
        if (obj instanceof KL.b) {
            throw ((KL.b) obj).a;
        }
        return obj;
    }

    @Override // defpackage.InterfaceC2297gg
    public InterfaceC2297gg getCallerFrame() {
        InterfaceC0793Of interfaceC0793Of = this.a;
        if (interfaceC0793Of instanceof InterfaceC2297gg) {
            return (InterfaceC2297gg) interfaceC0793Of;
        }
        return null;
    }

    @Override // defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        return this.a.getContext();
    }

    @Override // defpackage.InterfaceC0793Of
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            EnumC2215fg enumC2215fg = EnumC2215fg.UNDECIDED;
            if (obj2 == enumC2215fg) {
                if (AbstractC2403i0.a(c, this, enumC2215fg, obj)) {
                    return;
                }
            } else {
                if (obj2 != AbstractC0378Bt.d()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (AbstractC2403i0.a(c, this, AbstractC0378Bt.d(), EnumC2215fg.RESUMED)) {
                    this.a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3633pN(InterfaceC0793Of interfaceC0793Of) {
        this(interfaceC0793Of, EnumC2215fg.UNDECIDED);
        AbstractC4492zt.h(interfaceC0793Of, "delegate");
    }
}
