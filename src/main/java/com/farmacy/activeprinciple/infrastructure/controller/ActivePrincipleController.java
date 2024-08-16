package com.farmacy.activeprinciple.infrastructure.controller;

import com.farmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.farmacy.activeprinciple.domain.service.ActivePrincipleService;

public class ActivePrincipleController {
    private final ActivePrincipleService activePrincipleService;

    public ActivePrincipleController(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void createActivePrinciple(ActivePrinciple activePrinciple) {
        activePrincipleService.createActivePrinciple(activePrinciple);
    }

    public ActivePrinciple getActivePrinciple(int idAp) {
        return activePrincipleService.readActivePrinciple(idAp).orElse(null);
    }

    public void updateActivePrinciple(ActivePrinciple activePrinciple) {
        activePrincipleService.updateActivePrinciple(activePrinciple);
    }

    public void deleteActivePrinciple(int idAp) {
        activePrincipleService.deleteActivePrinciple(idAp);
    }
}
