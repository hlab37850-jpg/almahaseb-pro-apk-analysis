package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPException;

/* JADX INFO: loaded from: classes3.dex */
class ParseState {
    private int pos = 0;
    private String str;

    public ParseState(String str) {
        this.str = str;
    }

    public char ch(int i) {
        if (i < this.str.length()) {
            return this.str.charAt(i);
        }
        return (char) 0;
    }

    public int gatherInt(String str, int i) throws XMPException {
        char cCh = ch(this.pos);
        int i2 = 0;
        boolean z = false;
        while ('0' <= cCh && cCh <= '9') {
            i2 = (i2 * 10) + (cCh - '0');
            z = true;
            int i3 = this.pos + 1;
            this.pos = i3;
            cCh = ch(i3);
        }
        if (!z) {
            throw new XMPException(str, 5);
        }
        if (i2 > i) {
            return i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public boolean hasNext() {
        return this.pos < this.str.length();
    }

    public int length() {
        return this.str.length();
    }

    public int pos() {
        return this.pos;
    }

    public void skip() {
        this.pos++;
    }

    public char ch() {
        if (this.pos < this.str.length()) {
            return this.str.charAt(this.pos);
        }
        return (char) 0;
    }
}
