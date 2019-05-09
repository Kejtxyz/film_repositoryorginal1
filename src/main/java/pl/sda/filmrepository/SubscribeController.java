package pl.sda.filmrepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscribers")
public class SubscribeController {
    Subskrypcja subskrypcja;

    public SubscribeController(Subskrypcja subskrypcja) {
        this.subskrypcja = subskrypcja;
    }

    @PostMapping
    void addSubscriber (@RequestBody Subskrypcja subskrypcja){
        subskrypcjaRepo.save(subskrypcja);
    }
}
