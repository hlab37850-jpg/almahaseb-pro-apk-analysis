package defpackage;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: b7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1769b7 implements InterfaceC3174jl {
    public static char c(char c, int i) {
        int i2 = c + ((i * ShapeTypes.FLOW_CHART_SORT) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }

    @Override // defpackage.InterfaceC3174jl
    public void a(C3256kl c3256kl) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (c3256kl.i()) {
            sb.append(c3256kl.c());
            c3256kl.f++;
            if (HighLevelEncoder.lookAheadTest(c3256kl.d(), c3256kl.f, b()) != b()) {
                c3256kl.o(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = c3256kl.a() + length + 1;
        c3256kl.q(iA);
        boolean z = c3256kl.g().getDataCapacity() - iA > 0;
        if (c3256kl.i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                }
                sb.setCharAt(0, (char) ((length / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            c3256kl.r(c(sb.charAt(i), c3256kl.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}
