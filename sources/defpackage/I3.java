package defpackage;

import android.os.Looper;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class I3 implements InterfaceC3104ix {
    @Override // defpackage.InterfaceC3104ix
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // defpackage.InterfaceC3104ix
    public AbstractC2399hx b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C1984cr(AbstractC2147er.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // defpackage.InterfaceC3104ix
    public int c() {
        return 1073741823;
    }
}
