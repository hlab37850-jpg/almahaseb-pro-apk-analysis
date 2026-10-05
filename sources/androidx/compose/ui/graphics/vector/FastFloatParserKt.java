package androidx.compose.ui.graphics.vector;

/* JADX INFO: loaded from: classes.dex */
public final class FastFloatParserKt {
    private static final char charAt(CharSequence charSequence, int i) {
        if (i < charSequence.length()) {
            return charSequence.charAt(i);
        }
        return (char) 0;
    }

    private static final long fullMultiplicationHighBits(long j, long j2) {
        long j3 = j & 4294967295L;
        long j4 = j >>> 32;
        long j5 = j2 & 4294967295L;
        long j6 = j2 >>> 32;
        long j7 = j4 * j6;
        long j8 = j6 * j3;
        return j7 + ((((j4 * j5) + ((j3 * j5) >>> 32)) + (4294967295L & j8)) >>> 32) + (j8 >>> 32);
    }

    private static final boolean isDigit(char c) {
        return ((char) (c + 65488)) < '\n';
    }

    private static final int parseFourDigits(CharSequence charSequence, int i) {
        long jCharAt = (((long) charSequence.charAt(i + 3)) << 48) | ((long) charSequence.charAt(i)) | (((long) charSequence.charAt(i + 1)) << 16) | (((long) charSequence.charAt(i + 2)) << 32);
        long j = jCharAt - 13511005043687472L;
        if ((((jCharAt + 19703549022044230L) | j) & (-35747867511423104L)) != 0) {
            return -1;
        }
        return (int) ((j * 281475406208040961L) >>> 48);
    }
}
