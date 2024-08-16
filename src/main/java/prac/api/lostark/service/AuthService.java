package prac.api.lostark.service;


import prac.api.lostark.dto.AuthJoinDTO;

public interface AuthService {
    static class MidExistException extends Exception {}

    void join(AuthJoinDTO dto) throws MidExistException;
}
