package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzad;
import com.google.firebase.iid.zzaz;
import defpackage.C2013d90;
import defpackage.Kf0;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseMessagingService extends zzc {
    private static final Queue<String> zza = new ArrayDeque(10);

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(@NonNull String str) {
    }

    @WorkerThread
    public void onNewToken(@NonNull String str) {
    }

    @WorkerThread
    public void onSendError(@NonNull String str, @NonNull Exception exc) {
    }

    @Override // com.google.firebase.messaging.zzc
    public final Intent zza(Intent intent) {
        return zzaz.zza().zzb();
    }

    @Override // com.google.firebase.messaging.zzc
    public final boolean zzb(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!zzo.zzd(intent)) {
            return true;
        }
        zzo.zza(intent);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:67:0x0102  */
    /* JADX WARN: Code duplicated, block: B:68:0x0107  */
    /* JADX WARN: Code duplicated, block: B:70:0x0111  */
    /* JADX WARN: Code duplicated, block: B:71:0x011a  */
    /* JADX WARN: Code duplicated, block: B:73:0x0120  */
    /* JADX WARN: Code duplicated, block: B:75:0x0136  */
    /* JADX WARN: Code duplicated, block: B:77:0x013c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0145  */
    /* JADX WARN: Code duplicated, block: B:82:0x0149  */
    /* JADX WARN: Code duplicated, block: B:83:0x015d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0168  */
    /* JADX WARN: Code duplicated, block: B:89:0x0178  */
    /* JADX WARN: Code duplicated, block: B:92:0x018c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0190  */
    /* JADX WARN: Code duplicated, block: B:95:0x0199  */
    /* JADX WARN: Code duplicated, block: B:99:0x01a2  */
    @Override // com.google.firebase.messaging.zzc
    public final void zzc(Intent intent) {
        Task<Void> taskZza;
        String stringExtra;
        Bundle extras;
        zzn zznVar;
        ExecutorService executorServiceNewSingleThreadExecutor;
        TransportFactory transportFactory;
        String stringExtra2;
        String str;
        byte b = 3;
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(action) && !"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
                if (zzo.zzd(intent)) {
                    zzo.zzb(intent);
                    return;
                }
                return;
            } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                onNewToken(intent.getStringExtra("token"));
                return;
            } else {
                String strValueOf = String.valueOf(intent.getAction());
                Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Unknown intent action: ".concat(strValueOf) : new String("Unknown intent action: "));
                return;
            }
        }
        String stringExtra3 = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra3)) {
            taskZza = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra3);
            taskZza = zzad.zza(this).zza(2, bundle);
        }
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra = intent.getStringExtra("message_type");
            if (stringExtra == null) {
                stringExtra = "gcm";
            }
            switch (stringExtra.hashCode()) {
                case -2062414158:
                    if (stringExtra.equals("deleted_messages")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    break;
                case 102161:
                    if (stringExtra.equals("gcm")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    break;
                case 814694033:
                    if (stringExtra.equals("send_error")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case 814800675:
                    if (!stringExtra.equals("send_event")) {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    onDeletedMessages();
                    break;
                case 1:
                    if (zzo.zzd(intent)) {
                        zzo.zza(intent, (Transport<String>) null);
                    }
                    if (zzo.zze(intent)) {
                        transportFactory = FirebaseMessaging.zza;
                        if (transportFactory != null) {
                            zzo.zza(intent, (Transport<String>) transportFactory.getTransport("FCM_CLIENT_EVENT_LOGGING", String.class, Encoding.of("json"), Kf0.a));
                        } else {
                            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
                        }
                    }
                    extras = intent.getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    extras.remove("androidx.contentpager.content.wakelockid");
                    if (zzn.zza(extras)) {
                        onMessageReceived(new RemoteMessage(extras));
                    } else {
                        zznVar = new zzn(extras);
                        executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                        try {
                            if (new C2013d90(this, zznVar, executorServiceNewSingleThreadExecutor).a()) {
                                executorServiceNewSingleThreadExecutor.shutdown();
                                if (zzo.zzd(intent)) {
                                    zzo.zzc(intent);
                                }
                                onMessageReceived(new RemoteMessage(extras));
                            } else {
                                executorServiceNewSingleThreadExecutor.shutdown();
                            }
                        } catch (Throwable th) {
                            executorServiceNewSingleThreadExecutor.shutdown();
                            throw th;
                        }
                    }
                    break;
                case 2:
                    stringExtra2 = intent.getStringExtra("google.message_id");
                    if (stringExtra2 == null) {
                        stringExtra2 = intent.getStringExtra("message_id");
                    }
                    onSendError(stringExtra2, new SendException(intent.getStringExtra("error")));
                    break;
                case 3:
                    onMessageSent(intent.getStringExtra("google.message_id"));
                    break;
                default:
                    if (stringExtra.length() != 0) {
                        str = "Received message with unknown type: ".concat(stringExtra);
                    } else {
                        str = new String("Received message with unknown type: ");
                    }
                    Log.w("FirebaseMessaging", str);
                    break;
            }
        } else {
            Queue<String> queue = zza;
            if (!queue.contains(stringExtra3)) {
                if (queue.size() >= 10) {
                    queue.remove();
                }
                queue.add(stringExtra3);
                stringExtra = intent.getStringExtra("message_type");
                if (stringExtra == null) {
                    stringExtra = "gcm";
                }
                switch (stringExtra.hashCode()) {
                    case -2062414158:
                        if (stringExtra.equals("deleted_messages")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 102161:
                        if (stringExtra.equals("gcm")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 814694033:
                        if (stringExtra.equals("send_error")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 814800675:
                        if (!stringExtra.equals("send_event")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        onDeletedMessages();
                        break;
                    case 1:
                        if (zzo.zzd(intent)) {
                            zzo.zza(intent, (Transport<String>) null);
                        }
                        if (zzo.zze(intent)) {
                            transportFactory = FirebaseMessaging.zza;
                            if (transportFactory != null) {
                                zzo.zza(intent, (Transport<String>) transportFactory.getTransport("FCM_CLIENT_EVENT_LOGGING", String.class, Encoding.of("json"), Kf0.a));
                            } else {
                                Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
                            }
                        }
                        extras = intent.getExtras();
                        if (extras == null) {
                            extras = new Bundle();
                        }
                        extras.remove("androidx.contentpager.content.wakelockid");
                        if (zzn.zza(extras)) {
                            onMessageReceived(new RemoteMessage(extras));
                        } else {
                            zznVar = new zzn(extras);
                            executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                            if (new C2013d90(this, zznVar, executorServiceNewSingleThreadExecutor).a()) {
                                executorServiceNewSingleThreadExecutor.shutdown();
                                if (zzo.zzd(intent)) {
                                    zzo.zzc(intent);
                                }
                                onMessageReceived(new RemoteMessage(extras));
                            } else {
                                executorServiceNewSingleThreadExecutor.shutdown();
                            }
                        }
                        break;
                    case 2:
                        stringExtra2 = intent.getStringExtra("google.message_id");
                        if (stringExtra2 == null) {
                            stringExtra2 = intent.getStringExtra("message_id");
                        }
                        onSendError(stringExtra2, new SendException(intent.getStringExtra("error")));
                        break;
                    case 3:
                        onMessageSent(intent.getStringExtra("google.message_id"));
                        break;
                    default:
                        if (stringExtra.length() != 0) {
                            str = "Received message with unknown type: ".concat(stringExtra);
                        } else {
                            str = new String("Received message with unknown type: ");
                        }
                        Log.w("FirebaseMessaging", str);
                        break;
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                String strValueOf2 = String.valueOf(stringExtra3);
                Log.d("FirebaseMessaging", strValueOf2.length() != 0 ? "Received duplicate message: ".concat(strValueOf2) : new String("Received duplicate message: "));
            }
        }
        try {
            Tasks.await(taskZza, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String strValueOf3 = String.valueOf(e);
            StringBuilder sb = new StringBuilder(strValueOf3.length() + 20);
            sb.append("Message ack failed: ");
            sb.append(strValueOf3);
            Log.w("FirebaseMessaging", sb.toString());
        }
    }
}
