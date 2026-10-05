package androidx.compose.foundation.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public abstract class AlignmentLineProvider {

    @StabilityInferred(parameters = 0)
    public static final class Block extends AlignmentLineProvider {
        public static final int $stable = 0;
        private final InterfaceC3750qp lineProviderBlock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Block(InterfaceC3750qp interfaceC3750qp) {
            super(null);
            AbstractC4492zt.h(interfaceC3750qp, "lineProviderBlock");
            this.lineProviderBlock = interfaceC3750qp;
        }

        public static /* synthetic */ Block copy$default(Block block, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
            if ((i & 1) != 0) {
                interfaceC3750qp = block.lineProviderBlock;
            }
            return block.copy(interfaceC3750qp);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int calculateAlignmentLinePosition(Placeable placeable) {
            AbstractC4492zt.h(placeable, "placeable");
            return ((Number) this.lineProviderBlock.invoke(placeable)).intValue();
        }

        public final InterfaceC3750qp component1() {
            return this.lineProviderBlock;
        }

        public final Block copy(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "lineProviderBlock");
            return new Block(interfaceC3750qp);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Block) && AbstractC4492zt.d(this.lineProviderBlock, ((Block) obj).lineProviderBlock);
        }

        public final InterfaceC3750qp getLineProviderBlock() {
            return this.lineProviderBlock;
        }

        public int hashCode() {
            return this.lineProviderBlock.hashCode();
        }

        public String toString() {
            return "Block(lineProviderBlock=" + this.lineProviderBlock + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class Value extends AlignmentLineProvider {
        public static final int $stable = 0;
        private final AlignmentLine alignmentLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Value(AlignmentLine alignmentLine) {
            super(null);
            AbstractC4492zt.h(alignmentLine, "alignmentLine");
            this.alignmentLine = alignmentLine;
        }

        public static /* synthetic */ Value copy$default(Value value, AlignmentLine alignmentLine, int i, Object obj) {
            if ((i & 1) != 0) {
                alignmentLine = value.alignmentLine;
            }
            return value.copy(alignmentLine);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int calculateAlignmentLinePosition(Placeable placeable) {
            AbstractC4492zt.h(placeable, "placeable");
            return placeable.get(this.alignmentLine);
        }

        public final AlignmentLine component1() {
            return this.alignmentLine;
        }

        public final Value copy(AlignmentLine alignmentLine) {
            AbstractC4492zt.h(alignmentLine, "alignmentLine");
            return new Value(alignmentLine);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Value) && AbstractC4492zt.d(this.alignmentLine, ((Value) obj).alignmentLine);
        }

        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        public String toString() {
            return "Value(alignmentLine=" + this.alignmentLine + ')';
        }
    }

    public /* synthetic */ AlignmentLineProvider(AbstractC0419Di abstractC0419Di) {
        this();
    }

    public abstract int calculateAlignmentLinePosition(Placeable placeable);

    private AlignmentLineProvider() {
    }
}
