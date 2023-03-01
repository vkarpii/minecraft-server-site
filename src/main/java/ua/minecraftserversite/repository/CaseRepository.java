package ua.minecraftserversite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.minecraftserversite.entity.Case;

@Repository
public interface CaseRepository extends JpaRepository<Case,Long> {
}
