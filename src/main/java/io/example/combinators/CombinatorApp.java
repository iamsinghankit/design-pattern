package io.example.combinators;


import static io.example.combinators.UserValidation.nonEmptyName;
import static io.example.combinators.UserValidation.validateEmail;

/**
 * @author Ankit Singh
 */
public class CombinatorApp {
    public static void main(String[] args) {
        UserValidation validation = nonEmptyName().and(validateEmail());

        User ankit=new User("weagon",27,"weagon@gmail.com");
        User divya=new User("Christine",27,"christinegmail.com");

        ValidationResult result=validation.apply(ankit);
        result.reason().ifPresent(System.out::println);

        ValidationResult divyaResult=validation.apply(divya);
        divyaResult.reason().ifPresent(System.out::println);

    }
}
