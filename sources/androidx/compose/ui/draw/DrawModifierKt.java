package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DrawModifierKt {
    public static final CacheDrawModifierNode CacheDrawModifierNode(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "onBuildDrawCache");
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), interfaceC3750qp);
    }

    public static final Modifier drawBehind(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onDraw");
        return modifier.then(new DrawBehindElement(interfaceC3750qp));
    }

    public static final Modifier drawWithCache(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onBuildDrawCache");
        return modifier.then(new DrawWithCacheElement(interfaceC3750qp));
    }

    public static final Modifier drawWithContent(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onDraw");
        return modifier.then(new DrawWithContentElement(interfaceC3750qp));
    }
}
