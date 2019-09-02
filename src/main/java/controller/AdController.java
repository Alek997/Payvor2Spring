package controller;

import model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AdService;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:4200/**"}, maxAge = 3000)
@RestController
@RequestMapping("/rest/ad")
public class AdController {

    @Autowired
    private AdService adService;


    @GetMapping("/getAll")
    public List<Ad> getAll() {
        List<Ad> ads = adService.getAll();
        return ads;
    }

}
