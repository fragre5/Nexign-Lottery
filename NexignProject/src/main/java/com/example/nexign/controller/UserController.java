package com.example.nexign.controller;

import com.example.nexign.model.User;
import com.example.nexign.model.Winner;
import com.example.nexign.repository.UserRepository;
import com.example.nexign.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/lottery/participant", produces = MediaType.APPLICATION_JSON_VALUE)
    public void setUsers(@RequestBody User user){
        userService.saveUser(user);
    }

    @DeleteMapping(value = "/lottery/participant")
    public void deleteUser(){
        userRepository.deleteAll();
    }


    @GetMapping("/lottery/participant")
    public List<User> findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return users;
    }

    @GetMapping(value = "/lottery/start")
    public ResponseEntity<String> startLottery(){
        long countOfUsers = userService.lotteryStart();
        if(countOfUsers < 2){
            System.out.println("ERROR");
            return new ResponseEntity<>("Error! There are not enough participants to start the lottery! Minimal count of players should be equals or higher than 2!" , HttpStatus.BAD_REQUEST);
            }
            int sum = userService.winningAmount();
            List<Long> listOfId = userService.listOfId();
            Long randomIdOfUser = listOfId.get((int) (Math.random() * listOfId.size()));
            User user = userService.findById(randomIdOfUser);
            userRepository.deleteAll();
            userRepository.saveWinner(user.getId(), user.getFirstName(), user.getAge(), user.getCity());
            return new ResponseEntity<>("Winner is: " + user.toString() + "\n" +
                                              "Winning amount is : " + sum + "\n" +
                                              "Congratulations!", HttpStatus.OK);

    }

    @GetMapping("/lottery/winners")
    public List<Winner> printAllWinners(Model model){
        List<Winner> winners = userService.findAllWinners();
        model.addAttribute("winners", winners);
        return winners;
    }

}
