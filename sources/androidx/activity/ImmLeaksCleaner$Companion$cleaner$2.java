package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner$Companion$cleaner$2 extends AbstractC2233fv implements InterfaceC3588op {
    public static final ImmLeaksCleaner$Companion$cleaner$2 INSTANCE = new ImmLeaksCleaner$Companion$cleaner$2();

    public ImmLeaksCleaner$Companion$cleaner$2() {
        super(0);
    }

    @Override // defpackage.InterfaceC3588op
    public final ImmLeaksCleaner.Cleaner invoke() {
        try {
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            declaredField3.setAccessible(true);
            AbstractC4492zt.g(declaredField3, "hField");
            AbstractC4492zt.g(declaredField, "servedViewField");
            AbstractC4492zt.g(declaredField2, "nextServedViewField");
            return new ImmLeaksCleaner.ValidCleaner(declaredField3, declaredField, declaredField2);
        } catch (NoSuchFieldException unused) {
            return ImmLeaksCleaner.FailedInitialization.INSTANCE;
        }
    }
}
