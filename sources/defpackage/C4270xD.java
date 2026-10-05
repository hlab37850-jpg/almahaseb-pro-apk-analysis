package defpackage;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: renamed from: xD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4270xD implements InputFilter {
    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (charSequence == null || !charSequence.toString().contains("'")) {
            return null;
        }
        return charSequence.toString().replace("'", "");
    }
}
