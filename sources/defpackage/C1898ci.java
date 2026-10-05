package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Toast;
import info.aalmoghalis.inventory.R;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* JADX INFO: renamed from: ci, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1898ci extends SQLiteOpenHelper {
    public static C1898ci b;
    public static final String c = Environment.getExternalStorageDirectory().getAbsolutePath() + "/INV_APP/";
    public Context a;

    public C1898ci(Context context) {
        super(context, "inv.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.a = context;
    }

    public static synchronized C1898ci c(Context context) {
        try {
            if (b == null) {
                b = new C1898ci(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.a.getResources().openRawResource(R.raw.sql), null).getElementsByTagName("statement");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                try {
                    sQLiteDatabase.execSQL(elementsByTagName.item(i).getChildNodes().item(0).getNodeValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            Toast.makeText(this.a, th.toString(), 1).show();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.disableWriteAheadLogging();
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
