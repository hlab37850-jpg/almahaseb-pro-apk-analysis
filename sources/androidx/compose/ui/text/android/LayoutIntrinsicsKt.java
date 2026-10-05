package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.compose.ui.text.android.LayoutIntrinsicsKt;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutIntrinsicsKt {
    public static final float minIntrinsicWidth(CharSequence charSequence, TextPaint textPaint) {
        AbstractC4492zt.h(charSequence, "text");
        AbstractC4492zt.h(textPaint, "paint");
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, 0, charSequence.length()));
        PriorityQueue<C2020dG> priorityQueue = new PriorityQueue(10, new Comparator() { // from class: kv
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LayoutIntrinsicsKt.minIntrinsicWidth$lambda$0((C2020dG) obj, (C2020dG) obj2);
            }
        });
        int next = lineInstance.next();
        int i = 0;
        while (next != -1) {
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new C2020dG(Integer.valueOf(i), Integer.valueOf(next)));
            } else {
                C2020dG c2020dG = (C2020dG) priorityQueue.peek();
                if (c2020dG != null && ((Number) c2020dG.e()).intValue() - ((Number) c2020dG.c()).intValue() < next - i) {
                    priorityQueue.poll();
                    priorityQueue.add(new C2020dG(Integer.valueOf(i), Integer.valueOf(next)));
                }
            }
            int i2 = next;
            next = lineInstance.next();
            i = i2;
        }
        float fMax = 0.0f;
        for (C2020dG c2020dG2 : priorityQueue) {
            fMax = Math.max(fMax, Layout.getDesiredWidth(charSequence, ((Number) c2020dG2.a()).intValue(), ((Number) c2020dG2.b()).intValue(), textPaint));
        }
        return fMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int minIntrinsicWidth$lambda$0(C2020dG c2020dG, C2020dG c2020dG2) {
        return (((Number) c2020dG.e()).intValue() - ((Number) c2020dG.c()).intValue()) - (((Number) c2020dG2.e()).intValue() - ((Number) c2020dG2.c()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    public static final boolean shouldIncreaseMaxIntrinsic(float f, CharSequence charSequence, TextPaint textPaint) {
        if (f != 0.0f) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                if (!SpannedExtensionsKt.hasSpan(spanned, LetterSpacingSpanPx.class) && !SpannedExtensionsKt.hasSpan(spanned, LetterSpacingSpanEm.class)) {
                    if (textPaint.getLetterSpacing() == 0.0f) {
                    }
                }
            } else if (textPaint.getLetterSpacing() == 0.0f) {
            }
            return true;
        }
        return false;
    }
}
