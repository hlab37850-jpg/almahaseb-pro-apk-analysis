package org.apache.poi.hssf.usermodel;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Annotation;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.DrawingRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.SubRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.formula.ExpPtg;
import org.apache.poi.hssf.record.formula.Ptg;
import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.ErrorConstants;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: classes4.dex */
public class HSSFCell implements Cell {
    public static final short ENCODING_COMPRESSED_UNICODE = 0;
    public static final short ENCODING_UNCHANGED = -1;
    public static final short ENCODING_UTF_16 = 1;
    private static final String FILE_FORMAT_NAME = "BIFF8";
    private static final String LAST_COLUMN_NAME;
    public static final int LAST_COLUMN_NUMBER;
    private static POILogger log = POILogFactory.getLogger(HSSFCell.class);
    private final HSSFWorkbook _book;
    private int _cellType;
    private HSSFComment _comment;
    private CellValueRecordInterface _record;
    private final HSSFSheet _sheet;
    private HSSFRichTextString _stringValue;

    static {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL97;
        LAST_COLUMN_NUMBER = spreadsheetVersion.getLastColumnIndex();
        LAST_COLUMN_NAME = spreadsheetVersion.getLastColumnName();
    }

    public HSSFCell(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, int i, short s) {
        checkBounds(s);
        this._stringValue = null;
        this._book = hSSFWorkbook;
        this._sheet = hSSFSheet;
        setCellType(3, false, i, s, hSSFSheet.getSheet().getXFIndexForColAt(s));
    }

    private static void checkBounds(int i) {
        if (i < 0 || i > LAST_COLUMN_NUMBER) {
            throw new IllegalArgumentException("Invalid column index (" + i + ").  Allowable column range for " + FILE_FORMAT_NAME + " is (0.." + LAST_COLUMN_NUMBER + ") or ('A'..'" + LAST_COLUMN_NAME + "')");
        }
    }

    private static void checkFormulaCachedValueType(int i, FormulaRecord formulaRecord) {
        int cachedResultType = formulaRecord.getCachedResultType();
        if (cachedResultType != i) {
            throw typeMismatch(i, cachedResultType, true);
        }
    }

    private boolean convertCellValueToBoolean() {
        int i = this._cellType;
        if (i == 0) {
            return ((NumberRecord) this._record).getValue() != 0.0d;
        }
        if (i == 1) {
            return Boolean.valueOf(this._book.getWorkbook().getSSTString(((LabelSSTRecord) this._record).getSSTIndex()).getString()).booleanValue();
        }
        if (i == 2) {
            FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
            checkFormulaCachedValueType(4, formulaRecord);
            return formulaRecord.getCachedBooleanValue();
        }
        if (i != 3) {
            if (i == 4) {
                return ((BoolErrRecord) this._record).getBooleanValue();
            }
            if (i != 5) {
                throw new RuntimeException("Unexpected cell type (" + this._cellType + ")");
            }
        }
        return false;
    }

