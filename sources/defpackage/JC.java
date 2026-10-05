package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.activity.d;
import info.aalmoghalis.inventory.activity.e;
import info.aalmoghalis.inventory.activity.f;
import info.aalmoghalis.inventory.activity.g;
import info.aalmoghalis.inventory.activity.h;
import info.aalmoghalis.inventory.activity.i;
import info.aalmoghalis.inventory.activity.j;
import info.aalmoghalis.inventory.activity.k;
import info.aalmoghalis.inventory.activity.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class JC extends FragmentStatePagerAdapter {
    public List a;
    public ArrayList b;
    public ArrayList c;
    public int d;
    public Context e;
    public SQLiteDatabase f;
    public Z00 g;
    public String h;
    public double i;
    public int[] j;
    public F5 k;
    public ViewOnClickListenerC4396yo l;
    public f m;
    public g n;
    public i o;
    public j p;
    public h q;
    public l r;
    public C1739ap s;
    public ViewOnClickListenerC0967Uo t;
    public k u;
    public ViewOnClickListenerC3091io v;
    public K5 w;
    public ViewOnClickListenerC1049Xo x;
    public e y;
    public ArrayList z;

    public JC(FragmentManager fragmentManager, List list, int i, Context context) {
        super(fragmentManager);
        this.h = "";
        this.i = 0.0d;
        this.j = new int[]{R.drawable.up, 1, R.drawable.down};
        this.z = new ArrayList();
        this.a = list;
        this.d = i;
        this.e = context;
        this.g = new Z00(this.f, context);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        int i = this.d;
        if (i == 0) {
            List list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        if (i == 7) {
            ArrayList arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        if (i == 17 || i == 18 || i == 71 || i == 72 || i == 73) {
            ArrayList arrayList2 = this.c;
            if (arrayList2 == null) {
                return 0;
            }
            return arrayList2.size();
        }
        if (i == 11) {
            return 100;
        }
        ArrayList arrayList3 = this.b;
        if (arrayList3 == null) {
            return 0;
        }
        return arrayList3.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        Log.d("trace_S_getitem_Frag=", FragmentStatePagerSupport_Main.X());
        Log.d("Frag.Created=", i + ":" + this.d + ":" + FragmentStatePagerSupport_Main.W);
        int i2 = this.d;
        if (i2 == 3) {
            ViewOnClickListenerC4396yo viewOnClickListenerC4396yo = new ViewOnClickListenerC4396yo((C0917Sq) this.b.get(i), i, getCount(), this.h);
            this.l = viewOnClickListenerC4396yo;
            return viewOnClickListenerC4396yo;
        }
        if (i2 == 10) {
            ViewOnClickListenerC3091io viewOnClickListenerC3091io = new ViewOnClickListenerC3091io((C0917Sq) this.b.get(i), i, getCount(), this.h);
            this.v = viewOnClickListenerC3091io;
            return viewOnClickListenerC3091io;
        }
        if (i2 == 8) {
            ViewOnClickListenerC0967Uo viewOnClickListenerC0967Uo = new ViewOnClickListenerC0967Uo((C0917Sq) this.b.get(i), i, getCount(), this.h);
            this.t = viewOnClickListenerC0967Uo;
            return viewOnClickListenerC0967Uo;
        }
        if (i2 == 9) {
            k kVar = new k((C0917Sq) this.b.get(i), i, getCount(), this.h);
            this.u = kVar;
            return kVar;
        }
        if (i2 == 4) {
            return d.w((C0917Sq) this.b.get(i), i, getCount(), ((C0917Sq) this.b.get(i)).e(), ((C0917Sq) this.b.get(i)).a());
        }
        if (i2 == 1) {
            f fVar = new f((C0917Sq) this.b.get(i), i, getCount(), this.h);
            this.m = fVar;
            return fVar;
        }
        if (i2 == 7) {
            g gVar = new g((C4145vh) this.c.get(i), i, getCount(), this.h);
            this.n = gVar;
            return gVar;
        }
        if (i2 == 71) {
            i iVar = new i((C4145vh) this.c.get(i), i, getCount(), this.h);
            this.o = iVar;
            return iVar;
        }
        if (i2 == 72) {
            j jVar = new j((C4145vh) this.c.get(i), i, getCount(), this.h);
            this.p = jVar;
            return jVar;
        }
        if (i2 == 73) {
            h hVar = new h((C4145vh) this.c.get(i), i, getCount(), this.h);
            this.q = hVar;
            return hVar;
        }
        if (i2 == 17) {
            l lVar = new l((C4145vh) this.c.get(i), i, getCount(), this.h);
            this.r = lVar;
            return lVar;
        }
        if (i2 == 18) {
            C1739ap c1739ap = new C1739ap((C4145vh) this.c.get(i), i, getCount(), this.h);
            this.s = c1739ap;
            return c1739ap;
        }
        if (i2 == 2) {
            e eVar = new e((C0917Sq) this.b.get(i), i, getCount(), ((C0917Sq) this.b.get(i)).e(), ((C0917Sq) this.b.get(i)).a(), ((C0917Sq) this.b.get(i)).b());
            this.y = eVar;
            return eVar;
        }
        if (i2 == 0) {
            F5 f5 = new F5((C4143vg) this.a.get(i), i, getCount(), new ArrayList(), this.h, false);
            this.k = f5;
            return f5;
        }
        if (i2 == 11) {
            String strF5 = this.g.f5(i * (-1));
            FragmentStatePagerSupport.O = strF5;
            FragmentStatePagerSupport.P = strF5;
            K5 k5 = new K5(i, getCount(), new ArrayList(), this.h, false);
            this.w = k5;
            return k5;
        }
        if (i2 != 12) {
            return null;
        }
        Log.d("Frag5.Created=", i + ":" + this.d + ":" + ((C0917Sq) this.b.get(i)).a());
        ViewOnClickListenerC1049Xo viewOnClickListenerC1049Xo = new ViewOnClickListenerC1049Xo((C0917Sq) this.b.get(i), i, getCount(), this.h);
        this.x = viewOnClickListenerC1049Xo;
        viewOnClickListenerC1049Xo.setRetainInstance(true);
        return this.x;
    }

    public JC(FragmentManager fragmentManager, ArrayList arrayList, int i, Context context) {
        super(fragmentManager);
        this.h = "";
        this.i = 0.0d;
        this.j = new int[]{R.drawable.up, 1, R.drawable.down};
        this.z = new ArrayList();
        this.b = arrayList;
        this.d = i;
        this.e = context;
        this.g = new Z00(this.f, context);
    }

    public JC(FragmentManager fragmentManager, ArrayList arrayList, int i, Context context, String str) {
        super(fragmentManager);
        this.h = "";
        this.i = 0.0d;
        this.j = new int[]{R.drawable.up, 1, R.drawable.down};
        this.z = new ArrayList();
        this.c = arrayList;
        this.d = i;
        this.e = context;
        this.g = new Z00(this.f, context);
    }
}
