package defpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: loaded from: classes2.dex */
public final class X10 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ActivityResultLauncher c;
    public final /* synthetic */ GoogleApiAvailability d;

    public X10(GoogleApiAvailability googleApiAvailability, Activity activity, int i, ActivityResultLauncher activityResultLauncher) {
        this.d = googleApiAvailability;
        this.a = activity;
        this.b = i;
        this.c = activityResultLauncher;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.d.getErrorResolutionPendingIntent(this.a, this.b, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        this.c.launch(new IntentSenderRequest.Builder(errorResolutionPendingIntent.getIntentSender()).build());
    }
}
