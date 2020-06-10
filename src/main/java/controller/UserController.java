package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import validate.UserValidate;

@Controller
public class UserController {

    @GetMapping("/user")
    public ModelAndView showAddForm(){
        ModelAndView modelAndView = new ModelAndView("addForm");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("add")
    public ModelAndView add(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("addForm");
        }
        return new ModelAndView("result","message","ok");
    }

}
