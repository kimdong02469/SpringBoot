package kimdong.vn.configuration;

import org.springframework.boot.tomcat.servlet.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatJSPConfiguration {

	@Bean
	public TomcatServletWebServerFactory servletWebServerFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addContextCustomizers(
				context -> context.addLifecycleListener(new JSPStaticResourceConfigurer(context)));
		return factory;
	}
}