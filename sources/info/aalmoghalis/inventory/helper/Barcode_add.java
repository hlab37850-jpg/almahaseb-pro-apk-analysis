package info.aalmoghalis.inventory.helper;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import defpackage.AbstractC4371yX;
import defpackage.C0372Bn;
import defpackage.C1098Yv;
import defpackage.C4145vh;
import defpackage.W6;
import defpackage.Z00;
import info.aalmoghalis.inventory.lang.BaseActivity;
import info.aalmoghalis.inventory.printBT.MainActivity3;
import info.aalmoghalis.inventory.printBT.MainActivity4;

/* JADX INFO: loaded from: classes3.dex */
public class Barcode_add extends BaseActivity {
    public TextView c;
    public Button d;
    public Button e;
    public Button f;
    public Button g;
    public Button h;
    public SQLiteDatabase l;
    public Z00 n;
    public C1098Yv t;
    public AutoCompleteTextView i = null;
    public EditText j = null;
    public String k = "";
    public int p = 0;
    public int q = 0;
    public int u = 4;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Barcode_add.this.B();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Barcode_add.this.C();
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ TextView b;

        public d(ArrayAdapter arrayAdapter, TextView textView) {
            this.a = arrayAdapter;
            this.b = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Barcode_add.this.x(this.a, this.b);
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ EditText d;
        public final /* synthetic */ EditText e;
        public final /* synthetic */ SwitchCompat f;
        public final /* synthetic */ SwitchCompat g;
        public final /* synthetic */ SwitchCompat h;
        public final /* synthetic */ SwitchCompat i;
        public final /* synthetic */ AlertDialog j;

        public g(EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, SwitchCompat switchCompat, SwitchCompat switchCompat2, SwitchCompat switchCompat3, SwitchCompat switchCompat4, AlertDialog alertDialog) {
            this.a = editText;
            this.b = editText2;
            this.c = editText3;
            this.d = editText4;
            this.e = editText5;
            this.f = switchCompat;
            this.g = switchCompat2;
            this.h = switchCompat3;
            this.i = switchCompat4;
            this.j = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.c)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.d)) {
                zA = false;
            }
            if (!AbstractC4371yX.a(this.e)) {
                zA = false;
            }
            if (zA) {
                Barcode_add.this.n.Lc("item_barcode_img_h2", this.a.getText().toString());
                Barcode_add.this.n.Lc("item_barcode_img_w2", this.b.getText().toString());
                Barcode_add.this.n.Lc("item_barcode_col_cnt2", this.c.getText().toString());
                Barcode_add.this.n.Lc("item_barcode_img_cnt2", this.d.getText().toString());
                Barcode_add.this.n.Lc("item_barcode_img_m2", this.e.getText().toString());
                Barcode_add.this.n.Mc("item_price_status", this.f.isChecked());
                Barcode_add.this.n.Mc("item_unit_status", this.g.isChecked());
                Barcode_add.this.n.Mc("name_status", this.h.isChecked());
                Barcode_add.this.n.Mc("hide_barcode2", this.i.isChecked());
                this.j.dismiss();
                Barcode_add barcode_add = Barcode_add.this;
                String strX6 = barcode_add.n.X6(barcode_add.i.getText().toString());
                String strL3 = Barcode_add.this.n.l3("0");
                Barcode_add.this.n.g3(strL3);
                Barcode_add barcode_add2 = Barcode_add.this;
                double dJ6 = barcode_add2.n.J6(barcode_add2.i.getText().toString(), strL3, 1, false, "0", 1, strX6);
                if (dJ6 != 0.0d && dJ6 != -1.0d) {
                    Barcode_add.this.n.P7(dJ6 + "");
                }
                this.g.isChecked();
                Intent intent = new Intent(Barcode_add.this, (Class<?>) (Barcode_add.this.n.ja("prefThermalBluetooth", true) ? MainActivity3.class : MainActivity4.class));
                intent.putExtra("item_name", Barcode_add.this.i.getText().toString() + "");
                intent.putExtra("item_barcode", Barcode_add.this.j.getText().toString() + "");
                intent.putExtra("img_h", this.a.getText().toString() + "");
                intent.putExtra("img_w", this.b.getText().toString() + "");
                intent.putExtra("col_cnt", this.c.getText().toString() + "");
                intent.putExtra("img_cnt", this.d.getText().toString() + "");
                intent.putExtra("img_m2", this.e.getText().toString() + "");
                intent.putExtra("item_price_status", this.f.isChecked());
                intent.putExtra("item_unit_status", this.g.isChecked());
                intent.putExtra("name_status", this.h.isChecked());
                Z00.j0.clear();
                int i = Barcode_add.this.n.ia("prefThermalType", "1").equals("10") ? 1 : Integer.parseInt(Barcode_add.this.n.ia("item_barcode_img_cnt2", "4")) / Integer.parseInt(Barcode_add.this.n.ia("item_barcode_col_cnt2", "1"));
                for (int i2 = 0; i2 < i; i2++) {
                    Z00.j0.add(new String[]{Barcode_add.this.i.getText().toString(), ""});
                }
                Barcode_add.this.startActivity(intent);
            }
        }
    }

    public class h implements AdapterView.OnItemClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            C4145vh c4145vh = (C4145vh) adapterView.getItemAtPosition(i);
            Barcode_add.this.i.setText(c4145vh.a());
            Barcode_add.this.j.requestFocus();
            String strX6 = Barcode_add.this.n.x6(c4145vh.n());
            Log.d("barcode=", strX6 + "");
            Barcode_add.this.j.setText(strX6);
            if (Barcode_add.this.j.getText().toString().length() > 0) {
                Barcode_add barcode_add = Barcode_add.this;
                barcode_add.z(barcode_add.j.getText().toString());
            }
        }
    }

    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Barcode_add.this.i.showDropDown();
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getX() <= (Barcode_add.this.i.getCompoundDrawables()[0] != null ? Barcode_add.this.i.getCompoundDrawables()[0].getBounds().width() : 0) + Barcode_add.this.i.getPaddingLeft() + Barcode_add.this.i.getLeft()) {
                    Barcode_add.this.i.setText("");
                    Barcode_add.this.j.setText("");
                    Barcode_add.this.i.requestFocus();
                    return false;
                }
                motionEvent.getX();
                Barcode_add.this.i.getRight();
                Barcode_add.this.i.getPaddingRight();
                if (Barcode_add.this.i.getCompoundDrawables()[2] != null) {
                    Barcode_add.this.i.getCompoundDrawables()[2].getBounds().width();
                }
            }
            return false;
        }
    }

    public class j implements TextWatcher {
        public j() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() > 0) {
                Barcode_add barcode_add = Barcode_add.this;
                barcode_add.i.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(barcode_add, R.drawable.ic_notification_clear_all), (Drawable) null, Barcode_add.this.i.getCompoundDrawables()[2], (Drawable) null);
            } else {
                AutoCompleteTextView autoCompleteTextView = Barcode_add.this.i;
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, autoCompleteTextView.getCompoundDrawables()[2], (Drawable) null);
            }
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Barcode_add.this.n.ia("pref_barcode_type", "1").equals("1")) {
                Barcode_add barcode_add = Barcode_add.this;
                barcode_add.n.Td(barcode_add);
            } else {
                Barcode_add barcode_add2 = Barcode_add.this;
                Toast.makeText(barcode_add2, barcode_add2.getString(info.aalmoghalis.inventory.R.string.usb_barcode), 0).show();
                Barcode_add.this.i.requestFocus();
            }
        }
    }

    public class l implements View.OnKeyListener {
        public final /* synthetic */ EditText a;

        public l(EditText editText) {
            this.a = editText;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            return Barcode_add.this.y(keyEvent, this.a);
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ String a;

        public m(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Barcode_add.this.D(this.a);
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Barcode_add.this.j.getText().toString().length() > 0) {
                Barcode_add barcode_add = Barcode_add.this;
                String strI6 = barcode_add.n.I6(barcode_add.j.getText().toString());
                if (!strI6.equals("") && !strI6.equals(Barcode_add.this.i.getText().toString())) {
                    Toast.makeText(Barcode_add.this, Barcode_add.this.getString(info.aalmoghalis.inventory.R.string.barcode_used) + " " + strI6, 1).show();
                    return;
                }
                Barcode_add.this.n.v0("update items set barcode='" + Barcode_add.this.j.getText().toString() + "' where name='" + Barcode_add.this.i.getText().toString() + "'");
                Toast.makeText(Barcode_add.this.getApplicationContext(), Barcode_add.this.getString(info.aalmoghalis.inventory.R.string.barcode_saved), 0).show();
                Barcode_add barcode_add2 = Barcode_add.this;
                barcode_add2.z(barcode_add2.j.getText().toString());
            }
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Barcode_add barcode_add = Barcode_add.this;
            barcode_add.j.setText(barcode_add.n.R1());
            if (Barcode_add.this.j.getText().toString().length() > 0) {
                Barcode_add.this.n.v0("update items set barcode='" + Barcode_add.this.j.getText().toString() + "' where name='" + Barcode_add.this.i.getText().toString() + "'");
                Toast.makeText(Barcode_add.this.getApplicationContext(), Barcode_add.this.getString(info.aalmoghalis.inventory.R.string.barcode_saved), 0).show();
                Barcode_add barcode_add2 = Barcode_add.this;
                barcode_add2.z(barcode_add2.j.getText().toString());
            }
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Barcode_add.this.finish();
        }
    }

    public class q implements AdapterView.OnItemClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ Dialog b;

        public q(TextView textView, Dialog dialog) {
            this.a = textView;
            this.b = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.a.setText(adapterView.getItemAtPosition(i).toString());
            this.a.setTag(adapterView.getItemAtPosition(i).toString());
            Z00 z00 = Barcode_add.this.n;
            z00.Lc("item_barcode_curr_id", z00.i3(adapterView.getItemAtPosition(i).toString()));
            this.b.dismiss();
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ ArrayAdapter a;
        public final /* synthetic */ TextView b;

        public r(ArrayAdapter arrayAdapter, TextView textView) {
            this.a = arrayAdapter;
            this.b = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Barcode_add.this.x(this.a, this.b);
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class t implements DialogInterface.OnClickListener {
        public t() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class u implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ SwitchCompat c;
        public final /* synthetic */ SwitchCompat d;
        public final /* synthetic */ SwitchCompat e;
        public final /* synthetic */ AlertDialog f;
        public final /* synthetic */ TextView g;
        public final /* synthetic */ TextView h;

        public u(EditText editText, EditText editText2, SwitchCompat switchCompat, SwitchCompat switchCompat2, SwitchCompat switchCompat3, AlertDialog alertDialog, TextView textView, TextView textView2) {
            this.a = editText;
            this.b = editText2;
            this.c = switchCompat;
            this.d = switchCompat2;
            this.e = switchCompat3;
            this.f = alertDialog;
            this.g = textView;
            this.h = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            boolean zA = AbstractC4371yX.a(this.a);
            if (!AbstractC4371yX.a(this.b)) {
                zA = false;
            }
            if (zA) {
                Barcode_add.this.n.Lc("item_barcode_img_cnt", this.a.getText().toString());
                Barcode_add.this.n.Lc("item_barcode_col_cnt", this.b.getText().toString());
                Barcode_add.this.n.Mc("item_price_status", this.c.isChecked());
                Barcode_add.this.n.Mc("item_unit_status", this.d.isChecked());
                Barcode_add.this.n.Mc("name_status", this.e.isChecked());
                this.f.dismiss();
                Barcode_add barcode_add = Barcode_add.this;
                String strX6 = barcode_add.n.X6(barcode_add.i.getText().toString());
                String string2 = this.g.getText().toString();
                String strG3 = Barcode_add.this.n.g3(string2);
                Barcode_add barcode_add2 = Barcode_add.this;
                double dJ6 = barcode_add2.n.J6(barcode_add2.i.getText().toString(), string2, 1, false, "0", 1, strX6);
                String str = "";
                if (dJ6 == 0.0d || dJ6 == -1.0d) {
                    string = "";
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Barcode_add.this.n.P7(dJ6 + ""));
                    sb.append(" ");
                    sb.append(strG3);
                    string = sb.toString();
                }
                if (this.d.isChecked()) {
                    str = strX6 + " ";
                }
                Barcode_add barcode_add3 = Barcode_add.this;
                Z00 z00 = barcode_add3.n;
                z00.qb(z00.ic(barcode_add3.i.getText().toString()), Barcode_add.this.j.getText().toString(), Barcode_add.this.i.getText().toString(), Integer.parseInt(this.a.getText().toString()), Integer.parseInt(this.b.getText().toString()), string, this.c.isChecked(), str, this.h.getText().toString(), this.e.isChecked());
                Z00 z01 = Barcode_add.this.n;
                StringBuilder sb2 = new StringBuilder();
                Barcode_add barcode_add4 = Barcode_add.this;
                sb2.append(barcode_add4.n.ic(barcode_add4.i.getText().toString()));
                sb2.append(".pdf");
                z01.ra(sb2.toString());
            }
        }
    }

    public void A() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_barcode_print_type, (ViewGroup) null);
            builder.setView(viewInflate);
            Button button = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.print_a4);
            Button button2 = (Button) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.print_thermal);
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new a());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.print_barcode));
            alertDialogCreate.show();
            button.setOnClickListener(new b());
            button2.setOnClickListener(new c());
        } catch (Exception unused) {
        }
    }

    public void B() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_barcode_item_print, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_barcode_img_cnt);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_barcode_col_cnt);
            SwitchCompat switchCompat = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
            SwitchCompat switchCompat2 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat2);
            SwitchCompat switchCompat3 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat3);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_name);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.name_hdr);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
            Z00 z00 = this.n;
            textView2.setText(z00.l3(z00.ia("item_barcode_curr_id", "0")));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, this.n.s3());
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            textView2.setOnClickListener(new r(arrayAdapter, textView2));
            textView.setText(this.n.ia("prefUsername", ""));
            if (this.n.ia("prefUsername", "").equals("")) {
                linearLayout.setVisibility(8);
                this.n.Mc("name_status", false);
            }
            int i2 = Integer.parseInt(this.n.ia("item_barcode_img_cnt", "40"));
            int i3 = Integer.parseInt(this.n.ia("item_barcode_col_cnt", "4"));
            boolean zJa = this.n.ja("item_price_status", false);
            boolean zJa2 = this.n.ja("item_unit_status", false);
            boolean zJa3 = this.n.ja("name_status", false);
            switchCompat.setChecked(zJa);
            switchCompat2.setChecked(zJa2);
            switchCompat3.setChecked(zJa3);
            this.n.nd(editText, i2 + "");
            this.n.nd(editText2, i3 + "");
            editText.selectAll();
            editText2.selectAll();
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.print), new s());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new t());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.print_barcode));
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new u(editText, editText2, switchCompat, switchCompat2, switchCompat3, alertDialogCreate, textView2, textView));
        } catch (Exception unused) {
        }
    }

    public void C() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.content_barcode_item_print2, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_barcode_img_h);
            EditText editText2 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_barcode_img_w);
            EditText editText3 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_barcode_col_cnt);
            EditText editText4 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_barcode_img_cnt);
            EditText editText5 = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.item_barcode_margin_h);
            SwitchCompat switchCompat = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat);
            SwitchCompat switchCompat2 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat2);
            SwitchCompat switchCompat3 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat3);
            SwitchCompat switchCompat4 = (SwitchCompat) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.switch_compat4);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.ll_name);
            TextView textView = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.name_hdr);
            TextView textView2 = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.tv_curr);
            Z00 z00 = this.n;
            textView2.setText(z00.l3(z00.ia("item_barcode_curr_id", "0")));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, this.n.s3());
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            textView2.setOnClickListener(new d(arrayAdapter, textView2));
            textView.setText(this.n.ia("prefUsername", ""));
            if (this.n.ia("prefUsername", "").equals("")) {
                linearLayout.setVisibility(8);
                this.n.Mc("name_status", false);
            }
            int i2 = Integer.parseInt(this.n.ia("item_barcode_img_h2", "20"));
            int i3 = Integer.parseInt(this.n.ia("item_barcode_img_w2", "38"));
            int i4 = Integer.parseInt(this.n.ia("item_barcode_col_cnt2", "1"));
            int i5 = Integer.parseInt(this.n.ia("item_barcode_img_cnt2", "4"));
            int i6 = Integer.parseInt(this.n.ia("item_barcode_img_m2", "2"));
            boolean zJa = this.n.ja("item_price_status", false);
            boolean zJa2 = this.n.ja("item_unit_status", false);
            boolean zJa3 = this.n.ja("name_status", false);
            boolean zJa4 = this.n.ja("hide_barcode2", false);
            switchCompat.setChecked(zJa);
            switchCompat2.setChecked(zJa2);
            switchCompat3.setChecked(zJa3);
            switchCompat4.setChecked(zJa4);
            this.n.nd(editText, i2 + "");
            this.n.nd(editText2, i3 + "");
            this.n.nd(editText3, i4 + "");
            this.n.nd(editText4, i5 + "");
            this.n.nd(editText5, i6 + "");
            editText.selectAll();
            editText2.selectAll();
            editText3.selectAll();
            editText4.selectAll();
            editText5.selectAll();
            builder.setPositiveButton(getString(info.aalmoghalis.inventory.R.string.print), new e());
            builder.setNegativeButton(getString(info.aalmoghalis.inventory.R.string.resourceID_Cancel), new f());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setTitle(getString(info.aalmoghalis.inventory.R.string.print_barcode));
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new g(editText, editText2, editText3, editText4, editText5, switchCompat, switchCompat2, switchCompat3, switchCompat4, alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public void D(String str) {
        if (str.equals("")) {
            return;
        }
        this.c.setText(str);
        this.j.setText(this.c.getText().toString());
        String strI6 = this.n.I6(str);
        if (!strI6.equals("")) {
            Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.barcode_used) + " " + strI6, 1).show();
            return;
        }
        this.n.v0("update items set barcode='" + this.c.getText().toString() + "' where name='" + this.i.getText().toString() + "'");
        Context applicationContext = getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(info.aalmoghalis.inventory.R.string.barcode_saved));
        sb.append(" ");
        sb.append(this.c.getText().toString());
        Toast.makeText(applicationContext, sb.toString(), 0).show();
        this.c.setText("");
        z(this.j.getText().toString());
    }

    public void E() {
        C1098Yv c1098Yv = new C1098Yv(this, info.aalmoghalis.inventory.R.layout.data_det_row_search, this.n.G6(), 4);
        this.t = c1098Yv;
        c1098Yv.l.clear();
        this.t.notifyDataSetChanged();
        this.i.setThreshold(1);
        this.i.setAdapter(this.t);
        this.i.setOnItemClickListener(new h());
        this.i.setOnTouchListener(new i());
        this.i.addTextChangedListener(new j());
    }

    public void btn_print(View view) {
        if (this.j.getText().toString().length() > 0) {
            String strI6 = this.n.I6(this.j.getText().toString());
            if (!strI6.equals(this.i.getText().toString()) && !strI6.equals("")) {
                Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.barcode_used) + " " + strI6, 1).show();
                return;
            }
            this.n.v0("update items set barcode='" + this.j.getText().toString() + "' where name='" + this.i.getText().toString() + "'");
            z(this.j.getText().toString());
            A();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Log.d("excel_log:requestCode=", "" + i2 + ":" + i3 + ":");
        try {
            IntentResult activityResult = IntentIntegrator.parseActivityResult(i2, i3, intent);
            if (activityResult == null) {
                super.onActivityResult(i2, i3, intent);
            } else if (activityResult.getContents() == null) {
                Toast.makeText(this, "Cancelled", 1).show();
            } else {
                this.c.setText(activityResult.getContents());
                this.j.setText(this.c.getText().toString());
                String strI6 = this.n.I6(activityResult.getContents());
                if (strI6.equals("")) {
                    this.n.v0("update items set barcode='" + this.c.getText().toString() + "' where name='" + this.i.getText().toString() + "'");
                    Context applicationContext = getApplicationContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(getString(info.aalmoghalis.inventory.R.string.barcode_saved));
                    sb.append(" ");
                    sb.append(this.c.getText().toString());
                    Toast.makeText(applicationContext, sb.toString(), 0).show();
                    this.c.setText("");
                    z(this.j.getText().toString());
                } else {
                    Toast.makeText(this, getString(info.aalmoghalis.inventory.R.string.barcode_used) + " " + strI6, 1).show();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("barcode_log_error=", "results=" + e2.getMessage());
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(info.aalmoghalis.inventory.R.layout.activity_barcode_add);
        this.n = new Z00(this.l, this);
        this.d = (Button) findViewById(info.aalmoghalis.inventory.R.id.browse);
        this.e = (Button) findViewById(info.aalmoghalis.inventory.R.id.save);
        this.f = (Button) findViewById(info.aalmoghalis.inventory.R.id.close);
        this.g = (Button) findViewById(info.aalmoghalis.inventory.R.id.print);
        this.h = (Button) findViewById(info.aalmoghalis.inventory.R.id.new_barcode);
        this.i = (AutoCompleteTextView) findViewById(info.aalmoghalis.inventory.R.id.item_name);
        this.j = (EditText) findViewById(info.aalmoghalis.inventory.R.id.item_barcode);
        this.c = (TextView) findViewById(info.aalmoghalis.inventory.R.id.txtBarcodeValue);
        this.n.ad(this, this.j);
        w(this.j);
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.d);
        c0372Bn.a(this, this.e);
        c0372Bn.a(this, this.f);
        E();
        if (getIntent().getStringExtra("item_name") != null && getIntent().getStringExtra("item_barcode") != null) {
            this.i.setText(getIntent().getStringExtra("item_name"));
            this.j.setText(getIntent().getStringExtra("item_barcode"));
            this.j.requestFocus();
            if (this.j.getText().toString().length() > 0) {
                z(this.j.getText().toString());
            } else {
                this.h.setVisibility(0);
            }
        }
        this.d.setOnClickListener(new k());
        this.e.setOnClickListener(new n());
        this.h.setOnClickListener(new o());
        this.f.setOnClickListener(new p());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
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
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void w(EditText editText) {
        editText.setOnKeyListener(new l(editText));
    }

    public void x(ArrayAdapter arrayAdapter, TextView textView) {
        Dialog dialog = new Dialog(this);
        LinearLayout linearLayout = new LinearLayout(this);
        ListView listView = new ListView(this);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new q(textView, dialog));
        linearLayout.setFocusable(true);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        linearLayout.addView(listView, -1, -1);
        dialog.setContentView(linearLayout);
        dialog.show();
    }

    public boolean y(KeyEvent keyEvent, EditText editText) {
        if (keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 66) {
            return false;
        }
        new Handler().postDelayed(new m(editText.getText().toString()), 200);
        return true;
    }

    public Bitmap z(String str) {
        try {
            this.h.setVisibility(8);
            W6 w6 = new W6();
            ImageView imageView = (ImageView) findViewById(info.aalmoghalis.inventory.R.id.barcode_img);
            Bitmap bitmapC = w6.c(str, BarcodeFormat.CODE_128, 400, 300);
            imageView.setImageBitmap(bitmapC);
            return bitmapC;
        } catch (Exception unused) {
            return null;
        }
    }
}
