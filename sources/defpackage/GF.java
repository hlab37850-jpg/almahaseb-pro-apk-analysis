package defpackage;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GF {
    public static final GF c = new GF(new byte[0]);
    public static final e[] d;
    public byte[] a;
    public String b;

    public class a implements e {
        @Override // GF.e
        public byte[] a(String str) {
            return LF.b(str);
        }
    }

    public static abstract class b implements e {
        public Byte a;

        public b(Byte b) {
            this.a = b;
        }

        @Override // GF.e
        public byte[] a(String str) {
            CharsetEncoder charsetEncoderB = b();
            Byte b = this.a;
            if (b != null) {
                charsetEncoderB.replaceWith(new byte[]{b.byteValue()});
                charsetEncoderB.onUnmappableCharacter(CodingErrorAction.REPLACE);
            } else {
                charsetEncoderB.onUnmappableCharacter(CodingErrorAction.IGNORE);
            }
            try {
                ByteBuffer byteBufferEncode = charsetEncoderB.encode(CharBuffer.wrap(str));
                byte[] bArr = new byte[byteBufferEncode.remaining()];
                byteBufferEncode.get(bArr);
                return bArr;
            } catch (CharacterCodingException unused) {
                return null;
            }
        }

        public abstract CharsetEncoder b();
    }

    public static class c extends b {
        public /* synthetic */ c(Byte b, c cVar) {
            this(b);
        }

        @Override // GF.b
        public CharsetEncoder b() {
            return new C1985cs();
        }

        public c(Byte b) {
            super(b);
        }
    }

    public static class d extends b {
        public /* synthetic */ d(Byte b, d dVar) {
            this(b);
        }

        @Override // GF.b
        public CharsetEncoder b() {
            return new C3625pF();
        }

        public d(Byte b) {
            super(b);
        }
    }

    public interface e {
        byte[] a(String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        byte b2 = (byte) 0;
        byte b3 = (byte) 63;
        d = new e[]{new d(null, null == true ? 1 : 0), new d(b2, null == true ? 1 : 0), new d(b3, null == true ? 1 : 0), new a(), new c(null == true ? 1 : 0, null == true ? 1 : 0), new c(b2, null == true ? 1 : 0), new c(b3, null == true ? 1 : 0)};
    }

    public GF(byte[] bArr) {
        this.a = null;
        this.b = null;
        this.a = bArr == null ? new byte[0] : bArr;
    }

    public static List a(String str) {
        ArrayList arrayList = new ArrayList();
        for (e eVar : d) {
            byte[] bArrA = eVar.a(str);
            boolean z = false;
            for (int i = 0; !z && i < arrayList.size(); i++) {
                if (Arrays.equals((byte[]) arrayList.get(i), bArrA)) {
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(bArrA);
            }
        }
        return arrayList;
    }

    public static GF d(GF gf) {
        return gf != null ? gf : c;
    }

    public List b(boolean z) {
        String str;
        byte[] bArr = this.a;
        if (bArr != null || (str = this.b) == null) {
            return Collections.singletonList(bArr);
        }
        return c(str) ? Collections.singletonList(LF.b(this.b)) : a(this.b);
    }

    public final boolean c(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 127 || !Character.isLetterOrDigit(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public GF(String str) {
        this.a = null;
        this.b = null;
        this.b = str == null ? "" : str;
    }
}
