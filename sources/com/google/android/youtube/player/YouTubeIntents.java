package com.google.android.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.youtube.player.internal.z;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class YouTubeIntents {
    private YouTubeIntents() {
    }

    public static Intent a(Intent intent, Context context) {
        intent.putExtra("app_package", context.getPackageName()).putExtra("app_version", z.d(context)).putExtra("client_library_version", z.a());
        return intent;
    }

    private static Intent b(Context context, Uri uri) {
        return a(new Intent("android.intent.action.VIEW", uri).setPackage(a(context)), context);
    }

    public static boolean canResolveChannelIntent(Context context) {
        return a(context, Uri.parse("https://www.youtube.com/channel/"));
    }

    public static boolean canResolveOpenPlaylistIntent(Context context) {
        return a(context, Uri.parse("https://www.youtube.com/playlist?list="));
    }

    public static boolean canResolvePlayPlaylistIntent(Context context) {
        int installedYouTubeVersionCode = getInstalledYouTubeVersionCode(context);
        if (z.a(context.getPackageManager())) {
            if (installedYouTubeVersionCode < 4700) {
                return false;
            }
        } else if (installedYouTubeVersionCode < 4000) {
            return false;
        }
        return canResolveOpenPlaylistIntent(context);
    }

    public static boolean canResolvePlayVideoIntent(Context context) {
        return a(context, Uri.parse("https://www.youtube.com/watch?v="));
    }

    public static boolean canResolvePlayVideoIntentWithOptions(Context context) {
        int installedYouTubeVersionCode = getInstalledYouTubeVersionCode(context);
        PackageManager packageManager = context.getPackageManager();
        if (!z.b(packageManager)) {
            if (z.a(packageManager)) {
                if (installedYouTubeVersionCode < Integer.MAX_VALUE) {
                    return false;
                }
            } else if (installedYouTubeVersionCode < 3300) {
                return false;
            }
        }
        return canResolvePlayVideoIntent(context);
    }

    public static boolean canResolveSearchIntent(Context context) {
        if (!z.a(context.getPackageManager()) || getInstalledYouTubeVersionCode(context) >= 4700) {
            return a(context, new Intent("android.intent.action.SEARCH").setPackage(a(context)));
        }
        return false;
    }

    public static boolean canResolveUploadIntent(Context context) {
        return a(context, new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(a(context)).setType("video/*"));
    }

    public static boolean canResolveUserIntent(Context context) {
        return a(context, Uri.parse("https://www.youtube.com/user/"));
    }

    public static Intent createChannelIntent(Context context, String str) {
        String strValueOf = String.valueOf(str);
        return b(context, Uri.parse(strValueOf.length() != 0 ? "https://www.youtube.com/channel/".concat(strValueOf) : new String("https://www.youtube.com/channel/")));
    }

    public static Intent createOpenPlaylistIntent(Context context, String str) {
        return a(b(context, a(str)), context);
    }

    public static Intent createPlayPlaylistIntent(Context context, String str) {
        return a(b(context, a(str).buildUpon().appendQueryParameter("playnext", "1").build()), context);
    }

    public static Intent createPlayVideoIntent(Context context, String str) {
        return createPlayVideoIntentWithOptions(context, str, false, false);
    }

    public static Intent createPlayVideoIntentWithOptions(Context context, String str, boolean z, boolean z2) {
        String strValueOf = String.valueOf(str);
        return b(context, Uri.parse(strValueOf.length() != 0 ? "https://www.youtube.com/watch?v=".concat(strValueOf) : new String("https://www.youtube.com/watch?v="))).putExtra("force_fullscreen", z).putExtra("finish_on_ended", z2);
    }

    public static Intent createSearchIntent(Context context, String str) {
        return a(new Intent("android.intent.action.SEARCH").setPackage(a(context)).putExtra(SearchIntents.EXTRA_QUERY, str), context);
    }

    public static Intent createUploadIntent(Context context, Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("videoUri parameter cannot be null.");
        }
        if (uri.toString().startsWith("content://media/")) {
            return a(new Intent("com.google.android.youtube.intent.action.UPLOAD").setPackage(a(context)).setDataAndType(uri, "video/*"), context);
        }
        throw new IllegalArgumentException("videoUri parameter must be a URI pointing to a valid video file. It must begin with \"content://media/\"");
    }

    public static Intent createUserIntent(Context context, String str) {
        String strValueOf = String.valueOf(str);
        return b(context, Uri.parse(strValueOf.length() != 0 ? "https://www.youtube.com/user/".concat(strValueOf) : new String("https://www.youtube.com/user/")));
    }

    public static int getInstalledYouTubeVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String getInstalledYouTubeVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isYouTubeInstalled(Context context) {
        try {
            context.getPackageManager().getApplicationInfo(a(context), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static Uri a(String str) {
        String strValueOf = String.valueOf(str);
        return Uri.parse(strValueOf.length() != 0 ? "https://www.youtube.com/playlist?list=".concat(strValueOf) : new String("https://www.youtube.com/playlist?list="));
    }

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (z.b(packageManager)) {
            return "com.google.android.youtube.tv";
        }
        return z.a(packageManager) ? "com.google.android.youtube.googletv" : "com.google.android.youtube";
    }

    private static boolean a(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) ? false : true;
    }

    private static boolean a(Context context, Uri uri) {
        return a(context, new Intent("android.intent.action.VIEW", uri).setPackage(a(context)));
    }
}
