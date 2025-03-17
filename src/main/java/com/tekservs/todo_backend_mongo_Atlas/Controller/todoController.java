package com.tekservs.todo_backend_mongo_Atlas.Controller;

import com.tekservs.todo_backend_mongo_Atlas.Service.todoService;
import com.tekservs.todo_backend_mongo_Atlas.dto.todoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
public class todoController {
    @Autowired
    private todoService service;
    @PostMapping
    public ResponseEntity<todoDTO> addTodo(@RequestBody todoDTO todo){
        todoDTO savedtododto = service.addTODO(todo);
        return new ResponseEntity<>(savedtododto, HttpStatus.ACCEPTED);
    }
    @GetMapping("{id}")
    public ResponseEntity<todoDTO> getTodo(@PathVariable("id") String id){
        todoDTO got = service.getTODO(id);
        return new ResponseEntity<>(got, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<todoDTO>> getallTODO(){
        List<todoDTO> save = service.getallTODO();
        return ResponseEntity.ok(save);
    }
   @PutMapping("{id}")
    public ResponseEntity<todoDTO> updateTODO(@RequestBody todoDTO tododto,@PathVariable("id") String id){
        todoDTO updatetd = service.updateTODO(tododto,id);
        return ResponseEntity.ok(updatetd);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTODO(@PathVariable("id") String id){
        service.deleteTODO(id);
        return  ResponseEntity.ok("todo was deleted ");
    }
    @PatchMapping("{id}/complete")
    public ResponseEntity<todoDTO> complete(@PathVariable("id") String id){
        todoDTO update = service.complete(id);
     return new ResponseEntity<>(update, HttpStatus.ACCEPTED);
    }
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<todoDTO> incomplete(@PathVariable("id") String id){
        todoDTO update = service.incomplete(id);
        return new ResponseEntity<>(update, HttpStatus.ACCEPTED);
    }
}
