package colruyt.pcrsejb.util.validators;

import colruyt.pcrsejb.util.exceptions.validation.ValidationException;

public interface GenericValidator<T> {

    void validate(T toValidate) throws ValidationException;

}
