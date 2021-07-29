
package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class ServiceInterceptorConfig extends WebMvcConfigurationSupport {

	@Autowired
	ServiceInterceptor serviceInterceptor;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// super.addInterceptors(registry);
		registry.addInterceptor(serviceInterceptor);
	}

}
