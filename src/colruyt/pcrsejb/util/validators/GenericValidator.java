package colruyt.pcrsejb.util.validators;

public interface GenericValidator<T> {

    public boolean validate(T toValidate);

}
