package kimdong.vn.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

@Configuration
public class WebConfig {

    public static class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
        @Override
        protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
            builder.addDecoratorPath("/*", "web.jsp")
                   .addDecoratorPath("/admin/*", "admin.jsp")
                   .addExcludedPath("/login*").addExcludedPath("/login/*")
                   .addExcludedPath("/alogin*").addExcludedPath("/alogin/*")
                   .addExcludedPath("/api/**");
        }
    }

    @Bean 
    public FilterRegistrationBean<CustomSiteMeshFilter> siteMeshFilter() {
        FilterRegistrationBean<CustomSiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomSiteMeshFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}