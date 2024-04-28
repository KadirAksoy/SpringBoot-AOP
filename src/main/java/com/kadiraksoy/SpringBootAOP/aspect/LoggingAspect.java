package com.kadiraksoy.SpringBootAOP.aspect;

import com.kadiraksoy.SpringBootAOP.model.Person;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    // Tüm servislerdeki aspectExample() metodundan önce çalışır.
    @Before("execution(public void aspectExample())")
    public void beforeCreatePersonAdvice(){
        System.out.println("---> aspectExample() fonksiyonundan önce çalıştı.");
    }

    @Before("execution(public * createPerson(..)) && args(person)")
    public void logBeforeCreatePerson(Person person) {
        System.out.println("--->createPerson metodu çağrıldı. Person bilgisi: " + person);
        // İstediğiniz ekstra işlemleri buraya ekleyebilirsiniz.
    }
}
