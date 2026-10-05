package defpackage;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.time.Clock;

/* JADX INFO: renamed from: kg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3248kg {
    public final Context a;
    public final Clock b;
    public final Clock c;

    public C3248kg(Context context, Clock clock, Clock clock2) {
        this.a = context;
        this.b = clock;
        this.c = clock2;
    }

    public CreationContext a(String str) {
        return CreationContext.create(this.a, this.b, this.c, str);
    }
}
