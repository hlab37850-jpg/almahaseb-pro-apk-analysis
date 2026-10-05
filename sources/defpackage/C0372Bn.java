package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/* JADX INFO: renamed from: Bn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0372Bn {
    public static final C0372Bn c = new C0372Bn("fonts/GE_SS_TEXT_LIGHT.ttf");
    public static final C0372Bn d = new C0372Bn("fonts/GE_SS_TWO_MEDIUM.ttf");
    public static final C0372Bn e = new C0372Bn("fonts/GE_SS_TWO_MEDIUM.ttf");
    public static final C0372Bn f = new C0372Bn("fonts/GE_SS_TEXT_LIGHT.ttf");
    public static final C0372Bn g = new C0372Bn("fonts/Tahoma.ttf");
    public final String a;
    public volatile Typeface b;

    public C0372Bn(String str) {
        this.a = str;
    }

    public void a(Context context, TextView textView) {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = Typeface.createFromAsset(context.getAssets(), this.a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        textView.setTypeface(this.b);
    }
}
