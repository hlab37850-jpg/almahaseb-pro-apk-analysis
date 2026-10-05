package defpackage;

import android.util.Patterns;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/* JADX INFO: renamed from: yX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4371yX {
    public static boolean a(EditText editText) {
        String strTrim = editText.getText().toString().trim();
        editText.setError(null);
        if (strTrim.length() != 0) {
            return true;
        }
        editText.setError("required");
        return false;
    }

    public static boolean b(RadioGroup radioGroup) {
        return (radioGroup.getTag() == null || radioGroup.getTag().toString().trim().length() == 0) ? false : true;
    }

    public static boolean c(TextView textView) {
        String strTrim = textView.getText().toString().trim();
        textView.setError(null);
        if (strTrim.length() != 0) {
            return true;
        }
        textView.setError("required");
        return false;
    }

    public static boolean d(String str) {
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    public static boolean e(EditText editText) {
        String strTrim = editText.getText().toString().trim();
        editText.setError(null);
        if (!strTrim.equals(".")) {
            return true;
        }
        editText.setError("required");
        return false;
    }

    public static boolean f(EditText editText) {
        String strTrim = editText.getText().toString().trim();
        editText.setError(null);
        if (!strTrim.equals("0") && !strTrim.equals("0.0")) {
            return true;
        }
        editText.setError("No zero");
        return false;
    }
}
