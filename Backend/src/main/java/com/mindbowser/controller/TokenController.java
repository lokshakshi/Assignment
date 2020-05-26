//package com.mindbowser.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.mindbowser.securityJWT.AuthenticationRequest;
//import com.mindbowser.securityJWT.AuthenticationResponse;
//import com.mindbowser.securityJWT.MyUserDetailsService;
//import com.mindbowser.securityJWT.jwtUtil;
//
//@Controller
//@RequestMapping(path ="Token")
//@CrossOrigin(origins = "*")
//public class TokenController {
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private MyUserDetailsService userDetailsService;
//	
//	@Autowired
//	private jwtUtil jwtToken;
//	
//	@PostMapping(value = "/authenticate")
//	@ResponseBody
//	public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception{
//		try {
//		authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())));
//		}
//		catch(BadCredentialsException e)
//		{
//			throw new Exception("Incorrect username and passowrd",e);
//		}
//		
//		final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		final String jwt=jwtToken.generateToken(userDetails);
//		return ResponseEntity.ok(new AuthenticationResponse (jwt));
//		
//	}
//}