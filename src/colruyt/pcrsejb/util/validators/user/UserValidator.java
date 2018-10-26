package colruyt.pcrsejb.util.validators.user;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;
import colruyt.pcrsejb.util.exceptions.validation.user.InvalidEmailException;
import colruyt.pcrsejb.util.exceptions.validation.user.InvalidFirstNameException;
import colruyt.pcrsejb.util.exceptions.validation.user.InvalidLastNameException;
import colruyt.pcrsejb.util.validators.GenericValidator;

public class UserValidator implements GenericValidator<User> {

    @Override
    public void validate(User toValidate) throws ValidationException {

        try {
            this.validateEmail(toValidate.getEmail());
            this.validateLastName(toValidate.getLastName());
            this.validateFirstName(toValidate.getFirstName());
        }
        catch(Exception e){
            //Encapsuleer de Exception
            throw new ValidationException(e);
        }
    }

    private void validateFirstName(String firstName) throws InvalidFirstNameException {
        if(firstName == null || firstName.isEmpty()){
            throw new InvalidFirstNameException();
        }

    }

    private void validateEmail(String email) throws InvalidEmailException {
        String regExp = "[a-zA-Z.]+@[a-zA-Z]+.[a-zA-Z]+";
        if(email == null || email.isEmpty()){
            throw new InvalidEmailException();
        }


    }

    private void validateLastName(String lastName) throws InvalidLastNameException {
        if(lastName == null || lastName.isEmpty()){
            throw new InvalidLastNameException();
        }

    }
}
