package in.ashokit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.dto.LoginDto;
import in.ashokit.dto.RegisterDto;
import in.ashokit.dto.ResetPwdDto;
import in.ashokit.dto.UserDto;
import in.ashokit.service.UserService;
import in.ashokit.util.AppProperties;

@Controller
public class UserController {
   @Autowired
   private UserService userService;
   @Autowired
   private AppProperties props;

   @GetMapping({"/register"})
   public String registerPage(Model model) {
      model.addAttribute("registerDto", new RegisterDto());
      model.addAttribute("countries", this.userService.getCountries());
      return "registerView";
   }

   @GetMapping({"/states/{cid}"})
   @ResponseBody
   public Map<Integer, String> getStates(@PathVariable("cid") Integer cid) {
      return this.userService.getStates(cid);
   }

   @GetMapping({"/cities/{sid}"})
   @ResponseBody
   public Map<Integer, String> getCities(@PathVariable("sid") Integer sid) {
      return this.userService.getCities(sid);
   }

   @PostMapping({"/register"})
   public String register(RegisterDto regDto, Model model) {
      Map<String, String> message = this.props.getMessage();
      UserDto user = this.userService.getUser(regDto.getEmail());
      if (user != null) {
         model.addAttribute("emsg", message.get("dupEmail"));
      }

      boolean regiterUser = this.userService.regiterUser(regDto);
      if (regiterUser) {
         model.addAttribute("smsg", message.get("regSucc"));
      } else {
         model.addAttribute("emsg", message.get("regFail"));
      }

      model.addAttribute("countries", this.userService.getCountries());
      return "registerView";
   }

   @GetMapping({"/"})
   public String loginPage(Model model) {
      model.addAttribute("loginDto", new LoginDto());
      return "index";
   }

   @PostMapping({"/login"})
   public String login(LoginDto loginDto, Model model) {
      Map<String, String> message = this.props.getMessage();
      UserDto user = this.userService.getUser(loginDto);
      if (user == null) {
         model.addAttribute("emsg", message.get("invaildCredentials"));
         model.addAttribute("loginDto", new LoginDto());
         return "index";
      } else {
         String pwdUpdated = user.getPwdUpdated();
         if ("yes".equals(pwdUpdated)) {
            return "redirect:dashboard";
         } else {
            ResetPwdDto resetPwdDto = new ResetPwdDto();
            resetPwdDto.setEmail(user.getEmail());
            model.addAttribute("resetPwdDto", resetPwdDto);
            return "resetPwdView";
         }
      }
   }

   @PostMapping({"/resetPwd"})
   public String resetPwd(ResetPwdDto pwdDto, Model model) {
    
	   Map<String, String> message = this.props.getMessage();
      
      if (!pwdDto.getNewPwd().equals(pwdDto.getConfirmPwd())) {
         model.addAttribute("emsg", message.get("pwdMatchErr"));
         return "resetPwdView";
      } else {
         UserDto user = this.userService.getUser(pwdDto.getEmail());
         if (user.getPwd().equals(pwdDto.getOldPwd())) {
            boolean resetPwd = this.userService.resetPwd(pwdDto);
            if (resetPwd) {
               return "redirect:dashboard";
            } else {
               model.addAttribute("emsg", message.get("pwdUpdateErr"));
               return "resetPwdView";
            }
         } else {
            model.addAttribute("emsg", message.get("oldPwdErr"));
            return "resetPwdView";
         }
      }
   }

   @GetMapping({"/dashboard"})
   public String dashboard(Model model) {
      String quote = this.userService.getQuote();
      model.addAttribute("quote", quote);
      return "dashboardView";
   }

   @GetMapping({"/logout"})
   public String logout() {
      return "index";
   }
}