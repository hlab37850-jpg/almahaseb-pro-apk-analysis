package defpackage;

import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Ph, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0821Ph {
    public List a;

    /* JADX INFO: renamed from: Ph$a */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh2.r()).compareTo(String.valueOf(c0795Oh.r()));
        }
    }

    /* JADX INFO: renamed from: Ph$b */
    public class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh.r()).compareTo(String.valueOf(c0795Oh2.r()));
        }
    }

    /* JADX INFO: renamed from: Ph$c */
    public class c implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh2.q()).compareTo(String.valueOf(c0795Oh.q()));
        }
    }

    /* JADX INFO: renamed from: Ph$d */
    public class d implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return String.valueOf(c0795Oh.q()).compareTo(String.valueOf(c0795Oh2.q()));
        }
    }

    /* JADX INFO: renamed from: Ph$e */
    public static class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                return simpleDateFormat.parse(c0795Oh.n()).compareTo(simpleDateFormat.parse(c0795Oh2.n()));
            } catch (ParseException unused) {
                return c0795Oh2.n().compareTo(c0795Oh.n());
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Ph$f */
    public static class f implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                return simpleDateFormat.parse(c0795Oh2.n()).compareTo(simpleDateFormat.parse(c0795Oh.n()));
            } catch (ParseException unused) {
                return c0795Oh2.n().compareTo(c0795Oh.n());
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Ph$g */
    public static class g implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return c0795Oh.p().replaceAll(",", "").compareTo(c0795Oh2.p().replaceAll(",", ""));
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Ph$h */
    public static class h implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return c0795Oh2.p().compareTo(c0795Oh.p());
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Ph$i */
    public static class i implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return Double.valueOf(c0795Oh.l().replaceAll(",", "")).compareTo(Double.valueOf(c0795Oh2.l().replaceAll(",", "")));
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Ph$j */
    public static class j implements Comparator {
        public j() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0795Oh c0795Oh, C0795Oh c0795Oh2) {
            return Double.valueOf(c0795Oh2.l().replaceAll(",", "")).compareTo(Double.valueOf(c0795Oh.l().replaceAll(",", "")));
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    public final void a() {
        Collections.sort(this.a, new f(null));
    }

    public final void b() {
        Collections.sort(this.a, new h(null));
    }

    public final void c() {
        Collections.sort(this.a, Collections.reverseOrder(new d()));
    }

    public final void d() {
        Collections.sort(this.a, Collections.reverseOrder(new b()));
    }

    public final void e() {
        Collections.sort(this.a, new j(null));
    }

    public final void f() {
        Collections.sort(this.a, new i(null));
    }

    public final void g() {
        Collections.sort(this.a, new e(null));
    }

    public final void h() {
        Collections.sort(this.a, new g(null));
    }

    public final void i() {
        Collections.sort(this.a, Collections.reverseOrder(new c()));
    }

    public final void j() {
        Collections.sort(this.a, Collections.reverseOrder(new a()));
    }

    public List k(List list, int i2, int i3) {
        Log.d("trace_2Sort=", "Start:" + i2 + ":" + i3);
        this.a = list;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            if (i3 == 0) {
                                h();
                            } else {
                                b();
                            }
                        }
                    } else if (i3 == 0) {
                        j();
                    } else {
                        d();
                    }
                } else if (i3 == 0) {
                    i();
                } else {
                    c();
                }
            } else if (i3 == 0) {
                f();
            } else {
                e();
            }
        } else if (i3 == 0) {
            g();
        } else {
            a();
        }
        Log.d("trace_2Sort=", "End:" + i2 + ":" + i3);
        list.size();
        return this.a;
    }
}
