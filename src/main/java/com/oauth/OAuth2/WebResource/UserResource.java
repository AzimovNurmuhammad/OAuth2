package com.oauth.OAuth2.WebResource;

import com.oauth.OAuth2.Domain.User;
import com.oauth.OAuth2.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    //    1- git
    @GetMapping("/hello")
    public String hello(){
        return "Hello OAuth2";
    }

//    2- git
//     @GetMapping("/user")
//    public ResponseEntity getUser(Principal principal){
//        return ResponseEntity.ok(principal);
//     }
     /*
1- git google bilan authorizatsiyadan utganimni  qaytarish uchun 2- git yozildi
2- git Authorizatsiyadagi barcha ma'lumotlarni chiqaradi
     */

//    3- git
    @GetMapping("/user")
    public ResponseEntity<User> getUser(Principal principal){
        if (principal instanceof AbstractAuthenticationToken){
            return ResponseEntity.ok(userService.getUserFromAuthontication((AbstractAuthenticationToken) principal));
        }else {
            throw new IllegalArgumentException("Error ");
        }
    }
/*
3- git google qaytargan ma'lumotlarni saralash uchun ishlatiladi
*/
}
