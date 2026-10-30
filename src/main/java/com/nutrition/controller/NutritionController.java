package com.nutrition.controller;

import com.nutrition.dto.Root;
import com.nutrition.external.ExternalNutritionApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/v1/nutrition")
public class NutritionController {

    private static final Logger log = LoggerFactory.getLogger(NutritionController.class);

    private final ExternalNutritionApi externalNutritionApi;

    public NutritionController(ExternalNutritionApi externalNutritionApi) {
        this.externalNutritionApi = externalNutritionApi;
    }

    @GetMapping("/searchNutrient")
    public ResponseEntity<Root> searchNutrients(@Param("upc") String upc) {
        log.info("Enter into searching nutrients with upc :{}", upc);
        Root root = externalNutritionApi.searchNutrients(upc);
        log.info("Exiting from searching nutrients with upc :{}", upc);
        return Objects.nonNull(root) ? ResponseEntity.status(HttpStatus.OK).body(root) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
