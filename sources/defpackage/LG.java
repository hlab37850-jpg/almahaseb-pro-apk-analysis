package defpackage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes3.dex */
public final class LG extends AbstractC2239g0 {
    @Override // defpackage.AbstractC2239g0
    public Random e() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        AbstractC4492zt.g(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
