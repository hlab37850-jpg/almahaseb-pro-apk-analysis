package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MappedInteractionSource implements InteractionSource {
    private final long delta;
    private final InterfaceC0939Tm interactions;
    private final Map<PressInteraction.Press, PressInteraction.Press> mappedPresses;

    public /* synthetic */ MappedInteractionSource(InteractionSource interactionSource, long j, AbstractC0419Di abstractC0419Di) {
        this(interactionSource, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PressInteraction.Press mapPress(PressInteraction.Press press) {
        return new PressInteraction.Press(Offset.m2802minusMKHz9U(press.m366getPressPositionF1C5BW0(), this.delta), null);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public InterfaceC0939Tm getInteractions() {
        return this.interactions;
    }

    private MappedInteractionSource(InteractionSource interactionSource, long j) {
        AbstractC4492zt.h(interactionSource, "underlyingInteractionSource");
        this.delta = j;
        this.mappedPresses = new LinkedHashMap();
        final InterfaceC0939Tm interactions = interactionSource.getInteractions();
        this.interactions = new InterfaceC0939Tm() { // from class: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1

            /* JADX INFO: renamed from: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;
                final /* synthetic */ MappedInteractionSource this$0;

                /* JADX INFO: renamed from: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2", f = "MappedInteractionSource.kt", l = {223}, m = "emit")
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

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm, MappedInteractionSource mappedInteractionSource) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                    this.this$0 = mappedInteractionSource;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // defpackage.InterfaceC0995Vm
                public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    PressInteraction.Release release;
                    PressInteraction.Cancel cancel;
                    Object release2;
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
                    if (i2 == 0) {
                        LL.b(obj2);
                        InterfaceC0995Vm interfaceC0995Vm = this.$this_unsafeFlow;
                        Interaction interaction = (Interaction) obj;
                        if (interaction instanceof PressInteraction.Press) {
                            PressInteraction.Press pressMapPress = this.this$0.mapPress((PressInteraction.Press) interaction);
                            this.this$0.mappedPresses.put(interaction, pressMapPress);
                            release2 = pressMapPress;
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            cancel = (PressInteraction.Cancel) interaction;
                            PressInteraction.Press press = (PressInteraction.Press) this.this$0.mappedPresses.remove(cancel.getPress());
                            if (press != null) {
                                release2 = cancel;
                                release2 = new PressInteraction.Cancel(press);
                            }
                        } else if (interaction instanceof PressInteraction.Release) {
                            release = (PressInteraction.Release) interaction;
                            PressInteraction.Press press2 = (PressInteraction.Press) this.this$0.mappedPresses.remove(release.getPress());
                            if (press2 != null) {
                                release2 = interaction;
                                release2 = release;
                                release2 = new PressInteraction.Release(press2);
                            }
                        }
                        release2 = interaction;
                        release2 = release;
                        release2 = interaction;
                        release2 = cancel;
                        anonymousClass1.label = 1;
                        if (interfaceC0995Vm.emit(release2, anonymousClass1) == objD) {
                            return objD;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj2);
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = interactions.collect(new AnonymousClass2(interfaceC0995Vm, this), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        };
    }
}
