package tk.hfjohn123.rurl;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "entry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

    @Id
    private ObjectId ID;

    @NotNull
    private String address;

    @NotNull
    private String UA;

    @NotNull
    private  int count;


}
