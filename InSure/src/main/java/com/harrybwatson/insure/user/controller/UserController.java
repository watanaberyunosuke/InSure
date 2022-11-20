package com.harrybwatson.insure.user.controller;

import com.harrybwatson.insure.user.model.User;
import com.harrybwatson.insure.user.model.UserType;
import com.harrybwatson.insure.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // User Homepage
    @GetMapping(value = "")
    public ModelAndView getAllUsersPage() {
        ModelAndView allUsersMav = new ModelAndView("userHomepage");
        allUsersMav.addObject("users", userRepository.findAll());
        return allUsersMav;
    }

    // New User
    @GetMapping(value = "/new")
    public String getNewUserForm(Model model) {
        List<UserType> userTypeList = Arrays.asList(UserType.class.getEnumConstants());
        model.addAttribute("userTypesList", userTypeList);
        model.addAttribute("newUserItem", new User());
        return "newUser";
    }

    @PostMapping(value = "/addnew")
    public String newUserSubmission(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        userRepository.save(user);
        return "actionSuccessful";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(value="deleteUserId") Long id){
        userRepository.deleteById(id);
        return "actionSuccessful";
    }

}
