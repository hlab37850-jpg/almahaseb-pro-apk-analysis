package androidx.room.util;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0712Lb;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3880sS;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.PO;
import defpackage.QO;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {
    public static final Companion Companion = new Companion(null);
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IllegalAccessException, IOException, InvocationTargetException {
            Set setB = PO.b();
            Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            try {
                if (cursorQuery.getColumnCount() > 0) {
                    int columnIndex = cursorQuery.getColumnIndex("name");
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndex);
                        AbstractC4492zt.g(string, "cursor.getString(nameIndex)");
                        setB.add(string);
                    }
                }
                FW fw = FW.a;
                AbstractC0712Lb.a(cursorQuery, null);
                return PO.a(setB);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AbstractC0712Lb.a(cursorQuery, th);
                    throw th2;
                }
            }
        }

        private final Set<String> readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String str) throws IllegalAccessException, IOException, InvocationTargetException {
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
            try {
                String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("sql")) : "";
                AbstractC0712Lb.a(cursorQuery, null);
                AbstractC4492zt.g(string, "sql");
                return parseOptions(string);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AbstractC0712Lb.a(cursorQuery, th);
                    throw th2;
                }
            }
        }

        @VisibleForTesting
        public final Set<String> parseOptions(String str) {
            Character ch;
            AbstractC4492zt.h(str, "createStatement");
            if (str.length() == 0) {
                return QO.e();
            }
            String strSubstring = str.substring(AbstractC3961tS.Q(str, '(', 0, false, 6, null) + 1, AbstractC3961tS.W(str, ')', 0, false, 6, null));
            AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            int i = -1;
            int i2 = 0;
            int i3 = 0;
            while (i2 < strSubstring.length()) {
                char cCharAt = strSubstring.charAt(i2);
                int i4 = i3 + 1;
                if (cCharAt == '\'' || cCharAt == '\"' || cCharAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    } else {
                        Character ch2 = (Character) arrayDeque.peek();
                        if (ch2 != null && ch2.charValue() == cCharAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (cCharAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    }
                } else if (cCharAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.peek()) != null && ch.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (cCharAt == ',' && arrayDeque.isEmpty()) {
                    String strSubstring2 = strSubstring.substring(i + 1, i3);
                    AbstractC4492zt.g(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int length = strSubstring2.length() - 1;
                    int i5 = 0;
                    boolean z = false;
                    while (i5 <= length) {
                        boolean z2 = AbstractC4492zt.j(strSubstring2.charAt(!z ? i5 : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i5++;
                        } else {
                            z = true;
                        }
                    }
                    arrayList.add(strSubstring2.subSequence(i5, length + 1).toString());
                    i = i3;
                }
                i2++;
                i3 = i4;
            }
            String strSubstring3 = strSubstring.substring(i + 1);
            AbstractC4492zt.g(strSubstring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(AbstractC3961tS.D0(strSubstring3).toString());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                String str2 = (String) obj;
                for (String str3 : FtsTableInfo.FTS_OPTIONS) {
                    if (AbstractC3880sS.B(str2, str3, false, 2, null)) {
                        arrayList2.add(obj);
                        break;
                    }
                }
            }
            return AbstractC3240kc.H0(arrayList2);
        }

        @SuppressLint({"SyntheticAccessor"})
        public final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            AbstractC4492zt.h(supportSQLiteDatabase, "database");
            AbstractC4492zt.h(str, "tableName");
            return new FtsTableInfo(str, readColumns(supportSQLiteDatabase, str), readOptions(supportSQLiteDatabase, str));
        }

        private Companion() {
        }
    }

    public FtsTableInfo(String str, Set<String> set, Set<String> set2) {
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(set, "columns");
        AbstractC4492zt.h(set2, "options");
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    @VisibleForTesting
    public static final Set<String> parseOptions(String str) {
        return Companion.parseOptions(str);
    }

    @SuppressLint({"SyntheticAccessor"})
    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        if (AbstractC4492zt.d(this.name, ftsTableInfo.name) && AbstractC4492zt.d(this.columns, ftsTableInfo.columns)) {
            return AbstractC4492zt.d(this.options, ftsTableInfo.options);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String str, Set<String> set, String str2) {
        this(str, set, Companion.parseOptions(str2));
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(set, "columns");
        AbstractC4492zt.h(str2, "createSql");
    }
}
