package tacho.security;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tacho.data.UserRepository;
import tacho.models.User;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

	private final UserRepository userRepo;

	public UserRepositoryUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User '" + username + "' not found");
		}
		return user;
	}

}
