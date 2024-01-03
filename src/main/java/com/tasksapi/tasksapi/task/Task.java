package com.tasksapi.tasksapi.task;

import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity
@NamedStoredProcedureQuery(
        name = "GetEvents",
        procedureName = "GetEvents"
)
public class Task {

    @Id
    private String id;
    private String title;
    private String note;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
    private String color;
}
