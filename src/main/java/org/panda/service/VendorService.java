package org.panda.service;

import lombok.extern.slf4j.Slf4j;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VendorService {

    private final StateMachine<VendorState, VendorEvent> stateMachine;
    @Autowired
    public VendorService(StateMachine<VendorState, VendorEvent> stateMachine) {
        this.stateMachine = stateMachine;
        stateMachine.start();
    }

    public void performTransition(VendorEvent event) {
        // Send the event to trigger the transition
        stateMachine.sendEvent(event);
        // Optionally, you can handle the transition outcome here
        stateMachine.getExtendedState().getVariables().forEach((key, value) -> {
            log.info("Extended state variable: " + key + " = " + value);
        });
    }
}

