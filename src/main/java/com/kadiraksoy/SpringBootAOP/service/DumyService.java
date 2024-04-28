package com.kadiraksoy.SpringBootAOP.service;


import com.kadiraksoy.SpringBootAOP.repository.DumyRepository;
import org.springframework.stereotype.Component;

@Component
public class DumyService implements DumyRepository {
    @Override
    public void aspectExample() {
        System.out.println("Sade haliyle DumyService aspect için fonksiyon örneğidir");
    }
}
