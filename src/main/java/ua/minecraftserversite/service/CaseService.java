package ua.minecraftserversite.service;

import ua.minecraftserversite.entity.Case;
import ua.minecraftserversite.repository.CaseRepository;

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
}
