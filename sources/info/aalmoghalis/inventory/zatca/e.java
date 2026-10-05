package info.aalmoghalis.inventory.zatca;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.Z00;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public final info.aalmoghalis.inventory.zatca.d a;
    public final info.aalmoghalis.inventory.zatca.c b;
    public Z00 g;
    public final Handler d = new Handler(Looper.getMainLooper());
    public List e = new ArrayList();
    public List f = new ArrayList();
    public final ExecutorService c = Executors.newSingleThreadExecutor();

    public class a implements info.aalmoghalis.inventory.zatca.d.InterfaceC0322d {
        public final /* synthetic */ f a;
        public final /* synthetic */ h b;
        public final /* synthetic */ info.aalmoghalis.inventory.zatca.d.j c;

        public a(f fVar, h hVar, info.aalmoghalis.inventory.zatca.d.j jVar) {
            this.a = fVar;
            this.b = hVar;
            this.c = jVar;
        }

        public final /* synthetic */ void b(h hVar, info.aalmoghalis.inventory.zatca.d.k kVar, info.aalmoghalis.inventory.zatca.d.j jVar, f fVar) {
            g gVar = new g();
            gVar.b = hVar.a;
            gVar.d = hVar.b;
            gVar.e = hVar.g;
            gVar.i = true;
            gVar.j = 0;
            gVar.k = true;
            gVar.l = kVar.d;
            gVar.m = e.this.r(kVar.e, "EGS-" + System.currentTimeMillis());
            gVar.n = kVar.f;
            gVar.o = hVar.j;
            gVar.p = e.this.L(hVar.k);
            gVar.g = hVar.c;
            gVar.h = hVar.d;
            gVar.f = hVar.f;
            gVar.c = e.this.a.r().substring(0, 10);
            gVar.q = jVar.h;
            e.this.E(fVar, e.this.b.j(gVar));
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(final info.aalmoghalis.inventory.zatca.d.k kVar) {
            if (TextUtils.isEmpty(kVar.d) || TextUtils.isEmpty(kVar.f)) {
                e.this.F(this.a, "Invalid ZATCA response: missing certificate or taxer");
                return;
            }
            ExecutorService executorService = e.this.c;
            final h hVar = this.b;
            final info.aalmoghalis.inventory.zatca.d.j jVar = this.c;
            final f fVar = this.a;
            executorService.execute(new Runnable() { // from class: z00
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(hVar, kVar, jVar, fVar);
                }
            });
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        public void onError(String str) {
            e.this.F(this.a, str);
        }
    }

    public class b implements info.aalmoghalis.inventory.zatca.d.InterfaceC0322d {
        public final /* synthetic */ f a;
        public final /* synthetic */ g b;
        public final /* synthetic */ String c;

        public b(f fVar, g gVar, String str) {
            this.a = fVar;
            this.b = gVar;
            this.c = str;
        }

        public final /* synthetic */ void b(g gVar, String str, info.aalmoghalis.inventory.zatca.d.k kVar, f fVar) {
            gVar.i = true;
            gVar.o = str;
            gVar.l = e.this.r(kVar.d, gVar.l);
            gVar.m = e.this.r(kVar.e, gVar.m);
            gVar.n = e.this.r(kVar.f, gVar.n);
            e.this.E(fVar, e.this.b.n(gVar));
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(final info.aalmoghalis.inventory.zatca.d.k kVar) {
            if (TextUtils.isEmpty(kVar.d) || TextUtils.isEmpty(kVar.f)) {
                e.this.F(this.a, "Invalid ZATCA response: missing certificate or taxer");
                return;
            }
            ExecutorService executorService = e.this.c;
            final g gVar = this.b;
            final String str = this.c;
            final f fVar = this.a;
            executorService.execute(new Runnable() { // from class: A00
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(gVar, str, kVar, fVar);
                }
            });
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        public void onError(String str) {
            e.this.F(this.a, str);
        }
    }

    public class c implements info.aalmoghalis.inventory.zatca.d.InterfaceC0322d {
        public final /* synthetic */ f a;
        public final /* synthetic */ g b;

        public c(f fVar, g gVar) {
            this.a = fVar;
            this.b = gVar;
        }

        public final /* synthetic */ void c(g gVar, f fVar) {
            gVar.i = false;
            e.this.E(fVar, e.this.b.o(gVar));
        }

        public final /* synthetic */ void d(g gVar, f fVar) {
            gVar.i = false;
            e.this.E(fVar, e.this.b.o(gVar));
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onSuccess(info.aalmoghalis.inventory.zatca.d.k kVar) {
            if (TextUtils.isEmpty(kVar.d) || TextUtils.isEmpty(kVar.f)) {
                e.this.F(this.a, "Invalid ZATCA response: missing certificate or taxer");
                return;
            }
            ExecutorService executorService = e.this.c;
            final g gVar = this.b;
            final f fVar = this.a;
            executorService.execute(new Runnable() { // from class: B00
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d(gVar, fVar);
                }
            });
        }

        @Override // info.aalmoghalis.inventory.zatca.d.InterfaceC0322d
        public void onError(String str) {
            e.this.F(this.a, str);
            if (str.contains("Invalid login")) {
                ExecutorService executorService = e.this.c;
                final g gVar = this.b;
                final f fVar = this.a;
                executorService.execute(new Runnable() { // from class: C00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.c(gVar, fVar);
                    }
                });
            }
        }
    }

    public static class d {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.zatca.e$e, reason: collision with other inner class name */
    public static class C0323e {
        public final String a;
        public final String b;

        public C0323e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public interface f {
        void onError(String str);

        void onSuccess(Object obj);
    }

    public static class g {
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public boolean i;
        public int j;
        public boolean k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;

        public g a() {
            g gVar = new g();
            gVar.a = this.a;
            gVar.b = this.b;
            gVar.d = this.d;
            gVar.e = this.e;
            gVar.i = this.i;
            gVar.j = this.j;
            gVar.k = this.k;
            gVar.l = this.l;
            gVar.m = this.m;
            gVar.n = this.n;
            gVar.o = this.o;
            gVar.p = this.p;
            gVar.g = this.g;
            gVar.c = this.c;
            gVar.f = this.f;
            gVar.q = this.q;
            return gVar;
        }
    }

    public static class h {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h = "SA";
        public String i;
        public String j;
        public String k;
        public d l;
        public String m;
        public String n;
    }

    public e(Context context, Z00 z00) {
        this.a = new info.aalmoghalis.inventory.zatca.d(context.getApplicationContext());
        this.b = new info.aalmoghalis.inventory.zatca.c(context.getApplicationContext());
        this.g = z00;
    }

    public final /* synthetic */ void A(h hVar, String str, f fVar) {
        if (this.b.i(hVar.a, str, hVar.b)) {
            F(fVar, "ZATCA unit already exists for this branch/environment.");
            return;
        }
        info.aalmoghalis.inventory.zatca.d.j jVar = new info.aalmoghalis.inventory.zatca.d.j();
        jVar.a = hVar.c;
        jVar.b = hVar.d;
        jVar.c = hVar.e;
        jVar.d = hVar.f;
        jVar.e = hVar.g;
        jVar.f = L(hVar.k);
        jVar.g = hVar.h;
        jVar.h = q(hVar.l);
        String str2 = hVar.i;
        jVar.i = str2;
        jVar.j = str2;
        jVar.k = hVar.l.e;
        jVar.l = hVar.l.a + " " + hVar.l.b;
        jVar.m = hVar.l.e + " " + hVar.l.d;
        d dVar = hVar.l;
        jVar.n = dVar.d;
        jVar.o = dVar.e;
        jVar.p = hVar.b;
        jVar.q = hVar.j;
        jVar.s = Z00.T;
        this.a.b0(jVar, new a(fVar, hVar, jVar));
    }

    public final /* synthetic */ void B(int i, f fVar, String str) {
        g gVarD = this.b.d(i);
        if (gVarD == null) {
            F(fVar, "ZATCA unit not exists or not active for this branch/environment:" + i);
            return;
        }
        info.aalmoghalis.inventory.zatca.d.l lVar = new info.aalmoghalis.inventory.zatca.d.l();
        lVar.a = gVarD.l;
        lVar.b = gVarD.m;
        lVar.c = gVarD.n;
        lVar.d = str;
        lVar.e = gVarD.g;
        this.a.X(lVar, new b(fVar, gVarD, str));
    }

    public final /* synthetic */ void C(int i, f fVar) {
        g gVarD = this.b.d(i);
        if (gVarD == null) {
            F(fVar, "ZATCA unit not exists or not active for this branch/environment.");
            return;
        }
        info.aalmoghalis.inventory.zatca.d.m mVar = new info.aalmoghalis.inventory.zatca.d.m();
        mVar.a = gVarD.l;
        mVar.b = gVarD.m;
        mVar.c = gVarD.n;
        mVar.d = gVarD.o;
        mVar.e = gVarD.g;
        this.a.c0(mVar, new c(fVar, gVarD));
    }

    public final /* synthetic */ void D(int i, boolean z, f fVar) {
        if (this.b.m(i, z)) {
            G(fVar);
        } else {
            F(fVar, "Device not found");
        }
    }

    public final void E(final f fVar, final g gVar) {
        this.d.post(new Runnable() { // from class: y00
            @Override // java.lang.Runnable
            public final void run() {
                fVar.onSuccess(gVar);
            }
        });
    }

    public final void F(final f fVar, final String str) {
        this.d.post(new Runnable() { // from class: w00
            @Override // java.lang.Runnable
            public final void run() {
                fVar.onError(str);
            }
        });
    }

    public final void G(final f fVar) {
        this.d.post(new Runnable() { // from class: v00
            @Override // java.lang.Runnable
            public final void run() {
                fVar.onSuccess(null);
            }
        });
    }

    public void H(final h hVar, final String str, final f fVar) {
        if (TextUtils.isEmpty(hVar.a)) {
            fVar.onError("Branch is required.");
        } else {
            this.c.execute(new Runnable() { // from class: t00
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.A(hVar, str, fVar);
                }
            });
        }
    }

    public void I(final int i, final String str, final f fVar) {
        this.c.execute(new Runnable() { // from class: x00
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B(i, fVar, str);
            }
        });
    }

    public void J(final int i, final f fVar) {
        this.c.execute(new Runnable() { // from class: u00
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C(i, fVar);
            }
        });
    }

    public void K(final int i, final boolean z, final f fVar) {
        this.c.execute(new Runnable() { // from class: s00
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D(i, z, fVar);
            }
        });
    }

    public final String L(String str) {
        return str == null ? "" : str;
    }

    public final String q(d dVar) {
        return dVar.a + ", " + dVar.b + ", " + dVar.c + ", " + dVar.d + ", " + dVar.e;
    }

    public final String r(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public void s(final f fVar) {
        this.e = u();
        this.d.postDelayed(new Runnable() { // from class: q00
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v(fVar);
            }
        }, 200L);
    }

    public void t(final String str, final String str2, final f fVar) {
        this.c.execute(new Runnable() { // from class: r00
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w(str, str2, fVar);
            }
        });
    }

    public ArrayList u() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = this.g.a.rawQuery("SELECT a.id AS id, a.name AS name FROM branches a ORDER BY a.id", null);
        try {
            int columnIndexOrThrow = cursorRawQuery.getColumnIndexOrThrow(HTML.Attribute.ID);
            int columnIndexOrThrow2 = cursorRawQuery.getColumnIndexOrThrow("name");
            while (cursorRawQuery.moveToNext()) {
                arrayList.add(new C0323e(cursorRawQuery.getString(columnIndexOrThrow), cursorRawQuery.getString(columnIndexOrThrow2)));
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final /* synthetic */ void v(f fVar) {
        fVar.onSuccess(new ArrayList(this.e));
    }

    public final /* synthetic */ void w(String str, String str2, f fVar) {
        g gVarC = this.b.c(str, this.a.r(), str2);
        if (gVarC == null) {
            F(fVar, "DEVICE_NOT_FOUND");
        } else {
            E(fVar, gVarC.a());
        }
    }
}
