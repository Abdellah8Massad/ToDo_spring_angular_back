package com.massad.todo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CryptoColumn {
    public String clePrivate();
    public String clePublic();
}
