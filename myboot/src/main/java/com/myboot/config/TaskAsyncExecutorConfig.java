package com.myboot.config;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class TaskAsyncExecutorConfig implements AsyncConfigurer {

	private static final Logger log = LoggerFactory.getLogger(TaskAsyncExecutorConfig.class);
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(5);
		pool.setMaxPoolSize(10);
		pool.setQueueCapacity(30);
		pool.setThreadNamePrefix("mypool-");
		pool.initialize();
		return pool;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return new AsyncUncaughtExceptionHandler() {
			
			@Override
			public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
				
				log.error(arg1.getName() + " have ex", arg0);
			}
		};
	}

}
