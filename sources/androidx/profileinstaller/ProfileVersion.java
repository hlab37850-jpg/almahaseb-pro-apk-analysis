package androidx.profileinstaller;

import androidx.annotation.RestrictTo;
import com.itextpdf.text.pdf.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ProfileVersion {
    public static final int MAX_SUPPORTED_SDK = 34;
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V015_S = {ByteBuffer.ZERO, 49, 53, 0};
    static final byte[] V010_P = {ByteBuffer.ZERO, 49, ByteBuffer.ZERO, 0};
    static final byte[] V009_O_MR1 = {ByteBuffer.ZERO, ByteBuffer.ZERO, 57, 0};
    static final byte[] V005_O = {ByteBuffer.ZERO, ByteBuffer.ZERO, 53, 0};
    static final byte[] V001_N = {ByteBuffer.ZERO, ByteBuffer.ZERO, 49, 0};
    static final byte[] METADATA_V001_N = {ByteBuffer.ZERO, ByteBuffer.ZERO, 49, 0};
    static final byte[] METADATA_V002 = {ByteBuffer.ZERO, ByteBuffer.ZERO, 50, 0};

    private ProfileVersion() {
    }

    public static String dexKeySeparator(byte[] bArr) {
        return (Arrays.equals(bArr, V001_N) || Arrays.equals(bArr, V005_O)) ? ":" : "!";
    }
}
