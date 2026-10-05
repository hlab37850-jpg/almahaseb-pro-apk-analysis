package androidx.compose.runtime.tooling;

import defpackage.AbstractC0515Fe;
import defpackage.AbstractC0541Ge;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface CompositionGroup extends CompositionData {

    public static final class DefaultImpls {
        @Deprecated
        public static CompositionGroup find(CompositionGroup compositionGroup, Object obj) {
            AbstractC4492zt.h(obj, "identityToFind");
            return AbstractC0515Fe.a(compositionGroup, obj);
        }

        @Deprecated
        public static int getGroupSize(CompositionGroup compositionGroup) {
            return AbstractC0541Ge.a(compositionGroup);
        }

        @Deprecated
        public static Object getIdentity(CompositionGroup compositionGroup) {
            return AbstractC0541Ge.b(compositionGroup);
        }

        @Deprecated
        public static int getSlotsSize(CompositionGroup compositionGroup) {
            return AbstractC0541Ge.c(compositionGroup);
        }
    }

    Iterable<Object> getData();

    int getGroupSize();

    Object getIdentity();

    Object getKey();

    Object getNode();

    int getSlotsSize();

    String getSourceInfo();
}
