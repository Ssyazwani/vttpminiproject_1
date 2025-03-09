package testtest.surah.list.surahlisttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class HadithController {

    private final RestTemplate restTemplate;
    private final String baseurl = "https://hadithapi.com/public/api/hadiths?apiKey="; 
    private final String apiKey = "apiKey";  

    @Autowired
    public HadithController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index"; 
    }

    @GetMapping("/getHadith")
    public String getRandomHadith(@RequestParam(required = false, defaultValue = "true") String hadithEnglish, Model model) {
        String url = UriComponentsBuilder.fromHttpUrl(baseurl)
                .queryParam("apiKey", apiKey)
                .queryParam("hadithEnglish", hadithEnglish)
                .toUriString();

       
        String response = restTemplate.getForObject(url, String.class);

    
        model.addAttribute("hadith", response);

    
        return "index";
    }
}

