package com.tekservs.todo_backend_mongo_Atlas.Service;

import com.tekservs.todo_backend_mongo_Atlas.dto.todoDTO;

import java.util.List;

public interface todoService {

    todoDTO addTODO(todoDTO tododto);

    todoDTO getTODO(String id);

    List<todoDTO> getallTODO();

    todoDTO updateTODO(todoDTO tododto, String id);

    void deleteTODO(String id);

    todoDTO complete(String id);

    todoDTO incomplete(String id);
}
