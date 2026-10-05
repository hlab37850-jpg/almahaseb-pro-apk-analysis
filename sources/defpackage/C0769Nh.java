package defpackage;

import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: Nh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0769Nh {
    public List a;

    /* JADX INFO: renamed from: Nh$a */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh2.t()).compareTo(String.valueOf(c4064uh.t()));
        }
    }

    /* JADX INFO: renamed from: Nh$b */
    public class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh.t()).compareTo(String.valueOf(c4064uh2.t()));
        }
    }

    /* JADX INFO: renamed from: Nh$c */
    public class c implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh2.r()).compareTo(String.valueOf(c4064uh.r()));
        }
    }

    /* JADX INFO: renamed from: Nh$d */
    public class d implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return String.valueOf(c4064uh.r()).compareTo(String.valueOf(c4064uh2.r()));
        }
    }

    /* JADX INFO: renamed from: Nh$e */
    public class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                int iCompareTo = simpleDateFormat.parse(c4064uh.p()).compareTo(simpleDateFormat.parse(c4064uh2.p()));
                return iCompareTo == 0 ? Integer.valueOf(c4064uh.q()).compareTo(Integer.valueOf(c4064uh2.q())) : iCompareTo;
            } catch (ParseException unused) {
                return 0;
            }
        }

        public /* synthetic */ e(C0769Nh c0769Nh, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Nh$f */
    public class f implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            try {
                int iCompareTo = simpleDateFormat.parse(c4064uh2.p()).compareTo(simpleDateFormat.parse(c4064uh.p()));
                return iCompareTo == 0 ? Integer.valueOf(c4064uh2.q()).compareTo(Integer.valueOf(c4064uh.q())) : iCompareTo;
            } catch (ParseException unused) {
                return 0;
            }
        }

        public /* synthetic */ f(C0769Nh c0769Nh, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Nh$g */
    public class g implements Comparator {
        public g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh.f().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh2.f().replaceAll(",", "")));
        }

        public /* synthetic */ g(C0769Nh c0769Nh, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Nh$h */
    public class h implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh2.f().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh.f().replaceAll(",", "")));
        }

        public /* synthetic */ h(C0769Nh c0769Nh, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Nh$i */
    public class i implements Comparator {
        public i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh.n().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh2.n().replaceAll(",", "")));
        }

        public /* synthetic */ i(C0769Nh c0769Nh, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: Nh$j */
    public class j implements Comparator {
        public j() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C4064uh c4064uh, C4064uh c4064uh2) {
            return Double.valueOf(c4064uh2.n().replaceAll(",", "")).compareTo(Double.valueOf(c4064uh.n().replaceAll(",", "")));
        }

        public /* synthetic */ j(C0769Nh c0769Nh, a aVar) {
            this();
        }
    }

    public final void a() {
        Collections.sort(this.a, new f(this, null));
    }

    public final void b() {
        Collections.sort(this.a, new h(this, null));
    }

    public final void c() {
        Collections.sort(this.a, Collections.reverseOrder(new d()));
    }

    public final void d() {
        Collections.sort(this.a, Collections.reverseOrder(new b()));
    }

    public final void e() {
        Collections.sort(this.a, new j(this, null));
    }

    public final void f() {
        Collections.sort(this.a, new i(this, null));
    }

    public final void g() {
        Collections.sort(this.a, new e(this, null));
    }

    public final void h() {
        Collections.sort(this.a, new g(this, null));
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
