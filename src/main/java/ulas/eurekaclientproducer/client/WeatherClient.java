package ulas.eurekaclientproducer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ulas.eurekaclientproducer.client.model.WeatherInfo;

@FeignClient(value = "openweathermap", url = "http://api.openweathermap.org/data/2.5/")
public interface WeatherClient {

    @RequestMapping(method = RequestMethod.GET, value = "/weather?q={city}&appid=XXXXXXXXXXXXXXXXXXX", produces = "application/json")
    WeatherInfo getWeatherInfo(@RequestParam("city") String city);
}
