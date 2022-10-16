package ua.minecraftserversite.service;

import ua.minecraftserversite.entity.History;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.repository.HistoryRepository;

import java.util.List;

public class HistoryService {
    private static HistoryService service;

    private HistoryService(){}

    public static HistoryService getInstance(){
        if (service == null)
            service = new HistoryService();
        return service;
    }

    public List<History> printHistory(User user) {
        List<History> histories = HistoryRepository.getInstance().getHistory(user);
        return histories;
    }
}
