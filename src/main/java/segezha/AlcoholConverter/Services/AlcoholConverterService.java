package segezha.AlcoholConverter.Services;

import org.springframework.stereotype.Service;

@Service
public class AlcoholConverterService {

    public Double alcoholConversion(Double firstStrength, Double firstVolume, Double secondStrenght) {
        return firstVolume * firstStrength / secondStrenght;
    }

}
