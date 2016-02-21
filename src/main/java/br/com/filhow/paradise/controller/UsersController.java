package br.com.filhow.paradise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.filhow.paradise.service.UserService;

@Controller
public class UsersController {

	@Autowired private UserService userService;

    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        return new ModelAndView("users", "users", userService.getAllUsers());
    }

//    @InitBinder("form")
//    public void initBinder(WebDataBinder binder) {
//        binder.addValidators(userCreateFormValidator);
//    }
//
//    @RequestMapping("/user/{id}")
//    public ModelAndView getUserPage(@PathVariable Long id) {
//        return new ModelAndView("user", "user", userService.getUserById(id)
//                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
//    }
//
//    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
//    public ModelAndView getUserCreatePage() {
//        return new ModelAndView("user_create", "form", new UserCreateForm());
//    }
//
//    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
//    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "user_create";
//        }
//        try {
//            userService.create(form);
//        } catch (DataIntegrityViolationException e) {
//            bindingResult.reject("email.exists", "Email already exists");
//            return "user_create";
//        }
//        return "redirect:/users";
//    }
}
