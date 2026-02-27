package com.vehiclerental.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserProfileController - Customers manage their account profile
 * Routes: /user/profile/...
 */
@Controller
@RequestMapping("/user/profile")
public class UserProfileController {

    @GetMapping
    public String viewProfile() {
        return "user/profile/view"; // → templates/user/profile/view.html
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "user/profile/edit"; // → templates/user/profile/edit.html
    }

    @PostMapping("/edit")
    public String updateProfile() {
        // TODO: Implement profile update
        return "redirect:/user/profile";
    }

    @GetMapping("/settings")
    public String viewSettings() {
        return "user/profile/settings"; // → templates/user/profile/settings.html
    }

    @PostMapping("/settings")
    public String updateSettings() {
        // TODO: Implement settings update
        return "redirect:/user/profile/settings";
    }
}
