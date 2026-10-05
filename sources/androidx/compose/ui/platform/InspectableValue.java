package androidx.compose.ui.platform;

import defpackage.AbstractC0806Os;
import defpackage.InterfaceC4362yO;

/* JADX INFO: loaded from: classes.dex */
public interface InspectableValue {

    public static final class DefaultImpls {
        @Deprecated
        public static InterfaceC4362yO getInspectableElements(InspectableValue inspectableValue) {
            return AbstractC0806Os.a(inspectableValue);
        }

        @Deprecated
        public static String getNameFallback(InspectableValue inspectableValue) {
            return AbstractC0806Os.b(inspectableValue);
        }

        @Deprecated
        public static Object getValueOverride(InspectableValue inspectableValue) {
            return AbstractC0806Os.c(inspectableValue);
        }
    }

    InterfaceC4362yO getInspectableElements();

    String getNameFallback();

    Object getValueOverride();
}
