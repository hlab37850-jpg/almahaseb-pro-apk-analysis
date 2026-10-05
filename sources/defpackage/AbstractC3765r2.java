package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: r2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3765r2 implements InterfaceC0829Pp, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AbstractC3765r2(int i, Object obj, Class cls, String str, String str2, int i2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i2 & 1) == 1;
        this.arity = i;
        this.flags = i2 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC3765r2)) {
            return false;
        }
        AbstractC3765r2 abstractC3765r2 = (AbstractC3765r2) obj;
        return this.isTopLevel == abstractC3765r2.isTopLevel && this.arity == abstractC3765r2.arity && this.flags == abstractC3765r2.flags && AbstractC4492zt.d(this.receiver, abstractC3765r2.receiver) && AbstractC4492zt.d(this.owner, abstractC3765r2.owner) && this.name.equals(abstractC3765r2.name) && this.signature.equals(abstractC3765r2.signature);
    }

    @Override // defpackage.InterfaceC0829Pp
    public int getArity() {
        return this.arity;
    }

    public InterfaceC0705Ku getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? QJ.c(cls) : QJ.b(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((((((((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return QJ.h(this);
    }
}
