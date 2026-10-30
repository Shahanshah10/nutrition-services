
package com.nutrition.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NutritionProperties {

    @Value("${external-nutrition-api.base-url}")
    private String nutritionApiBaseUrl;

    @Value("${external-nutrition-api.search-end-point}")
    private String nutritionApiSearchEndPoint;

    public String getNutritionApiBaseUrl() {
        return nutritionApiBaseUrl;
    }

    public String getNutritionApiSearchEndPoint() {
        return nutritionApiSearchEndPoint;
    }
}
