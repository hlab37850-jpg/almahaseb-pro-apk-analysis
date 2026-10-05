package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class RelocationModifierKt {
    @ExperimentalComposeUiApi
    public static final Modifier onRelocationRequest(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "onProvideDestination");
        AbstractC4492zt.h(interfaceC0552Gp, "onPerformRelocation");
        return modifier;
    }
}
