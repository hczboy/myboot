package com.myboot.config;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VelocityConfig {

	@Bean(initMethod="init")
	public VelocityEngine velocityEngine(){
		VelocityEngine ve = new VelocityEngine();
        ve.setProperty(Velocity.RESOURCE_LOADER, "class");
        ve.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        /*ve.setProperty("class.runtime.log", "velocity.log");
        ve.setProperty("class.runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
        ve.setProperty("class.runtime.log.logsystem.log4j.category", "velocity");*/
        ve.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM, new LoggerExample());
       // ve.setProperty("class.resource.loader.path", "classpath:/templates");
        return ve;
	}
}
