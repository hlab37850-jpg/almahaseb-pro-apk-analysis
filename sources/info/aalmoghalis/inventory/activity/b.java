package info.aalmoghalis.inventory.activity;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import defpackage.Z00;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b extends DialogFragment implements AdapterView.OnItemClickListener {
    public final String a = "◀";
    public d b;
    public ArrayList c;
    public String d;
    public TextView e;
    public EditText f;
    public TextView g;
    public ListView h;
    public File i;
    public int j;
    public int k;
    public int l;
    public int n;
    public int p;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.b$b, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0299b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0299b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            b.this.b.f(null, null);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String absolutePath = b.this.i.getAbsolutePath();
            String string = b.this.f.getText().toString();
            if (b.this.b.h(absolutePath, string)) {
                b.this.dismiss();
                b.this.b.f(absolutePath, string);
            }
        }
    }

    public interface d {
        void f(String str, String str2);

        boolean h(String str, String str2);
    }

    public class e extends ArrayAdapter {
        public e(Context context, List list) {
            super(context, R.layout.simple_list_item_1, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) super.getView(i, view, viewGroup);
            if (b.this.c.get(i) != null) {
                textView.setText(((File) b.this.c.get(i)).getName());
            }
            return textView;
        }
    }

    public static boolean a(String str, String str2) {
        return new File(str, str2).exists();
    }

    public static boolean b(String str) {
        return !c(str).matches(".*\\W{1,}.*");
    }

    public static String c(String str) {
        return str.contains(".") ? str.split("\\.(?=[^\\.]+$)")[0] : str;
    }

    public static b i(String str, int i, int i2, int i3, int i4, int i5) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("extensionList", str);
        bundle.putInt("captionOK", i);
        bundle.putInt("captionCancel", i2);
        bundle.putInt("popupTitle", i3);
        bundle.putInt("editHint", i4);
        bundle.putInt("popupIcon", i5);
        bVar.setArguments(bundle);
        return bVar;
    }

    public final ArrayList h(File file) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        file.getParent();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory() && !file2.isHidden()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public final void j() {
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof d)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }
        this.b = (d) activity;
        this.c = new ArrayList();
        this.d = getArguments().getString("extensionList");
        this.j = getArguments().getInt("captionOK");
        this.k = getArguments().getInt("captionCancel");
        this.l = getArguments().getInt("popupTitle");
        this.n = getArguments().getInt("editHint");
        this.p = getArguments().getInt("popupIcon");
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.file_save, (ViewGroup) null);
        this.e = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.selectedPath);
        EditText editText = (EditText) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.selectedFile);
        this.f = editText;
        editText.requestFocus();
        try {
            j();
        } catch (Exception unused) {
        }
        this.g = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.default_ext);
        this.h = (ListView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.directoryView);
        File file = new File(Z00.L);
        this.i = file;
        this.c = h(file);
        this.h.setAdapter((ListAdapter) new e(getActivity(), this.c));
        this.h.setOnItemClickListener(this);
        this.e.setText(this.i.getAbsolutePath() + "/");
        String str = this.d;
        if (str != null) {
            this.g.setText(str);
            this.g.setPadding(2, 0, 6, 0);
        }
        builder.setView(viewInflate);
        builder.setIcon(this.p);
        builder.setTitle(this.l);
        builder.setPositiveButton(this.j, new a());
        builder.setNegativeButton(this.k, new DialogInterfaceOnClickListenerC0299b());
        return builder.create();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (i >= 0 || i < this.c.size()) {
            File file = (File) this.c.get(i);
            if (file.getName().equals("◀")) {
                this.i = this.i.getParentFile();
            } else {
                this.i = file;
            }
            this.c = h(this.i);
            this.h.setAdapter((ListAdapter) new e(getActivity(), this.c));
            String absolutePath = this.i.getAbsolutePath();
            if (this.i.getParent() != null) {
                absolutePath = absolutePath + "/";
            }
            this.e.setText(absolutePath);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setOnClickListener(new c());
        }
    }
}
