package softwaredesign.sdproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import softwaredesign.sdproject.model.User;
import softwaredesign.sdproject.repository.UserRepository;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    User user;
    @PostMapping("logIn")
    public ResponseEntity<User> logIn(@ModelAttribute("email") String email, @ModelAttribute("password") String password){
        List<User> userList;
        userList=userRepository.findAll();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getEmail().equalsIgnoreCase(email)) {
                if(userList.get(i).getPassword().equalsIgnoreCase(password)) {
                    user = userList.get(i);
                }
            }
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("logout")
    public ResponseEntity<User> logOut(){
        user=null;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("addUser")
    public ResponseEntity<User> addUser(@ModelAttribute User user1){
        userRepository.save(user1);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }
    @PostMapping("deleteUser")
    public ResponseEntity<User> deleteUser(@RequestParam int id){
        userRepository.delete(userRepository.getOne(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("seeSpecificUser")
    public ResponseEntity<User> seeSpecificUser(@RequestParam("id") int id){
        User user=userRepository.getOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("updateUser")
    public ResponseEntity<User> updateUser(@ModelAttribute User user){
        userRepository.updateUser(user.getEmail(),user.getPassword(),user.getPermission(),user.getUserId());
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    //Get or Post???
    @PostMapping("allUsers")
    public ResponseEntity<List<User>> findAllUsers(Model model){
        List<User> userList=userRepository.findAll();
        //model.addAttribute("userList",userList);
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }






}
