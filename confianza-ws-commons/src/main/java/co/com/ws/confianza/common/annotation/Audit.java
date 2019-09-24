package co.com.ws.confianza.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotacion que define los metodos a auditar.
 *
 * @author Didier esteban garcia olave.
 * @copy Todos los derechos reservados a confianza.
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Audit {

    String value() default "";

}
