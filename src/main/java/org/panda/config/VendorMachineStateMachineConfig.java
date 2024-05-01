package org.panda.config;

import org.panda.action.TransitionAction;
import org.panda.action.TransitionActionHandler;
import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;
import org.panda.listener.StateMachineListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;
import java.util.Map;

@Configuration
@EnableStateMachine
public class VendorMachineStateMachineConfig extends EnumStateMachineConfigurerAdapter<VendorState, VendorEvent> {

    private final ApplicationContext applicationContext;

    @Autowired
    public VendorMachineStateMachineConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Autowired
    private StateMachineListener stateMachineListener;

    @Override
    public void configure(StateMachineConfigurationConfigurer<VendorState, VendorEvent> config) throws Exception {
        config.withConfiguration()
                .listener(stateMachineListener);
    }

    @Override
    public void configure(StateMachineStateConfigurer<VendorState, VendorEvent> states) throws Exception {
        states
                .withStates()
                .initial(VendorState.IDLE)
                .states(EnumSet.allOf(VendorState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<VendorState, VendorEvent> transitions) throws Exception {
        for (VendorEvent event : VendorEvent.values()) {
            transitions
                    .withExternal()
                    .source(event.getSource()).target(event.getTarget()).event(event)
                    .action(transitionActions(event.getSource(), event.getTarget(), event));
        }
    }

    private Action<VendorState, VendorEvent> transitionActions(VendorState sourceState, VendorState targetState, VendorEvent event) {
        return context -> {
            Map<String, TransitionActionHandler> transitionActions = applicationContext.getBeansOfType(TransitionActionHandler.class);
            transitionActions.values().stream()
                    .filter(action -> {
                        TransitionAction annotation = action.getClass().getAnnotation(TransitionAction.class);
                        return annotation != null && annotation.sourceState() == sourceState && annotation.targetState() == targetState && annotation.event() == event;
                    })
                    .forEach(TransitionActionHandler::execute);
        };
    }
}
