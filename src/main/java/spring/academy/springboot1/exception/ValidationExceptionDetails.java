package spring.academy.springboot1.exception;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ValidationExceptionDetails extends  ExceptionDetails{
    private final String fields;
    private final String fieldMessage;
}
