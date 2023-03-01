package ua.minecraftserversite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.minecraftserversite.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
