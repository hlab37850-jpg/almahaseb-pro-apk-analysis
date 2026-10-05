package defpackage;

import com.google.android.gms.internal.auth.zzee;
import com.google.android.gms.internal.auth.zzeo;
import com.google.android.gms.internal.auth.zzew;
import com.google.android.gms.internal.auth.zzez;
import com.google.android.gms.internal.auth.zzfb;
import com.google.android.gms.internal.auth.zzfw;
import com.google.android.gms.internal.auth.zzhn;
import com.google.android.gms.internal.auth.zzho;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: lb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3321lb0 {
    public static final C3321lb0 d = new C3321lb0(true);
    public final AbstractC3734qd0 a = new C2128ed0(16);
    public boolean b;
    public boolean c;

    public C3321lb0() {
    }

    public static C3321lb0 a() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    public static final void d(zzeo zzeoVar, Object obj) {
        boolean z;
        zzeoVar.zzb();
        zzez.zze(obj);
        zzhn zzhnVar = zzhn.zza;
        zzho zzhoVar = zzho.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzee) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzew)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzfw) || (obj instanceof zzfb)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeoVar.zza()), zzeoVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.a.a();
        this.b = true;
    }

    public final void c(zzeo zzeoVar, Object obj) {
        if (!zzeoVar.zzc()) {
            d(zzeoVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d(zzeoVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzfb) {
            this.c = true;
        }
        this.a.put(zzeoVar, obj);
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        C3321lb0 c3321lb0 = new C3321lb0();
        for (int i = 0; i < this.a.b(); i++) {
            Map.Entry entryG = this.a.g(i);
            c3321lb0.c((zzeo) entryG.getKey(), entryG.getValue());
        }
        for (Map.Entry entry : this.a.c()) {
            c3321lb0.c((zzeo) entry.getKey(), entry.getValue());
        }
        c3321lb0.c = this.c;
        return c3321lb0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3321lb0) {
            return this.a.equals(((C3321lb0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public C3321lb0(boolean z) {
        b();
        b();
    }
}
