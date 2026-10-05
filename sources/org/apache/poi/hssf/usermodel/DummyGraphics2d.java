package org.apache.poi.hssf.usermodel;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.PrintStream;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DummyGraphics2d extends Graphics2D {
    private Graphics2D g2D;
    BufferedImage img;

    public DummyGraphics2d() {
        BufferedImage bufferedImage = new BufferedImage(1000, 1000, 2);
        this.img = bufferedImage;
        this.g2D = bufferedImage.getGraphics();
    }

    public void addRenderingHints(Map map) {
        PrintStream printStream = System.out;
        printStream.println("addRenderingHinds(Map):");
        printStream.println("  hints = " + map);
        this.g2D.addRenderingHints(map);
    }

    public void clearRect(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("clearRect(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.clearRect(i, i2, i3, i4);
    }

    public void clip(Shape shape) {
        PrintStream printStream = System.out;
        printStream.println("clip(Shape):");
        printStream.println("  s = " + shape);
        this.g2D.clip(shape);
    }

    public void clipRect(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("clipRect(int, int, int, int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.clipRect(i, i2, i3, i4);
    }

    public void copyArea(int i, int i2, int i3, int i4, int i5, int i6) {
        PrintStream printStream = System.out;
        printStream.println("copyArea(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.copyArea(i, i2, i3, i4, i5, i6);
    }

    public Graphics create() {
        System.out.println("create():");
        return this.g2D.create();
    }

    public void dispose() {
        System.out.println("dispose():");
        this.g2D.dispose();
    }

    public void draw(Shape shape) {
        PrintStream printStream = System.out;
        printStream.println("draw(Shape):");
        printStream.println("s = " + shape);
        this.g2D.draw(shape);
    }

    public void draw3DRect(int i, int i2, int i3, int i4, boolean z) {
        PrintStream printStream = System.out;
        printStream.println("draw3DRect(int,int,int,int,boolean):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        printStream.println("raised = " + z);
        this.g2D.draw3DRect(i, i2, i3, i4, z);
    }

    public void drawArc(int i, int i2, int i3, int i4, int i5, int i6) {
        PrintStream printStream = System.out;
        printStream.println("drawArc(int,int,int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        printStream.println("startAngle = " + i5);
        printStream.println("arcAngle = " + i6);
        this.g2D.drawArc(i, i2, i3, i4, i5, i6);
    }

    public void drawBytes(byte[] bArr, int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("drawBytes(byte[],int,int,int,int):");
        printStream.println("data = " + bArr);
        printStream.println("offset = " + i);
        printStream.println("length = " + i2);
        printStream.println("x = " + i3);
        printStream.println("y = " + i4);
        this.g2D.drawBytes(bArr, i, i2, i3, i4);
    }

    public void drawChars(char[] cArr, int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("drawChars(data,int,int,int,int):");
        printStream.println("data = " + cArr.toString());
        printStream.println("offset = " + i);
        printStream.println("length = " + i2);
        printStream.println("x = " + i3);
        printStream.println("y = " + i4);
        this.g2D.drawChars(cArr, i, i2, i3, i4);
    }

    public void drawGlyphVector(GlyphVector glyphVector, float f, float f2) {
        PrintStream printStream = System.out;
        printStream.println("drawGlyphVector(GlyphVector, float, float):");
        printStream.println("g = " + glyphVector);
        printStream.println("x = " + f);
        printStream.println("y = " + f2);
        this.g2D.drawGlyphVector(glyphVector, f, f2);
    }

    public void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i, int i2) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(BufferedImage, BufferedImageOp, x, y):");
        printStream.println("img = " + bufferedImage);
        printStream.println("op = " + bufferedImageOp);
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        this.g2D.drawImage(bufferedImage, bufferedImageOp, i, i2);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("drawLine(int,int,int,int):");
        printStream.println("x1 = " + i);
        printStream.println("y1 = " + i2);
        printStream.println("x2 = " + i3);
        printStream.println("y2 = " + i4);
        this.g2D.drawLine(i, i2, i3, i4);
    }

    public void drawOval(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("drawOval(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.drawOval(i, i2, i3, i4);
    }

    public void drawPolygon(Polygon polygon) {
        PrintStream printStream = System.out;
        printStream.println("drawPolygon(Polygon):");
        printStream.println("p = " + polygon);
        this.g2D.drawPolygon(polygon);
    }

    public void drawPolyline(int[] iArr, int[] iArr2, int i) {
        PrintStream printStream = System.out;
        printStream.println("drawPolyline(int[],int[],int):");
        printStream.println("xPoints = " + iArr);
        printStream.println("yPoints = " + iArr2);
        printStream.println("nPoints = " + i);
        this.g2D.drawPolyline(iArr, iArr2, i);
    }

    public void drawRect(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("drawRect(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.drawRect(i, i2, i3, i4);
    }

    public void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform) {
        PrintStream printStream = System.out;
        printStream.println("drawRenderableImage(RenderableImage, AfflineTransform):");
        printStream.println("img = " + renderableImage);
        printStream.println("xform = " + affineTransform);
        this.g2D.drawRenderableImage(renderableImage, affineTransform);
    }

    public void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform) {
        PrintStream printStream = System.out;
        printStream.println("drawRenderedImage(RenderedImage, AffineTransform):");
        printStream.println("img = " + renderedImage);
        printStream.println("xform = " + affineTransform);
        this.g2D.drawRenderedImage(renderedImage, affineTransform);
    }

    public void drawRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        PrintStream printStream = System.out;
        printStream.println("drawRoundRect(int,int,int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        printStream.println("arcWidth = " + i5);
        printStream.println("arcHeight = " + i6);
        this.g2D.drawRoundRect(i, i2, i3, i4, i5, i6);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, float f, float f2) {
        PrintStream printStream = System.out;
        printStream.println("drawString(AttributedCharacterIterator):");
        printStream.println("iterator = " + attributedCharacterIterator);
        printStream.println("x = " + f);
        printStream.println("y = " + f2);
        this.g2D.drawString(attributedCharacterIterator, f, f2);
    }

    public void fill(Shape shape) {
        PrintStream printStream = System.out;
        printStream.println("fill(Shape):");
        printStream.println("s = " + shape);
        this.g2D.fill(shape);
    }

    public void fill3DRect(int i, int i2, int i3, int i4, boolean z) {
        PrintStream printStream = System.out;
        printStream.println("fill3DRect(int,int,int,int,boolean):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        printStream.println("raised = " + z);
        this.g2D.fill3DRect(i, i2, i3, i4, z);
    }

    public void fillArc(int i, int i2, int i3, int i4, int i5, int i6) {
        PrintStream printStream = System.out;
        printStream.println("fillArc(int,int,int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        printStream.println("startAngle = " + i5);
        printStream.println("arcAngle = " + i6);
        this.g2D.fillArc(i, i2, i3, i4, i5, i6);
    }

    public void fillOval(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("fillOval(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.fillOval(i, i2, i3, i4);
    }

    public void fillPolygon(Polygon polygon) {
        PrintStream printStream = System.out;
        printStream.println("fillPolygon(Polygon):");
        printStream.println("p = " + polygon);
        this.g2D.fillPolygon(polygon);
    }

    public void fillRect(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("fillRect(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.fillRect(i, i2, i3, i4);
    }

    public void fillRoundRect(int i, int i2, int i3, int i4, int i5, int i6) {
        PrintStream printStream = System.out;
        printStream.println("fillRoundRect(int,int,int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.fillRoundRect(i, i2, i3, i4, i5, i6);
    }

    public void finalize() {
        System.out.println("finalize():");
        this.g2D.finalize();
    }

    public Color getBackground() {
        System.out.println("getBackground():");
        return this.g2D.getBackground();
    }

    public Shape getClip() {
        System.out.println("getClip():");
        return this.g2D.getClip();
    }

    public Rectangle getClipBounds() {
        System.out.println("getClipBounds():");
        return this.g2D.getClipBounds();
    }

    public Rectangle getClipRect() {
        System.out.println("getClipRect():");
        return this.g2D.getClipRect();
    }

    public Color getColor() {
        System.out.println("getColor():");
        return this.g2D.getColor();
    }

    public Composite getComposite() {
        System.out.println("getComposite():");
        return this.g2D.getComposite();
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        System.out.println("getDeviceConfiguration():");
        return this.g2D.getDeviceConfiguration();
    }

    public Font getFont() {
        System.out.println("getFont():");
        return this.g2D.getFont();
    }

    public FontMetrics getFontMetrics() {
        System.out.println("getFontMetrics():");
        return this.g2D.getFontMetrics();
    }

    public FontRenderContext getFontRenderContext() {
        System.out.println("getFontRenderContext():");
        return this.g2D.getFontRenderContext();
    }

    public Paint getPaint() {
        System.out.println("getPaint():");
        return this.g2D.getPaint();
    }

    public Object getRenderingHint(RenderingHints.Key key) {
        PrintStream printStream = System.out;
        printStream.println("getRenderingHint(RenderingHints.Key):");
        printStream.println("hintKey = " + key);
        return this.g2D.getRenderingHint(key);
    }

    public RenderingHints getRenderingHints() {
        System.out.println("getRenderingHints():");
        return this.g2D.getRenderingHints();
    }

    public Stroke getStroke() {
        System.out.println("getStroke():");
        return this.g2D.getStroke();
    }

    public AffineTransform getTransform() {
        System.out.println("getTransform():");
        return this.g2D.getTransform();
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean z) {
        PrintStream printStream = System.out;
        printStream.println("hit(Rectangle, Shape, onStroke):");
        printStream.println("rect = " + rectangle);
        printStream.println("s = " + shape);
        printStream.println("onStroke = " + z);
        return this.g2D.hit(rectangle, shape, z);
    }

    public boolean hitClip(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("hitClip(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        return this.g2D.hitClip(i, i2, i3, i4);
    }

    public void rotate(double d) {
        PrintStream printStream = System.out;
        printStream.println("rotate(theta):");
        printStream.println("theta = " + d);
        this.g2D.rotate(d);
    }

    public void scale(double d, double d2) {
        PrintStream printStream = System.out;
        printStream.println("scale(double,double):");
        printStream.println("sx = " + d);
        printStream.println("sy");
        this.g2D.scale(d, d2);
    }

    public void setBackground(Color color) {
        PrintStream printStream = System.out;
        printStream.println("setBackground(Color):");
        printStream.println("color = " + color);
        this.g2D.setBackground(color);
    }

    public void setClip(Shape shape) {
        PrintStream printStream = System.out;
        printStream.println("setClip(Shape):");
        printStream.println("clip = " + shape);
        this.g2D.setClip(shape);
    }

    public void setColor(Color color) {
        PrintStream printStream = System.out;
        printStream.println("setColor():");
        printStream.println("c = " + color);
        this.g2D.setColor(color);
    }

    public void setComposite(Composite composite) {
        PrintStream printStream = System.out;
        printStream.println("setComposite(Composite):");
        printStream.println("comp = " + composite);
        this.g2D.setComposite(composite);
    }

    public void setFont(Font font) {
        PrintStream printStream = System.out;
        printStream.println("setFont(Font):");
        printStream.println("font = " + font);
        this.g2D.setFont(font);
    }

    public void setPaint(Paint paint) {
        PrintStream printStream = System.out;
        printStream.println("setPain(Paint):");
        printStream.println("paint = " + paint);
        this.g2D.setPaint(paint);
    }

    public void setPaintMode() {
        System.out.println("setPaintMode():");
        this.g2D.setPaintMode();
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        PrintStream printStream = System.out;
        printStream.println("setRenderingHint(RenderingHints.Key, Object):");
        printStream.println("hintKey = " + key);
        printStream.println("hintValue = " + obj);
        this.g2D.setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map map) {
        PrintStream printStream = System.out;
        printStream.println("setRenderingHints(Map):");
        printStream.println("hints = " + map);
        this.g2D.setRenderingHints(map);
    }

    public void setStroke(Stroke stroke) {
        PrintStream printStream = System.out;
        printStream.println("setStroke(Stoke):");
        printStream.println("s = " + stroke);
        this.g2D.setStroke(stroke);
    }

    public void setTransform(AffineTransform affineTransform) {
        PrintStream printStream = System.out;
        printStream.println("setTransform():");
        printStream.println("Tx = " + affineTransform);
        this.g2D.setTransform(affineTransform);
    }

    public void setXORMode(Color color) {
        PrintStream printStream = System.out;
        printStream.println("setXORMode(Color):");
        printStream.println("c1 = " + color);
        this.g2D.setXORMode(color);
    }

    public void shear(double d, double d2) {
        PrintStream printStream = System.out;
        printStream.println("shear(shx, dhy):");
        printStream.println("shx = " + d);
        printStream.println("shy = " + d2);
        this.g2D.shear(d, d2);
    }

    public String toString() {
        System.out.println("toString():");
        return this.g2D.toString();
    }

    public void transform(AffineTransform affineTransform) {
        PrintStream printStream = System.out;
        printStream.println("transform(AffineTransform):");
        printStream.println("Tx = " + affineTransform);
        this.g2D.transform(affineTransform);
    }

    public void translate(double d, double d2) {
        PrintStream printStream = System.out;
        printStream.println("translate(double, double):");
        printStream.println("tx = " + d);
        printStream.println("ty = " + d2);
        this.g2D.translate(d, d2);
    }

    public Graphics create(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("create(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        return this.g2D.create(i, i2, i3, i4);
    }

    public Rectangle getClipBounds(Rectangle rectangle) {
        PrintStream printStream = System.out;
        printStream.println("getClipBounds(Rectangle):");
        printStream.println("r = " + rectangle);
        return this.g2D.getClipBounds(rectangle);
    }

    public FontMetrics getFontMetrics(Font font) {
        System.out.println("getFontMetrics():");
        return this.g2D.getFontMetrics(font);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i) {
        PrintStream printStream = System.out;
        printStream.println("drawPolygon(int[],int[],int):");
        printStream.println("xPoints = " + iArr);
        printStream.println("yPoints = " + iArr2);
        printStream.println("nPoints = " + i);
        this.g2D.drawPolygon(iArr, iArr2, i);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i) {
        PrintStream printStream = System.out;
        printStream.println("fillPolygon(int[],int[],int):");
        printStream.println("xPoints = " + iArr);
        printStream.println("yPoints = " + iArr2);
        printStream.println("nPoints = " + i);
        this.g2D.fillPolygon(iArr, iArr2, i);
    }

    public void rotate(double d, double d2, double d3) {
        PrintStream printStream = System.out;
        printStream.println("rotate(double,double,double):");
        printStream.println("theta = " + d);
        printStream.println("x = " + d2);
        printStream.println("y = " + d3);
        this.g2D.rotate(d, d2, d3);
    }

    public void setClip(int i, int i2, int i3, int i4) {
        PrintStream printStream = System.out;
        printStream.println("setClip(int,int,int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        this.g2D.setClip(i, i2, i3, i4);
    }

    public void translate(int i, int i2) {
        PrintStream printStream = System.out;
        printStream.println("translate(int,int):");
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        this.g2D.translate(i, i2);
    }

    public void drawString(String str, float f, float f2) {
        PrintStream printStream = System.out;
        printStream.println("drawString(s,x,y):");
        printStream.println("s = " + str);
        printStream.println("x = " + f);
        printStream.println("y = " + f2);
        this.g2D.drawString(str, f, f2);
    }

    public boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(Image,AfflineTransform,ImageObserver):");
        printStream.println("img = " + image);
        printStream.println("xform = " + affineTransform);
        printStream.println("obs = " + imageObserver);
        return this.g2D.drawImage(image, affineTransform, imageObserver);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i, int i2) {
        PrintStream printStream = System.out;
        printStream.println("drawString(AttributedCharacterIterator,int,int):");
        printStream.println("iterator = " + attributedCharacterIterator);
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        this.g2D.drawString(attributedCharacterIterator, i, i2);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(Image,int,int,int,int,int,int,int,int,ImageObserver):");
        printStream.println("img = " + image);
        printStream.println("dx1 = " + i);
        printStream.println("dy1 = " + i2);
        printStream.println("dx2 = " + i3);
        printStream.println("dy2 = " + i4);
        printStream.println("sx1 = " + i5);
        printStream.println("sy1 = " + i6);
        printStream.println("sx2 = " + i7);
        printStream.println("sy2 = " + i8);
        printStream.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, i5, i6, i7, i8, imageObserver);
    }

    public void drawString(String str, int i, int i2) {
        PrintStream printStream = System.out;
        printStream.println("drawString(str,int,int):");
        printStream.println("str = " + str);
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        this.g2D.drawString(str, i, i2);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(Image,int,int,int,int,int,int,int,int,Color,ImageObserver):");
        printStream.println("img = " + image);
        printStream.println("dx1 = " + i);
        printStream.println("dy1 = " + i2);
        printStream.println("dx2 = " + i3);
        printStream.println("dy2 = " + i4);
        printStream.println("sx1 = " + i5);
        printStream.println("sy1 = " + i6);
        printStream.println("sx2 = " + i7);
        printStream.println("sy2 = " + i8);
        printStream.println("bgcolor = " + color);
        printStream.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, i5, i6, i7, i8, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, Color color, ImageObserver imageObserver) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(Image,int,int,Color,ImageObserver):");
        printStream.println("img = " + image);
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("bgcolor = " + color);
        printStream.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(Image,int,int,observer):");
        printStream.println("img = " + image);
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, Color color, ImageObserver imageObserver) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(Image,int,int,int,int,Color,ImageObserver):");
        printStream.println("img = " + image);
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        printStream.println("bgcolor = " + color);
        printStream.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, color, imageObserver);
    }

    public boolean drawImage(Image image, int i, int i2, int i3, int i4, ImageObserver imageObserver) {
        PrintStream printStream = System.out;
        printStream.println("drawImage(Image,int,int,width,height,observer):");
        printStream.println("img = " + image);
        printStream.println("x = " + i);
        printStream.println("y = " + i2);
        printStream.println("width = " + i3);
        printStream.println("height = " + i4);
        printStream.println("observer = " + imageObserver);
        return this.g2D.drawImage(image, i, i2, i3, i4, imageObserver);
    }
}
