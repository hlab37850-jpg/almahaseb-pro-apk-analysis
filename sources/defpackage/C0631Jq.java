package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: renamed from: Jq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0631Jq {
    public static final String[] n = {"https://www.googleapis.com/auth/drive"};
    public static final String[] o = {"https://www.googleapis.com/auth/drive.file"};
    public GoogleAccountCredential a;
    public String d;
    public Context k;
    public Z00 l;
    public SQLiteDatabase m;
    public String b = null;
    public String c = null;
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";

    /* JADX INFO: renamed from: Jq$a */
    public class a implements HttpRequestInitializer {
        public final /* synthetic */ HttpRequestInitializer a;

        public a(HttpRequestInitializer httpRequestInitializer) {
            this.a = httpRequestInitializer;
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void initialize(HttpRequest httpRequest) {
            this.a.initialize(httpRequest);
            httpRequest.setConnectTimeout(180000);
            httpRequest.setReadTimeout(180000);
        }
    }

    /* JADX INFO: renamed from: Jq$b */
    public class b extends AsyncTask {
        public Drive a;
        public Exception b = null;
        public String c;

        public b(GoogleAccountCredential googleAccountCredential, String str) {
            this.a = null;
            this.c = str;
            C0631Jq.this.l = new Z00(C0631Jq.this.m, C0631Jq.this.k);
            this.a = new Drive.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), C0631Jq.this.g(googleAccountCredential)).setApplicationName("Drive API Android Quickstart").build();
        }

        public final String a(String str) {
            File file = new File();
            file.setName(str);
            file.setMimeType("application/vnd.google-apps.folder");
            return c(str) == null ? this.a.files().create(file).setFields2(HTML.Attribute.ID).execute().getId() : c(str);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            try {
                return Boolean.valueOf(d());
            } catch (UserRecoverableAuthIOException e) {
                C0631Jq.this.l.Lc("drive_error", "1");
                Log.d("drive_err=", "UserRecoverableAuthIOException");
                e.printStackTrace();
                this.b = e;
                cancel(true);
                return Boolean.FALSE;
            } catch (Exception e2) {
                e2.printStackTrace();
                this.b = e2;
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
                Iterator<File> it = fileListExecute.getFiles().iterator();
                while (it.hasNext()) {
                    id = it.next().getId();
                }
                nextPageToken = fileListExecute.getNextPageToken();
            } while (nextPageToken != null);
            return id;
        }

        public final boolean d() {
            File file = new File();
            file.setName(this.c);
            file.setMimeType("application/x-sqlite3");
            file.setParents(Collections.singletonList(a(C0631Jq.this.d)));
            String strIa = C0631Jq.this.l.ia("prefBackup_path", Z00.L);
            java.io.File file2 = new java.io.File(strIa);
            if (new C3966tX().l(file2, strIa, C0631Jq.this.l)) {
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(C0631Jq.this.l.b, Uri.parse(C0631Jq.this.l.ia("app_path_uri", "")));
                if (documentFileFromTreeUri.canWrite()) {
                    this.a.files().create(file, new FileContent("application/x-sqlite3", new C3966tX().o(documentFileFromTreeUri.findFile(this.c).getUri(), "tmp", C0631Jq.this.l))).setFields2(HTML.Attribute.ID).execute();
                    return true;
                }
            }
            if (!file2.canWrite()) {
                return false;
            }
            this.a.files().create(file, new FileContent("application/x-sqlite3", new java.io.File(strIa + "/" + this.c))).setFields2(HTML.Attribute.ID).execute();
            return true;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            try {
                Log.d("drive=", "onPostExecute:" + bool);
                if (bool.booleanValue()) {
                    f("1");
                    C0631Jq.this.l.Lc("db_data_changed2", "0");
                    C0631Jq.this.l.Lc("auto_drive_date_save", new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
                    Z00.t0 = false;
                } else {
                    f("0");
                    Log.d("drive", "No file uploaded.");
                }
            } catch (Exception unused) {
            }
        }

        public final void f(String str) {
            FragmentStatePagerSupport_Main.b0 = str;
            C0631Jq.this.l.Lc("bk_drive_flag", str);
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            Log.d("drive=", "onCancelled");
            f("0");
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            f("2");
            Log.d("drive=", "onPreExecute:" + FragmentStatePagerSupport_Main.b0);
        }
    }

    public C0631Jq(Context context, Z00 z00) {
        this.d = "DAFTAR";
        try {
            this.k = context;
            this.l = z00;
            this.l = new Z00(this.m, context);
            Log.d("job_start1=", "google_drive_auto");
            this.a = GoogleAccountCredential.usingOAuth2(context, Arrays.asList(z00.ia("drive_error", "0").equals("0") ? o : n)).setBackOff(new ExponentialBackOff()).setSelectedAccountName(z00.ia("PREF_ACCOUNT_NAME", null));
            this.d = context.getString(R.string.app_name);
            Log.d("job_start=", "google_drive_auto");
        } catch (Exception e) {
            Log.d("drive_err=", e.getMessage() + "");
            e.printStackTrace();
        }
    }

    public final void a() {
        try {
            if (!e()) {
                Log.d("drive_err", "acquireGooglePlayServices");
            } else if (this.a.getSelectedAccountName() == null) {
                Log.d("drive_err", "chooseAccount_upload");
            } else if (d()) {
                Log.d("drive_file=", this.j);
                if (!this.j.equals("")) {
                    new b(this.a, this.j).execute(new Void[0]);
                }
            } else {
                Log.d("isDeviceOnline", "No");
            }
        } catch (Exception unused) {
            f("0");
        }
    }

    public void c() {
        try {
            if (FragmentStatePagerSupport_Main.b0.equals("1")) {
                return;
            }
            f("2");
            Z00.L = this.l.ia("prefBackup_path", Z00.L);
            this.j = this.l.ia("auto_filename", "");
            a();
        } catch (Exception unused) {
            f("0");
        }
    }

    public final boolean d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.k.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean e() {
        GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.k);
        return true;
    }

    public final void f(String str) {
        FragmentStatePagerSupport_Main.b0 = str;
        this.l.Lc("bk_drive_flag", str);
    }

    public final HttpRequestInitializer g(HttpRequestInitializer httpRequestInitializer) {
        return new a(httpRequestInitializer);
    }
}
