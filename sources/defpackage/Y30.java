package defpackage;

import com.google.firebase.iid.InstanceIdResult;

/* JADX INFO: loaded from: classes3.dex */
public final class Y30 implements InstanceIdResult {
    public final String a;
    public final String b;

    public Y30(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getId() {
        return this.a;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getToken() {
        return this.b;
    }
}
