package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class IndexEvents extends PdfPageEventHelper {
    private Map<String, Integer> indextag = new TreeMap();
    private long indexcounter = 0;
    private List<Entry> indexentry = new ArrayList();
    private Comparator<Entry> comparator = new Comparator<Entry>() { // from class: com.itextpdf.text.pdf.events.IndexEvents.1
        @Override // java.util.Comparator
        public int compare(Entry entry, Entry entry2) {
            if (entry.getIn1() == null || entry2.getIn1() == null) {
                return 0;
            }
            int iCompareToIgnoreCase = entry.getIn1().compareToIgnoreCase(entry2.getIn1());
            if (iCompareToIgnoreCase != 0 || entry.getIn2() == null || entry2.getIn2() == null) {
                return iCompareToIgnoreCase;
            }
            int iCompareToIgnoreCase2 = entry.getIn2().compareToIgnoreCase(entry2.getIn2());
            return (iCompareToIgnoreCase2 != 0 || entry.getIn3() == null || entry2.getIn3() == null) ? iCompareToIgnoreCase2 : entry.getIn3().compareToIgnoreCase(entry2.getIn3());
        }
    };

    public class Entry {
        private String in1;
        private String in2;
        private String in3;
        private String tag;
        private List<Integer> pagenumbers = new ArrayList();
        private List<String> tags = new ArrayList();

        public Entry(String str, String str2, String str3, String str4) {
            this.in1 = str;
            this.in2 = str2;
            this.in3 = str3;
            this.tag = str4;
        }

        public void addPageNumberAndTag(int i, String str) {
            this.pagenumbers.add(Integer.valueOf(i));
            this.tags.add(str);
        }

        public String getIn1() {
            return this.in1;
        }

        public String getIn2() {
            return this.in2;
        }

        public String getIn3() {
            return this.in3;
        }

        public String getKey() {
            return this.in1 + "!" + this.in2 + "!" + this.in3;
        }

        public int getPageNumber() {
            Integer num = (Integer) IndexEvents.this.indextag.get(this.tag);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }

        public List<Integer> getPagenumbers() {
            return this.pagenumbers;
        }

        public String getTag() {
            return this.tag;
        }

        public List<String> getTags() {
            return this.tags;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.in1);
            stringBuffer.append(' ');
            stringBuffer.append(this.in2);
            stringBuffer.append(' ');
            stringBuffer.append(this.in3);
            stringBuffer.append(' ');
            for (int i = 0; i < this.pagenumbers.size(); i++) {
                stringBuffer.append(this.pagenumbers.get(i));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    public Chunk create(String str, String str2, String str3, String str4) {
        Chunk chunk = new Chunk(str);
        StringBuilder sb = new StringBuilder();
        sb.append("idx_");
        long j = this.indexcounter;
        this.indexcounter = 1 + j;
        sb.append(j);
        String string = sb.toString();
        chunk.setGenericTag(string);
        chunk.setLocalDestination(string);
        this.indexentry.add(new Entry(str2, str3, str4, string));
        return chunk;
    }

    public List<Entry> getSortedEntries() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.indexentry.size(); i++) {
            Entry entry = this.indexentry.get(i);
            String key = entry.getKey();
            Entry entry2 = (Entry) map.get(key);
            if (entry2 != null) {
                entry2.addPageNumberAndTag(entry.getPageNumber(), entry.getTag());
            } else {
                entry.addPageNumberAndTag(entry.getPageNumber(), entry.getTag());
                map.put(key, entry);
            }
        }
        ArrayList arrayList = new ArrayList(map.values());
        Collections.sort(arrayList, this.comparator);
        return arrayList;
    }

    @Override // com.itextpdf.text.pdf.PdfPageEventHelper, com.itextpdf.text.pdf.PdfPageEvent
    public void onGenericTag(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        this.indextag.put(str, Integer.valueOf(pdfWriter.getPageNumber()));
    }

    public void setComparator(Comparator<Entry> comparator) {
        this.comparator = comparator;
    }

    public Chunk create(String str, String str2) {
        return create(str, str2, "", "");
    }

    public Chunk create(String str, String str2, String str3) {
        return create(str, str2, str3, "");
    }

    public void create(Chunk chunk, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("idx_");
        long j = this.indexcounter;
        this.indexcounter = 1 + j;
        sb.append(j);
        String string = sb.toString();
        chunk.setGenericTag(string);
        chunk.setLocalDestination(string);
        this.indexentry.add(new Entry(str, str2, str3, string));
    }

    public void create(Chunk chunk, String str) {
        create(chunk, str, "", "");
    }

    public void create(Chunk chunk, String str, String str2) {
        create(chunk, str, str2, "");
    }
}
