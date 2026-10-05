package androidx.paging;

import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class LoggerKt {
    public static final int DEBUG = 3;
    private static Logger LOGGER = null;
    public static final String LOG_TAG = "Paging";
    public static final int VERBOSE = 2;

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final void log(@IntRange(from = 2, to = MediaDescriptionCompat.BT_FOLDER_TYPE_ARTISTS) int i, Throwable th, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        Logger logger = getLOGGER();
        if (logger == null || !logger.isLoggable(i)) {
            return;
        }
        logger.log(i, (String) interfaceC3588op.invoke(), th);
    }

    public static /* synthetic */ void log$default(int i, Throwable th, InterfaceC3588op interfaceC3588op, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        Logger logger = getLOGGER();
        if (logger == null || !logger.isLoggable(i)) {
            return;
        }
        logger.log(i, (String) interfaceC3588op.invoke(), th);
    }

    public static final void setLOGGER(Logger logger) {
        LOGGER = logger;
    }
}
