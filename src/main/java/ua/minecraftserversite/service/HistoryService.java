package ua.minecraftserversite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.History;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.repository.HistoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository repository;

    public List<History> printHistory(User user) {
        return repository.findByUserId(user.getId());
    }
}
