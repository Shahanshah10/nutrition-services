package com.nutrition.external;

import com.nutrition.dto.Root;
import com.nutrition.exception.NutritionServiceException;
import com.nutrition.properties.NutritionProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExternalNutritionApi {

    private static final Logger logger = LoggerFactory.getLogger(ExternalNutritionApi.class);
    private final WebClient webClient;
    private final NutritionProperties nutritionProperties;

    public ExternalNutritionApi(WebClient webClient, NutritionProperties nutritionProperties) {
        this.webClient = webClient;
        this.nutritionProperties = nutritionProperties;
    }


    public Root searchNutrients(String upc) {

        String nutritionApiUrl=nutritionProperties.getNutritionApiBaseUrl().concat(nutritionProperties.getNutritionApiSearchEndPoint());
        Map<String,Object> params=new HashMap<>();
        params.put("upc",upc);

        return webClient.get().uri(nutritionApiUrl,params)
                    .header("x-app-id", "c4e4f1ba")
                    .header("x-app-key", "c607395a6c73ba1ca86e1ccd99161d4f")
                    .retrieve().bodyToMono(Root.class)
                    .block();
    }
}