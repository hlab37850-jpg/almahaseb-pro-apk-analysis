package defpackage;

import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;

/* JADX INFO: loaded from: classes2.dex */
public final class Eb0 extends AbstractBinderC2459if0 {
    public final /* synthetic */ Mc0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Eb0(Mc0 mc0, AbstractC2298gg0 abstractC2298gg0) {
        super(abstractC2298gg0);
        this.b = mc0;
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zzc(DeviceMetaData deviceMetaData) {
        this.b.a.setResult(deviceMetaData);
    }
}
