package com.example.nexign.service;

import com.example.nexign.model.User;
import com.example.nexign.model.Winner;
import com.example.nexign.repository.UserRepository;
import com.example.nexign.repository.WinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final WinnerRepository winnerRepository;
    private static int sumOfWin;

    @Autowired
    public UserService(UserRepository userRepository, WinnerRepository winnerRepository) {
        this.userRepository = userRepository;
        this.winnerRepository = winnerRepository;
    }

    public User findById(Long id){
        return userRepository.getReferenceById(id);
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }
    public List<Winner> findAllWinners() { return winnerRepository.findAll(); }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public long lotteryStart(){
        return userRepository.count();
    }

    public int winningAmount(){
        sumOfWin = (int) (Math.random() * 1000) + 1;
        return sumOfWin;
    }

    public List<Long> listOfId(){
        return userRepository.findAll_Id();

    }
}
