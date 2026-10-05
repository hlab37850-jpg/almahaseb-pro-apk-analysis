package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import androidx.documentfile.provider.DocumentFile;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: renamed from: g10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2242g10 {
    public static String a = "application/x-sqlite3";

    public static void a(Context context) {
        try {
            Z00 z00 = new Z00(C1898ci.c(context).getWritableDatabase(), context);
            if (new C3966tX().i(z00.ia("prefBackup_path", Z00.L), z00)) {
                z00.he();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean b(Context context) {
        try {
            return new C3966tX().k(new Z00(C1898ci.c(context).getWritableDatabase(), context));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context, String str, String str2, String str3) {
        DocumentFile documentFileCreateFile;
        try {
            Log.d("package_name=", context.getPackageName() + ":" + context.getApplicationContext().getPackageName());
            a(context);
            Z00.L = h(context, "prefBackup_path", Z00.L);
            File file = new File(Z00.L);
            file.mkdirs();
            File dataDirectory = Environment.getDataDirectory();
            if (!file.canWrite() && !g(Z00.L) && !b(context)) {
                return false;
            }
            String path = "//data//" + str3 + "//databases//" + str;
            Log.d("huawei=", "DB Path 0#" + path + ":" + new File(dataDirectory, path).exists());
            if (!new File(dataDirectory, path).exists()) {
                Log.d("huawei=", "DB Path 1#" + path);
                path = context.getDatabasePath(str).getPath();
                Log.d("huawei=", "DB Path 2#" + path + ":" + new File(path).exists());
            }
            File file2 = new File(dataDirectory, path);
            Log.d("huawei=", "DB Path 3#" + file2.exists() + ":" + file2.getPath());
            if (!file2.exists()) {
                file2 = new File(path);
                Log.d("huawei=", "DB Path 4#" + file2.exists() + ":" + file2.getPath());
            }
            if ((!file.canWrite() || !g(Z00.L)) && !h(context, "app_path_uri", "").equals("")) {
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(context, Uri.parse(h(context, "app_path_uri", "")));
                if (documentFileFromTreeUri.canWrite()) {
                    DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile(str2);
                    if (documentFileFindFile == null) {
                        documentFileCreateFile = documentFileFromTreeUri.createFile(a, str2);
                    } else {
                        documentFileFindFile.renameTo(str2.replace("." + MimeTypeMap.getFileExtensionFromUrl(documentFileFindFile.getUri().toString()), "") + "_Old_" + C3966tX.J(documentFileFindFile.lastModified()) + ".db");
                        documentFileCreateFile = documentFileFromTreeUri.createFile(a, str2);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(context.getContentResolver().openFileDescriptor(documentFileCreateFile.getUri(), "w").getFileDescriptor());
                    FileChannel channel = new FileInputStream(file2).getChannel();
                    FileChannel channel2 = fileOutputStream.getChannel();
                    channel2.transferFrom(channel, 0L, channel.size());
                    channel.close();
                    channel2.close();
                    return true;
                }
            }
            if (!file.canWrite()) {
                Toast.makeText(context, context.getString(R.string.error) + ":Error2", 1).show();
                return false;
            }
            File file3 = new File(file, str2);
            FileChannel channel3 = new FileInputStream(file2).getChannel();
            FileChannel channel4 = new FileOutputStream(file3).getChannel();
            channel4.transferFrom(channel3, 0L, channel3.size());
            channel3.close();
            channel4.close();
            return true;
        } catch (Exception e) {
            Toast.makeText(context, context.getString(R.string.error) + e.getMessage(), 1).show();
            Log.d("Backup Failed!:", e.getMessage());
            return false;
        }
    }

    public static void d(Context context, String str, String str2, String str3, String str4) {
        DocumentFile documentFileCreateFile;
        try {
            File file = new File(str);
            a(context);
            file.mkdirs();
            File dataDirectory = Environment.getDataDirectory();
            if (!file.canWrite() && !g(str) && !b(context)) {
                return;
            }
            String path = "//data//" + str4 + "//databases//" + str2;
            if (!new File(dataDirectory, path).exists()) {
                path = context.getDatabasePath(str2).getPath();
            }
            File file2 = new File(dataDirectory, path);
            if (!file2.exists()) {
                file2 = new File(path);
            }
            if ((!file.canWrite() || !g(str)) && !h(context, "app_path_uri", "").equals("")) {
                Log.d("trace_bk_new=", HTML.Attribute.START);
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(context, Uri.parse(h(context, "app_path_uri", "")));
                Log.d("trace_bk_new=", "check:" + documentFileFromTreeUri.canWrite() + ":" + str3);
                if (documentFileFromTreeUri.canWrite()) {
                    DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile(str3);
                    if (documentFileFindFile == null) {
                        documentFileCreateFile = documentFileFromTreeUri.createFile(a, str3);
                    } else {
                        documentFileFindFile.renameTo(str3.replace("." + MimeTypeMap.getFileExtensionFromUrl(documentFileFindFile.getUri().toString()), "") + "_Old_" + C3966tX.J(documentFileFindFile.lastModified()) + ".db");
                        documentFileCreateFile = documentFileFromTreeUri.createFile(a, str3);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(context.getContentResolver().openFileDescriptor(documentFileCreateFile.getUri(), "w").getFileDescriptor());
                    FileChannel channel = new FileInputStream(file2).getChannel();
                    FileChannel channel2 = fileOutputStream.getChannel();
                    channel2.transferFrom(channel, 0L, channel.size());
                    channel.close();
                    channel2.close();
                    return;
                }
            }
            if (file.canWrite()) {
                File file3 = new File(file, str3);
                FileChannel channel3 = new FileInputStream(file2).getChannel();
                FileChannel channel4 = new FileOutputStream(file3).getChannel();
                channel4.transferFrom(channel3, 0L, channel3.size());
                channel3.close();
                channel4.close();
            }
        } catch (Exception e) {
            Log.d("Backup Failed!:", e.getMessage() + "");
        }
    }

    public static boolean e(Context context, String str, String str2, String str3) {
        DocumentFile documentFileCreateFile;
        try {
            a(context);
            Z00.L = h(context, "prefBackup_path", Z00.L);
            File file = new File(Z00.L);
            file.mkdirs();
            File dataDirectory = Environment.getDataDirectory();
            if (!file.canWrite() && !g(Z00.L) && !b(context)) {
                return false;
            }
            String path = "//data//" + str3 + "//databases//" + str;
            if (!new File(dataDirectory, path).exists()) {
                path = context.getDatabasePath(str).getPath();
            }
            File file2 = new File(dataDirectory, path);
            if (!file2.exists()) {
                file2 = new File(path);
            }
            if ((!file.canWrite() || !g(Z00.L)) && !h(context, "app_path_uri", "").equals("")) {
                DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(context, Uri.parse(h(context, "app_path_uri", "")));
                if (documentFileFromTreeUri.canWrite()) {
                    DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile(str2);
                    if (documentFileFindFile == null) {
                        documentFileCreateFile = documentFileFromTreeUri.createFile(a, str2);
                    } else {
                        documentFileFindFile.renameTo(str2.replace("." + MimeTypeMap.getFileExtensionFromUrl(documentFileFindFile.getUri().toString()), "") + "_Old_" + C3966tX.J(documentFileFindFile.lastModified()) + ".db");
                        documentFileCreateFile = documentFileFromTreeUri.createFile(a, str2);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(context.getContentResolver().openFileDescriptor(documentFileCreateFile.getUri(), "w").getFileDescriptor());
                    FileChannel channel = new FileInputStream(file2).getChannel();
                    FileChannel channel2 = fileOutputStream.getChannel();
                    channel2.transferFrom(channel, 0L, channel.size());
                    channel.close();
                    channel2.close();
                    return true;
                }
            }
            if (file.canWrite()) {
                File file3 = new File(file, str2);
                FileChannel channel3 = new FileInputStream(file2).getChannel();
                FileChannel channel4 = new FileOutputStream(file3).getChannel();
                channel4.transferFrom(channel3, 0L, channel3.size());
                channel3.close();
                channel4.close();
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int f(Context context, String str, String str2, String str3, String str4) {
        try {
            File file = new File(str2);
            File dataDirectory = Environment.getDataDirectory();
            if (!file.canWrite() && !g(str2) && !b(context)) {
                return 0;
            }
            String path = "//data//" + str4 + "//databases//" + str;
            if (!new File(dataDirectory, path).exists()) {
                path = context.getDatabasePath(str).getPath();
            }
            File file2 = new File(dataDirectory, path);
            File file3 = new File(file, str3);
            if (!file2.exists()) {
                file2 = new File(path);
            }
            Log.d("trace_imp=", "" + file.canWrite() + ":" + g(str2) + ":" + file3.getName());
            FileChannel channel = new FileInputStream(file3).getChannel();
            Log.d("trace_imp=", "trace1");
            FileChannel channel2 = new FileOutputStream(file2).getChannel();
            Log.d("trace_imp=", "trace2");
            channel2.transferFrom(channel, 0L, channel.size());
            channel.close();
            channel2.close();
            Toast.makeText(context, context.getString(R.string.done), 0).show();
            return 0;
        } catch (Exception e) {
            Toast.makeText(context, context.getString(R.string.error) + e.getMessage(), 0).show();
            Log.d("Import Failed:", e.getMessage());
            e.printStackTrace();
            return 1;
        }
    }

    public static boolean g(String str) {
        return str.startsWith(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "");
    }

    public static String h(Context context, String str, String str2) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
