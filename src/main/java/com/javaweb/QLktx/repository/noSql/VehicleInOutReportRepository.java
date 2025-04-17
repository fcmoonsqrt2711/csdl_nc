package com.javaweb.QLktx.repository.noSql;

import com.javaweb.QLktx.models.noSql.AvgParkingDurationDTO;
import com.javaweb.QLktx.models.noSql.VehicleInOutLog;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleInOutReportRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public VehicleInOutReportRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> getDailyVehicleInOutReport() {
        AggregationOperation group = Aggregation.group(
                String.valueOf(DateOperators.dateOf("timeIn").toString("%Y-%m-%d"))
        ).count().as("count");

        AggregationOperation project = Aggregation.project("count").and("_id").as("date");

        TypedAggregation<VehicleInOutLog> aggregation = Aggregation.newAggregation(
            VehicleInOutLog.class,
            group,
            project,
            Aggregation.sort(Sort.Direction.ASC, "date")
        );

        return mongoTemplate.aggregate(aggregation, Document.class).getMappedResults();
    }

    public List<Document> getDailyRevenueReport() {
        AggregationOperation group = Aggregation.group(
                String.valueOf(DateOperators.dateOf("timeIn").toString("%Y-%m-%d"))
        ).sum("fee").as("totalFee");

        AggregationOperation project = Aggregation.project("totalFee").and("_id").as("date");

        TypedAggregation<VehicleInOutLog> aggregation = Aggregation.newAggregation(
            VehicleInOutLog.class,
            group,
            project,
            Aggregation.sort(Sort.Direction.ASC, "date")
        );

        return mongoTemplate.aggregate(aggregation, Document.class).getMappedResults();
    }

    public List<Document> getStudentVehicleInOutReport() {
        AggregationOperation group = Aggregation.group("studentId").count().as("count");

        AggregationOperation project = Aggregation.project("count").and("_id").as("studentId");

        TypedAggregation<VehicleInOutLog> aggregation = Aggregation.newAggregation(
            VehicleInOutLog.class,
            group,
            project,
            Aggregation.sort(Sort.Direction.ASC, "studentId")
        );

        return mongoTemplate.aggregate(aggregation, Document.class).getMappedResults();
    }

    public List<Document> getStudentRevenueReport() {
        AggregationOperation group = Aggregation.group("studentId").sum("fee").as("totalFee");

        AggregationOperation project = Aggregation.project("totalFee").and("_id").as("studentId");

        TypedAggregation<VehicleInOutLog> aggregation = Aggregation.newAggregation(
            VehicleInOutLog.class,
            group,
            project,
            Aggregation.sort(Sort.Direction.ASC, "studentId")
        );

        return mongoTemplate.aggregate(aggregation, Document.class).getMappedResults();
    }

    public List<Document> getLicensePlateVehicleInOutReport() {
        AggregationOperation group = Aggregation.group("licensePlate").count().as("count");

        AggregationOperation project = Aggregation.project("count").and("_id").as("licensePlate");

        TypedAggregation<VehicleInOutLog> aggregation = Aggregation.newAggregation(
            VehicleInOutLog.class,
            group,
            project,
            Aggregation.sort(Sort.Direction.ASC, "licensePlate")
        );

        return mongoTemplate.aggregate(aggregation, Document.class).getMappedResults();
    }
    public List<AvgParkingDurationDTO> getAverageParkingDurations() {
        MatchOperation matchStage = Aggregation.match(
                Criteria.where("timeIn").ne(null).and("timeOut").ne(null)
        );

        ProjectionOperation projectStage = Aggregation.project("studentId")
                .and(
                        ArithmeticOperators.Divide.valueOf(
                                ArithmeticOperators.Subtract.valueOf("timeOut").subtract("timeIn")
                        ).divideBy(3600000)
                ).as("durationInHours");

        GroupOperation groupStage = Aggregation.group("studentId")
                .avg("durationInHours").as("avgDuration");

        // Gộp các stage
        Aggregation aggregation = Aggregation.newAggregation(matchStage, projectStage, groupStage);

        // Thực hiện truy vấn
        AggregationResults<Document> results = mongoTemplate.aggregate(
                aggregation,
                "vehicle_in_out_logs", // tên collection
                Document.class
        );
        List<AvgParkingDurationDTO> list = new ArrayList<>();
        for (Document doc : results.getMappedResults()) {
            AvgParkingDurationDTO avgParkingDurationDTO = new AvgParkingDurationDTO() {
                @Override
                public String getStudentId() {
                    return doc.getString("_id");
                }

                @Override
                public Double getAvgDuration() {
                    return doc.getDouble("avgDuration");
                }
            };
            list.add(avgParkingDurationDTO);
        }
        return list;
    }
}