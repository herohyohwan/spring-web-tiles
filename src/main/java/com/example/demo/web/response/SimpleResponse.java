package com.example.demo.web.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * SimpleResponse
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@Data
public class SimpleResponse {
    /**
     * The Status.
     */
    private int status;
    /**
     * The Result.
     */
    private Result result;
    /**
     * The Message.
     */
    private String message;
    /**
     * The Error.
     */
    private String error;

    /**
     * Ok simple response.
     *
     * @param message the message
     *
     * @return the simple response
     */
    public static SimpleResponse ok(String message) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.result = Result.OK;
        simpleResponse.message = message;
        simpleResponse.status = HttpStatus.OK.value();
        return simpleResponse;
    }

    /**
     * Ok simple response.
     *
     * @return the simple response
     */
    public static SimpleResponse ok() {
        return ok(null);
    }

    /**
     * Error simple response.
     *
     * @param message   the message
     * @param exception the exception
     *
     * @return the simple response
     */
    public static SimpleResponse error(String message, Exception exception) {
        return error(message, exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * Error simple response.
     *
     * @param message   the message
     * @param exception the exception
     * @param status    the status
     *
     * @return the simple response
     */
    public static SimpleResponse error(String message, Exception exception, HttpStatus status) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.result = Result.ERROR;
        simpleResponse.message = message;
        simpleResponse.error = exception.getMessage();
        if (status != null) {
            simpleResponse.status = status.value();
        }
        return simpleResponse;
    }

    /**
     * Error simple response.
     *
     * @param exception the exception
     *
     * @return the simple response
     */
    public static SimpleResponse error(Exception exception) {
        return error(getTop5FromStackTrace(exception), exception);
    }

    /**
     * Error simple response.
     *
     * @param exception the exception
     * @param status    the status
     *
     * @return the simple response
     */
    public static SimpleResponse error(Exception exception, HttpStatus status) {
        return error(getTop5FromStackTrace(exception), exception, status);
    }

    /**
     * Gets top 5 from stack trace.
     *
     * @param ex the ex
     *
     * @return the top 5 from stack trace
     */
    private static String getTop5FromStackTrace(Exception ex) {
        if (ex == null) {
            return null;
        }
        final int TOP = 5;
        StringBuilder sb = new StringBuilder(500);
        StackTraceElement[] st = ex.getStackTrace();
        sb.append(ex.getClass().getName()).append(": ").append(ex.getMessage()).append(" \n");
        for (int i = 0; i < st.length && i < TOP; i++) {
            sb.append("\t at ").append(st[i].toString()).append(" \n");
        }
        if (st.length >= TOP) {
            sb.append("...");
        }
        return sb.toString();
    }

    /**
     * Error simple response.
     *
     * @param message the message
     *
     * @return the simple response
     */
    public static SimpleResponse error(String message) {
        return error(message, new Exception());
    }

    /**
     * Result
     *
     * @author herohyohwan@gmail.com
     * @date 2017.01.09
     */
    public enum Result {
        /**
         * Ok result.
         */
        OK,
        /**
         * Error result.
         */
        ERROR}

}
