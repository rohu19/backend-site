package com.pool.poolBackendSide.controller;


import com.pool.poolBackendSide.dto.ChangePasswordDTO;
import com.pool.poolBackendSide.dto.ForgotPasswordDTO;
import com.pool.poolBackendSide.dto.LoginDTO;
import com.pool.poolBackendSide.dto.PasswordResetSuccessDTO;
import com.pool.poolBackendSide.dto.ResetPasswordDTO;
import com.pool.poolBackendSide.entity.AppUser;
import com.pool.poolBackendSide.service.AppUserService;
import com.pool.poolBackendSide.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AppUserService appUserService ;

    @Autowired
    private MailService mailService ;


    @PostMapping("login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO)
    {
        AppUser appUser = appUserService.login(loginDTO) ;

        if(appUser == null) {
            loginDTO.setStatus("Login Failed , Username not found");
        }
        else
        {
            loginDTO.setStatus("Login Success");
            loginDTO.setRole(appUser.getRole());
            if(appUser.getStatus() == 0)
            {
                loginDTO.setStatus("Please Activate Your Email Before LoggingIn");
            }
        }
        return ResponseEntity.ok(loginDTO);
    }


    @PostMapping("changePassword")
    public ResponseEntity<ChangePasswordDTO> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO)
    {
        AppUser appUser = appUserService.findByEmail(changePasswordDTO.getEmail()) ;
        changePasswordDTO.setMessage("Password incorrect ");
        changePasswordDTO.setStatus(false);

        if(appUser.getPassword().equals(changePasswordDTO.getOldPassword()))
        {
            appUser.setPassword(changePasswordDTO.getNewPassword());
            appUserService.update(appUser);
            changePasswordDTO.setMessage("Password Changed SuccessFully");
            changePasswordDTO.setStatus(true);
        }
        return ResponseEntity.ok(changePasswordDTO);
    }


    @PostMapping("forgotPassword")
    public ResponseEntity<ForgotPasswordDTO> forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO) throws Exception
    {
        String activationCode = mailService.forgotPasswordLink(forgotPasswordDTO.getEmail()) ;
        AppUser appUser = appUserService.findByEmail(forgotPasswordDTO.getEmail()) ;

        if(appUser == null)
        {
            forgotPasswordDTO.setMessage("Email does'nt exist");
            forgotPasswordDTO.setStatus(false);
            return ResponseEntity.ok(forgotPasswordDTO) ;
        }

        appUser.setActivationCode(activationCode);
        appUserService.update(appUser);

        forgotPasswordDTO.setMessage("Password Reset Form Sent to Your Mail : "+forgotPasswordDTO.getEmail());
        forgotPasswordDTO.setStatus(true);

        return ResponseEntity.ok(forgotPasswordDTO) ;
    }


    @PostMapping("passwordReset")
    public ResponseEntity<PasswordResetSuccessDTO> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO)
    {
        String message = appUserService.resetPassword(resetPasswordDTO.getEmail(),resetPasswordDTO.getActivationCode(),resetPasswordDTO.getPassword());
        PasswordResetSuccessDTO passwordResetSuccessDTO = new PasswordResetSuccessDTO() ;
        passwordResetSuccessDTO.setMessage(message);
        passwordResetSuccessDTO.setStatus(true);
        return ResponseEntity.ok(passwordResetSuccessDTO);
    }


    @GetMapping("myprofile/read/{email}")
    public ResponseEntity<AppUser> read(@PathVariable String email)
    {
        return ResponseEntity.ok(appUserService.findByEmail(email)) ;
    }


    @PostMapping("myprofile/save")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser)
    {
        return ResponseEntity.ok(appUserService.update(appUser)) ;
    }
}
