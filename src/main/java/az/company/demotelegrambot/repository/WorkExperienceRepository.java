package az.company.demotelegrambot.repository;

import az.company.demotelegrambot.entity.WorkExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperienceEntity, Long> {
}
