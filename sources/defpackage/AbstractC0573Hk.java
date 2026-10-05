package defpackage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: Hk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC0573Hk {

    /* JADX INFO: renamed from: Hk$a */
    public static class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String[] c;

        public a(c cVar, int i, String[] strArr) {
            this.a = cVar;
            this.b = i;
            this.c = strArr;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.b(this.b, Arrays.asList(this.c));
        }
    }

    /* JADX INFO: renamed from: Hk$b */
    public static class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Object a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ int c;

        public b(Object obj, String[] strArr, int i) {
            this.a = obj;
            this.b = strArr;
            this.c = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractC0573Hk.c(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: renamed from: Hk$c */
    public interface c extends ActivityCompat.OnRequestPermissionsResultCallback {
        void b(int i, List list);

        void i(int i, List list);
    }

    public static void b(Object obj) {
        if (!(obj instanceof Fragment) && !(obj instanceof Activity)) {
            throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }
        if (!(obj instanceof c)) {
            throw new IllegalArgumentException("Caller must implement PermissionCallbacks.");
        }
    }

    public static void c(Object obj, String[] strArr, int i) {
        b(obj);
        if (obj instanceof Activity) {
            ActivityCompat.requestPermissions((Activity) obj, strArr, i);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).requestPermissions(strArr, i);
        }
    }

    public static Activity d(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).getActivity();
        }
        return null;
    }

    public static boolean e(Context context, String... strArr) {
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void f(int i, String[] strArr, int[] iArr, Object obj) {
        b(obj);
        c cVar = (c) obj;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] == 0) {
                arrayList.add(str);
            } else {
                arrayList2.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            cVar.i(i, arrayList);
        }
        if (!arrayList2.isEmpty()) {
            cVar.b(i, arrayList2);
        }
        if (arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return;
        }
        i(obj, i);
    }

    public static void g(Object obj, String str, int i, int i2, int i3, String... strArr) {
        b(obj);
        c cVar = (c) obj;
        boolean z = false;
        for (String str2 : strArr) {
            z = z || j(obj, str2);
        }
        if (z) {
            new AlertDialog.Builder(d(obj)).setMessage(str).setPositiveButton(i, new b(obj, strArr, i3)).setNegativeButton(i2, new a(cVar, i3, strArr)).create().show();
        } else {
            c(obj, strArr, i3);
        }
    }

    public static void h(Object obj, String str, int i, String... strArr) {
        g(obj, str, R.string.ok, R.string.cancel, i, strArr);
    }

    public static void i(Object obj, int i) {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(InterfaceC4008u2.class) && ((InterfaceC4008u2) method.getAnnotation(InterfaceC4008u2.class)).value() == i) {
                if (method.getParameterTypes().length > 0) {
                    String strValueOf = String.valueOf(method.getName());
                    throw new RuntimeException(strValueOf.length() != 0 ? "Cannot execute non-void method ".concat(strValueOf) : new String("Cannot execute non-void method "));
                }
                try {
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    method.invoke(obj, new Object[0]);
                } catch (IllegalAccessException e) {
                    Log.e("EasyPermissions", "runDefaultMethod:IllegalAccessException", e);
                } catch (InvocationTargetException e2) {
                    Log.e("EasyPermissions", "runDefaultMethod:InvocationTargetException", e2);
                }
            }
        }
    }

    public static boolean j(Object obj, String str) {
        if (obj instanceof Activity) {
            return ActivityCompat.shouldShowRequestPermissionRationale((Activity) obj, str);
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
