package  br.com.zherro.codereusability.annotation.c1_getter_map;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface NomePropriedade {
    String value();
}