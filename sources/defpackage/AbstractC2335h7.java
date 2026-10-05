package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: renamed from: h7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2335h7 {
    public static int a;

    public static void b(Context context, View view, final boolean z, final boolean z2) {
        if (view != null && Build.VERSION.SDK_INT >= 35) {
            ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: g7
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    return AbstractC2335h7.c(z, z2, view2, windowInsetsCompat);
                }
            });
        }
    }

    public static /* synthetic */ WindowInsetsCompat c(boolean z, boolean z2, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.systemGestures() | WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.captionBar() | WindowInsetsCompat.Type.displayCutout());
        Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
        Log.d("padding_inset=", "f=" + a + ":" + insets.top + ":" + windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars()).top);
        int i = insets.top;
        if (i != 0 && a == 0) {
            a = i;
        }
        view.setPadding(view.getPaddingLeft(), z ? a : view.getPaddingTop(), view.getPaddingRight(), z2 ? insets.bottom : view.getPaddingBottom());
        Log.d("padding_inset=", "t=" + insets.top + ":" + view.getPaddingTop() + ":" + a + ":b=" + insets.bottom);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), Math.max(insets.bottom, insets2.bottom));
        return WindowInsetsCompat.CONSUMED;
    }
}
