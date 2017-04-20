package com.myboot.metrics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class ApplicationContextMetrics implements PublicMetrics {

	private ApplicationContext appctx;
	
	@Autowired
	public ApplicationContextMetrics(ApplicationContext appctx) {
		super();
		this.appctx = appctx;
	}


	@Override
	public Collection<Metric<?>> metrics() {
		List<Metric<?>> metrics = new ArrayList<Metric<?>>();
		metrics.add(new Metric<Long>("spring.context.startup-date", appctx.getStartupDate()));
		metrics.add(new Metric<Integer>("spring.beans.definitions", appctx.getBeanDefinitionCount()));
		metrics.add(new Metric<Integer>("spring.beans", appctx.getBeanNamesForType(Object.class).length));
		metrics.add(new Metric<Integer>("spring.controllers", appctx.getBeanNamesForAnnotation(Controller.class).length));
		
		
		return metrics;
	}

}
