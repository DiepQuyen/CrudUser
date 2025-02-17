package org.example.themsuaxoauser.Service;

import org.example.themsuaxoauser.Model.User;
import org.example.themsuaxoauser.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//file này sẽ có các hàm để xử lý dữ liệu
@Service
public class UserService {
    //sử dụng UserRepository để thao tác với dữ liệu
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //lấy all dữ liệu
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //lưu dữ liệu
    public void saveUser(User user) {
        userRepository.save(user);
    }

    //xóa dữ liệu
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //lấy dữ liệu theo id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
