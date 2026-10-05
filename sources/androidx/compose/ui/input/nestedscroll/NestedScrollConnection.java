package androidx.compose.ui.input.nestedscroll;

import defpackage.AbstractC2262gD;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollConnection {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m3947onPostFlingRZ2iAVY(NestedScrollConnection nestedScrollConnection, long j, long j2, InterfaceC0793Of interfaceC0793Of) {
            return AbstractC2262gD.a(nestedScrollConnection, j, j2, interfaceC0793Of);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m3948onPostScrollDzOQY0M(NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
            return AbstractC2262gD.b(nestedScrollConnection, j, j2, i);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m3949onPreFlingQWom1Mo(NestedScrollConnection nestedScrollConnection, long j, InterfaceC0793Of interfaceC0793Of) {
            return AbstractC2262gD.c(nestedScrollConnection, j, interfaceC0793Of);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m3950onPreScrollOzD1aCk(NestedScrollConnection nestedScrollConnection, long j, int i) {
            return AbstractC2262gD.d(nestedScrollConnection, j, i);
        }
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of);

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    long mo341onPostScrollDzOQY0M(long j, long j2, int i);

    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of);

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    long mo343onPreScrollOzD1aCk(long j, int i);
}
