package com.deqode.BankingApplication.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deqode.BankingApplication.config.JwtTokenUtil;
import com.deqode.BankingApplication.dto.UserDto;
import com.deqode.BankingApplication.model.User;
import com.deqode.BankingApplication.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public UserDto createUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		User savedUser = userRepository.save(user);
		UserDto createdUser = new UserDto();
		BeanUtils.copyProperties(savedUser, createdUser);
		return createdUser;
	}

	public String generateJwtToken(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return jwtTokenUtil.generateToken(userDetails.getUsername());
	}

	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Create a UserDetails object from the retrieved user details
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), null);
	}
}
