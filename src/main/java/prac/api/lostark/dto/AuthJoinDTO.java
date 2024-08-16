package prac.api.lostark.dto;

import lombok.Data;

@Data
public class AuthJoinDTO {
    private String id;
    private String pw;
    private String email;
    private boolean del;
    private boolean social;
}
