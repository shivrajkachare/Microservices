package com.UserService.UserService;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;
//Once Again Change 
//Check it present on GITHUB
//Added in GITHUB
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;


    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    //Add user
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User newuser = userService.addUser(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> getAllUsers(){
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    //get User
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        if(id < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //Delete user
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        if(id < 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String msg = userService.deleteUser(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


    @GetMapping("/logs")
    public String getLogs(){
        log.info("Logs are Working");
        log.error("Logs ERROR ..!!");
        log.warn("Logs WARNING ..!!");
        return "Logs Found...!!";
    }
    //All user --> ADMIN (Optional)

    @GetMapping("/headers")
    public String checkHeaders(HttpServletRequest request) {

        Enumeration<String> headers = request.getHeaderNames();

        while(headers.hasMoreElements()) {
            String h = headers.nextElement();
            System.out.println(h + " = " + request.getHeader(h));
        }

        return "ok";
    }

}
