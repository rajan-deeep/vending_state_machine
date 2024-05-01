package org.panda.enums;

public enum VendorEvent {
    SELECT_PRODUCT(VendorState.IDLE, VendorState.SELECTING_PRODUCT),
    INSERT_COINS_1(VendorState.SELECTING_PRODUCT, VendorState.INSERTING_COINS),
    PROCESS_ORDER(VendorState.INSERTING_COINS, VendorState.PROCESSING_ORDER),
    DELIVER_PRODUCT(VendorState.PROCESSING_ORDER, VendorState.DELIVERING_PRODUCT),
    OUT_OF_STOCK(VendorState.DELIVERING_PRODUCT, VendorState.IDLE);

    private final VendorState source;
    private final VendorState target;

    VendorEvent(VendorState source, VendorState target) {
        this.source = source;
        this.target = target;
    }

    public VendorState getSource() {
        return source;
    }

    public VendorState getTarget() {
        return target;
    }
}

