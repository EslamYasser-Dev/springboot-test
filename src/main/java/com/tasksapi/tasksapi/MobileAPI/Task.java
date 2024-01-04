package com.tasksapi.tasksapi.MobileAPI;

import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import lombok.Data;
import jakarta.persistence.Entity;

import java.util.Date;

@Data
@Entity
@NamedStoredProcedureQuery(
        name = "GetTasks",
        procedureName = "GetTasks"
)
public class Task {

    @Id
    private String id;
    private String title;
    private String note;
    private java.util.Date Date;
    private String startTime;
    private String endTime;
    private String color;
    private Integer remind;
    private String repeat;
    private String isCompleted;

}
