package org.apache.poi.ss.format;

/* JADX INFO: loaded from: classes4.dex */
public enum CellFormatType {
    GENERAL { // from class: org.apache.poi.ss.format.CellFormatType.1
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellGeneralFormatter();
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }
    },
    NUMBER { // from class: org.apache.poi.ss.format.CellFormatType.2
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellNumberFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }
    },
    DATE { // from class: org.apache.poi.ss.format.CellFormatType.3
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellDateFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return c == '\'' || (c <= 127 && Character.isLetter(c));
        }
    },
    ELAPSED { // from class: org.apache.poi.ss.format.CellFormatType.4
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellElapsedFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }
    },
    TEXT { // from class: org.apache.poi.ss.format.CellFormatType.5
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellTextFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }
    };

    public abstract CellFormatter formatter(String str);

    public abstract boolean isSpecial(char c);
}
