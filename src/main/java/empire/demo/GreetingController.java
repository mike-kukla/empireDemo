package empire.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import empire.demo.model.Provider;
import empire.demo.services.ProviderRepository;

@Controller
public class GreetingController {
	
	@ModelAttribute("definitions")
	public List<String> addProviderNamesToModel(){
		return this.repository.findDistinctProviderDefinitions();
	}

    @RequestMapping({"/"}) 
    public String greeting() {
       return "home";
    }

    @RequestMapping({"/byDefinition.html"}) 
    public String byDefinition(@RequestParam(value="definition", required=false, defaultValue="") String definition, Model model) {
        model.addAttribute("definition", definition);
        model.addAttribute("accResult", this.repository.findAverageAcc(definition));
        return "home";
    }
    
    public ProviderRepository getRepository() {
		return repository;
	}
	public void setRepository(ProviderRepository repository) {
		this.repository = repository;
	}


	@Autowired
    private ProviderRepository repository;
}
