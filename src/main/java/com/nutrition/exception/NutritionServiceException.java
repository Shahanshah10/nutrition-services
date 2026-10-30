package com.nutrition.exception;

import java.io.Serializable;

public class NutritionServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public NutritionServiceException(String str) {
        super(str);
    }
}