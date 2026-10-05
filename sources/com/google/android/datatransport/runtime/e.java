package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.e;
import defpackage.InterfaceC4460zV;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Transport {
    public final TransportContext a;
    public final String b;
    public final Encoding c;
    public final Transformer d;
    public final InterfaceC4460zV e;

    public e(TransportContext transportContext, String str, Encoding encoding, Transformer transformer, InterfaceC4460zV interfaceC4460zV) {
        this.a = transportContext;
        this.b = str;
        this.c = encoding;
        this.d = transformer;
        this.e = interfaceC4460zV;
    }

    public static /* synthetic */ void c(Exception exc) {
    }

    public TransportContext b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.Transport
    public void schedule(Event event, TransportScheduleCallback transportScheduleCallback) {
        this.e.send(SendRequest.a().setTransportContext(this.a).setEvent(event).setTransportName(this.b).setTransformer(this.d).setEncoding(this.c).build(), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public void send(Event event) {
        schedule(event, new TransportScheduleCallback() { // from class: yV
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void onSchedule(Exception exc) {
                e.c(exc);
            }
        });
    }
}
