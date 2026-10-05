package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfe;
import com.google.android.gms.internal.play_billing.zzfi;
import defpackage.AbstractC3491ne0;
import defpackage.C2208fc0;
import defpackage.C3237ka0;
import defpackage.C3407md0;
import defpackage.C3571od0;
import defpackage.C3653pd0;
import defpackage.InterfaceC3814rd0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfi<MessageType extends zzfi<MessageType, BuilderType>, BuilderType extends zzfe<MessageType, BuilderType>> extends zzds<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzhi zzc = zzhi.zzc();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzA(zzfi zzfiVar, boolean z) {
        byte bByteValue = ((Byte) zzfiVar.zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zA = C3407md0.a().b(zzfiVar.getClass()).a(zzfiVar);
        if (z) {
            zzfiVar.zzb(2, true != zA ? null : zzfiVar, null);
        }
        return zA;
    }

    private final int zzc(InterfaceC3814rd0 interfaceC3814rd0) {
        return C3407md0.a().b(getClass()).zza(this);
    }

    private static zzfi zzd(zzfi zzfiVar, byte[] bArr, int i, int i2, zzeu zzeuVar) throws zzfq {
        if (i2 == 0) {
            return zzfiVar;
        }
        zzfi zzfiVarZzo = zzfiVar.zzo();
        try {
            InterfaceC3814rd0 interfaceC3814rd0B = C3407md0.a().b(zzfiVarZzo.getClass());
            interfaceC3814rd0B.f(zzfiVarZzo, bArr, 0, i2, new C3237ka0(zzeuVar));
            interfaceC3814rd0B.b(zzfiVarZzo);
            return zzfiVarZzo;
        } catch (zzfq e) {
            throw e;
        } catch (zzhg e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzfq) {
                throw ((zzfq) e3.getCause());
            }
            throw new zzfq(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzfq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static zzfi zzn(Class cls) {
        Map map = zzb;
        zzfi zzfiVar = (zzfi) map.get(cls);
        if (zzfiVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfiVar = (zzfi) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfiVar == null) {
            zzfiVar = (zzfi) ((zzfi) AbstractC3491ne0.j(cls)).zzb(6, null, null);
            if (zzfiVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzfiVar);
        }
        return zzfiVar;
    }

    public static zzfi zzp(zzfi zzfiVar, byte[] bArr, zzeu zzeuVar) throws zzfq {
        zzfi zzfiVarZzd = zzd(zzfiVar, bArr, 0, bArr.length, zzeuVar);
        if (zzfiVarZzd == null || zzA(zzfiVarZzd, true)) {
            return zzfiVarZzd;
        }
        throw new zzhg(zzfiVarZzd).zza();
    }

    public static zzfm zzq() {
        return C2208fc0.c();
    }

    public static zzfn zzr() {
        return C3571od0.b();
    }

    public static Object zzs(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzt(zzgl zzglVar, String str, Object[] objArr) {
        return new C3653pd0(zzglVar, str, objArr);
    }

    public static void zzw(Class cls, zzfi zzfiVar) {
        zzfiVar.zzv();
        zzb.put(cls, zzfiVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C3407md0.a().b(getClass()).e(this, (zzfi) obj);
    }

    public final int hashCode() {
        if (zzz()) {
            return zzi();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzi = zzi();
        this.zza = iZzi;
        return iZzi;
    }

    public final String toString() {
        return t.a(this, super.toString());
    }

    @Override // com.google.android.gms.internal.play_billing.zzgl
    public final /* synthetic */ zzgk zzK() {
        return (zzfe) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgl
    public final void zzL(zzep zzepVar) {
        C3407md0.a().b(getClass()).c(this, r.L(zzepVar));
    }

    public abstract Object zzb(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.play_billing.zzds
    public final int zze(InterfaceC3814rd0 interfaceC3814rd0) {
        if (zzz()) {
            int iZza = interfaceC3814rd0.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = interfaceC3814rd0.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final /* synthetic */ zzgl zzh() {
        return (zzfi) zzb(6, null, null);
    }

    public final int zzi() {
        return C3407md0.a().b(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgl
    public final int zzj() {
        int iZzc;
        if (zzz()) {
            iZzc = zzc(null);
            if (iZzc < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
            }
        } else {
            iZzc = this.zzd & Integer.MAX_VALUE;
            if (iZzc == Integer.MAX_VALUE) {
                iZzc = zzc(null);
                if (iZzc < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc;
            }
        }
        return iZzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgm
    public final boolean zzk() {
        return zzA(this, true);
    }

    public final zzfe zzl() {
        return (zzfe) zzb(5, null, null);
    }

    public final zzfe zzm() {
        zzfe zzfeVar = (zzfe) zzb(5, null, null);
        zzfeVar.zzd(this);
        return zzfeVar;
    }

    public final zzfi zzo() {
        return (zzfi) zzb(4, null, null);
    }

    public final void zzu() {
        C3407md0.a().b(getClass()).b(this);
        zzv();
    }

    public final void zzv() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzx(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzz() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
