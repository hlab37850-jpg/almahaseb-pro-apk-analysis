package defpackage;

import com.google.android.gms.common.zzu;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class pi0 extends xi0 {
    public final Callable f;

    public /* synthetic */ pi0(Callable callable, zzu zzuVar) {
        super();
        this.f = callable;
    }

    @Override // defpackage.xi0
    public final String a() {
        try {
            return (String) this.f.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
