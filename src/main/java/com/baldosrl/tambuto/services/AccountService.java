package com.baldosrl.tambuto.services;

import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.repositories.UserRepo;
import com.baldosrl.tambuto.supports.exceptions.EmailGiaPresenteException;
import com.baldosrl.tambuto.supports.exceptions.UtenteNonTrovatoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public void aggiungiuser(User u){
    if (userRepo.existsByEmail(u.getEmail())){
        throw new EmailGiaPresenteException();
    }
    userRepo.save(u);
    }

    public User trovauser(int id){
        Optional<User> opt = userRepo.getUserById(id);
        if (opt.isPresent())
            return opt.get();
    throw new UtenteNonTrovatoException();
    }

}
