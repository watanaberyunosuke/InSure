package com.harrybwatson.insure.policy.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PolicyTypeNotFoundException extends RuntimeException{
    // Left blank intentionally
}
