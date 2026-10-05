package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0756Mu;
import defpackage.V;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ImmutableList<E> extends List<E>, ImmutableCollection<E>, InterfaceC0756Mu {

    public static final class SubList<E> extends V implements ImmutableList<E> {
        private int _size;
        private final int fromIndex;
        private final ImmutableList<E> source;
        private final int toIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(ImmutableList<? extends E> immutableList, int i, int i2) {
            AbstractC4492zt.h(immutableList, DublinCoreProperties.SOURCE);
            this.source = immutableList;
            this.fromIndex = i;
            this.toIndex = i2;
            ListImplementation.checkRangeIndexes$runtime_release(i, i2, immutableList.size());
            this._size = i2 - i;
        }

        @Override // defpackage.V, java.util.List
        public E get(int i) {
            ListImplementation.checkElementIndex$runtime_release(i, this._size);
            return this.source.get(this.fromIndex + i);
        }

        @Override // defpackage.V, defpackage.D
        public int getSize() {
            return this._size;
        }

        @Override // defpackage.V, java.util.List
        public ImmutableList<E> subList(int i, int i2) {
            ListImplementation.checkRangeIndexes$runtime_release(i, i2, this._size);
            ImmutableList<E> immutableList = this.source;
            int i3 = this.fromIndex;
            return new SubList(immutableList, i + i3, i3 + i2);
        }
    }

    @Override // java.util.List
    ImmutableList<E> subList(int i, int i2);

    @Override // java.util.List
    /* bridge */ /* synthetic */ List subList(int i, int i2);
}
