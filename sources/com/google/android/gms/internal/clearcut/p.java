package com.google.android.gms.internal.clearcut;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements Cloneable {
    public zzfv a;
    public Object b;
    public List c = new ArrayList();

    public final byte[] a() {
        byte[] bArr = new byte[d()];
        b(zzfs.zzg(bArr));
        return bArr;
    }

    public final void b(zzfs zzfsVar) {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        Iterator it = this.c.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
    }

    public final int d() {
        if (this.b != null) {
            throw new NoSuchMethodError();
        }
        Iterator it = this.c.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final p clone() {
        Object objClone;
        p pVar = new p();
        try {
            pVar.a = this.a;
            List list = this.c;
            if (list == null) {
                pVar.c = null;
            } else {
                pVar.c.addAll(list);
            }
            Object obj = this.b;
            if (obj != null) {
                if (obj instanceof zzfz) {
                    objClone = (zzfz) ((zzfz) obj).clone();
                } else if (obj instanceof byte[]) {
                    objClone = ((byte[]) obj).clone();
                } else {
                    int i = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length][];
                        pVar.b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (obj instanceof boolean[]) {
                        objClone = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        objClone = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        objClone = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        objClone = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        objClone = ((double[]) obj).clone();
                    } else if (obj instanceof zzfz[]) {
                        zzfz[] zzfzVarArr = (zzfz[]) obj;
                        zzfz[] zzfzVarArr2 = new zzfz[zzfzVarArr.length];
                        pVar.b = zzfzVarArr2;
                        while (i < zzfzVarArr.length) {
                            zzfzVarArr2[i] = (zzfz) zzfzVarArr[i].clone();
                            i++;
                        }
                    }
                }
                pVar.b = objClone;
            }
            return pVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.b == null || pVar.b == null) {
            List list2 = this.c;
            if (list2 != null && (list = pVar.c) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(a(), pVar.a());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        zzfv zzfvVar = this.a;
        if (zzfvVar != pVar.a) {
            return false;
        }
        if (!zzfvVar.zzrk.isArray()) {
            return this.b.equals(pVar.b);
        }
        Object obj2 = this.b;
        if (obj2 instanceof byte[]) {
            return Arrays.equals((byte[]) obj2, (byte[]) pVar.b);
        }
        if (obj2 instanceof int[]) {
            return Arrays.equals((int[]) obj2, (int[]) pVar.b);
        }
        if (obj2 instanceof long[]) {
            return Arrays.equals((long[]) obj2, (long[]) pVar.b);
        }
        if (obj2 instanceof float[]) {
            return Arrays.equals((float[]) obj2, (float[]) pVar.b);
        }
        if (obj2 instanceof double[]) {
            return Arrays.equals((double[]) obj2, (double[]) pVar.b);
        }
        return obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) pVar.b) : Arrays.deepEquals((Object[]) obj2, (Object[]) pVar.b);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(a()) + MetaDo.META_OFFSETWINDOWORG;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
