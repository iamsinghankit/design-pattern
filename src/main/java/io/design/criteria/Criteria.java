package io.design.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iamsinghankit
 */
public interface Criteria<E> {

    List<E> filter(List<E> entity);


    default Criteria<E> and(Criteria<E> otherCriteria) {
        return (entity) -> otherCriteria.filter(this.filter(entity));
    }


    default Criteria<E> or(Criteria<E> otherCriteria) {
        return (entity) -> {
            List<E> es = new ArrayList<>( filter(entity));
            List<E> es1 = otherCriteria.filter(entity);
            es.addAll(es1.stream().filter(e -> !es.contains(e)).toList());
            return es;
        };
    }

}
