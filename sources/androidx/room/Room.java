package androidx.room;

import android.content.Context;
import androidx.annotation.RestrictTo;
import defpackage.AbstractC3880sS;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> cls, String str) {
        AbstractC4492zt.h(context, "context");
        AbstractC4492zt.h(cls, "klass");
        if (str == null || AbstractC3961tS.T(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.Builder<>(context, cls, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T, C> T getGeneratedImplementation(Class<C> cls, String str) {
        String str2;
        AbstractC4492zt.h(cls, "klass");
        AbstractC4492zt.h(str, "suffix");
        Package r1 = cls.getPackage();
        AbstractC4492zt.e(r1);
        String name = r1.getName();
        String canonicalName = cls.getCanonicalName();
        AbstractC4492zt.e(canonicalName);
        AbstractC4492zt.g(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            AbstractC4492zt.g(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str3 = AbstractC3880sS.w(canonicalName, '.', '_', false, 4, null) + str;
        try {
            if (name.length() == 0) {
                str2 = str3;
            } else {
                str2 = name + '.' + str3;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            AbstractC4492zt.f(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls2.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls + ".canonicalName");
        }
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> cls) {
        AbstractC4492zt.h(context, "context");
        AbstractC4492zt.h(cls, "klass");
        return new RoomDatabase.Builder<>(context, cls, null);
    }
}
