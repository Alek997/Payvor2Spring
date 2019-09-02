package controller;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public Map<String, String> login(HttpServletRequest req) {
        Map<String, String> response = new HashMap();
        if(req.getUserPrincipal()!=null && !req.getUserPrincipal().getName().isBlank()){
            String username = req.getUserPrincipal().getName();
            response.put("success", "true");
            response.put("message", "all good");
            response.put("userame",username);
            response.put("type", "1");
            System.out.println("successful login");
            return response;
        }
        System.out.println("login failed");

        response.put("success", "false");
        response.put("message", "all good");
        response.put("type", "0");
        return response;

    }
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody Map<String,String> body){
        Map<String,Object> response = new HashMap();
        response.put("success",false);
        if(validate(body)){
            String username = body.get("username");
            String password = body.get("password");
            String email = body.get("email");
            String firstName = body.get("firstname");
            String lastName = body.get("lastname");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setName(firstName);
            user.setLastname(lastName);
            userService.save(user);
            response.put("success",true);
        }
        return response;
    }

    private boolean validate(Map<String,String> body){
        return !body.get("username").isBlank() && !body.get("password").isBlank()
                && !body.get("email").isBlank() && !body.get("firstname").isBlank()
                && !body.get("lastname").isBlank();
    }


    @GetMapping("loginfail")
    public Map<String,String> loginFail(){
        System.out.println("LOGIN FAIL");
        Map<String,String> response = new HashMap();
        response.put("success", "false");
        response.put("message", "all good");
        response.put("type", "0");
        return response;
    }


    @GetMapping("/logout")
    public void logout(HttpServletRequest req) {
        String username = req.getUserPrincipal().getName();
        System.out.println(username + " logged out");
    }

    @GetMapping("/user")
    public Map<String, Object> auth(HttpServletRequest req) {
        Collection<SimpleGrantedAuthority> authorities
                = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Map<String, Object> response = new HashMap();

        String username = "";

        if (req.getUserPrincipal() != null) {
            //not authorized
            username =req.getUserPrincipal().getName();
            System.out.println("AUTHOVAN");
        }else{
            System.out.println("NIJE AUTHOVAN");

        }

        response.put("message", "");
        response.put("success", false);
        response.put("type", 1);
        response.put("initLogin", false);
        response.put("username", "");

        if (!authorities.isEmpty() && !authorities.contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
            String role = authorities.toArray()[0].toString();
            User currUser = userService.findByUsername(username);
            response.put("message", role.toLowerCase());
            response.put("success", true);
            response.put("username", username);
            response.put("type", role.toLowerCase());

        }
        return response;
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = userService.getAll();
        return users;
    }

    @PostMapping("/save")
    public User register(@RequestBody User req) {
        userService.save(req);
        return req;
    }
}