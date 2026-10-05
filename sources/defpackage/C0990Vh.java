package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import androidx.paging.rxjava3.PagingRx;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: Vh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0990Vh extends AndroidViewModel {
    public MutableLiveData a;
    public MutableLiveData b;
    public MutableLiveData c;
    public AbstractC3258kn d;
    public MutableLiveData e;
    public MutableLiveData f;
    public MutableLiveData g;
    public MutableLiveData h;
    public AbstractC3258kn i;
    public MutableLiveData j;

    /* JADX INFO: renamed from: Vh$a */
    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ double[] c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ Z00 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;
        public final /* synthetic */ Handler k;

        /* JADX INFO: renamed from: Vh$a$a, reason: collision with other inner class name */
        public class RunnableC0023a implements Runnable {
            public RunnableC0023a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != 11) {
                    Log.d("trace_2Footer=", "" + a.this.c[0]);
                    a aVar = a.this;
                    C0990Vh.this.g.postValue(Double.valueOf(aVar.c[0]));
                    return;
                }
                Log.d("trace_2Footer=", "" + a.this.c[0] + ":" + a.this.c[1]);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Double.valueOf(a.this.c[0]));
                arrayList.add(Double.valueOf(a.this.c[1]));
                C0990Vh.this.h.postValue(arrayList);
            }
        }

        public a(int i, int i2, double[] dArr, Context context, Z00 z00, String str, String str2, String str3, int i3, String str4, Handler handler) {
            this.a = i;
            this.b = i2;
            this.c = dArr;
            this.d = context;
            this.e = z00;
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = i3;
            this.j = str4;
            this.k = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i = this.a;
                String str = CSS.Value.PERCENTAGE;
                if (i == 10) {
                    int i2 = this.b;
                    if (i2 == 8 || i2 == 9) {
                        double[] dArr = this.c;
                        C2160f10 c2160f10 = new C2160f10(this.d, this.e);
                        if (!this.f.equals("0")) {
                            str = this.f;
                        }
                        dArr[0] = c2160f10.w(str, this.b, 2, this.g, this.h, CSS.Value.PERCENTAGE, this.i, this.j);
                    } else {
                        double[] dArr2 = this.c;
                        C2160f10 c2160f11 = new C2160f10(this.d, this.e);
                        if (!this.f.equals("0")) {
                            str = this.f;
                        }
                        dArr2[0] = c2160f11.x(str, this.b, 2, this.g, this.h, CSS.Value.PERCENTAGE, this.i, this.j);
                    }
                } else if (i == 11) {
                    C2160f10 c2160f12 = new C2160f10(this.d, this.e);
                    if (!this.f.equals("0")) {
                        str = this.f;
                    }
                    double[] dArrA = c2160f12.A(str, this.g, this.h, -1, -1, this.i, this.j);
                    double[] dArr3 = this.c;
                    dArr3[0] = dArrA[0];
                    dArr3[1] = dArrA[1];
                } else if (i == 12) {
                    this.c[0] = new C2160f10(this.d, this.e).B(this.g, this.h, -1, -1, this.i, this.j);
                }
                this.k.post(new RunnableC0023a());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: Vh$b */
    public class b implements Runnable {
        public final /* synthetic */ Z00 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Handler f;

        /* JADX INFO: renamed from: Vh$b$a */
        public class a implements Runnable {
            public final /* synthetic */ List a;

            public a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0990Vh.this.j.postValue(this.a);
            }
        }

        public b(Z00 z00, String str, String str2, int i, String str3, Handler handler) {
            this.a = z00;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = str3;
            this.f = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f.post(new a(this.a.Y3(this.b, this.c, this.d, this.e)));
            } catch (Exception unused) {
            }
        }
    }

    public C0990Vh(@NonNull Application application) {
        super(application);
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
        this.e = new MutableLiveData();
        this.f = new MutableLiveData();
        this.g = new MutableLiveData();
        this.h = new MutableLiveData();
        this.j = new MutableLiveData();
    }

    public void e(Context context, String str, int i, Z00 z00, String str2, String str3, int i2, int i3, int i4, int i5, String str4, int i6, int i7) {
        PagingConfig pagingConfig = new PagingConfig(C2160f10.l, 20, false, 20, Integer.MAX_VALUE);
        final C1817bi c1817bi = new C1817bi(context, str, i, z00, str2, str3, i2, i3, i4, i5, str4, i6, i7);
        this.d = PagingRx.getFlowable(new Pager(pagingConfig, new InterfaceC3588op() { // from class: Th
            @Override // defpackage.InterfaceC3588op
            public final Object invoke() {
                return C0990Vh.c(c1817bi);
            }
        }));
        PagingRx.cachedIn(this.d, ViewModelKt.getViewModelScope(this));
    }

    public void f(Context context, String str, String str2, Z00 z00, String str3, int i, String str4, String str5, int i2, int i3, String str6, int i4, int i5) {
        PagingConfig pagingConfig = new PagingConfig(C2160f10.l, 20, false, 20, Integer.MAX_VALUE);
        final C1084Yh c1084Yh = new C1084Yh(context, str, str2, z00, CSS.Value.PERCENTAGE, i, str4, str5, i2, i3, str6, i4, i5);
        this.i = PagingRx.getFlowable(new Pager(pagingConfig, new InterfaceC3588op() { // from class: Uh
            @Override // defpackage.InterfaceC3588op
            public final Object invoke() {
                return C0990Vh.d(c1084Yh);
            }
        }));
        PagingRx.cachedIn(this.i, ViewModelKt.getViewModelScope(this));
    }

    public void g(Context context, String str, int i, Z00 z00, String str2, String str3, int i2, int i3, int i4, String str4) {
        Executors.newSingleThreadExecutor().execute(new a(i2, i, new double[]{0.0d, 0.0d}, context, z00, str, str2, str3, i4, str4, new Handler(Looper.getMainLooper())));
    }

    public void h(Context context, String str, String str2, Z00 z00, int i, String str3) {
        Log.d("trace_2Footer=", str + ":" + str2 + ":" + i + ":" + str3);
        Executors.newSingleThreadExecutor().execute(new b(z00, str, str2, i, str3, new Handler(Looper.getMainLooper())));
    }

    public static /* synthetic */ PagingSource c(C1817bi c1817bi) {
        return c1817bi;
    }

    public static /* synthetic */ PagingSource d(C1084Yh c1084Yh) {
        return c1084Yh;
    }
}