    private String convertCellValueToString() {
        int i = this._cellType;
        if (i == 0) {
            return NumberToTextConverter.toText(((NumberRecord) this._record).getValue());
        }
        if (i == 1) {
            return this._book.getWorkbook().getSSTString(((LabelSSTRecord) this._record).getSSTIndex()).getString();
        }
        if (i != 2) {
            if (i == 3) {
                return "";
            }
            if (i == 4) {
                return ((BoolErrRecord) this._record).getBooleanValue() ? "TRUE" : "FALSE";
            }
            if (i == 5) {
                return ErrorConstants.getText(((BoolErrRecord) this._record).getErrorValue());
            }
            throw new IllegalStateException("Unexpected cell type (" + this._cellType + ")");
        }
        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
        FormulaRecord formulaRecord = formulaRecordAggregate.getFormulaRecord();
        int cachedResultType = formulaRecord.getCachedResultType();
        if (cachedResultType == 0) {
            return NumberToTextConverter.toText(formulaRecord.getValue());
        }
        if (cachedResultType == 1) {
            return formulaRecordAggregate.getStringValue();
        }
        if (cachedResultType == 4) {
            return formulaRecord.getCachedBooleanValue() ? "TRUE" : "FALSE";
        }
        if (cachedResultType == 5) {
            return ErrorConstants.getText(formulaRecord.getCachedErrorValue());
        }
        throw new IllegalStateException("Unexpected formula result type (" + this._cellType + ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int determineType(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            return 2;
        }
        Record record = (Record) cellValueRecordInterface;
        short sid = record.getSid();
        if (sid == 253) {
            return 1;
        }
        if (sid == 513) {
            return 3;
        }
        if (sid == 515) {
            return 0;
        }
        if (sid == 517) {
            return ((BoolErrRecord) record).isBoolean() ? 4 : 5;
        }
        throw new RuntimeException("Bad cell value rec (" + cellValueRecordInterface.getClass().getName() + ")");
    }

    public static HSSFComment findCellComment(InternalSheet internalSheet, int i, int i2) {
        HSSFComment hSSFComment;
        HashMap map = new HashMap();
        Iterator<RecordBase> it = internalSheet.getRecords().iterator();
        int i3 = 0;
        while (true) {
            hSSFComment = null;
            if (!it.hasNext()) {
                break;
            }
            RecordBase next = it.next();
            if (next instanceof NoteRecord) {
                NoteRecord noteRecord = (NoteRecord) next;
                if (noteRecord.getRow() == i && noteRecord.getColumn() == i2) {
                    if (i3 >= map.size()) {
                        log.log(POILogger.WARN, "Failed to match NoteRecord and TextObjectRecord, row: " + i + ", column: " + i2);
                        break;
                    }
                    TextObjectRecord textObjectRecord = (TextObjectRecord) map.get(Integer.valueOf(noteRecord.getShapeId()));
                    if (textObjectRecord == null) {
                        log.log(POILogger.WARN, "Failed to match NoteRecord and TextObjectRecord, row: " + i + ", column: " + i2);
                        break;
                    }
                    hSSFComment = new HSSFComment(noteRecord, textObjectRecord);
                    hSSFComment.setRow(noteRecord.getRow());
                    hSSFComment.setColumn(noteRecord.getColumn());
                    hSSFComment.setAuthor(noteRecord.getAuthor());
                    hSSFComment.setVisible(noteRecord.getFlags() == 2);
                    hSSFComment.setString(textObjectRecord.getStr());
                    break;
                }
                i3++;
            } else if (next instanceof ObjRecord) {
                SubRecord subRecord = ((ObjRecord) next).getSubRecords().get(0);
                if (subRecord instanceof CommonObjectDataSubRecord) {
                    CommonObjectDataSubRecord commonObjectDataSubRecord = (CommonObjectDataSubRecord) subRecord;
                    if (commonObjectDataSubRecord.getObjectType() == 25) {
                        while (it.hasNext()) {
                            RecordBase next2 = it.next();
                            if (next2 instanceof TextObjectRecord) {
                                map.put(Integer.valueOf(commonObjectDataSubRecord.getObjectId()), (TextObjectRecord) next2);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return hSSFComment;
    }

    private static String getCellTypeName(int i) {
        if (i == 0) {
            return "numeric";
        }
        if (i == 1) {
            return "text";
        }
        if (i == 2) {
            return "formula";
        }
        if (i == 3) {
            return "blank";
        }
        if (i == 4) {
            return TypedValues.Custom.S_BOOLEAN;
        }
        if (i == 5) {
            return "error";
        }
        return "#unknown cell type (" + i + ")#";
    }

    private void notifyFormulaChanging() {
        CellValueRecordInterface cellValueRecordInterface = this._record;
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            ((FormulaRecordAggregate) cellValueRecordInterface).notifyFormulaChanging();
        }
    }

    private static RuntimeException typeMismatch(int i, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot get a ");
        sb.append(getCellTypeName(i));
        sb.append(" value from a ");
        sb.append(getCellTypeName(i2));
        sb.append(" ");
        sb.append(z ? "formula " : "");
        sb.append("cell");
        return new IllegalStateException(sb.toString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        if (this._cellType == 2) {
            return ((FormulaRecordAggregate) this._record).getArrayFormulaRange();
        }
        throw new IllegalStateException("Cell " + new CellReference(this).formatAsString() + " is not part of an array formula.");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        int i = this._cellType;
        if (i == 2) {
            FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
            checkFormulaCachedValueType(4, formulaRecord);
            return formulaRecord.getCachedBooleanValue();
        }
        if (i == 3) {
            return false;
        }
        if (i == 4) {
            return ((BoolErrRecord) this._record).getBooleanValue();
        }
        throw typeMismatch(4, i, false);
    }

    public InternalWorkbook getBoundWorkbook() {
        return this._book.getWorkbook();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCachedFormulaResultType() {
        if (this._cellType == 2) {
            return ((FormulaRecordAggregate) this._record).getFormulaRecord().getCachedResultType();
        }
        throw new IllegalStateException("Only formula cells have cached results");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        CellValueRecordInterface cellValueRecordInterface = this._record;
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            return HSSFFormulaParser.toFormulaString(this._book, ((FormulaRecordAggregate) cellValueRecordInterface).getFormulaTokens());
        }
        throw typeMismatch(2, this._cellType, true);
    }

    public short getCellNum() {
        return (short) getColumnIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getCellType() {
        return this._cellType;
    }

    public CellValueRecordInterface getCellValueRecord() {
        return this._record;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._record.getColumn() & 65535;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (this._cellType == 3) {
            return null;
        }
        double numericCellValue = getNumericCellValue();
        return this._book.getWorkbook().isUsing1904DateWindowing() ? DateUtil.getJavaDate(numericCellValue, true) : DateUtil.getJavaDate(numericCellValue, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        int i = this._cellType;
        if (i != 2) {
            if (i == 5) {
                return ((BoolErrRecord) this._record).getErrorValue();
            }
            throw typeMismatch(5, i, false);
        }
        FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
        checkFormulaCachedValueType(5, formulaRecord);
        return (byte) formulaRecord.getCachedErrorValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        int i = this._cellType;
        if (i == 0) {
            return ((NumberRecord) this._record).getValue();
        }
        if (i != 2) {
            if (i == 3) {
                return 0.0d;
            }
            throw typeMismatch(0, i, false);
        }
        FormulaRecord formulaRecord = ((FormulaRecordAggregate) this._record).getFormulaRecord();
        checkFormulaCachedValueType(0, formulaRecord);
        return formulaRecord.getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._record.getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        return getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        if (this._cellType != 2) {
            return false;
        }
        return ((FormulaRecordAggregate) this._record).isPartOfArrayFormula();
    }

    public void notifyArrayFormulaChanging(String str) {
        if (getArrayFormulaRange().getNumberOfCells() > 1) {
            throw new IllegalStateException(str);
        }
        getRow().getSheet().removeArrayFormula(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        HSSFComment hSSFCommentFindCellComment = findCellComment(this._sheet.getSheet(), this._record.getRow(), this._record.getColumn());
        this._comment = null;
        if (hSSFCommentFindCellComment == null) {
            return;
        }
        List<RecordBase> records = this._sheet.getSheet().getRecords();
        records.remove(hSSFCommentFindCellComment.getNoteRecord());
        if (hSSFCommentFindCellComment.getTextObjectRecord() != null) {
            TextObjectRecord textObjectRecord = hSSFCommentFindCellComment.getTextObjectRecord();
            int iIndexOf = records.indexOf(textObjectRecord);
            int i = iIndexOf - 3;
            if (records.get(i) instanceof DrawingRecord) {
                int i2 = iIndexOf - 2;
                if (records.get(i2) instanceof ObjRecord) {
                    int i3 = iIndexOf - 1;
                    if (records.get(i3) instanceof DrawingRecord) {
                        records.remove(i3);
                        records.remove(i2);
                        records.remove(i);
                        records.remove(textObjectRecord);
                        return;
                    }
                }
            }
            throw new IllegalStateException("Found the wrong records before the TextObjectRecord, can't remove comment");
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
        int row = this._record.getRow();
        short column = this._record.getColumn();
        this._sheet.getSheet().setActiveCellRow(row);
        this._sheet.getSheet().setActiveCellCol(column);
    }

    public void setCellArrayFormula(CellRangeAddress cellRangeAddress) {
        setCellType(2, false, this._record.getRow(), this._record.getColumn(), this._record.getXFIndex());
        ((FormulaRecordAggregate) this._record).setParsedExpression(new Ptg[]{new ExpPtg(cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn())});
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        if (comment == null) {
            removeCellComment();
            return;
        }
        comment.setRow(this._record.getRow());
        comment.setColumn(this._record.getColumn());
        this._comment = (HSSFComment) comment;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        int i = this._cellType;
        if (i == 2) {
            ((FormulaRecordAggregate) this._record).setCachedErrorResult(b);
            return;
        }
        if (i != 5) {
            setCellType(5, false, row, column, xFIndex);
        }
        ((BoolErrRecord) this._record).setValue(b);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellFormula(String str) {
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        if (str == null) {
            notifyFormulaChanging();
            setCellType(3, false, row, column, xFIndex);
            return;
        }
        Ptg[] ptgArr = HSSFFormulaParser.parse(str, this._book, 0, this._book.getSheetIndex(this._sheet));
        setCellType(2, false, row, column, xFIndex);
        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
        FormulaRecord formulaRecord = formulaRecordAggregate.getFormulaRecord();
        formulaRecord.setOptions((short) 2);
        formulaRecord.setValue(0.0d);
        if (formulaRecordAggregate.getXFIndex() == 0) {
            formulaRecordAggregate.setXFIndex((short) 15);
        }
        formulaRecordAggregate.setParsedExpression(ptgArr);
    }

    public void setCellNum(short s) {
        this._record.setColumn(s);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        setCellStyle((HSSFCellStyle) cellStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellType(int i) {
        notifyFormulaChanging();
        if (isPartOfArrayFormulaGroup()) {
            notifyArrayFormulaChanging();
        }
        setCellType(i, true, this._record.getRow(), this._record.getColumn(), this._record.getXFIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(double d) {
        if (Double.isInfinite(d)) {
            setCellErrorValue(FormulaError.DIV0.getCode());
            return;
        }
        if (Double.isNaN(d)) {
            setCellErrorValue(FormulaError.NUM.getCode());
            return;
        }
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        int i = this._cellType;
        if (i != 0) {
            if (i == 2) {
                ((FormulaRecordAggregate) this._record).setCachedDoubleResult(d);
                return;
            }
            setCellType(0, false, row, column, xFIndex);
        }
        ((NumberRecord) this._record).setValue(d);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0043  */
    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        HSSFHyperlink hSSFHyperlink = (HSSFHyperlink) hyperlink;
        hSSFHyperlink.setFirstRow(this._record.getRow());
        hSSFHyperlink.setLastRow(this._record.getRow());
        hSSFHyperlink.setFirstColumn(this._record.getColumn());
        hSSFHyperlink.setLastColumn(this._record.getColumn());
        int type = hSSFHyperlink.getType();
        if (type == 1) {
            hSSFHyperlink.setLabel("url");
        } else if (type == 2) {
            hSSFHyperlink.setLabel("place");
        } else if (type == 3) {
            hSSFHyperlink.setLabel("url");
        } else if (type == 4) {
            hSSFHyperlink.setLabel(Annotation.FILE);
        }
        List<RecordBase> records = this._sheet.getSheet().getRecords();
        records.add(records.size() - 1, hSSFHyperlink.record);
    }

    public String toString() {
        int cellType = getCellType();
        if (cellType == 0) {
            return DateUtil.isCellDateFormatted(this) ? new SimpleDateFormat("dd-MMM-yyyy").format(getDateCellValue()) : String.valueOf(getNumericCellValue());
        }
        if (cellType == 1) {
            return getStringCellValue();
        }
        if (cellType == 2) {
            return getCellFormula();
        }
        if (cellType == 3) {
            return "";
        }
        if (cellType == 4) {
            return getBooleanCellValue() ? "TRUE" : "FALSE";
        }
        if (cellType == 5) {
            return ErrorEval.getText(((BoolErrRecord) this._record).getErrorValue());
        }
        return "Unknown Cell Type: " + getCellType();
    }

    public void updateCellNum(short s) {
        this._record.setColumn(s);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFComment getCellComment() {
        if (this._comment == null) {
            this._comment = findCellComment(this._sheet.getSheet(), this._record.getRow(), this._record.getColumn());
        }
        return this._comment;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFCellStyle getCellStyle() {
        short xFIndex = this._record.getXFIndex();
        return new HSSFCellStyle(xFIndex, this._book.getWorkbook().getExFormatAt(xFIndex), this._book);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFHyperlink getHyperlink() {
        for (RecordBase recordBase : this._sheet.getSheet().getRecords()) {
            if (recordBase instanceof HyperlinkRecord) {
                HyperlinkRecord hyperlinkRecord = (HyperlinkRecord) recordBase;
                if (hyperlinkRecord.getFirstColumn() == this._record.getColumn() && hyperlinkRecord.getFirstRow() == this._record.getRow()) {
                    return new HSSFHyperlink(hyperlinkRecord);
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFRichTextString getRichStringCellValue() {
        int i = this._cellType;
        if (i == 1) {
            return this._stringValue;
        }
        if (i != 2) {
            if (i == 3) {
                return new HSSFRichTextString("");
            }
            throw typeMismatch(1, i, false);
        }
        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
        checkFormulaCachedValueType(1, formulaRecordAggregate.getFormulaRecord());
        String stringValue = formulaRecordAggregate.getStringValue();
        return new HSSFRichTextString(stringValue != null ? stringValue : "");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFRow getRow() {
        return this._sheet.getRow(getRowIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public HSSFSheet getSheet() {
        return this._sheet;
    }

    public void setCellStyle(HSSFCellStyle hSSFCellStyle) {
        hSSFCellStyle.verifyBelongsToWorkbook(this._book);
        this._record.setXFIndex(hSSFCellStyle.getIndex());
    }

    public void notifyArrayFormulaChanging() {
        notifyArrayFormulaChanging("Cell " + new CellReference(this).formatAsString() + " is part of a multi-cell array formula. You cannot change part of an array.");
    }

    public HSSFCell(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, int i, short s, int i2) {
        checkBounds(s);
        this._cellType = -1;
        this._stringValue = null;
        this._book = hSSFWorkbook;
        this._sheet = hSSFSheet;
        setCellType(i2, false, i, s, hSSFSheet.getSheet().getXFIndexForColAt(s));
    }

    private void setCellType(int i, boolean z, int i2, short s, short s2) {
        NumberRecord numberRecord;
        LabelSSTRecord labelSSTRecord;
        FormulaRecordAggregate formulaRecordAggregateCreateFormula;
        BlankRecord blankRecord;
        BoolErrRecord boolErrRecord;
        BoolErrRecord boolErrRecord2;
        if (i <= 5) {
            if (i == 0) {
                if (i != this._cellType) {
                    numberRecord = new NumberRecord();
                } else {
                    numberRecord = (NumberRecord) this._record;
                }
                numberRecord.setColumn(s);
                if (z) {
                    numberRecord.setValue(getNumericCellValue());
                }
                numberRecord.setXFIndex(s2);
                numberRecord.setRow(i2);
                this._record = numberRecord;
            } else if (i == 1) {
                if (i == this._cellType) {
                    labelSSTRecord = (LabelSSTRecord) this._record;
                } else {
                    LabelSSTRecord labelSSTRecord2 = new LabelSSTRecord();
                    labelSSTRecord2.setColumn(s);
                    labelSSTRecord2.setRow(i2);
                    labelSSTRecord2.setXFIndex(s2);
                    labelSSTRecord = labelSSTRecord2;
                }
                if (z) {
                    int iAddSSTString = this._book.getWorkbook().addSSTString(new UnicodeString(convertCellValueToString()));
                    labelSSTRecord.setSSTIndex(iAddSSTString);
                    UnicodeString sSTString = this._book.getWorkbook().getSSTString(iAddSSTString);
                    HSSFRichTextString hSSFRichTextString = new HSSFRichTextString();
                    this._stringValue = hSSFRichTextString;
                    hSSFRichTextString.setUnicodeString(sSTString);
                }
                this._record = labelSSTRecord;
            } else if (i == 2) {
                if (i != this._cellType) {
                    formulaRecordAggregateCreateFormula = this._sheet.getSheet().getRowsAggregate().createFormula(i2, s);
                } else {
                    FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) this._record;
                    formulaRecordAggregate.setRow(i2);
                    formulaRecordAggregate.setColumn(s);
                    formulaRecordAggregateCreateFormula = formulaRecordAggregate;
                }
                if (z) {
                    formulaRecordAggregateCreateFormula.getFormulaRecord().setValue(getNumericCellValue());
                }
                formulaRecordAggregateCreateFormula.setXFIndex(s2);
                this._record = formulaRecordAggregateCreateFormula;
            } else if (i == 3) {
                if (i != this._cellType) {
                    blankRecord = new BlankRecord();
                } else {
                    blankRecord = (BlankRecord) this._record;
                }
                blankRecord.setColumn(s);
                blankRecord.setXFIndex(s2);
                blankRecord.setRow(i2);
                this._record = blankRecord;
            } else if (i == 4) {
                if (i != this._cellType) {
                    boolErrRecord = new BoolErrRecord();
                } else {
                    boolErrRecord = (BoolErrRecord) this._record;
                }
                boolErrRecord.setColumn(s);
                if (z) {
                    boolErrRecord.setValue(convertCellValueToBoolean());
                }
                boolErrRecord.setXFIndex(s2);
                boolErrRecord.setRow(i2);
                this._record = boolErrRecord;
            } else if (i == 5) {
                if (i != this._cellType) {
                    boolErrRecord2 = new BoolErrRecord();
                } else {
                    boolErrRecord2 = (BoolErrRecord) this._record;
                }
                boolErrRecord2.setColumn(s);
                if (z) {
                    boolErrRecord2.setValue((byte) 15);
                }
                boolErrRecord2.setXFIndex(s2);
                boolErrRecord2.setRow(i2);
                this._record = boolErrRecord2;
            }
            int i3 = this._cellType;
            if (i != i3 && i3 != -1) {
                this._sheet.getSheet().replaceValueRecord(this._record);
            }
            this._cellType = i;
            return;
        }
        throw new RuntimeException("I have no idea what type that is!");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Date date) {
        setCellValue(DateUtil.getExcelDate(date, this._book.getWorkbook().isUsing1904DateWindowing()));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Calendar calendar) {
        setCellValue(DateUtil.getExcelDate(calendar, this._book.getWorkbook().isUsing1904DateWindowing()));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String str) {
        setCellValue(str == null ? null : new HSSFRichTextString(str));
    }

    public HSSFCell(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, CellValueRecordInterface cellValueRecordInterface) {
        this._record = cellValueRecordInterface;
        int iDetermineType = determineType(cellValueRecordInterface);
        this._cellType = iDetermineType;
        this._stringValue = null;
        this._book = hSSFWorkbook;
        this._sheet = hSSFSheet;
        if (iDetermineType == 1) {
            this._stringValue = new HSSFRichTextString(hSSFWorkbook.getWorkbook(), (LabelSSTRecord) cellValueRecordInterface);
        } else if (iDetermineType == 2) {
            this._stringValue = new HSSFRichTextString(((FormulaRecordAggregate) cellValueRecordInterface).getStringValue());
        }
        setCellStyle(new HSSFCellStyle(cellValueRecordInterface.getXFIndex(), hSSFWorkbook.getWorkbook().getExFormatAt(cellValueRecordInterface.getXFIndex()), hSSFWorkbook));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString richTextString) {
        HSSFRichTextString hSSFRichTextString = (HSSFRichTextString) richTextString;
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        if (hSSFRichTextString == null) {
            notifyFormulaChanging();
            setCellType(3, false, row, column, xFIndex);
            return;
        }
        if (hSSFRichTextString.length() <= SpreadsheetVersion.EXCEL97.getMaxTextLength()) {
            int i = this._cellType;
            if (i == 2) {
                ((FormulaRecordAggregate) this._record).setCachedStringResult(hSSFRichTextString.getString());
                this._stringValue = new HSSFRichTextString(richTextString.getString());
                return;
            }
            if (i != 1) {
                setCellType(1, false, row, column, xFIndex);
            }
            int iAddSSTString = this._book.getWorkbook().addSSTString(hSSFRichTextString.getUnicodeString());
            ((LabelSSTRecord) this._record).setSSTIndex(iAddSSTString);
            this._stringValue = hSSFRichTextString;
            hSSFRichTextString.setWorkbookReferences(this._book.getWorkbook(), (LabelSSTRecord) this._record);
            this._stringValue.setUnicodeString(this._book.getWorkbook().getSSTString(iAddSSTString));
            return;
        }
        throw new IllegalArgumentException("The maximum length of cell contents (text) is 32,767 characters");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z) {
        int row = this._record.getRow();
        short column = this._record.getColumn();
        short xFIndex = this._record.getXFIndex();
        int i = this._cellType;
        if (i != 2) {
            if (i != 4) {
                setCellType(4, false, row, column, xFIndex);
            }
            ((BoolErrRecord) this._record).setValue(z);
            return;
        }
        ((FormulaRecordAggregate) this._record).setCachedBooleanResult(z);
    }
}
