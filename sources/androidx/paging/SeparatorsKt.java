package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.Q5;
import defpackage.R5;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SeparatorsKt {

    /* JADX INFO: renamed from: androidx.paging.SeparatorsKt$insertInternalSeparators$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.SeparatorsKt", f = "Separators.kt", l = {82}, m = "insertInternalSeparators")
    public static final class AnonymousClass1<R, T extends R> extends AbstractC0819Pf {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeparatorsKt.insertInternalSeparators(null, null, this);
        }
    }

    public static final <T> void addSeparatorPage(List<TransformablePage<T>> list, T t, int[] iArr, int i, int i2) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(iArr, "originalPageOffsets");
        if (t == null) {
            return;
        }
        list.add(separatorPage(t, iArr, i, i2));
    }

    public static final <T extends R, R> InterfaceC0939Tm insertEventSeparators(final InterfaceC0939Tm interfaceC0939Tm, TerminalSeparatorType terminalSeparatorType, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0939Tm, "<this>");
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        AbstractC4492zt.h(interfaceC0552Gp, "generator");
        final SeparatorState separatorState = new SeparatorState(terminalSeparatorType, new SeparatorsKt$insertEventSeparators$separatorState$1(interfaceC0552Gp, null));
        return new InterfaceC0939Tm() { // from class: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1

            /* JADX INFO: renamed from: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ SeparatorState $separatorState$inlined;
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1$2", f = "Separators.kt", l = {224, 223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC0819Pf {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
                        super(interfaceC0793Of);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm, SeparatorState separatorState) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                    this.$separatorState$inlined = separatorState;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // defpackage.InterfaceC0995Vm
                public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    InterfaceC0995Vm interfaceC0995Vm;
                    if (interfaceC0793Of instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objD = AbstractC0378Bt.d();
                    int i2 = anonymousClass1.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            interfaceC0995Vm = (InterfaceC0995Vm) anonymousClass1.L$0;
                            LL.b(obj2);
                        } else {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj2);
                        }
                        return FW.a;
                    }
                    LL.b(obj2);
                    InterfaceC0995Vm interfaceC0995Vm2 = this.$this_unsafeFlow;
                    SeparatorState separatorState = this.$separatorState$inlined;
                    anonymousClass1.L$0 = interfaceC0995Vm2;
                    anonymousClass1.label = 1;
                    Object objOnEvent = separatorState.onEvent((PageEvent) obj, anonymousClass1);
                    if (objOnEvent == objD) {
                        return objD;
                    }
                    obj2 = objOnEvent;
                    interfaceC0995Vm = interfaceC0995Vm2;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (interfaceC0995Vm.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = interfaceC0939Tm.collect(new AnonymousClass2(interfaceC0995Vm, separatorState), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:29:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d1 -> B:28:0x00da). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <R, T extends R> java.lang.Object insertInternalSeparators(androidx.paging.TransformablePage<T> r12, defpackage.InterfaceC0552Gp r13, defpackage.InterfaceC0793Of r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorsKt.insertInternalSeparators(androidx.paging.TransformablePage, Gp, Of):java.lang.Object");
    }

    public static final <T> TransformablePage<T> separatorPage(T t, int[] iArr, int i, int i2) {
        AbstractC4492zt.h(t, "separator");
        AbstractC4492zt.h(iArr, "originalPageOffsets");
        return new TransformablePage<>(iArr, AbstractC1805bc.e(t), i, AbstractC1805bc.e(Integer.valueOf(i2)));
    }

    public static final <R, T extends R> void addSeparatorPage(List<TransformablePage<R>> list, R r, TransformablePage<T> transformablePage, TransformablePage<T> transformablePage2, int i, int i2) {
        AbstractC4492zt.h(list, "<this>");
        int[] originalPageOffsets = transformablePage != null ? transformablePage.getOriginalPageOffsets() : null;
        int[] originalPageOffsets2 = transformablePage2 != null ? transformablePage2.getOriginalPageOffsets() : null;
        if (originalPageOffsets != null && originalPageOffsets2 != null) {
            originalPageOffsets = AbstractC3240kc.B0(AbstractC3240kc.w0(R5.F(Q5.w(originalPageOffsets, originalPageOffsets2))));
        } else if (originalPageOffsets == null && originalPageOffsets2 != null) {
            originalPageOffsets = originalPageOffsets2;
        } else if (originalPageOffsets == null || originalPageOffsets2 != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        addSeparatorPage(list, r, originalPageOffsets, i, i2);
    }
}
