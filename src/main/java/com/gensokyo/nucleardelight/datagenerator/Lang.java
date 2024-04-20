package com.gensokyo.nucleardelight.datagenerator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Langs.class)
public @interface Lang {
    LangName lang();
    String name();
}

