package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: classes4.dex */
public interface Drawing {
    Comment createCellComment(ClientAnchor clientAnchor);

    Picture createPicture(ClientAnchor clientAnchor, int i);
}
