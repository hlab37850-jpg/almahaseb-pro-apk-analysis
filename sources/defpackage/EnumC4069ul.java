package defpackage;

/* JADX INFO: renamed from: ul, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC4069ul {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    public static final a b = new a(null);
    public final int a;

    /* JADX INFO: renamed from: ul$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final EnumC4069ul a(int i) {
            for (EnumC4069ul enumC4069ul : EnumC4069ul.values()) {
                if (enumC4069ul.b() == i) {
                    return enumC4069ul;
                }
            }
            return null;
        }

        public a() {
        }
    }

    EnumC4069ul(int i) {
        this.a = i;
    }

    public final int b() {
        return this.a;
    }
}
