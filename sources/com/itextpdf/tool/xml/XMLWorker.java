package com.itextpdf.tool.xml;

import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.parser.XMLParserListener;
import com.itextpdf.tool.xml.pipeline.ctx.WorkerContextImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class XMLWorker implements XMLParserListener {
    private static ThreadLocal<WorkerContextImpl> context = new ThreadLocal<WorkerContextImpl>() { // from class: com.itextpdf.tool.xml.XMLWorker.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public WorkerContextImpl initialValue() {
            return new WorkerContextImpl();
        }
    };
    protected final boolean parseHtml;
    protected final Pipeline<?> rootpPipe;

    public XMLWorker(Pipeline<?> pipeline, boolean z) {
        this.parseHtml = z;
        this.rootpPipe = pipeline;
    }

    public static void closeLocalWC() {
        context.remove();
    }

    public static WorkerContext getLocalWC() {
        return context.get();
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void close() {
        closeLocalWC();
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void comment(String str) {
    }

    public Tag createTag(String str, Map<String, String> map, String str2) {
        if (this.parseHtml) {
            str = str.toLowerCase();
        }
        return new Tag(str, map, str2);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x006a */
    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void endElement(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            boolean r6 = r4.parseHtml
            if (r6 == 0) goto L8
            java.lang.String r5 = r5.toLowerCase()
        L8:
            com.itextpdf.tool.xml.WorkerContext r6 = getLocalWC()
            com.itextpdf.tool.xml.Tag r0 = r6.getCurrentTag()
            if (r0 == 0) goto L46
            com.itextpdf.tool.xml.Tag r0 = r6.getCurrentTag()
            java.lang.String r0 = r0.getName()
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L21
            goto L46
        L21:
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r0 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException
            com.itextpdf.tool.xml.exceptions.LocaleMessages r1 = com.itextpdf.tool.xml.exceptions.LocaleMessages.getInstance()
            java.lang.String r2 = "tag.invalidnesting"
            java.lang.String r1 = r1.getMessage(r2)
            com.itextpdf.tool.xml.Tag r6 = r6.getCurrentTag()
            java.lang.String r6 = r6.getName()
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r6
            java.lang.String r5 = java.lang.String.format(r1, r2)
            r0.<init>(r5)
            throw r0
        L46:
            com.itextpdf.tool.xml.Pipeline<?> r5 = r4.rootpPipe
            com.itextpdf.tool.xml.ProcessObject r0 = new com.itextpdf.tool.xml.ProcessObject
            r0.<init>()
        L4d:
            com.itextpdf.tool.xml.Tag r1 = r6.getCurrentTag()     // Catch: java.lang.Throwable -> L6a com.itextpdf.tool.xml.PipelineException -> L6c
            com.itextpdf.tool.xml.Pipeline r5 = r5.close(r6, r1, r0)     // Catch: java.lang.Throwable -> L6a com.itextpdf.tool.xml.PipelineException -> L6c
            if (r5 == 0) goto L58
            goto L4d
        L58:
            com.itextpdf.tool.xml.Tag r5 = r6.getCurrentTag()
            if (r5 == 0) goto L69
            com.itextpdf.tool.xml.Tag r5 = r6.getCurrentTag()
            com.itextpdf.tool.xml.Tag r5 = r5.getParent()
            r6.setCurrentTag(r5)
        L69:
            return
        L6a:
            r5 = move-exception
            goto L73
        L6c:
            r5 = move-exception
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r0 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException     // Catch: java.lang.Throwable -> L6a
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L6a
            throw r0     // Catch: java.lang.Throwable -> L6a
        L73:
            com.itextpdf.tool.xml.Tag r0 = r6.getCurrentTag()
            if (r0 == 0) goto L84
            com.itextpdf.tool.xml.Tag r0 = r6.getCurrentTag()
            com.itextpdf.tool.xml.Tag r0 = r0.getParent()
            r6.setCurrentTag(r0)
        L84:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.XMLWorker.endElement(java.lang.String, java.lang.String):void");
    }

    public Tag getCurrentTag() {
        return getLocalWC().getCurrentTag();
    }

    public boolean ignoreCdata() {
        return true;
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void init() {
        Pipeline<?> pipelineInit = this.rootpPipe;
        do {
            try {
                pipelineInit = pipelineInit.init(getLocalWC());
            } catch (PipelineException e) {
                throw new RuntimeWorkerException(e);
            }
        } while (pipelineInit != null);
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void startElement(String str, Map<String, String> map, String str2) {
        Tag tagCreateTag = createTag(str, map, str2);
        WorkerContext localWC = getLocalWC();
        if (localWC.getCurrentTag() != null) {
            localWC.getCurrentTag().addChild(tagCreateTag);
        }
        localWC.setCurrentTag(tagCreateTag);
        Pipeline<?> pipelineOpen = this.rootpPipe;
        ProcessObject processObject = new ProcessObject();
        do {
            try {
                pipelineOpen = pipelineOpen.open(localWC, tagCreateTag, processObject);
            } catch (PipelineException e) {
                throw new RuntimeWorkerException(e);
            }
        } while (pipelineOpen != null);
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void text(String str) {
        if (str.startsWith("<![CDATA[") && str.endsWith("]]>")) {
            if (ignoreCdata()) {
                return;
            } else {
                str = str.substring(9, str.length() - 3);
            }
        }
        WorkerContext localWC = getLocalWC();
        if (localWC.getCurrentTag() == null || str.length() <= 0) {
            return;
        }
        Pipeline<?> pipelineContent = this.rootpPipe;
        ProcessObject processObject = new ProcessObject();
        do {
            try {
                pipelineContent = pipelineContent.content(localWC, localWC.getCurrentTag(), str, processObject);
            } catch (PipelineException e) {
                throw new RuntimeWorkerException(e);
            }
        } while (pipelineContent != null);
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void unknownText(String str) {
    }
}
