package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC4492zt;
import defpackage.JG;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextInputServicePlugin implements PlatformTextInputPlugin<Adapter> {
    public static final AndroidTextInputServicePlugin INSTANCE = new AndroidTextInputServicePlugin();

    @StabilityInferred(parameters = 0)
    public static final class Adapter implements PlatformTextInputAdapter {
        public static final int $stable = 8;
        private final TextInputServiceAndroid androidService;
        private final TextInputService service;

        public Adapter(TextInputService textInputService, TextInputServiceAndroid textInputServiceAndroid) {
            AbstractC4492zt.h(textInputService, NotificationCompat.CATEGORY_SERVICE);
            AbstractC4492zt.h(textInputServiceAndroid, "androidService");
            this.service = textInputService;
            this.androidService = textInputServiceAndroid;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInputAdapter
        public InputConnection createInputConnection(EditorInfo editorInfo) {
            AbstractC4492zt.h(editorInfo, "outAttrs");
            return this.androidService.createInputConnection(editorInfo);
        }

        public final TextInputService getService() {
            return this.service;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInputAdapter
        public /* synthetic */ void onDisposed() {
            JG.a(this);
        }
    }

    private AndroidTextInputServicePlugin() {
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputPlugin
    public Adapter createAdapter(PlatformTextInput platformTextInput, View view) {
        AbstractC4492zt.h(platformTextInput, "platformTextInput");
        AbstractC4492zt.h(view, "view");
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(view, platformTextInput);
        return new Adapter(new TextInputService(textInputServiceAndroid), textInputServiceAndroid);
    }
}
