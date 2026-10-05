package defpackage;

import java.util.Random;

/* JADX INFO: renamed from: g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2239g0 extends AbstractC3465nJ {
    @Override // defpackage.AbstractC3465nJ
    public int b() {
        return e().nextInt();
    }

    @Override // defpackage.AbstractC3465nJ
    public int c(int i) {
        return e().nextInt(i);
    }

    public abstract Random e();
}
