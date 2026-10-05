package defpackage;

import androidx.autofill.HintConstants;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: lg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3330lg {
    public static final C3330lg a = new C3330lg();

    public static final String a(String str, String str2, Charset charset) {
        AbstractC4492zt.h(str, HintConstants.AUTOFILL_HINT_USERNAME);
        AbstractC4492zt.h(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
        AbstractC4492zt.h(charset, "charset");
        return "Basic " + W8.d.b(str + ':' + str2, charset).a();
    }
}
