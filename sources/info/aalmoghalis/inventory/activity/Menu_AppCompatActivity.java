package info.aalmoghalis.inventory.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import defpackage.C3874sM;
import defpackage.C4062ug;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Menu_AppCompatActivity extends BaseActivity {
    public String[] c;
    public TypedArray d;
    public List e;
    public C4062ug f;
    public final Context g = this;

    public class a implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public a(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            Log.d("tran_type_pos=", String.valueOf(i));
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (i == 0 || i == 1) {
                Intent intent = new Intent(Menu_AppCompatActivity.this.g, (Class<?>) Bill_edit.class);
                intent.putExtra("TR_TYPE", String.valueOf(i + 1));
                Menu_AppCompatActivity.this.startActivity(intent);
            } else if (i != 2) {
                if (i == 3) {
                    Intent intent2 = new Intent(Menu_AppCompatActivity.this.g, (Class<?>) Info_edit2.class);
                    intent2.putExtra("action_type", i);
                    intent2.putExtra("action_text", textView.getText().toString());
                    Menu_AppCompatActivity.this.startActivity(intent2);
                } else if (i != 4 && i == 5) {
                    Intent intent3 = new Intent(Menu_AppCompatActivity.this.g, (Class<?>) Bill_edit.class);
                    intent3.putExtra("TR_TYPE", String.valueOf(1));
                    intent3.putExtra("broken_type_id", "1");
                    intent3.putExtra("item_status_id", "1");
                    Menu_AppCompatActivity.this.startActivity(intent3);
                }
            }
            this.a.dismiss();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.add) {
            w();
            return true;
        }
        if (menuItem.getItemId() == R.id.bills) {
            Intent intent = new Intent(this, (Class<?>) Bills2.class);
            intent.putExtra("TR_TYPE", "1");
            startActivity(intent);
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.bills2) {
            Intent intent2 = new Intent(this, (Class<?>) Bills2.class);
            intent2.putExtra("TR_TYPE", "2");
            startActivity(intent2);
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.expenses) {
            startActivity(new Intent(this, (Class<?>) Expenses.class));
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.report1) {
            startActivity(new Intent(this, (Class<?>) Report8_item_movement.class));
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.report2) {
            startActivity(new Intent(this, (Class<?>) Report2_supp_balance.class));
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.report3) {
            startActivity(new Intent(this, (Class<?>) Report3_expense_balance.class));
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.report4) {
            Intent intent3 = new Intent(this, (Class<?>) Report4_purchases.class);
            intent3.putExtra("TR_TYPE", "2");
            startActivity(intent3);
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.report5) {
            Intent intent4 = new Intent(this, (Class<?>) Report4_purchases.class);
            intent4.putExtra("TR_TYPE", "1");
            startActivity(intent4);
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.report6) {
            Intent intent5 = new Intent(this, (Class<?>) Report6_expenses.class);
            intent5.putExtra("TR_TYPE", "3");
            startActivity(intent5);
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.report7) {
            startActivity(new Intent(this, (Class<?>) Report7_profit_loss.class));
            finish();
            return true;
        }
        if (menuItem.getItemId() == 16908332) {
            Log.d("Back icon=", "Yes");
            onBackPressed();
        }
        return true;
    }

    public void w() {
        Dialog dialog = new Dialog(this.g);
        LinearLayout linearLayout = new LinearLayout(this);
        this.c = getResources().getStringArray(R.array.titles3);
        this.d = getResources().obtainTypedArray(R.array.icons3);
        ListView listView = new ListView(this);
        this.e = new ArrayList();
        int i = 0;
        while (true) {
            String[] strArr = this.c;
            if (i >= strArr.length) {
                this.d.recycle();
                C4062ug c4062ug = new C4062ug(getApplicationContext(), this.e);
                this.f = c4062ug;
                listView.setAdapter((ListAdapter) c4062ug);
                listView.setOnItemClickListener(new a(dialog));
                linearLayout.setFocusable(true);
                listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                listView.setDividerHeight(0);
                linearLayout.addView(listView, -1, -1);
                dialog.requestWindowFeature(1);
                dialog.setContentView(linearLayout);
                dialog.show();
                return;
            }
            this.e.add(new C3874sM(strArr[i], this.d.getResourceId(i, -1)));
            i++;
        }
    }

    public void x(int i, String str) {
        if (i == 0 || i == 1) {
            Intent intent = new Intent(this, (Class<?>) Bill_edit.class);
            intent.putExtra("TR_TYPE", String.valueOf(i + 1));
            intent.putExtra("title", str);
            startActivity(intent);
            return;
        }
        if (i == 2) {
            Intent intent2 = new Intent(this, (Class<?>) Bill_move.class);
            intent2.putExtra("TR_TYPE", String.valueOf(i + 1));
            intent2.putExtra("title", str);
            startActivity(intent2);
            return;
        }
        if (i == 3) {
            Intent intent3 = new Intent(this.g, (Class<?>) Info_edit2.class);
            intent3.putExtra("action_type", 1);
            intent3.putExtra("action_text", str);
            startActivity(intent3);
            return;
        }
        if (i != 4 && i == 5) {
            Intent intent4 = new Intent(this.g, (Class<?>) Bill_edit.class);
            intent4.putExtra("TR_TYPE", String.valueOf(1));
            intent4.putExtra("broken_type_id", "1");
            intent4.putExtra("item_status_id", "1");
            startActivity(intent4);
        }
    }

    public void y() {
        startActivity(new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class));
        finish();
    }
}
