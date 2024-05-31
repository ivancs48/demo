package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String adminAccess() {
		return "Admin Content";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user")
	public String userAccess() {
		return "User Content";
	}

	@PreAuthorize("hasRole('ROLE_GUEST')")
	@GetMapping("/guest")
	public String guestAccess() {
		return "Guest Content";
	}
}