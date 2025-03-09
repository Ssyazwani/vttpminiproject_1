package testtest.surah.list.surahlisttest.restcontroller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.servlet.http.HttpSession;
import testtest.surah.list.surahlisttest.service.Qhadith;

@RestController
@RequestMapping("/api/hadith")
public class QhadithController {

    private final RestTemplate restTemplate;
    private final String baseurl = "https://hadithapi.com/public/api/hadiths?apiKey="; 
    private final String apiKey = "apiKey"; 

    public QhadithController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    
    @GetMapping("/randomHadith")
    public ResponseEntity<String> randomHadith(@RequestParam String hadithEnglish) {
        String url = UriComponentsBuilder.fromHttpUrl(baseurl)
                .queryParam("apiKey", apiKey)
                .queryParam("hadithEnglish", hadithEnglish)
                .toUriString();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

       
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(responseEntity.getBody());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching Hadith.");
        }
    }
}
