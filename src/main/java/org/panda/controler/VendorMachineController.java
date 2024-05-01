package org.panda.controler;

import org.panda.dto.request.DtoEvent;
import org.panda.enums.VendorEvent;
import org.panda.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorMachineController {

    private final VendorService vendorService;

    @Autowired
    public VendorMachineController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/transition")
    public void transitionState(@RequestBody DtoEvent dtoEvent) {
        vendorService.performTransition(dtoEvent.getEvent());
    }
}


