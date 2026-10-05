package defpackage;

import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class YB {
    static {
        Modifier.Companion companion = Modifier.Companion;
    }

    public static Modifier a(Modifier modifier, Modifier modifier2) {
        AbstractC4492zt.h(modifier2, "other");
        return modifier2 == Modifier.Companion ? modifier : new CombinedModifier(modifier, modifier2);
    }
}
