package com.farmacy.region.infrastructure.controller;

import com.farmacy.region.application.CreateRegionUseCase;
import com.farmacy.region.domain.entity.Region;

public class RegionController {
    private final CreateRegionUseCase createRegionUseCase;

    public RegionController(CreateRegionUseCase createRegionUseCase) {
        this.createRegionUseCase = createRegionUseCase;
    }

    public void addRegion(String codeRegion, String nameRegion, String codeCountry) {
        Region region = new Region(codeRegion, nameRegion, codeCountry);
        createRegionUseCase.execute(region);
    }
}
