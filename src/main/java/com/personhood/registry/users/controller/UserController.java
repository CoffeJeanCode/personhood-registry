package com.personhood.registry.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.personhood.registry.users.dto.UserDTO;
import com.personhood.registry.users.service.UserService;
import com.personhood.registry.utils.MessagesUtil;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "index";
	}
	
	@PostMapping("/registrar")
	public String saveUser(UserDTO userDTO, RedirectAttributes redirectAttributes) {
		int result = userService.saveUser(userDTO);

    if (result == 1) {
        redirectAttributes.addFlashAttribute("successMessage", MessagesUtil.MESSAGE_REGISTER);
    } else {
        redirectAttributes.addFlashAttribute("errorMessage", MessagesUtil.MESSAGE_NO_REGISTER);
    }
		return "redirect:/"; 
	}
	
	@GetMapping("/consultar")
	public String getAllUsuarios(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "consultar";
	}
}
