package defpackage;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TJ {
    public static final InterfaceC0434Dx c(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new C0460Ex(matcher, charSequence);
        }
        return null;
    }

    public static final C1001Vs d(MatchResult matchResult, int i) {
        return AbstractC3871sJ.s(matchResult.start(i), matchResult.end(i));
    }
}
