package prac.api.lostark.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "roleSet")
public class AuthMember extends BaseEntity{
    @Id
    private String id;

    private String pw;
    private String email;
    private boolean del;
    private boolean social;

    @ElementCollection(fetch= FetchType.LAZY)
    @Builder.Default
    private Set<AuthRole> roleSet = new HashSet<>();

    public void changePassword(String pw){
        this.pw = pw;
    }
    public void changeEmail(String email){
        this.email = email;
    }
    public void changeDel(boolean del){
        this.del = del;
    }
    public void addRole(AuthRole role){
        this.roleSet.add(role);
    }
    public void clearRoles(){
        this.roleSet.clear();
    }
    public void changeSocial(boolean social){
        this.social = social;
    }
}
