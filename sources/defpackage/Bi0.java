package defpackage;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class Bi0 implements Continuation {
    public final /* synthetic */ Sh0 a;

    public Bi0(Sh0 sh0) {
        this.a = sh0;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        Bundle bundle = (Bundle) task.getResult(IOException.class);
        Sh0 sh0 = this.a;
        return Sh0.e(bundle);
    }
}
