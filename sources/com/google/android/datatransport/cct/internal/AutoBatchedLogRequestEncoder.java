package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import defpackage.C3202k6;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoBatchedLogRequestEncoder();

    public static final class a implements ObjectEncoder {
        public static final a a = new a();
        public static final FieldDescriptor b = FieldDescriptor.of("sdkVersion");
        public static final FieldDescriptor c = FieldDescriptor.of("model");
        public static final FieldDescriptor d = FieldDescriptor.of("hardware");
        public static final FieldDescriptor e = FieldDescriptor.of("device");
        public static final FieldDescriptor f = FieldDescriptor.of("product");
        public static final FieldDescriptor g = FieldDescriptor.of("osBuild");
        public static final FieldDescriptor h = FieldDescriptor.of("manufacturer");
        public static final FieldDescriptor i = FieldDescriptor.of("fingerprint");
        public static final FieldDescriptor j = FieldDescriptor.of("locale");
        public static final FieldDescriptor k = FieldDescriptor.of("country");
        public static final FieldDescriptor l = FieldDescriptor.of("mccMnc");
        public static final FieldDescriptor m = FieldDescriptor.of("applicationBuild");

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b, androidClientInfo.getSdkVersion());
            objectEncoderContext.add(c, androidClientInfo.getModel());
            objectEncoderContext.add(d, androidClientInfo.getHardware());
            objectEncoderContext.add(e, androidClientInfo.getDevice());
            objectEncoderContext.add(f, androidClientInfo.getProduct());
            objectEncoderContext.add(g, androidClientInfo.getOsBuild());
            objectEncoderContext.add(h, androidClientInfo.getManufacturer());
            objectEncoderContext.add(i, androidClientInfo.getFingerprint());
            objectEncoderContext.add(j, androidClientInfo.getLocale());
            objectEncoderContext.add(k, androidClientInfo.getCountry());
            objectEncoderContext.add(l, androidClientInfo.getMccMnc());
            objectEncoderContext.add(m, androidClientInfo.getApplicationBuild());
        }
    }

    public static final class b implements ObjectEncoder {
        public static final b a = new b();
        public static final FieldDescriptor b = FieldDescriptor.of("logRequest");

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b, batchedLogRequest.getLogRequests());
        }
    }

    public static final class c implements ObjectEncoder {
        public static final c a = new c();
        public static final FieldDescriptor b = FieldDescriptor.of("clientType");
        public static final FieldDescriptor c = FieldDescriptor.of("androidClientInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b, clientInfo.getClientType());
            objectEncoderContext.add(c, clientInfo.getAndroidClientInfo());
        }
    }

    public static final class d implements ObjectEncoder {
        public static final d a = new d();
        public static final FieldDescriptor b = FieldDescriptor.of("eventTimeMs");
        public static final FieldDescriptor c = FieldDescriptor.of("eventCode");
        public static final FieldDescriptor d = FieldDescriptor.of("eventUptimeMs");
        public static final FieldDescriptor e = FieldDescriptor.of("sourceExtension");
        public static final FieldDescriptor f = FieldDescriptor.of("sourceExtensionJsonProto3");
        public static final FieldDescriptor g = FieldDescriptor.of("timezoneOffsetSeconds");
        public static final FieldDescriptor h = FieldDescriptor.of("networkConnectionInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b, logEvent.getEventTimeMs());
            objectEncoderContext.add(c, logEvent.getEventCode());
            objectEncoderContext.add(d, logEvent.getEventUptimeMs());
            objectEncoderContext.add(e, logEvent.getSourceExtension());
            objectEncoderContext.add(f, logEvent.getSourceExtensionJsonProto3());
            objectEncoderContext.add(g, logEvent.getTimezoneOffsetSeconds());
            objectEncoderContext.add(h, logEvent.getNetworkConnectionInfo());
        }
    }

    public static final class e implements ObjectEncoder {
        public static final e a = new e();
        public static final FieldDescriptor b = FieldDescriptor.of("requestTimeMs");
        public static final FieldDescriptor c = FieldDescriptor.of("requestUptimeMs");
        public static final FieldDescriptor d = FieldDescriptor.of("clientInfo");
        public static final FieldDescriptor e = FieldDescriptor.of("logSource");
        public static final FieldDescriptor f = FieldDescriptor.of("logSourceName");
        public static final FieldDescriptor g = FieldDescriptor.of("logEvent");
        public static final FieldDescriptor h = FieldDescriptor.of("qosTier");

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b, logRequest.getRequestTimeMs());
            objectEncoderContext.add(c, logRequest.getRequestUptimeMs());
            objectEncoderContext.add(d, logRequest.getClientInfo());
            objectEncoderContext.add(e, logRequest.getLogSource());
            objectEncoderContext.add(f, logRequest.getLogSourceName());
            objectEncoderContext.add(g, logRequest.getLogEvents());
            objectEncoderContext.add(h, logRequest.getQosTier());
        }
    }

    public static final class f implements ObjectEncoder {
        public static final f a = new f();
        public static final FieldDescriptor b = FieldDescriptor.of("networkType");
        public static final FieldDescriptor c = FieldDescriptor.of("mobileSubtype");

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(b, networkConnectionInfo.getNetworkType());
            objectEncoderContext.add(c, networkConnectionInfo.getMobileSubtype());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        b bVar = b.a;
        encoderConfig.registerEncoder(BatchedLogRequest.class, bVar);
        encoderConfig.registerEncoder(C3202k6.class, bVar);
        e eVar = e.a;
        encoderConfig.registerEncoder(LogRequest.class, eVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.d.class, eVar);
        c cVar = c.a;
        encoderConfig.registerEncoder(ClientInfo.class, cVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.b.class, cVar);
        a aVar = a.a;
        encoderConfig.registerEncoder(AndroidClientInfo.class, aVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.a.class, aVar);
        d dVar = d.a;
        encoderConfig.registerEncoder(LogEvent.class, dVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.c.class, dVar);
        f fVar = f.a;
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, fVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.e.class, fVar);
    }
}
