package ulas.eurekaclientproducer.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    private List<Weather> weather;
    private String base;
    private int visibility;
    private Wind wind;
    private int dt;
    private int timezone;
    private int id;
    private String name;
    private int cod;
    private String message;
}
