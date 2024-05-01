package org.panda.listener;

import lombok.extern.slf4j.Slf4j;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
@Configuration
@Slf4j
public class StateMachineListener extends StateMachineListenerAdapter<VendorState, VendorEvent> {

    @Override
    public void stateChanged(State from, State to) {
        log.info("Transitioned from {} to {}", from == null ? "none" : from.getId(), to.getId());
    }
}