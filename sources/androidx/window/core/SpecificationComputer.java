package androidx.window.core;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SpecificationComputer<T> {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i, Object obj2) {
            if ((i & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        public final <T> SpecificationComputer<T> startSpecification(T t, String str, VerificationMode verificationMode, Logger logger) {
            AbstractC4492zt.h(t, "<this>");
            AbstractC4492zt.h(str, "tag");
            AbstractC4492zt.h(verificationMode, "verificationMode");
            AbstractC4492zt.h(logger, "logger");
            return new ValidSpecification(t, str, verificationMode, logger);
        }

        private Companion() {
        }
    }

    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public abstract T compute();

    public final String createMessage(Object obj, String str) {
        AbstractC4492zt.h(obj, "value");
        AbstractC4492zt.h(str, "message");
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer<T> require(String str, InterfaceC3750qp interfaceC3750qp);
}
