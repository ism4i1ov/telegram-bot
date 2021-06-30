package az.company.demotelegrambot.repository;

import az.company.demotelegrambot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByChatId(Long chatId);

    List<UserEntity> getAllByDevelopmentLangName(String name);
}
