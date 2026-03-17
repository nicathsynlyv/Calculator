package Controller;

import Service.CalculatorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {
    private final CalculatorService service;


    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("result", null);
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double a,
                            @RequestParam double b,
                            @RequestParam String op,
                            Model model) {
        try {
            double result = service.calculate(a, b, op);
            // Tam ədəddirsə onluq göstərmə
            if (result == Math.floor(result)) {
                model.addAttribute("result", (long) result);
            } else {
                model.addAttribute("result", result);
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("op", op);
        return "index";
    }
}