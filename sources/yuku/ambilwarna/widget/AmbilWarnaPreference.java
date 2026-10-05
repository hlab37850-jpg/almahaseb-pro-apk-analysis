package yuku.ambilwarna.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import defpackage.AbstractC2268gJ;
import defpackage.AbstractC2350hJ;
import defpackage.AbstractC3137jJ;
import defpackage.B2;

/* JADX INFO: loaded from: classes4.dex */
public class AmbilWarnaPreference extends Preference {
    public final boolean a;
    public int b;

    public AmbilWarnaPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context.obtainStyledAttributes(attributeSet, AbstractC3137jJ.AmbilWarnaPreference).getBoolean(AbstractC3137jJ.AmbilWarnaPreference_supportsAlpha, false);
        setWidgetLayoutResource(AbstractC2350hJ.ambilwarna_pref_widget);
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        View viewFindViewById = view.findViewById(AbstractC2268gJ.ambilwarna_pref_widget_box);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(this.b);
        }
    }

    @Override // android.preference.Preference
    public void onClick() {
        new B2(getContext(), this.b, this.a, new a()).u();
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInteger(i, 0));
    }

    @Override // android.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable.getClass().equals(b.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.b = bVar.a;
        notifyChanged();
    }

    @Override // android.preference.Preference
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return parcelableOnSaveInstanceState;
        }
        b bVar = new b(parcelableOnSaveInstanceState);
        bVar.a = this.b;
        return bVar;
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            this.b = getPersistedInt(this.b);
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        this.b = iIntValue;
        persistInt(iIntValue);
    }

    public static class b extends Preference.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public int a;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public class a implements B2.h {
        public a() {
        }

        @Override // B2.h
        public void b(B2 b2, int i) {
            if (AmbilWarnaPreference.this.callChangeListener(Integer.valueOf(i))) {
                AmbilWarnaPreference ambilWarnaPreference = AmbilWarnaPreference.this;
                ambilWarnaPreference.b = i;
                ambilWarnaPreference.persistInt(i);
                AmbilWarnaPreference.this.notifyChanged();
            }
        }

        @Override // B2.h
        public void a(B2 b2) {
        }
    }
}
