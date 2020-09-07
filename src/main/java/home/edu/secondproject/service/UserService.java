package home.edu.secondproject.service;

import home.edu.secondproject.model.User;
import home.edu.secondproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> allUsers(){
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }

    public User addNewUser(User user){
        User newUser = userRepo.save(user);
        return newUser;
    }

    public User getById(Long id){
        return userRepo.getOne(id);
    }

    public void deleteById(Long id){
        userRepo.deleteById(id);
    }
}
