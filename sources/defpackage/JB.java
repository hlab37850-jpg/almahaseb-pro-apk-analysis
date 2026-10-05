package defpackage;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class JB implements HttpUnsuccessfulResponseHandler, HttpIOExceptionHandler {
    public static final Logger d = Logger.getLogger(JB.class.getName());
    public final MediaHttpUploader a;
    public final HttpIOExceptionHandler b;
    public final HttpUnsuccessfulResponseHandler c;

    public JB(MediaHttpUploader mediaHttpUploader, HttpRequest httpRequest) {
        this.a = (MediaHttpUploader) Preconditions.checkNotNull(mediaHttpUploader);
        this.b = httpRequest.getIOExceptionHandler();
        this.c = httpRequest.getUnsuccessfulResponseHandler();
        httpRequest.setIOExceptionHandler(this);
        httpRequest.setUnsuccessfulResponseHandler(this);
    }

    @Override // com.google.api.client.http.HttpIOExceptionHandler
    public boolean handleIOException(HttpRequest httpRequest, boolean z) {
        HttpIOExceptionHandler httpIOExceptionHandler = this.b;
        boolean z2 = httpIOExceptionHandler != null && httpIOExceptionHandler.handleIOException(httpRequest, z);
        if (z2) {
            try {
                this.a.serverErrorCallback();
            } catch (IOException e) {
                d.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e);
            }
        }
        return z2;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
        HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler = this.c;
        boolean z2 = httpUnsuccessfulResponseHandler != null && httpUnsuccessfulResponseHandler.handleResponse(httpRequest, httpResponse, z);
        if (z2 && z && httpResponse.getStatusCode() / 100 == 5) {
            try {
                this.a.serverErrorCallback();
            } catch (IOException e) {
                d.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e);
            }
        }
        return z2;
    }
}
