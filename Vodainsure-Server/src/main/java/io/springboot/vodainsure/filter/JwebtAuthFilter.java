// package io.springboot.viserver.filter;


// // JWT filter class
// import io.jsonwebtoken.ExpiredJwtException;
// import io.springboot.viserver.config.CustomUserDetailsService;
// import io.springboot.viserver.service.JwebtService;
// // import io.springboot.viserver.service.JwebtService;
// import io.springboot.viserver.service.JwtService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;

// @Component
// public class JwebtAuthFilter extends OncePerRequestFilter {

// @Autowired
// private CustomUserDetailsService customuserDetailsService;

// @Autowired
// private JwebtService jwtService;

// @Override
// protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
// // Get the authorization header from the request
// final String authHeader = request.getHeader("Authorization");

// String username = null;
// String jwt = null;

// // Extract the token from the header
// if (authHeader != null && authHeader.startsWith("Bearer ")) {
// jwt = authHeader.substring(7);
// try {
// // Extract the username from the token
// username = jwtService.extractUsername(jwt);
// } catch (IllegalArgumentException e) {
// System.out.println("Unable to get JWT Token");
// } catch (ExpiredJwtException e) {
// System.out.println("JWT Token has expired");
// }
// } else {
// logger.warn("JWT Token does not begin with Bearer String");
// }

// // Validate the token and set the authentication context
// if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
// UserDetails userDetails = this.customuserDetailsService.loadUserByUsername(username);
// if (jwtService.validateToken(jwt, userDetails)) {
// UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
// userDetails, null, userDetails.getAuthorities());
// authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
// SecurityContextHolder.getContext().setAuthentication(authToken);
// }
// }
// filterChain.doFilter(request, response);
// }
// }