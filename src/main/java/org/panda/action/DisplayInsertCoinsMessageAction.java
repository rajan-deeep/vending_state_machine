package org.panda.action;

import lombok.extern.slf4j.Slf4j;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.springframework.stereotype.Component;

@Component
@TransitionAction(sourceState = VendorState.SELECTING_PRODUCT, targetState = VendorState.INSERTING_COINS, event = VendorEvent.INSERT_COINS_1)
@Slf4j
public class DisplayInsertCoinsMessageAction implements TransitionActionHandler<VendorState, VendorEvent> {
    @Override
    public void execute() {
        log.info("Displaying insert coins message...");
    }
}

