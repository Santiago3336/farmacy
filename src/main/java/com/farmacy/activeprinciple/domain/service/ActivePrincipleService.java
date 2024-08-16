package com.farmacy.activeprinciple.domain.service;

import com.farmacy.activeprinciple.domain.entity.ActivePrinciple;

import java.util.List;
import java.util.Optional;

public interface ActivePrincipleService {
    void createActivePrinciple(ActivePrinciple activePrinciple);
    Optional<ActivePrinciple> readActivePrinciple(int idAp);
    List<ActivePrinciple> getAllActivePrinciples();
    void updateActivePrinciple(ActivePrinciple activePrinciple);
    void deleteActivePrinciple(int idAp);
}
