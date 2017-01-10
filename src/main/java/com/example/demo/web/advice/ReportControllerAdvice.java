package com.example.demo.web.advice;

import com.example.demo.web.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ReportControllerAdvice
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@ControllerAdvice
public class ReportControllerAdvice {

    /**
     * Handle default exception response entity.
     *
     * @param e the e
     *
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<SimpleResponse> handleDefaultException(Exception e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<SimpleResponse>(SimpleResponse.error(e, httpStatus), httpStatus);
    }
}
