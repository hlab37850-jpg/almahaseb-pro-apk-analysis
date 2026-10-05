package defpackage;

import com.google.android.gms.internal.play_billing.zzfv;
import com.google.android.gms.internal.play_billing.zzgl;
import java.util.Map;

/* JADX INFO: renamed from: tc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3974tc0 implements Map.Entry {
    public final Map.Entry a;

    public final zzfv a() {
        return (zzfv) this.a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzfv) this.a.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzgl) {
            return ((zzfv) this.a.getValue()).zzc((zzgl) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
