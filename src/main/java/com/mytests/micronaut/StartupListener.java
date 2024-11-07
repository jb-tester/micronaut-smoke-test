package com.mytests.micronaut;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class StartupListener {

    @Inject
    private DBService DBService;

    @EventListener
    public void onStartup(StartupEvent event) {
        DBService.populateDB();
    }
}