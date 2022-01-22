package io.design.visitor.model;

import io.design.visitor.Visitor;

/**
 * @author iamsinghankit
 */
public class Engine {

//    public void  accept(Visitor visitor) {
//         visitor.visit(this);
//    }

//    public <R> R accept(Visitor<R> visitor) {
//        return visitor.visit(this);
//    }


    @Override
    public String toString() {
        return "Engine{}";
    }
}
