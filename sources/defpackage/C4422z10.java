package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zabf;

/* JADX INFO: renamed from: z10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4422z10 extends P10 {
    public final /* synthetic */ ConnectionResult b;
    public final /* synthetic */ B10 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4422z10(B10 b10, zabf zabfVar, ConnectionResult connectionResult) {
        super(zabfVar);
        this.c = b10;
        this.b = connectionResult;
    }

    @Override // defpackage.P10
    public final void a() {
        this.c.c.zaD(this.b);
    }
}
