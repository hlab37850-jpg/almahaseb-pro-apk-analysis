package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AE {
    public static final Logger a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        AbstractC4492zt.h(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? AbstractC3961tS.G(message, "getsockname failed", false, 2, null) : false;
    }

    public static final LQ c(Socket socket) throws IOException {
        AbstractC4492zt.h(socket, "<this>");
        XQ xq = new XQ(socket);
        OutputStream outputStream = socket.getOutputStream();
        AbstractC4492zt.g(outputStream, "getOutputStream(...)");
        return xq.z(new C1780bF(outputStream, xq));
    }

    public static final InterfaceC3309lR d(InputStream inputStream) {
        AbstractC4492zt.h(inputStream, "<this>");
        return new C0780Ns(inputStream, new JU());
    }

    public static final InterfaceC3309lR e(Socket socket) throws IOException {
        AbstractC4492zt.h(socket, "<this>");
        XQ xq = new XQ(socket);
        InputStream inputStream = socket.getInputStream();
        AbstractC4492zt.g(inputStream, "getInputStream(...)");
        return xq.A(new C0780Ns(inputStream, xq));
    }
}
