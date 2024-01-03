package com.tasksapi.tasksapi.task;

import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import lombok.Data;
import jakarta.persistence.Entity;


@Data
@Entity
public class Task {

    @Id
    private Integer id;
    private String title;
    private String note;
    private Integer isCompleted;
    private String date;
    private String startTime;
    private String endTime;
    private Integer color;
    private Integer remind;
    private String repeat;
}
