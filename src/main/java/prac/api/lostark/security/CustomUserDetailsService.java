package prac.api.lostark.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import prac.api.lostark.domain.AuthMember;
import prac.api.lostark.dto.AuthSecurityDTO;
import prac.api.lostark.repository.AuthRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: " + username);

        Optional<AuthMember> result = authRepository.getWithRoles(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException(username);
        }

        AuthMember member = result.get();

        AuthSecurityDTO authSecurityDTO = new AuthSecurityDTO(member.getId(), member.getPw(), member.getEmail(), member.isDel(), false, member.getRoleSet().stream().map(memberRole-> new SimpleGrantedAuthority("ROLE_"+memberRole.name())).collect(Collectors.toList()));

        log.info("authSecurityDTO");
        log.info(authSecurityDTO);

        return authSecurityDTO;
    }
}
