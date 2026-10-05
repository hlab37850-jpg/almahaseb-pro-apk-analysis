package defpackage;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class XQ extends W5 {
    public final Socket o;

    public XQ(Socket socket) {
        AbstractC4492zt.h(socket, "socket");
        this.o = socket;
    }

    @Override // defpackage.W5
    public void B() {
        try {
            this.o.close();
        } catch (AssertionError e) {
            if (!AbstractC4443zE.c(e)) {
                throw e;
            }
            AE.a.log(Level.WARNING, "Failed to close timed out socket " + this.o, (Throwable) e);
        } catch (Exception e2) {
            AE.a.log(Level.WARNING, "Failed to close timed out socket " + this.o, (Throwable) e2);
        }
    }

    @Override // defpackage.W5
    public IOException x(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
