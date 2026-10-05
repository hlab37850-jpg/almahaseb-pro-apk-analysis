package defpackage;

/* JADX INFO: renamed from: n6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3448n6 extends AbstractC0600Il {
    public final long b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;

    /* JADX INFO: renamed from: n6$b */
    public static final class b extends AbstractC0600Il.a {
        public Long a;
        public Integer b;
        public Integer c;
        public Long d;
        public Integer e;

        @Override // defpackage.AbstractC0600Il.a
        public AbstractC0600Il a() {
            String str = "";
            if (this.a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.b == null) {
                str = str + " loadBatchSize";
            }
            if (this.c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C3448n6(this.a.longValue(), this.b.intValue(), this.c.intValue(), this.d.longValue(), this.e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // defpackage.AbstractC0600Il.a
        public AbstractC0600Il.a b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // defpackage.AbstractC0600Il.a
        public AbstractC0600Il.a c(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // defpackage.AbstractC0600Il.a
        public AbstractC0600Il.a d(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // defpackage.AbstractC0600Il.a
        public AbstractC0600Il.a e(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // defpackage.AbstractC0600Il.a
        public AbstractC0600Il.a f(long j) {
            this.a = Long.valueOf(j);
            return this;
        }
    }

    @Override // defpackage.AbstractC0600Il
    public int b() {
        return this.d;
    }

    @Override // defpackage.AbstractC0600Il
    public long c() {
        return this.e;
    }

    @Override // defpackage.AbstractC0600Il
    public int d() {
        return this.c;
    }

    @Override // defpackage.AbstractC0600Il
    public int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0600Il)) {
            return false;
        }
        AbstractC0600Il abstractC0600Il = (AbstractC0600Il) obj;
        return this.b == abstractC0600Il.f() && this.c == abstractC0600Il.d() && this.d == abstractC0600Il.b() && this.e == abstractC0600Il.c() && this.f == abstractC0600Il.e();
    }

    @Override // defpackage.AbstractC0600Il
    public long f() {
        return this.b;
    }

    public int hashCode() {
        long j = this.b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j2 = this.e;
        return this.f ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.b + ", loadBatchSize=" + this.c + ", criticalSectionEnterTimeoutMs=" + this.d + ", eventCleanUpAge=" + this.e + ", maxBlobByteSizePerRow=" + this.f + "}";
    }

    public C3448n6(long j, int i, int i2, long j2, int i3) {
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }
}
