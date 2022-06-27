package com.danhuy.config.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteMeshConfig extends ConfigurableSiteMeshFilter {

	@Bean 
	public FilterRegistrationBean<SiteMeshConfig> siteMeshFilter() {
		FilterRegistrationBean<SiteMeshConfig> filter = new FilterRegistrationBean<SiteMeshConfig>(); 
		filter.setFilter(new SiteMeshConfig()); 
		return filter; 
	}
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder 
		// Map decorators to path patterns.		
		.addDecoratorPath("/*", "/decorators/web.jsp")
		.addDecoratorPath("/admin*", "/decorators/admin.jsp")
		// Exclude path from decoration.
		.addExcludedPath("/login")
		.addExcludedPath("**/download/*")
		.addExcludedPath("**/ajax/*")
		.addExcludedPath("**/api/*")
		.setMimeTypes("text/html");		
	}
}