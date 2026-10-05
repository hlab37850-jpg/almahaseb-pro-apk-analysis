package defpackage;

import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzii;
import com.google.android.gms.internal.vision.zziw;
import com.google.android.gms.internal.vision.zzje;
import com.google.android.gms.internal.vision.zzjf;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzkk;
import com.google.android.gms.internal.vision.zzkt;
import com.google.android.gms.internal.vision.zzml;
import com.google.android.gms.internal.vision.zzmo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: bf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1812bf0 {
    public static final C1812bf0 d = new C1812bf0(true);
    public final AbstractC3577og0 a;
    public boolean b;
    public boolean c;

    public C1812bf0() {
        this.a = AbstractC3577og0.d(16);
    }

    public static int a(zzml zzmlVar, int i, Object obj) {
        int iZze = zzii.zze(i);
        if (zzmlVar == zzml.zzj) {
            zzjf.zza((zzkk) obj);
            iZze <<= 1;
        }
        return iZze + b(zzmlVar, obj);
    }

    public static int b(zzml zzmlVar, Object obj) {
        switch (AbstractC1246af0.b[zzmlVar.ordinal()]) {
            case 1:
                return zzii.zzb(((Double) obj).doubleValue());
            case 2:
                return zzii.zzb(((Float) obj).floatValue());
            case 3:
                return zzii.zzd(((Long) obj).longValue());
            case 4:
                return zzii.zze(((Long) obj).longValue());
            case 5:
                return zzii.zzf(((Integer) obj).intValue());
            case 6:
                return zzii.zzg(((Long) obj).longValue());
            case 7:
                return zzii.zzi(((Integer) obj).intValue());
            case 8:
                return zzii.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzii.zzc((zzkk) obj);
            case 10:
                return obj instanceof zzjp ? zzii.zza((zzjp) obj) : zzii.zzb((zzkk) obj);
            case 11:
                return obj instanceof zzht ? zzii.zzb((zzht) obj) : zzii.zzb((String) obj);
            case 12:
                return obj instanceof zzht ? zzii.zzb((zzht) obj) : zzii.zzb((byte[]) obj);
            case 13:
                return zzii.zzg(((Integer) obj).intValue());
            case 14:
                return zzii.zzj(((Integer) obj).intValue());
            case 15:
                return zzii.zzh(((Long) obj).longValue());
            case 16:
                return zzii.zzh(((Integer) obj).intValue());
            case 17:
                return zzii.zzf(((Long) obj).longValue());
            case 18:
                return obj instanceof zzje ? zzii.zzk(((zzje) obj).zza()) : zzii.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static Object d(Object obj) {
        if (obj instanceof zzkt) {
            return ((zzkt) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static C1812bf0 e() {
        return d;
    }

    public static boolean h(Map.Entry entry) {
        zziw zziwVar = (zziw) entry.getKey();
        if (zziwVar.zzc() == zzmo.MESSAGE) {
            if (zziwVar.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzkk) it.next()).zzk()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzkk)) {
                    if (value instanceof zzjp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzkk) value).zzk()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int l(zziw zziwVar, Object obj) {
        zzml zzmlVarZzb = zziwVar.zzb();
        int iZza = zziwVar.zza();
        if (!zziwVar.zzd()) {
            return a(zzmlVarZzb, iZza, obj);
        }
        int iA = 0;
        if (zziwVar.zze()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iA += b(zzmlVarZzb, it.next());
            }
            return zzii.zze(iZza) + iA + zzii.zzl(iA);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iA += a(zzmlVarZzb, iZza, it2.next());
        }
        return iA;
    }

    public static int m(Map.Entry entry) {
        zziw zziwVar = (zziw) entry.getKey();
        Object value = entry.getValue();
        if (zziwVar.zzc() != zzmo.MESSAGE || zziwVar.zzd() || zziwVar.zze()) {
            return l(zziwVar, value);
        }
        return value instanceof zzjp ? zzii.zzb(((zziw) entry.getKey()).zza(), (zzjp) value) : zzii.zzb(((zziw) entry.getKey()).zza(), (zzkk) value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0018  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    public static void p(zziw zziwVar, Object obj) {
        boolean z;
        zzml zzmlVarZzb = zziwVar.zzb();
        zzjf.zza(obj);
        switch (AbstractC1246af0.a[zzmlVarZzb.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzht) || (obj instanceof byte[])) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzje)) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            case 9:
                if ((obj instanceof zzkk) || (obj instanceof zzjp)) {
                    z = true;
                } else {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zziwVar.zza()), zziwVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final Object c(zziw zziwVar) {
        Object obj = this.a.get(zziwVar);
        return obj instanceof zzjp ? zzjp.zza() : obj;
    }

    public final /* synthetic */ Object clone() {
        C1812bf0 c1812bf0 = new C1812bf0();
        for (int i = 0; i < this.a.k(); i++) {
            Map.Entry entryH = this.a.h(i);
            c1812bf0.f((zziw) entryH.getKey(), entryH.getValue());
        }
        for (Map.Entry entry : this.a.n()) {
            c1812bf0.f((zziw) entry.getKey(), entry.getValue());
        }
        c1812bf0.c = this.c;
        return c1812bf0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1812bf0) {
            return this.a.equals(((C1812bf0) obj).a);
        }
        return false;
    }

    public final void f(zziw zziwVar, Object obj) {
        if (!zziwVar.zzd()) {
            p(zziwVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                p(zziwVar, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzjp) {
            this.c = true;
        }
        this.a.put(zziwVar, obj);
    }

    public final void g(C1812bf0 c1812bf0) {
        for (int i = 0; i < c1812bf0.a.k(); i++) {
            k(c1812bf0.a.h(i));
        }
        Iterator it = c1812bf0.a.n().iterator();
        while (it.hasNext()) {
            k((Map.Entry) it.next());
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void i() {
        if (this.b) {
            return;
        }
        this.a.e();
        this.b = true;
    }

    public final void j(zziw zziwVar, Object obj) {
        List arrayList;
        if (!zziwVar.zzd()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        p(zziwVar, obj);
        Object objC = c(zziwVar);
        if (objC == null) {
            arrayList = new ArrayList();
            this.a.put(zziwVar, arrayList);
        } else {
            arrayList = (List) objC;
        }
        arrayList.add(obj);
    }

    public final void k(Map.Entry entry) {
        zziw zziwVar = (zziw) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzjp) {
            value = zzjp.zza();
        }
        if (zziwVar.zzd()) {
            Object objC = c(zziwVar);
            if (objC == null) {
                objC = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objC).add(d(it.next()));
            }
            this.a.put(zziwVar, objC);
            return;
        }
        if (zziwVar.zzc() != zzmo.MESSAGE) {
            this.a.put(zziwVar, d(value));
            return;
        }
        Object objC2 = c(zziwVar);
        if (objC2 == null) {
            this.a.put(zziwVar, d(value));
        } else {
            this.a.put(zziwVar, objC2 instanceof zzkt ? zziwVar.zza((zzkt) objC2, (zzkt) value) : zziwVar.zza(((zzkk) objC2).zzp(), (zzkk) value).zzf());
        }
    }

    public final boolean n() {
        return this.b;
    }

    public final Iterator o() {
        return this.c ? new C4304xf0(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public final Iterator q() {
        return this.c ? new C4304xf0(this.a.p().iterator()) : this.a.p().iterator();
    }

    public final boolean r() {
        for (int i = 0; i < this.a.k(); i++) {
            if (!h(this.a.h(i))) {
                return false;
            }
        }
        Iterator it = this.a.n().iterator();
        while (it.hasNext()) {
            if (!h((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int s() {
        int iM = 0;
        for (int i = 0; i < this.a.k(); i++) {
            iM += m(this.a.h(i));
        }
        Iterator it = this.a.n().iterator();
        while (it.hasNext()) {
            iM += m((Map.Entry) it.next());
        }
        return iM;
    }

    public C1812bf0(boolean z) {
        this(AbstractC3577og0.d(0));
        i();
    }

    public C1812bf0(AbstractC3577og0 abstractC3577og0) {
        this.a = abstractC3577og0;
        i();
    }
}
