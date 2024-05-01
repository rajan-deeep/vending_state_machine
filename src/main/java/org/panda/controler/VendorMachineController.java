package org.panda.controler;

import org.panda.enums.VendorEvent;
import org.panda.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.panda.enums.VendorEvent.INSERT_COINS_1;
import static org.panda.enums.VendorEvent.SELECT_PRODUCT;
import static org.panda.enums.VendorState.SELECTING_PRODUCT;

@RestController
public class VendorMachineController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/transition")
    public void transitionState() {
        vendorService.performTransition(SELECT_PRODUCT);
    }
}


