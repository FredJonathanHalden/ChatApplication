package repository;

import mvc.model.Message;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called messageRepository
// CRUD refers Create, Read, Update, Delete
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
