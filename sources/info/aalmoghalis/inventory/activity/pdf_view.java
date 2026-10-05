package info.aalmoghalis.inventory.activity;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import androidx.core.content.FileProvider;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class pdf_view extends BaseActivity {
    public String c = "";
    public SQLiteDatabase d;
    public Z00 e;

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri uriFromFile;
        super.onCreate(bundle);
        setContentView(R.layout.activity_pdf);
        try {
            this.e = new Z00(this.d, this);
            if (getIntent().getStringExtra("filename") == null) {
                return;
            }
            String stringExtra = getIntent().getStringExtra("filename");
            this.c = stringExtra;
            setTitle(stringExtra.replace(".pdf", ""));
            File file = new File(Z00.L + "/" + this.c);
            if (file.exists()) {
                if (Build.VERSION.SDK_INT >= 24) {
                    uriFromFile = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
                } else {
                    uriFromFile = Uri.fromFile(file);
                }
                String str = "http://docs.google.com/gview?embedded=true&url=" + uriFromFile.getPath();
                Log.d("pdf_file=", "Opening PDF: " + str);
                WebView webView = (WebView) findViewById(R.id.web_view);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.share) {
            try {
                this.e.sd(this.c);
            } catch (Exception unused) {
            }
            return true;
        }
        if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
