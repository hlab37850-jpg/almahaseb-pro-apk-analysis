package info.aalmoghalis.inventory.printservice;

import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.C3616p8;
import defpackage.OH;
import defpackage.SH;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.File;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends BaseActivity {
    public AlertDialog.Builder c;
    public BluetoothDevice d;
    public C3616p8 e;
    public ArrayAdapter f;
    public SQLiteDatabase j;
    public Z00 k;
    public boolean g = false;
    public String h = null;
    public Bitmap i = null;
    public final Handler l = new d();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity mainActivity = MainActivity.this;
            if (mainActivity.g) {
                mainActivity.z();
            } else {
                mainActivity.A();
                MainActivity.this.c.show();
            }
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                String str = (String) MainActivity.this.f.getItem(i);
                String strSubstring = str.substring(str.length() - 17);
                MainActivity mainActivity = MainActivity.this;
                mainActivity.d = mainActivity.e.m(strSubstring);
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.e.i(mainActivity2.d);
            } catch (Exception unused) {
            }
        }
    }

    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 6) {
                    return;
                }
                Log.d("BTService", "Unable to connect device");
            } else if (message.arg1 == 3) {
                MainActivity.this.z();
                MainActivity.this.g = true;
            }
        }
    }

    public void A() {
        this.f.clear();
        y();
        Set<BluetoothDevice> setN = this.e.n();
        if (setN.size() <= 0) {
            this.f.add("No printers");
            Toast.makeText(this, "No printers", 0).show();
            return;
        }
        for (BluetoothDevice bluetoothDevice : setN) {
            this.f.add(bluetoothDevice.getName() + StringUtilities.LF + bluetoothDevice.getAddress());
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.e = new C3616p8(this, this.l);
        this.k = new Z00(this.j, this);
        String stringExtra = getIntent().getStringExtra("FILE");
        this.h = stringExtra;
        if (stringExtra != null) {
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            Bitmap bitmapA = new SH(this.h).a();
            this.i = bitmapA;
            imageView.setImageBitmap(bitmapA);
            new File(this.h).delete();
            Bitmap bitmap = this.i;
            if (bitmap != null) {
                this.k.Wd(bitmap, "bill.jpg");
            }
        }
        this.f = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        y();
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
        Set<BluetoothDevice> setN = this.e.n();
        if (setN.size() <= 0) {
            this.f.add("No printers");
            Toast.makeText(this, "No printers", 0).show();
            return;
        }
        for (BluetoothDevice bluetoothDevice : setN) {
            this.f.add(bluetoothDevice.getName() + StringUtilities.LF + bluetoothDevice.getAddress());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C3616p8 c3616p8 = this.e;
        if (c3616p8 != null) {
            c3616p8.h();
        }
        this.e = null;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        this.c = builder;
        builder.setIcon(android.R.drawable.ic_btn_speak_now);
        this.c.setTitle("Select Printer:-");
        this.c.setNegativeButton("cancel", new b());
        this.c.setAdapter(this.f, new c());
    }

    public final void z() {
        OH oh = new OH();
        oh.b(384);
        oh.c();
        oh.e(0.0f, 0.0f, this.i);
        this.e.q(oh.d());
    }
}
