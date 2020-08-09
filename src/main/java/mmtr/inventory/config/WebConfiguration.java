package mmtr.inventory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!registry.hasMappingForPattern("/swagger-ui/**")) {
      registry
          .addResourceHandler("/swagger-ui/**")
          .addResourceLocations("classpath:/static/swagger-ui/");
    }
  }
}
