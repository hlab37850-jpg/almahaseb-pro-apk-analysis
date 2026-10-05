package info.aalmoghalis.inventory.lang;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import defpackage.AbstractC2335h7;
import defpackage.C2160f10;
import defpackage.MO;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class BaseActivity extends AppCompatActivity {
    public static boolean b = false;
    public Locale a;

    public static Locale v(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        context.getResources().getConfiguration();
        String string = defaultSharedPreferences.getString("prefLanguage", "Arabic");
        string.hashCode();
        if (string.equals("English")) {
            string = "fa";
        } else if (string.equals("Arabic")) {
            string = "en";
        }
        return new Locale(string);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 35) {
            EdgeToEdge.enable(this);
        }
        C2160f10.h = MO.b(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        u();
        AbstractC2335h7.b(this, getWindow().getDecorView(), true, true);
        b = false;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        Locale localeV = v(this);
        if (localeV.equals(this.a)) {
            return;
        }
        this.a = localeV;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.a = getResources().getConfiguration().locale;
    }

    public void u() {
        if (Build.VERSION.SDK_INT >= 35) {
            Window window = getWindow();
            WindowCompat.setDecorFitsSystemWindows(window, false);
            WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
            window.setStatusBarColor(0);
            if (insetsController != null) {
                insetsController.setAppearanceLightStatusBars(true);
                insetsController.setAppearanceLightNavigationBars(true);
            }
        }
    }
}
