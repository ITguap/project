package com.example.probaex.Service;

import com.example.probaex.Model.User;
import com.example.probaex.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    //Находит всех пользователей в БД
    public List<User> findAll(){
        return userRepo.findAll();
    }

    // Сохраняет новые данные о пользователях
    public void save(User user){
    user.setName(user.getName());
    user.setSurname(user.getSurname());
    user.setLastname(user.getLastname());
    user.setPassword(user.getPassword());
    user.setNumber(user.getNumber());
    user.setCity(user.getCity());
    }

    //Удаление пользователя по id
    public void deleteUser(Long id){
        this.userRepo.deleteById(id);
    }

    //Нахождение пользователя по имени
    public List<User> findUserByName(String name) {
        return userRepo.findByNameContainingIgnoreCase(name);
    }
}
