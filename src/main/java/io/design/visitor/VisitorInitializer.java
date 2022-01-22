package io.design.visitor;

import java.util.function.Consumer;

/**
 * @author iamsinghankit
 */
public interface VisitorInitializer<R> extends Consumer<VisitorBuilder<R>> {

    default void init(VisitorBuilder<R> visitorBuilder) {
        this.accept(visitorBuilder);
    }
}
