package com.dacdoliveira.wsdlserver.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.dacdoliveira.wsdlserver.assets.GetCountryRequest;
import com.dacdoliveira.wsdlserver.assets.GetCountryResponse;
import com.dacdoliveira.wsdlserver.repository.CountryRepository;

@Endpoint
public class CountryEndpoints
{
    private static final String NAMESPACE_URI = "http://dacdoliveira.com/wsdlserver/assets";

    private final CountryRepository countryRepository;

    public CountryEndpoints(CountryRepository countryRepository)
    {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request)
    {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountryByName(request.getName()));
        return response;
    }

}
