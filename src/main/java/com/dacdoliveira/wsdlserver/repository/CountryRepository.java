package com.dacdoliveira.wsdlserver.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.dacdoliveira.wsdlserver.assets.Country;
import com.dacdoliveira.wsdlserver.assets.Currency;

@Component
public class CountryRepository
{
    private static final Map<String, Country> COUNTRIES = new HashMap<>();

    @PostConstruct
    public void init()
    {
        Country brasil = new Country();
        brasil.setCapital("Brasilia");
        brasil.setCurrency(Currency.BRL);
        brasil.setName("Brasil");
        brasil.setPopulation(209300000);

        Country espanha = new Country();
        espanha.setCapital("Madrid");
        espanha.setCurrency(Currency.EUR);
        espanha.setName("Espanha");
        espanha.setPopulation(46940000);

        Country inglaterra = new Country();
        inglaterra.setCapital("Londres");
        inglaterra.setCurrency(Currency.GBP);
        inglaterra.setName("Inlaterra");
        inglaterra.setPopulation(55900000);
        
        COUNTRIES.put(brasil.getName(), brasil);
        COUNTRIES.put(espanha.getName(), espanha);
        COUNTRIES.put(inglaterra.getName(), inglaterra);
    }
    
    public Country findCountryByName(String name)
    {
        Assert.notNull(name, "The name should be not null");
        return COUNTRIES.get(name);
    }

}
