package info.aalmoghalis.inventory.activity;

import android.os.Bundle;
import info.aalmoghalis.inventory.R;

/* JADX INFO: loaded from: classes3.dex */
public class PdfViewerActivity extends net.sf.andpdf.pdfviewer.PdfViewerActivity {
    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int A() {
        return R.drawable.left_arrow;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int B() {
        return R.drawable.zoom_in;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int C() {
        return R.drawable.zoom_out;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int t() {
        return R.drawable.right_arrow;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int u() {
        return R.id.pagenum_edit;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int v() {
        return R.layout.dialog_pagenumber;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int w() {
        return R.id.etPassword;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int x() {
        return R.id.btExit;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int y() {
        return R.layout.pdf_file_password;
    }

    @Override // net.sf.andpdf.pdfviewer.PdfViewerActivity
    public int z() {
        return R.id.btOK;
    }
}
