package az.company.demotelegrambot.repository;

import az.company.demotelegrambot.entity.DevelopmentLangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopmentLangRepository extends JpaRepository<DevelopmentLangEntity, Long> {
}
