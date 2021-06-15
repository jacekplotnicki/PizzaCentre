package pl.jacekplotnicki.PizzaCentre.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class Config {
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode =
            ScopedProxyMode.TARGET_CLASS)
    public Basket getBasket(){
        return new Basket();
    }

}
