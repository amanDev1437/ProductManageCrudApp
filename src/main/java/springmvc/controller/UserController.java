package springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import springmvc.dao.UserDao;
import springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping("/")
    public String index(){
        System.out.println("index controller");
        return "login";
    }


    @RequestMapping(path = "/reg")
    public String handleReg(){
        return "register";
    }

    @RequestMapping(path = "/register")
    public String handleRegister(@ModelAttribute User user, Model model){
        if(userDao.getUser(user.getEmail())==null){
            userDao.saveUser(user);
            return "success";
        }
        model.addAttribute("message","Email already exist");
        return "register";

    }


    @RequestMapping(path = "/login")
    public String handleLogin(@ModelAttribute User user, Model model, HttpSession session){

        String password = user.getPassword();
        String email = user.getEmail();

        if(userDao.getUser(email)!=null && Objects.equals(userDao.getUser(email).getPassword(), password)){

            session.setAttribute("id",userDao.getUser(email).getId());
            return "redirect:/home";

        }
        model.addAttribute("message","Incorrect email or password");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session) {
        model.addAttribute("message","Logout successfully");
        session.invalidate();
        return "redirect:/";
    }


}
