package colruyt.pcrsejb.converter;

public interface GenericConverter<T,E> {

    public T convertTo(E from);

}
