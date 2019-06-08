package com.elutra.aai.aaiexceptions;

public class AAIBussinessException {

    private String errorMessage;

    public AAIBussinessException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
