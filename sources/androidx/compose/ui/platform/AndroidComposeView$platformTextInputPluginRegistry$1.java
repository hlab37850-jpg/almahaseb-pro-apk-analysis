package androidx.compose.ui.platform;

import androidx.compose.ui.text.input.PlatformTextInput;
import androidx.compose.ui.text.input.PlatformTextInputAdapter;
import androidx.compose.ui.text.input.PlatformTextInputPlugin;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$platformTextInputPluginRegistry$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$platformTextInputPluginRegistry$1(AndroidComposeView androidComposeView) {
        super(2);
        this.this$0 = androidComposeView;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final PlatformTextInputAdapter mo13invoke(PlatformTextInputPlugin<?> platformTextInputPlugin, PlatformTextInput platformTextInput) {
        AbstractC4492zt.h(platformTextInputPlugin, "factory");
        AbstractC4492zt.h(platformTextInput, "platformTextInput");
        return platformTextInputPlugin.createAdapter(platformTextInput, this.this$0);
    }
}
