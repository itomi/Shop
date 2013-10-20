package pl.solsoft.shop2013.validation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 14.08.13
 * Time: 16:21
 * To change this template use File | Settings | File Templates.
*/

@Target( {ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmUserPasswordValidator.class)
public @interface ConfirmUserPassword {
    String message() default "The password fields must match.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
