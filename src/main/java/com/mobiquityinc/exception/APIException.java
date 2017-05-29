package com.mobiquityinc.exception;


/**
 * User Defined excpetion throws when any validation failure occurs
 *
 * Created by Mithilesh Ravindran
 */
public class APIException extends Exception {

    public APIException(String message) {
        super(message);
    }
}
