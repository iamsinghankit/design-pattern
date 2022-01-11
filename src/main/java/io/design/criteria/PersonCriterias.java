package io.design.criteria;

import io.design.criteria.enums.Gender;
import io.design.criteria.enums.MaritalStatus;
import io.design.criteria.model.Person;

/**
 * @author _singhankit
 */
public final class PersonCriterias {

    private PersonCriterias() {
        throw new AssertionError();
    }


    public static Criteria<Person> genderCriteria(Gender gender) {
        return (personsList) -> personsList.stream().filter(e -> e.gender().equals(gender)).toList();
    }


    public static Criteria<Person> maritalStatusCriteria(MaritalStatus maritalStatus) {
        return (personsList) -> personsList.stream().filter(e -> e.maritalStatus().equals(maritalStatus)).toList();
    }


}
