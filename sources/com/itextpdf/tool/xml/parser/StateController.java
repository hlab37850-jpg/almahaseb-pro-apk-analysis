package com.itextpdf.tool.xml.parser;

import com.itextpdf.tool.xml.parser.state.AttributeValueState;
import com.itextpdf.tool.xml.parser.state.CdataState;
import com.itextpdf.tool.xml.parser.state.CloseCommentState;
import com.itextpdf.tool.xml.parser.state.CloseStarCommentState;
import com.itextpdf.tool.xml.parser.state.ClosingTagState;
import com.itextpdf.tool.xml.parser.state.CommentState;
import com.itextpdf.tool.xml.parser.state.DocTypeState;
import com.itextpdf.tool.xml.parser.state.DoubleQuotedAttrValueState;
import com.itextpdf.tool.xml.parser.state.InsideTagHTMLState;
import com.itextpdf.tool.xml.parser.state.InsideTagState;
import com.itextpdf.tool.xml.parser.state.ProcessingInstructionEncounteredState;
import com.itextpdf.tool.xml.parser.state.SelfClosingTagState;
import com.itextpdf.tool.xml.parser.state.SingleQuotedAttrValueState;
import com.itextpdf.tool.xml.parser.state.SpecialCharState;
import com.itextpdf.tool.xml.parser.state.StarCommentState;
import com.itextpdf.tool.xml.parser.state.TagAttributeState;
import com.itextpdf.tool.xml.parser.state.TagEncounteredState;
import com.itextpdf.tool.xml.parser.state.UnknownState;
import com.itextpdf.tool.xml.parser.state.UnquotedAttrState;
import com.itextpdf.tool.xml.parser.state.XmlState;

/* JADX INFO: loaded from: classes3.dex */
public class StateController {
    private final State attrValue;
    private final State cdata;
    private final State closeComment;
    private State closeStarComment;
    private final State closingTag;
    private final State comment;
    private State currentState;
    private final State doctype;
    private final State doubleQuoted;
    private final State inTag;
    private final XMLParser parser;
    private State previousState;
    private final State processingInstruction;
    private final State selfClosing;
    private final State singleQuoted;
    private final State specialChar;
    private State starComment;
    private final State tagAttributes;
    private final State tagEncountered;
    private final State unknown;
    private final State unquoted;
    private final State xml;

    public StateController(XMLParser xMLParser, boolean z) {
        this.parser = xMLParser;
        this.unknown = new UnknownState(xMLParser);
        this.tagEncountered = new TagEncounteredState(xMLParser);
        this.tagAttributes = new TagAttributeState(xMLParser);
        this.inTag = z ? new InsideTagHTMLState(xMLParser) : new InsideTagState(xMLParser);
        this.attrValue = new AttributeValueState(xMLParser);
        this.singleQuoted = new SingleQuotedAttrValueState(xMLParser);
        this.doubleQuoted = new DoubleQuotedAttrValueState(xMLParser);
        this.selfClosing = new SelfClosingTagState(xMLParser);
        this.specialChar = new SpecialCharState(xMLParser);
        this.closingTag = new ClosingTagState(xMLParser);
        this.comment = new CommentState(xMLParser);
        this.closeComment = new CloseCommentState(xMLParser);
        this.cdata = new CdataState(xMLParser);
        this.xml = new XmlState(xMLParser);
        this.doctype = new DocTypeState(xMLParser);
        this.unquoted = new UnquotedAttrState(xMLParser);
        this.processingInstruction = new ProcessingInstructionEncounteredState(xMLParser);
        this.previousState = null;
        this.currentState = null;
        this.starComment = new StarCommentState(xMLParser);
        this.closeStarComment = new CloseStarCommentState(xMLParser);
    }

    public XMLParser attributeValue() {
        return setState(this.attrValue);
    }

    public XMLParser cdata() {
        return setState(this.cdata);
    }

    public XMLParser closeComment() {
        return setState(this.closeComment);
    }

    public XMLParser closeStarComment() {
        return setState(this.closeStarComment);
    }

    public XMLParser closingTag() {
        return setState(this.closingTag);
    }

    public XMLParser comment() {
        return setState(this.comment);
    }

    public XMLParser doctype() {
        return setState(this.doctype);
    }

    public XMLParser doubleQuotedAttr() {
        return setState(this.doubleQuoted);
    }

    public XMLParser inTag() {
        return setState(this.inTag);
    }

    public XMLParser previousState() {
        this.parser.setState(this.previousState);
        State state = this.currentState;
        this.currentState = this.previousState;
        this.previousState = state;
        return this.parser;
    }

    public XMLParser processingInstructions() {
        return setState(this.processingInstruction);
    }

    public XMLParser selfClosing() {
        return setState(this.selfClosing);
    }

    public XMLParser setState(State state) {
        this.previousState = this.currentState;
        this.currentState = state;
        this.parser.setState(state);
        return this.parser;
    }

    public XMLParser singleQuotedAttr() {
        return setState(this.singleQuoted);
    }

    public XMLParser specialChar() {
        return setState(this.specialChar);
    }

    public XMLParser starComment() {
        return setState(this.starComment);
    }

    public XMLParser tagAttributes() {
        return setState(this.tagAttributes);
    }

    public XMLParser tagEncountered() {
        return setState(this.tagEncountered);
    }

    public XMLParser unknown() {
        return setState(this.unknown);
    }

    public XMLParser unquotedAttr() {
        return setState(this.unquoted);
    }
}
