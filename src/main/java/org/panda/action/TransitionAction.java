package org.panda.action;

import org.panda.enums.VendorEvent;
import org.panda.enums.VendorState;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransitionAction {
    VendorState sourceState();
    VendorState targetState();
    VendorEvent event();
}

