package k25tiimi1backend.k25tiimi1backend.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import k25tiimi1backend.k25tiimi1backend.domain.Manufacturer;
import k25tiimi1backend.k25tiimi1backend.domain.ManufacturerRepository;


@RestController
//@RequestMapping("/api")
@CrossOrigin
public class ManufacturerRestController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    public Iterable<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

}
