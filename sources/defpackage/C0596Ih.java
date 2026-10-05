package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingSource;
import androidx.paging.rxjava3.PagingRx;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: Ih, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0596Ih extends ViewModel {
    public AbstractC3258kn g;
    public MutableLiveData a = new MutableLiveData();
    public MutableLiveData b = new MutableLiveData();
    public MutableLiveData c = new MutableLiveData();
    public MutableLiveData d = new MutableLiveData();
    public MutableLiveData e = new MutableLiveData();
    public ExecutorService f = Executors.newSingleThreadExecutor();
    public MutableLiveData h = new MutableLiveData();

    /* JADX INFO: renamed from: Ih$a */
    public class a implements Runnable {
        public final /* synthetic */ Z00 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Handler e;

        /* JADX INFO: renamed from: Ih$a$a, reason: collision with other inner class name */
        public class RunnableC0009a implements Runnable {
            public final /* synthetic */ List a;

            public RunnableC0009a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0596Ih.this.h.postValue(this.a);
            }
        }

        public a(Z00 z00, String str, int i, String str2, Handler handler) {
            this.a = z00;
            this.b = str;
            this.c = i;
            this.d = str2;
            this.e = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.e.post(new RunnableC0009a(this.a.c4(this.b, this.c, this.d)));
            } catch (Exception unused) {
            }
        }
    }

    public void c(Context context, String str, String str2, Z00 z00, String str3, String str4, int i, int i2, int i3, String str5, int i4, int i5) {
        PagingConfig pagingConfig = new PagingConfig(C2160f10.l, 20, false, 20, Integer.MAX_VALUE);
        final C0743Mh c0743Mh = new C0743Mh(context, str, str2, z00, str3, str4, i, i2, i3, str5, i4, i5);
        this.g = PagingRx.getFlowable(new Pager(pagingConfig, new InterfaceC3588op() { // from class: Hh
            @Override // defpackage.InterfaceC3588op
            public final Object invoke() {
                return C0596Ih.b(c0743Mh);
            }
        }));
        PagingRx.cachedIn(this.g, ViewModelKt.getViewModelScope(this));
    }

    public void d(Context context, String str, Z00 z00, int i, String str2) {
        Executors.newSingleThreadExecutor().execute(new a(z00, str, i, str2, new Handler(Looper.getMainLooper())));
    }

    public static /* synthetic */ PagingSource b(C0743Mh c0743Mh) {
        return c0743Mh;
    }
}
