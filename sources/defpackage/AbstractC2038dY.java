package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

/* JADX INFO: renamed from: dY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2038dY {
    public static C4278xL a(Context context) {
        return b(context, null);
    }

    public static C4278xL b(Context context, InterfaceC0753Mr interfaceC0753Mr) {
        File file = new File(context.getCacheDir(), "volley");
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageName);
            sb.append("/");
            sb.append(packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (interfaceC0753Mr == null) {
            interfaceC0753Mr = new C0831Pr();
        }
        C4278xL c4278xL = new C4278xL(new C3824rj(file), new C3937t7(interfaceC0753Mr));
        c4278xL.d();
        return c4278xL;
    }
}
