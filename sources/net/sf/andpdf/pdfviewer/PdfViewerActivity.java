package net.sf.andpdf.pdfviewer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.AbstractC3948tF;
import defpackage.C2346hF;
import defpackage.C3099ir;
import defpackage.C3706qF;
import defpackage.C4353yF;
import defpackage.CF;
import defpackage.DF;
import defpackage.GF;
import defpackage.T8;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import net.sf.andpdf.pdfviewer.gui.FullScrollView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PdfViewerActivity extends Activity {
    public h a;
    public h b;
    public String c;
    public C3706qF d;
    public int e;
    public float f;
    public File g;
    public ProgressDialog h;
    public CF i;
    public Thread j;
    public Handler k;

    public class a implements View.OnClickListener {
        public final /* synthetic */ EditText b;

        public a(EditText editText) {
            this.b = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PdfViewerActivity.this.J(this.b.getText().toString());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PdfViewerActivity.this.finish();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int b;
        public final /* synthetic */ float c;

        public c(int i, float f) {
            this.b = i;
            this.c = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (PdfViewerActivity.this.d != null) {
                    PdfViewerActivity.this.K(this.b, this.c);
                }
            } catch (Exception e) {
                Log.e("PDFVIEWER", e.getMessage(), e);
            }
            PdfViewerActivity.this.j = null;
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PdfViewerActivity.this.N();
        }
    }

    public class e implements TextView.OnEditorActionListener {
        public final /* synthetic */ EditText b;

        public e(EditText editText) {
            this.b = editText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (keyEvent == null || keyEvent.getAction() == 1) {
                ((InputMethodManager) PdfViewerActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
            }
            return true;
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText b;

        public f(EditText editText) {
            this.b = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String string = this.b.getText().toString();
            int i2 = PdfViewerActivity.this.e;
            try {
                i2 = Integer.parseInt(string);
            } catch (NumberFormatException unused) {
            }
            if (i2 == PdfViewerActivity.this.e || i2 < 1 || i2 > PdfViewerActivity.this.d.g()) {
                return;
            }
            PdfViewerActivity.this.e = i2;
            PdfViewerActivity.this.b.y.setEnabled(true);
            PdfViewerActivity.this.b.z.setEnabled(true);
            PdfViewerActivity pdfViewerActivity = PdfViewerActivity.this;
            pdfViewerActivity.h = ProgressDialog.show(pdfViewerActivity, "Loading", "Loading PDF Page " + PdfViewerActivity.this.e, true, true);
            PdfViewerActivity pdfViewerActivity2 = PdfViewerActivity.this;
            pdfViewerActivity2.L(pdfViewerActivity2.e, PdfViewerActivity.this.f);
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class h extends FullScrollView {
        public Bitmap u;
        public ImageView v;
        public Button w;
        public Button x;
        public ImageButton y;
        public ImageButton z;

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PdfViewerActivity.this.P();
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PdfViewerActivity.this.O();
            }
        }

        public class c implements View.OnClickListener {
            public c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PdfViewerActivity.this.H();
            }
        }

        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PdfViewerActivity.this.D();
            }
        }

        public class e implements View.OnClickListener {
            public e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PdfViewerActivity.this.E();
            }
        }

        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.N();
            }
        }

        public class g implements Runnable {
            public g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.v.setImageBitmap(h.this.u);
            }
        }

        public h(Context context) {
            super(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2, 10.0f);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(1);
            if (PdfViewerActivity.this.a == null) {
                PdfViewerActivity.this.h = ProgressDialog.show(PdfViewerActivity.this, "Loading", "Loading PDF Page", true, true);
            }
            I(linearLayout);
            this.x = this.w;
            this.v = new ImageView(context);
            K(null);
            M();
            this.v.setLayoutParams(layoutParams);
            this.v.setPadding(5, 5, 5, 5);
            linearLayout.addView(this.v);
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 100));
            setBackgroundColor(-3355444);
            setHorizontalScrollBarEnabled(true);
            setHorizontalFadingEdgeEnabled(true);
            setVerticalScrollBarEnabled(true);
            setVerticalFadingEdgeEnabled(true);
            addView(linearLayout);
        }

        public final void I(ViewGroup viewGroup) {
            J(viewGroup, 6, 6);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2, 10.0f);
            Context context = viewGroup.getContext();
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(0);
            ImageButton imageButton = new ImageButton(context);
            this.y = imageButton;
            imageButton.setBackgroundDrawable(null);
            this.y.setLayoutParams(layoutParams);
            this.y.setImageResource(PdfViewerActivity.this.C());
            this.y.setOnClickListener(new a());
            linearLayout.addView(this.y);
            ImageButton imageButton2 = new ImageButton(context);
            this.z = imageButton2;
            imageButton2.setBackgroundDrawable(null);
            this.z.setLayoutParams(layoutParams);
            this.z.setImageResource(PdfViewerActivity.this.B());
            this.z.setOnClickListener(new b());
            linearLayout.addView(this.z);
            J(linearLayout, 6, 6);
            ImageButton imageButton3 = new ImageButton(context);
            imageButton3.setBackgroundDrawable(null);
            imageButton3.setLayoutParams(layoutParams);
            imageButton3.setImageResource(PdfViewerActivity.this.A());
            imageButton3.setOnClickListener(new c());
            linearLayout.addView(imageButton3);
            Button button = new Button(context);
            this.w = button;
            button.setLayoutParams(layoutParams);
            String string = PdfViewerActivity.this.d == null ? "0" : Integer.toString(PdfViewerActivity.this.d.g());
            this.w.setText(String.valueOf(PdfViewerActivity.this.e) + "/" + string);
            this.w.setOnClickListener(new d());
            linearLayout.addView(this.w);
            ImageButton imageButton4 = new ImageButton(context);
            imageButton4.setBackgroundDrawable(null);
            imageButton4.setLayoutParams(layoutParams);
            imageButton4.setImageResource(PdfViewerActivity.this.t());
            imageButton4.setOnClickListener(new e());
            linearLayout.addView(imageButton4);
            J(linearLayout, 20, 20);
            viewGroup.addView(linearLayout);
            J(viewGroup, 6, 6);
        }

        public final void J(ViewGroup viewGroup, int i, int i2) {
            TextView textView = new TextView(viewGroup.getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(i, i2, 1.0f));
            textView.setText("");
            viewGroup.addView(textView);
        }

        public final void K(Bitmap bitmap) {
            if (bitmap != null) {
                this.u = bitmap;
            }
        }

        public final void L(String str) {
            Log.i("PDFVIEWER", "ST='" + str + "'");
            O();
        }

        public final void M() {
            PdfViewerActivity.this.k.post(new g());
        }

        public void N() {
            if (PdfViewerActivity.this.i != null) {
                Button button = this.w;
                if (button != null) {
                    button.setText(String.valueOf(PdfViewerActivity.this.i.z()) + "/" + PdfViewerActivity.this.d.g());
                }
                Button button2 = this.x;
                if (button2 != null) {
                    button2.setText(String.valueOf(PdfViewerActivity.this.i.z()) + "/" + PdfViewerActivity.this.d.g());
                }
            }
        }

        public final void O() {
            PdfViewerActivity.this.k.post(new f());
        }
    }

    public abstract int A();

    public abstract int B();

    public abstract int C();

    public final void D() {
        if (this.d != null) {
            showDialog(1);
        }
    }

    public final void E() {
        C3706qF c3706qF = this.d;
        if (c3706qF == null || this.e >= c3706qF.g()) {
            return;
        }
        this.e++;
        this.b.y.setEnabled(true);
        this.b.z.setEnabled(true);
        this.h = ProgressDialog.show(this, "Loading", "Loading PDF Page " + this.e, true, true);
        L(this.e, this.f);
    }

    public void F(File file, String str) {
        FileChannel channel = new RandomAccessFile(file, "r").getChannel();
        T8 t8A = T8.a(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()));
        if (str == null) {
            this.d = new C3706qF(t8A);
        } else {
            this.d = new C3706qF(t8A, new GF(str));
        }
        this.b.L("Anzahl Seiten:" + this.d.g());
    }

    public final void G(String str, String str2) throws C2346hF {
        try {
            File file = new File(str);
            long length = file.length();
            if (length == 0) {
                this.b.L("file '" + str + "' not found");
            } else {
                this.b.L("file '" + str + "' has " + length + " bytes");
                F(file, str2);
            }
        } catch (C2346hF e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            this.b.L("Exception: " + th.getMessage());
        }
    }

    public final void H() {
        int i;
        if (this.d == null || (i = this.e) <= 1) {
            return;
        }
        this.e = i - 1;
        this.b.y.setEnabled(true);
        this.b.z.setEnabled(true);
        this.h = ProgressDialog.show(this, "Loading", "Loading PDF Page " + this.e, true, true);
        L(this.e, this.f);
    }

    public final boolean I() {
        this.a = null;
        Log.e("PDFVIEWER", "restoreInstance");
        if (getLastNonConfigurationInstance() == null) {
            return false;
        }
        PdfViewerActivity pdfViewerActivity = (PdfViewerActivity) getLastNonConfigurationInstance();
        if (pdfViewerActivity == this) {
            return true;
        }
        Log.e("PDFVIEWER", "restoring Instance");
        this.a = pdfViewerActivity.b;
        this.e = pdfViewerActivity.e;
        this.d = pdfViewerActivity.d;
        this.i = pdfViewerActivity.i;
        this.g = pdfViewerActivity.g;
        this.f = pdfViewerActivity.f;
        this.c = pdfViewerActivity.c;
        this.j = pdfViewerActivity.j;
        return true;
    }

    public final void J(String str) {
        try {
            G(this.c, str);
            setContentView(this.b);
            L(this.e, this.f);
        } catch (C2346hF unused) {
            setContentView(y());
            EditText editText = (EditText) findViewById(w());
            Button button = (Button) findViewById(z());
            Button button2 = (Button) findViewById(x());
            button.setOnClickListener(new a(editText));
            button2.setOnClickListener(new b());
        }
    }

    public final void K(int i, float f2) {
        try {
            this.b.K(null);
            this.b.M();
            CF cf = this.i;
            if (cf == null || cf.z() != i) {
                this.i = this.d.h(i, true);
            }
            this.b.K(this.i.x((int) (this.i.B() * f2), (int) (this.i.w() * f2), null, true, true));
            this.b.M();
            ProgressDialog progressDialog = this.h;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Throwable th) {
            Log.e("PDFVIEWER", th.getMessage(), th);
            this.b.L("Exception: " + th.getMessage());
        }
    }

    public final synchronized void L(int i, float f2) {
        if (this.j != null) {
            return;
        }
        this.b.L("reading page " + i + ", zoom:" + f2);
        this.j = new Thread(new c(i, f2));
        N();
        this.j.start();
    }

    public final String M(Uri uri) {
        try {
            File file = this.g;
            if (file == null) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory == null) {
                    throw new Exception("external storage dir not found");
                }
                File file2 = new File(externalStorageDirectory, "AndroidPdfViewer/AndroidPdfViewer_temp.pdf");
                this.g = file2;
                file2.getParentFile().mkdirs();
                this.g.delete();
            } else {
                file.delete();
            }
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(this.g);
            byte[] bArr = new byte[1024];
            for (int i = inputStreamOpenInputStream.read(bArr); i > 0; i = inputStreamOpenInputStream.read(bArr)) {
                fileOutputStream.write(bArr, 0, i);
            }
            fileOutputStream.close();
            inputStreamOpenInputStream.close();
            String canonicalPath = this.g.getCanonicalPath();
            this.g.deleteOnExit();
            return canonicalPath;
        } catch (Exception e2) {
            Log.e("PDFVIEWER", e2.getMessage(), e2);
            return null;
        }
    }

    public final void N() {
        if (this.j == null) {
            this.b.O();
        } else {
            this.b.O();
            this.b.postDelayed(new d(), 1000L);
        }
    }

    public final void O() {
        if (this.d != null) {
            float f2 = this.f;
            if (f2 < 3.0f) {
                float f3 = f2 * 1.5f;
                this.f = f3;
                if (f3 > 3.0f) {
                    this.f = 3.0f;
                }
                if (this.f >= 3.0f) {
                    Log.d("PDFVIEWER", "Disabling zoom in button");
                    this.b.z.setEnabled(false);
                } else {
                    this.b.z.setEnabled(true);
                }
                this.b.y.setEnabled(true);
                L(this.e, this.f);
            }
        }
    }

    public final void P() {
        if (this.d != null) {
            float f2 = this.f;
            if (f2 > 0.25f) {
                float f3 = f2 / 1.5f;
                this.f = f3;
                if (f3 < 0.25f) {
                    this.f = 0.25f;
                }
                if (this.f <= 0.25f) {
                    Log.d("PDFVIEWER", "Disabling zoom out button");
                    this.b.y.setEnabled(false);
                } else {
                    this.b.y.setEnabled(true);
                }
                this.b.z.setEnabled(true);
                L(this.e, this.f);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("PDFVIEWER", "onCreate");
        this.k = new Handler();
        I();
        if (this.a != null) {
            h hVar = new h(this);
            this.b = hVar;
            hVar.u = this.a.u;
            this.a = null;
            this.b.v.setImageBitmap(this.b.u);
            this.b.N();
            setContentView(this.b);
            return;
        }
        this.b = new h(this);
        Intent intent = getIntent();
        StringBuilder sb = new StringBuilder();
        sb.append(intent);
        Log.i("PDFVIEWER", sb.toString());
        C4353yF.j = getIntent().getBooleanExtra("net.sf.andpdf.extra.SHOWIMAGES", true);
        DF.b = getIntent().getBooleanExtra("net.sf.andpdf.extra.ANTIALIAS", true);
        AbstractC3948tF.f = getIntent().getBooleanExtra("net.sf.andpdf.extra.USEFONTSUBSTITUTION", false);
        C3099ir.b = getIntent().getBooleanExtra("net.sf.andpdf.extra.KEEPCACHES", false);
        if (intent != null) {
            if ("android.intent.action.VIEW".equals(intent.getAction())) {
                this.c = M(intent.getData());
            } else {
                this.c = getIntent().getStringExtra("net.sf.andpdf.extra.PDFFILENAME");
            }
        }
        if (this.c == null) {
            this.c = "no file selected";
        }
        this.e = 1;
        this.f = 1.0f;
        J(null);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i != 1) {
            return null;
        }
        View viewInflate = LayoutInflater.from(this).inflate(v(), (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(u());
        editText.setText(Integer.toString(this.e));
        editText.setOnEditorActionListener(new e(editText));
        return new AlertDialog.Builder(this).setTitle("Jump to page").setView(viewInflate).setPositiveButton("OK", new f(editText)).setNegativeButton("Cancel", new g()).create();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 2, 0, "Previous Page").setIcon(A());
        menu.add(0, 1, 0, "Next Page").setIcon(t());
        menu.add(0, 3, 0, "Goto Page");
        menu.add(0, 5, 0, "Zoom Out").setIcon(C());
        menu.add(0, 4, 0, "Zoom In").setIcon(B());
        if (C3099ir.b) {
            menu.add(0, 7, 0, "Clear Caches");
        }
        return true;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        File file = this.g;
        if (file != null) {
            file.delete();
            this.g = null;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case 1:
                E();
                break;
            case 2:
                H();
                break;
            case 3:
                D();
                break;
            case 4:
                O();
                break;
            case 5:
                P();
                break;
            case 6:
                finish();
                break;
            case 7:
                C3099ir.b();
                break;
        }
        return true;
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        Log.e("PDFVIEWER", "onRetainNonConfigurationInstance");
        return this;
    }

    public abstract int t();

    public abstract int u();

    public abstract int v();

    public abstract int w();

    public abstract int x();

    public abstract int y();

    public abstract int z();
}
