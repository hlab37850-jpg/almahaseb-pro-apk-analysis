package defpackage;

import android.R;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class IU extends DialogFragment {
    public TimePickerDialog.OnTimeSetListener g;
    public int h;
    public int i;

    private boolean b(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= i && i3 <= i2;
    }

    private boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("samsung") && b(21, 22);
    }

    public void f(TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        this.g = onTimeSetListener;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        getActivity();
        if (d()) {
            new ContextThemeWrapper(getActivity(), R.style.Theme.Holo.Light.Dialog);
        }
        Calendar.getInstance();
        return new TimePickerDialog(getActivity(), this.g, this.h, this.i, DateFormat.is24HourFormat(getActivity()));
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.h = bundle.getInt("hour");
        this.i = bundle.getInt("minute");
    }
}
