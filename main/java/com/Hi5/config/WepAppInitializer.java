package com.Hi5.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WepAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer
{

	public WepAppInitializer()
	{
		System.out.println(">>>>>>WebAppInitializer is loaded and instantiated..<<<<<<<");
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		System.out.println(">>>>>>>>In getRootConfigClasses method<<<<<<<<<<<<");
		return new Class[]{DBConfig.class};
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		System.out.println(">>>>>>>In getServletConfigClasses method<<<<<<<");
		return new Class[]{WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings()
	{
		System.out.println(">>>>>>>In getServletMappings method<<<<<<<<");
		return new String[]{"/"};
	}

}
