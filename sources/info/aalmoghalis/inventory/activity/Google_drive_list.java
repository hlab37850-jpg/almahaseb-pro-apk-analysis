package info.aalmoghalis.inventory.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0573Hk;
import defpackage.AbstractC2242g10;
import defpackage.C0870Qv;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.C4143vg;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class Google_drive_list extends BaseActivity implements AbstractC0573Hk.c {
    public static final String[] E = {"https://www.googleapis.com/auth/drive"};
    public static final String[] F = {"https://www.googleapis.com/auth/drive.file"};
    public SQLiteDatabase C;
    public Z00 D;
    public GoogleAccountCredential c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public ProgressDialog q;
    public C0870Qv u;
    public SparseBooleanArray x;
    public boolean y;
    public String g = null;
    public String h = null;
    public String i = "DAFTAR";
    public String j = "";
    public String k = "";
    public String l = "";
    public String n = "";
    public String p = "";
    public ListView t = null;
    public List v = new ArrayList();
    public String w = "";
    public int z = 0;
    public String A = null;
    public ArrayList B = new ArrayList();

    public class a implements AbsListView.MultiChoiceModeListener {

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Google_drive_list$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0294a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0294a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    Google_drive_list.this.P();
                } catch (Exception unused) {
                }
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() != R.id.menu_delete) {
                return false;
            }
            SparseBooleanArray sparseBooleanArrayC = Google_drive_list.this.u.c();
            Google_drive_list google_drive_list = Google_drive_list.this;
            google_drive_list.x = sparseBooleanArrayC;
            AlertDialog.Builder builder = new AlertDialog.Builder(google_drive_list);
            builder.setMessage(Google_drive_list.this.getString(R.string.delete_msg));
            builder.setPositiveButton(Google_drive_list.this.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0294a());
            builder.setNegativeButton(Google_drive_list.this.getString(R.string.confirm_no), new b());
            builder.create().show();
            actionMode.finish();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_action_bar_del, menu);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            Log.d("Back_=", "BACK#2");
            Google_drive_list.this.t.setBackgroundColor(Color.parseColor("#FFFFFF"));
            Google_drive_list.this.u.i.clear();
            Google_drive_list.this.u.e();
        }

        @Override // android.widget.AbsListView.MultiChoiceModeListener
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
            int checkedItemCount = Google_drive_list.this.t.getCheckedItemCount();
            actionMode.invalidate();
            actionMode.setTitle(checkedItemCount + " Selected");
            Google_drive_list.this.u.g(i);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                if ((C2160f10.h > 0 && !new C2160f10(Google_drive_list.this.D).l("-5", "view")) || Google_drive_list.this.D.S()) {
                    Google_drive_list google_drive_list = Google_drive_list.this;
                    Toast.makeText(google_drive_list, google_drive_list.getString(R.string.no_priv), 0).show();
                    return;
                }
                String string = ((TextView) view.findViewById(R.id.file_id)).getText().toString();
                String string2 = ((TextView) view.findViewById(R.id.title)).getText().toString();
                Google_drive_list google_drive_list2 = Google_drive_list.this;
                google_drive_list2.h = string;
                google_drive_list2.g = string2;
                google_drive_list2.Q();
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ Context b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Google_drive_list.this.I();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Google_drive_list.this.I();
            }
        }

        /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.Google_drive_list$c$c, reason: collision with other inner class name */
        public class RunnableC0295c implements Runnable {
            public RunnableC0295c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Google_drive_list.this.I();
            }
        }

        public c(Handler handler, Context context) {
            this.a = handler;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Google_drive_list.this.c.getToken();
                this.a.post(new a());
            } catch (UserRecoverableAuthException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("check_Scopes:UserRecoverableAuthException:");
                sb.append(e.getCause() != null ? e.getCause().getMessage() : "");
                Log.d("trace_drive=", sb.toString());
                Google_drive_list.this.D.Lc("drive_error", "0");
                Google_drive_list.this.b0(this.b);
                this.a.post(new b());
                e.printStackTrace();
            } catch (GoogleAuthException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("check_Scopes:GoogleAuthException:");
                sb2.append(e2.getCause() != null ? e2.getCause().getMessage() : "");
                Log.d("trace_drive=", sb2.toString());
                Google_drive_list.this.D.Lc("drive_error", "0");
                Google_drive_list.this.b0(this.b);
                this.a.post(new RunnableC0295c());
                e2.printStackTrace();
            } catch (Exception e3) {
                Log.d("trace_drive=", "Exception:" + e3.getMessage());
                e3.printStackTrace();
            }
        }
    }

    public class d implements HttpRequestInitializer {
        public final /* synthetic */ HttpRequestInitializer a;

        public d(HttpRequestInitializer httpRequestInitializer) {
            this.a = httpRequestInitializer;
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void initialize(HttpRequest httpRequest) {
            this.a.initialize(httpRequest);
            httpRequest.setConnectTimeout(180000);
            httpRequest.setReadTimeout(180000);
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                Google_drive_list.this.R();
            } catch (Exception unused) {
                Google_drive_list google_drive_list = Google_drive_list.this;
                Toast.makeText(google_drive_list, google_drive_list.getString(R.string.sql_error), 1);
            }
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g extends AsyncTask {
        public Drive a;
        public Exception b = null;
        public ArrayList c;
        public String d;

        public class a implements Runnable {
            public final /* synthetic */ ProgressDialog a;
            public final /* synthetic */ String b;

            public a(ProgressDialog progressDialog, String str) {
                this.a = progressDialog;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.setMessage(Google_drive_list.this.getString(R.string.google_drive_delete) + this.b);
            }
        }

        public g(GoogleAccountCredential googleAccountCredential, ArrayList arrayList) {
            this.a = null;
            new ArrayList();
            this.d = null;
            this.c = arrayList;
            this.a = new Drive.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), Google_drive_list.this.c0(googleAccountCredential)).setApplicationName("Drive API Android Quickstart").build();
        }

        public final boolean a() {
            try {
                boolean z = false;
                for (C4143vg c4143vg : this.c) {
                    this.a.files().delete(c4143vg.i()).execute();
                    d(Google_drive_list.this.q, c4143vg.j());
                    z = true;
                }
                return z;
            } catch (Exception e) {
                Log.d("delete_error=", e.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                return Boolean.valueOf(a());
            } catch (Exception e) {
                this.b = e;
                cancel(true);
                return Boolean.FALSE;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            Google_drive_list.this.q.hide();
            if (bool.booleanValue()) {
                Google_drive_list.this.S();
                return;
            }
            Google_drive_list.this.d.setText("No file deleted.");
            Google_drive_list.this.v.clear();
            Google_drive_list.this.u.notifyDataSetChanged();
        }

        public final void d(ProgressDialog progressDialog, String str) {
            Google_drive_list.this.runOnUiThread(new a(progressDialog, str));
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            if (Google_drive_list.this.q.isShowing()) {
                Google_drive_list.this.q.hide();
            }
            Exception exc = this.b;
            if (exc == null) {
                Google_drive_list.this.d.setText("Request cancelled.");
                return;
            }
            if (exc instanceof GooglePlayServicesAvailabilityIOException) {
                Google_drive_list.this.e0(((GooglePlayServicesAvailabilityIOException) exc).getConnectionStatusCode());
                return;
            }
            if (exc instanceof UserRecoverableAuthIOException) {
                Google_drive_list.this.startActivityForResult(((UserRecoverableAuthIOException) exc).getIntent(), 1001);
                return;
            }
            Google_drive_list.this.d.setText("Download:The following error occurred:\n" + this.b.getMessage());
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Google_drive_list google_drive_list = Google_drive_list.this;
            google_drive_list.q.setMessage(google_drive_list.getString(R.string.google_drive_download));
            Google_drive_list.this.q.show();
        }
    }

    public class h extends AsyncTask {
        public Drive a;
        public Exception b = null;
        public String c;
        public String d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Google_drive_list.this.startActivity(new Intent(Google_drive_list.this, (Class<?>) FragmentStatePagerSupport_Main.class));
                Google_drive_list.this.finish();
            }
        }

        public h(GoogleAccountCredential googleAccountCredential, String str, String str2) {
            this.a = null;
            this.c = str;
            this.d = str2;
            this.a = new Drive.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), Google_drive_list.this.c0(googleAccountCredential)).setApplicationName("Drive API Android Quickstart").build();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                return Boolean.valueOf(b());
            } catch (Exception e) {
                this.b = e;
                cancel(true);
                return Boolean.FALSE;
            }
        }

        public final boolean b() {
            try {
                this.a.files().get(this.c).executeMediaAndDownloadTo(Google_drive_list.this.D.Vd("Drive_" + this.d));
                return true;
            } catch (Exception e) {
                Log.d("download_error=", e.getMessage());
                return false;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            Google_drive_list.this.q.hide();
            if (!bool.booleanValue()) {
                Google_drive_list.this.d.setText("No file downloaded.");
                Google_drive_list.this.v.clear();
                Google_drive_list.this.u.notifyDataSetChanged();
                return;
            }
            new DateFormat();
            String strC8 = Z00.C8();
            AbstractC2242g10.c(Google_drive_list.this, "inv.db", strC8 + "-inv.db", "info.aalmoghalis.inventory");
            Google_drive_list.this.D.Y();
            new File(Z00.L).mkdirs();
            if (AbstractC2242g10.f(Google_drive_list.this, "inv.db", Z00.L, "Drive_" + this.d, "info.aalmoghalis.inventory") == 0) {
                new Handler().postDelayed(new a(), CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            if (Google_drive_list.this.q.isShowing()) {
                Google_drive_list.this.q.hide();
            }
            Exception exc = this.b;
            if (exc == null) {
                Google_drive_list.this.d.setText("Request cancelled.");
                return;
            }
            if (exc instanceof GooglePlayServicesAvailabilityIOException) {
                Google_drive_list.this.e0(((GooglePlayServicesAvailabilityIOException) exc).getConnectionStatusCode());
                return;
            }
            if (exc instanceof UserRecoverableAuthIOException) {
                Google_drive_list.this.startActivityForResult(((UserRecoverableAuthIOException) exc).getIntent(), 1001);
                return;
            }
            Google_drive_list.this.d.setText("Download:The following error occurred:\n" + this.b.getMessage());
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Google_drive_list google_drive_list = Google_drive_list.this;
            google_drive_list.q.setMessage(google_drive_list.getString(R.string.google_drive_download));
            Google_drive_list.this.q.show();
        }
    }

    public class i extends AsyncTask {
        public Drive a;
        public Exception b = null;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                Google_drive_list.this.startActivityForResult(((UserRecoverableAuthException) iVar.b).getIntent(), 1001);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                Google_drive_list.this.startActivityForResult(((UserRecoverableAuthIOException) iVar.b).getIntent(), 1001);
            }
        }

        public i(GoogleAccountCredential googleAccountCredential) {
            this.a = null;
            this.a = new Drive.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), Google_drive_list.this.c0(googleAccountCredential)).setApplicationName("Drive API Android Quickstart").build();
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List doInBackground(Void... voidArr) {
            try {
                return c();
            } catch (Exception e) {
                this.b = e;
                cancel(true);
                return null;
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [com.google.api.services.drive.Drive$Files$List] */
        public final List c() {
            ArrayList arrayList = new ArrayList();
            List listN = new C2160f10().n(Google_drive_list.this.i, this.a);
            String string = "";
            for (int i = 0; i < listN.size(); i++) {
                Log.d("trace_files=", i + ":" + ((String) listN.get(i)) + ":" + listN.size());
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append("'");
                sb.append((String) listN.get(i));
                sb.append("' in parents or ");
                string = sb.toString();
            }
            String strSubstring = string.substring(0, string.length() - 3);
            Log.d("trace_query=", strSubstring);
            Google_drive_list.this.A = null;
            FileList fileListExecute = this.a.files().list().setQ(strSubstring).setFields2("nextPageToken, files(id, name,mimeType,modifiedTime,size)").setPageToken(Google_drive_list.this.A).execute();
            List<com.google.api.services.drive.model.File> files = fileListExecute.getFiles();
            Google_drive_list google_drive_list = Google_drive_list.this;
            if (google_drive_list.A == null) {
                google_drive_list.v.clear();
            }
            Log.d("trace_drive=", "Files_CNT=" + files.size());
            for (com.google.api.services.drive.model.File file : fileListExecute.getFiles()) {
                if (file.getSize() != null) {
                    arrayList.add(String.format("%s (%s)-%s\n", file.getName(), file.getId(), file.getMimeType()));
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                        Google_drive_list.this.v.add(new C4143vg(file.getId(), file.getName(), new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).format(simpleDateFormat.parse(file.getModifiedTime().toString())), 0.0d, 0, 0, Z00.Ub(file.getSize().longValue())));
                    } catch (Exception e) {
                        Google_drive_list.this.v.add(new C4143vg(file.getId(), file.getName(), file.getModifiedTime().toString(), 0.0d, 0, 0, Z00.Ub(file.getSize().longValue())));
                        Log.d("date_error=", e.getMessage());
                    }
                }
            }
            Google_drive_list.this.A = fileListExecute.getNextPageToken();
            Log.d("trace_drive=", "dataList_CNT=" + Google_drive_list.this.v.size());
            Google_drive_list.this.l = " " + Google_drive_list.this.v.size();
            return Google_drive_list.this.v;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List list) {
            try {
                Google_drive_list.this.q.dismiss();
                Google_drive_list.this.y = false;
                if (list != null && list.size() != 0) {
                    Google_drive_list.this.u = new C0870Qv(Google_drive_list.this, R.layout.list_backup, list);
                    Google_drive_list.this.u.i.clear();
                    Google_drive_list.this.u.notifyDataSetChanged();
                    Google_drive_list google_drive_list = Google_drive_list.this;
                    google_drive_list.t.setAdapter((ListAdapter) google_drive_list.u);
                    Log.d("trace_drive=", "lv_size=" + Google_drive_list.this.u.d.size() + ":" + list.size() + ":" + Google_drive_list.this.v.size());
                    if (Google_drive_list.this.z > 20) {
                        Google_drive_list google_drive_list2 = Google_drive_list.this;
                        google_drive_list2.t.setSelection(google_drive_list2.z - 20);
                    }
                    if (Google_drive_list.this.v.size() > 100) {
                        Google_drive_list.this.e.setText(Google_drive_list.this.l);
                        return;
                    }
                    Google_drive_list.this.e.setText(Google_drive_list.this.k + Google_drive_list.this.l);
                    return;
                }
                Google_drive_list.this.d.setText(Google_drive_list.this.n);
                Google_drive_list.this.v.clear();
                Google_drive_list.this.u.notifyDataSetChanged();
            } catch (Exception unused) {
                if (this.b != null) {
                    Google_drive_list.this.d.setText(this.b.getMessage());
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            if (Google_drive_list.this.q.isShowing()) {
                Google_drive_list.this.q.hide();
            }
            Google_drive_list.this.y = false;
            Exception exc = this.b;
            if (exc == null) {
                Google_drive_list.this.d.setText("Request cancelled.");
            } else if (exc instanceof GooglePlayServicesAvailabilityIOException) {
                Google_drive_list.this.e0(((GooglePlayServicesAvailabilityIOException) exc).getConnectionStatusCode());
            } else {
                if (exc instanceof UserRecoverableAuthException) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error1:UserRecoverableAuthException:");
                    sb.append(this.b.getCause() != null ? this.b.getCause().getMessage() : "");
                    sb.append(":");
                    sb.append(Google_drive_list.this.D.ia("drive_error", "0"));
                    Log.d("trace_drive=", sb.toString());
                    Google_drive_list.this.runOnUiThread(new a());
                } else if (exc instanceof UserRecoverableAuthIOException) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error2:UserRecoverableAuthIOException:");
                    sb2.append(this.b.getCause() != null ? this.b.getCause().getMessage() : "");
                    sb2.append(":");
                    sb2.append(Google_drive_list.this.D.ia("drive_error", "0"));
                    Log.d("trace_drive=", sb2.toString());
                    Google_drive_list.this.runOnUiThread(new b());
                } else if (Google_drive_list.this.c.getSelectedAccountName() == null) {
                    Google_drive_list.this.d.setText("LIST: The following error occurred:\n" + this.b.getMessage());
                } else {
                    Google_drive_list.this.d.setText(Google_drive_list.this.p + "\nLIST: The following error occurred:\n" + this.b.getMessage() + ":" + Google_drive_list.this.c.getSelectedAccountName());
                }
            }
            Google_drive_list.this.v.clear();
            Google_drive_list.this.u.notifyDataSetChanged();
            Google_drive_list google_drive_list = Google_drive_list.this;
            google_drive_list.t.setAdapter((ListAdapter) google_drive_list.u);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            try {
                Google_drive_list google_drive_list = Google_drive_list.this;
                google_drive_list.q.setMessage(google_drive_list.getString(R.string.google_drive_list));
                Google_drive_list.this.q.show();
                Google_drive_list.this.y = true;
            } catch (Exception unused) {
            }
        }
    }

    public class j extends AsyncTask {
        public Drive a;
        public Exception b = null;
        public String c;

        public j(GoogleAccountCredential googleAccountCredential, String str) {
            this.a = null;
            this.c = str;
            this.a = new Drive.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), Google_drive_list.this.c0(googleAccountCredential)).setApplicationName("Drive API Android Quickstart").build();
        }

        public final String a(String str) {
            com.google.api.services.drive.model.File file = new com.google.api.services.drive.model.File();
            file.setName(str);
            file.setMimeType("application/vnd.google-apps.folder");
            return c(str) == null ? this.a.files().create(file).setFields2(HTML.Attribute.ID).execute().getId() : c(str);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                return Boolean.valueOf(d());
            } catch (Exception e) {
                this.b = e;
                cancel(true);
                return Boolean.FALSE;
            }
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [com.google.api.services.drive.Drive$Files$List] */
        public final String c(String str) {
            String nextPageToken = null;
            String id = null;
            do {
                FileList fileListExecute = this.a.files().list().setQ("mimeType='application/vnd.google-apps.folder' and name contains '" + str + "'").setSpaces("drive").setFields2("nextPageToken, files(id, name)").setPageToken(nextPageToken).execute();
                Iterator<com.google.api.services.drive.model.File> it = fileListExecute.getFiles().iterator();
                while (it.hasNext()) {
                    id = it.next().getId();
                }
                nextPageToken = fileListExecute.getNextPageToken();
            } while (nextPageToken != null);
            return id;
        }

        public final boolean d() {
            com.google.api.services.drive.model.File file = new com.google.api.services.drive.model.File();
            file.setName(this.c);
            file.setMimeType("application/x-sqlite3");
            file.setParents(Collections.singletonList(a(Google_drive_list.this.i)));
            String strIa = Google_drive_list.this.D.ia("prefBackup_path", Z00.L);
            File file2 = new File(strIa);
            if (new C3966tX().l(file2, strIa, Google_drive_list.this.D)) {
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(Google_drive_list.this.D.b, Uri.parse(Google_drive_list.this.D.ia("app_path_uri", "")));
                if (documentFileFromTreeUri.canWrite()) {
                    this.a.files().create(file, new FileContent("application/x-sqlite3", new C3966tX().o(documentFileFromTreeUri.findFile(this.c).getUri(), "tmp", Google_drive_list.this.D))).setFields2(HTML.Attribute.ID).execute();
                    return true;
                }
            }
            if (!file2.canWrite()) {
                return false;
            }
            this.a.files().create(file, new FileContent("application/x-sqlite3", new File(strIa + "/" + this.c))).setFields2(HTML.Attribute.ID).execute();
            return true;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                Google_drive_list.this.q.hide();
                if (bool.booleanValue()) {
                    Google_drive_list google_drive_list = Google_drive_list.this;
                    Toast.makeText(google_drive_list, google_drive_list.getString(R.string.backup_done), 1).show();
                    Google_drive_list.this.D.Lc("auto_drive_date_save", new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
                    Google_drive_list.this.D.Lc("db_data_changed", "0");
                    Google_drive_list.this.D.Lc("db_data_changed2", "0");
                    Z00.t0 = false;
                    Google_drive_list.this.S();
                } else {
                    Google_drive_list.this.d.setText("No file uploaded.");
                    Google_drive_list.this.v.clear();
                    Google_drive_list.this.u.notifyDataSetChanged();
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            if (Google_drive_list.this.q.isShowing()) {
                Google_drive_list.this.q.hide();
            }
            Exception exc = this.b;
            if (exc == null) {
                Google_drive_list.this.d.setText("Request cancelled.");
                return;
            }
            if (exc instanceof GooglePlayServicesAvailabilityIOException) {
                Google_drive_list.this.e0(((GooglePlayServicesAvailabilityIOException) exc).getConnectionStatusCode());
                return;
            }
            if (exc instanceof UserRecoverableAuthIOException) {
                Google_drive_list.this.startActivityForResult(((UserRecoverableAuthIOException) exc).getIntent(), 1001);
                return;
            }
            if (Google_drive_list.this.c.getSelectedAccountName() == null) {
                Google_drive_list.this.d.setText("UPLOAD: The following error occurred:\n" + this.b.getMessage());
                return;
            }
            File file = new File(Google_drive_list.this.D.ia("prefBackup_path", Z00.L));
            String str = "";
            if (!Google_drive_list.this.D.ia("app_path_uri", "").equals("")) {
                Uri uri = Uri.parse(Google_drive_list.this.D.ia("app_path_uri", ""));
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(Google_drive_list.this.D.b, uri);
                str = ":t2=" + documentFileFromTreeUri.canWrite() + ":" + documentFileFromTreeUri.listFiles().length + ":" + documentFileFromTreeUri.exists() + ":" + new C3966tX().t(uri);
            }
            Google_drive_list.this.d.setText(Build.VERSION.SDK_INT + "\nUPLOAD: The following error occurred:\n" + this.b.getMessage() + ":" + Google_drive_list.this.c.getSelectedAccountName() + ":\n" + Google_drive_list.this.D.ia("prefBackup_path", Z00.L) + "/" + this.c + ":\n:d=" + file.isDirectory() + ":e=" + file.exists() + ":t=" + file.canWrite() + str);
            if (new C3966tX().i(Google_drive_list.this.D.ia("prefBackup_path", Z00.L), Google_drive_list.this.D)) {
                Google_drive_list.this.D.he();
            }
            this.b.printStackTrace();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Google_drive_list google_drive_list = Google_drive_list.this;
            google_drive_list.q.setMessage(google_drive_list.getString(R.string.google_drive_backup));
            Google_drive_list.this.q.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.B.clear();
        for (int size = this.x.size() - 1; size >= 0; size--) {
            if (this.x.valueAt(size)) {
                this.B.add(this.u.getItem(this.x.keyAt(size)));
            }
        }
        new g(this.c, this.B).execute(new Void[0]);
    }

    private void d0() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public final void H() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(this);
        if (googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable)) {
            e0(iIsGooglePlayServicesAvailable);
        }
    }

    public void I() {
        try {
            if (getIntent().getStringExtra("bk_flag") == null || !getIntent().getStringExtra("bk_flag").equals("1")) {
                S();
            } else {
                this.w = getIntent().getStringExtra("auto_filename");
                J();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void J() {
        try {
            Log.d("trace_drive=", "backup_db:" + this.D.ia("drive_error", "0"));
            y();
        } catch (Exception e2) {
            Log.d("drive_error=", e2.getMessage() + "");
            this.d.setText(e2.getMessage());
            this.v.clear();
            this.u.notifyDataSetChanged();
        }
    }

    public void K(Context context) {
        this.A = null;
        this.z = 0;
        Log.d("trace_drive=", "check_Scopes:" + this.c.getAllAccounts().length + ":" + this.D.ia("drive_error", "0"));
        if (this.c.getAllAccounts().length > 0) {
            this.D.Lc("drive_error", "1");
            b0(this);
            Executors.newSingleThreadExecutor().execute(new c(new Handler(Looper.getMainLooper()), context));
        }
    }

    public final void L() {
        try {
            if (!AbstractC0573Hk.e(this, "android.permission.GET_ACCOUNTS")) {
                AbstractC0573Hk.h(this, "This app needs to access your Google account (via Contacts).", PointerIconCompat.TYPE_HELP, "android.permission.GET_ACCOUNTS");
                return;
            }
            String string = getPreferences(0).getString("accountName1", null);
            if (string != null) {
                this.c.setSelectedAccountName(string);
                S();
            } else if (this.D.S()) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
            } else {
                startActivityForResult(this.c.newChooseAccountIntent(), 1000);
            }
        } catch (Exception unused) {
        }
    }

    public final void M() {
        try {
            if (!AbstractC0573Hk.e(this, "android.permission.GET_ACCOUNTS")) {
                AbstractC0573Hk.h(this, "This app needs to access your Google account (via Contacts).", PointerIconCompat.TYPE_HELP, "android.permission.GET_ACCOUNTS");
                return;
            }
            String string = getPreferences(0).getString("accountName1", null);
            if (string != null) {
                this.c.setSelectedAccountName(string);
                if (U()) {
                    new h(this.c, this.h, this.g).execute(new Void[0]);
                    return;
                }
                return;
            }
            if (this.D.S()) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
            } else {
                startActivityForResult(this.c.newChooseAccountIntent(), 1000);
            }
        } catch (Exception unused) {
        }
    }

    public final void N() {
        try {
            Log.d("trace_drive=", "chooseAccount_force");
            if (AbstractC0573Hk.e(this, "android.permission.GET_ACCOUNTS")) {
                if (this.D.S()) {
                    Toast.makeText(this, getString(R.string.no_priv), 0).show();
                    return;
                } else {
                    startActivityForResult(this.c.newChooseAccountIntent(), 1000);
                    return;
                }
            }
            AbstractC0573Hk.g(this, getString(R.string.google_priv), R.string.alert_ok, R.string.alert_cancel, PointerIconCompat.TYPE_HELP, "android.permission.GET_ACCOUNTS");
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.GET_ACCOUNTS")) {
                Log.d("trace_drive=", "denied permission but not permanently");
            } else {
                Log.d("trace_drive=", "Permission denied permanently.");
                Toast.makeText(this, getString(R.string.permission_rationale), 1).show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("trace_drive=", "foce_Exception:" + e2.getMessage());
        }
    }

    public final void O() {
        try {
            if (!AbstractC0573Hk.e(this, "android.permission.GET_ACCOUNTS")) {
                AbstractC0573Hk.h(this, "This app needs to access your Google account (via Contacts).", PointerIconCompat.TYPE_HELP, "android.permission.GET_ACCOUNTS");
                return;
            }
            String string = getPreferences(0).getString("accountName1", null);
            if (string != null) {
                this.c.setSelectedAccountName(string);
                if (U()) {
                    Z();
                    return;
                }
                return;
            }
            if (this.D.S()) {
                Toast.makeText(this, getString(R.string.no_priv), 0).show();
            } else {
                startActivityForResult(this.c.newChooseAccountIntent(), 1000);
            }
        } catch (Exception unused) {
        }
    }

    public void Q() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.restore_confirm) + " " + this.g + "?");
        builder.setPositiveButton(getString(R.string.resourceID_OK), new e());
        builder.setNegativeButton(getString(R.string.resourceID_Cancel), new f());
        builder.create().show();
    }

    public final void R() {
        this.D.Lc("upgrade_db", "0");
        if (!V()) {
            H();
            return;
        }
        if (this.c.getSelectedAccountName() == null) {
            M();
        } else if (U()) {
            new h(this.c, this.h, this.g).execute(new Void[0]);
        } else {
            this.d.setText("No network connection available.");
        }
    }

    public final void S() {
        Log.d("trace_drive=", "getResultsFromApi:" + this.y + ":" + this.A);
        if (!V()) {
            H();
            return;
        }
        if (this.c.getSelectedAccountName() == null) {
            L();
        } else if (U()) {
            new i(this.c).execute(new Void[0]);
        } else {
            this.d.setText(getString(R.string.no_internet));
        }
    }

    public final void T(Intent intent) {
        try {
            GoogleSignIn.getSignedInAccountFromIntent(intent).addOnSuccessListener(new OnSuccessListener() { // from class: Kq
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.a.W((GoogleSignInAccount) obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: Lq
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Log.e("trace_drive=", "Unable to sign in.", exc);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean U() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean V() {
        GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        return true;
    }

    public final /* synthetic */ void W(GoogleSignInAccount googleSignInAccount) {
        Log.d("trace_drive=", "Signed in as " + googleSignInAccount.getEmail());
        String email = googleSignInAccount.getEmail();
        this.D.Lc("PREF_ACCOUNT_NAME", email);
        SharedPreferences.Editor editorEdit = getPreferences(0).edit();
        editorEdit.putString("accountName1", email);
        editorEdit.apply();
        a0(email);
        this.c.setSelectedAccount(googleSignInAccount.getAccount());
        S();
    }

    public void Y() {
        try {
            this.D = new Z00(this.C, this);
        } catch (Exception unused) {
        }
    }

    public void Z() {
        new DateFormat();
        String strC8 = Z00.C8();
        AbstractC2242g10.c(this, "inv.db", strC8 + "-inv.db", "info.aalmoghalis.inventory");
        if (!this.w.equals("")) {
            new j(this.c, this.w).execute(new Void[0]);
            return;
        }
        new j(this.c, strC8 + "-inv.db").execute(new Void[0]);
    }

    public void a0(String str) {
        try {
            GoogleAccountCredential googleAccountCredentialUsingOAuth2 = GoogleAccountCredential.usingOAuth2(this, Collections.singleton("https://www.googleapis.com/auth/drive.file"));
            this.c = googleAccountCredentialUsingOAuth2;
            googleAccountCredentialUsingOAuth2.setSelectedAccountName(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void add_btn(View view) {
        this.D.v0("commit;");
        J();
    }

    @Override // defpackage.AbstractC0573Hk.c
    public void b(int i2, List list) {
    }

    public void b0(Context context) {
        SharedPreferences preferences = getPreferences(0);
        Log.d("trace_drive=", "recreate_Credential:" + this.D.ia("drive_error", "0"));
        this.c = GoogleAccountCredential.usingOAuth2(context, Arrays.asList(this.D.ia("drive_error", "0").equals("0") ? F : E)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(preferences.getString("accountName1", null));
    }

    public void backup_btn(View view) {
        J();
    }

    public final HttpRequestInitializer c0(HttpRequestInitializer httpRequestInitializer) {
        return new d(httpRequestInitializer);
    }

    public void e0(int i2) {
        GoogleApiAvailability.getInstance().getErrorDialog(this, i2, 1002).show();
    }

    public void help_btn(View view) {
        new C3966tX().F(this, "javascript:DisplayItem_details('2','8','7')");
    }

    @Override // defpackage.AbstractC0573Hk.c
    public void i(int i2, List list) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        super.onActivityResult(i2, i3, intent);
        this.j += "r_code=" + i2 + ":" + i3;
        Log.d("trace_drive=", "onActivityResult:req=" + i2 + ":res=" + i3 + ":" + this.D.ia("drive_error", "0"));
        if (i2 == 2000) {
            if (i3 != -1 || intent == null) {
                return;
            }
            T(intent);
        }
        switch (i2) {
            case 1000:
                if (i3 == -1 && intent != null && intent.getExtras() != null && (stringExtra = intent.getStringExtra("authAccount")) != null) {
                    this.D.Lc("PREF_ACCOUNT_NAME", stringExtra);
                    Log.d("trace_drive=", "onActivityResult:reset:" + this.D.ia("drive_error", "0"));
                    SharedPreferences.Editor editorEdit = getPreferences(0).edit();
                    editorEdit.putString("accountName1", stringExtra);
                    editorEdit.apply();
                    b0(this);
                    this.c.setSelectedAccountName(stringExtra);
                    K(this);
                    break;
                }
                break;
            case 1001:
                if (i3 != -1) {
                    this.D.Lc("drive_error", "0");
                } else {
                    b0(this);
                    S();
                }
                break;
            case 1002:
                if (i3 == -1) {
                    S();
                } else {
                    this.d.setText("This app requires Google Play Services. Please install Google Play Services on your device and relaunch this app.");
                }
                break;
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SharedPreferences preferences = getPreferences(0);
        Z00 z00 = new Z00(this.C, this);
        this.D = z00;
        this.c = GoogleAccountCredential.usingOAuth2(this, Arrays.asList(z00.ia("drive_error", "0").equals("0") ? F : E)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(preferences.getString("accountName1", null));
        setContentView(R.layout.report_listview_layout4);
        d0();
        this.i = getString(R.string.app_name);
        this.k = getString(R.string.no_copies);
        this.n = getString(R.string.take_backup);
        this.p = getString(R.string.no_speed_internet);
        this.t = (ListView) findViewById(R.id.list_cus_det);
        TextView textView = (TextView) findViewById(R.id.emptyResults);
        this.d = textView;
        textView.setText("");
        this.e = (TextView) findViewById(R.id.footer_sum);
        ImageView imageView = (ImageView) findViewById(R.id.img_add_amount);
        this.f = imageView;
        imageView.setImageResource(android.R.drawable.ic_menu_upload);
        this.D.Lc("PREF_ACCOUNT_NAME", preferences.getString("accountName1", null));
        this.t.setEmptyView(this.d);
        setTitle(R.string.google_drive_title);
        this.u = new C0870Qv(this, R.layout.list_backup, this.v);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.q = progressDialog;
        progressDialog.setMessage(getString(R.string.google_drive_backup));
        this.q.dismiss();
        try {
            if (new C3966tX().i(this.D.ia("prefBackup_path", Z00.L), this.D)) {
                this.D.he();
            }
            Y();
            if (this.D.ia("PREF_ACCOUNT_NAME", null) == null || this.c.getSelectedAccountName() == null) {
                N();
            }
        } catch (Exception unused) {
        }
        try {
            if (getIntent().getStringExtra("bk_flag") != null && this.D.ia("PREF_ACCOUNT_NAME", null) != null) {
                try {
                    K(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception unused2) {
        }
        try {
            if (getIntent().getStringExtra("change_email_flag") != null && this.D.ia("PREF_ACCOUNT_NAME", null) != null && getIntent().getStringExtra("change_email_flag").equals("1")) {
                N();
            }
        } catch (Exception unused3) {
        }
        this.t.setChoiceMode(2);
        this.t.setChoiceMode(3);
        this.t.setMultiChoiceModeListener(new a());
        this.t.setOnItemClickListener(new b());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_google_email, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.change_email) {
            return super.onOptionsItemSelected(menuItem);
        }
        N();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        AbstractC0573Hk.f(i2, strArr, iArr, this);
    }

    public final void y() {
        try {
            if (!V()) {
                H();
            } else if (this.c.getSelectedAccountName() == null) {
                O();
            } else if (U()) {
                new DateFormat();
                String strC8 = Z00.C8();
                AbstractC2242g10.c(this, "inv.db", strC8 + "-inv.db", "info.aalmoghalis.inventory");
                if (this.w.equals("")) {
                    new j(this.c, strC8 + "-inv.db").execute(new Void[0]);
                } else {
                    new j(this.c, this.w).execute(new Void[0]);
                }
            } else {
                this.d.setText(getString(R.string.no_internet));
                this.v.clear();
                this.u.notifyDataSetChanged();
            }
        } catch (Exception unused) {
        }
    }
}
