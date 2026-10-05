package info.aalmoghalis.inventory.printservice;

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AppCompatPreferenceActivity extends PreferenceActivity {
    public AppCompatDelegate a;

    public final AppCompatDelegate a() {
        if (this.a == null) {
            this.a = AppCompatDelegate.create(this, (AppCompatCallback) null);
        }
        return this.a;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().addContentView(view, layoutParams);
    }

    public ActionBar b() {
        return a().getSupportActionBar();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return a().getMenuInflater();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        a().invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a().onConfigurationChanged(configuration);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        a().installViewFactory();
        a().onCreate(bundle);
        super.onCreate(bundle);
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a().onDestroy();
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        a().onPostCreate(bundle);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        a().onPostResume();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        a().onStop();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        a().setTitle(charSequence);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        a().setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        a().setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().setContentView(view, layoutParams);
    }
}
