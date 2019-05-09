package pl.sda.filmrepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/app/suggestions")
public class AllSuggestionsViewController {
    SuggestioRepository repository;

    public AllSuggestionsViewController(SuggestioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    String allSuggestions(Model model , Principal principal){
        model.addAttribute("allSuggestions",repository.findAll());
        model.addAttribute("author", principal.getName());
        return "suggestions";
    }

    @PostMapping
    String addSuggestion (Suggestion suggestion){
        repository.save(suggestion);
        return "redirect:/app/suggestions";
    }


}
