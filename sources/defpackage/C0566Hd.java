package defpackage;

import android.database.Cursor;
import androidx.collection.ArrayMap;

/* JADX INFO: renamed from: Hd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0566Hd {
    public ArrayMap a = new ArrayMap();

    public void a() {
        this.a.clear();
    }

    public int b(Cursor cursor, String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, Integer.valueOf(cursor.getColumnIndex(str)));
        }
        return ((Integer) this.a.get(str)).intValue();
    }
}
