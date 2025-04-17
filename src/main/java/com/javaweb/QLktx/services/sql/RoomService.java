package com.javaweb.QLktx.services.sql;

import com.javaweb.QLktx.models.sql.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    public List<Room> getAllRooms();

    public Optional<Room> getRoomByNumber(String roomNumber);

    public Room saveRoom(Room room);

    public void deleteRoom(String roomNumber);
}
