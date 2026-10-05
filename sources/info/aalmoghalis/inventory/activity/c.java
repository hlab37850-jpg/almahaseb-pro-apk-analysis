package info.aalmoghalis.inventory.activity;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import defpackage.Z00;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class c extends DialogFragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    public final String g = "◀";
    public g h;
    public ArrayList i;
    public TextView j;
    public TextView k;
    public ListView l;
    public File n;
    public File p;
    public int q;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public i y;
    public FilenameFilter z;

    public class a implements FilenameFilter {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            boolean zIsDirectory = new File(String.format("%s/%s", file.getAbsolutePath(), str)).isDirectory();
            if (!zIsDirectory) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    String upperCase = String.format(".{0,}\\%s$", (String) it.next()).toUpperCase(Locale.getDefault());
                    str = str.toUpperCase(Locale.getDefault());
                    zIsDirectory = str.matches(upperCase);
                    if (zIsDirectory) {
                        break;
                    }
                }
            }
            return zIsDirectory;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.activity.c$c, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0300c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC0300c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            c.this.h.l(null, null);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String absolutePath = c.this.n.getAbsolutePath();
            String name = c.this.p != null ? c.this.p.getName() : null;
            if (c.this.h.m(absolutePath, name)) {
                c.this.dismiss();
                c.this.h.l(absolutePath, name);
            }
        }
    }

    public class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return Long.valueOf(file2.lastModified()).compareTo(Long.valueOf(file.lastModified()));
        }
    }

    public class f implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return Long.valueOf(file2.lastModified()).compareTo(Long.valueOf(file.lastModified()));
        }
    }

    public interface g {
        void l(String str, String str2);

        boolean m(String str, String str2);
    }

    public class h extends ArrayAdapter {
        public h(Context context, List list) {
            super(context, R.layout.simple_list_item_1, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2 = c.this.x;
            TextView textView = (TextView) super.getView(i, view, viewGroup);
            if (c.this.i.get(i) != null) {
                String name = ((File) c.this.i.get(i)).getName();
                textView.setText(name);
                if (((File) c.this.i.get(i)).isDirectory()) {
                    i2 = c.this.w;
                }
                if (name.equals("◀")) {
                    i2 = -1;
                }
                if (i2 > 0) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(c.this.getActivity().getResources().getDrawable(i2), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
            return textView;
        }
    }

    public enum i {
        DirectorySelector,
        FileSelector
    }

    public static FilenameFilter b(ArrayList arrayList) {
        return new a(arrayList);
    }

    public static c m(i iVar, int i2, int i3, int i4, int i5, int i6, int i7) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putInt("mode", iVar.ordinal());
        bundle.putInt("captionOK", i2);
        bundle.putInt("captionCancel", i3);
        bundle.putInt("popupTitle", i4);
        bundle.putInt("iconPopup", i5);
        bundle.putInt("iconDirectory", i6);
        bundle.putInt("iconFile", i7);
        cVar.setArguments(bundle);
        return cVar;
    }

    public final ArrayList k(File file) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        FilenameFilter filenameFilter = this.z;
        if (filenameFilter != null) {
            fileArrListFiles = file.listFiles(filenameFilter);
            if (fileArrListFiles != null) {
                Arrays.sort(fileArrListFiles, new e());
            }
        } else {
            fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                Arrays.sort(fileArrListFiles, new f());
            }
        }
        if (file.getParent() != null) {
            arrayList.add(new File("◀"));
        }
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if ((this.y != i.DirectorySelector || file2.isDirectory()) && !file2.isHidden()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public void l(int i2) {
        if (i2 >= 0 || i2 < this.i.size()) {
            File file = (File) this.i.get(i2);
            String name = file.getName();
            if (file.isDirectory() || name.equals("◀")) {
                if (name.equals("◀")) {
                    this.n = this.n.getParentFile();
                } else {
                    this.n = file;
                }
                this.i = k(this.n);
                this.l.setAdapter((ListAdapter) new h(getActivity(), this.i));
                this.p = null;
                String absolutePath = this.n.getAbsolutePath();
                if (this.n.getParent() != null) {
                    absolutePath = absolutePath + "/";
                }
                this.j.setText(absolutePath);
                if (this.y == i.FileSelector) {
                    this.k.setText((CharSequence) null);
                }
            }
        }
    }

    public void n(FilenameFilter filenameFilter) {
        this.z = filenameFilter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof g)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.:" + activity.toString());
        }
        this.h = (g) activity;
        this.i = new ArrayList();
        this.q = getArguments().getInt("captionOK");
        this.t = getArguments().getInt("captionCancel");
        this.u = getArguments().getInt("popupTitle");
        this.v = getArguments().getInt("iconPopup");
        this.x = getArguments().getInt("iconFile");
        this.w = getArguments().getInt("iconDirectory");
        this.y = i.values()[getArguments().getInt("mode")];
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View viewInflate = getActivity().getLayoutInflater().inflate(info.aalmoghalis.inventory.R.layout.file_select, (ViewGroup) null);
        this.j = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.selectedPath);
        this.k = (TextView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.selectedFile);
        this.l = (ListView) viewInflate.findViewById(info.aalmoghalis.inventory.R.id.directoryView);
        if (Z00.Y.equals("0")) {
            this.n = new File(Z00.L);
        } else {
            this.n = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        }
        this.i = k(this.n);
        this.l.setAdapter((ListAdapter) new h(getActivity(), this.i));
        this.l.setOnItemClickListener(this);
        this.l.setOnItemLongClickListener(this);
        this.j.setText(this.n.getAbsolutePath() + "/");
        if (this.y == i.FileSelector) {
            this.k.setGravity(3);
            this.k.setPadding(2, 0, 6, 0);
        }
        builder.setView(viewInflate);
        builder.setIcon(this.v);
        builder.setTitle(this.u);
        builder.setPositiveButton(this.q, new b());
        builder.setNegativeButton(this.t, new DialogInterfaceOnClickListenerC0300c());
        return builder.create();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        this.p = null;
        String absolutePath = this.n.getAbsolutePath();
        if (this.n.getParent() != null) {
            absolutePath = absolutePath + "/";
        }
        this.j.setText(absolutePath);
        if (i2 >= 0 || i2 < this.i.size()) {
            File file = (File) this.i.get(i2);
            this.p = file;
            String name = file.getName();
            if (!this.p.isDirectory() && !name.equals("◀") && this.y == i.FileSelector) {
                this.k.setText(this.p.getName());
            }
            l(i2);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i2, long j) {
        if (i2 < 0 && i2 >= this.i.size()) {
            return false;
        }
        File file = (File) this.i.get(i2);
        String name = file.getName();
        if (!file.isDirectory() && !name.equals("◀")) {
            return false;
        }
        if (name.equals("◀")) {
            this.n = this.n.getParentFile();
        } else {
            this.n = file;
        }
        this.i = k(this.n);
        this.l.setAdapter((ListAdapter) new h(getActivity(), this.i));
        this.p = null;
        String absolutePath = this.n.getAbsolutePath();
        if (this.n.getParent() != null) {
            absolutePath = absolutePath + "/";
        }
        this.j.setText(absolutePath);
        if (this.y != i.FileSelector) {
            return false;
        }
        this.k.setText((CharSequence) null);
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        if (alertDialog != null) {
            alertDialog.getButton(-1).setOnClickListener(new d());
        }
    }
}
