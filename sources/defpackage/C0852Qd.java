package defpackage;

import com.google.common.collect.ObjectArrays;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: Qd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0852Qd extends C0765Nd {
    public transient int[] f;
    public transient int[] g;
    public transient int h;
    public transient int i;

    public C0852Qd(int i) {
        super(i);
    }

    public static C0852Qd E(int i) {
        return new C0852Qd(i);
    }

    public final int F(int i) {
        return G()[i] - 1;
    }

    public final int[] G() {
        int[] iArr = this.f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final int[] H() {
        int[] iArr = this.g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final void I(int i, int i2) {
        G()[i] = i2 + 1;
    }

    public final void J(int i, int i2) {
        if (i == -2) {
            this.h = i2;
        } else {
            K(i, i2);
        }
        if (i2 == -2) {
            this.i = i;
        } else {
            I(i2, i);
        }
    }

    public final void K(int i, int i2) {
        H()[i] = i2 + 1;
    }

    @Override // defpackage.C0765Nd
    public int c(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // defpackage.C0765Nd, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (u()) {
            return;
        }
        this.h = -2;
        this.i = -2;
        int[] iArr = this.f;
        if (iArr != null && this.g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.g, 0, size(), 0);
        }
        super.clear();
    }

    @Override // defpackage.C0765Nd
    public int e() {
        int iE = super.e();
        this.f = new int[iE];
        this.g = new int[iE];
        return iE;
    }

    @Override // defpackage.C0765Nd
    public Set f() {
        Set setF = super.f();
        this.f = null;
        this.g = null;
        return setF;
    }

    @Override // defpackage.C0765Nd
    public int n() {
        return this.h;
    }

    @Override // defpackage.C0765Nd
    public int o(int i) {
        return H()[i] - 1;
    }

    @Override // defpackage.C0765Nd
    public void r(int i) {
        super.r(i);
        this.h = -2;
        this.i = -2;
    }

    @Override // defpackage.C0765Nd
    public void s(int i, Object obj, int i2, int i3) {
        super.s(i, obj, i2, i3);
        J(this.i, i);
        J(i, -2);
    }

    @Override // defpackage.C0765Nd
    public void t(int i, int i2) {
        int size = size() - 1;
        super.t(i, i2);
        J(F(i), o(i));
        if (i < size) {
            J(F(size), i);
            J(i, o(size));
        }
        G()[size] = 0;
        H()[size] = 0;
    }

    @Override // defpackage.C0765Nd, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    @Override // defpackage.C0765Nd
    public void y(int i) {
        super.y(i);
        this.f = Arrays.copyOf(G(), i);
        this.g = Arrays.copyOf(H(), i);
    }

    @Override // defpackage.C0765Nd, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        return ObjectArrays.toArrayImpl(this, objArr);
    }
}
