//package com.Project.Leaning.LearningRESTAPIs.auth;
//
//import com.Project.Leaning.LearningRESTAPIs.entity.Student;
//import com.Project.Leaning.LearningRESTAPIs.service.StudentService;
//import io.jsonwebtoken.io.IOException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class JWTFilter extends OncePerRequestFilter {
//
//    private final JwtService jwtService;
//    private final StudentService userDetailsService;
//
//    @SneakyThrows
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain)
//            throws ServletException, IOException {
//
//        log.info("JwtFilter running...");
//
//        String authHeader = request.getHeader("Authorization");
//
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = authHeader.substring(7);
//
//        String email = jwtService.extractEmail(token);
//
//        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//            Student userDetails = userDetailsService.loadUserByUsername(email);
//
//            if (jwtService.isTokenValid(token, String.valueOf(userDetails))) {
//
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(
//                                userDetails,
//                                null,
//                                userDetails.getAuthorities()
//                        );
//
//                authToken.setDetails(
//                        new WebAuthenticationDetailsSource().buildDetails(request)
//                );
//
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//
//                log.info("User authenticated: {}", email);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
//}
