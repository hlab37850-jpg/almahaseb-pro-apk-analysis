package androidx.compose.ui.modifier;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class ModifierLocalMap {
    public static final int $stable = 0;

    public /* synthetic */ ModifierLocalMap(AbstractC0419Di abstractC0419Di) {
        this();
    }

    public abstract boolean contains$ui_release(ModifierLocal<?> modifierLocal);

    public abstract <T> T get$ui_release(ModifierLocal<T> modifierLocal);

    /* JADX INFO: renamed from: set$ui_release */
    public abstract <T> void mo4243set$ui_release(ModifierLocal<T> modifierLocal, T t);

    private ModifierLocalMap() {
    }
}
