package tk.hfjohn123.rurl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map.Entry;

@Controller
public class MainController {

    @Autowired
    private EntryRepository EntryRepository;

    @GetMapping("/s/{id}")
    public ModelAndView redirect(@PathVariable(value = "id",required = false) String id) {
        ObjectId objectid = new ObjectId(id);
        tk.hfjohn123.rurl.Entry entry = EntryRepository.findById(objectid).get();
        String target = entry.getAddress();
        entry.setCount(entry.getCount()+1);
        EntryRepository.save(entry);
        return new ModelAndView("redirect:"+target);
    }
}
