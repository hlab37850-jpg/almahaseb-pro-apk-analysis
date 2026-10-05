package com.google.firebase.messaging;

import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final String a;
    public final Intent b;

    /* JADX INFO: renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    public static class C0273a implements ObjectEncoder {
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final /* synthetic */ void encode(Object obj, Object obj2) {
            a aVar = (a) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            Intent intentA = aVar.a();
            objectEncoderContext.add("ttl", zzo.zzf(intentA));
            objectEncoderContext.add(NotificationCompat.CATEGORY_EVENT, aVar.b());
            objectEncoderContext.add("instanceId", zzo.zzc());
            objectEncoderContext.add("priority", zzo.zzm(intentA));
            objectEncoderContext.add("packageName", zzo.zzb());
            objectEncoderContext.add("sdkPlatform", "ANDROID");
            objectEncoderContext.add("messageType", zzo.zzk(intentA));
            String strZzj = zzo.zzj(intentA);
            if (strZzj != null) {
                objectEncoderContext.add("messageId", strZzj);
            }
            String strZzl = zzo.zzl(intentA);
            if (strZzl != null) {
                objectEncoderContext.add("topic", strZzl);
            }
            String strZzg = zzo.zzg(intentA);
            if (strZzg != null) {
                objectEncoderContext.add("collapseKey", strZzg);
            }
            if (zzo.zzi(intentA) != null) {
                objectEncoderContext.add("analyticsLabel", zzo.zzi(intentA));
            }
            if (zzo.zzh(intentA) != null) {
                objectEncoderContext.add("composerLabel", zzo.zzh(intentA));
            }
            String strZzd = zzo.zzd();
            if (strZzd != null) {
                objectEncoderContext.add("projectNumber", strZzd);
            }
        }
    }

    public static final class b implements ObjectEncoder {
        @Override // com.google.firebase.encoders.ObjectEncoder
        public final /* synthetic */ void encode(Object obj, Object obj2) {
            ((ObjectEncoderContext) obj2).add("messaging_client_event", ((c) obj).a());
        }
    }

    public static final class c {
        public final a a;

        public c(a aVar) {
            this.a = (a) Preconditions.checkNotNull(aVar);
        }

        public final a a() {
            return this.a;
        }
    }

    public a(String str, Intent intent) {
        this.a = Preconditions.checkNotEmpty(str, "evenType must be non-null");
        this.b = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }

    public final Intent a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }
}
