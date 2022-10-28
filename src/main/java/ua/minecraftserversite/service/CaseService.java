package ua.minecraftserversite.service;

import ua.minecraftserversite.entity.Buying;
import ua.minecraftserversite.entity.Case;
import ua.minecraftserversite.entity.Permission;
import ua.minecraftserversite.repository.CaseRepository;
import ua.minecraftserversite.repository.PermissionRepository;

import java.util.List;

public class CaseService {
    private static CaseService service;

    private CaseService(){}

    public static CaseService getInstance(){
        if (service == null)
            service = new CaseService();
        return service;
    }
    public List<Case> printCase(){
        List<Case> cases = CaseRepository.getInstance().getAllCases();
        return cases;
    }

    public Case getCase(long id) {
        Case gCase = CaseRepository.getInstance().getCaseById(id);
        return gCase;
    }
}
