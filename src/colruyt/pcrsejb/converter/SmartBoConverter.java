package colruyt.pcrsejb.converter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmartBoConverter<T,E> implements GenericConverter<E,T> {





    private List<Method> getGetters(T p) {
        return Arrays.asList(p.getClass().getMethods()).stream().filter(x -> x.getName().startsWith("get") && !x.getName().equals("getClass")).collect(Collectors.toList());
    }

    private List<Method> getSetters(E p) {
        return Arrays.asList(p.getClass().getMethods()).stream().filter(x -> x.getName().startsWith("set") && !x.getName().equals("getClass")).collect(Collectors.toList());

    }

    private void dataCopy(T p, E t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        for (Method getter : this.getGetters(p)) {

            for (Method setter : this.getSetters(t)) {

                //Cut get and Set from method name
                String set = setter.getName().substring(3, setter.getName().length());
                String get = getter.getName().substring(3, getter.getName().length());

                if (get.equals(set)) {

                    Object o = getter.invoke(p, null);
                    setter.invoke(t, o);
                }
            }

        }


    }

    private E createInstance(T p) throws IllegalAccessException, InstantiationException, ClassNotFoundException {


        //Bo off the object Name
        String target = p.getClass().getName().substring(0,p.getClass().getName().length()-2);
        //Invoke default constructor
        return (E) Class.forName(target).newInstance();


    }

    @Override
    public E convertTo(T from) {
        E result = null;

        try {

            result = this.createInstance(from);
            this.dataCopy(from, result);


        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (InstantiationException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (InvocationTargetException e) {

            e.printStackTrace();
        }

        return result;

    }
}