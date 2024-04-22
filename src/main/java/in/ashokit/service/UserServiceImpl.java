package in.ashokit.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.dto.LoginDto;
import in.ashokit.dto.QuoteDto;
import in.ashokit.dto.RegisterDto;
import in.ashokit.dto.ResetPwdDto;
import in.ashokit.dto.UserDto;
import in.ashokit.entity.CityEntity;
import in.ashokit.entity.CountryEntity;
import in.ashokit.entity.StateEntity;
import in.ashokit.entity.UserEntity;
import in.ashokit.repo.CityRepo;
import in.ashokit.repo.CountryRepo;
import in.ashokit.repo.StateRepo;
import in.ashokit.repo.UserRepo;
import in.ashokit.util.EmailUtil;



@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserRepo userRepo;
   @Autowired
   private CountryRepo countryRepo;
   @Autowired
   private StateRepo stateRepo;
   @Autowired
   private CityRepo cityRepo;
   @Autowired
   private EmailUtil emailUtils;
   private QuoteDto[] quotations;

   public Map<Integer, String> getCountries() {
      Map<Integer, String> countryMap = new HashMap();
      List<CountryEntity> countriesList = this.countryRepo.findAll();
      countriesList.forEach((c) -> {
         countryMap.put(c.getCountryId(), c.getCountryName());
      });
      return countryMap;
   }

   public Map<Integer, String> getStates(Integer cid) {
      HashMap<Integer, String> statesMap = new HashMap();
      List<StateEntity> statesList = this.stateRepo.getStates(cid);
      statesList.forEach((s) -> {
         statesMap.put(s.getStateId(), s.getStateName());
      });
      return statesMap;
   }

   public Map<Integer, String> getCities(Integer sid) {
      HashMap<Integer, String> citiesMap = new HashMap();
      List<CityEntity> citiesList = this.cityRepo.getCities(sid);
      citiesList.forEach((c) -> {
         citiesMap.put(c.getCityId(), c.getCityName());
      });
      return citiesMap;
   }

   public UserDto getUser(String email) {
      UserEntity userEntity = this.userRepo.findByEmail(email);
      if (userEntity == null) {
         return null;
      } else {
         ModelMapper mapper = new ModelMapper();
         return (UserDto)mapper.map(userEntity, UserDto.class);
      }
   }

   public boolean regiterUser(RegisterDto regDto) {
      ModelMapper mapper = new ModelMapper();
      UserEntity entity = (UserEntity)mapper.map(regDto, UserEntity.class);
      CountryEntity country = (CountryEntity)this.countryRepo.findById(regDto.getCountryId()).orElseThrow();
      StateEntity state = (StateEntity)this.stateRepo.findById(regDto.getStateId()).orElseThrow();
      CityEntity city = (CityEntity)this.cityRepo.findById(regDto.getCityId()).orElseThrow();
      entity.setCountry(country);
      entity.setState(state);
      entity.setCity(city);
      entity.setPwd(generateRandom());
      entity.setPwdUpdated("no");
      UserEntity savedEntity = (UserEntity)this.userRepo.save(entity);
      String subject = "User Registeration";
      String body = "Your Temporary Password is " + entity.getPwd();
      this.emailUtils.sendEmail(regDto.getEmail(), subject, body);
      return savedEntity.getUserId() != null;
   }

   public UserDto getUser(LoginDto loginDto) {
      UserEntity userEntity = this.userRepo.findByEmailAndPwd(loginDto.getEmail(), loginDto.getPwd());
      if (userEntity == null) {
         return null;
      } else {
         ModelMapper mapper = new ModelMapper();
         return (UserDto)mapper.map(userEntity, UserDto.class);
      }
   }

   public boolean resetPwd(ResetPwdDto pwdDto) {
      UserEntity userEntity = this.userRepo.findByEmailAndPwd(pwdDto.getEmail(), pwdDto.getOldPwd());
      if (userEntity != null) {
         userEntity.setPwd(pwdDto.getNewPwd());
         userEntity.setPwdUpdated("yes");
         this.userRepo.save(userEntity);
         return true;
      } else {
         return false;
      }
   }

   public String getQuote() {
      if (this.quotations == null) {
         String url = "https://type.fit/api/quotes";
         RestTemplate rt = new RestTemplate();
         ResponseEntity<String> forEntity = rt.getForEntity(url, String.class, new Object[0]);
         String responseBody = (String)forEntity.getBody();
         ObjectMapper mapper = new ObjectMapper();

         try {
            this.quotations = (QuoteDto[])mapper.readValue(responseBody, QuoteDto[].class);
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      Random r = new Random();
      int index = r.nextInt(this.quotations.length - 1);
      return this.quotations[index].getText();
   }

   private static String generateRandom() {
      String aToZ = "ABCDEFGHIJKLMNOPQRRSTUVWXYZ123456789";
      Random random = new Random();
      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < 5; ++i) {
         int randomIndex = random.nextInt(aToZ.length());
         sb.append(aToZ.charAt(randomIndex));
      }

      return sb.toString();
   }
}