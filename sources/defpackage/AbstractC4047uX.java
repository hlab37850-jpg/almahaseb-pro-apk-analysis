package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: uX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4047uX {
    public static final StringBuilder a = new StringBuilder();

    /* JADX INFO: renamed from: uX$a */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000L);
        }
    }

    /* JADX INFO: renamed from: uX$b */
    public static class b {
        public static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* JADX INFO: renamed from: uX$c */
    public static class c {
        public static int a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* JADX INFO: renamed from: uX$d */
    public static class d {
        public static InterfaceC1254ak a(Context context) {
            return new C4352yE(context);
        }
    }

    /* JADX INFO: renamed from: uX$e */
    public static class e extends Thread {
        public e(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* JADX INFO: renamed from: uX$f */
    public static class f implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new e(runnable);
        }
    }

    public static long a(File file) {
        long blockCount;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            blockCount = 5242880;
        }
        return Math.max(Math.min(blockCount, 52428800L), 5242880L);
    }

    public static int b(Context context) {
        ActivityManager activityManager = (ActivityManager) p(context, "activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z) {
            memoryClass = b.a(activityManager);
        }
        return (memoryClass * 1048576) / 7;
    }

    public static void c() {
        if (!s()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static Object d(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static void e(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    public static File f(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static InterfaceC1254ak g(Context context) {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return d.a(context);
        } catch (ClassNotFoundException unused) {
            return new C1232aX(context);
        }
    }

    public static String h(C3792rL c3792rL) {
        StringBuilder sb = a;
        String strI = i(c3792rL, sb);
        sb.setLength(0);
        return strI;
    }

    public static String i(C3792rL c3792rL, StringBuilder sb) {
        String str = c3792rL.f;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(c3792rL.f);
        } else {
            Uri uri = c3792rL.d;
            if (uri != null) {
                String string = uri.toString();
                sb.ensureCapacity(string.length() + 50);
                sb.append(string);
            } else {
                sb.ensureCapacity(50);
                sb.append(c3792rL.e);
            }
        }
        sb.append('\n');
        if (c3792rL.m != 0.0f) {
            sb.append("rotation:");
            sb.append(c3792rL.m);
            if (c3792rL.p) {
                sb.append('@');
                sb.append(c3792rL.n);
                sb.append('x');
                sb.append(c3792rL.o);
            }
            sb.append('\n');
        }
        if (c3792rL.c()) {
            sb.append("resize:");
            sb.append(c3792rL.h);
            sb.append('x');
            sb.append(c3792rL.i);
            sb.append('\n');
        }
        if (c3792rL.j) {
            sb.append("centerCrop");
            sb.append('\n');
        } else if (c3792rL.k) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List list = c3792rL.g;
        if (list == null || list.size() <= 0) {
            return sb.toString();
        }
        AbstractC3574of.a(c3792rL.g.get(0));
        throw null;
    }

    public static void j(Looper looper) {
        a aVar = new a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000L);
    }

    public static int k(Bitmap bitmap) {
        int iA = c.a(bitmap);
        if (iA >= 0) {
            return iA;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static String l(RunnableC2091e8 runnableC2091e8) {
        return m(runnableC2091e8, "");
    }

    public static String m(RunnableC2091e8 runnableC2091e8, String str) {
        StringBuilder sb = new StringBuilder(str);
        X1 x1H = runnableC2091e8.h();
        if (x1H != null) {
            sb.append(x1H.b.d());
        }
        List listI = runnableC2091e8.i();
        if (listI != null) {
            int size = listI.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || x1H != null) {
                    sb.append(", ");
                }
                sb.append(((X1) listI.get(i)).b.d());
            }
        }
        return sb.toString();
    }

    public static int n(Resources resources, C3792rL c3792rL) throws FileNotFoundException {
        Uri uri;
        int i = c3792rL.e;
        if (i != 0 || (uri = c3792rL.d) == null) {
            return i;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c3792rL.d);
        }
        List<String> pathSegments = c3792rL.d.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + c3792rL.d);
        }
        if (pathSegments.size() == 1) {
            try {
                return Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + c3792rL.d);
            }
        }
        if (pathSegments.size() == 2) {
            return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        }
        throw new FileNotFoundException("More than two path segments: " + c3792rL.d);
    }

    public static Resources o(Context context, C3792rL c3792rL) throws FileNotFoundException {
        Uri uri;
        if (c3792rL.e != 0 || (uri = c3792rL.d) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            throw new FileNotFoundException("No package provided: " + c3792rL.d);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(authority);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + c3792rL.d);
        }
    }

    public static Object p(Context context, String str) {
        return context.getSystemService(str);
    }

    public static boolean q(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean r(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean s() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean t(InputStream inputStream) {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && "RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) && "WEBP".equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    public static void u(String str, String str2, String str3) {
        v(str, str2, str3, "");
    }

    public static void v(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    public static boolean w(String str) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split(" ", 2);
        if ("CACHE".equals(strArrSplit[0])) {
            return true;
        }
        if (strArrSplit.length == 1) {
            return false;
        }
        try {
            return "CONDITIONAL_CACHE".equals(strArrSplit[0]) && Integer.parseInt(strArrSplit[1]) == 304;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static byte[] x(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }
}
