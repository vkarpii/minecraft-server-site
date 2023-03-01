package ua.minecraftserversite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.Case;
import ua.minecraftserversite.repository.CaseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseRepository repository;

    public List<Case> printCase(){
        return repository.findAll();
    }

    public Case getCase(long id) {
        return repository.findById(id).orElseThrow();
    }
}
