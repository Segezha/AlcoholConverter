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

    @GetMapping("/amount")
    public String amount(@RequestParam String strength, String volume, String gender, String weight) {
        String ans = String.format("%.3f", (alcoholConverterService.alcoholAmount(Double.parseDouble(strength),
                Double.parseDouble(volume), gender, Double.parseDouble(weight))));
        if (ans.equals("-1.0")) return "There are only two genders supported!";
        else return ans + "‰";
    }

    @GetMapping("/amountForTwo")
    public String amountForTwo(@RequestParam String firstStrength, String firstVolume, String secondStrength,
                               String secondVolume, String gender, String weight) {
        String ans = String.format("%.3f", (alcoholConverterService.alcoholAmountForTwo(Double.parseDouble(firstStrength),
                Double.parseDouble(firstVolume), Double.parseDouble(secondStrength), Double.parseDouble(secondVolume),
                gender, Double.parseDouble(weight))));
        if (ans.equals("-1.0")) return "There are only two genders supported!";
        else return ans + "‰";
    }

    @GetMapping("/elimination")
    public String elimination(@RequestParam String strength, String volume) {
        Integer ans = alcoholConverterService.eliminationTime(Double.parseDouble(strength),
                Double.parseDouble(volume));
        return ans / 60 + "h:" + ans % 60 + "m";
    }

    @GetMapping("/Russia")
    public String Russia(@RequestParam String strength, String volume) {
        Integer ans = alcoholConverterService.withdrawalRussia(Double.parseDouble(strength),
                Double.parseDouble(volume));
        return ans / 60 + "h:" + ans % 60 + "m";
    }

    @GetMapping("/Georgia")
    public String Georgia(@RequestParam String strength, String volume) {
        Integer ans = alcoholConverterService.withdrawalGeorgia(Double.parseDouble(strength),
                Double.parseDouble(volume));
        return ans / 60 + "h:" + ans % 60 + "m";
    }

}
