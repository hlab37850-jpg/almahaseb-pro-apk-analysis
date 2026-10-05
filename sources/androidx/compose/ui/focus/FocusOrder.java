package androidx.compose.ui.focus;

import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FocusOrder {
    public static final int $stable = 8;
    private final FocusProperties focusProperties;

    public FocusOrder(FocusProperties focusProperties) {
        AbstractC4492zt.h(focusProperties, "focusProperties");
        this.focusProperties = focusProperties;
    }

    public final FocusRequester getDown() {
        return this.focusProperties.getDown();
    }

    public final FocusRequester getEnd() {
        return this.focusProperties.getEnd();
    }

    public final FocusRequester getLeft() {
        return this.focusProperties.getLeft();
    }

    public final FocusRequester getNext() {
        return this.focusProperties.getNext();
    }

    public final FocusRequester getPrevious() {
        return this.focusProperties.getPrevious();
    }

    public final FocusRequester getRight() {
        return this.focusProperties.getRight();
    }

    public final FocusRequester getStart() {
        return this.focusProperties.getStart();
    }

    public final FocusRequester getUp() {
        return this.focusProperties.getUp();
    }

    public final void setDown(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "down");
        this.focusProperties.setDown(focusRequester);
    }

    public final void setEnd(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "end");
        this.focusProperties.setEnd(focusRequester);
    }

    public final void setLeft(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "left");
        this.focusProperties.setLeft(focusRequester);
    }

    public final void setNext(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "next");
        this.focusProperties.setNext(focusRequester);
    }

    public final void setPrevious(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "previous");
        this.focusProperties.setPrevious(focusRequester);
    }

    public final void setRight(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "right");
        this.focusProperties.setRight(focusRequester);
    }

    public final void setStart(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, HTML.Attribute.START);
        this.focusProperties.setStart(focusRequester);
    }

    public final void setUp(FocusRequester focusRequester) {
        AbstractC4492zt.h(focusRequester, "up");
        this.focusProperties.setUp(focusRequester);
    }

    public FocusOrder() {
        this(new FocusPropertiesImpl());
    }
}
