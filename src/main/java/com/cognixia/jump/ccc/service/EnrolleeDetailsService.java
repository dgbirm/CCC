package com.cognixia.jump.ccc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognixia.jump.ccc.model.Enrollee;
import com.cognixia.jump.ccc.repository.EnrolleeRepo;

@Service
@Transactional
public class EnrolleeDetailsService implements UserDetailsService {
	
	private static List<GrantedAuthority> authorities = new ArrayList<>();
	static {
		authorities.add(new SimpleGrantedAuthority("ROLE_ENROLLEE"));	
	}

	@Autowired
	private EnrolleeRepo enrolleRepo;
	
	public EnrolleeDetailsService() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(final String idAsString) throws UsernameNotFoundException {
		try {
			Optional<Enrollee> findEnrollee = enrolleRepo.findById(Long.parseLong(idAsString.strip()));
			if(findEnrollee.isEmpty()) {
				throw new UsernameNotFoundException("Enrollee not found");
			}
			return new User(idAsString, findEnrollee.get().getHashWord(), authorities);
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
		
		catch (UsernameNotFoundException e) {
			e.getMessage();
			throw new RuntimeException(e);
		}
	}
}
