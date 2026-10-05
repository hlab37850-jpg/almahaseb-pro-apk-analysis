package androidx.core.content;

import android.content.ContentValues;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(C2020dG... c2020dGArr) {
        ContentValues contentValues = new ContentValues(c2020dGArr.length);
        for (C2020dG c2020dG : c2020dGArr) {
            String str = (String) c2020dG.a();
            Object objB = c2020dG.b();
            if (objB == null) {
                contentValues.putNull(str);
            } else if (objB instanceof String) {
                contentValues.put(str, (String) objB);
            } else if (objB instanceof Integer) {
                contentValues.put(str, (Integer) objB);
            } else if (objB instanceof Long) {
                contentValues.put(str, (Long) objB);
            } else if (objB instanceof Boolean) {
                contentValues.put(str, (Boolean) objB);
            } else if (objB instanceof Float) {
                contentValues.put(str, (Float) objB);
            } else if (objB instanceof Double) {
                contentValues.put(str, (Double) objB);
            } else if (objB instanceof byte[]) {
                contentValues.put(str, (byte[]) objB);
            } else if (objB instanceof Byte) {
                contentValues.put(str, (Byte) objB);
            } else {
                if (!(objB instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + str + '\"');
                }
                contentValues.put(str, (Short) objB);
            }
        }
        return contentValues;
    }
}
