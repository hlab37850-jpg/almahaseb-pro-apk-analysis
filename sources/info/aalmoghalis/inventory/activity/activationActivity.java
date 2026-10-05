package info.aalmoghalis.inventory.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import defpackage.C1193a2;
import defpackage.C3966tX;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;

/* JADX INFO: loaded from: classes3.dex */
public class activationActivity extends BaseActivity {
    public static boolean f = false;
    public C1193a2 c;
    public Z00 d;
    public SQLiteDatabase e;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            activationActivity.this.finish();
            return true;
        }
    }

    private void w() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1193a2 c1193a2C = C1193a2.c(getLayoutInflater());
        this.c = c1193a2C;
        setContentView(c1193a2C.getRoot());
        w();
        Z00 z00 = new Z00(this.e, this);
        this.d = z00;
        try {
            if (z00.ja("black_list", false)) {
                this.d.Lc("black_date", "");
                this.d.Lc("black_date_done", "");
                this.d.F0(this);
            }
            C3966tX.e(this);
            this.d.qe(this, this);
            f = true;
        } catch (Exception e) {
            Log.d("adv_search_error=", e.getMessage());
        }
        this.c.getRoot().setOnTouchListener(new a());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_setting, menu);
        menu.findItem(R.id.activation).setVisible(false);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
