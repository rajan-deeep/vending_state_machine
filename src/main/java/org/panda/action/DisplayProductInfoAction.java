package org.panda.action;

import lombok.extern.slf4j.Slf4j;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.springframework.stereotype.Component;

@Component
@TransitionAction(sourceState = VendorState.IDLE, targetState = VendorState.SELECTING_PRODUCT, event = VendorEvent.SELECT_PRODUCT)
@Slf4j
public class DisplayProductInfoAction implements TransitionActionHandler<VendorState, VendorEvent> {
    @Override
    public void execute() {
        log.info("Displaying product information...");
    }
}

