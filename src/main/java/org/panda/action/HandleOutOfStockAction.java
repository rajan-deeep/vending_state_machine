package org.panda.action;

import lombok.extern.slf4j.Slf4j;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.springframework.stereotype.Component;

@Component
@TransitionAction(sourceState = VendorState.DELIVERING_PRODUCT, targetState = VendorState.IDLE, event = VendorEvent.OUT_OF_STOCK)
@Slf4j
public class HandleOutOfStockAction implements TransitionActionHandler<VendorState, VendorEvent> {
    @Override
    public void execute() {
        log.info("Handling out of stock...");
    }
}
