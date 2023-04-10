package dev.fredyhg.api.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {

    @Query(value = """
        select t from Token t inner join Usuario u\s
        on t.usuario.id = u.id \s
        where u.id = :id and (t.expired = false or t.revoked = false)
        """)
    List<Token> findAllValidTokenByUser(UUID id);


    Optional<Token> findByToken(String token);
}
