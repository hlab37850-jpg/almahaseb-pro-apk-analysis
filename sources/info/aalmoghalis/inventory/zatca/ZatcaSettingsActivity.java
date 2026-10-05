package info.aalmoghalis.inventory.zatca;

import android.R;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import defpackage.AbstractC3604p2;
import defpackage.Z00;
import info.aalmoghalis.inventory.activity.Google_drive_list;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class ZatcaSettingsActivity extends BaseActivity {
    public AbstractC3604p2 c;
    public final List d = new ArrayList();
    public final List e = new ArrayList();
    public final List f = Arrays.asList(new h("2", "Compliance"), new h("1", "Simulation"));
    public info.aalmoghalis.inventory.zatca.e g;
    public Integer h;
    public info.aalmoghalis.inventory.zatca.e.g i;
    public boolean j;
    public SQLiteDatabase k;
    public Z00 l;

    public class a implements AdapterView.OnItemSelectedListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            ZatcaSettingsActivity.this.k0();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
            ZatcaSettingsActivity.this.Y();
        }
    }

    public class b implements info.aalmoghalis.inventory.zatca.e.f {
        public b() {
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            ZatcaSettingsActivity.this.d.clear();
            ZatcaSettingsActivity.this.d.addAll(list);
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            ArrayAdapter arrayAdapter = new ArrayAdapter(zatcaSettingsActivity, R.layout.simple_spinner_item, zatcaSettingsActivity.R(list));
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            ZatcaSettingsActivity.this.c.B.setAdapter((SpinnerAdapter) arrayAdapter);
            if (ZatcaSettingsActivity.this.d.isEmpty()) {
                ZatcaSettingsActivity.this.Y();
                ZatcaSettingsActivity.this.A0("No branches found");
            } else {
                ZatcaSettingsActivity.this.c.B.setSelection(0, false);
                ZatcaSettingsActivity.this.k0();
            }
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        public void onError(String str) {
            ZatcaSettingsActivity.this.Y();
            ZatcaSettingsActivity.this.A0(str);
        }
    }

    public class c implements info.aalmoghalis.inventory.zatca.e.f {
        public c() {
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(info.aalmoghalis.inventory.zatca.e.g gVar) {
            ZatcaSettingsActivity.this.x0(gVar);
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        public void onError(String str) {
            Log.d("zatca=", "Error:" + str);
            if ("DEVICE_NOT_FOUND".equals(str)) {
                ZatcaSettingsActivity.this.y0();
            } else {
                ZatcaSettingsActivity.this.Y();
                ZatcaSettingsActivity.this.A0(str);
            }
        }
    }

    public class d implements info.aalmoghalis.inventory.zatca.e.f {
        public d() {
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r3) {
            ZatcaSettingsActivity.this.A0("Auto Send to Zatca saved");
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.d, true);
            ZatcaSettingsActivity.this.k0();
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        public void onError(String str) {
            ZatcaSettingsActivity.this.A0(str);
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.d, true);
            ZatcaSettingsActivity.this.k0();
        }
    }

    public class e implements info.aalmoghalis.inventory.zatca.e.f {
        public e() {
        }

        public final /* synthetic */ void b() {
            ZatcaSettingsActivity.this.c.A.smoothScrollTo(0, 0);
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(info.aalmoghalis.inventory.zatca.e.g gVar) {
            ZatcaSettingsActivity.this.A0("Device registered successfully");
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.b, true);
            ZatcaSettingsActivity.this.l.x9(ZatcaSettingsActivity.this.c.q);
            ZatcaSettingsActivity.this.c.A.postDelayed(new Runnable() { // from class: p00
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            }, 300L);
            ZatcaSettingsActivity.this.k0();
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        public void onError(String str) {
            ZatcaSettingsActivity.this.A0(info.aalmoghalis.inventory.zatca.d.B(str));
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.b, true);
        }
    }

    public class f implements info.aalmoghalis.inventory.zatca.e.f {
        public final /* synthetic */ AlertDialog a;

        public f(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(info.aalmoghalis.inventory.zatca.e.g gVar) {
            ZatcaSettingsActivity.this.A0("OTP renewed successfully");
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.a, true);
            this.a.dismiss();
            ZatcaSettingsActivity.this.k0();
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        public void onError(String str) {
            ZatcaSettingsActivity.this.A0(info.aalmoghalis.inventory.zatca.d.B(str));
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.a, true);
        }
    }

    public class g implements info.aalmoghalis.inventory.zatca.e.f {
        public g() {
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(info.aalmoghalis.inventory.zatca.e.g gVar) {
            ZatcaSettingsActivity.this.A0("OTP stopped successfully");
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.c, true);
            ZatcaSettingsActivity.this.k0();
        }

        @Override // info.aalmoghalis.inventory.zatca.e.f
        public void onError(String str) {
            ZatcaSettingsActivity.this.A0(info.aalmoghalis.inventory.zatca.d.B(str));
            ZatcaSettingsActivity zatcaSettingsActivity = ZatcaSettingsActivity.this;
            zatcaSettingsActivity.s0(zatcaSettingsActivity.c.c, true);
        }
    }

    public static class h {
        public final String a;
        public final String b;

        public h(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public static class i implements InputFilter {
        public i() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            StringBuilder sb = new StringBuilder();
            while (i < i2) {
                char cCharAt = charSequence.charAt(i);
                if (!Character.isWhitespace(cCharAt)) {
                    sb.append(cCharAt);
                }
                i++;
            }
            return sb.toString();
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public final void A0(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public final void B0(View view) {
        int iMax = Math.max(16, this.c.A.getHeight() - view.getHeight());
        LinearLayout linearLayout = this.c.z;
        linearLayout.setPadding(linearLayout.getPaddingLeft(), this.c.z.getPaddingTop(), this.c.z.getPaddingRight(), iMax);
    }

    public final info.aalmoghalis.inventory.zatca.e.h C0() {
        Q();
        info.aalmoghalis.inventory.zatca.e.C0323e c0323eV = V();
        h hVarW = W();
        if (c0323eV == null || hVarW == null) {
            A0("Please select branch/user and environment");
            return null;
        }
        String strN0 = n0(this.c.v, false, 0);
        String strN1 = n0(this.c.l, false, 0);
        String strO0 = o0(this.c.j);
        String strO1 = o0(this.c.p);
        String strO2 = o0(this.c.f);
        String strO3 = o0(this.c.k);
        String strN2 = n0(this.c.g, true, 4);
        String strO4 = o0(this.c.u);
        String strO5 = o0(this.c.n);
        String strN3 = n0(this.c.t, true, 5);
        String strO6 = o0(this.c.i);
        String strO7 = o0(this.c.h);
        String strN4 = n0(this.c.q, false, 0);
        if (strN0 == null || strN1 == null || strO0 == null || strO1 == null || strO2 == null || strO3 == null || strN2 == null || strO4 == null || strO5 == null || strN3 == null || strO6 == null || strO7 == null || strN4 == null) {
            return null;
        }
        info.aalmoghalis.inventory.zatca.e.h hVar = new info.aalmoghalis.inventory.zatca.e.h();
        hVar.a = c0323eV.a;
        hVar.b = hVarW.a;
        hVar.c = strN0;
        hVar.d = strN1;
        hVar.e = strO0;
        hVar.f = strO1;
        hVar.g = strO2;
        hVar.h = strO3.toUpperCase(Locale.US);
        hVar.i = strO7;
        hVar.j = strN4;
        info.aalmoghalis.inventory.zatca.e.d dVar = new info.aalmoghalis.inventory.zatca.e.d();
        hVar.l = dVar;
        dVar.a = strN2;
        dVar.b = strO4;
        dVar.c = strO5;
        dVar.d = strN3;
        dVar.e = strO6;
        hVar.k = S(hVar);
        hVar.n = Z00.T;
        return hVar;
    }

    public final String D0(String str) {
        return str == null ? "" : str;
    }

    public final String P(EditText editText) {
        return editText.getText() == null ? "" : editText.getText().toString().trim();
    }

    public final void Q() {
        Iterator it = U().iterator();
        while (it.hasNext()) {
            ((EditText) it.next()).setError(null);
        }
    }

    public final List R(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((info.aalmoghalis.inventory.zatca.e.C0323e) it.next()).b);
        }
        return arrayList;
    }

    public String S(info.aalmoghalis.inventory.zatca.e.h hVar) {
        return "1-" + (hVar.b == "0" ? "PRO" : "TST") + "|2-" + hVar.g + "|3-" + UUID.randomUUID();
    }

    public final List T() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) it.next()).b);
        }
        return arrayList;
    }

    public final List U() {
        AbstractC3604p2 abstractC3604p2 = this.c;
        return Arrays.asList(abstractC3604p2.v, abstractC3604p2.l, abstractC3604p2.j, abstractC3604p2.p, abstractC3604p2.f, abstractC3604p2.k, abstractC3604p2.g, abstractC3604p2.u, abstractC3604p2.n, abstractC3604p2.t, abstractC3604p2.i, abstractC3604p2.h, abstractC3604p2.q);
    }

    public final info.aalmoghalis.inventory.zatca.e.C0323e V() {
        int selectedItemPosition = this.c.B.getSelectedItemPosition();
        if (selectedItemPosition < 0 || selectedItemPosition >= this.d.size()) {
            return null;
        }
        return (info.aalmoghalis.inventory.zatca.e.C0323e) this.d.get(selectedItemPosition);
    }

    public final h W() {
        int selectedItemPosition = this.c.C.getSelectedItemPosition();
        if (selectedItemPosition < 0 || selectedItemPosition >= this.f.size()) {
            return null;
        }
        return (h) this.f.get(selectedItemPosition);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        r4 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int X(android.view.View r4) {
        /*
            r3 = this;
            int r0 = r4.getTop()
            android.view.ViewParent r1 = r4.getParent()
            boolean r1 = r1 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto L14
            android.view.ViewParent r4 = r4.getParent()
            android.view.View r4 = (android.view.View) r4
            goto L15
        L14:
            r4 = r2
        L15:
            if (r4 == 0) goto L31
            p2 r1 = r3.c
            android.widget.LinearLayout r1 = r1.z
            if (r4 == r1) goto L31
            int r1 = r4.getTop()
            int r0 = r0 + r1
            android.view.ViewParent r1 = r4.getParent()
            boolean r1 = r1 instanceof android.view.View
            if (r1 == 0) goto L14
            android.view.ViewParent r4 = r4.getParent()
            android.view.View r4 = (android.view.View) r4
            goto L15
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: info.aalmoghalis.inventory.zatca.ZatcaSettingsActivity.X(android.view.View):int");
    }

    public final void Y() {
        this.h = null;
        this.i = null;
        this.c.w.setVisibility(8);
        this.c.y.setVisibility(8);
        this.c.x.setVisibility(8);
    }

    public final boolean Z(int i2, KeyEvent keyEvent) {
        if (i2 == 5) {
            return true;
        }
        return i2 == 0 && keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 66;
    }

    public final /* synthetic */ void a0(EditText editText, AlertDialog alertDialog, View view) {
        String strP = P(editText);
        if (TextUtils.isEmpty(strP)) {
            editText.setError(getString(info.aalmoghalis.inventory.R.string.error_required));
        } else {
            s0(this.c.a, false);
            this.g.I(this.i.a, strP, new f(alertDialog));
        }
    }

    public final /* synthetic */ void b0(View view) {
        B0(view);
        r0(view, false);
        r0(view, true);
    }

    public final /* synthetic */ void c0(View view) {
        if (view.hasFocus()) {
            this.c.A.smoothScrollTo(0, Math.max(0, X(view)));
        }
    }

    public final /* synthetic */ void d0(CompoundButton compoundButton, boolean z) {
        if (this.j || this.h == null) {
            return;
        }
        p0(z);
    }

    public final /* synthetic */ void e0(View view) {
        l0();
    }

    public final /* synthetic */ void f0(View view) {
        m0();
    }

    public final /* synthetic */ void g0(View view) {
        z0();
    }

    public final /* synthetic */ void h0(View view, boolean z) {
        if (z) {
            q0(view);
        }
    }

    public final /* synthetic */ boolean i0(EditText editText, TextView textView, int i2, KeyEvent keyEvent) {
        if (editText == null || !Z(i2, keyEvent)) {
            return false;
        }
        editText.requestFocus();
        return true;
    }

    public final void j0() {
        this.g.s(new b());
    }

    public final void k0() {
        info.aalmoghalis.inventory.zatca.e.C0323e c0323eV = V();
        h hVarW = W();
        if (c0323eV == null || hVarW == null) {
            Y();
        } else {
            this.g.t(c0323eV.a, hVarW.a, new c());
        }
    }

    public final void l0() {
        info.aalmoghalis.inventory.zatca.e.h hVarC0 = C0();
        if (hVarC0 == null) {
            return;
        }
        hVarC0.n = Z00.T;
        s0(this.c.b, false);
        this.g.H(hVarC0, hVarC0.m, new e());
    }

    public final void m0() {
        if (this.i == null) {
            return;
        }
        final EditText editText = new EditText(this);
        editText.setHint(getString(info.aalmoghalis.inventory.R.string.hint_otp));
        editText.setInputType(2);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(info.aalmoghalis.inventory.R.string.title_renew_otp).setView(editText).setPositiveButton(info.aalmoghalis.inventory.R.string.action_renew, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
        alertDialogCreate.show();
        alertDialogCreate.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: n00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a0(editText, alertDialogCreate, view);
            }
        });
    }

    public final String n0(EditText editText, boolean z, int i2) {
        String strReplaceAll = P(editText).replaceAll("\\D", "");
        if (TextUtils.isEmpty(strReplaceAll)) {
            editText.setError(getString(info.aalmoghalis.inventory.R.string.error_required));
            return null;
        }
        if (z && strReplaceAll.length() != i2) {
            editText.setError(getString(info.aalmoghalis.inventory.R.string.error_digits_length, Integer.valueOf(i2)));
            return null;
        }
        if (!TextUtils.isDigitsOnly(strReplaceAll)) {
            editText.setError(getString(info.aalmoghalis.inventory.R.string.error_digits_only));
            return null;
        }
        editText.setText(strReplaceAll);
        editText.setSelection(strReplaceAll.length());
        return strReplaceAll;
    }

    public final String o0(EditText editText) {
        String strP = P(editText);
        if (!TextUtils.isEmpty(strP)) {
            return strP;
        }
        editText.setError(getString(info.aalmoghalis.inventory.R.string.error_required));
        return null;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = (AbstractC3604p2) DataBindingUtil.setContentView(this, info.aalmoghalis.inventory.R.layout.activity_zatca_settings);
        this.l = new Z00(this.k, getApplicationContext());
        this.g = new info.aalmoghalis.inventory.zatca.e(getApplicationContext(), this.l);
        Z00.T = this.l.ia("PREF_ACCOUNT_NAME", "");
        u0();
        t0();
        v0();
        j0();
        if (this.l.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
            Intent intent = new Intent(this, (Class<?>) Google_drive_list.class);
            intent.putExtra("change_email_flag", "1");
            finish();
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public final void p0(boolean z) {
        s0(this.c.d, false);
        this.g.K(this.h.intValue(), z, new d());
    }

    public final void q0(final View view) {
        view.post(new Runnable() { // from class: m00
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b0(view);
            }
        });
    }

    public final void r0(final View view, boolean z) {
        this.c.A.postDelayed(new Runnable() { // from class: o00
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c0(view);
            }
        }, z ? 300L : 0L);
    }

    public final void s0(View view, boolean z) {
        view.setEnabled(z);
        view.setAlpha(z ? 1.0f : 0.6f);
    }

    public final void t0() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, T());
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.c.C.setAdapter((SpinnerAdapter) arrayAdapter);
        this.c.C.setSelection(0, false);
    }

    public final void u0() {
        i iVar = new i(null);
        this.c.v.setInputType(2);
        this.c.l.setInputType(2);
        this.c.g.setInputType(2);
        this.c.t.setInputType(2);
        this.c.q.setInputType(2);
        this.c.k.setText("SA");
        this.c.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2), iVar});
        this.c.h.setFilters(new InputFilter[]{iVar});
        this.c.g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        this.c.t.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        w0();
    }

    public final void v0() {
        a aVar = new a();
        this.c.B.setOnItemSelectedListener(aVar);
        this.c.C.setOnItemSelectedListener(aVar);
        this.c.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i00
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.d0(compoundButton, z);
            }
        });
        this.c.b.setOnClickListener(new View.OnClickListener() { // from class: j00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.e0(view);
            }
        });
        this.c.a.setOnClickListener(new View.OnClickListener() { // from class: k00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f0(view);
            }
        });
        this.c.c.setOnClickListener(new View.OnClickListener() { // from class: l00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.g0(view);
            }
        });
    }

    public final void w0() {
        List listU = U();
        int i2 = 0;
        while (i2 < listU.size()) {
            EditText editText = (EditText) listU.get(i2);
            final EditText editText2 = i2 < listU.size() - 1 ? (EditText) listU.get(i2 + 1) : null;
            editText.setSingleLine(true);
            editText.setImeOptions(editText2 == null ? 6 : 5);
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: g00
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    this.a.h0(view, z);
                }
            });
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: h00
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                    return this.a.i0(editText2, textView, i3, keyEvent);
                }
            });
            i2++;
        }
    }

    public final void x0(info.aalmoghalis.inventory.zatca.e.g gVar) {
        this.h = Integer.valueOf(gVar.a);
        this.i = gVar;
        this.c.E.setText(D0(gVar.f) + " " + D0(gVar.e));
        this.c.F.setText(gVar.g);
        this.c.D.setText(String.valueOf(gVar.j));
        this.j = true;
        this.c.d.setChecked(gVar.k);
        this.j = false;
        this.c.y.setVisibility(8);
        this.c.x.setVisibility(8);
        this.c.w.setVisibility(0);
        this.c.e.setText(Z00.T);
    }

    public final void y0() {
        this.h = null;
        this.i = null;
        this.c.w.setVisibility(8);
        this.c.y.setVisibility(0);
        this.c.x.setVisibility(0);
    }

    public final void z0() {
        if (this.i == null) {
            return;
        }
        s0(this.c.c, false);
        this.g.J(this.i.a, new g());
    }
}
