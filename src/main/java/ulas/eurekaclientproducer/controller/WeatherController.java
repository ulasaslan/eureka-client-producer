package ulas.eurekaclientproducer.controller;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ulas.eurekaclientproducer.client.WeatherClient;
import ulas.eurekaclientproducer.client.model.WeatherInfo;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WeatherController {

    final WeatherClient client;

    @GetMapping("/weather/{city}")
    public ResponseEntity<Object> getWeatherInfo(@PathVariable String city){
        try {
            WeatherInfo info = client.getWeatherInfo(city);

            if (info != null) {
                return ResponseEntity.ok(info);
            }
        }catch (FeignException ex) {
            WeatherInfo info = new WeatherInfo();
            info.setCod(ex.status());
            info.setMessage(ex.status() == 404 ? "Şehir bulunamadı" : "Bilinmeyen hata");
            return ResponseEntity.status(ex.status()).body(info);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
