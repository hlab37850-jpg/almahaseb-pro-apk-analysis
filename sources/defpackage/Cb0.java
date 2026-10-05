package defpackage;

import com.google.android.gms.internal.play_billing.zzei;
import com.google.android.gms.internal.play_billing.zzep;
import com.google.android.gms.internal.play_billing.zzey;
import com.google.android.gms.internal.play_billing.zzfi;
import com.google.android.gms.internal.play_billing.zzfk;
import com.google.android.gms.internal.play_billing.zzfo;
import com.google.android.gms.internal.play_billing.zzfv;
import com.google.android.gms.internal.play_billing.zzgl;
import com.google.android.gms.internal.play_billing.zzgm;
import com.google.android.gms.internal.play_billing.zzhs;
import com.google.android.gms.internal.play_billing.zzht;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Cb0 {
    public static final Cb0 d = new Cb0(true);
    public final Sd0 a = new C4057ud0();
    public boolean b;
    public boolean c;

    public Cb0() {
    }

    public static int a(zzhs zzhsVar, int i, Object obj) {
        int iZzC = zzep.zzC(i << 3);
        if (zzhsVar == zzhs.zzj) {
            zzfo.zzd((zzgl) obj);
            iZzC += iZzC;
        }
        return iZzC + b(zzhsVar, obj);
    }

    public static int b(zzhs zzhsVar, Object obj) {
        int iZzd;
        int iZzC;
        zzhs zzhsVar2 = zzhs.zza;
        zzht zzhtVar = zzht.INT;
        switch (zzhsVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzep.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzep.zzb;
                return 4;
            case 2:
                return zzep.zzD(((Long) obj).longValue());
            case 3:
                return zzep.zzD(((Long) obj).longValue());
            case 4:
                return zzep.zzD(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzep.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzep.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzep.zzb;
                return 1;
            case 8:
                if (!(obj instanceof zzei)) {
                    return zzep.zzB((String) obj);
                }
                int i6 = zzep.zzb;
                iZzd = ((zzei) obj).zzd();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case 9:
                return ((zzgl) obj).zzj();
            case 10:
                if (!(obj instanceof zzfv)) {
                    return zzep.zzz((zzgl) obj);
                }
                int i7 = zzep.zzb;
                iZzd = ((zzfv) obj).zza();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case 11:
                if (!(obj instanceof zzei)) {
                    int i8 = zzep.zzb;
                    iZzd = ((byte[]) obj).length;
                    iZzC = zzep.zzC(iZzd);
                } else {
                    int i9 = zzep.zzb;
                    iZzd = ((zzei) obj).zzd();
                    iZzC = zzep.zzC(iZzd);
                }
                break;
            case 12:
                return zzep.zzC(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzfk ? zzep.zzD(((zzfk) obj).zza()) : zzep.zzD(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzep.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzep.zzb;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzep.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzep.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzC + iZzd;
    }

    public static int c(zzey zzeyVar, Object obj) {
        zzhs zzhsVarZzb = zzeyVar.zzb();
        int iZza = zzeyVar.zza();
        if (!zzeyVar.zze()) {
            return a(zzhsVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzeyVar.zzd()) {
            int iA = 0;
            while (i < size) {
                iA += a(zzhsVarZzb, iZza, list.get(i));
                i++;
            }
            return iA;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iB = 0;
        while (i < size) {
            iB += b(zzhsVarZzb, list.get(i));
            i++;
        }
        return zzep.zzC(iZza << 3) + iB + zzep.zzC(iB);
    }

    public static Cb0 e() {
        return d;
    }

    public static boolean j(Map.Entry entry) {
        zzey zzeyVar = (zzey) entry.getKey();
        if (zzeyVar.zzc() != zzht.MESSAGE) {
            return true;
        }
        if (!zzeyVar.zze()) {
            return k(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!k(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Object obj) {
        if (obj instanceof zzgm) {
            return ((zzgm) obj).zzk();
        }
        if (obj instanceof zzfv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public static final int l(Map.Entry entry) {
        int i;
        int iZzC;
        int iZzC2;
        zzey zzeyVar = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (zzeyVar.zzc() != zzht.MESSAGE || zzeyVar.zze() || zzeyVar.zzd()) {
            return c(zzeyVar, value);
        }
        if (value instanceof zzfv) {
            int iZza = ((zzey) entry.getKey()).zza();
            int iZzC3 = zzep.zzC(8);
            i = iZzC3 + iZzC3;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza);
            int iZzC4 = zzep.zzC(24);
            int iZza2 = ((zzfv) value).zza();
            iZzC2 = iZzC4 + zzep.zzC(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzey) entry.getKey()).zza();
            int iZzC5 = zzep.zzC(8);
            i = iZzC5 + iZzC5;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza3);
            iZzC2 = zzep.zzC(24) + zzep.zzz((zzgl) value);
        }
        return i + iZzC + iZzC2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    public static final void m(zzey zzeyVar, Object obj) {
        boolean z;
        zzeyVar.zzb();
        byte[] bArr = zzfo.zzb;
        obj.getClass();
        zzhs zzhsVar = zzhs.zza;
        zzht zzhtVar = zzht.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzei) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzfk)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzgl) || (obj instanceof zzfv)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        Cb0 cb0 = new Cb0();
        Sd0 sd0 = this.a;
        int iC = sd0.c();
        for (int i = 0; i < iC; i++) {
            Map.Entry entryG = sd0.g(i);
            cb0.h((zzey) ((C4300xd0) entryG).a(), entryG.getValue());
        }
        for (Map.Entry entry : sd0.d()) {
            cb0.h((zzey) entry.getKey(), entry.getValue());
        }
        cb0.c = this.c;
        return cb0;
    }

    public final int d() {
        Sd0 sd0 = this.a;
        int iC = sd0.c();
        int iL = 0;
        for (int i = 0; i < iC; i++) {
            iL += l(sd0.g(i));
        }
        Iterator it = sd0.d().iterator();
        while (it.hasNext()) {
            iL += l((Map.Entry) it.next());
        }
        return iL;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cb0) {
            return this.a.equals(((Cb0) obj).a);
        }
        return false;
    }

    public final Iterator f() {
        Sd0 sd0 = this.a;
        if (sd0.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.c ? new C4136vc0(sd0.entrySet().iterator()) : sd0.entrySet().iterator();
    }

    public final void g() {
        if (this.b) {
            return;
        }
        Sd0 sd0 = this.a;
        int iC = sd0.c();
        for (int i = 0; i < iC; i++) {
            Object value = sd0.g(i).getValue();
            if (value instanceof zzfi) {
                ((zzfi) value).zzu();
            }
        }
        Iterator it = sd0.d().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzfi) {
                ((zzfi) value2).zzu();
            }
        }
        sd0.a();
        this.b = true;
    }

    public final void h(zzey zzeyVar, Object obj) {
        if (!zzeyVar.zze()) {
            m(zzeyVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                m(zzeyVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfv) {
            this.c = true;
        }
        this.a.put(zzeyVar, obj);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean i() {
        Sd0 sd0 = this.a;
        int iC = sd0.c();
        for (int i = 0; i < iC; i++) {
            if (!j(sd0.g(i))) {
                return false;
            }
        }
        Iterator it = sd0.d().iterator();
        while (it.hasNext()) {
            if (!j((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Cb0(boolean z) {
        g();
        g();
    }
}
