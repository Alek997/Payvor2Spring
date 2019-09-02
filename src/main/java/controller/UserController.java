package controller;


import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import model.Ad;
import model.User;
import model.UserAddAdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AdService;
import service.UserService;

@CrossOrigin(origins = {"http://localhost:4200/**"}, maxAge = 3000)
@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdService adService;


    @GetMapping("/profile")
    public User getCreatorProfile(HttpServletRequest req) {
        String username = req.getUserPrincipal().getName();
        System.out.println(username);
        User temp = userService.findByUsername(username);
        return temp;
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @PostMapping
    public User addAdToUser(@RequestBody UserAddAdRequest request) {
        Long userId = request.getUserId().longValue();
        Ad newAd = request.getAd();

        adService.save(newAd);

        User user = userService.findById(userId);
        user.getAds().add(newAd);

        return userService.save(user);
    }


}
