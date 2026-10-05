package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import defpackage.AbstractC2287gb;
import defpackage.I8;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC4038uO;
import defpackage.O8;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
final class OnBackInstance {
    private final InterfaceC1009Wa channel = AbstractC2287gb.b(-2, I8.SUSPEND, null, 4, null);
    private boolean isPredictiveBack;
    private final InterfaceC1830bu job;

    public OnBackInstance(InterfaceC2052dg interfaceC2052dg, boolean z, InterfaceC0526Fp interfaceC0526Fp, OnBackPressedCallback onBackPressedCallback) {
        this.isPredictiveBack = z;
        this.job = O8.d(interfaceC2052dg, null, null, new OnBackInstance$job$1(onBackPressedCallback, interfaceC0526Fp, this, null), 3, null);
    }

    public final void cancel() {
        this.channel.cancel(new CancellationException("onBack cancelled"));
        InterfaceC1830bu.a.a(this.job, null, 1, null);
    }

    public final boolean close() {
        return InterfaceC4038uO.a.a(this.channel, null, 1, null);
    }

    public final InterfaceC1009Wa getChannel() {
        return this.channel;
    }

    public final InterfaceC1830bu getJob() {
        return this.job;
    }

    public final boolean isPredictiveBack() {
        return this.isPredictiveBack;
    }

    /* JADX INFO: renamed from: send-JP2dKIU, reason: not valid java name */
    public final Object m9sendJP2dKIU(BackEventCompat backEventCompat) {
        return this.channel.mo0trySendJP2dKIU(backEventCompat);
    }

    public final void setPredictiveBack(boolean z) {
        this.isPredictiveBack = z;
    }
}
