package androidx.window.core;

/* JADX INFO: loaded from: classes2.dex */
public final class BuildConfig {
    public static final BuildConfig INSTANCE = new BuildConfig();
    private static final SpecificationComputer.VerificationMode verificationMode = SpecificationComputer.VerificationMode.QUIET;

    private BuildConfig() {
    }

    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return verificationMode;
    }
}
