package com.kadiraksoy.SpringBootAOP.aspect;

import com.kadiraksoy.SpringBootAOP.model.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    // * ile service, return type gibi yerlere tüm yapılar dahil olucak şekidle yazabiliriz.

    // @Order(number) number verilerek sıra belirlenebilir. Hangi sırayla çalışacağı belirlenir.

    // @AfterThrowing bir exception fırlatıldıktan sonra gerçekleşir


    // Tüm servislerdeki aspectExample() metodundan önce çalışır.
    @Before("execution(public void aspectExample())")
    public void beforeAspectExampleAdvice(){
        System.out.println("---> aspectExample() fonksiyonundan önce çalıştı.");
    }

    //  * kullanılarak service klasörünün içindeki tüm service'ler içindeki aspectExample metodu öncesi çağrılır.
    @Before("execution(public void com.kadiraksoy.SpringBootAOP.service.*.aspectExample())")
    public void beforeAllServiceAspectExampleAdvice(){
        System.out.println("---> Tüm Service'ler için aspectExample() fonksiyonundan önce çalıştı.");
    }

    // com.kadiraksoy.SpringBootAOP.service.PersonService.aspectExample() dan önce çalışır.
    @Before("execution(public void com.kadiraksoy.SpringBootAOP.service.PersonService.aspectExample())")
    public void beforePersonServiceAspectExampleAdvice(){
        System.out.println("---> PersonService'e özel aspectExample() fonksiyonundan önce çalıştı.");
    }

    // aspect ile başlayan tüm metodlardan önce çalışır
    @Before("execution(public void aspect*())")
    public void beforeAspectAspectExampleAdvice(){
        System.out.println("---> PersonService'e özel aspectExample() fonksiyonundan önce çalıştı.");
    }

    // * ile herhangi bir dönüş tipindeki veri türü geleceği varsayılır.
    @Before("execution(* boolAspectExample())")
    public void beforeBoolAspectExampleAdvice(){
        System.out.println("---> boolAspectExample() fonksiyonundan önce çalıştı.");
    }
    @After("execution(* boolAspectExample())")
    public void afterBoolAspectExampleAdvice(){
        System.out.println("---> @After advice boolAspectExample() fonksiyonundan sonra çalıştı.");
    }

    // parametre alıcaksak isek .. kullanabilir. ve args içine alacağı parametreyi yazmalıyız.
    @Before("execution(public * createPerson(..)) && args(person)")
    public void logBeforeCreatePerson(Person person) {
        System.out.println("--->createPerson metodu çağrıldı. Person bilgisi: " + person);
        // İstediğiniz ekstra işlemleri buraya ekleyebilirsiniz.
    }


    // metod başarıyla gerçekleştikten sonra çalışır.
    @AfterReturning(
            pointcut = "execution(* com.kadiraksoy.SpringBootAOP.service.PersonService.getAllPersons())",
            returning = "result"
    )
    public void afterReturningAdvice(JoinPoint joinPoint, List<Person> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("@AfterReturning çalıştı tüm kayıtlar bulundu. Çalışan metod:" + method);

        System.out.println("@AfterReturning çalıştı tüm kayıtlar bulundu. Kayıtlar:" + result);
    }




}
