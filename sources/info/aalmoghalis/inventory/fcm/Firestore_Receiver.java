package info.aalmoghalis.inventory.fcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import defpackage.Q00;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;

/* JADX INFO: loaded from: classes3.dex */
public class Firestore_Receiver extends BroadcastReceiver {
    public Context a;
    public Z00 b;
    public SQLiteDatabase c;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Q00.T(Firestore_Receiver.this.b);
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (!Firestore_Receiver.this.b.ja("online_client", false) && !Firestore_Receiver.this.b.ja("online_server", false)) {
                Firestore_Receiver firestore_Receiver = Firestore_Receiver.this;
                firestore_Receiver.b.Kd(firestore_Receiver.a, "C:" + this.a + ":" + Firestore_Receiver.this.a.getString(R.string.online_info), 5000);
            }
            Firestore_Receiver.this.b.Mc("online_client", true);
            Firestore_Receiver.this.b.Mc("online_client_confirm", true);
            Firestore_Receiver.this.b.Lc("online_client_confirm_un", this.b);
            Firestore_Receiver.this.b.Lc("online_user", (this.a + "").replace("@gmail.com", ""));
            Q00.T(Firestore_Receiver.this.b);
            Firestore_Receiver.this.b.m0();
            dialogInterface.dismiss();
        }
    }

    public void a(String str, String str2) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setCancelable(true);
            builder.setMessage(this.a.getString(R.string.online_client_confirm) + " " + str + " ?");
            builder.setNegativeButton(this.a.getText(R.string.confirm_no), new a());
            builder.setPositiveButton(this.a.getText(R.string.confirm_yes), new b(str, str2));
            builder.create().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d(Q00.H, "show_alert_confirm:Firestore_Receiver");
        this.a = context;
        this.b = new Z00(this.c, context);
        a(intent.getStringExtra("email_"), intent.getStringExtra("un_"));
    }
}
