package com.itextpdf.tool.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Inherited
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface Experimental {
    String value() default "";
}
