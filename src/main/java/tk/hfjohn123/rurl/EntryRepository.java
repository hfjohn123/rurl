package tk.hfjohn123.rurl;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "entry", path = "entry")
public interface EntryRepository extends MongoRepository<Entry, ObjectId> {

}
