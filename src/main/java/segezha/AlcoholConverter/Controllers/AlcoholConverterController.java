package segezha.AlcoholConverter.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import segezha.AlcoholConverter.Services.AlcoholConverterService;

@RestController
public class AlcoholConverterController {

    public final AlcoholConverterService alcoholConverterService;

    public AlcoholConverterController(AlcoholConverterService alcoholConverterService) {
        this.alcoholConverterService = alcoholConverterService;
    }

    @GetMapping("/convert")
    public String convert(@RequestParam String firstStrength, String firstVolume, String secondStrenght) {
        return Double.toString(alcoholConverterService.alcoholConversion(Double.parseDouble(firstStrength),
                Double.parseDouble(firstVolume), Double.parseDouble(secondStrenght)));
    }

}
