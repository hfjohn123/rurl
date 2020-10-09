package tk.hfjohn123.rurl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private EntryRepository EntryRepository;

    @GetMapping("/s/{id}")
    public ModelAndView redirect(@PathVariable(value = "id", required = false) String id) {
        ObjectId objectid = new ObjectId(id);
        tk.hfjohn123.rurl.Entry entry = EntryRepository.findById(objectid).get();
        String target = entry.getAddress();
        entry.setCount(entry.getCount() + 1);
        EntryRepository.save(entry);
        return new ModelAndView("redirect:" + target);
    }


    @RequestMapping("/API")
    public String API() {
        return "https://app.swaggerhub.com/apis-docs/hfjohn123/Rurlapi/1.0.0";
    }

}
