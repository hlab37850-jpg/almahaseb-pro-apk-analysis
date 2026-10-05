package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityComposeUtilsKt {
    public static final /* synthetic */ <T> T findOwner(Context context) {
        for (Object obj = context; obj instanceof ContextWrapper; obj = (T) ((ContextWrapper) obj).getBaseContext()) {
            AbstractC4492zt.m(3, "T");
            if (obj instanceof Object) {
                return (T) obj;
            }
        }
        return null;
    }
}
