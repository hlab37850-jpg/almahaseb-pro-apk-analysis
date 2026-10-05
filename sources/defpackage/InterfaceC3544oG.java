package defpackage;

import com.google.api.client.http.HttpMethods;

/* JADX INFO: renamed from: oG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3544oG {
    public static final String[] a = {HttpMethods.CONNECT, "DISCONNECT", "EVENT", "ACK", "ERROR", "BINARY_EVENT", "BINARY_ACK"};

    /* JADX INFO: renamed from: oG$a */
    public interface a {

        /* JADX INFO: renamed from: oG$a$a, reason: collision with other inner class name */
        public interface InterfaceC0327a {
            void a(VF vf);
        }

        void a(InterfaceC0327a interfaceC0327a);

        void add(String str);

        void add(byte[] bArr);

        void destroy();
    }

    /* JADX INFO: renamed from: oG$b */
    public interface b {

        /* JADX INFO: renamed from: oG$b$a */
        public interface a {
            void call(Object[] objArr);
        }

        void a(VF vf, a aVar);
    }
}
