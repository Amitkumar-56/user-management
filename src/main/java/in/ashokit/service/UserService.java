package in.ashokit.service;

import java.util.Map;
import in.ashokit.dto.LoginDto;
import in.ashokit.dto.RegisterDto;
import in.ashokit.dto.ResetPwdDto;
import in.ashokit.dto.UserDto;
public interface UserService {
	   Map<Integer, String> getCountries();

	   Map<Integer, String> getStates(Integer cid);

	   Map<Integer, String> getCities(Integer sid);

	   UserDto getUser(String email);

	   boolean regiterUser(RegisterDto regDto);

	   UserDto getUser(LoginDto loginDto);

	   boolean resetPwd(ResetPwdDto pwdDto);

	   String getQuote();
	}
	    