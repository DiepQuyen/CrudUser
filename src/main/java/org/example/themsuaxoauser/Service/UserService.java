package org.example.themsuaxoauser.Service;

import org.example.themsuaxoauser.Model.Post;
import org.example.themsuaxoauser.Model.User;
import org.example.themsuaxoauser.Repository.PostRepository;
import org.example.themsuaxoauser.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//file này sẽ có các hàm để xử lý dữ liệu
@Service
public class UserService {
    //sử dụng UserRepository để thao tác với dữ liệu
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    //tạo post cho user
    @Transactional//đảm bảo rằng tất cả các thao tác trong method này sẽ được thực thi hoặc rollback nếu có lỗi
    public Post createPostForUser(Long userId, Post post) {
        User user = getUserById(userId);
        post.setUser(user);
        return postRepository.save(post);
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
