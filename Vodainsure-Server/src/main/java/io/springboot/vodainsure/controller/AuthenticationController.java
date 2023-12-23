package io.springboot.vodainsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.vodainsure.dto.AuthRequest;
import io.springboot.vodainsure.service.JwtService;

// @RestController
// public class AuthenticationController {


// @Autowired
// private AuthenticationManager authenticationManager;

// @Autowired
// private UserDetailsService userDetailsService;

// @Autowired
// private JwebtService jwtService;

// // Handle the login requests and return a JWT token
// @PostMapping("/users/authenticate")
// public ResponseEntity<?> authenticate(@RequestBody User user) throws Exception {
// try {
// // Authenticate the user credentials
// authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
// );
// } catch (BadCredentialsException e) {
// throw new Exception("Incorrect username or password", e);
// }

// // Load the user details
// final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

// // Generate a JWT token
// final String jwt = jwtService.generateToken(userDetails);

// // Return the token in the response body
// return ResponseEntity.ok(new AuthenticationResponse(jwt));
// }
// }

@RestController
public class AuthenticationController {

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private JwtService jwtService;

// @Autowired
// private UserDetailsService userDetailsService;

// // Handle the login requests and return a success or failure message
// @PostMapping("/authenticate")
// public ResponseEntity<?> authenticate(@RequestBody User user) throws Exception {
// try {
// // Authenticate the user credentials
// authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
// );
// } catch (BadCredentialsException e) {
// throw new Exception("Incorrect username or password", e);
// }

// // Load the user details
// final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

// // Return a success message
// return ResponseEntity.ok("Authentication successful!");
// }
//    @PostMapping("/authenticate")
//     public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
//         try {
//             // Authenticate the user
//             Authentication authentication = authenticationManager.authenticate(
//                     new UsernamePasswordAuthenticationToken(
//                             authRequest.getUsername(),
//                             authRequest.getPassword()
//                     )
//             );

//             // Set the authentication object in the SecurityContext
//             SecurityContextHolder.getContext().setAuthentication(authentication);

//             // Optionally, you can get the authenticated user details if needed
//             // UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

//             return ResponseEntity.ok("Authentication successful");
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//         }
//     }
 @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return "jwtService.generateToken(authRequest.getUsername())";
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
        }
}
