package prac.api.lostark.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import prac.api.lostark.domain.AuthMember;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthMember, String> {
    @EntityGraph(attributePaths="roleSet")
    @Query("select a from AuthMember a where a.id = :id and a.social = false")
    Optional<AuthMember> getWithRoles(String id);
}
