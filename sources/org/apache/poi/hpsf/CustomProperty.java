package org.apache.poi.hpsf;

/* JADX INFO: loaded from: classes2.dex */
public class CustomProperty extends MutableProperty {
    private String name;

    public CustomProperty() {
        this.name = null;
    }

    public boolean equalsContents(Object obj) {
        boolean zEquals;
        CustomProperty customProperty = (CustomProperty) obj;
        String name = customProperty.getName();
        String name2 = getName();
        if (name == null) {
            zEquals = name2 == null;
        } else {
            zEquals = name.equals(name2);
        }
        return zEquals && customProperty.getID() == getID() && customProperty.getType() == getType() && customProperty.getValue().equals(getValue());
    }

    public String getName() {
        return this.name;
    }

    @Override // org.apache.poi.hpsf.Property
    public int hashCode() {
        return (int) getID();
    }

    public void setName(String str) {
        this.name = str;
    }

    public CustomProperty(Property property) {
        this(property, null);
    }

    public CustomProperty(Property property, String str) {
        super(property);
        this.name = str;
    }
}
