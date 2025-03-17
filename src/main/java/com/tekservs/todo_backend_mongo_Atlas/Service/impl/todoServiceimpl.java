package com.tekservs.todo_backend_mongo_Atlas.Service.impl;

import com.tekservs.todo_backend_mongo_Atlas.Model.todo;
import com.tekservs.todo_backend_mongo_Atlas.Repository.todoRepo;
import com.tekservs.todo_backend_mongo_Atlas.Service.todoService;
import com.tekservs.todo_backend_mongo_Atlas.dto.todoDTO;
import com.tekservs.todo_backend_mongo_Atlas.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class todoServiceimpl implements todoService {
     @Autowired
    private todoRepo repo;
    @Autowired
     private ModelMapper modelMapper;

    @Override
    public todoDTO addTODO(todoDTO tododto) {
        todo td = modelMapper.map(tododto,todo.class);
        todo savedtodo=repo.save(td);

        todoDTO savedtododto = modelMapper.map(savedtodo, todoDTO.class);
        return savedtododto;
    }

    @Override
    public todoDTO getTODO(String id) {
        todo td = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("todo not find with the number "+ id));
        return modelMapper.map(td,todoDTO.class);
    }

    @Override
    public List<todoDTO> getallTODO() {
        List<todo> todos = repo.findAll();
        return todos.stream().map((todo -> modelMapper.map(todo , todoDTO.class)))
                .collect(Collectors.toList());
    }

    @Override
    public todoDTO updateTODO(todoDTO tododto, String id) {
        todo to = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("todo not found with id "+ id));
        to.setTitle(tododto.getTitle());
        to.setDescription(tododto.getDescription());
        to.setCompleted(tododto.isCompleted());
        todo savedtodo =  repo.save(to);

        return modelMapper.map(savedtodo, todoDTO.class);

    }

    @Override
    public void deleteTODO(String id) {
        todo td = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("entered for deleting id was not found "));
        repo.deleteById(id);
    }

    @Override
    public todoDTO complete(String id) {
        todo tm = repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("id was not found "));
        tm.setCompleted(Boolean.TRUE);
        todo tc = repo.save(tm);
        return modelMapper.map(tc, todoDTO.class);
    }

    @Override
    public todoDTO incomplete(String id) {
       todo pt =  repo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("id was not found please enter correct one "));
        pt.setCompleted(Boolean.FALSE);
        todo tc = repo.save(pt);
        return modelMapper.map(tc, todoDTO.class);
    }
}
