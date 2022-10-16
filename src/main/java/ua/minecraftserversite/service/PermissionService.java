package ua.minecraftserversite.service;

import ua.minecraftserversite.entity.Permission;
import ua.minecraftserversite.repository.PermissionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PermissionService {
    private static PermissionService service;

    private PermissionService(){}

    public static PermissionService getInstance(){
        if (service == null)
            service = new PermissionService();
        return service;
    }
    public List<Permission> printPermissions(){
        List<Permission> permissions = PermissionRepository.getInstance().getAllPermissions();
        return permissions.stream()
                .filter(str ->
                        !str.getName().equalsIgnoreCase("Admin") &&
                                !str.getName().equalsIgnoreCase("Standart"))
                .collect(Collectors.toList());
    }

    public Permission getPermission(long id) {
        Permission permission = PermissionRepository.getInstance().getPermissionById(id);
        return permission;
    }
}
