package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by user on 2017/8/14.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)

public @interface Auto {
    String value() default "auto process";
}
