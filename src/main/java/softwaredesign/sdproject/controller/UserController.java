package softwaredesign.sdproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softwaredesign.sdproject.model.User;
import softwaredesign.sdproject.repository.UserRepository;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    static User user=new User();
    static public User modelUser(){
        return user;
    }
    @PostMapping("logIn")
    public String logIn(@ModelAttribute("email") String email, @ModelAttribute("password") String password){
        List<User> userList;
        userList=userRepository.findAll();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getEmail().equalsIgnoreCase(email)) {
                if(userList.get(i).getPassword().equalsIgnoreCase(password)) {
                    user = userList.get(i);
                }
            }
        }
        return "redirect:/index";
    }
    @GetMapping("/userComment/{userId}")
    public void userComment(@PathVariable("userId") int userId, Model model){
    model.addAttribute("email",userRepository.getOne(userId));
    }
    @GetMapping("logout")
    public String logOut(){
        User logOutUser=new User();
        user=logOutUser;
        return "redirect:/index";
    }
    @GetMapping("register")
    public String register(Model model)
    {
        model.addAttribute("user",user);
        return "registerUser";
    }
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute User user1){
        userRepository.save(user1);
        return "redirect:/index";
    }

    @PostMapping("addUser")
    public ResponseEntity<User> addUser(@ModelAttribute User user1){
        userRepository.save(user1);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }
    @GetMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") int userId){
        userRepository.delete(userRepository.getOne(userId));
        return "redirect:/viewProfile";
    }
    @GetMapping("seeSpecificUser")
    public ResponseEntity<User> seeSpecificUser(@RequestParam("id") int id){
        User user=userRepository.getOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute User user1){
        userRepository.updateUser(user1.getEmail(),user1.getPassword(),user1.getPermission(),user1.getUserId());
        user.setEmail(user1.getEmail());
        user.setPassword(user1.getPassword());
        return "redirect:/viewProfile";
    }
    //Get or Post???
    @PostMapping("allUsers")
    public ResponseEntity<List<User>> findAllUsers(Model model){
        List<User> userList=userRepository.findAll();
        //model.addAttribute("userList",userList);
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }







}
