package pl.bd2.shop2013.validation;

import pl.bd2.shop2013.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created with IntelliJ IDEA.
 * User: arek
 * Date: 14.08.13
 * Time: 16:32
 * To change this template use File | Settings | File Templates.

*/
public class ConfirmUserPasswordValidator implements ConstraintValidator<ConfirmUserPassword, Object> {

    private String message;

    @Override
    public void initialize(ConfirmUserPassword confirmUserPassword) {
        message = confirmUserPassword.message();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        User user = (User) o;
        if (user.getPassword().equals(user.getConpasswd()))
            return true;

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message).addPropertyNode("conpasswd").addConstraintViolation();
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
