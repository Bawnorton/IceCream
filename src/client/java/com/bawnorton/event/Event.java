package com.bawnorton.event;

import java.util.EventListener;

public abstract class Event<T extends EventListener> {
    public abstract void serve(T listener);
}
