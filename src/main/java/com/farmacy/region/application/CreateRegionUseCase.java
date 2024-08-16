package com.farmacy.region.application;

import com.farmacy.region.domain.entity.Region;
import com.farmacy.region.domain.service.RegionService;

public class CreateRegionUseCase {
    private final RegionService regionService;

    public CreateRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(Region region) {
        regionService.addRegion(region);
    }
}
