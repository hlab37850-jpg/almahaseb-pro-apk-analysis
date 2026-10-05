package androidx.compose.runtime;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class OpaqueKey {
    private final String key;

    public OpaqueKey(String str) {
        AbstractC4492zt.h(str, "key");
        this.key = str;
    }

    public static /* synthetic */ OpaqueKey copy$default(OpaqueKey opaqueKey, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = opaqueKey.key;
        }
        return opaqueKey.copy(str);
    }

    public final String component1() {
        return this.key;
    }

    public final OpaqueKey copy(String str) {
        AbstractC4492zt.h(str, "key");
        return new OpaqueKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpaqueKey) && AbstractC4492zt.d(this.key, ((OpaqueKey) obj).key);
    }

    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "OpaqueKey(key=" + this.key + ')';
    }
}
