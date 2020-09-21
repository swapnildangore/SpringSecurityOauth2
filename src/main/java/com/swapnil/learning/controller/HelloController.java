/**
 * 
 */
package com.swapnil.learning.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dangoswa
 *
 */
@RestController
public class HelloController {

	@GetMapping("/")
	public String welcomeUser(@AuthenticationPrincipal OAuth2AuthenticatedPrincipal user) {
		return "Welcome Mr." + user.getName();
	}
}
