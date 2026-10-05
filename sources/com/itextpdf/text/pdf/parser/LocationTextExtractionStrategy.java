package com.itextpdf.text.pdf.parser;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LocationTextExtractionStrategy implements TextExtractionStrategy {
    static boolean DUMP_STATE = false;
    private final List<TextChunk> locationalResult;
    private final TextChunkLocationStrategy tclStrat;

    public static class TextChunk implements Comparable<TextChunk> {
        private final TextChunkLocation location;
        private final String text;

        public TextChunk(String str, Vector vector, Vector vector2, float f) {
            this(str, new TextChunkLocationDefaultImp(vector, vector2, f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void printDiagnostics() {
            PrintStream printStream = System.out;
            printStream.println("Text (@" + this.location.getStartLocation() + " -> " + this.location.getEndLocation() + "): " + this.text);
            StringBuilder sb = new StringBuilder();
            sb.append("orientationMagnitude: ");
            sb.append(this.location.orientationMagnitude());
            printStream.println(sb.toString());
            printStream.println("distPerpendicular: " + this.location.distPerpendicular());
            printStream.println("distParallel: " + this.location.distParallelStart());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean sameLine(TextChunk textChunk) {
            return getLocation().sameLine(textChunk.getLocation());
        }

        public float distanceFromEndOf(TextChunk textChunk) {
            return this.location.distanceFromEndOf(textChunk.location);
        }

        public float getCharSpaceWidth() {
            return this.location.getCharSpaceWidth();
        }

        public Vector getEndLocation() {
            return this.location.getEndLocation();
        }

        public TextChunkLocation getLocation() {
            return this.location;
        }

        public Vector getStartLocation() {
            return this.location.getStartLocation();
        }

        public String getText() {
            return this.text;
        }

        public TextChunk(String str, TextChunkLocation textChunkLocation) {
            this.text = str;
            this.location = textChunkLocation;
        }

        @Override // java.lang.Comparable
        public int compareTo(TextChunk textChunk) {
            return this.location.compareTo(textChunk.location);
        }
    }

    public interface TextChunkFilter {
        boolean accept(TextChunk textChunk);
    }

    public interface TextChunkLocation extends Comparable<TextChunkLocation> {
        float distParallelEnd();

        float distParallelStart();

        int distPerpendicular();

        float distanceFromEndOf(TextChunkLocation textChunkLocation);

        float getCharSpaceWidth();

        Vector getEndLocation();

        Vector getStartLocation();

        boolean isAtWordBoundary(TextChunkLocation textChunkLocation);

        int orientationMagnitude();

        boolean sameLine(TextChunkLocation textChunkLocation);
    }

    public static class TextChunkLocationDefaultImp implements TextChunkLocation {
        private final float charSpaceWidth;
        private final float distParallelEnd;
        private final float distParallelStart;
        private final int distPerpendicular;
        private final Vector endLocation;
        private final int orientationMagnitude;
        private final Vector orientationVector;
        private final Vector startLocation;

        public TextChunkLocationDefaultImp(Vector vector, Vector vector2, float f) {
            this.startLocation = vector;
            this.endLocation = vector2;
            this.charSpaceWidth = f;
            Vector vectorSubtract = vector2.subtract(vector);
            Vector vectorNormalize = (vectorSubtract.length() == 0.0f ? new Vector(1.0f, 0.0f, 0.0f) : vectorSubtract).normalize();
            this.orientationVector = vectorNormalize;
            this.orientationMagnitude = (int) (Math.atan2(vectorNormalize.get(1), vectorNormalize.get(0)) * 1000.0d);
            this.distPerpendicular = (int) vector.subtract(new Vector(0.0f, 0.0f, 1.0f)).cross(vectorNormalize).get(2);
            this.distParallelStart = vectorNormalize.dot(vector);
            this.distParallelEnd = vectorNormalize.dot(vector2);
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float distParallelEnd() {
            return this.distParallelEnd;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float distParallelStart() {
            return this.distParallelStart;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public int distPerpendicular() {
            return this.distPerpendicular;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float distanceFromEndOf(TextChunkLocation textChunkLocation) {
            return distParallelStart() - textChunkLocation.distParallelEnd();
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public float getCharSpaceWidth() {
            return this.charSpaceWidth;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public Vector getEndLocation() {
            return this.endLocation;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public Vector getStartLocation() {
            return this.startLocation;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public boolean isAtWordBoundary(TextChunkLocation textChunkLocation) {
            if (getCharSpaceWidth() < 0.1f) {
                return false;
            }
            float fDistanceFromEndOf = distanceFromEndOf(textChunkLocation);
            return fDistanceFromEndOf < (-getCharSpaceWidth()) || fDistanceFromEndOf > getCharSpaceWidth() / 2.0f;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public int orientationMagnitude() {
            return this.orientationMagnitude;
        }

        @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation
        public boolean sameLine(TextChunkLocation textChunkLocation) {
            return orientationMagnitude() == textChunkLocation.orientationMagnitude() && distPerpendicular() == textChunkLocation.distPerpendicular();
        }

        @Override // java.lang.Comparable
        public int compareTo(TextChunkLocation textChunkLocation) {
            if (this == textChunkLocation) {
                return 0;
            }
            int iCompareInts = LocationTextExtractionStrategy.compareInts(orientationMagnitude(), textChunkLocation.orientationMagnitude());
            if (iCompareInts != 0) {
                return iCompareInts;
            }
            int iCompareInts2 = LocationTextExtractionStrategy.compareInts(distPerpendicular(), textChunkLocation.distPerpendicular());
            return iCompareInts2 != 0 ? iCompareInts2 : Float.compare(distParallelStart(), textChunkLocation.distParallelStart());
        }
    }

    public interface TextChunkLocationStrategy {
        TextChunkLocation createLocation(TextRenderInfo textRenderInfo, LineSegment lineSegment);
    }

    public LocationTextExtractionStrategy() {
        this(new TextChunkLocationStrategy() { // from class: com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.1
            @Override // com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocationStrategy
            public TextChunkLocation createLocation(TextRenderInfo textRenderInfo, LineSegment lineSegment) {
                return new TextChunkLocationDefaultImp(lineSegment.getStartPoint(), lineSegment.getEndPoint(), textRenderInfo.getSingleSpaceWidth());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareInts(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    private void dumpState() {
        Iterator<TextChunk> it = this.locationalResult.iterator();
        while (it.hasNext()) {
            it.next().printDiagnostics();
            System.out.println();
        }
    }

    private boolean endsWithSpace(String str) {
        return str.length() != 0 && str.charAt(str.length() - 1) == ' ';
    }

    private List<TextChunk> filterTextChunks(List<TextChunk> list, TextChunkFilter textChunkFilter) {
        if (textChunkFilter == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (TextChunk textChunk : list) {
            if (textChunkFilter.accept(textChunk)) {
                arrayList.add(textChunk);
            }
        }
        return arrayList;
    }

    private boolean startsWithSpace(String str) {
        return str.length() != 0 && str.charAt(0) == ' ';
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    public String getResultantText(TextChunkFilter textChunkFilter) {
        if (DUMP_STATE) {
            dumpState();
        }
        List<TextChunk> listFilterTextChunks = filterTextChunks(this.locationalResult, textChunkFilter);
        Collections.sort(listFilterTextChunks);
        StringBuilder sb = new StringBuilder();
        TextChunk textChunk = null;
        for (TextChunk textChunk2 : listFilterTextChunks) {
            if (textChunk == null) {
                sb.append(textChunk2.text);
            } else if (textChunk2.sameLine(textChunk)) {
                if (isChunkAtWordBoundary(textChunk2, textChunk) && !startsWithSpace(textChunk2.text) && !endsWithSpace(textChunk.text)) {
                    sb.append(' ');
                }
                sb.append(textChunk2.text);
            } else {
                sb.append('\n');
                sb.append(textChunk2.text);
            }
            textChunk = textChunk2;
        }
        return sb.toString();
    }

    public boolean isChunkAtWordBoundary(TextChunk textChunk, TextChunk textChunk2) {
        return textChunk.getLocation().isAtWordBoundary(textChunk2.getLocation());
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        LineSegment baseline = textRenderInfo.getBaseline();
        if (textRenderInfo.getRise() != 0.0f) {
            baseline = baseline.transformBy(new Matrix(0.0f, -textRenderInfo.getRise()));
        }
        this.locationalResult.add(new TextChunk(textRenderInfo.getText(), this.tclStrat.createLocation(textRenderInfo, baseline)));
    }

    public LocationTextExtractionStrategy(TextChunkLocationStrategy textChunkLocationStrategy) {
        this.locationalResult = new ArrayList();
        this.tclStrat = textChunkLocationStrategy;
    }

    @Override // com.itextpdf.text.pdf.parser.TextExtractionStrategy
    public String getResultantText() {
        return getResultantText(null);
    }
}
