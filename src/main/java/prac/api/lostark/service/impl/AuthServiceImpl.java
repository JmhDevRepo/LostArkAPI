package prac.api.lostark.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import prac.api.lostark.domain.AuthMember;
import prac.api.lostark.domain.AuthRole;
import prac.api.lostark.dto.AuthJoinDTO;
import prac.api.lostark.repository.AuthRepository;
import prac.api.lostark.service.AuthService;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void join(AuthJoinDTO dto) throws MidExistException {
        String id = dto.getId();
        boolean exists = authRepository.existsById(id);

        if(exists) {
            throw new MidExistException();
        }

        AuthMember member = modelMapper.map(dto, AuthMember.class);
        member.changePassword(passwordEncoder.encode(dto.getPw()));
        member.addRole(AuthRole.USER);

        log.info("=================");
        log.info(member);
        log.info(member.getRoleSet());

        authRepository.save(member);
    }
}
