package com.google.android.gms.internal.clearcut;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfw implements Cloneable {
    private static final p zzrl = new p();
    private int mSize;
    private boolean zzrm;
    private int[] zzrn;
    private p[] zzro;

    public zzfw() {
        this(10);
    }

    public final /* synthetic */ Object clone() {
        int i = this.mSize;
        zzfw zzfwVar = new zzfw(i);
        System.arraycopy(this.zzrn, 0, zzfwVar.zzrn, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            p pVar = this.zzro[i2];
            if (pVar != null) {
                zzfwVar.zzro[i2] = (p) pVar.clone();
            }
        }
        zzfwVar.mSize = i;
        return zzfwVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfwVar = (zzfw) obj;
        int i = this.mSize;
        if (i != zzfwVar.mSize) {
            return false;
        }
        int[] iArr = this.zzrn;
        int[] iArr2 = zzfwVar.zzrn;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        p[] pVarArr = this.zzro;
        p[] pVarArr2 = zzfwVar.zzro;
        int i3 = this.mSize;
        for (int i4 = 0; i4 < i3; i4++) {
            if (!pVarArr[i4].equals(pVarArr2[i4])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 17;
        for (int i = 0; i < this.mSize; i++) {
            iHashCode = (((iHashCode * 31) + this.zzrn[i]) * 31) + this.zzro[i].hashCode();
        }
        return iHashCode;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    public final int size() {
        return this.mSize;
    }

    public final p zzaq(int i) {
        return this.zzro[i];
    }

    private zzfw(int i) {
        this.zzrm = false;
        int i2 = i << 2;
        for (int i3 = 4; i3 < 32; i3++) {
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
        }
        int i5 = i2 / 4;
        this.zzrn = new int[i5];
        this.zzro = new p[i5];
        this.mSize = 0;
    }
}
