package segezha.AlcoholConverter.Services;

import org.springframework.stereotype.Service;

@Service
public class AlcoholConverterService {

    public Double alcoholConversion(Double firstStrength, Double firstVolume, Double secondStrenght) {
        return firstVolume * firstStrength / secondStrenght;
    }

    public Double alcoholAmount(Double strength, Double volume, String gender, Double weight) {
        double ethanol = strength * volume / 100;
        if (gender.equals("male")) return ethanol / (weight * 0.7);
        else if (gender.equals("female")) return ethanol / (weight * 0.6);
        else return -1.0;
    }

    public Double alcoholAmountForTwo(Double firstStrength, Double firstVolume, Double secondStrenght,
                                      Double secondVolume, String gender, Double weight) {
        double ethanol = firstStrength * firstVolume / 100 + secondStrenght * secondVolume / 100;
        if (gender.equals("male")) return ethanol / (weight * 0.7);
        else if (gender.equals("female")) return ethanol / (weight * 0.6);
        else return -1.0;
    }

    public Integer eliminationTime(Double strength, Double volume) {
        double ans = ((strength * volume / 100) * 0.15) * 60;
        return (int) ans;
    }

    public Integer withdrawalRussia(Double strength, Double volume) {
        double ans = ((strength * volume / 100) * 0.15) * 60 - 120;
        return (int) ans;
    }

}
