package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new a();

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        private String unsafeReplacement;

        public class a extends ArrayBasedCharEscaper {
            public final char[] a;

            public a(Map map, char c, char c2) {
                super((Map<Character, String>) map, c, c2);
                this.a = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
            }

            @Override // com.google.common.escape.ArrayBasedCharEscaper
            public char[] escapeUnsafe(char c) {
                return this.a;
            }
        }

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        @CanIgnoreReturnValue
        public Builder addEscape(char c, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c), str);
            return this;
        }

        public Escaper build() {
            return new a(this.replacementMap, this.safeMin, this.safeMax);
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c, char c2) {
            this.safeMin = c;
            this.safeMax = c2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(String str) {
            this.unsafeReplacement = str;
            return this;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = (char) 0;
            this.safeMax = (char) 65535;
            this.unsafeReplacement = null;
        }
    }

    public class a extends CharEscaper {
        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char c) {
            return null;
        }

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }
    }

    public class b extends UnicodeEscaper {
        public final /* synthetic */ CharEscaper a;

        public b(CharEscaper charEscaper) {
            this.a = charEscaper;
        }

        @Override // com.google.common.escape.UnicodeEscaper
        public char[] escape(int i) {
            if (i < 65536) {
                return this.a.escape((char) i);
            }
            char[] cArr = new char[2];
            Character.toChars(i, cArr, 0);
            char[] cArrEscape = this.a.escape(cArr[0]);
            char[] cArrEscape2 = this.a.escape(cArr[1]);
            if (cArrEscape == null && cArrEscape2 == null) {
                return null;
            }
            int length = cArrEscape != null ? cArrEscape.length : 1;
            char[] cArr2 = new char[(cArrEscape2 != null ? cArrEscape2.length : 1) + length];
            if (cArrEscape != null) {
                for (int i2 = 0; i2 < cArrEscape.length; i2++) {
                    cArr2[i2] = cArrEscape[i2];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (cArrEscape2 != null) {
                for (int i3 = 0; i3 < cArrEscape2.length; i3++) {
                    cArr2[length + i3] = cArrEscape2[i3];
                }
            } else {
                cArr2[length] = cArr[1];
            }
            return cArr2;
        }
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        String name = escaper.getClass().getName();
        throw new IllegalArgumentException(name.length() != 0 ? "Cannot create a UnicodeEscaper from: ".concat(name) : new String("Cannot create a UnicodeEscaper from: "));
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static String computeReplacement(CharEscaper charEscaper, char c) {
        return stringOrNull(charEscaper.escape(c));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    private static String stringOrNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(CharEscaper charEscaper) {
        return new b(charEscaper);
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i) {
        return stringOrNull(unicodeEscaper.escape(i));
    }
}
