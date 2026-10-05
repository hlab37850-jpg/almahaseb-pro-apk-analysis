package defpackage;

import androidx.compose.material3.CalendarModelKt;
import com.google.common.net.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: p9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3618p9 {
    public static final a c = new a(null);
    public final C3873sL a;
    public final EL b;

    /* JADX INFO: renamed from: p9$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:24:0x003b  */
        public final boolean a(EL el, C3873sL c3873sL) {
            AbstractC4492zt.h(el, "response");
            AbstractC4492zt.h(c3873sL, "request");
            int iR = el.r();
            if (iR != 200 && iR != 410 && iR != 414 && iR != 501 && iR != 203 && iR != 204) {
                if (iR == 307) {
                    if (EL.x(el, HttpHeaders.EXPIRES, null, 2, null) == null && el.d().c() == -1 && !el.d().b() && !el.d().a()) {
                        return false;
                    }
                } else if (iR != 308 && iR != 404 && iR != 405) {
                    switch (iR) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            if (EL.x(el, HttpHeaders.EXPIRES, null, 2, null) == null) {
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
            return (el.d().h() || c3873sL.b().h()) ? false : true;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: p9$b */
    public static final class b {
        public final long a;
        public final C3873sL b;
        public final EL c;
        public Date d;
        public String e;
        public Date f;
        public String g;
        public Date h;
        public long i;
        public long j;
        public String k;
        public int l;

        public b(long j, C3873sL c3873sL, EL el) {
            AbstractC4492zt.h(c3873sL, "request");
            this.a = j;
            this.b = c3873sL;
            this.c = el;
            this.l = -1;
            if (el != null) {
                this.i = el.L();
                this.j = el.J();
                C3994tr c3994trZ = el.z();
                int size = c3994trZ.size();
                for (int i = 0; i < size; i++) {
                    String strB = c3994trZ.b(i);
                    String strE = c3994trZ.e(i);
                    if (AbstractC3880sS.q(strB, HttpHeaders.DATE, true)) {
                        this.d = AbstractC3170ji.a(strE);
                        this.e = strE;
                    } else if (AbstractC3880sS.q(strB, HttpHeaders.EXPIRES, true)) {
                        this.h = AbstractC3170ji.a(strE);
                    } else if (AbstractC3880sS.q(strB, HttpHeaders.LAST_MODIFIED, true)) {
                        this.f = AbstractC3170ji.a(strE);
                        this.g = strE;
                    } else if (AbstractC3880sS.q(strB, HttpHeaders.ETAG, true)) {
                        this.k = strE;
                    } else if (AbstractC3880sS.q(strB, HttpHeaders.AGE, true)) {
                        this.l = AbstractC3724qX.X(strE, -1);
                    }
                }
            }
        }

        public final long a() {
            Date date = this.d;
            long jMax = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return jMax + (j - this.i) + (this.a - j);
        }

        public final C3618p9 b() {
            C3618p9 c3618p9C = c();
            return (c3618p9C.b() == null || !this.b.b().i()) ? c3618p9C : new C3618p9(null, null);
        }

        public final C3618p9 c() {
            String str;
            if (this.c == null) {
                return new C3618p9(this.b, null);
            }
            if (this.b.f() && this.c.u() == null) {
                return new C3618p9(this.b, null);
            }
            if (!C3618p9.c.a(this.c, this.b)) {
                return new C3618p9(this.b, null);
            }
            C3290l9 c3290l9B = this.b.b();
            if (c3290l9B.g() || e(this.b)) {
                return new C3618p9(this.b, null);
            }
            C3290l9 c3290l9D = this.c.d();
            long jA = a();
            long jD = d();
            if (c3290l9B.c() != -1) {
                jD = Math.min(jD, TimeUnit.SECONDS.toMillis(c3290l9B.c()));
            }
            long millis = 0;
            long millis2 = c3290l9B.e() != -1 ? TimeUnit.SECONDS.toMillis(c3290l9B.e()) : 0L;
            if (!c3290l9D.f() && c3290l9B.d() != -1) {
                millis = TimeUnit.SECONDS.toMillis(c3290l9B.d());
            }
            if (!c3290l9D.g()) {
                long j = millis2 + jA;
                if (j < millis + jD) {
                    EL.a aVarG = this.c.G();
                    if (j >= jD) {
                        aVarG.a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > CalendarModelKt.MillisecondsIn24Hours && f()) {
                        aVarG.a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new C3618p9(null, aVarG.c());
                }
            }
            String str2 = this.k;
            if (str2 != null) {
                str = HttpHeaders.IF_NONE_MATCH;
            } else {
                if (this.f != null) {
                    str2 = this.g;
                } else {
                    if (this.d == null) {
                        return new C3618p9(this.b, null);
                    }
                    str2 = this.e;
                }
                str = HttpHeaders.IF_MODIFIED_SINCE;
            }
            C3994tr.a aVarC = this.b.e().c();
            AbstractC4492zt.e(str2);
            aVarC.c(str, str2);
            return new C3618p9(this.b.h().d(aVarC.d()).b(), this.c);
        }

        public final long d() {
            EL el = this.c;
            AbstractC4492zt.e(el);
            C3290l9 c3290l9D = el.d();
            if (c3290l9D.c() != -1) {
                return TimeUnit.SECONDS.toMillis(c3290l9D.c());
            }
            Date date = this.h;
            if (date != null) {
                Date date2 = this.d;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f == null || this.c.K().i().n() != null) {
                return 0L;
            }
            Date date3 = this.d;
            long time2 = date3 != null ? date3.getTime() : this.i;
            Date date4 = this.f;
            AbstractC4492zt.e(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / ((long) 10);
            }
            return 0L;
        }

        public final boolean e(C3873sL c3873sL) {
            return (c3873sL.d(HttpHeaders.IF_MODIFIED_SINCE) == null && c3873sL.d(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }

        public final boolean f() {
            EL el = this.c;
            AbstractC4492zt.e(el);
            return el.d().c() == -1 && this.h == null;
        }
    }

    public C3618p9(C3873sL c3873sL, EL el) {
        this.a = c3873sL;
        this.b = el;
    }

    public final EL a() {
        return this.b;
    }

    public final C3873sL b() {
        return this.a;
    }
}
