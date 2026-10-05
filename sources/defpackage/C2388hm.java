package defpackage;

import java.util.Random;

/* JADX INFO: renamed from: hm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2388hm extends AbstractC2239g0 {
    public final a c = new a();

    /* JADX INFO: renamed from: hm$a */
    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // defpackage.AbstractC2239g0
    public Random e() {
        Object obj = this.c.get();
        AbstractC4492zt.g(obj, "get(...)");
        return (Random) obj;
    }
}
