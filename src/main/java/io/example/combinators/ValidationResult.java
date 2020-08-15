package io.example.combinators;

import java.util.Optional;

/**
 * @author Ankit Singh
 */
public interface ValidationResult {

    static ValidationResult valid(){
        return new Valid();
    }

    static ValidationResult invalid(String reason){
        return new Invalid(reason);
    }

    boolean isValid();

    Optional<String> reason();


    final class Invalid implements ValidationResult {
        private final String reason;

        public Invalid(String reason) {
            this.reason = reason;
        }

        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public Optional<String> reason() {
            return Optional.of(reason);
        }
    }

    final class Valid implements ValidationResult{
        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public Optional<String> reason() {
            return Optional.empty();
        }
    }
}

