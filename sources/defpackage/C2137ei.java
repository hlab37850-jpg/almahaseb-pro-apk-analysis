package defpackage;

import android.R;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

/* JADX INFO: renamed from: ei, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2137ei extends DialogFragment {
    public DatePickerDialog.OnDateSetListener g;
    public int h;
    public int i;
    public int j;

    private boolean b(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && b(21, 22);
    }

    public void f(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.g = onDateSetListener;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context activity = getActivity();
        if (d()) {
            activity = new ContextThemeWrapper(getActivity(), R.style.Theme.Holo.Light.Dialog);
        }
        Context context = activity;
        Calendar calendar = Calendar.getInstance();
        return new DatePickerDialog(context, this.g, calendar.get(1), calendar.get(2), calendar.get(5));
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.h = bundle.getInt("year");
        this.i = bundle.getInt("month");
        this.j = bundle.getInt("day");
    }
}
