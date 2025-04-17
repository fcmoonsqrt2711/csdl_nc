// RoomRepository.java
package com.javaweb.QLktx.repository.sql;

import com.javaweb.QLktx.models.sql.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {
    @Query("SELECT r.roomNumber, COUNT(s.studentID) " +
            "FROM Room r JOIN Student s ON s.room.roomNumber = r.roomNumber " +
            "GROUP BY r.roomNumber " +
            "HAVING COUNT(s.studentID) > r.maxOccupants")
    List<Object[]> getRoomsOverCapacity();
}
