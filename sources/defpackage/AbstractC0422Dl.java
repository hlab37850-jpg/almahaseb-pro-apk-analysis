package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: Dl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0422Dl extends AbstractC1040Xf {
    public long a;
    public boolean b;
    public M5 c;

    public static /* synthetic */ void H(AbstractC0422Dl abstractC0422Dl, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        abstractC0422Dl.G(z);
    }

    public static /* synthetic */ void M(AbstractC0422Dl abstractC0422Dl, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        abstractC0422Dl.L(z);
    }

    public final void G(boolean z) {
        long jI = this.a - I(z);
        this.a = jI;
        if (jI <= 0 && this.b) {
            shutdown();
        }
    }

    public final long I(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void J(AbstractC4229wj abstractC4229wj) {
        M5 m5 = this.c;
        if (m5 == null) {
            m5 = new M5();
            this.c = m5;
        }
        m5.a(abstractC4229wj);
    }

    public long K() {
        M5 m5 = this.c;
        if (m5 == null || m5.c()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0L;
    }

    public final void L(boolean z) {
        this.a += I(z);
        if (z) {
            return;
        }
        this.b = true;
    }

    public final boolean N() {
        return this.a >= I(true);
    }

    public final boolean O() {
        M5 m5 = this.c;
        if (m5 != null) {
            return m5.c();
        }
        return true;
    }

    public abstract long P();

    public final boolean Q() throws IllegalAccessException, InvocationTargetException {
        AbstractC4229wj abstractC4229wj;
        M5 m5 = this.c;
        if (m5 == null || (abstractC4229wj = (AbstractC4229wj) m5.d()) == null) {
            return false;
        }
        abstractC4229wj.run();
        return true;
    }

    public boolean R() {
        return false;
    }

    @Override // defpackage.AbstractC1040Xf
    public final AbstractC1040Xf limitedParallelism(int i) {
        AbstractC0458Ev.a(i);
        return this;
    }

    public abstract void shutdown();
}
