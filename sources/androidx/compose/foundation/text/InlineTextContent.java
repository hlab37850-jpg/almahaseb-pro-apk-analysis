package androidx.compose.foundation.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.Placeholder;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class InlineTextContent {
    public static final int $stable = 0;
    private final InterfaceC0552Gp children;
    private final Placeholder placeholder;

    public InlineTextContent(Placeholder placeholder, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(placeholder, "placeholder");
        AbstractC4492zt.h(interfaceC0552Gp, "children");
        this.placeholder = placeholder;
        this.children = interfaceC0552Gp;
    }

    public final InterfaceC0552Gp getChildren() {
        return this.children;
    }

    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }
}
