package defpackage;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

/* JADX INFO: renamed from: oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3580oi implements InputFilter {
    public final int a;

    public C3580oi(int i) {
        this.a = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        int length = spanned.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            }
            if (spanned.charAt(i5) == '.') {
                break;
            }
            i5++;
        }
        if (i5 >= 0) {
            if (charSequence.equals(".")) {
                return "";
            }
            if (i4 > i5 && length - i5 > this.a) {
                return "";
            }
        }
        return null;
    }
}
