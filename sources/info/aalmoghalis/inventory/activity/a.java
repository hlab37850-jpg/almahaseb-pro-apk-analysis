package info.aalmoghalis.inventory.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import info.aalmoghalis.inventory.R;

/* JADX INFO: loaded from: classes3.dex */
public class a extends DialogFragment {
    public b a;
    public EditText b = null;
    public String c = null;

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.a$a, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0298a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0298a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a aVar = a.this;
            aVar.a.n(aVar);
        }
    }

    public interface b {
        void n(DialogFragment dialogFragment);
    }

    public static a a(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("cus_name", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.a = (b) activity;
            this.c = getArguments().getString("cus_name");
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.DialogBaseTheme));
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_cat, (ViewGroup) null);
        builder.setView(viewInflate);
        EditText editText = (EditText) viewInflate.findViewById(R.id.field1);
        this.b = editText;
        editText.setText(this.c);
        builder.setTitle(getString(R.string.cat_edit));
        builder.setPositiveButton(R.string.btn_save, new DialogInterfaceOnClickListenerC0298a());
        return builder.create();
    }
}
