package org.queue.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY, reason="User already exists")
public class UserAleadyExistsException extends RuntimeException {
}
