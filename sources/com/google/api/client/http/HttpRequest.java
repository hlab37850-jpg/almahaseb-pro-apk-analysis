package com.google.api.client.http;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.api.client.util.Beta;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingStreamingContent;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import com.google.api.client.util.StreamingContent;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpRequest {
    public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
    public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.22.0 (gzip)";
    public static final String VERSION = "1.22.0";

    @Beta
    @Deprecated
    private BackOffPolicy backOffPolicy;
    private HttpContent content;
    private HttpEncoding encoding;
    private HttpExecuteInterceptor executeInterceptor;

    @Beta
    private HttpIOExceptionHandler ioExceptionHandler;
    private ObjectParser objectParser;
    private String requestMethod;
    private HttpResponseInterceptor responseInterceptor;
    private boolean suppressUserAgentSuffix;
    private final HttpTransport transport;
    private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
    private GenericUrl url;
    private HttpHeaders headers = new HttpHeaders();
    private HttpHeaders responseHeaders = new HttpHeaders();
    private int numRetries = 10;
    private int contentLoggingLimit = 16384;
    private boolean loggingEnabled = true;
    private boolean curlLoggingEnabled = true;
    private int connectTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private int readTimeout = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
    private boolean followRedirects = true;
    private boolean throwExceptionOnExecuteError = true;

    @Beta
    @Deprecated
    private boolean retryOnExecuteIOException = false;
    private Sleeper sleeper = Sleeper.DEFAULT;

    public class a implements Callable {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpResponse call() {
            return HttpRequest.this.execute();
        }
    }

    public HttpRequest(HttpTransport httpTransport, String str) {
        this.transport = httpTransport;
        setRequestMethod(str);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x022c A[Catch: all -> 0x0235, TryCatch #1 {all -> 0x0235, blocks: (B:110:0x0226, B:112:0x022c, B:114:0x0230, B:119:0x023a, B:123:0x024c, B:125:0x0250, B:127:0x025a, B:130:0x0266, B:135:0x0271), top: B:164:0x0226 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0230 A[Catch: all -> 0x0235, TryCatch #1 {all -> 0x0235, blocks: (B:110:0x0226, B:112:0x022c, B:114:0x0230, B:119:0x023a, B:123:0x024c, B:125:0x0250, B:127:0x025a, B:130:0x0266, B:135:0x0271), top: B:164:0x0226 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0237  */
    /* JADX WARN: Code duplicated, block: B:119:0x023a A[Catch: all -> 0x0235, TryCatch #1 {all -> 0x0235, blocks: (B:110:0x0226, B:112:0x022c, B:114:0x0230, B:119:0x023a, B:123:0x024c, B:125:0x0250, B:127:0x025a, B:130:0x0266, B:135:0x0271), top: B:164:0x0226 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0248  */
    /* JADX WARN: Code duplicated, block: B:122:0x024a  */
    /* JADX WARN: Code duplicated, block: B:135:0x0271 A[Catch: all -> 0x0235, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0235, blocks: (B:110:0x0226, B:112:0x022c, B:114:0x0230, B:119:0x023a, B:123:0x024c, B:125:0x0250, B:127:0x025a, B:130:0x0266, B:135:0x0271), top: B:164:0x0226 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0279 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x027b  */
    /* JADX WARN: Code duplicated, block: B:141:0x027d  */
    /* JADX WARN: Code duplicated, block: B:146:0x0285  */
    /* JADX WARN: Code duplicated, block: B:148:0x0289  */
    /* JADX WARN: Code duplicated, block: B:160:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:161:0x02a4 A[LOOP:0: B:10:0x0021->B:161:0x02a4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:164:0x0226 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0266 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x0283 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x009b  */
    /* JADX WARN: Code duplicated, block: B:33:0x009f  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00de  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:55:0x010a  */
    /* JADX WARN: Code duplicated, block: B:56:0x010f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0114  */
    /* JADX WARN: Code duplicated, block: B:61:0x0118  */
    /* JADX WARN: Code duplicated, block: B:63:0x0135  */
    /* JADX WARN: Code duplicated, block: B:64:0x014b  */
    /* JADX WARN: Code duplicated, block: B:66:0x014f  */
    /* JADX WARN: Code duplicated, block: B:68:0x016a  */
    /* JADX WARN: Code duplicated, block: B:71:0x0185  */
    /* JADX WARN: Code duplicated, block: B:72:0x019f  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:80:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e9  */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x00a5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:63:0x0135, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x014f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x016a, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:71:0x0185, please report this as an issue */
    public HttpResponse execute() throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        String userAgent;
        HttpContent httpContent;
        boolean z;
        int i;
        StreamingContent streamingContent;
        boolean z2;
        HttpResponse httpResponse;
        HttpIOExceptionHandler httpIOExceptionHandler;
        HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler;
        boolean zHandleResponse;
        boolean z3;
        BackOffPolicy backOffPolicy;
        long nextBackOffMillis;
        HttpResponseInterceptor httpResponseInterceptor;
        boolean z4;
        LowLevelHttpResponse lowLevelHttpResponseExecute;
        String type;
        StreamingContent loggingStreamingContent;
        HttpEncoding httpEncoding;
        String name;
        HttpEncodingStreamingContent httpEncodingStreamingContent;
        long jComputeLength;
        StreamingContent streamingContent2;
        String str;
        String string;
        HttpRequest httpRequest = this;
        Preconditions.checkArgument(httpRequest.numRetries >= 0);
        int i2 = httpRequest.numRetries;
        BackOffPolicy backOffPolicy2 = httpRequest.backOffPolicy;
        if (backOffPolicy2 != null) {
            backOffPolicy2.reset();
        }
        Preconditions.checkNotNull(httpRequest.requestMethod);
        Preconditions.checkNotNull(httpRequest.url);
        int i3 = i2;
        HttpResponse httpResponse2 = null;
        while (true) {
            if (httpResponse2 != null) {
                httpResponse2.ignore();
            }
            HttpExecuteInterceptor httpExecuteInterceptor = httpRequest.executeInterceptor;
            if (httpExecuteInterceptor != null) {
                httpExecuteInterceptor.intercept(httpRequest);
            }
            String strBuild = httpRequest.url.build();
            LowLevelHttpRequest lowLevelHttpRequestBuildRequest = httpRequest.transport.buildRequest(httpRequest.requestMethod, strBuild);
            Logger logger = HttpTransport.LOGGER;
            boolean z5 = httpRequest.loggingEnabled && logger.isLoggable(Level.CONFIG);
            try {
                try {
                    if (z5) {
                        sb = new StringBuilder();
                        sb.append("-------------- REQUEST  --------------");
                        String str2 = StringUtils.LINE_SEPARATOR;
                        sb.append(str2);
                        sb.append(httpRequest.requestMethod);
                        sb.append(' ');
                        sb.append(strBuild);
                        sb.append(str2);
                        if (httpRequest.curlLoggingEnabled) {
                            sb2 = new StringBuilder("curl -v --compressed");
                            if (!httpRequest.requestMethod.equals(HttpMethods.GET)) {
                                sb2.append(" -X ");
                                sb2.append(httpRequest.requestMethod);
                            }
                        }
                        userAgent = httpRequest.headers.getUserAgent();
                        if (!httpRequest.suppressUserAgentSuffix) {
                            if (userAgent == null) {
                                httpRequest.headers.setUserAgent(USER_AGENT_SUFFIX);
                            } else {
                                httpRequest.headers.setUserAgent(userAgent + " " + USER_AGENT_SUFFIX);
                            }
                        }
                        HttpHeaders.serializeHeaders(httpRequest.headers, sb, sb2, logger, lowLevelHttpRequestBuildRequest);
                        if (!httpRequest.suppressUserAgentSuffix) {
                            httpRequest.headers.setUserAgent(userAgent);
                        }
                        httpContent = httpRequest.content;
                        if (httpContent != null || httpContent.retrySupported()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (httpContent != null) {
                            type = httpRequest.content.getType();
                            if (z5) {
                                loggingStreamingContent = httpContent;
                                loggingStreamingContent = new LoggingStreamingContent(httpContent, logger, Level.CONFIG, httpRequest.contentLoggingLimit);
                            }
                            loggingStreamingContent = httpContent;
                            httpEncoding = httpRequest.encoding;
                            if (httpEncoding == null) {
                                jComputeLength = httpRequest.content.getLength();
                                name = null;
                            } else {
                                name = httpEncoding.getName();
                                httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, httpRequest.encoding);
                                if (z) {
                                    jComputeLength = IOUtils.computeLength(httpEncodingStreamingContent);
                                } else {
                                    jComputeLength = -1;
                                }
                                streamingContent2 = httpEncodingStreamingContent;
                            }
                            if (z5) {
                                if (type != null) {
                                    StringBuilder sb3 = new StringBuilder();
                                    i = i3;
                                    sb3.append("Content-Type: ");
                                    sb3.append(type);
                                    string = sb3.toString();
                                    sb.append(string);
                                    sb.append(StringUtils.LINE_SEPARATOR);
                                    if (sb2 != null) {
                                        streamingContent2 = loggingStreamingContent;
                                        sb2.append(" -H '" + string + "'");
                                    }
                                } else {
                                    streamingContent2 = loggingStreamingContent;
                                    i = i3;
                                }
                                if (name != null) {
                                    str = "Content-Encoding: " + name;
                                    sb.append(str);
                                    sb.append(StringUtils.LINE_SEPARATOR);
                                    if (sb2 != null) {
                                        sb2.append(" -H '" + str + "'");
                                    }
                                }
                                if (jComputeLength >= 0) {
                                    sb.append("Content-Length: " + jComputeLength);
                                    sb.append(StringUtils.LINE_SEPARATOR);
                                }
                            } else {
                                i = i3;
                            }
                            if (sb2 != null) {
                                streamingContent2 = loggingStreamingContent;
                                sb2.append(" -d '@-'");
                            }
                            streamingContent2 = loggingStreamingContent;
                            lowLevelHttpRequestBuildRequest.setContentType(type);
                            lowLevelHttpRequestBuildRequest.setContentEncoding(name);
                            lowLevelHttpRequestBuildRequest.setContentLength(jComputeLength);
                            lowLevelHttpRequestBuildRequest.setStreamingContent(streamingContent2);
                            streamingContent = streamingContent2;
                        } else {
                            i = i3;
                        }
                        if (z5) {
                            streamingContent = httpContent;
                            logger.config(sb.toString());
                            if (sb2 != null) {
                                sb2.append(" -- '");
                                sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                                sb2.append("'");
                                if (streamingContent != null) {
                                    sb2.append(" << $$$");
                                }
                                logger.config(sb2.toString());
                            }
                        }
                        if (z || i <= 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        httpRequest = this;
                        lowLevelHttpRequestBuildRequest.setTimeout(httpRequest.connectTimeout, httpRequest.readTimeout);
                        lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
                        httpResponse = new HttpResponse(httpRequest, lowLevelHttpResponseExecute);
                        e = null;
                        if (httpResponse == null) {
                            try {
                                if (httpResponse.isSuccessStatusCode()) {
                                    if (httpResponse == null) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    z3 = z2 & z4;
                                } else {
                                    httpUnsuccessfulResponseHandler = httpRequest.unsuccessfulResponseHandler;
                                    if (httpUnsuccessfulResponseHandler != null) {
                                        zHandleResponse = httpUnsuccessfulResponseHandler.handleResponse(httpRequest, httpResponse, z2);
                                    } else {
                                        zHandleResponse = false;
                                    }
                                    if (!zHandleResponse) {
                                        if (!httpRequest.handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                                            zHandleResponse = true;
                                        } else if (z2 && (backOffPolicy = httpRequest.backOffPolicy) != null && backOffPolicy.isBackOffRequired(httpResponse.getStatusCode())) {
                                            nextBackOffMillis = httpRequest.backOffPolicy.getNextBackOffMillis();
                                            if (nextBackOffMillis != -1) {
                                                try {
                                                    httpRequest.sleeper.sleep(nextBackOffMillis);
                                                } catch (InterruptedException unused) {
                                                }
                                                zHandleResponse = true;
                                            }
                                        }
                                    }
                                    z3 = z2 & zHandleResponse;
                                    if (z3) {
                                        httpResponse.ignore();
                                    }
                                }
                            } catch (Throwable th) {
                                httpResponse.disconnect();
                                throw th;
                            }
                        } else {
                            if (httpResponse == null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            z3 = z2 & z4;
                        }
                        i3 = i - 1;
                        if (!z3) {
                            if (httpResponse != null) {
                                throw e;
                            }
                            httpResponseInterceptor = httpRequest.responseInterceptor;
                            if (httpResponseInterceptor != null) {
                                httpResponseInterceptor.interceptResponse(httpResponse);
                            }
                            if (httpRequest.throwExceptionOnExecuteError || httpResponse.isSuccessStatusCode()) {
                                return httpResponse;
                            }
                            try {
                                throw new HttpResponseException(httpResponse);
                            } catch (Throwable th2) {
                                httpResponse.disconnect();
                                throw th2;
                            }
                        }
                        httpResponse2 = httpResponse;
                    } else {
                        sb = null;
                    }
                    httpResponse = new HttpResponse(httpRequest, lowLevelHttpResponseExecute);
                    e = null;
                    if (httpResponse == null) {
                        if (httpResponse == null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z3 = z2 & z4;
                    } else if (httpResponse.isSuccessStatusCode()) {
                        httpUnsuccessfulResponseHandler = httpRequest.unsuccessfulResponseHandler;
                        if (httpUnsuccessfulResponseHandler != null) {
                            zHandleResponse = httpUnsuccessfulResponseHandler.handleResponse(httpRequest, httpResponse, z2);
                        } else {
                            zHandleResponse = false;
                        }
                        if (!zHandleResponse) {
                            if (!httpRequest.handleRedirect(httpResponse.getStatusCode(), httpResponse.getHeaders())) {
                                zHandleResponse = true;
                            } else if (z2) {
                                nextBackOffMillis = httpRequest.backOffPolicy.getNextBackOffMillis();
                                if (nextBackOffMillis != -1) {
                                    httpRequest.sleeper.sleep(nextBackOffMillis);
                                    zHandleResponse = true;
                                }
                            }
                        }
                        z3 = z2 & zHandleResponse;
                        if (z3) {
                            httpResponse.ignore();
                        }
                    } else {
                        if (httpResponse == null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z3 = z2 & z4;
                    }
                    i3 = i - 1;
                    if (!z3) {
                        if (httpResponse != null) {
                            throw e;
                        }
                        httpResponseInterceptor = httpRequest.responseInterceptor;
                        if (httpResponseInterceptor != null) {
                            httpResponseInterceptor.interceptResponse(httpResponse);
                        }
                        if (httpRequest.throwExceptionOnExecuteError) {
                        }
                        return httpResponse;
                    }
                    httpResponse2 = httpResponse;
                } catch (Throwable th3) {
                    InputStream content = lowLevelHttpResponseExecute.getContent();
                    if (content != null) {
                        content.close();
                    }
                    throw th3;
                }
                lowLevelHttpResponseExecute = lowLevelHttpRequestBuildRequest.execute();
            } catch (IOException e) {
                e = e;
                if (!httpRequest.retryOnExecuteIOException && ((httpIOExceptionHandler = httpRequest.ioExceptionHandler) == null || !httpIOExceptionHandler.handleIOException(httpRequest, z2))) {
                    throw e;
                }
                logger.log(Level.WARNING, "exception thrown while executing request", (Throwable) e);
                httpResponse = null;
            }
            sb2 = null;
            userAgent = httpRequest.headers.getUserAgent();
            if (!httpRequest.suppressUserAgentSuffix) {
                if (userAgent == null) {
                    httpRequest.headers.setUserAgent(USER_AGENT_SUFFIX);
                } else {
                    httpRequest.headers.setUserAgent(userAgent + " " + USER_AGENT_SUFFIX);
                }
            }
            HttpHeaders.serializeHeaders(httpRequest.headers, sb, sb2, logger, lowLevelHttpRequestBuildRequest);
            if (!httpRequest.suppressUserAgentSuffix) {
                httpRequest.headers.setUserAgent(userAgent);
            }
            httpContent = httpRequest.content;
            if (httpContent != null) {
                z = true;
            } else {
                z = true;
            }
            if (httpContent != null) {
                type = httpRequest.content.getType();
                if (z5) {
                    loggingStreamingContent = httpContent;
                    loggingStreamingContent = new LoggingStreamingContent(httpContent, logger, Level.CONFIG, httpRequest.contentLoggingLimit);
                }
                loggingStreamingContent = httpContent;
                httpEncoding = httpRequest.encoding;
                if (httpEncoding == null) {
                    jComputeLength = httpRequest.content.getLength();
                    name = null;
                } else {
                    name = httpEncoding.getName();
                    httpEncodingStreamingContent = new HttpEncodingStreamingContent(loggingStreamingContent, httpRequest.encoding);
                    if (z) {
                        jComputeLength = IOUtils.computeLength(httpEncodingStreamingContent);
                    } else {
                        jComputeLength = -1;
                    }
                    streamingContent2 = httpEncodingStreamingContent;
                }
                if (z5) {
                    if (type != null) {
                        StringBuilder sb4 = new StringBuilder();
                        i = i3;
                        sb4.append("Content-Type: ");
                        sb4.append(type);
                        string = sb4.toString();
                        sb.append(string);
                        sb.append(StringUtils.LINE_SEPARATOR);
                        if (sb2 != null) {
                            streamingContent2 = loggingStreamingContent;
                            sb2.append(" -H '" + string + "'");
                        }
                    } else {
                        streamingContent2 = loggingStreamingContent;
                        i = i3;
                    }
                    if (name != null) {
                        str = "Content-Encoding: " + name;
                        sb.append(str);
                        sb.append(StringUtils.LINE_SEPARATOR);
                        if (sb2 != null) {
                            sb2.append(" -H '" + str + "'");
                        }
                    }
                    if (jComputeLength >= 0) {
                        sb.append("Content-Length: " + jComputeLength);
                        sb.append(StringUtils.LINE_SEPARATOR);
                    }
                } else {
                    i = i3;
                }
                if (sb2 != null) {
                    streamingContent2 = loggingStreamingContent;
                    sb2.append(" -d '@-'");
                }
                streamingContent2 = loggingStreamingContent;
                lowLevelHttpRequestBuildRequest.setContentType(type);
                lowLevelHttpRequestBuildRequest.setContentEncoding(name);
                lowLevelHttpRequestBuildRequest.setContentLength(jComputeLength);
                lowLevelHttpRequestBuildRequest.setStreamingContent(streamingContent2);
                streamingContent = streamingContent2;
            } else {
                i = i3;
            }
            if (z5) {
                streamingContent = httpContent;
                logger.config(sb.toString());
                if (sb2 != null) {
                    sb2.append(" -- '");
                    sb2.append(strBuild.replaceAll("'", "'\"'\"'"));
                    sb2.append("'");
                    if (streamingContent != null) {
                        sb2.append(" << $$$");
                    }
                    logger.config(sb2.toString());
                }
            }
            if (z) {
                z2 = false;
            } else {
                z2 = false;
            }
            httpRequest = this;
            lowLevelHttpRequestBuildRequest.setTimeout(httpRequest.connectTimeout, httpRequest.readTimeout);
        }
    }

    @Beta
    public Future<HttpResponse> executeAsync(Executor executor) {
        FutureTask futureTask = new FutureTask(new a());
        executor.execute(futureTask);
        return futureTask;
    }

    @Beta
    @Deprecated
    public BackOffPolicy getBackOffPolicy() {
        return this.backOffPolicy;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public HttpContent getContent() {
        return this.content;
    }

    public int getContentLoggingLimit() {
        return this.contentLoggingLimit;
    }

    public HttpEncoding getEncoding() {
        return this.encoding;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    @Beta
    public HttpIOExceptionHandler getIOExceptionHandler() {
        return this.ioExceptionHandler;
    }

    public HttpExecuteInterceptor getInterceptor() {
        return this.executeInterceptor;
    }

    public int getNumberOfRetries() {
        return this.numRetries;
    }

    public final ObjectParser getParser() {
        return this.objectParser;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public HttpResponseInterceptor getResponseInterceptor() {
        return this.responseInterceptor;
    }

    @Beta
    @Deprecated
    public boolean getRetryOnExecuteIOException() {
        return this.retryOnExecuteIOException;
    }

    public Sleeper getSleeper() {
        return this.sleeper;
    }

    public boolean getSuppressUserAgentSuffix() {
        return this.suppressUserAgentSuffix;
    }

    public boolean getThrowExceptionOnExecuteError() {
        return this.throwExceptionOnExecuteError;
    }

    public HttpTransport getTransport() {
        return this.transport;
    }

    public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
        return this.unsuccessfulResponseHandler;
    }

    public GenericUrl getUrl() {
        return this.url;
    }

    public boolean handleRedirect(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!getFollowRedirects() || !HttpStatusCodes.isRedirect(i) || location == null) {
            return false;
        }
        setUrl(new GenericUrl(this.url.toURL(location)));
        if (i == 303) {
            setRequestMethod(HttpMethods.GET);
            setContent(null);
        }
        this.headers.setAuthorization((String) null);
        this.headers.setIfMatch(null);
        this.headers.setIfNoneMatch(null);
        this.headers.setIfModifiedSince(null);
        this.headers.setIfUnmodifiedSince(null);
        this.headers.setIfRange(null);
        return true;
    }

    public boolean isCurlLoggingEnabled() {
        return this.curlLoggingEnabled;
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    @Beta
    @Deprecated
    public HttpRequest setBackOffPolicy(BackOffPolicy backOffPolicy) {
        this.backOffPolicy = backOffPolicy;
        return this;
    }

    public HttpRequest setConnectTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.connectTimeout = i;
        return this;
    }

    public HttpRequest setContent(HttpContent httpContent) {
        this.content = httpContent;
        return this;
    }

    public HttpRequest setContentLoggingLimit(int i) {
        Preconditions.checkArgument(i >= 0, "The content logging limit must be non-negative.");
        this.contentLoggingLimit = i;
        return this;
    }

    public HttpRequest setCurlLoggingEnabled(boolean z) {
        this.curlLoggingEnabled = z;
        return this;
    }

    public HttpRequest setEncoding(HttpEncoding httpEncoding) {
        this.encoding = httpEncoding;
        return this;
    }

    public HttpRequest setFollowRedirects(boolean z) {
        this.followRedirects = z;
        return this;
    }

    public HttpRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    @Beta
    public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.ioExceptionHandler = httpIOExceptionHandler;
        return this;
    }

    public HttpRequest setInterceptor(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.executeInterceptor = httpExecuteInterceptor;
        return this;
    }

    public HttpRequest setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
        return this;
    }

    public HttpRequest setNumberOfRetries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.numRetries = i;
        return this;
    }

    public HttpRequest setParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
        return this;
    }

    public HttpRequest setReadTimeout(int i) {
        Preconditions.checkArgument(i >= 0);
        this.readTimeout = i;
        return this;
    }

    public HttpRequest setRequestMethod(String str) {
        Preconditions.checkArgument(str == null || HttpMediaType.matchesToken(str));
        this.requestMethod = str;
        return this;
    }

    public HttpRequest setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
        return this;
    }

    public HttpRequest setResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        this.responseInterceptor = httpResponseInterceptor;
        return this;
    }

    @Beta
    @Deprecated
    public HttpRequest setRetryOnExecuteIOException(boolean z) {
        this.retryOnExecuteIOException = z;
        return this;
    }

    public HttpRequest setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    public HttpRequest setSuppressUserAgentSuffix(boolean z) {
        this.suppressUserAgentSuffix = z;
        return this;
    }

    public HttpRequest setThrowExceptionOnExecuteError(boolean z) {
        this.throwExceptionOnExecuteError = z;
        return this;
    }

    public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.unsuccessfulResponseHandler = httpUnsuccessfulResponseHandler;
        return this;
    }

    public HttpRequest setUrl(GenericUrl genericUrl) {
        this.url = (GenericUrl) Preconditions.checkNotNull(genericUrl);
        return this;
    }

    @Beta
    public Future<HttpResponse> executeAsync() {
        return executeAsync(Executors.newSingleThreadExecutor());
    }
}
