package com.nutrition.controller;

import com.nutrition.dto.Root;
import com.nutrition.external.ExternalNutritionApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/nutrition")
public class NutritionController {

    private final ExternalNutritionApi externalNutritionApi;

    @GetMapping("/searchNutrient")
    public ResponseEntity<Root> searchNutrients(@Param("upc") String upc) {
        log.info("Enter into searching nutrients with upc :{}", upc);
        Root root = externalNutritionApi.searchNutrients(upc);
        log.info("Exiting from searching nutrients with upc :{}", upc);
        return Objects.nonNull(root) ? ResponseEntity.status(HttpStatus.OK).body(root) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
