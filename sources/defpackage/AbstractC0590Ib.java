package defpackage;

import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.text.AnnotatedString;

/* JADX INFO: renamed from: Ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0590Ib {
    public static boolean a(ClipboardManager clipboardManager) {
        AnnotatedString text = clipboardManager.getText();
        return text != null && text.length() > 0;
    }
}
