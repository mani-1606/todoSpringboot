package com.tekservs.todo_backend_mongo_Atlas.Repository;

import com.tekservs.todo_backend_mongo_Atlas.Model.todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todoRepo extends MongoRepository<todo, String> {

}
