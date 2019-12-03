package com.brandolkuete.springmvc.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@EnableAutoConfiguration
public class Config implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    // Pour que notre application puisse déterminer les paramètres régionaux actuellement utilisés, ici en se basant sur la session
    @Bean
    public CookieLocaleResolver localeResolver() {
       CookieLocaleResolver localeResolver= new CookieLocaleResolver();
       localeResolver.setCookieName("lang");
       localeResolver.setDefaultLocale(new Locale("fr"));
        return localeResolver;
    }

    // intercepteur qui basculera vers un nouvel environnement local basé sur la valeur du paramètre lang ajouté à une demande
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Bean
     public MessageSource messageSource() {
         ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
         messageSource.setBasename("i18n/messages");
         return messageSource;
     }

}
