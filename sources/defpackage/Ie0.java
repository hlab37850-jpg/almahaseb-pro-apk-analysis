package defpackage;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class Ie0 extends Gc0 {
    public final /* synthetic */ Fd0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ie0(Fd0 fd0) {
        super(null);
        this.a = fd0;
    }

    @Override // com.google.android.gms.internal.clearcut.zzl
    public final void zza(Status status) {
        this.a.setResult(status);
    }
}
