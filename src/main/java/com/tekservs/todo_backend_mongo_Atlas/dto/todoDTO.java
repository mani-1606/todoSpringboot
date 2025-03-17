package com.tekservs.todo_backend_mongo_Atlas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import static java.lang.Integer.parseInt;

@Getter
@Setter

public class todoDTO {
    private String id;
    private String title;
    private String description;
    private boolean completed;

    public todoDTO(String id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public todoDTO() {
    }
}
