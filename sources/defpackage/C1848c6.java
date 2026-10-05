package defpackage;

import android.content.Intent;

/* JADX INFO: renamed from: c6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1848c6 extends C2119eY {
    public Intent b;

    public C1848c6(C3865sD c3865sD) {
        super(c3865sD);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
