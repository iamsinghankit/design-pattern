package io.example.combinators;


import java.util.function.Function;
import java.util.function.Predicate;

import static io.example.combinators.ValidationResult.invalid;
import static io.example.combinators.ValidationResult.valid;

/**
 * @author Ankit Singh
 */
public interface UserValidation extends Function<User, ValidationResult> {

    static UserValidation nonEmptyName() {
        return holds(user -> !user.name()
                                  .trim()
                                  .isEmpty(), "Name is Empty");
    }

    static UserValidation validateEmail(){
        return holds(user -> user.email().contains("@"),"Missing @-sign");
    }

    static UserValidation holds(Predicate<User> p, String message) {
        return user -> p.test(user) ? valid() : invalid(message);
    }

    default UserValidation and(UserValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }

    static UserValidation all(UserValidation... validations){
        throw new UnsupportedOperationException();
    }
}
