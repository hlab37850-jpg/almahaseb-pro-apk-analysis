package defpackage;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import java.util.StringTokenizer;

/* JADX INFO: renamed from: dE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2018dE implements TextWatcher {
    public EditText a;
    public long d;
    public Thread f;
    public final Handler c = new Handler();
    public boolean e = true;
    public Runnable g = new a();
    public boolean b = false;

    /* JADX INFO: renamed from: dE$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (System.currentTimeMillis() - C2018dE.this.d <= 600) {
            }
            Log.d("Debug_EditTEXT_watcher", "(System.currentTimeMillis()-after)>600 ->  " + (System.currentTimeMillis() - C2018dE.this.d) + " > " + C2018dE.this.a.getText().toString());
            C2018dE.this.c();
            C2018dE.this.f = null;
        }
    }

    public C2018dE(EditText editText) {
        this.a = editText;
    }

    public static String d(String str) {
        String strNextToken;
        if (str.length() <= 3) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        String str2 = "";
        if (stringTokenizer.countTokens() > 1) {
            str = stringTokenizer.nextToken();
            strNextToken = stringTokenizer.nextToken();
        } else {
            strNextToken = "";
        }
        int length = str.length();
        int i = length - 1;
        if (str.charAt(str.length() - 1) == '.') {
            i = length - 2;
            str2 = ".";
        }
        int i2 = 0;
        while (i >= 0) {
            if (i2 == 3) {
                str2 = "," + str2;
                i2 = 0;
            }
            str2 = str.charAt(i) + str2;
            i2++;
            i--;
        }
        if (strNextToken.length() <= 0) {
            return str2;
        }
        return str2 + "." + strNextToken;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.d = System.currentTimeMillis();
        if (this.f == null) {
            Thread thread = new Thread(this.g);
            this.f = thread;
            thread.start();
        }
    }

    public void c() {
        try {
            this.a.removeTextChangedListener(this);
            C1044Xj.a().c(new RunnableC1171Zj(17, this.a, new RunnableC1086Yj()));
            this.a.addTextChangedListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
