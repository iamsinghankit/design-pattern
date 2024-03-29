package io.design.visitor;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author iamsinghankit
 */
public interface VisitorBuilder<R> extends BiConsumer<Class<?>, Function<Object,R>> {

    default void register(Class<?>type,Function<Object,R>function){
        this.accept(type,function);
    }
}
