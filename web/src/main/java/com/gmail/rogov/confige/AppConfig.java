package com.gmail.rogov.confige;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan(basePackages = { "com.gmail.rogov.dao",
                                "com.gmail.rogov.service",
                                "com.gmail.rogov.config",
                                "com.gmail.rogov.controller"
})
public class AppConfig {
}
