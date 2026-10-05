package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SuspendingPointerInputFilterKt {
    private static final PointerEvent EmptyPointerEvent = new PointerEvent(AbstractC1886cc.m());
    private static final String PointerInputModifierNoParamError = "Modifier.pointerInput must provide one or more 'key' parameters that define the identity of the modifier and determine when its previous input processing coroutine should be cancelled and a new effect launched for the new key.";

    public static final SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "pointerInputHandler");
        return new SuspendingPointerInputModifierNodeImpl(interfaceC0526Fp);
    }

    private static /* synthetic */ void getPointerInputModifierNoParamError$annotations() {
    }

    public static final Modifier pointerInput(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        throw new IllegalStateException(PointerInputModifierNoParamError);
    }

    public static final Modifier pointerInput(Modifier modifier, Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return modifier.then(new SuspendPointerInputElement(obj, null, null, interfaceC0526Fp, 6, null));
    }

    public static final Modifier pointerInput(Modifier modifier, Object obj, Object obj2, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return modifier.then(new SuspendPointerInputElement(obj, obj2, null, interfaceC0526Fp, 4, null));
    }

    public static final Modifier pointerInput(Modifier modifier, Object[] objArr, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(objArr, "keys");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return modifier.then(new SuspendPointerInputElement(null, null, objArr, interfaceC0526Fp, 3, null));
    }
}
