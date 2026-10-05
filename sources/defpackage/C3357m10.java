package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: renamed from: m10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3357m10 {
    public static int c = 1000;
    public Context a;
    public Z00 b;

    /* JADX INFO: renamed from: m10$a */
    public class a {
        public int a;
        public int b = 5;
        public float[] c;
        public boolean d;
        public boolean e;

        public a(List list, int i, BaseFont baseFont) {
            int i2;
            String str;
            this.a = 6;
            int i3 = 5;
            this.c = new float[]{3.0f, 2.0f, 2.0f, 1.0f, 4.0f, 0.5f};
            this.d = false;
            this.e = false;
            float size = (list.size() - 1) * 0.5f;
            boolean zJa = C3357m10.this.b.ja("prefOthers_print_end_date", false);
            this.e = zJa;
            float f = 1.0f + size;
            int i4 = 4;
            this.c = new float[]{3.0f, 2.0f, 2.0f, f, 4.0f, size + 0.5f};
            this.a = 6;
            if (zJa) {
                this.a = 7;
                this.c = new float[]{3.0f, 2.0f, 2.0f, 2.5f, 2.0f, 4.0f, f};
            }
            if (C3357m10.this.b.ja("prefOthers_barcode", false) && (i == 1 || i == 2)) {
                this.d = true;
                int i5 = this.a + 1;
                this.a = i5;
                if (i5 == 7) {
                    this.c = new float[]{3.0f, 2.0f, 2.0f, 3.0f, 4.0f, 4.0f, f};
                } else if (i5 == 8) {
                    this.c = new float[]{3.0f, 2.0f, 2.0f, 3.0f, 2.0f, 4.0f, 4.0f, f};
                }
            }
            ArrayList arrayList = new ArrayList();
            int size2 = list.size();
            if (size2 > 0) {
                int i6 = 0;
                int i7 = 0;
                while (i6 < Math.min(15, size2)) {
                    C4145vh c4145vh = (C4145vh) list.get(i6);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(c4145vh.s());
                    int i8 = this.b;
                    if (i8 == i3 || i8 == i4) {
                        arrayList2.add(i8 == i3 ? c4145vh.t() : "");
                        arrayList2.add(c4145vh.r());
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                    String str2 = "-";
                    if (this.e) {
                        arrayList2.add(c4145vh.i().length() == 0 ? "-" : c4145vh.i());
                        i2++;
                    }
                    if (!c4145vh.e().equals(".")) {
                        str2 = c4145vh.e() + "";
                    }
                    arrayList2.add(str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append(c4145vh.q());
                    if (c4145vh.c().equals("")) {
                        str = "";
                    } else {
                        str = " " + c4145vh.c();
                    }
                    sb.append(str);
                    arrayList2.add(sb.toString());
                    if (this.d) {
                        arrayList2.add(c4145vh.h().equals("") ? "." : c4145vh.h());
                    }
                    arrayList2.add(size2 + "");
                    arrayList.add((String[]) arrayList2.toArray(new String[0]));
                    i6++;
                    i7 = i2;
                    i4 = 4;
                    i3 = 5;
                }
                this.c = AbstractC4030uG.a(arrayList, 12.0f, baseFont);
                float length = ((size2 + "").length() - 1) * 10.0f;
                float[] fArr = this.c;
                fArr[fArr.length - 1] = 10.0f + length;
                fArr[fArr.length - 1] = Math.min(fArr[fArr.length - 1], 25.0f);
                if (this.d) {
                    float[] fArr2 = this.c;
                    fArr2[fArr2.length - 2] = fArr2[fArr2.length - 2] + length + (this.a >= 8 ? 5.0f : 0.0f);
                    fArr2[fArr2.length - 2] = Math.min(fArr2[fArr2.length - 2], 70.0f);
                }
                if (this.e) {
                    this.c[i7] = 50.0f;
                }
            }
        }
    }

    public C3357m10(Context context, Z00 z00) {
        this.a = context;
        this.b = z00;
    }

    public static void a(Document document, PdfWriter pdfWriter) {
        try {
            if (pdfWriter.getPageNumber() > 0) {
                document.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BaseColor b() {
        return new BaseColor(224, 224, 224);
    }

    public static void c(File file, File file2, String str) {
        try {
            new File(file2, "temp.pdf");
            Log.d("trace_pdf=", "f=" + str);
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 268435456);
            PdfRenderer pdfRenderer = new PdfRenderer(parcelFileDescriptorOpen);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < pdfRenderer.getPageCount()) {
                PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(i);
                int width = pageOpenPage.getWidth();
                int height = pageOpenPage.getHeight();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(-1);
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
                pageOpenPage.render(bitmapCreateBitmap, null, null, 1);
                pageOpenPage.close();
                i3 += height;
                arrayList.add(bitmapCreateBitmap);
                i++;
                i2 = width;
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            Paint paint = new Paint();
            int height2 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                Bitmap bitmap = (Bitmap) arrayList.get(i4);
                canvas2.drawBitmap(bitmap, 0.0f, height2, paint);
                height2 += bitmap.getHeight();
                bitmap.recycle();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file2, str + ".jpg"));
            bitmapCreateBitmap2.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            pdfRenderer.close();
            parcelFileDescriptorOpen.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0511 A[EXC_TOP_SPLITTER, PHI: r2
      0x0511: PHI (r2v10 java.io.FileOutputStream) = (r2v9 java.io.FileOutputStream), (r2v11 java.io.FileOutputStream) binds: [B:114:0x050f, B:118:0x0529] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public boolean d(RecyclerView recyclerView, String str, double d, String str2, String str3, String str4) throws Throwable {
        int i;
        String str5;
        CellStyle cellStyle;
        C3357m10 c3357m10 = this;
        String str6 = "FileUtils";
        if (!Z00.V9() || Z00.X9()) {
            return false;
        }
        c3357m10.b.ja("pref_hide_doc_col", true);
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
        CellStyle cellStyleCreateCellStyle = hSSFWorkbook.createCellStyle();
        cellStyleCreateCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        HSSFFont hSSFFont = (HSSFFont) hSSFWorkbook.createFont();
        hSSFFont.setColor(IndexedColors.BLUE.getIndex());
        cellStyleCreateCellStyle.setFont(hSSFFont);
        c3357m10.b.Xc(cellStyleCreateCellStyle);
        CellStyle cellStyleCreateCellStyle2 = hSSFWorkbook.createCellStyle();
        c3357m10.b.Yc(cellStyleCreateCellStyle2);
        Sheet sheetCreateSheet = hSSFWorkbook.createSheet(str);
        Row rowCreateRow = sheetCreateSheet.createRow(0);
        Cell cellCreateCell = rowCreateRow.createCell(0);
        cellCreateCell.setCellValue(c3357m10.a.getString(R.string.cus_det_title) + str);
        cellCreateCell.setCellStyle(cellStyleCreateCellStyle);
        rowCreateRow.createCell(1).setCellStyle(cellStyleCreateCellStyle);
        rowCreateRow.createCell(2).setCellStyle(cellStyleCreateCellStyle);
        rowCreateRow.createCell(3).setCellStyle(cellStyleCreateCellStyle);
        rowCreateRow.createCell(4).setCellStyle(cellStyleCreateCellStyle);
        rowCreateRow.createCell(5).setCellStyle(cellStyleCreateCellStyle);
        sheetCreateSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        String strW9 = c3357m10.b.w9(str3, str4);
        if (!strW9.equals("")) {
            Row rowCreateRow2 = sheetCreateSheet.createRow(1);
            Cell cellCreateCell2 = rowCreateRow2.createCell(0);
            cellCreateCell2.setCellValue(strW9);
            cellCreateCell2.setCellStyle(cellStyleCreateCellStyle);
            rowCreateRow2.createCell(1).setCellStyle(cellStyleCreateCellStyle);
            rowCreateRow2.createCell(2).setCellStyle(cellStyleCreateCellStyle);
            rowCreateRow2.createCell(3).setCellStyle(cellStyleCreateCellStyle);
            rowCreateRow2.createCell(4).setCellStyle(cellStyleCreateCellStyle);
            rowCreateRow2.createCell(5).setCellStyle(cellStyleCreateCellStyle);
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));
        }
        Row rowCreateRow3 = strW9.equals("") ? sheetCreateSheet.createRow(1) : sheetCreateSheet.createRow(2);
        Cell cellCreateCell3 = rowCreateRow3.createCell(0);
        cellCreateCell3.setCellValue(c3357m10.a.getString(R.string.tr_bal));
        cellCreateCell3.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell4 = rowCreateRow3.createCell(1);
        cellCreateCell4.setCellValue(c3357m10.b.Q2());
        cellCreateCell4.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell5 = rowCreateRow3.createCell(2);
        cellCreateCell5.setCellValue(c3357m10.b.c5());
        cellCreateCell5.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell6 = rowCreateRow3.createCell(3);
        cellCreateCell6.setCellValue(c3357m10.a.getString(R.string.tr_remarks));
        cellCreateCell6.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell7 = rowCreateRow3.createCell(4);
        cellCreateCell7.setCellValue(c3357m10.a.getString(R.string.bill_no_doc));
        cellCreateCell7.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell8 = rowCreateRow3.createCell(5);
        cellCreateCell8.setCellValue(c3357m10.a.getString(R.string.tr_date));
        cellCreateCell8.setCellStyle(cellStyleCreateCellStyle);
        if (strW9.equals("")) {
            i = 0;
            sheetCreateSheet.createFreezePane(0, 2);
        } else {
            i = 0;
            sheetCreateSheet.createFreezePane(0, 3);
        }
        List listC = ((C4330y1) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(i)).c();
        int i2 = 0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        while (true) {
            if (i2 >= listC.size()) {
                break;
            }
            C4064uh c4064uh = (C4064uh) listC.get(i2);
            Row rowCreateRow4 = strW9.equals("") ? sheetCreateSheet.createRow(i2 + 2) : sheetCreateSheet.createRow(i2 + 3);
            Cell cellCreateCell9 = rowCreateRow4.createCell(5);
            cellCreateCell9.setCellValue(c4064uh.p());
            cellCreateCell9.setCellStyle(cellStyleCreateCellStyle2);
            Cell cellCreateCell10 = rowCreateRow4.createCell(4);
            String str7 = str6;
            cellCreateCell10.setCellValue(c4064uh.k().equals("0") ? " " : c4064uh.k());
            cellCreateCell10.setCellStyle(cellStyleCreateCellStyle2);
            Cell cellCreateCell11 = rowCreateRow4.createCell(3);
            cellCreateCell11.setCellValue(c4064uh.r());
            cellCreateCell11.setCellStyle(cellStyleCreateCellStyle2);
            if (c4064uh.t() == c3357m10.b.c[0]) {
                Cell cellCreateCell12 = rowCreateRow4.createCell(1);
                cellCreateCell12.setCellValue(c4064uh.n());
                cellCreateCell12.setCellStyle(cellStyleCreateCellStyle2);
                Cell cellCreateCell13 = rowCreateRow4.createCell(2);
                cellCreateCell13.setCellValue(0.0d);
                cellCreateCell13.setCellStyle(cellStyleCreateCellStyle2);
                if (c4064uh.a.equals("0")) {
                    d4 = Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                } else {
                    d2 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                }
                cellStyle = cellStyleCreateCellStyle;
            } else {
                Cell cellCreateCell14 = rowCreateRow4.createCell(1);
                cellStyle = cellStyleCreateCellStyle;
                cellCreateCell14.setCellValue(0.0d);
                cellCreateCell14.setCellStyle(cellStyleCreateCellStyle2);
                Cell cellCreateCell15 = rowCreateRow4.createCell(2);
                cellCreateCell15.setCellValue(c4064uh.n());
                cellCreateCell15.setCellStyle(cellStyleCreateCellStyle2);
                if (c4064uh.a.equals("0")) {
                    d5 = Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                } else {
                    d3 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                }
            }
            Cell cellCreateCell16 = rowCreateRow4.createCell(0);
            cellCreateCell16.setCellValue(c4064uh.f());
            cellCreateCell16.setCellStyle(cellStyleCreateCellStyle2);
            i2++;
            c3357m10 = this;
            cellStyleCreateCellStyle = cellStyle;
            str6 = str7;
        }
        String str8 = str6;
        CellStyle cellStyle2 = cellStyleCreateCellStyle;
        int size = listC.size();
        Row rowCreateRow5 = strW9.equals("") ? sheetCreateSheet.createRow(size + 3) : sheetCreateSheet.createRow(size + 4);
        rowCreateRow5.createCell(0).setCellStyle(cellStyle2);
        Cell cellCreateCell17 = rowCreateRow5.createCell(1);
        cellCreateCell17.setCellValue(this.b.P7(String.valueOf(d2)));
        cellCreateCell17.setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell18 = rowCreateRow5.createCell(2);
        cellCreateCell18.setCellValue(this.b.P7(String.valueOf(d3)));
        cellCreateCell18.setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell19 = rowCreateRow5.createCell(3);
        double d6 = d4;
        double d7 = d5;
        if (d6 == 0.0d && d7 == 0.0d) {
            cellCreateCell19.setCellValue(this.a.getString(R.string.total_det));
        } else {
            cellCreateCell19.setCellValue(this.a.getString(R.string.total_det2));
        }
        cellCreateCell19.setCellStyle(cellStyle2);
        rowCreateRow5.createCell(4).setCellStyle(cellStyle2);
        rowCreateRow5.createCell(5).setCellStyle(cellStyle2);
        if (strW9.equals("")) {
            int i3 = size + 3;
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i3, i3, 3, 5));
        } else {
            int i4 = size + 4;
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i4, i4, 3, 5));
        }
        int i5 = (d6 == 0.0d && d7 == 0.0d) ? 0 : 1;
        Row rowCreateRow6 = strW9.equals("") ? sheetCreateSheet.createRow(size + 4) : sheetCreateSheet.createRow(size + 5);
        rowCreateRow6.createCell(0).setCellStyle(cellStyle2);
        Cell cellCreateCell20 = rowCreateRow6.createCell(1);
        int i6 = i5;
        cellCreateCell20.setCellValue(this.b.O7(d6));
        cellCreateCell20.setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell21 = rowCreateRow6.createCell(2);
        cellCreateCell21.setCellValue(this.b.O7(d7));
        cellCreateCell21.setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell22 = rowCreateRow6.createCell(3);
        cellCreateCell22.setCellValue(this.a.getString(R.string.old_balance));
        cellCreateCell22.setCellStyle(cellStyle2);
        rowCreateRow6.createCell(4).setCellStyle(cellStyle2);
        rowCreateRow6.createCell(5).setCellStyle(cellStyle2);
        if (strW9.equals("")) {
            int i7 = size + 4;
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i7, i7, 3, 5));
        } else {
            int i8 = size + 5;
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i8, i8, 3, 5));
        }
        Row rowCreateRow7 = strW9.equals("") ? sheetCreateSheet.createRow(size + 4 + i6) : sheetCreateSheet.createRow(size + 5 + i6);
        Cell cellCreateCell23 = rowCreateRow7.createCell(0);
        cellCreateCell23.setCellValue(this.b.P7(String.valueOf(Math.abs(d))) + " " + str2);
        cellCreateCell23.setCellStyle(cellStyleCreateCellStyle2);
        rowCreateRow7.createCell(1).setCellStyle(cellStyleCreateCellStyle2);
        rowCreateRow7.createCell(2).setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell24 = rowCreateRow7.createCell(3);
        if (d >= 0.0d) {
            cellCreateCell24.setCellValue(this.b.d5());
        } else {
            cellCreateCell24.setCellValue(this.b.R2());
        }
        cellCreateCell24.setCellStyle(cellStyle2);
        rowCreateRow7.createCell(4).setCellStyle(cellStyle2);
        rowCreateRow7.createCell(5).setCellStyle(cellStyle2);
        if (strW9.equals("")) {
            int i9 = size + 4 + i6;
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i9, i9, 0, 2));
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i9, i9, 3, 5));
        } else {
            int i10 = size + 5 + i6;
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i10, i10, 0, 2));
            sheetCreateSheet.addMergedRegion(new CellRangeAddress(i10, i10, 3, 5));
        }
        File file = new File(Z00.L);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str + ".xls");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    try {
                        hSSFWorkbook.write(fileOutputStream2);
                        str5 = str8;
                        try {
                            Log.w(str5, "Writing file" + file2);
                            try {
                                fileOutputStream2.close();
                                return true;
                            } catch (Exception unused) {
                                return true;
                            }
                        } catch (IOException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            Log.w(str5, "Error writing " + file2, e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return false;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            Log.w(str5, "Failed to save file", e);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    str5 = str8;
                } catch (Exception e4) {
                    e = e4;
                    str5 = str8;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            str5 = str8;
        } catch (Exception e6) {
            e = e6;
            str5 = str8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0310 A[EXC_TOP_SPLITTER, PHI: r5
      0x0310: PHI (r5v11 java.io.FileOutputStream) = (r5v10 java.io.FileOutputStream), (r5v12 java.io.FileOutputStream) binds: [B:44:0x030e, B:48:0x0328] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public boolean e(RecyclerView recyclerView, String str, double d, String str2) throws Throwable {
        String str3;
        CellStyle cellStyle;
        if (!Z00.V9() || Z00.X9()) {
            return false;
        }
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
        CellStyle cellStyleCreateCellStyle = hSSFWorkbook.createCellStyle();
        cellStyleCreateCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        HSSFFont hSSFFont = (HSSFFont) hSSFWorkbook.createFont();
        hSSFFont.setColor(IndexedColors.BLUE.getIndex());
        cellStyleCreateCellStyle.setFont(hSSFFont);
        this.b.Xc(cellStyleCreateCellStyle);
        CellStyle cellStyleCreateCellStyle2 = hSSFWorkbook.createCellStyle();
        this.b.Yc(cellStyleCreateCellStyle2);
        Sheet sheetCreateSheet = hSSFWorkbook.createSheet(str);
        Row rowCreateRow = sheetCreateSheet.createRow(0);
        Cell cellCreateCell = rowCreateRow.createCell(0);
        cellCreateCell.setCellStyle(cellStyleCreateCellStyle);
        cellCreateCell.setCellValue(str);
        rowCreateRow.createCell(1).setCellStyle(cellStyleCreateCellStyle);
        int i = 2;
        rowCreateRow.createCell(2).setCellStyle(cellStyleCreateCellStyle);
        int i2 = 3;
        rowCreateRow.createCell(3).setCellStyle(cellStyleCreateCellStyle);
        int i3 = 4;
        rowCreateRow.createCell(4).setCellStyle(cellStyleCreateCellStyle);
        sheetCreateSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        Row rowCreateRow2 = sheetCreateSheet.createRow(1);
        Cell cellCreateCell2 = rowCreateRow2.createCell(0);
        cellCreateCell2.setCellValue(this.a.getString(R.string.radio1));
        cellCreateCell2.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell3 = rowCreateRow2.createCell(1);
        cellCreateCell3.setCellValue(this.a.getString(R.string.radio2));
        cellCreateCell3.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell4 = rowCreateRow2.createCell(2);
        cellCreateCell4.setCellValue(this.a.getString(R.string.tr_remarks));
        cellCreateCell4.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell5 = rowCreateRow2.createCell(3);
        cellCreateCell5.setCellValue(this.a.getString(R.string.cus_name));
        cellCreateCell5.setCellStyle(cellStyleCreateCellStyle);
        Cell cellCreateCell6 = rowCreateRow2.createCell(4);
        cellCreateCell6.setCellValue(this.a.getString(R.string.tr_date));
        cellCreateCell6.setCellStyle(cellStyleCreateCellStyle);
        sheetCreateSheet.createFreezePane(0, 2);
        List listB = ((L1) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).b();
        int i4 = 0;
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (true) {
            str3 = "";
            if (i4 >= listB.size()) {
                break;
            }
            C0795Oh c0795Oh = (C0795Oh) listB.get(i4);
            Row rowCreateRow3 = sheetCreateSheet.createRow(i4 + 2);
            Cell cellCreateCell7 = rowCreateRow3.createCell(i);
            cellCreateCell7.setCellValue(c0795Oh.q());
            cellCreateCell7.setCellStyle(cellStyleCreateCellStyle2);
            Cell cellCreateCell8 = rowCreateRow3.createCell(i2);
            cellCreateCell8.setCellValue(c0795Oh.p());
            cellCreateCell8.setCellStyle(cellStyleCreateCellStyle2);
            Cell cellCreateCell9 = rowCreateRow3.createCell(i3);
            cellCreateCell9.setCellValue(c0795Oh.n());
            cellCreateCell9.setCellStyle(cellStyleCreateCellStyle2);
            if (c0795Oh.r() == this.b.c[0]) {
                Cell cellCreateCell10 = rowCreateRow3.createCell(0);
                cellCreateCell10.setCellValue(c0795Oh.l().replaceAll(",", ""));
                cellCreateCell10.setCellStyle(cellStyleCreateCellStyle2);
                Cell cellCreateCell11 = rowCreateRow3.createCell(1);
                cellCreateCell11.setCellValue(0.0d);
                cellCreateCell11.setCellStyle(cellStyleCreateCellStyle2);
                d2 += Double.parseDouble(c0795Oh.l().replaceAll(",", ""));
                cellStyle = cellStyleCreateCellStyle;
            } else {
                cellStyle = cellStyleCreateCellStyle;
                Cell cellCreateCell12 = rowCreateRow3.createCell(0);
                cellCreateCell12.setCellValue(0.0d);
                cellCreateCell12.setCellStyle(cellStyleCreateCellStyle2);
                Cell cellCreateCell13 = rowCreateRow3.createCell(1);
                cellCreateCell13.setCellValue(c0795Oh.l().replaceAll(",", ""));
                cellCreateCell13.setCellStyle(cellStyleCreateCellStyle2);
                d3 += Double.parseDouble(c0795Oh.l().replaceAll(",", ""));
            }
            i4++;
            cellStyleCreateCellStyle = cellStyle;
            i = 2;
            i2 = 3;
            i3 = 4;
        }
        CellStyle cellStyle2 = cellStyleCreateCellStyle;
        int size = listB.size();
        int i5 = size + 3;
        Row rowCreateRow4 = sheetCreateSheet.createRow(i5);
        Cell cellCreateCell14 = rowCreateRow4.createCell(0);
        cellCreateCell14.setCellValue(this.b.P7(String.valueOf(d2)));
        cellCreateCell14.setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell15 = rowCreateRow4.createCell(1);
        cellCreateCell15.setCellValue(this.b.P7(String.valueOf(d3)));
        cellCreateCell15.setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell16 = rowCreateRow4.createCell(2);
        cellCreateCell16.setCellValue(this.a.getString(R.string.total));
        cellCreateCell16.setCellStyle(cellStyle2);
        rowCreateRow4.createCell(3).setCellStyle(cellStyle2);
        rowCreateRow4.createCell(4).setCellStyle(cellStyle2);
        sheetCreateSheet.addMergedRegion(new CellRangeAddress(i5, i5, 2, 4));
        int i6 = size + 4;
        Row rowCreateRow5 = sheetCreateSheet.createRow(i6);
        Cell cellCreateCell17 = rowCreateRow5.createCell(0);
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.P7(String.valueOf(Math.abs(d))));
        if (Z00.Z) {
            str3 = "" + str2;
        }
        sb.append(str3);
        cellCreateCell17.setCellValue(sb.toString());
        cellCreateCell17.setCellStyle(cellStyleCreateCellStyle2);
        rowCreateRow5.createCell(1).setCellStyle(cellStyleCreateCellStyle2);
        Cell cellCreateCell18 = rowCreateRow5.createCell(2);
        if (d >= 0.0d) {
            cellCreateCell18.setCellValue(this.a.getString(R.string.net_total2));
        } else {
            cellCreateCell18.setCellValue(this.a.getString(R.string.net_total1));
        }
        cellCreateCell18.setCellStyle(cellStyle2);
        rowCreateRow5.createCell(3).setCellStyle(cellStyle2);
        rowCreateRow5.createCell(4).setCellStyle(cellStyle2);
        sheetCreateSheet.addMergedRegion(new CellRangeAddress(i6, i6, 0, 1));
        sheetCreateSheet.addMergedRegion(new CellRangeAddress(i6, i6, 2, 4));
        File file = new File(Z00.L);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str + ".xls");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    hSSFWorkbook.write(fileOutputStream2);
                    Log.w("FileUtils", "Writing file" + file2);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.w("FileUtils", "Error writing " + file2, e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    Log.w("FileUtils", "Failed to save file", e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void f(RecyclerView recyclerView, String str, double d) {
        Z00 z00;
        Font font;
        Font font2;
        Font font3;
        Document document = new Document();
        new DecimalFormat("0.00");
        try {
            File file = new File(Z00.L);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".pdf"));
            BaseFont baseFontCreateFont = BaseFont.createFont(Z00.N, BaseFont.IDENTITY_H, true);
            Font font4 = new Font(baseFontCreateFont, 12.0f);
            Font font5 = new Font(baseFontCreateFont, 12.0f, 1, new BaseColor(0, 0, 0));
            Font font6 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(32, 48, 76));
            new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(255, 0, 0));
            new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(0, 255, 0));
            Font font7 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(255, 255, 255));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
            this.b.e = defaultSharedPreferences.getString("prefUsername", "");
            this.b.g = defaultSharedPreferences.getString("prefAddress", "");
            this.b.i = defaultSharedPreferences.getString("prefPhone", "");
            this.b.l = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintUser", false));
            Z00.r0 = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintDate", true));
            this.b.k = Integer.parseInt(defaultSharedPreferences.getString("prefSyncFrequency", "1"));
            Z00 z01 = this.b;
            z01.j = z01.ia("ImageDecode", "0");
            PdfWriter.getInstance(document, fileOutputStream).setPageEvent(new Z00.G1());
            document.open();
            document.setPageSize(PageSize.A4);
            Paragraph paragraph = new Paragraph("");
            paragraph.setAlignment(1);
            float[] fArr = {2.5f, 2.0f, 2.0f, 2.0f, 6.0f, 2.5f};
            float[] fArr2 = {2.5f, 2.0f, 3.0f, 3.0f, 4.0f, 2.5f};
            this.b.z7();
            if (Z00.X.equals("R")) {
                fArr = new float[]{2.5f, 6.0f, 2.0f, 2.0f, 2.0f, 2.5f};
                fArr2 = new float[]{2.5f, 4.0f, 3.0f, 3.0f, 2.0f, 2.5f};
            }
            PdfPTable pdfPTable = new PdfPTable(fArr);
            PdfPTable pdfPTable2 = new PdfPTable(fArr2);
            pdfPTable.setWidthPercentage(100.0f);
            pdfPTable2.setWidthPercentage(100.0f);
            int i = 0;
            while (true) {
                z00 = this.b;
                font = font7;
                if (i >= z00.k - 1) {
                    break;
                }
                z00.z9(pdfPTable2, "", 0, 6, font5);
                i++;
                font7 = font;
            }
            String str2 = "L";
            if (z00.l.booleanValue()) {
                if (Z00.X.equals("R")) {
                    Z00 z02 = this.b;
                    z02.B9(pdfPTable2, z02.e, 2, 2, font6, true);
                    Z00 z03 = this.b;
                    z03.B9(pdfPTable2, z03.g, 2, 2, font6, true);
                    Z00 z04 = this.b;
                    z04.B9(pdfPTable2, z04.i, 2, 2, font6, true);
                }
                if (this.b.j.equals("0")) {
                    this.b.G9(pdfPTable2, "", 0, 3, font6);
                    this.b.G9(pdfPTable2, "", 0, 3, font6);
                    this.b.H9(pdfPTable2, "", 1, 3, font6, R.mipmap.ic_launcher);
                } else {
                    this.b.G9(pdfPTable2, "", 0, 3, font6);
                    this.b.G9(pdfPTable2, "", 0, 3, font6);
                    Z00 z05 = this.b;
                    z05.J9(pdfPTable2, "", 1, 3, font6, z05.j);
                }
                if (Z00.X.equals("L")) {
                    Z00 z06 = this.b;
                    z06.B9(pdfPTable2, z06.e, 0, 2, font6, true);
                    Z00 z07 = this.b;
                    z07.B9(pdfPTable2, z07.g, 0, 2, font6, true);
                    Z00 z08 = this.b;
                    z08.B9(pdfPTable2, z08.i, 0, 2, font6, true);
                }
                this.b.B9(pdfPTable2, "", 0, 6, font6, true);
            }
            this.b.z9(pdfPTable2, this.a.getString(R.string.cus_det_title) + str, 1, 6, font6);
            PdfPCell pdfPCell = new PdfPCell(pdfPTable2);
            pdfPCell.setColspan(6);
            pdfPTable.addCell(pdfPCell);
            if (Z00.X.equals("L")) {
                this.b.z9(pdfPTable, this.a.getString(R.string.tr_bal), 1, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.radio1), 1, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.radio2), 1, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.tr_remarks), 0, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.bill_no), 0, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.tr_date), 0, 1, font6);
            } else {
                this.b.z9(pdfPTable, this.a.getString(R.string.tr_date), 2, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.bill_no), 2, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.tr_remarks), 2, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.radio2), 1, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.radio1), 1, 1, font6);
                this.b.z9(pdfPTable, this.a.getString(R.string.tr_bal), 1, 1, font6);
            }
            pdfPTable.setHeaderRows(this.b.k + 1);
            List listC = ((C4330y1) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).c();
            int i2 = 0;
            double d2 = 0.0d;
            double d3 = 0.0d;
            while (i2 < listC.size()) {
                C4064uh c4064uh = (C4064uh) listC.get(i2);
                if (Z00.X.equals(str2)) {
                    font2 = font4;
                    font3 = font;
                    this.b.z9(pdfPTable, c4064uh.f(), 1, 1, font2);
                    int iT = c4064uh.t();
                    Z00 z09 = this.b;
                    if (iT == z09.c[0]) {
                        z09.z9(pdfPTable, c4064uh.n(), 1, 1, font2);
                        this.b.z9(pdfPTable, "0", 1, 1, font3);
                        d2 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                    } else {
                        z09.z9(pdfPTable, "0", 1, 1, font3);
                        this.b.z9(pdfPTable, c4064uh.n(), 1, 1, font2);
                        d3 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                    }
                    this.b.z9(pdfPTable, c4064uh.h(), 0, 1, font2);
                    this.b.z9(pdfPTable, Integer.parseInt(c4064uh.a()) <= 0 ? " " : c4064uh.a(), 0, 1, font2);
                    this.b.z9(pdfPTable, c4064uh.p(), 0, 1, font2);
                } else {
                    font2 = font4;
                    font3 = font;
                    this.b.z9(pdfPTable, c4064uh.p(), 2, 1, font2);
                    this.b.z9(pdfPTable, Integer.parseInt(c4064uh.a()) <= 0 ? " " : c4064uh.a(), 2, 1, font2);
                    this.b.z9(pdfPTable, c4064uh.h(), 2, 1, font2);
                    int iT2 = c4064uh.t();
                    Z00 z010 = this.b;
                    if (iT2 == z010.c[0]) {
                        z010.z9(pdfPTable, "0", 1, 1, font3);
                        this.b.z9(pdfPTable, c4064uh.n(), 1, 1, font2);
                        d2 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                    } else {
                        z010.z9(pdfPTable, c4064uh.n(), 1, 1, font2);
                        this.b.z9(pdfPTable, "0", 1, 1, font3);
                        d3 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                    }
                    this.b.z9(pdfPTable, c4064uh.f(), 1, 1, font2);
                }
                i2++;
                str2 = str2;
                font4 = font2;
                font = font3;
                font6 = font6;
            }
            Font font8 = font6;
            String str3 = str2;
            Font font9 = font;
            if (Z00.X.equals(str3)) {
                this.b.z9(pdfPTable, "-", 1, 1, font9);
                Z00 z011 = this.b;
                z011.z9(pdfPTable, z011.P7(String.valueOf(d2)), 1, 1, font8);
                Z00 z012 = this.b;
                z012.z9(pdfPTable, z012.P7(String.valueOf(d3)), 1, 1, font8);
                this.b.z9(pdfPTable, this.a.getString(R.string.total), 0, 3, font8);
            } else {
                this.b.z9(pdfPTable, this.a.getString(R.string.total), 2, 3, font8);
                Z00 z013 = this.b;
                z013.z9(pdfPTable, z013.P7(String.valueOf(d3)), 1, 1, font8);
                Z00 z014 = this.b;
                z014.z9(pdfPTable, z014.P7(String.valueOf(d2)), 1, 1, font8);
                this.b.z9(pdfPTable, "-", 1, 1, font9);
            }
            if (Z00.X.equals(str3)) {
                if (d >= 0.0d) {
                    Z00 z015 = this.b;
                    z015.z9(pdfPTable, z015.P7(String.valueOf(Math.abs(d))), 1, 3, font8);
                    this.b.z9(pdfPTable, this.a.getString(R.string.net_total2), 0, 3, font8);
                } else {
                    Z00 z016 = this.b;
                    z016.z9(pdfPTable, z016.P7(String.valueOf(Math.abs(d))), 1, 3, font8);
                    this.b.z9(pdfPTable, this.a.getString(R.string.net_total1), 0, 3, font8);
                }
            } else if (d >= 0.0d) {
                this.b.z9(pdfPTable, this.a.getString(R.string.net_total2), 2, 3, font8);
                Z00 z017 = this.b;
                z017.z9(pdfPTable, z017.P7(String.valueOf(Math.abs(d))), 1, 3, font8);
            } else {
                this.b.z9(pdfPTable, this.a.getString(R.string.net_total1), 0, 3, font8);
                Z00 z018 = this.b;
                z018.z9(pdfPTable, z018.P7(String.valueOf(Math.abs(d))), 1, 3, font8);
            }
            paragraph.add((Element) pdfPTable);
            document.add(paragraph);
            document.close();
        } catch (DocumentException e) {
            Log.e("PDFCreator", "DocumentException:" + e);
        } catch (IOException e2) {
            Log.e("PDFCreator", "ioException:" + e2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void g(RecyclerView recyclerView, String str, double d, String str2, String str3, String str4, String str5) {
        String str6;
        DocumentException documentException;
        IOException iOException;
        String str7;
        String str8;
        String str9 = "PDFCreator";
        String str10 = "L";
        Rectangle rectangle = PageSize.A4;
        Document document = new Document(rectangle, 15.0f, 15.0f, 5.0f, 10.0f);
        new DecimalFormat("0.00");
        try {
            try {
                try {
                    File file = new File(Z00.L);
                    if (!file.exists()) {
                        try {
                            file.mkdirs();
                        } catch (IOException e) {
                            iOException = e;
                            str6 = "PDFCreator";
                            Log.e(str6, "ioException:" + iOException);
                        }
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".pdf"));
                    BaseFont baseFontCreateFont = BaseFont.createFont(Z00.N, BaseFont.IDENTITY_H, true);
                    Font font = new Font(baseFontCreateFont, 10.0f);
                    str6 = "PDFCreator";
                    try {
                        Font font2 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(32, 48, 76));
                        Font font3 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(50, 50, 50));
                        Font font4 = new Font(baseFontCreateFont, 10.0f, 0, new BaseColor(94, 16, 37));
                        Font font5 = new Font(baseFontCreateFont, 10.0f, 0, new BaseColor(42, 89, 76));
                        Font font6 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(94, 16, 37));
                        Font font7 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(42, 89, 76));
                        Font font8 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(255, 255, 255));
                        BaseColor baseColor = new BaseColor(224, 224, 224);
                        PdfWriter.getInstance(document, fileOutputStream).setPageEvent(new Z00.G1());
                        document.open();
                        document.setPageSize(rectangle);
                        new Paragraph("").setAlignment(1);
                        float[] fArr = {2.5f, 2.5f, 2.5f, 6.5f, 2.3f, 2.0f, 2.7f};
                        this.b.z7();
                        if (Z00.X.equals("R")) {
                            fArr = new float[]{2.5f, 2.0f, 2.0f, 6.0f, 2.5f, 2.5f, 2.5f};
                        }
                        boolean zJa = this.b.ja("pref_hide_doc_col", true);
                        if (zJa) {
                            fArr = new float[]{2.5f, 2.5f, 2.5f, 6.3f, 2.3f, 2.4f};
                        }
                        PdfPTable pdfPTable = new PdfPTable(fArr);
                        pdfPTable.setWidthPercentage(100.0f);
                        pdfPTable.addCell(this.b.w(font2, font, this.a.getString(R.string.cus_det_title) + str5, str3, str4, zJa ? 6 : 7));
                        if (Z00.X.equals("L")) {
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_bal), 1, 1, font3, baseColor);
                            Z00 z00 = this.b;
                            z00.A9(pdfPTable, z00.Q2(), 1, 1, font3, baseColor);
                            Z00 z01 = this.b;
                            z01.A9(pdfPTable, z01.c5(), 1, 1, font3, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_details), 0, 1, font3, baseColor);
                            if (!zJa) {
                                this.b.A9(pdfPTable, this.a.getString(R.string.doc_type2), 0, 1, font3, baseColor);
                            }
                            this.b.A9(pdfPTable, this.a.getString(R.string.bill_no_doc), 0, 1, font3, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_date), 0, 1, font3, baseColor);
                        } else {
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_date), 2, 1, font3, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.bill_no_doc), 2, 1, font3, baseColor);
                            if (!zJa) {
                                this.b.A9(pdfPTable, this.a.getString(R.string.doc_type2), 0, 1, font3, baseColor);
                            }
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_details), 2, 1, font3, baseColor);
                            Z00 z02 = this.b;
                            z02.A9(pdfPTable, z02.c5(), 1, 1, font3, baseColor);
                            Z00 z03 = this.b;
                            z03.A9(pdfPTable, z03.Q2(), 1, 1, font3, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_bal), 1, 1, font3, baseColor);
                        }
                        pdfPTable.setHeaderRows(this.b.k + 1);
                        Z00.T = this.b.ia("PREF_ACCOUNT_NAME", "###");
                        List listC = ((C4330y1) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).c();
                        pdfPTable.setComplete(false);
                        double d2 = 0.0d;
                        double d3 = 0.0d;
                        double d4 = 0.0d;
                        double d5 = 0.0d;
                        int i = 0;
                        while (i < listC.size()) {
                            C4064uh c4064uh = (C4064uh) listC.get(i);
                            List list = listC;
                            if (Z00.X.equals(str10)) {
                                this.b.z9(pdfPTable, c4064uh.f(), 1, 1, Double.parseDouble(c4064uh.f().replaceAll(",", "")) > 0.0d ? font4 : font5);
                                int iT = c4064uh.t();
                                Z00 z04 = this.b;
                                if (iT == z04.c[0]) {
                                    z04.z9(pdfPTable, c4064uh.n(), 1, 1, font);
                                    this.b.z9(pdfPTable, "0", 1, 1, font8);
                                    if (c4064uh.a.equals("0")) {
                                        d4 = Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    } else {
                                        d2 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    }
                                } else {
                                    z04.z9(pdfPTable, "0", 1, 1, font8);
                                    this.b.z9(pdfPTable, c4064uh.n(), 1, 1, font);
                                    if (c4064uh.a.equals("0")) {
                                        d5 = Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    } else {
                                        d3 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    }
                                }
                                if ((this.b.Od(c4064uh) || zJa) && C1839c10.I(this.b)) {
                                    if (c4064uh.a().length() <= 0 || Double.parseDouble(c4064uh.a()) <= 0.0d) {
                                        Z00 z05 = this.b;
                                        z05.z9(pdfPTable, z05.D0(c4064uh.r(), c4064uh.a()), 0, 1, font);
                                    } else {
                                        Z00 z06 = this.b;
                                        z06.z9(pdfPTable, z06.D0(c4064uh.r(), c4064uh.a()).substring(0, c4064uh.r().length() - c4064uh.h().length()), 0, 1, font);
                                    }
                                } else if (this.b.Od(c4064uh) || zJa) {
                                    Z00 z07 = this.b;
                                    z07.z9(pdfPTable, z07.D0(c4064uh.r(), c4064uh.a()), 0, 1, font);
                                } else {
                                    this.b.z9(pdfPTable, (c4064uh.h() == null || !c4064uh.h().trim().equals("")) ? c4064uh.h() : "-", 0, 1, (c4064uh.h() == null || !c4064uh.h().trim().equals("")) ? font : font8);
                                }
                                if (!zJa) {
                                    this.b.z9(pdfPTable, c4064uh.e().equals("") ? "-" : c4064uh.e(), 1, 1, c4064uh.e().equals("") ? font8 : font);
                                }
                                this.b.z9(pdfPTable, c4064uh.k().equals("0") ? "-" : c4064uh.k(), 0, 1, c4064uh.k().equals("0") ? font8 : font);
                                this.b.z9(pdfPTable, c4064uh.p() + "", 0, 1, font);
                            } else {
                                this.b.z9(pdfPTable, c4064uh.p(), 2, 1, font);
                                this.b.z9(pdfPTable, c4064uh.k().equals("0") ? "-" : c4064uh.k(), 2, 1, c4064uh.k().equals("0") ? font8 : font);
                                if (!zJa) {
                                    this.b.z9(pdfPTable, c4064uh.e().equals("") ? "-" : c4064uh.e(), 1, 1, c4064uh.e().equals("") ? font8 : font);
                                }
                                if (this.b.Od(c4064uh) || zJa) {
                                    Z00 z08 = this.b;
                                    z08.z9(pdfPTable, z08.D0(c4064uh.r(), c4064uh.a()), 0, 1, font);
                                } else {
                                    this.b.z9(pdfPTable, (c4064uh.h() == null || !c4064uh.h().trim().equals("")) ? c4064uh.h() : "-", 0, 1, (c4064uh.h() == null || !c4064uh.h().trim().equals("")) ? font : font8);
                                }
                                int iT2 = c4064uh.t();
                                Z00 z09 = this.b;
                                if (iT2 == z09.c[0]) {
                                    z09.z9(pdfPTable, "0", 1, 1, font8);
                                    this.b.z9(pdfPTable, c4064uh.n(), 1, 1, font);
                                    if (c4064uh.a.equals("0")) {
                                        d4 = Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    } else {
                                        d2 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    }
                                } else {
                                    z09.z9(pdfPTable, c4064uh.n(), 1, 1, font);
                                    this.b.z9(pdfPTable, "0", 1, 1, font8);
                                    if (c4064uh.a.equals("0")) {
                                        d5 = Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    } else {
                                        d3 += Double.parseDouble(c4064uh.n().replaceAll(",", ""));
                                    }
                                }
                                this.b.z9(pdfPTable, c4064uh.f(), 1, 1, Double.parseDouble(c4064uh.f().replaceAll(",", "")) > 0.0d ? font4 : font5);
                            }
                            if (i % c == 0) {
                                document.add(pdfPTable);
                            }
                            i++;
                            listC = list;
                            str10 = str10;
                        }
                        String str11 = str10;
                        this.b.z9(pdfPTable, "-", 1, 1, font8);
                        Z00 z010 = this.b;
                        z010.z9(pdfPTable, z010.P7(String.valueOf(d2)), 1, 1, font2);
                        Z00 z011 = this.b;
                        z011.z9(pdfPTable, z011.P7(String.valueOf(d3)), 1, 1, font2);
                        if (d4 == 0.0d && d5 == 0.0d) {
                            this.b.z9(pdfPTable, this.a.getString(R.string.total_det), 0, zJa ? 3 : 4, font2);
                        } else {
                            this.b.z9(pdfPTable, this.a.getString(R.string.total_det2), 0, zJa ? 3 : 4, font2);
                        }
                        if (d4 != 0.0d || d5 != 0.0d) {
                            if (this.b.ja("prefOthers_footer2_total", false)) {
                                this.b.z9(pdfPTable, "-", 1, 1, font8);
                                Z00 z012 = this.b;
                                double d6 = d2 + d4;
                                z012.z9(pdfPTable, z012.P7(String.valueOf(d6)), 1, 1, d6 == 0.0d ? font8 : font2);
                                Z00 z013 = this.b;
                                double d7 = d3 + d5;
                                z013.z9(pdfPTable, z013.P7(String.valueOf(d7)), 1, 1, d7 == 0.0d ? font8 : font2);
                                this.b.z9(pdfPTable, this.a.getString(R.string.total_det), 0, zJa ? 3 : 4, font2);
                            } else {
                                this.b.z9(pdfPTable, "-", 1, 1, font8);
                                Z00 z014 = this.b;
                                z014.z9(pdfPTable, z014.P7(String.valueOf(d4)), 1, 1, d4 == 0.0d ? font8 : font2);
                                Z00 z015 = this.b;
                                z015.z9(pdfPTable, z015.P7(String.valueOf(d5)), 1, 1, d5 == 0.0d ? font8 : font2);
                                this.b.z9(pdfPTable, this.a.getString(R.string.old_balance), 0, zJa ? 3 : 4, font2);
                            }
                        }
                        double d8 = ((d2 - d3) + d4) - d5;
                        if (!Z00.X.equals(str11)) {
                            str7 = str2;
                            if (d8 >= 0.0d) {
                                Z00 z016 = this.b;
                                z016.z9(pdfPTable, z016.R2(), 0, zJa ? 3 : 4, font2);
                                this.b.z9(pdfPTable, this.b.P7(String.valueOf(Math.abs(d8))) + " " + str7, 1, 3, font7);
                            } else {
                                Z00 z017 = this.b;
                                z017.z9(pdfPTable, z017.d5(), 0, zJa ? 3 : 4, font2);
                                this.b.z9(pdfPTable, this.b.P7(String.valueOf(Math.abs(d8))) + " " + str7, 1, 3, font6);
                            }
                        } else if (d8 >= 0.0d) {
                            Z00 z018 = this.b;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.b.P7(String.valueOf(Math.abs(d8))));
                            sb.append(" ");
                            str7 = str2;
                            sb.append(str7);
                            z018.z9(pdfPTable, sb.toString(), 1, 3, font7);
                            Z00 z019 = this.b;
                            z019.z9(pdfPTable, z019.R2(), 0, zJa ? 3 : 4, font2);
                        } else {
                            str7 = str2;
                            this.b.z9(pdfPTable, this.b.P7(String.valueOf(Math.abs(d8))) + " " + str7, 1, 3, font6);
                            Z00 z020 = this.b;
                            z020.z9(pdfPTable, z020.d5(), 0, zJa ? 3 : 4, font2);
                        }
                        if (d8 != 0.0d && this.b.ja("pref_num_words", false)) {
                            Z00 z021 = this.b;
                            if (d8 >= 0.0d) {
                                str8 = this.b.Q2() + " : " + this.b.Fa(Math.abs(d8), str7);
                            } else {
                                str8 = this.b.c5() + " : " + this.b.Fa(Math.abs(d8), str7);
                            }
                            z021.z9(pdfPTable, str8, 1, zJa ? 6 : 7, font);
                        }
                        if (this.b.ia("pref_print_remarks", "").trim().length() != 0) {
                            this.b.B9(pdfPTable, "* " + this.b.ia("pref_print_remarks", ""), 0, zJa ? 6 : 7, font, true);
                        }
                        pdfPTable.setComplete(true);
                        document.add(pdfPTable);
                        document.close();
                    } catch (DocumentException e2) {
                        documentException = e2;
                        str9 = str6;
                        Log.e(str9, "DocumentException:" + documentException);
                    } catch (IOException e3) {
                        e = e3;
                        iOException = e;
                        Log.e(str6, "ioException:" + iOException);
                    }
                } catch (DocumentException e4) {
                    e = e4;
                    documentException = e;
                    Log.e(str9, "DocumentException:" + documentException);
                }
            } catch (IOException e5) {
                e = e5;
                str6 = "PDFCreator";
            }
        } catch (DocumentException e6) {
            e = e6;
        }
    }

    public void h(RecyclerView recyclerView, String str, double d, String str2, String str3, String str4) {
        String str5;
        DocumentException documentException;
        IOException iOException;
        Font font;
        String str6 = "PDFCreator";
        String str7 = "";
        Document document = new Document();
        new DecimalFormat("0.00");
        try {
            try {
                try {
                    File file = new File(Z00.L);
                    if (!file.exists()) {
                        try {
                            file.mkdirs();
                        } catch (IOException e) {
                            iOException = e;
                            str5 = "PDFCreator";
                            Log.e(str5, "ioException:" + iOException);
                        }
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".pdf"));
                    BaseFont baseFontCreateFont = BaseFont.createFont(Z00.N, BaseFont.IDENTITY_H, true);
                    Font font2 = new Font(baseFontCreateFont, 12.0f);
                    new Font(baseFontCreateFont, 12.0f, 1, new BaseColor(0, 0, 0));
                    Font font3 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(32, 48, 76));
                    Font font4 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(50, 50, 50));
                    str5 = "PDFCreator";
                    try {
                        new Font(baseFontCreateFont, 12.0f, 0, new BaseColor(94, 16, 37));
                        new Font(baseFontCreateFont, 12.0f, 0, new BaseColor(42, 89, 76));
                        new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(94, 16, 37));
                        new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(42, 89, 76));
                        Font font5 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(255, 255, 255));
                        BaseColor baseColor = new BaseColor(224, 224, 224);
                        PdfWriter.getInstance(document, fileOutputStream).setPageEvent(new Z00.G1());
                        document.open();
                        document.setPageSize(PageSize.A4);
                        new Paragraph("").setAlignment(1);
                        float[] fArr = {2.0f, 2.0f, 4.5f, 4.0f, 2.1f, 2.0f, 2.8f};
                        boolean zJa = this.b.ja("pref_hide_doc_col", false);
                        this.b.z7();
                        if (Z00.X.equals("R")) {
                            fArr = new float[]{2.8f, 2.0f, 2.1f, 4.0f, 4.5f, 2.0f, 2.0f};
                        }
                        if (zJa) {
                            fArr = new float[]{2.0f, 2.0f, 4.5f, 4.0f, 2.0f, 2.8f};
                        }
                        PdfPTable pdfPTable = new PdfPTable(fArr);
                        pdfPTable.setWidthPercentage(100.0f);
                        pdfPTable.addCell(this.b.w(font3, font2, str, str3, str4, zJa ? 6 : 7));
                        if (Z00.X.equals("L")) {
                            Z00 z00 = this.b;
                            z00.A9(pdfPTable, z00.Q2(), 1, 1, font4, baseColor);
                            Z00 z01 = this.b;
                            z01.A9(pdfPTable, z01.c5(), 1, 1, font4, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_details), 1, 1, font4, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.account_name), 0, 1, font4, baseColor);
                            if (!zJa) {
                                this.b.A9(pdfPTable, this.a.getString(R.string.doc_type2), 1, 1, font4, baseColor);
                            }
                            this.b.A9(pdfPTable, this.a.getString(R.string.doc_no_), 0, 1, font4, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_date), 0, 1, font4, baseColor);
                        } else {
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_date), 2, 1, font4, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.doc_no_), 0, 1, font4, baseColor);
                            if (!zJa) {
                                this.b.A9(pdfPTable, this.a.getString(R.string.doc_type2), 1, 1, font4, baseColor);
                            }
                            this.b.A9(pdfPTable, this.a.getString(R.string.account_name), 2, 1, font4, baseColor);
                            this.b.A9(pdfPTable, this.a.getString(R.string.tr_details), 1, 1, font4, baseColor);
                            Z00 z02 = this.b;
                            z02.A9(pdfPTable, z02.c5(), 1, 1, font4, baseColor);
                            Z00 z03 = this.b;
                            z03.A9(pdfPTable, z03.Q2(), 1, 1, font4, baseColor);
                        }
                        pdfPTable.setHeaderRows(this.b.k + 1);
                        pdfPTable.setComplete(false);
                        List listB = ((L1) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).b();
                        int i = 0;
                        double d2 = 0.0d;
                        double d3 = 0.0d;
                        while (i < listB.size()) {
                            C0795Oh c0795Oh = (C0795Oh) listB.get(i);
                            List list = listB;
                            if (Z00.X.equals("L")) {
                                int iR = c0795Oh.r();
                                Z00 z04 = this.b;
                                font = font3;
                                if (iR == z04.c[0]) {
                                    z04.z9(pdfPTable, c0795Oh.l(), 1, 1, font2);
                                    this.b.z9(pdfPTable, "0", 1, 1, font5);
                                    d2 += Double.parseDouble(c0795Oh.l().replaceAll(",", ""));
                                } else {
                                    z04.z9(pdfPTable, "0", 1, 1, font5);
                                    this.b.z9(pdfPTable, c0795Oh.l(), 1, 1, font2);
                                    d3 += Double.parseDouble(c0795Oh.l().replaceAll(",", ""));
                                }
                                Z00 z05 = this.b;
                                z05.z9(pdfPTable, z05.D0(c0795Oh.q(), c0795Oh.a()), 0, 1, font2);
                                this.b.z9(pdfPTable, c0795Oh.p(), 0, 1, font2);
                                if (!zJa) {
                                    this.b.z9(pdfPTable, c0795Oh.e().equals("") ? "-" : c0795Oh.e(), 1, 1, c0795Oh.e().equals("") ? font5 : font2);
                                }
                                this.b.z9(pdfPTable, c0795Oh.i().equals("0") ? "-" : c0795Oh.i(), 0, 1, c0795Oh.i().equals("0") ? font5 : font2);
                                this.b.z9(pdfPTable, c0795Oh.n(), 0, 1, font2);
                            } else {
                                font = font3;
                                this.b.z9(pdfPTable, c0795Oh.n(), 2, 1, font2);
                                this.b.z9(pdfPTable, c0795Oh.i().equals("0") ? "-" : c0795Oh.i(), 0, 1, c0795Oh.i().equals("0") ? font5 : font2);
                                if (!zJa) {
                                    this.b.z9(pdfPTable, c0795Oh.e().equals("") ? "-" : c0795Oh.e(), 1, 1, c0795Oh.e().equals("") ? font5 : font2);
                                }
                                this.b.z9(pdfPTable, c0795Oh.p(), 2, 1, font2);
                                Z00 z06 = this.b;
                                z06.z9(pdfPTable, z06.D0(c0795Oh.q(), c0795Oh.a()), 0, 1, font2);
                                int iR2 = c0795Oh.r();
                                Z00 z07 = this.b;
                                if (iR2 == z07.c[0]) {
                                    z07.z9(pdfPTable, "0", 1, 1, font5);
                                    this.b.z9(pdfPTable, c0795Oh.l(), 1, 1, font2);
                                    d2 += Double.parseDouble(c0795Oh.l().replaceAll(",", ""));
                                } else {
                                    z07.z9(pdfPTable, c0795Oh.l(), 1, 1, font2);
                                    this.b.z9(pdfPTable, "0", 1, 1, font5);
                                    d3 += Double.parseDouble(c0795Oh.l().replaceAll(",", ""));
                                }
                            }
                            if (i % c == 0) {
                                document.add(pdfPTable);
                            }
                            i++;
                            listB = list;
                            font3 = font;
                        }
                        Font font6 = font3;
                        if (Z00.X.equals("L")) {
                            Z00 z08 = this.b;
                            z08.z9(pdfPTable, z08.P7(String.valueOf(d2)), 1, 1, font6);
                            Z00 z09 = this.b;
                            z09.z9(pdfPTable, z09.P7(String.valueOf(d3)), 1, 1, font6);
                            this.b.z9(pdfPTable, this.a.getString(R.string.total_det), 0, zJa ? 4 : 5, font6);
                        } else {
                            this.b.z9(pdfPTable, this.a.getString(R.string.total_det), 2, zJa ? 4 : 5, font6);
                            Z00 z010 = this.b;
                            z010.z9(pdfPTable, z010.P7(String.valueOf(d3)), 1, 1, font6);
                            Z00 z011 = this.b;
                            z011.z9(pdfPTable, z011.P7(String.valueOf(d2)), 1, 1, font6);
                        }
                        if (Z00.X.equals("L")) {
                            if (d >= 0.0d) {
                                Z00 z012 = this.b;
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.b.P7(String.valueOf(Math.abs(d))));
                                if (Z00.Z) {
                                    str7 = " " + str2;
                                }
                                sb.append(str7);
                                z012.z9(pdfPTable, sb.toString(), 1, 3, font6);
                                Z00 z013 = this.b;
                                z013.z9(pdfPTable, z013.d5(), 0, zJa ? 3 : 4, font6);
                            } else {
                                Z00 z014 = this.b;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(this.b.P7(String.valueOf(Math.abs(d))));
                                if (Z00.Z) {
                                    str7 = " " + str2;
                                }
                                sb2.append(str7);
                                z014.z9(pdfPTable, sb2.toString(), 1, 3, font6);
                                Z00 z015 = this.b;
                                z015.z9(pdfPTable, z015.R2(), 0, zJa ? 3 : 4, font6);
                            }
                        } else if (d >= 0.0d) {
                            Z00 z016 = this.b;
                            z016.z9(pdfPTable, z016.d5(), 2, zJa ? 3 : 4, font6);
                            Z00 z017 = this.b;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.b.P7(String.valueOf(Math.abs(d))));
                            if (Z00.Z) {
                                str7 = " " + str2;
                            }
                            sb3.append(str7);
                            z017.z9(pdfPTable, sb3.toString(), 1, 3, font6);
                        } else {
                            Z00 z018 = this.b;
                            z018.z9(pdfPTable, z018.R2(), 2, zJa ? 3 : 4, font6);
                            Z00 z019 = this.b;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(this.b.P7(String.valueOf(Math.abs(d))));
                            if (Z00.Z) {
                                str7 = " " + str2;
                            }
                            sb4.append(str7);
                            z019.z9(pdfPTable, sb4.toString(), 1, 3, font6);
                        }
                        pdfPTable.setComplete(true);
                        document.add(pdfPTable);
                        document.close();
                    } catch (DocumentException e2) {
                        documentException = e2;
                        str6 = str5;
                        Log.e(str6, "DocumentException:" + documentException);
                    } catch (IOException e3) {
                        e = e3;
                        iOException = e;
                        Log.e(str5, "ioException:" + iOException);
                    }
                } catch (DocumentException e4) {
                    e = e4;
                    documentException = e;
                    Log.e(str6, "DocumentException:" + documentException);
                }
            } catch (IOException e5) {
                e = e5;
                str5 = "PDFCreator";
            }
        } catch (DocumentException e6) {
            e = e6;
        }
    }

    public void i(RecyclerView recyclerView, String str, String str2, String str3) throws Throwable {
        String str4;
        IOException iOException;
        String str5;
        DocumentException documentException;
        String str6;
        Exception exc;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        Font font;
        Document document;
        String str12;
        Font font2;
        String str13;
        PdfPTable pdfPTable;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        int i;
        Document document2;
        PdfPTable pdfPTable2;
        String str20;
        String str21 = "L";
        Rectangle rectangle = PageSize.A4;
        Document document3 = new Document(rectangle, 15.0f, 15.0f, 5.0f, 10.0f);
        new DecimalFormat("0.00");
        try {
            try {
                try {
                    try {
                        File file = new File(Z00.L);
                        if (!file.exists()) {
                            try {
                                file.mkdirs();
                            } catch (DocumentException e) {
                                documentException = e;
                                str5 = "PDFCreator";
                                Log.e(str5, "DocumentException:" + documentException);
                                return;
                            } catch (IOException e2) {
                                iOException = e2;
                                str4 = "PDFCreator";
                                Log.e(str4, "ioException:" + iOException);
                                return;
                            } catch (Exception e3) {
                                exc = e3;
                                str6 = "PDFCreator";
                            }
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".pdf"));
                        BaseFont baseFontCreateFont = BaseFont.createFont(Z00.N, BaseFont.IDENTITY_H, true);
                        Font font3 = new Font(baseFontCreateFont, 10.0f);
                        str6 = "PDFCreator";
                        try {
                            try {
                                new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(0, 0, 0));
                                String str22 = "-";
                                Font font4 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(32, 48, 76));
                                Font font5 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(50, 50, 50));
                                BaseColor baseColor = new BaseColor(224, 224, 224);
                                PdfWriter.getInstance(document3, fileOutputStream).setPageEvent(new Z00.G1());
                                document3.open();
                                document3.setPageSize(rectangle);
                                new Paragraph("").setAlignment(1);
                                try {
                                    float[] fArr = {1.0f, 2.0f, 2.0f, 3.0f, 2.0f, 2.0f};
                                    this.b.z7();
                                    if (Z00.X.equals("R")) {
                                        fArr = new float[]{2.0f, 2.0f, 2.0f, 3.0f, 2.0f, 1.0f};
                                    }
                                    PdfPTable pdfPTable3 = new PdfPTable(fArr);
                                    pdfPTable3.setWidthPercentage(100.0f);
                                    pdfPTable3.addCell(this.b.w(font4, font3, str, str2, str3, 6));
                                    if (Z00.X.equals("L")) {
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.currency), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.tr_amount), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.branch_name), 0, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.name), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.date), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.bill_no), 1, 1, font5, baseColor);
                                    } else {
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.bill_no), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.date), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.name), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.branch_name), 0, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.tr_amount), 1, 1, font5, baseColor);
                                        this.b.A9(pdfPTable3, this.a.getString(R.string.currency), 1, 1, font5, baseColor);
                                    }
                                    pdfPTable3.setHeaderRows(2);
                                    new ArrayList();
                                    ArrayList arrayListK3 = this.b.k3();
                                    String strReplaceAll = this.b.n2("1").replaceAll("- مرتجع", "");
                                    String strReplaceAll2 = this.b.n2("2").replaceAll("- مرتجع", "");
                                    List listC = ((C4279xM) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).c();
                                    pdfPTable3.setComplete(false);
                                    int i2 = 0;
                                    while (true) {
                                        str7 = "tot7";
                                        str8 = strReplaceAll;
                                        str9 = "tot4";
                                        str10 = strReplaceAll2;
                                        str11 = "tot2";
                                        font = font4;
                                        document = document3;
                                        str12 = "tot5";
                                        font2 = font3;
                                        str13 = "tot3";
                                        pdfPTable = pdfPTable3;
                                        str14 = "tot";
                                        String str23 = "name";
                                        if (i2 >= listC.size()) {
                                            break;
                                        }
                                        try {
                                            C4145vh c4145vh = (C4145vh) listC.get(i2);
                                            List list = listC;
                                            int i3 = i2;
                                            int i4 = 0;
                                            while (i4 < arrayListK3.size()) {
                                                String str24 = str23;
                                                if (((String) ((HashMap) arrayListK3.get(i4)).get(str23)).toString().equals(c4145vh.r())) {
                                                    if (!c4145vh.k().equals("0")) {
                                                        str20 = str21;
                                                        if (c4145vh.l().equals("2")) {
                                                            ((HashMap) arrayListK3.get(i4)).put("tot5", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot5")) + Double.parseDouble(c4145vh.q().replaceAll(",", ""))));
                                                        } else {
                                                            ((HashMap) arrayListK3.get(i4)).put("tot6", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot6")) + Double.parseDouble(c4145vh.q().replaceAll(",", ""))));
                                                        }
                                                    } else if (c4145vh.l().equals("2")) {
                                                        str20 = str21;
                                                        ((HashMap) arrayListK3.get(i4)).put("tot", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot")) + Double.parseDouble(c4145vh.q().replaceAll(",", ""))));
                                                    } else {
                                                        str20 = str21;
                                                        ((HashMap) arrayListK3.get(i4)).put("tot3", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot3")) + Double.parseDouble(c4145vh.q().replaceAll(",", ""))));
                                                    }
                                                    ((HashMap) arrayListK3.get(i4)).put("tot2", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot2")) + Double.parseDouble(c4145vh.t().replaceAll(",", ""))));
                                                    ((HashMap) arrayListK3.get(i4)).put("tot4", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot4")) + Double.parseDouble(c4145vh.i().replaceAll(",", ""))));
                                                    ((HashMap) arrayListK3.get(i4)).put("tot7", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot7")) + Double.parseDouble(c4145vh.m().replaceAll(",", ""))));
                                                } else {
                                                    str20 = str21;
                                                }
                                                i4++;
                                                str23 = str24;
                                                str21 = str20;
                                            }
                                            String str25 = str21;
                                            if (Z00.X.equals(str25)) {
                                                this.b.z9(pdfPTable, c4145vh.r(), 1, 1, font2);
                                                Z00 z00 = this.b;
                                                z00.z9(pdfPTable, z00.P7(c4145vh.q()), 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.p() + "", 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.o() + "", 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.n(), 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.a(), 1, 1, font2);
                                            } else {
                                                this.b.z9(pdfPTable, c4145vh.a(), 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.n(), 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.o(), 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.p(), 1, 1, font2);
                                                Z00 z01 = this.b;
                                                z01.z9(pdfPTable, z01.P7(c4145vh.q()), 1, 1, font2);
                                                this.b.z9(pdfPTable, c4145vh.r(), 1, 1, font2);
                                            }
                                            if (i3 % c == 0) {
                                                document2 = document;
                                                pdfPTable2 = pdfPTable;
                                                document2.add(pdfPTable2);
                                            } else {
                                                document2 = document;
                                                pdfPTable2 = pdfPTable;
                                            }
                                            strReplaceAll = str8;
                                            strReplaceAll2 = str10;
                                            str21 = str25;
                                            document3 = document2;
                                            font4 = font;
                                            font3 = font2;
                                            listC = list;
                                            i2 = i3 + 1;
                                            pdfPTable3 = pdfPTable2;
                                        } catch (DocumentException e4) {
                                            e = e4;
                                            documentException = e;
                                            str5 = str6;
                                            Log.e(str5, "DocumentException:" + documentException);
                                            return;
                                        } catch (IOException e5) {
                                            e = e5;
                                            iOException = e;
                                            str4 = str6;
                                            Log.e(str4, "ioException:" + iOException);
                                            return;
                                        } catch (Exception e6) {
                                            e = e6;
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                        exc = e;
                                        Log.e(str6, "Exception:" + exc);
                                        exc.printStackTrace();
                                        return;
                                    }
                                    String str26 = str21;
                                    int i5 = 0;
                                    while (i5 < arrayListK3.size()) {
                                        double d = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str14));
                                        double d2 = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str11));
                                        double d3 = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str13));
                                        double d4 = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str9));
                                        double d5 = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str12));
                                        double d6 = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get("tot6"));
                                        double d7 = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str7));
                                        if (d == 0.0d && d2 == 0.0d && d3 == 0.0d && d4 == 0.0d && d5 == 0.0d && d6 == 0.0d && d7 == 0.0d) {
                                            this.b.z9(pdfPTable, "", 1, 6, font2);
                                            str15 = str12;
                                            str16 = str14;
                                            str11 = str11;
                                            str9 = str9;
                                            str26 = str26;
                                            str17 = str22;
                                            i = 1;
                                            str18 = str10;
                                            str13 = str13;
                                            str19 = str8;
                                            str7 = str7;
                                        } else {
                                            str15 = str12;
                                            str16 = str14;
                                            if (Z00.X.equals(str26)) {
                                                if (d != 0.0d) {
                                                    Z00 z02 = this.b;
                                                    z02.z9(pdfPTable, z02.P7(String.valueOf(d)), 1, 3, font);
                                                    Z00 z03 = this.b;
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(this.a.getString(R.string.total));
                                                    sb.append(" - ");
                                                    str18 = str10;
                                                    sb.append(str18);
                                                    sb.append(" - ");
                                                    sb.append((String) ((HashMap) arrayListK3.get(i5)).get("name"));
                                                    z03.z9(pdfPTable, sb.toString(), 0, 3, font);
                                                } else {
                                                    str18 = str10;
                                                }
                                                if (d5 != 0.0d) {
                                                    Z00 z04 = this.b;
                                                    z04.z9(pdfPTable, z04.P7(String.valueOf(d5)), 1, 3, font);
                                                    Z00 z05 = this.b;
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append(this.a.getString(R.string.total));
                                                    sb2.append(" - ");
                                                    sb2.append(str18);
                                                    str17 = str22;
                                                    sb2.append(str17);
                                                    sb2.append(this.a.getString(R.string.bill_back));
                                                    sb2.append(" - ");
                                                    sb2.append((String) ((HashMap) arrayListK3.get(i5)).get("name"));
                                                    z05.z9(pdfPTable, sb2.toString(), 0, 3, font);
                                                } else {
                                                    str17 = str22;
                                                }
                                                if (d3 != 0.0d) {
                                                    Z00 z06 = this.b;
                                                    z06.z9(pdfPTable, z06.P7(String.valueOf(d3)), 1, 3, font);
                                                    Z00 z07 = this.b;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(this.a.getString(R.string.total));
                                                    sb3.append(" - ");
                                                    str19 = str8;
                                                    sb3.append(str19);
                                                    sb3.append(" - ");
                                                    sb3.append((String) ((HashMap) arrayListK3.get(i5)).get("name"));
                                                    z07.z9(pdfPTable, sb3.toString(), 0, 3, font);
                                                } else {
                                                    str19 = str8;
                                                }
                                                if (d6 != 0.0d) {
                                                    Z00 z08 = this.b;
                                                    z08.z9(pdfPTable, z08.P7(String.valueOf(d6)), 1, 3, font);
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total) + " - " + str19 + str17 + this.a.getString(R.string.bill_back) + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                }
                                                if (d2 != 0.0d) {
                                                    Z00 z09 = this.b;
                                                    z09.z9(pdfPTable, z09.P7(String.valueOf(d2)), 1, 3, font);
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total_disc) + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                }
                                                if (d4 != 0.0d) {
                                                    Z00 z010 = this.b;
                                                    z010.z9(pdfPTable, z010.P7(String.valueOf(d4)), 1, 3, font);
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total_tax) + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                }
                                                if (d7 != 0.0d) {
                                                    Z00 z011 = this.b;
                                                    z011.z9(pdfPTable, z011.P7(String.valueOf(d7)), 1, 3, font);
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total_other_cost) + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                }
                                                i = 1;
                                            } else {
                                                str11 = str11;
                                                str9 = str9;
                                                str26 = str26;
                                                str17 = str22;
                                                str18 = str10;
                                                str13 = str13;
                                                str19 = str8;
                                                str7 = str7;
                                                if (d != 0.0d) {
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total) + " - " + str18 + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                    Z00 z012 = this.b;
                                                    z012.z9(pdfPTable, z012.P7(String.valueOf(d)), 1, 3, font);
                                                }
                                                if (d3 != 0.0d) {
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total) + " - " + str19 + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                    Z00 z013 = this.b;
                                                    z013.z9(pdfPTable, z013.P7(String.valueOf(d3)), 1, 3, font);
                                                }
                                                if (d2 != 0.0d) {
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total_disc) + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                    Z00 z014 = this.b;
                                                    z014.z9(pdfPTable, z014.P7(String.valueOf(d2)), 1, 3, font);
                                                }
                                                if (d4 != 0.0d) {
                                                    this.b.z9(pdfPTable, this.a.getString(R.string.total_tax) + " - " + ((String) ((HashMap) arrayListK3.get(i5)).get("name")), 0, 3, font);
                                                    Z00 z015 = this.b;
                                                    z015.z9(pdfPTable, z015.P7(String.valueOf(d4)), 1, 3, font);
                                                }
                                                i = 1;
                                            }
                                        }
                                        i5 += i;
                                        str12 = str15;
                                        str7 = str7;
                                        str14 = str16;
                                        str22 = str17;
                                        str8 = str19;
                                        str9 = str9;
                                        str26 = str26;
                                        str13 = str13;
                                        str10 = str18;
                                        str11 = str11;
                                    }
                                    pdfPTable.setComplete(true);
                                    document.add(pdfPTable);
                                    document.close();
                                } catch (DocumentException e7) {
                                    e = e7;
                                } catch (IOException e8) {
                                    e = e8;
                                }
                            } catch (Exception e9) {
                                e = e9;
                            }
                        } catch (DocumentException e10) {
                            e = e10;
                        } catch (IOException e11) {
                            e = e11;
                        }
                    } catch (DocumentException e12) {
                        e = e12;
                        str6 = "PDFCreator";
                    } catch (IOException e13) {
                        e = e13;
                        str6 = "PDFCreator";
                    }
                } catch (Exception e14) {
                    e = e14;
                    str6 = "PDFCreator";
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (DocumentException e15) {
            str5 = "PDFCreator";
            documentException = e15;
        } catch (IOException e16) {
            str4 = "PDFCreator";
            iOException = e16;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 36281. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void j(androidx.recyclerview.widget.RecyclerView r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, int r55) {
        /*
            Method dump skipped, instruction units count: 3628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3357m10.j(androidx.recyclerview.widget.RecyclerView, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 35441. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void k(java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60) {
        /*
            Method dump skipped, instruction units count: 3544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3357m10.k(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void l(RecyclerView recyclerView, String str, String str2, String str3) {
        String str4;
        IOException iOException;
        String str5;
        DocumentException documentException;
        String str6;
        Exception exc;
        Z00 z00;
        String str7;
        String str8;
        Document document;
        String str9;
        Paragraph paragraph;
        String str10;
        Font font;
        String str11;
        String str12;
        Object obj;
        String str13;
        String str14;
        String str15 = "L";
        Rectangle rectangle = PageSize.A4;
        Document document2 = document;
        Document document3 = new Document(rectangle, 15.0f, 15.0f, 5.0f, 10.0f);
        new DecimalFormat("0.00");
        try {
            try {
                try {
                    File file = new File(Z00.L);
                    if (!file.exists()) {
                        try {
                            file.mkdirs();
                        } catch (DocumentException e) {
                            documentException = e;
                            str5 = "PDFCreator";
                            Log.e(str5, "DocumentException:" + documentException);
                        } catch (IOException e2) {
                            iOException = e2;
                            str4 = "PDFCreator";
                            Log.e(str4, "ioException:" + iOException);
                        } catch (Exception e3) {
                            exc = e3;
                            str6 = "PDFCreator";
                            Log.e(str6, "Exception:" + exc);
                        }
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".pdf"));
                    BaseFont baseFontCreateFont = BaseFont.createFont(Z00.N, BaseFont.IDENTITY_H, true);
                    Font font2 = new Font(baseFontCreateFont, 10.0f);
                    Font font3 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(0, 0, 0));
                    str6 = "PDFCreator";
                    String str16 = "FETCH...PRINT CURR:";
                    try {
                        try {
                            Font font4 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(32, 48, 76));
                            Font font5 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(50, 50, 50));
                            Font font6 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(255, 255, 255));
                            BaseColor baseColor = new BaseColor(224, 224, 224);
                            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
                            this.b.e = defaultSharedPreferences.getString("prefUsername", "");
                            this.b.g = defaultSharedPreferences.getString("prefAddress", "");
                            this.b.i = defaultSharedPreferences.getString("prefPhone", "");
                            this.b.l = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintUser", false));
                            Z00.r0 = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintDate", true));
                            this.b.k = Integer.parseInt(defaultSharedPreferences.getString("prefSyncFrequency", "1"));
                            Z00 z01 = this.b;
                            z01.j = z01.ia("ImageDecode", "0");
                            PdfWriter.getInstance(document2, fileOutputStream).setPageEvent(new Z00.G1());
                            document2.open();
                            document2.setPageSize(rectangle);
                            Paragraph paragraph2 = new Paragraph("");
                            paragraph2.setAlignment(1);
                            try {
                                float[] fArr = {2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f};
                                this.b.z7();
                                PdfPTable pdfPTable = new PdfPTable(fArr);
                                pdfPTable.setWidthPercentage(100.0f);
                                int i = 0;
                                while (true) {
                                    z00 = this.b;
                                    if (i >= z00.k) {
                                        break;
                                    }
                                    z00.z9(pdfPTable, "", 0, 7, font3);
                                    i++;
                                }
                                pdfPTable.addCell(z00.w(font4, font2, str, str2, str3, 7));
                                if (Z00.X.equals("L")) {
                                    this.b.A9(pdfPTable, this.a.getString(R.string.currency), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.doc_remarks), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.total_sum), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.account_name), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.doc_type), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.date2), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.daily_doc_no), 1, 1, font5, baseColor);
                                } else {
                                    this.b.A9(pdfPTable, this.a.getString(R.string.daily_doc_no), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.date2), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.doc_type), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.account_name), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.total_sum), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.doc_remarks), 1, 1, font5, baseColor);
                                    this.b.A9(pdfPTable, this.a.getString(R.string.currency), 1, 1, font5, baseColor);
                                }
                                pdfPTable.setHeaderRows(this.b.k + 1);
                                new ArrayList();
                                ArrayList arrayListK3 = this.b.k3();
                                List listC = ((C4360yM) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).c();
                                int i2 = 0;
                                while (true) {
                                    str7 = "tot3";
                                    str8 = "6";
                                    document = document2;
                                    str9 = "tot";
                                    paragraph = paragraph2;
                                    str10 = "5";
                                    font = font4;
                                    String str17 = "name";
                                    if (i2 >= listC.size()) {
                                        break;
                                    }
                                    C4145vh c4145vh = (C4145vh) listC.get(i2);
                                    List list = listC;
                                    int i3 = i2;
                                    int i4 = 0;
                                    while (i4 < arrayListK3.size()) {
                                        String str18 = str17;
                                        if (((String) ((HashMap) arrayListK3.get(i4)).get(str17)).toString().equals(c4145vh.r())) {
                                            if (c4145vh.f().equals("5")) {
                                                ((HashMap) arrayListK3.get(i4)).put("tot", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot")) + Double.parseDouble(c4145vh.t().replaceAll(",", ""))));
                                            } else if (c4145vh.f().equals("6")) {
                                                ((HashMap) arrayListK3.get(i4)).put("tot3", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i4)).get("tot3")) + Double.parseDouble(c4145vh.t().replaceAll(",", ""))));
                                            }
                                        }
                                        i4++;
                                        str17 = str18;
                                    }
                                    if (Z00.X.equals("L")) {
                                        this.b.z9(pdfPTable, c4145vh.r(), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.p().equals("") ? "-" : c4145vh.p(), 1, 1, c4145vh.p().equals("") ? font6 : font2);
                                        Z00 z02 = this.b;
                                        z02.z9(pdfPTable, z02.P7(c4145vh.t()), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.u(), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.s(), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.n(), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.a(), 1, 1, font2);
                                    } else {
                                        this.b.z9(pdfPTable, c4145vh.a(), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.n(), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.s(), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.u(), 1, 1, font2);
                                        Z00 z03 = this.b;
                                        z03.z9(pdfPTable, z03.P7(c4145vh.t()), 1, 1, font2);
                                        this.b.z9(pdfPTable, c4145vh.p().equals("") ? "-" : c4145vh.p(), 1, 1, c4145vh.p().equals("") ? font6 : font2);
                                        this.b.z9(pdfPTable, c4145vh.r(), 1, 1, font2);
                                    }
                                    i2 = i3 + 1;
                                    listC = list;
                                    document2 = document;
                                    paragraph2 = paragraph;
                                    font4 = font;
                                }
                                Object obj2 = "name";
                                String str19 = "print_pdf=";
                                Log.d(str19, "BEFORE...PRINT CURR:" + arrayListK3.size() + ":7");
                                int i5 = 0;
                                while (i5 < arrayListK3.size()) {
                                    double d = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str9));
                                    double d2 = Double.parseDouble((String) ((HashMap) arrayListK3.get(i5)).get(str7));
                                    if (d != 0.0d) {
                                        str11 = str9;
                                        StringBuilder sb = new StringBuilder();
                                        str12 = str7;
                                        String str20 = str16;
                                        sb.append(str20);
                                        sb.append(d);
                                        Log.d(str19, sb.toString());
                                        if (Z00.X.equals(str15)) {
                                            Z00 z04 = this.b;
                                            z04.z9(pdfPTable, z04.P7(String.valueOf(d)), 1, 4, font);
                                            Z00 z05 = this.b;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(this.a.getString(R.string.total_det));
                                            sb2.append(" - ");
                                            sb2.append(this.b.X8(str10));
                                            sb2.append(" - ");
                                            obj = obj2;
                                            sb2.append((String) ((HashMap) arrayListK3.get(i5)).get(obj));
                                            z05.z9(pdfPTable, sb2.toString(), 0, 3, font);
                                            str16 = str20;
                                        } else {
                                            obj = obj2;
                                            Z00 z06 = this.b;
                                            StringBuilder sb3 = new StringBuilder();
                                            str16 = str20;
                                            sb3.append(this.a.getString(R.string.total_det));
                                            sb3.append(" - ");
                                            sb3.append(this.b.X8(str10));
                                            sb3.append(" - ");
                                            sb3.append((String) ((HashMap) arrayListK3.get(i5)).get(obj));
                                            z06.z9(pdfPTable, sb3.toString(), 0, 3, font);
                                            Z00 z07 = this.b;
                                            z07.z9(pdfPTable, z07.P7(String.valueOf(d)), 1, 4, font);
                                        }
                                    } else {
                                        str11 = str9;
                                        str12 = str7;
                                        obj = obj2;
                                    }
                                    if (d2 != 0.0d) {
                                        StringBuilder sb4 = new StringBuilder();
                                        String str21 = str16;
                                        sb4.append(str21);
                                        sb4.append(d2);
                                        str14 = str19;
                                        Log.d(str14, sb4.toString());
                                        if (Z00.X.equals(str15)) {
                                            str15 = str15;
                                            Z00 z08 = this.b;
                                            z08.z9(pdfPTable, z08.P7(String.valueOf(d2)), 1, 4, font);
                                            Z00 z09 = this.b;
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(this.a.getString(R.string.total_det));
                                            sb5.append(" - ");
                                            str13 = str8;
                                            sb5.append(this.b.X8(str13));
                                            sb5.append(" - ");
                                            sb5.append((String) ((HashMap) arrayListK3.get(i5)).get(obj));
                                            z09.z9(pdfPTable, sb5.toString(), 0, 3, font);
                                            str16 = str21;
                                        } else {
                                            str15 = str15;
                                            str13 = str8;
                                            Z00 z010 = this.b;
                                            StringBuilder sb6 = new StringBuilder();
                                            str16 = str21;
                                            sb6.append(this.a.getString(R.string.total_det));
                                            sb6.append(" - ");
                                            sb6.append(this.b.X8(str13));
                                            sb6.append(" - ");
                                            sb6.append((String) ((HashMap) arrayListK3.get(i5)).get(obj));
                                            z010.z9(pdfPTable, sb6.toString(), 0, 3, font);
                                            Z00 z011 = this.b;
                                            z011.z9(pdfPTable, z011.P7(String.valueOf(d2)), 1, 4, font);
                                        }
                                    } else {
                                        str13 = str8;
                                        str15 = str15;
                                        str14 = str19;
                                    }
                                    i5++;
                                    str10 = str10;
                                    str9 = str11;
                                    obj2 = obj;
                                    str19 = str14;
                                    str7 = str12;
                                    str8 = str13;
                                }
                                paragraph.add((Element) pdfPTable);
                                document.add(paragraph);
                                document.close();
                            } catch (DocumentException e4) {
                                e = e4;
                                documentException = e;
                                str5 = str6;
                                Log.e(str5, "DocumentException:" + documentException);
                            } catch (IOException e5) {
                                e = e5;
                                iOException = e;
                                str4 = str6;
                                Log.e(str4, "ioException:" + iOException);
                            }
                        } catch (Exception e6) {
                            e = e6;
                            exc = e;
                            Log.e(str6, "Exception:" + exc);
                        }
                    } catch (DocumentException e7) {
                        e = e7;
                    } catch (IOException e8) {
                        e = e8;
                    }
                } catch (DocumentException e9) {
                    e = e9;
                    str6 = "PDFCreator";
                } catch (IOException e10) {
                    e = e10;
                    str6 = "PDFCreator";
                }
            } catch (Exception e11) {
                e = e11;
                str6 = "PDFCreator";
            }
        } catch (DocumentException e12) {
            str5 = "PDFCreator";
            documentException = e12;
        } catch (IOException e13) {
            str4 = "PDFCreator";
            iOException = e13;
        }
    }

    public void m(RecyclerView recyclerView, String str, String str2, String str3) {
        String str4 = "print_pdf=";
        String str5 = "L";
        Rectangle rectangle = PageSize.A4;
        Document document = new Document(rectangle, 15.0f, 15.0f, 5.0f, 10.0f);
        new DecimalFormat("0.00");
        try {
            File file = new File(Z00.L);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".pdf"));
            BaseFont baseFontCreateFont = BaseFont.createFont(Z00.N, BaseFont.IDENTITY_H, true);
            Font font = new Font(baseFontCreateFont, 10.0f);
            new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(0, 0, 0));
            Font font2 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(32, 48, 76));
            Font font3 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(50, 50, 50));
            Font font4 = new Font(baseFontCreateFont, 10.0f, 1, new BaseColor(255, 255, 255));
            BaseColor baseColor = new BaseColor(224, 224, 224);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
            this.b.e = defaultSharedPreferences.getString("prefUsername", "");
            this.b.g = defaultSharedPreferences.getString("prefAddress", "");
            this.b.i = defaultSharedPreferences.getString("prefPhone", "");
            this.b.l = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintUser", false));
            Z00.r0 = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintDate", true));
            this.b.k = Integer.parseInt(defaultSharedPreferences.getString("prefSyncFrequency", "1"));
            Z00 z00 = this.b;
            z00.j = z00.ia("ImageDecode", "0");
            PdfWriter.getInstance(document, fileOutputStream).setPageEvent(new Z00.G1());
            document.open();
            document.setPageSize(rectangle);
            Paragraph paragraph = new Paragraph("");
            paragraph.setAlignment(1);
            this.b.z7();
            PdfPTable pdfPTable = new PdfPTable(new float[]{2.0f, 2.0f, 2.0f, 2.0f, 2.0f});
            pdfPTable.setWidthPercentage(100.0f);
            Font font5 = font4;
            pdfPTable.addCell(this.b.w(font2, font, str, str2, str3, 5));
            if (Z00.X.equals("L")) {
                this.b.A9(pdfPTable, this.a.getString(R.string.currency), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.doc_remarks), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.total_sum), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.date2), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.daily_tran_no), 1, 1, font3, baseColor);
            } else {
                this.b.A9(pdfPTable, this.a.getString(R.string.daily_tran_no), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.date2), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.total_sum), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.doc_remarks), 1, 1, font3, baseColor);
                this.b.A9(pdfPTable, this.a.getString(R.string.currency), 1, 1, font3, baseColor);
            }
            pdfPTable.setHeaderRows(this.b.k + 1);
            new ArrayList();
            ArrayList arrayListK3 = this.b.k3();
            List listC = ((C4360yM) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).c();
            int i = 0;
            while (true) {
                Font font6 = font5;
                if (i >= listC.size()) {
                    break;
                }
                C4145vh c4145vh = (C4145vh) listC.get(i);
                List list = listC;
                int i2 = 0;
                while (i2 < arrayListK3.size()) {
                    Document document2 = document;
                    if (((String) ((HashMap) arrayListK3.get(i2)).get("name")).toString().equals(c4145vh.q())) {
                        ((HashMap) arrayListK3.get(i2)).put("tot", String.valueOf(Double.parseDouble((String) ((HashMap) arrayListK3.get(i2)).get("tot")) + Double.parseDouble(c4145vh.o().replaceAll(",", ""))));
                    }
                    i2++;
                    document = document2;
                }
                Document document3 = document;
                if (Z00.X.equals("L")) {
                    this.b.z9(pdfPTable, c4145vh.q(), 1, 1, font);
                    this.b.z9(pdfPTable, c4145vh.p().equals("") ? "-" : c4145vh.p(), 1, 1, c4145vh.p().equals("") ? font6 : font);
                    this.b.z9(pdfPTable, c4145vh.o(), 1, 1, font);
                    this.b.z9(pdfPTable, c4145vh.n() + "", 1, 1, font);
                    this.b.z9(pdfPTable, c4145vh.a(), 1, 1, font);
                } else {
                    this.b.z9(pdfPTable, c4145vh.a(), 1, 1, font);
                    this.b.z9(pdfPTable, c4145vh.n(), 1, 1, font);
                    this.b.z9(pdfPTable, c4145vh.o(), 1, 1, font);
                    this.b.z9(pdfPTable, c4145vh.p().equals("") ? "-" : c4145vh.p(), 1, 1, c4145vh.p().equals("") ? font6 : font);
                    this.b.z9(pdfPTable, c4145vh.q(), 1, 1, font);
                }
                i++;
                listC = list;
                font5 = font6;
                document = document3;
            }
            DocListener docListener = document;
            Log.d("print_pdf=", "BEFORE...PRINT CURR:" + arrayListK3.size() + ":5");
            int i3 = 0;
            while (i3 < arrayListK3.size()) {
                double d = Double.parseDouble((String) ((HashMap) arrayListK3.get(i3)).get("tot"));
                Double.parseDouble((String) ((HashMap) arrayListK3.get(i3)).get("tot3"));
                if (d != 0.0d) {
                    Log.d(str4, "FETCH...PRINT CURR:" + d);
                    if (Z00.X.equals(str5)) {
                        Z00 z01 = this.b;
                        z01.z9(pdfPTable, z01.P7(String.valueOf(d)), 1, 3, font2);
                        this.b.z9(pdfPTable, this.a.getString(R.string.total_det) + " - " + ((String) ((HashMap) arrayListK3.get(i3)).get("name")), 0, 2, font2);
                    } else {
                        this.b.z9(pdfPTable, this.a.getString(R.string.total_det) + " - " + ((String) ((HashMap) arrayListK3.get(i3)).get("name")), 0, 2, font2);
                        Z00 z02 = this.b;
                        z02.z9(pdfPTable, z02.P7(String.valueOf(d)), 1, 3, font2);
                    }
                }
                i3++;
                str4 = str4;
                str5 = str5;
            }
            paragraph.add((Element) pdfPTable);
            docListener.add(paragraph);
            docListener.close();
        } catch (DocumentException e) {
            Log.e("PDFCreator1", "DocumentException:" + e);
        } catch (IOException e2) {
            Log.e("PDFCreator2", "ioException:" + e2);
        } catch (Exception e3) {
            Log.e("PDFCreator3", "Exception:" + e3);
            e3.printStackTrace();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void n(RecyclerView recyclerView, String str, String str2, String str3) {
        String str4;
        IOException iOException;
        String str5;
        DocumentException documentException;
        String str6;
        Exception exc;
        Z00 z00;
        Font font;
        String str7;
        String str8 = "  ";
        Document document = new Document();
        new DecimalFormat("0.00");
        try {
            try {
                try {
                    try {
                        File file = new File(Z00.L);
                        if (!file.exists()) {
                            try {
                                file.mkdirs();
                            } catch (DocumentException e) {
                                documentException = e;
                                str5 = "PDFCreator";
                                Log.e(str5, "DocumentException:" + documentException);
                            } catch (IOException e2) {
                                iOException = e2;
                                str4 = "PDFCreator";
                                Log.e(str4, "ioException:" + iOException);
                            } catch (Exception e3) {
                                exc = e3;
                                str6 = "PDFCreator";
                                Log.e(str6, "Exception:" + exc);
                            }
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str + ".pdf"));
                        BaseFont baseFontCreateFont = BaseFont.createFont(Z00.N, BaseFont.IDENTITY_H, true);
                        Font font2 = new Font(baseFontCreateFont, 12.0f);
                        Font font3 = new Font(baseFontCreateFont, 12.0f, 1, new BaseColor(0, 0, 0));
                        Font font4 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(32, 48, 76));
                        Font font5 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(0, 0, 0));
                        new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(255, 0, 0));
                        new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(0, 255, 0));
                        Font font6 = new Font(baseFontCreateFont, 13.0f, 1, new BaseColor(255, 255, 255));
                        Font font7 = new Font(baseFontCreateFont, 15.0f, 1, new BaseColor(0, 0, 0));
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
                        this.b.e = defaultSharedPreferences.getString("prefUsername", "");
                        this.b.g = defaultSharedPreferences.getString("prefAddress", "");
                        this.b.i = defaultSharedPreferences.getString("prefPhone", "");
                        this.b.l = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintUser", false));
                        Z00.r0 = Boolean.valueOf(defaultSharedPreferences.getBoolean("prefPrintDate", true));
                        this.b.k = Integer.parseInt(defaultSharedPreferences.getString("prefSyncFrequency", "1"));
                        Z00 z01 = this.b;
                        z01.j = z01.ia("ImageDecode", "0");
                        PdfWriter.getInstance(document, fileOutputStream).setPageEvent(new Z00.G1());
                        document.open();
                        document.setPageSize(PageSize.A4);
                        new Paragraph("");
                        Paragraph paragraph = new Paragraph("");
                        paragraph.setAlignment(1);
                        try {
                            float[] fArr = {3.0f, 3.0f, 3.0f};
                            PdfPTable pdfPTable = new PdfPTable(fArr);
                            pdfPTable.setWidthPercentage(100.0f);
                            int i = 0;
                            while (true) {
                                z00 = this.b;
                                font = font7;
                                if (i >= z00.k - 1) {
                                    break;
                                }
                                int i2 = i;
                                z00.z9(pdfPTable, "", 0, 3, font3);
                                i = i2 + 1;
                                font7 = font;
                            }
                            str6 = "PDFCreator";
                            int i3 = 0;
                            try {
                                pdfPTable.addCell(z00.w(font4, font2, str, str2, str3, 3));
                                paragraph.add((Element) pdfPTable);
                                document.add(paragraph);
                                List listC = ((C4360yM) ((ConcatAdapter) recyclerView.getAdapter()).getAdapters().get(0)).c();
                                while (i3 < listC.size()) {
                                    C4145vh c4145vh = (C4145vh) listC.get(i3);
                                    List listN5 = this.b.n5(c4145vh.v() + "", this.b.p4(c4145vh.u()), "-3", c4145vh.n(), c4145vh.e());
                                    Paragraph paragraph2 = new Paragraph("");
                                    paragraph2.setAlignment(1);
                                    PdfPTable pdfPTable2 = new PdfPTable(fArr);
                                    pdfPTable2.setWidthPercentage(100.0f);
                                    paragraph2.setAlignment(1);
                                    List list = listC;
                                    this.b.z9(pdfPTable2, "", 0, 3, font3);
                                    this.b.z9(pdfPTable2, "", 0, 3, font3);
                                    BaseColor baseColorB = b();
                                    pdfPTable2.addCell(this.b.Ob(font4, "", 3, this.a.getString(R.string.doc_no) + str8 + c4145vh.a(), this.a.getString(R.string.doc_date) + str8 + c4145vh.n(), c4145vh.u()));
                                    this.b.B9(pdfPTable2, "", 1, 3, font5, true);
                                    String strS = c4145vh.s();
                                    Z00 z02 = this.b;
                                    StringBuilder sb = new StringBuilder();
                                    String str9 = str8;
                                    sb.append("سند ");
                                    sb.append(strS);
                                    z02.B9(pdfPTable2, sb.toString(), 1, 3, font, true);
                                    Font font8 = font2;
                                    this.b.B9(pdfPTable2, "", 0, 3, font8, true);
                                    String strG3 = this.b.g3(c4145vh.b());
                                    this.b.A9(pdfPTable2, this.b.S7(c4145vh.t()) + " " + strG3, 1, 1, font5, baseColorB);
                                    Z00 z03 = this.b;
                                    z03.z9(pdfPTable2, z03.Fa(Double.parseDouble(c4145vh.t().replaceAll(",", "")), c4145vh.b()), 0, 2, font5);
                                    if (strS.equals("قبض")) {
                                        str7 = "* " + this.a.getString(R.string.doc_account_hdr_in);
                                    } else if (strS.equals("صرف")) {
                                        str7 = "* " + this.a.getString(R.string.doc_account_hdr_out);
                                    } else {
                                        str7 = "";
                                    }
                                    this.b.z9(pdfPTable2, StringUtilities.LF + str7, 0, 3, font8);
                                    for (int size = listN5.size() - 1; size >= 0; size--) {
                                        C4145vh c4145vh2 = (C4145vh) listN5.get(size);
                                        this.b.z9(pdfPTable2, c4145vh2.o() + " " + this.b.g3(c4145vh2.n()), 0, 1, font8);
                                        this.b.z9(pdfPTable2, c4145vh2.p().equals("") ? "-" : c4145vh2.p(), 1, 1, c4145vh2.p().equals("") ? font6 : font8);
                                        this.b.z9(pdfPTable2, c4145vh2.a(), 0, 1, font8);
                                    }
                                    paragraph2.add((Element) pdfPTable2);
                                    document.add(paragraph2);
                                    i3++;
                                    listC = list;
                                    str8 = str9;
                                    font2 = font8;
                                }
                            } catch (DocumentException e4) {
                                e = e4;
                                documentException = e;
                                str5 = str6;
                                Log.e(str5, "DocumentException:" + documentException);
                            } catch (IOException e5) {
                                e = e5;
                                iOException = e;
                                str4 = str6;
                                Log.e(str4, "ioException:" + iOException);
                            } catch (Exception e6) {
                                e = e6;
                                exc = e;
                                Log.e(str6, "Exception:" + exc);
                            }
                        } catch (DocumentException e7) {
                            e = e7;
                            str6 = "PDFCreator";
                        } catch (IOException e8) {
                            e = e8;
                            str6 = "PDFCreator";
                        }
                    } catch (DocumentException e9) {
                        e = e9;
                        str6 = "PDFCreator";
                    } catch (IOException e10) {
                        e = e10;
                        str6 = "PDFCreator";
                    }
                } finally {
                    document.close();
                }
            } catch (Exception e11) {
                e = e11;
                str6 = "PDFCreator";
            }
        } catch (DocumentException e12) {
            str5 = "PDFCreator";
            documentException = e12;
        } catch (IOException e13) {
            str4 = "PDFCreator";
            iOException = e13;
        }
    }
}
