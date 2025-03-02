package testtest.surah.list.surahlisttest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import testtest.surah.list.surahlisttest.model.SavedData;

public class Qhadith {


    @Autowired
    private RedisTemplate<String, SavedData> redisTemplate;

    private RestTemplate restTemplate = new RestTemplate();

    String baseurl="https://hadithapi.com/public/api/hadiths?apiKey=";
    String apiKey;
    int x;
    String numberofHadith = "&paginate=" + x;
    String idNumber = "&id=";
    String hadithEnglish;


   
    public ResponseEntity<?> allHadith(){
   String url = UriComponentsBuilder.fromHttpUrl(baseurl)
            .queryParam("apiKey", apiKey)
            .queryParam("hadithEnglish", hadithEnglish)
            .queryParam("paginate", x)
            .toUriString();
        

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        
      
        return responseEntity;
    }

   
    
}
