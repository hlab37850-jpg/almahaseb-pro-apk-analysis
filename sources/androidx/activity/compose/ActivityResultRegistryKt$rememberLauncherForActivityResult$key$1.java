package androidx.activity.compose;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 extends AbstractC2233fv implements InterfaceC3588op {
    public static final ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 INSTANCE = new ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1();

    public ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1() {
        super(0);
    }

    @Override // defpackage.InterfaceC3588op
    public final String invoke() {
        return UUID.randomUUID().toString();
    }
}
