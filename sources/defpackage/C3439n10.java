package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.itextpdf.text.pdf.PdfObject;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.helper.Approval_add;
import info.aalmoghalis.inventory.helper.Auto_sms_add;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: n10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3439n10 {

    /* JADX INFO: renamed from: n10$a */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ Z00 c;
        public final /* synthetic */ LinearLayout d;
        public final /* synthetic */ String[] e;

        public a(Activity activity, EditText editText, Z00 z00, LinearLayout linearLayout, String[] strArr) {
            this.a = activity;
            this.b = editText;
            this.c = z00;
            this.d = linearLayout;
            this.e = strArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = ((Button) view).getText().toString();
            String str = "{" + string + "}";
            if ((this.a instanceof Approval_add) && (string.equals("واتساب") || string.equals(PdfObject.TEXT_PDFDOCENCODING))) {
                ((Approval_add) this.a).x(view);
                return;
            }
            C3439n10 c3439n10 = C3439n10.this;
            Activity activity = this.a;
            EditText editText = this.b;
            if (c3439n10.b(activity, editText, editText.getSelectionStart(), string)) {
                C3439n10.this.d(this.a, this.c, this.d, this.b, this.e);
                return;
            }
            if (this.b.getSelectionStart() > 0) {
                C3439n10 c3439n11 = C3439n10.this;
                Activity activity2 = this.a;
                EditText editText2 = this.b;
                if (!c3439n11.b(activity2, editText2, editText2.getSelectionStart(), string)) {
                    this.b.getText().insert(this.b.getSelectionStart(), str);
                    C3439n10 c3439n12 = C3439n10.this;
                    EditText editText3 = this.b;
                    c3439n12.g(editText3, c3439n12.f(editText3.getText().toString()));
                    C3439n10.this.d(this.a, this.c, this.d, this.b, this.e);
                    return;
                }
            }
            Activity activity3 = this.a;
            Toast.makeText(activity3, activity3.getString(R.string.approval_hint), 1).show();
        }
    }

    /* JADX INFO: renamed from: n10$b */
    public class b implements View.OnLongClickListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Button b;

        public b(Activity activity, Button button) {
            this.a = activity;
            this.b = button;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.a instanceof Approval_add) {
                Button button = (Button) view;
                if (button.getText().toString().equals("واتساب") || button.getText().toString().equals(PdfObject.TEXT_PDFDOCENCODING)) {
                    ((Approval_add) this.a).x(view);
                    return true;
                }
            }
            view.startDrag(ClipData.newPlainText("ButtonText", this.b.getText()), new View.DragShadowBuilder(view), view, 0);
            return true;
        }
    }

    /* JADX INFO: renamed from: n10$c */
    public class c implements View.OnDragListener {
        public final /* synthetic */ Z00 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ LinearLayout d;
        public final /* synthetic */ String[] e;

        public c(Z00 z00, Activity activity, EditText editText, LinearLayout linearLayout, String[] strArr) {
            this.a = z00;
            this.b = activity;
            this.c = editText;
            this.d = linearLayout;
            this.e = strArr;
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            if (dragEvent.getAction() != 3) {
                return false;
            }
            ClipData.Item itemAt = dragEvent.getClipData().getItemAt(0);
            String str = "{" + itemAt.getText().toString() + "}";
            if (itemAt.getText().toString().equals("واتساب") || itemAt.getText().toString().equals(PdfObject.TEXT_PDFDOCENCODING)) {
                Z00 z00 = this.a;
                z00.Mc("approval_wa", !z00.ja("approval_wa", true));
                ((Button) view).setText(this.a.ja("approval_wa", true) ? "واتساب" : PdfObject.TEXT_PDFDOCENCODING);
                Toast.makeText(this.b, this.a.ja("approval_wa", true) ? this.b.getString(R.string.approval_wa) : this.b.getString(R.string.approval_file), 0).show();
                return true;
            }
            C3439n10 c3439n10 = C3439n10.this;
            Activity activity = this.b;
            EditText editText = this.c;
            if (!c3439n10.b(activity, editText, editText.getSelectionStart(), itemAt.getText().toString())) {
                this.c.getText().insert(this.c.getSelectionStart(), str);
                C3439n10 c3439n11 = C3439n10.this;
                EditText editText2 = this.c;
                c3439n11.g(editText2, c3439n11.f(editText2.getText().toString()));
                C3439n10.this.d(this.b, this.a, this.d, this.c, this.e);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: n10$d */
    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public d(EditText editText, int i, int i2, String str) {
            this.a = editText;
            this.b = i;
            this.c = i2;
            this.d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.getText().delete(this.b, this.c + 1);
            this.a.getText().insert(this.a.getSelectionStart(), "{" + this.d + "}");
            C3439n10 c3439n10 = C3439n10.this;
            EditText editText = this.a;
            c3439n10.g(editText, c3439n10.f(editText.getText().toString()));
        }
    }

    public boolean a(Activity activity, EditText editText, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        String string = editText.getText().toString();
        if (string.length() == 0) {
            return false;
        }
        Matcher matcher = Pattern.compile("\\{(\\w+)\\}").matcher(string);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            arrayList.add(strGroup);
            boolean z2 = false;
            for (String str : strArr) {
                if (str.equals(strGroup)) {
                    z2 = true;
                }
            }
            if (!z2) {
                Toast.makeText(activity, strGroup, 1).show();
                return z2;
            }
            z = z2;
        }
        if (z) {
            string = string.replace("{سطرجديد}", StringUtilities.LF);
            for (String str2 : string.split(StringUtilities.LF)) {
                int length = strArr4.length;
                int i = 0;
                while (i < length) {
                    String str3 = string;
                    Matcher matcher2 = Pattern.compile("\\{(\\ccc+)\\}".replace("ccc", strArr4[i])).matcher(str2);
                    int i2 = 0;
                    while (matcher2.find()) {
                        Matcher matcher3 = matcher2;
                        int i3 = i2 + 1;
                        if (i3 > 1) {
                            Toast.makeText(activity, str2 + ":" + i3, 1).show();
                            return false;
                        }
                        i2 = i3;
                        matcher2 = matcher3;
                    }
                    i++;
                    string = str3;
                    strArr4 = strArr4;
                }
            }
        }
        if (z) {
            for (String str4 : strArr3) {
                Matcher matcher4 = Pattern.compile("\\{(\\ccc+)\\}".replace("ccc", str4)).matcher(string);
                int i4 = 0;
                while (matcher4.find()) {
                    i4++;
                    if (i4 > 1) {
                        Toast.makeText(activity, matcher4.group(1) + ":" + i4, 1).show();
                        return false;
                    }
                }
            }
        }
        boolean zT = false;
        if (!z) {
            return z;
        }
        for (String str5 : strArr2) {
            zT = new C2160f10().t((String[]) arrayList.toArray(new String[arrayList.size()]), str5);
            if (!zT) {
                Toast.makeText(activity, str5, 1).show();
                return zT;
            }
        }
        return zT;
    }

    public boolean b(Activity activity, EditText editText, int i, String str) {
        boolean z = false;
        try {
            int iIndexOf = editText.getText().toString().indexOf("}", i);
            int i2 = 0;
            for (int i3 = 0; i3 < iIndexOf; i3++) {
                int iLastIndexOf = editText.getText().toString().lastIndexOf("{", i3);
                if (iLastIndexOf < iIndexOf) {
                    i2 = iLastIndexOf;
                }
            }
            String strSubstring = "";
            Log.d("tag=", "L=" + i2 + ":R=" + iIndexOf + ":S=" + i + ":T=" + str);
            if (i2 >= 0 && iIndexOf > 0) {
                strSubstring = editText.getText().toString().substring(i2 + 1, iIndexOf);
                Log.d("tag=XX:", strSubstring);
            }
            String str2 = strSubstring;
            if (str2.equals(str) && i != 0) {
                try {
                    editText.getText().delete(i2, iIndexOf + 1);
                    z = true;
                    if (i >= i2) {
                        c(activity, editText, i2, iIndexOf, str2, str);
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    e.printStackTrace();
                }
            } else if (i >= i2 && i <= iIndexOf && str2.length() > 0 && !str2.equals(str) && i != 0) {
                c(activity, editText, i2, iIndexOf, str2, str);
                return true;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return z;
    }

    public void c(Activity activity, EditText editText, int i, int i2, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(activity.getString(R.string.replace_item_confirm).replace("{0}", str).replace("{1}", str2));
        builder.setPositiveButton(activity.getString(R.string.confirm_yes), new d(editText, i, i2, str2));
        builder.setNegativeButton(activity.getString(R.string.confirm_no), new e());
        builder.create().show();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    public void d(Activity activity, Z00 z00, LinearLayout linearLayout, EditText editText, String[] strArr) {
        linearLayout.removeAllViews();
        for (String str : strArr) {
            Button button = new Button(activity);
            button.setText(str);
            if (activity instanceof Approval_add) {
                if (str.equals("واتساب")) {
                    button.setText(z00.ja("approval_wa", true) ? "واتساب" : PdfObject.TEXT_PDFDOCENCODING);
                }
            }
            if (editText.getText().toString().contains(button.getText().toString())) {
                button.setBackgroundTintList(ColorStateList.valueOf(activity.getResources().getColor(R.color.gold)));
                button.setTextColor(-1);
            } else {
                button.setBackgroundTintList(ColorStateList.valueOf(activity.getResources().getColor(R.color.gold2)));
                button.setTextColor(-1);
            }
            float f = activity.getResources().getDisplayMetrics().density;
            button.setPadding(0, 0, 0, 0);
            button.setOnClickListener(new a(activity, editText, z00, linearLayout, strArr));
            button.setOnLongClickListener(new b(activity, button));
            linearLayout.addView(button);
        }
        editText.setOnDragListener(new c(z00, activity, editText, linearLayout, strArr));
    }

    public void e(Activity activity, Z00 z00, EditText editText) {
        String strReplace;
        if (activity instanceof Approval_add) {
            strReplace = z00.ia("approval_text", activity.getString(R.string.approval_text));
        } else {
            strReplace = activity instanceof Auto_sms_add ? z00.ia("auto_sms_text", activity.getString(R.string.auto_sms_text)).replace("{0}", activity.getString(R.string.total_prt)) : "";
        }
        editText.setText(f(strReplace));
    }

    public String f(String str) {
        return str.replace("{سطرجديد}", "{سطرجديد}\n").replace("\n\n", StringUtilities.LF);
    }

    public void g(EditText editText, String str) {
        int selectionStart = editText.getSelectionStart();
        editText.setText("");
        editText.append(str);
        if (selectionStart < str.length()) {
            editText.setSelection(selectionStart);
        }
    }

    /* JADX INFO: renamed from: n10$e */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
