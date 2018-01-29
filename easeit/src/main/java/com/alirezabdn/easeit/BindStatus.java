package com.alirezabdn.easeit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shadoWalker on 1/29/18.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindStatus {
    public enum Status {BIND, DO_NOT_BIND}

    Status value() default Status.BIND;
}
