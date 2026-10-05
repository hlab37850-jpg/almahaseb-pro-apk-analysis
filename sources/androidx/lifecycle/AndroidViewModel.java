package androidx.lifecycle;

import android.app.Application;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application) {
        AbstractC4492zt.h(application, Annotation.APPLICATION);
        this.application = application;
    }

    public <T extends Application> T getApplication() {
        T t = (T) this.application;
        AbstractC4492zt.f(t, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t;
    }
}
