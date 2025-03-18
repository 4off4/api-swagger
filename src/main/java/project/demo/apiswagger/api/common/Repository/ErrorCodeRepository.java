package project.demo.apiswagger.api.common.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.apiswagger.api.common.Entity.ErrorCode;
import java.util.Optional;

public interface ErrorCodeRepository extends JpaRepository<ErrorCode, Integer> {
    Optional<ErrorCode> findByCodeAndLang(String code, String lang);
    String findMessageByCodeAndLang(String code, String lang);
}