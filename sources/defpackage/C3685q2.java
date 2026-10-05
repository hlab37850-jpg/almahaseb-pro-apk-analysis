package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: q2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3685q2 extends AbstractC3604p2 {
    public static final ViewDataBinding.IncludedLayouts H = null;
    public static final SparseIntArray I;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R.id.layout_scroll_content, 1);
        sparseIntArray.put(R.id.spinner_branch, 2);
        sparseIntArray.put(R.id.spinner_environment, 3);
        sparseIntArray.put(R.id.device_email, 4);
        sparseIntArray.put(R.id.layout_device_card, 5);
        sparseIntArray.put(R.id.text_device_name, 6);
        sparseIntArray.put(R.id.text_device_vat, 7);
        sparseIntArray.put(R.id.text_device_icv, 8);
        sparseIntArray.put(R.id.checkbox_auto_send, 9);
        sparseIntArray.put(R.id.button_renew_otp, 10);
        sparseIntArray.put(R.id.button_stop_otp, 11);
        sparseIntArray.put(R.id.layout_registration_form, 12);
        sparseIntArray.put(R.id.input_vat_number, 13);
        sparseIntArray.put(R.id.input_cr_number, 14);
        sparseIntArray.put(R.id.input_common_name, 15);
        sparseIntArray.put(R.id.input_organization_name, 16);
        sparseIntArray.put(R.id.input_branch_name, 17);
        sparseIntArray.put(R.id.input_country_code, 18);
        sparseIntArray.put(R.id.input_building_number, 19);
        sparseIntArray.put(R.id.input_street_name, 20);
        sparseIntArray.put(R.id.input_district, 21);
        sparseIntArray.put(R.id.input_postal_code, 22);
        sparseIntArray.put(R.id.input_city, 23);
        sparseIntArray.put(R.id.input_business_category, 24);
        sparseIntArray.put(R.id.input_otp, 25);
        sparseIntArray.put(R.id.layout_registration_actions, 26);
        sparseIntArray.put(R.id.button_save, 27);
    }

    public C3685q2(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, H, I));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.G = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.G != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.G = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    public C3685q2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[10], (Button) objArr[27], (Button) objArr[11], (CheckBox) objArr[9], (TextView) objArr[4], (EditText) objArr[17], (EditText) objArr[19], (EditText) objArr[24], (EditText) objArr[23], (EditText) objArr[15], (EditText) objArr[18], (EditText) objArr[14], (EditText) objArr[21], (EditText) objArr[16], (EditText) objArr[25], (EditText) objArr[22], (EditText) objArr[20], (EditText) objArr[13], (LinearLayout) objArr[5], (LinearLayout) objArr[26], (LinearLayout) objArr[12], (LinearLayout) objArr[1], (ScrollView) objArr[0], (Spinner) objArr[2], (Spinner) objArr[3], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[7]);
        this.G = -1L;
        this.A.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
