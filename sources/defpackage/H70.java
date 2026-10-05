package defpackage;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzca;
import com.google.android.gms.internal.clearcut.zzci;
import com.google.android.gms.internal.clearcut.zzcj;
import com.google.android.gms.internal.clearcut.zzcr;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzdv;
import com.google.android.gms.internal.clearcut.zzfl;
import com.google.android.gms.internal.clearcut.zzfq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class H70 {
    public static final H70 d = new H70(true);
    public boolean b;
    public boolean c = false;
    public final Za0 a = Za0.f(16);

    public H70() {
    }

    public static int f(zzfl zzflVar, int i, Object obj) {
        int iZzr = zzbn.zzr(i);
        if (zzflVar == zzfl.zzql) {
            zzci.zzf((zzdo) obj);
            iZzr <<= 1;
        }
        return iZzr + o(zzflVar, obj);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    public static void i(zzfl zzflVar, Object obj) {
        zzci.checkNotNull(obj);
        boolean z = true;
        boolean z2 = false;
        switch (J70.a[zzflVar.zzek().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                break;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                break;
            case 7:
                if (!(obj instanceof zzbb) && !(obj instanceof byte[])) {
                    z = false;
                }
                z2 = z;
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzcj)) {
                    z = false;
                }
                z2 = z;
                break;
            case 9:
                if (!(obj instanceof zzdo) && !(obj instanceof zzcr)) {
                    z = false;
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static H70 k() {
        return d;
    }

    public static int n(zzca zzcaVar, Object obj) {
        zzfl zzflVarZzau = zzcaVar.zzau();
        int iZzc = zzcaVar.zzc();
        if (!zzcaVar.zzaw()) {
            return f(zzflVarZzau, iZzc, obj);
        }
        int iF = 0;
        List list = (List) obj;
        if (zzcaVar.zzax()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iF += o(zzflVarZzau, it.next());
            }
            return zzbn.zzr(iZzc) + iF + zzbn.zzz(iF);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iF += f(zzflVarZzau, iZzc, it2.next());
        }
        return iF;
    }

    public static int o(zzfl zzflVar, Object obj) {
        switch (J70.b[zzflVar.ordinal()]) {
            case 1:
                return zzbn.zzb(((Double) obj).doubleValue());
            case 2:
                return zzbn.zzb(((Float) obj).floatValue());
            case 3:
                return zzbn.zze(((Long) obj).longValue());
            case 4:
                return zzbn.zzf(((Long) obj).longValue());
            case 5:
                return zzbn.zzs(((Integer) obj).intValue());
            case 6:
                return zzbn.zzh(((Long) obj).longValue());
            case 7:
                return zzbn.zzv(((Integer) obj).intValue());
            case 8:
                return zzbn.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzbn.zzd((zzdo) obj);
            case 10:
                return obj instanceof zzcr ? zzbn.zza((zzcr) obj) : zzbn.zzc((zzdo) obj);
            case 11:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzh((String) obj);
            case 12:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzd((byte[]) obj);
            case 13:
                return zzbn.zzt(((Integer) obj).intValue());
            case 14:
                return zzbn.zzw(((Integer) obj).intValue());
            case 15:
                return zzbn.zzi(((Long) obj).longValue());
            case 16:
                return zzbn.zzu(((Integer) obj).intValue());
            case 17:
                return zzbn.zzg(((Long) obj).longValue());
            case 18:
                return obj instanceof zzcj ? zzbn.zzx(((zzcj) obj).zzc()) : zzbn.zzx(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static boolean p(Map.Entry entry) {
        zzca zzcaVar = (zzca) entry.getKey();
        if (zzcaVar.zzav() == zzfq.MESSAGE) {
            boolean zZzaw = zzcaVar.zzaw();
            Object value = entry.getValue();
            if (zZzaw) {
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    if (!((zzdo) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                if (!(value instanceof zzdo)) {
                    if (value instanceof zzcr) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzdo) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int r(Map.Entry entry) {
        zzca zzcaVar = (zzca) entry.getKey();
        Object value = entry.getValue();
        if (zzcaVar.zzav() != zzfq.MESSAGE || zzcaVar.zzaw() || zzcaVar.zzax()) {
            return n(zzcaVar, value);
        }
        boolean z = value instanceof zzcr;
        int iZzc = ((zzca) entry.getKey()).zzc();
        return z ? zzbn.zzb(iZzc, (zzcr) value) : zzbn.zzd(iZzc, (zzdo) value);
    }

    public static Object s(Object obj) {
        if (obj instanceof zzdv) {
            return ((zzdv) obj).zzci();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final Iterator a() {
        return this.c ? new K80(this.a.o().iterator()) : this.a.o().iterator();
    }

    public final boolean b() {
        return this.a.isEmpty();
    }

    public final boolean c() {
        return this.b;
    }

    public final /* synthetic */ Object clone() {
        H70 h70 = new H70();
        for (int i = 0; i < this.a.m(); i++) {
            Map.Entry entryG = this.a.g(i);
            h70.h((zzca) entryG.getKey(), entryG.getValue());
        }
        for (Map.Entry entry : this.a.n()) {
            h70.h((zzca) entry.getKey(), entry.getValue());
        }
        h70.c = this.c;
        return h70;
    }

    public final boolean d() {
        for (int i = 0; i < this.a.m(); i++) {
            if (!p(this.a.g(i))) {
                return false;
            }
        }
        Iterator it = this.a.n().iterator();
        while (it.hasNext()) {
            if (!p((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator e() {
        return this.c ? new K80(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof H70) {
            return this.a.equals(((H70) obj).a);
        }
        return false;
    }

    public final Object g(zzca zzcaVar) {
        Object obj = this.a.get(zzcaVar);
        return obj instanceof zzcr ? zzcr.zzbr() : obj;
    }

    public final void h(zzca zzcaVar, Object obj) {
        if (!zzcaVar.zzaw()) {
            i(zzcaVar.zzau(), obj);
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
                i(zzcaVar.zzau(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzcr) {
            this.c = true;
        }
        this.a.put(zzcaVar, obj);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void j(H70 h70) {
        for (int i = 0; i < h70.a.m(); i++) {
            q(h70.a.g(i));
        }
        Iterator it = h70.a.n().iterator();
        while (it.hasNext()) {
            q((Map.Entry) it.next());
        }
    }

    public final int l() {
        int iN = 0;
        for (int i = 0; i < this.a.m(); i++) {
            Map.Entry entryG = this.a.g(i);
            iN += n((zzca) entryG.getKey(), entryG.getValue());
        }
        for (Map.Entry entry : this.a.n()) {
            iN += n((zzca) entry.getKey(), entry.getValue());
        }
        return iN;
    }

    public final int m() {
        int iR = 0;
        for (int i = 0; i < this.a.m(); i++) {
            iR += r(this.a.g(i));
        }
        Iterator it = this.a.n().iterator();
        while (it.hasNext()) {
            iR += r((Map.Entry) it.next());
        }
        return iR;
    }

    public final void q(Map.Entry entry) {
        zzca zzcaVar = (zzca) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzcr) {
            value = zzcr.zzbr();
        }
        if (zzcaVar.zzaw()) {
            Object objG = g(zzcaVar);
            if (objG == null) {
                objG = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objG).add(s(it.next()));
            }
            this.a.put(zzcaVar, objG);
            return;
        }
        if (zzcaVar.zzav() != zzfq.MESSAGE) {
            this.a.put(zzcaVar, s(value));
            return;
        }
        Object objG2 = g(zzcaVar);
        if (objG2 == null) {
            this.a.put(zzcaVar, s(value));
        } else {
            this.a.put(zzcaVar, objG2 instanceof zzdv ? zzcaVar.zza((zzdv) objG2, (zzdv) value) : zzcaVar.zza(((zzdo) objG2).zzbc(), (zzdo) value).zzbj());
        }
    }

    public final void t() {
        if (this.b) {
            return;
        }
        this.a.r();
        this.b = true;
    }

    public H70(boolean z) {
        t();
    }
}
