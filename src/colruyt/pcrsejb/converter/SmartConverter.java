package colruyt.pcrsejb.converter;

import sun.net.www.content.text.Generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmartConverter<T,E> implements GenericConverter<E,T>{

    private List<Method> getGetters(T p){
        return Arrays.asList(p.getClass().getMethods()).stream().filter(x-> x.getName().startsWith("get") && !x.getName().equals("getClass")).collect(Collectors.toList());
    }

    private List<Method> getSetters(E p){
        return Arrays.asList(p.getClass().getMethods()).stream().filter(x-> x.getName().startsWith("set") && !x.getName().equals("getClass")).collect(Collectors.toList());

    }

    private void dataCopy(T p , E t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        for(Method g : this.getGetters(p)) {

            for(Method s : this.getSetters(t)) {

                String set = s.getName().substring(3, s.getName().length());
                String get = g.getName().substring(3, g.getName().length());

                if(get.equals(set)) {


                    Object o =  g.invoke(p, null);
                    s.invoke(t,o);
                }
            }

        }



    }

    private E createInstance(T p) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        String target = p.getClass().getName() + "Bo";

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
