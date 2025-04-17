package com.javaweb.QLktx.controllers.sql;

import com.javaweb.QLktx.models.sql.Room;
import com.javaweb.QLktx.services.sql.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    public List<Room> getAll() {
        return service.getAllRooms();
    }

    @GetMapping("/{roomNumber}")
    public Room getById(@PathVariable String roomNumber) {
        return service.getRoomByNumber(roomNumber).orElse(null);
    }

    @PostMapping
    public Room create(@RequestBody Room room) {
        return service.saveRoom(room);
    }

    @PutMapping("/{roomNumber}")
    public Room update(@PathVariable String roomNumber, @RequestBody Room room) {
        room.setRoomNumber(roomNumber);
        return service.saveRoom(room);
    }

    @DeleteMapping("/{roomNumber}")
    public void delete(@PathVariable String roomNumber) {
        service.deleteRoom(roomNumber);
    }
}
