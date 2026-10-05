package defpackage;

import android.content.Context;
import android.database.Cursor;
import androidx.loader.content.AsyncTaskLoader;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: Tq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0943Tq extends AsyncTaskLoader {
    public Z00 a;
    public int b;
    public int[] c;
    public double d;

    public C0943Tq(Context context, Z00 z00, int i) {
        super(context);
        this.c = new int[]{R.drawable.up, 1, R.drawable.down};
        this.d = 0.0d;
        this.a = z00;
        this.b = i;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList loadInBackground() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorG2 = this.b == 1 ? this.a.G2() : null;
        String strValueOf = String.valueOf(C2160f10.i);
        arrayList.clear();
        if (cursorG2 == null) {
            return arrayList;
        }
        cursorG2.moveToFirst();
        while (!cursorG2.isAfterLast()) {
            C0917Sq c0917Sq = new C0917Sq(cursorG2.getString(cursorG2.getColumnIndex("_id")), cursorG2.getString(cursorG2.getColumnIndex("g_name")), cursorG2.getString(cursorG2.getColumnIndex("curr_name")));
            int i = C2160f10.h;
            if (i <= 0 || (i > 0 && strValueOf.equals(cursorG2.getString(cursorG2.getColumnIndex("_id"))))) {
                arrayList.add(c0917Sq);
            }
            cursorG2.moveToNext();
        }
        cursorG2.close();
        return arrayList;
    }
}
