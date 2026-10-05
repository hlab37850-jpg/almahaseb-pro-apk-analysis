package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3756qv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3430mv;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<FW> {
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;
    private final ActivityResultContract<FW, O> contract;
    private final ActivityResultLauncher<I> launcher;
    private final InterfaceC3430mv resultContract$delegate;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> activityResultLauncher, ActivityResultContract<I, O> activityResultContract, I i) {
        AbstractC4492zt.h(activityResultLauncher, "launcher");
        AbstractC4492zt.h(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.callerInput = i;
        this.resultContract$delegate = AbstractC3756qv.a(new ActivityResultCallerLauncher$resultContract$2(this));
        this.contract = getResultContract();
    }

    private final ActivityResultContract<FW, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<FW, ?> getContract() {
        return this.contract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(FW fw, ActivityOptionsCompat activityOptionsCompat) {
        AbstractC4492zt.h(fw, HTML.Tag.INPUT);
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
