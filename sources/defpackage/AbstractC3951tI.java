package defpackage;

/* JADX INFO: renamed from: tI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3951tI extends AbstractC2285ga implements InterfaceC0977Uu {
    private final boolean syntheticJavaProperty;

    public AbstractC3951tI(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = (i & 2) == 2;
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0609Iu compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3951tI) {
            AbstractC3951tI abstractC3951tI = (AbstractC3951tI) obj;
            return getOwner().equals(abstractC3951tI.getOwner()) && getName().equals(abstractC3951tI.getName()) && getSignature().equals(abstractC3951tI.getSignature()) && AbstractC4492zt.d(getBoundReceiver(), abstractC3951tI.getBoundReceiver());
        }
        if (obj instanceof InterfaceC0977Uu) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // defpackage.InterfaceC0977Uu
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // defpackage.InterfaceC0977Uu
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        InterfaceC0609Iu interfaceC0609IuCompute = compute();
        if (interfaceC0609IuCompute != this) {
            return interfaceC0609IuCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // defpackage.AbstractC2285ga
    public InterfaceC0977Uu getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (InterfaceC0977Uu) super.getReflected();
    }
}
