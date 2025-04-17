package com.javaweb.QLktx.serviceimpl.sql;

import com.javaweb.QLktx.models.sql.Room;
import com.javaweb.QLktx.repository.sql.RoomRepository;
import com.javaweb.QLktx.services.sql.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public Optional<Room> getRoomByNumber(String roomNumber) {
        return repository.findById(roomNumber);
    }

    public Room saveRoom(Room room) {
        return repository.save(room);
    }

    public void deleteRoom(String roomNumber) {
        repository.deleteById(roomNumber);
    }
}
