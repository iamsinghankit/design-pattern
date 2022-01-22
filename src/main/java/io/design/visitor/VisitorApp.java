package io.design.visitor;

import io.design.visitor.model.Body;
import io.design.visitor.model.Car;
import io.design.visitor.model.Engine;
import io.design.visitor.model.Wheel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iamsinghankit
 */
public class VisitorApp {
    public static void main(String[] args) {
        VisitorApp visitorApp = new VisitorApp();
        visitorApp.functionalVisitor();
    }


    public void functionalVisitor() {
        Car buggati = new Car();

//        VisitorInitializer<String> visitorInitializer = builder -> {
//            builder.register(Car.class, car -> "Visited car " + car);
//            builder.register(Body.class, body -> "Visited body " + body);
//            builder.register(Engine.class, engine -> "Visited engine " + engine);
//            builder.register(Wheel.class, wheel -> "Visited wheel " + wheel);
//        };

//        VisitorInitializer<String>visitorInitializer=
//                Visitor.<Car,String>forType(Car.class).execute(car -> "Visited car " + car)
//                                                             .forType(Body.class).execute(body -> "Visited body " + body)
//                                                             .forType(Engine.class).execute(engine -> "Visited engine " + engine)
//                                                             .forType(Wheel.class).execute(wheel -> "Visited wheel " + wheel);

        VisitorInitializer<String> visitorInitializer =
                Visitor.<Car, String>forType(Car.class).execute((Car car) -> "Visiting car: " + car)
                       .forType(Body.class).execute((Body body) -> "Visiting body: " + body)
                       .forType(Engine.class).execute(engine -> "Visiting engine: " + engine)
                       .forType(Wheel.class).execute(wheel -> "Visiting wheel: " + wheel);

//        BiConsumer<Class<?>, Function<Object, String>> biConsumer = (type, function) -> registry.put(type, function);
        Visitor<String> visitor = Visitor.of(visitorInitializer);
//        Consumer<VisitorBuilder<String>> consumer = builder -> {
//            builder.register(Car.class, car -> "Visited car " + car);
//            builder.register(Body.class, body -> "Visited body " + body);
//            builder.register(Engine.class, engine -> "Visited engine " + engine);
//            builder.register(Wheel.class, wheel -> "Visited wheel " + wheel);
//        };
//        consumer.accept(visitorBuilder);

//        visitorBuilder.register(Car.class, car -> "Visited car " + car);
//        visitorBuilder.register(Body.class, body -> "Visited body " + body);
//        visitorBuilder.register(Engine.class, engine -> "Visited engine " + engine);
//        visitorBuilder.register(Wheel.class, wheel -> "Visited wheel " + wheel);

//        registry.put(Car.class, car -> "Visited car " + car);
//        registry.put(Body.class, body -> "Visited body " + body);
//        registry.put(Engine.class, engine -> "Visited engine " + engine);
//        registry.put(Wheel.class, wheel -> "Visited wheel " + wheel);


//        String visit = visitor.visit(buggati);
//        System.out.println("visit = " + visit);
//
//        String visit1 = visitor.visit(buggati.body());
//        System.out.println("visit1 = " + visit1);

        String visitedCar = visitor.visit(buggati);
        System.out.println("visitedCar = " + visitedCar);

        String visitedBody = visitor.visit(buggati.body());
        System.out.println("visitedBody = " + visitedBody);

        VisitableFactory<Car> visitableFactory =
                VisitableFactory.forType(Car.class)
                                .visit(
                                        car -> car,
                                        Car::body,
                                        Car::engine,
                                        car -> car.wheels()[0]
                                );

        Visitable<Car> visitableBuggati = visitableFactory.makeVisitable(buggati);

        String visited1 = visitableBuggati.accept(visitor, Collectors.joining("\n"));
        System.out.println("Visited car = " + visited1);

        List<String> visited2 = visitableBuggati.accept(visitor, Collectors.toList());
        System.out.println("Visited car = " + visited2);
//        var visitor = new Visitor<String>() {
//
//
//            @Override
//            public String visit(Car car) {
//                return "Visited car " + car;
//            }
//
//            @Override
//            public String visit(Body body) {
//                return "Visited body " + body;
//            }
//
//            @Override
//            public String visit(Engine engine) {
//                return "Visited engine " + engine;
//            }
//
//            @Override
//            public String visit(Wheel wheel) {
//                return "Visited wheel " + wheel;
//            }

    }


    //        String accept = buggati.accept(visitor, Collectors.joining(" -- "));
//        System.out.println("accept = " + accept);
//
//        List<String> accept1 = buggati.accept(visitor, Collectors.toList());
//        accept1.forEach(System.out::println);
}

// without functional
//    public void gofVisitor() {
//        Car buggati = new Car();
//        var visitor = new Visitor() {
//
//            private String visited = "";
//
//            @Override
//            public void visit(Car car) {
//                visited += "Visited car " + car;
//            }
//
//            @Override
//            public void visit(Body body) {
//                visited += "Visited body " + body;
//            }
//
//            @Override
//            public void visit(Engine engine) {
//                visited += "Visited engine " + engine;
//            }
//
//            @Override
//            public void visit(Wheel wheel) {
//                visited += "Visited wheel " + wheel;
//            }
//
//            public String getVisited() {
//                return visited;
//            }
//        };
//        buggati.accept(visitor, collector);
//        System.out.println(visitor.getVisited());
//    }



