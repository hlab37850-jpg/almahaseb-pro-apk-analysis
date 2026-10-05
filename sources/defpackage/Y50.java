package defpackage;

import com.google.android.gms.internal.play_billing.zzbv;
import com.google.android.gms.internal.play_billing.zzbw;

/* JADX INFO: loaded from: classes2.dex */
public enum Y50 {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);

    public static final zzbw u;
    public final int a;

    static {
        zzbv zzbvVar = new zzbv();
        for (Y50 y50 : values()) {
            zzbvVar.zza(Integer.valueOf(y50.a), y50);
        }
        u = zzbvVar.zzb();
    }

    Y50(int i) {
        this.a = i;
    }

    public static Y50 a(int i) {
        zzbw zzbwVar = u;
        Integer numValueOf = Integer.valueOf(i);
        return !zzbwVar.containsKey(numValueOf) ? RESPONSE_CODE_UNSPECIFIED : (Y50) zzbwVar.get(numValueOf);
    }
}
