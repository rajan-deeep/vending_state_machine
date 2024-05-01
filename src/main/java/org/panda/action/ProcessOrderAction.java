package org.panda.action;

import lombok.extern.slf4j.Slf4j;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.springframework.stereotype.Component;

@Component
@TransitionAction(sourceState = VendorState.INSERTING_COINS, targetState = VendorState.PROCESSING_ORDER, event = VendorEvent.PROCESS_ORDER)
@Slf4j
public class ProcessOrderAction implements TransitionActionHandler<VendorState, VendorEvent> {
    @Override
    public void execute() {
        log.info("Processing order...");
    }
}

