package org.example.kotiki._2023_03_24.annot;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {METHOD, FIELD})
public @interface MA {

}
