package com.farmacy.region.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.region.domain.entity.Region;

public interface RegionService {
    void addRegion(Region region);
    Optional<Region> readRegion(String codeRegion);
    List<Region> getAllRegions();
    void updateRegion(Region region);
    void deleteRegion(String codeRegion);
}
