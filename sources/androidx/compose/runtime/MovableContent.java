package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeApi
public final class MovableContent<P> {
    public static final int $stable = 0;
    private final InterfaceC0552Gp content;

    public MovableContent(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        this.content = interfaceC0552Gp;
    }

    public final InterfaceC0552Gp getContent() {
        return this.content;
    }
}
