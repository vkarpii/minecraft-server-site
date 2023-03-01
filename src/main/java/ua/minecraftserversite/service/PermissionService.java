package ua.minecraftserversite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.Permission;
import ua.minecraftserversite.repository.PermissionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository repository;

    public List<Permission> printPermissions(){
        return repository.findAll().stream()
                .filter(str ->
                        !str.getName().equalsIgnoreCase("Admin") &&
                                !str.getName().equalsIgnoreCase("Standart"))
                .collect(Collectors.toList());
    }

    public Permission getPermission(long id) {
        return repository.findById(id).orElseThrow();
    }
}
