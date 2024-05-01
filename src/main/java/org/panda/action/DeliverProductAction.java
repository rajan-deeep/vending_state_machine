package org.panda.action;

import lombok.extern.slf4j.Slf4j;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.springframework.stereotype.Component;

@Component
@TransitionAction(sourceState = VendorState.PROCESSING_ORDER, targetState = VendorState.DELIVERING_PRODUCT, event = VendorEvent.DELIVER_PRODUCT)
@Slf4j
public class DeliverProductAction implements TransitionActionHandler<VendorState, VendorEvent> {
    @Override
    public void execute() {
        log.info("Delivering product...");
    }
}
