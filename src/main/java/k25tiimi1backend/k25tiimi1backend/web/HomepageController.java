package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {
    @RequestMapping("/homepage")
    public String home() {
        return "homepage";
    }
}
