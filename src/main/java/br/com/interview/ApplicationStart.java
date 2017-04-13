package br.com.interview;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import br.com.interview.config.RestConfig;

public class ApplicationStart implements WebApplicationInitializer { 

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("Inicializando aplicacao");
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		
		ctx.register(RestConfig.class);
		ctx.setServletContext(servletContext);
		
		DispatcherServlet dispatcher = new DispatcherServlet(ctx);
		Dynamic servlet = servletContext.addServlet("dispatcher", dispatcher);
		servlet.addMapping("/*");
		servlet.setLoadOnStartup(1);
	}
}
