package io.design.criteria.model;

import io.design.criteria.enums.Gender;
import io.design.criteria.enums.MaritalStatus;

public record Person(String name,Gender gender,MaritalStatus maritalStatus) { }