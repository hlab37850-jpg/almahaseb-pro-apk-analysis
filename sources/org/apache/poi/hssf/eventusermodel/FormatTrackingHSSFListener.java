package org.apache.poi.hssf.eventusermodel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class FormatTrackingHSSFListener implements HSSFListener {
    private final HSSFListener _childListener;
    private final Map<Integer, FormatRecord> _customFormatRecords;
    private final NumberFormat _defaultFormat;
    private final HSSFDataFormatter _formatter;
    private final List<ExtendedFormatRecord> _xfRecords;

    public FormatTrackingHSSFListener(HSSFListener hSSFListener) {
        this(hSSFListener, Locale.getDefault());
    }

    public String formatNumberDateCell(CellValueRecordInterface cellValueRecordInterface) {
        double value;
        if (cellValueRecordInterface instanceof NumberRecord) {
            value = ((NumberRecord) cellValueRecordInterface).getValue();
        } else {
            if (!(cellValueRecordInterface instanceof FormulaRecord)) {
                throw new IllegalArgumentException("Unsupported CellValue Record passed in " + cellValueRecordInterface);
            }
            value = ((FormulaRecord) cellValueRecordInterface).getValue();
        }
        int formatIndex = getFormatIndex(cellValueRecordInterface);
        String formatString = getFormatString(cellValueRecordInterface);
        return formatString == null ? this._defaultFormat.format(value) : this._formatter.formatRawCellContents(value, formatIndex, formatString);
    }

    public int getFormatIndex(CellValueRecordInterface cellValueRecordInterface) {
        ExtendedFormatRecord extendedFormatRecord = this._xfRecords.get(cellValueRecordInterface.getXFIndex());
        if (extendedFormatRecord != null) {
            return extendedFormatRecord.getFormatIndex();
        }
        System.err.println("Cell " + cellValueRecordInterface.getRow() + "," + ((int) cellValueRecordInterface.getColumn()) + " uses XF with index " + ((int) cellValueRecordInterface.getXFIndex()) + ", but we don't have that");
        return -1;
    }

    public String getFormatString(int i) {
        if (i < HSSFDataFormat.getNumberOfBuiltinBuiltinFormats()) {
            return HSSFDataFormat.getBuiltinFormat((short) i);
        }
        FormatRecord formatRecord = this._customFormatRecords.get(Integer.valueOf(i));
        if (formatRecord != null) {
            return formatRecord.getFormatString();
        }
        System.err.println("Requested format at index " + i + ", but it wasn't found");
        return null;
    }

    public int getNumberOfCustomFormats() {
        return this._customFormatRecords.size();
    }

    public int getNumberOfExtendedFormats() {
        return this._xfRecords.size();
    }

    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record record) {
        processRecordInternally(record);
        this._childListener.processRecord(record);
    }

    public void processRecordInternally(Record record) {
        if (record instanceof FormatRecord) {
            FormatRecord formatRecord = (FormatRecord) record;
            this._customFormatRecords.put(Integer.valueOf(formatRecord.getIndexCode()), formatRecord);
        }
        if (record instanceof ExtendedFormatRecord) {
            this._xfRecords.add((ExtendedFormatRecord) record);
        }
    }

    public FormatTrackingHSSFListener(HSSFListener hSSFListener, Locale locale) {
        this._customFormatRecords = new Hashtable();
        this._xfRecords = new ArrayList();
        this._childListener = hSSFListener;
        this._formatter = new HSSFDataFormatter(locale);
        this._defaultFormat = NumberFormat.getInstance(locale);
    }

    public String getFormatString(CellValueRecordInterface cellValueRecordInterface) {
        int formatIndex = getFormatIndex(cellValueRecordInterface);
        if (formatIndex == -1) {
            return null;
        }
        return getFormatString(formatIndex);
    }
}
