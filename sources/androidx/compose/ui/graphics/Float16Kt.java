package androidx.compose.ui.graphics;

/* JADX INFO: loaded from: classes.dex */
public final class Float16Kt {
    /* JADX INFO: renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m3173maxAoSsdG0(short s, short s2) {
        if (Float16.m3146isNaNimpl(s) || Float16.m3146isNaNimpl(s2)) {
            return Float16.Companion.m3168getNaNslo4al4();
        }
        return Float16.m3133compareTo41bOqos(s, s2) >= 0 ? s : s2;
    }

    /* JADX INFO: renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m3174minAoSsdG0(short s, short s2) {
        if (Float16.m3146isNaNimpl(s) || Float16.m3146isNaNimpl(s2)) {
            return Float16.Companion.m3168getNaNslo4al4();
        }
        return Float16.m3133compareTo41bOqos(s, s2) <= 0 ? s : s2;
    }
}
