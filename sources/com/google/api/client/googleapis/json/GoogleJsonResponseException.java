package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleJsonResponseException extends HttpResponseException {
    private static final long serialVersionUID = 409811126989994864L;
    private final transient GoogleJsonError details;

    public GoogleJsonResponseException(HttpResponseException.Builder builder, GoogleJsonError googleJsonError) {
        super(builder);
        this.details = googleJsonError;
    }

    public static HttpResponse execute(JsonFactory jsonFactory, HttpRequest httpRequest) throws IOException {
        Preconditions.checkNotNull(jsonFactory);
        boolean throwExceptionOnExecuteError = httpRequest.getThrowExceptionOnExecuteError();
        if (throwExceptionOnExecuteError) {
            httpRequest.setThrowExceptionOnExecuteError(false);
        }
        HttpResponse httpResponseExecute = httpRequest.execute();
        httpRequest.setThrowExceptionOnExecuteError(throwExceptionOnExecuteError);
        if (!throwExceptionOnExecuteError || httpResponseExecute.isSuccessStatusCode()) {
            return httpResponseExecute;
        }
        throw from(jsonFactory, httpResponseExecute);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    /* JADX WARN: Code duplicated, block: B:47:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x009a A[Catch: IOException -> 0x0089, TryCatch #0 {IOException -> 0x0089, blocks: (B:48:0x009a, B:50:0x00a1, B:49:0x009e, B:39:0x0085, B:43:0x008f), top: B:61:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:49:0x009e A[Catch: IOException -> 0x0089, TryCatch #0 {IOException -> 0x0089, blocks: (B:48:0x009a, B:50:0x00a1, B:49:0x009e, B:39:0x0085, B:43:0x008f), top: B:61:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5 A[Catch: IOException -> 0x00a2, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x00a2, blocks: (B:3:0x0015, B:5:0x001b, B:7:0x0027, B:53:0x00a5), top: B:66:0x0015 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.api.client.googleapis.json.GoogleJsonError] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static GoogleJsonResponseException from(JsonFactory jsonFactory, HttpResponse httpResponse) throws Throwable {
        String asString;
        JsonParser jsonParserCreateJsonParser;
        GoogleJsonError googleJsonError;
        HttpResponseException.Builder builder = new HttpResponseException.Builder(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
        Preconditions.checkNotNull(jsonFactory);
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        try {
            if (httpResponse.isSuccessStatusCode()) {
                asString = httpResponse.parseAsString();
            } else {
                String contentType = httpResponse.getContentType();
                if (HttpMediaType.equalsIgnoreParameters(Json.MEDIA_TYPE, contentType)) {
                    try {
                        if (httpResponse.getContent() != null) {
                            try {
                                jsonParserCreateJsonParser = jsonFactory.createJsonParser(httpResponse.getContent());
                                try {
                                    JsonToken currentToken = jsonParserCreateJsonParser.getCurrentToken();
                                    if (currentToken == null) {
                                        currentToken = jsonParserCreateJsonParser.nextToken();
                                    }
                                    if (currentToken != null) {
                                        jsonParserCreateJsonParser.skipToKey("error");
                                        if (jsonParserCreateJsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                                            GoogleJsonError googleJsonError2 = (GoogleJsonError) jsonParserCreateJsonParser.parseAndClose(GoogleJsonError.class);
                                            try {
                                                asString = googleJsonError2.toPrettyString();
                                                r1 = googleJsonError2;
                                            } catch (IOException e) {
                                                googleJsonError = googleJsonError2;
                                                e = e;
                                                try {
                                                    e.printStackTrace();
                                                    if (jsonParserCreateJsonParser == null) {
                                                        httpResponse.ignore();
                                                    } else if (googleJsonError == null) {
                                                        jsonParserCreateJsonParser.close();
                                                    }
                                                    asString = null;
                                                    r1 = googleJsonError;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (jsonParserCreateJsonParser != null) {
                                                        httpResponse.ignore();
                                                    } else if (googleJsonError == null) {
                                                        jsonParserCreateJsonParser.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                googleJsonError = googleJsonError2;
                                                th = th2;
                                                if (jsonParserCreateJsonParser != null) {
                                                    httpResponse.ignore();
                                                } else if (googleJsonError == null) {
                                                    jsonParserCreateJsonParser.close();
                                                }
                                                throw th;
                                            }
                                        } else {
                                            asString = null;
                                        }
                                    } else {
                                        asString = null;
                                    }
                                    if (r1 == 0) {
                                        try {
                                            jsonParserCreateJsonParser.close();
                                        } catch (IOException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    googleJsonError = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    googleJsonError = null;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                jsonParserCreateJsonParser = null;
                                googleJsonError = null;
                            } catch (Throwable th4) {
                                th = th4;
                                jsonParserCreateJsonParser = null;
                                googleJsonError = null;
                            }
                        } else {
                            asString = httpResponse.parseAsString();
                        }
                    } catch (IOException e5) {
                        e = e5;
                        asString = null;
                        r1 = contentType;
                    }
                } else {
                    asString = httpResponse.parseAsString();
                }
            }
        } catch (IOException e6) {
            e = e6;
            asString = null;
        }
        StringBuilder sbComputeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
        if (!Strings.isNullOrEmpty(asString)) {
            sbComputeMessageBuffer.append(StringUtils.LINE_SEPARATOR);
            sbComputeMessageBuffer.append(asString);
            builder.setContent(asString);
        }
        builder.setMessage(sbComputeMessageBuffer.toString());
        return new GoogleJsonResponseException(builder, r1);
    }

    public final GoogleJsonError getDetails() {
        return this.details;
    }
}
