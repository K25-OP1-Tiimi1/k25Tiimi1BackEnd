// Controller for resetting demo data

package k25tiimi1backend.k25tiimi1backend.web;

import k25tiimi1backend.k25tiimi1backend.service.DemoDataResetService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoDataController {

    private final DemoDataResetService demoDataResetService;

    public DemoDataController(DemoDataResetService demoDataResetService) {
        this.demoDataResetService = demoDataResetService;
    }

    @PostMapping("/reset-demo-data")
    public String resetDemoData() {
        demoDataResetService.resetDemoData();
        return "redirect:/homepage";
    }
}
