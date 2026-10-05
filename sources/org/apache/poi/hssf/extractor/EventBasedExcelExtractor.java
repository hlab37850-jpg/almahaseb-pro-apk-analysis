package org.apache.poi.hssf.extractor;

import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes4.dex */
public class EventBasedExcelExtractor extends POIOLE2TextExtractor {
    private DirectoryNode _dir;
    boolean _formulasNotResults;
    private POIFSFileSystem _fs;
    boolean _includeSheetNames;

    public class TextListener implements HSSFListener {
        FormatTrackingHSSFListener _ft;
        private int rowNum;
        private SSTRecord sstRecord;
        final StringBuffer _text = new StringBuffer();
        private int sheetNum = -1;
        private boolean outputNextStringValue = false;
        private int nextRow = -1;
        private final List<String> sheetNames = new ArrayList();

        public TextListener() {
        }

        @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
        public void processRecord(Record record) {
            int row;
            short sid = record.getSid();
            String numberDateCell = null;
            if (sid == 6) {
                FormulaRecord formulaRecord = (FormulaRecord) record;
                row = formulaRecord.getRow();
                if (EventBasedExcelExtractor.this._formulasNotResults) {
                    numberDateCell = HSSFFormulaParser.toFormulaString(null, formulaRecord.getParsedExpression());
                } else if (formulaRecord.hasCachedResultString()) {
                    this.outputNextStringValue = true;
                    this.nextRow = formulaRecord.getRow();
                } else {
                    numberDateCell = this._ft.formatNumberDateCell(formulaRecord);
                }
            } else if (sid != 28) {
                row = -1;
                if (sid == 133) {
                    this.sheetNames.add(((BoundSheetRecord) record).getSheetname());
                } else if (sid != 519) {
                    if (sid != 2057) {
                        if (sid == 252) {
                            this.sstRecord = (SSTRecord) record;
                        } else if (sid == 253) {
                            LabelSSTRecord labelSSTRecord = (LabelSSTRecord) record;
                            row = labelSSTRecord.getRow();
                            SSTRecord sSTRecord = this.sstRecord;
                            if (sSTRecord == null) {
                                throw new IllegalStateException("No SST record found");
                            }
                            numberDateCell = sSTRecord.getString(labelSSTRecord.getSSTIndex()).toString();
                        } else if (sid == 515) {
                            NumberRecord numberRecord = (NumberRecord) record;
                            row = numberRecord.getRow();
                            numberDateCell = this._ft.formatNumberDateCell(numberRecord);
                        } else if (sid == 516) {
                            LabelRecord labelRecord = (LabelRecord) record;
                            row = labelRecord.getRow();
                            numberDateCell = labelRecord.getValue();
                        }
                    } else if (((BOFRecord) record).getType() == 16) {
                        this.sheetNum++;
                        this.rowNum = -1;
                        if (EventBasedExcelExtractor.this._includeSheetNames) {
                            if (this._text.length() > 0) {
                                this._text.append(StringUtilities.LF);
                            }
                            this._text.append(this.sheetNames.get(this.sheetNum));
                        }
                    }
                } else if (this.outputNextStringValue) {
                    numberDateCell = ((StringRecord) record).getString();
                    row = this.nextRow;
                    this.outputNextStringValue = false;
                }
            } else {
                row = ((NoteRecord) record).getRow();
            }
            if (numberDateCell != null) {
                if (row != this.rowNum) {
                    this.rowNum = row;
                    if (this._text.length() > 0) {
                        this._text.append(StringUtilities.LF);
                    }
                } else {
                    this._text.append("\t");
                }
                this._text.append(numberDateCell);
            }
        }
    }

    public EventBasedExcelExtractor(DirectoryNode directoryNode, POIFSFileSystem pOIFSFileSystem) {
        super(null);
        this._includeSheetNames = true;
        this._formulasNotResults = false;
        this._dir = directoryNode;
        this._fs = pOIFSFileSystem;
    }

    private TextListener triggerExtraction() {
        TextListener textListener = new TextListener();
        FormatTrackingHSSFListener formatTrackingHSSFListener = new FormatTrackingHSSFListener(textListener);
        textListener._ft = formatTrackingHSSFListener;
        HSSFEventFactory hSSFEventFactory = new HSSFEventFactory();
        HSSFRequest hSSFRequest = new HSSFRequest();
        hSSFRequest.addListenerForAllRecords(formatTrackingHSSFListener);
        hSSFEventFactory.processWorkbookEvents(hSSFRequest, this._dir);
        return textListener;
    }

    @Override // org.apache.poi.POIOLE2TextExtractor
    public DocumentSummaryInformation getDocSummaryInformation() {
        throw new IllegalStateException("Metadata extraction not supported in streaming mode, please use ExcelExtractor");
    }

    @Override // org.apache.poi.POIOLE2TextExtractor
    public POIFSFileSystem getFileSystem() {
        return this._fs;
    }

    @Override // org.apache.poi.POIOLE2TextExtractor
    public SummaryInformation getSummaryInformation() {
        throw new IllegalStateException("Metadata extraction not supported in streaming mode, please use ExcelExtractor");
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        try {
            String string = triggerExtraction()._text.toString();
            if (string.endsWith(StringUtilities.LF)) {
                return string;
            }
            return string + StringUtilities.LF;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFormulasNotResults(boolean z) {
        this._formulasNotResults = z;
    }

    public void setIncludeSheetNames(boolean z) {
        this._includeSheetNames = z;
    }

    public EventBasedExcelExtractor(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem.getRoot(), pOIFSFileSystem);
    }
}
