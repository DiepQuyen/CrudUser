package org.example.themsuaxoauser.Controller;

import org.example.themsuaxoauser.Model.Post;
import org.example.themsuaxoauser.Model.User;
import org.example.themsuaxoauser.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    //sử dụng service để gọi các thao tác xử lý với dữ liệu
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        //lấy all dữ liệu và truyền vào model
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        //trả về view
        return "users";
    }

    @PostMapping("/add")
    //thêm mới user
    //ModelAttribute là cách truyền dữ liệu từ form html vào controller
    public String addUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        //sau khi thêm mới thì chuyển hướng về trang danh sách
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{userId}/posts")
    public String listPosts(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("newPost", new Post());
        return "posts";
    }

    @PostMapping("/{userId}/posts/add")
    public String addPost(@PathVariable Long userId, @ModelAttribute("newPost") Post post) {
        userService.createPostForUser(userId, post);
        return "redirect:/users/" + userId + "/posts";
    }
}