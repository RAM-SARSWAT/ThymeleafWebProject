package com.webProject.ThymeleafWebProject.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.webProject")
public class ThymeleafConfig implements WebMvcConfigurer {

    @Bean(name = "templateResolver")
    public FileTemplateResolver getTemplateResolver() {
        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix("D:\\project\\ThymeleafWebProject\\src\\main\\resources\\templates\\");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setCacheable(true);
        return templateResolver;
    }


//           @Bean(name = "templateResolver")
//           public ITemplateResolver getTemplateResolver() {
//                         SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//                         templateResolver.setApplicationContext(applicationContext);
//
//                         templateResolver.setPrefix("/WEB-INF/templates/");
//                         templateResolver.setSuffix(".html");
//                         templateResolver.setCacheable(false);
//
//                         templateResolver.setTemplateMode(TemplateMode.HTML);
//                         return templateResolver;
//           }

    @Bean(name = "templateEngine")
    public ISpringTemplateEngine getTemplateEngine(){
        // SpringTemplateEngine automatically applies SpringStandardDialect and
        // enables Spring's own MessageSource message resolution mechanisms.
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(getTemplateResolver());
        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
        // speed up execution in most scenarios, but might be incompatible
        // with specific cases when expressions in one template are reused
        // across different data types, so this flag is "false" by default
        // for safer backwards compatibility.
        //           templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean(name = "viewResolver")
    public ViewResolver getViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(getTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
}


