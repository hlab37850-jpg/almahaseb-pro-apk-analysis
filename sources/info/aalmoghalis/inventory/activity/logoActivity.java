package info.aalmoghalis.inventory.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;

/* JADX INFO: loaded from: classes3.dex */
public class logoActivity extends BaseActivity {
    public SQLiteDatabase c;
    public Z00 d;

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_logo);
        this.d = new Z00(this.c, this);
        registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: h10
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.a.x((Uri) obj);
            }
        }).launch(new PickVisualMediaRequest.Builder().setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE).build());
    }

    public final /* synthetic */ void x(Uri uri) {
        try {
            if (uri != null) {
                Log.d("trace_PhotoPicker", "Selected URI: " + uri);
                String[] strArr = {"_data"};
                Cursor cursorQuery = getContentResolver().query(uri, strArr, null, null, null);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                cursorQuery.close();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(string, options);
                int[] iArrB1 = Z00.b1(options, 80, 80, 300);
                this.d.Lc("ImageDecode", Z00.d(this.d.q0(string, iArrB1[0], iArrB1[1])));
                this.d.Mc("prefPrintUser", true);
                finish();
            } else {
                Log.d("trace_PhotoPicker", "No media selected");
                finish();
            }
        } catch (Exception e) {
            this.d.Kd(this, "Error:" + e.getMessage(), 5000);
        }
    }
}
