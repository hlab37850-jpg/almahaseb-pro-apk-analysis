package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(SavedStateHandlesProvider savedStateHandlesProvider) {
        AbstractC4492zt.h(savedStateHandlesProvider, "provider");
        this.provider = savedStateHandlesProvider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        AbstractC4492zt.h(lifecycleOwner, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            this.provider.performRestore();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
