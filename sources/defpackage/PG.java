package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class PG {
    public final float a;
    public final float b;
    public final long c;

    public PG(float f, float f2, long j) {
        this.a = f;
        this.b = f2;
        this.c = j;
    }

    public final float a(PG pg) {
        return (float) Math.sqrt(Math.pow(this.a - pg.a, 2.0d) + Math.pow(this.b - pg.b, 2.0d));
    }

    public float b(PG pg) {
        return a(pg) / (this.c - pg.c);
    }
}
