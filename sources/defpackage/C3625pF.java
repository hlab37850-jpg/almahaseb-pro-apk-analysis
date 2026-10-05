package defpackage;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: pF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3625pF extends CharsetEncoder {
    public static final boolean[] a = new boolean[256];
    public static final Map b = new HashMap();

    static {
        byte b2 = 0;
        while (true) {
            char[] cArr = LF.a;
            if (b2 >= cArr.length) {
                return;
            }
            char c = cArr[b2];
            boolean z = c == b2;
            a[b2] = z;
            if (!z) {
                b.put(Character.valueOf(c), Byte.valueOf(b2));
            }
            b2 = (byte) (b2 + 1);
        }
    }

    public C3625pF() {
        super(null, 1.0f, 1.0f);
    }

    @Override // java.nio.charset.CharsetEncoder
    public CoderResult encodeLoop(CharBuffer charBuffer, ByteBuffer byteBuffer) {
        while (charBuffer.remaining() > 0) {
            if (byteBuffer.remaining() < 1) {
                return CoderResult.OVERFLOW;
            }
            char c = charBuffer.get();
            if (c < 0 || c >= 256 || !a[c]) {
                Byte b2 = (Byte) b.get(Character.valueOf(c));
                if (b2 == null) {
                    return CoderResult.unmappableForLength(1);
                }
                byteBuffer.put(b2.byteValue());
            } else {
                byteBuffer.put((byte) c);
            }
        }
        return CoderResult.UNDERFLOW;
    }

    @Override // java.nio.charset.CharsetEncoder
    public boolean isLegalReplacement(byte[] bArr) {
        return true;
    }
}
