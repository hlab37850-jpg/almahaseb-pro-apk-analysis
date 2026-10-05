package defpackage;

/* JADX INFO: renamed from: Rp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0890Rp extends AbstractC2285ga implements InterfaceC0829Pp, InterfaceC0730Lu {
    private final int arity;
    private final int flags;

    public AbstractC0890Rp(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0609Iu computeReflected() {
        return QJ.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0890Rp) {
            AbstractC0890Rp abstractC0890Rp = (AbstractC0890Rp) obj;
            return getName().equals(abstractC0890Rp.getName()) && getSignature().equals(abstractC0890Rp.getSignature()) && this.flags == abstractC0890Rp.flags && this.arity == abstractC0890Rp.arity && AbstractC4492zt.d(getBoundReceiver(), abstractC0890Rp.getBoundReceiver()) && AbstractC4492zt.d(getOwner(), abstractC0890Rp.getOwner());
        }
        if (obj instanceof InterfaceC0730Lu) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // defpackage.InterfaceC0829Pp
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // defpackage.InterfaceC0730Lu
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // defpackage.InterfaceC0730Lu
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // defpackage.InterfaceC0730Lu
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // defpackage.InterfaceC0730Lu
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // defpackage.AbstractC2285ga, defpackage.InterfaceC0609Iu
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        InterfaceC0609Iu interfaceC0609IuCompute = compute();
        if (interfaceC0609IuCompute != this) {
            return interfaceC0609IuCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0730Lu getReflected() {
        return (InterfaceC0730Lu) super.getReflected();
    }
}
