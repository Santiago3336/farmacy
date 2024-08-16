package com.farmacy.activeprinciple.application;

import com.farmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.farmacy.activeprinciple.domain.service.ActivePrincipleService;

public class CreateActivePrincipleUseCase {
    private final ActivePrincipleService activePrincipleService;

    public CreateActivePrincipleUseCase(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void execute(ActivePrinciple activePrinciple) {
        activePrincipleService.createActivePrinciple(activePrinciple);
    }
}
