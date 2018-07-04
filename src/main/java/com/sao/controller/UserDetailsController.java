package com.sao.controller;

import com.sao.domain.UserDetails;
import com.sao.domain.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detail")
public class UserDetailsController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetailsController(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @GetMapping("/set")
    public @ResponseBody String setNewUserDetails(@RequestParam Long uid,
                                                  @RequestParam String city,
                                                  @RequestParam String university,
                                                  @RequestParam String major,
                                                  @RequestParam String hobby) {
         if (userDetailsRepository.existsById(uid)) {
             UserDetails userDetails = userDetailsRepository.findById(uid).get();
             userDetails.setCity(city);
             userDetails.setUniversity(university);
             userDetails.setMajor(major);
             userDetails.setHobby(hobby);
             userDetailsRepository.save(userDetails);
             return "set ok!";
         } else {
            return "Error: uid not found";
         }
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<UserDetails> findAll() {
        return userDetailsRepository.findAll();
    }
}
