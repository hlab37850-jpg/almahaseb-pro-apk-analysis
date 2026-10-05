package defpackage;

/* JADX INFO: renamed from: a8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1205a8 {
    public EnumC4231wl a = EnumC4231wl.Left_Default;
    public a b = a._24DotDoubleDensity_Default;

    /* JADX INFO: renamed from: a8$a */
    public enum a {
        _8DotSingleDensity(0, 8),
        _8DotDoubleDensity(1, 8),
        _24DotSingleDensity(32, 24),
        _24DotDoubleDensity_Default(33, 24);

        public int a;
        public int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public C1205a8 a(EnumC4231wl enumC4231wl) {
        this.a = enumC4231wl;
        return this;
    }
}
