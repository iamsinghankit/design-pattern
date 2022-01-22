package io.design.visitor.model;

import io.design.visitor.Visitor;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author iamsinghankit
 */
public class Car {
    private final Body body = new Body();
    private final Engine engine = new Engine();
    private final Wheel[] wheels = {new Wheel(), new Wheel(), new Wheel(), new Wheel()};

//    public void accept(Visitor visitor) {
//        this.body.accept(visitor);
//        this.engine.accept(visitor);
//        Arrays.stream(this.wheels).forEach(wheel -> wheel.accept(visitor));
//    }

    //    public <R,RR> RR accept(Visitor<R> visitor, Collector<? super R, ?, RR> collector) {
    //        R r1 = this.body.accept(visitor);
    //        R r2 = this.engine.accept(visitor);
    //        R r3 = this.wheels[0].accept(visitor);
    //        R r4 = this.wheels[1].accept(visitor);
    //        R r5 = this.wheels[2].accept(visitor);
    //        R r6 = this.wheels[3].accept(visitor);
    //        R r7 = accept(visitor);
    //        return Stream.of(r1,r2,r3,r4,r5,r6,r7).collect(collector);
    //    }
    //
    //    private <R> R accept(Visitor<R> visitor) {
    //        return visitor.visit(this);
    //    }

    public Body body() {
        return body;
    }

    public Engine engine() {
        return engine;
    }

    public Wheel[] wheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                       "body=" + body +
                       ", engine=" + engine +
                       ", wheels=" + Arrays.toString(wheels) +
                       '}';
    }
}
