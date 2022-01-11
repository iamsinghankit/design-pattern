package io.design.criteria;

import io.design.criteria.enums.Gender;
import io.design.criteria.enums.MaritalStatus;
import io.design.criteria.model.Person;

import java.util.List;

/**
 * @author _singhankit
 */
public class CriteriaApp {

    public static void main(String[] args) {
        List<Person> persons = createPersons();
        System.out.println("-------------------------List of Persons--------------------------------");

        printPersons(persons);

        System.out.println("-------------------------Male Criteria-------------------------");

        Criteria<Person> maleCriteria = PersonCriterias.genderCriteria( Gender.MALE);
        printPersons(maleCriteria.filter(persons));

        System.out.println("-------------------------Female Criteria-------------------------");

        Criteria<Person> femaleCriteria = PersonCriterias.genderCriteria( Gender.FEMALE);
        printPersons(femaleCriteria.filter(persons));

        System.out.println("-------------------------Not Married Criteria-------------------------");

        Criteria<Person> notMarriedCriteria = PersonCriterias.maritalStatusCriteria(MaritalStatus.NOT_MARRIED);
        printPersons(notMarriedCriteria.filter(persons));

        System.out.println("------------------------- Married Criteria-------------------------");

        Criteria<Person> marriedCriteria = PersonCriterias.maritalStatusCriteria(MaritalStatus.MARRIED);
        printPersons(marriedCriteria.filter(persons));

        System.out.println("-------------------------Male And Married Criteria-------------------------");

        Criteria<Person> maleMarriedCriteria =
                PersonCriterias.maritalStatusCriteria(MaritalStatus.MARRIED).and(PersonCriterias.genderCriteria(Gender.MALE));
        printPersons(maleMarriedCriteria.filter(persons));

        System.out.println("-------------------------Female And Not Married Criteria-------------------------");

        Criteria<Person> femaleMarriedCriteria =
                PersonCriterias.maritalStatusCriteria(MaritalStatus.NOT_MARRIED).and(PersonCriterias.genderCriteria(Gender.FEMALE));
        printPersons(femaleMarriedCriteria.filter(persons));

        System.out.println("-------------------------Female Or Married Criteria-------------------------");

        Criteria<Person> femaleOrMarriedCriteria =
                PersonCriterias.maritalStatusCriteria(MaritalStatus.MARRIED).or(PersonCriterias.genderCriteria(Gender.FEMALE));
        printPersons(femaleOrMarriedCriteria.filter(persons));
    }



    private static List<Person> createPersons() {
        return List.of(new Person("Robert", Gender.MALE, MaritalStatus.NOT_MARRIED),
                new Person("John", Gender.MALE, MaritalStatus.MARRIED),
                new Person("Mike", Gender.MALE, MaritalStatus.NOT_MARRIED),
                new Person("Bobby", Gender.FEMALE, MaritalStatus.NOT_MARRIED),
                new Person("Laura", Gender.FEMALE, MaritalStatus.MARRIED),
                new Person("Diana", Gender.FEMALE, MaritalStatus.NOT_MARRIED));

    }

    public static void printPersons(List<Person> persons) {
        persons.forEach(person ->
                                System.out.println("Person : [ Name : " + person.name() + ", Gender : " + person.gender() + ", Marital " +
                                                           "Status : " + person.maritalStatus() + " ]"));
    }
}
