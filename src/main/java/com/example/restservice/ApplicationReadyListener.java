package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent>
{
    private static final Logger logger = LoggerFactory.getLogger(ApplicationReadyListener.class);

    @Value("${server.port}")
    private int port;

    @Value("${spring.main.log-startup-info}")
    private boolean startupInfo;

    @Autowired
    public ApplicationReadyListener()
    {
    }

    public void onApplicationEvent(final ApplicationReadyEvent event)
    {
        logger.info("Ready!");
        logger.info("value of spring.main.log-startup-info:".concat(String.valueOf(startupInfo)));
    }
}
