package colruyt.pcrsejb.converter;

public interface GenericConverter<T,E> {

    T convertTo(E from);

}
