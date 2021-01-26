package org.upgrad.upstac.auth.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;
import org.upgrad.upstac.users.models.AccountStatus;
import org.upgrad.upstac.users.roles.UserRole;

import java.time.LocalDateTime;


@Service
public class RegisterService {

    @Autowired
    private UserService userService;


    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);


    public User addUser(RegisterRequest registerRequest) {

/*      User should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.USER)
                status should be set to AccountStatus.APPROVED

        And finally
            Call userService.saveInDatabase to save the new user and return the saved user
*/
        if(userService.findByUserName(registerRequest.getUserName()) != null){
            throw new AppException("Username already exists");
        }
        if(userService.findByEmail(registerRequest.getEmail()) !=null){
            throw new AppException("Email ID already exists");
        }
        if(userService.findByPhoneNumber(registerRequest.getPhoneNumber()) !=null){
            throw new AppException("Phone number already exists");
        }

        User user1 = new User();
        user1.setFirstName(user1.getFirstName());
        user1.setLastName(user1.getLastName());
        user1.setUserName(user1.getUserName());
        user1.setPassword(userService.toEncrypted(registerRequest.getPassword()));
        user1.setRoles(userService.getRoleFor(UserRole.USER));
        user1.setGender(user1.getGender());
        user1.setDateOfBirth(user1.getDateOfBirth());
        user1.setEmail(user1.getEmail());
        user1.setPhoneNumber(user1.getPhoneNumber());
        user1.setAddress(user1.getAddress());
        user1.setPinCode(user1.getPinCode());
        user1.setStatus(AccountStatus.APPROVED);
        user1.setCreated(LocalDateTime.now());
        user1.setUpdated(LocalDateTime.now());

       return userService.saveInDatabase(user1);
    }

    public User addDoctor(RegisterRequest registerRequest) {


/*      Doctor should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.DOCTOR)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save the newly registered doctor and return the saved value
*/
        if(userService.findByUserName(registerRequest.getUserName()) != null){
            throw new AppException("Username already exists");
        }
        if(userService.findByEmail(registerRequest.getEmail()) !=null){
            throw new AppException("Email ID already exists");
        }
        if(userService.findByPhoneNumber(registerRequest.getPhoneNumber()) !=null){
            throw new AppException("Phone number already exists");
        }
        User user1 = new User();
        user1.setFirstName(user1.getFirstName());
        user1.setLastName(user1.getLastName());
        user1.setUserName(user1.getUserName());
        user1.setPassword(userService.toEncrypted(registerRequest.getPassword()));
        user1.setRoles(userService.getRoleFor(UserRole.DOCTOR));
        user1.setGender(user1.getGender());
        user1.setDateOfBirth(user1.getDateOfBirth());
        user1.setEmail(user1.getEmail());
        user1.setPhoneNumber(user1.getPhoneNumber());
        user1.setAddress(user1.getAddress());
        user1.setPinCode(user1.getPinCode());
        user1.setStatus(AccountStatus.INITIATED);
        user1.setCreated(LocalDateTime.now());
        user1.setUpdated(LocalDateTime.now());

        return   userService.saveInDatabase(user1);
    }


    public User addTester(RegisterRequest user) {


/*      Tester should be validated before registration.
                the username , email and phone number should be unique (i.e should throw AppException if the RegisterRequest has the same username or email or phone number)
                    hint:
                        userService.findByUserName
                        userService.findByEmail
                        userService.findByPhoneNumber

         A new User Object should be created with same details as registerRequest
                password should be encrypted with help of   userService.toEncrypted
                roles should be set with help of  userService.getRoleFor(UserRole.TESTER)
                status should be set to AccountStatus.INITIATED

        And finally
            Call userService.saveInDatabase to save newly registered tester and return the saved value
*/
        if(userService.findByUserName(user.getUserName()) != null){
            throw new AppException("Username already exists");
        }
        if(userService.findByEmail(user.getEmail()) !=null){
            throw new AppException("Email ID already exists");
        }
        if(userService.findByPhoneNumber(user.getPhoneNumber()) !=null){
            throw new AppException("Phone number already exists");
        }

        User user1 = new User();
        user1.setFirstName(user1.getFirstName());
        user1.setLastName(user1.getLastName());
        user1.setUserName(user1.getUserName());
        user1.setPassword(userService.toEncrypted(user.getPassword()));
        user1.setRoles(userService.getRoleFor(UserRole.TESTER));
        user1.setGender(user.getGender());
        user1.setDateOfBirth(user1.getDateOfBirth());
        user1.setEmail(user1.getEmail());
        user1.setPhoneNumber(user1.getPhoneNumber());
        user1.setAddress(user1.getAddress());
        user1.setPinCode(user1.getPinCode());
        user1.setStatus(AccountStatus.INITIATED);
        user1.setCreated(LocalDateTime.now());
        user1.setUpdated(LocalDateTime.now());



        return userService.saveInDatabase(user1);
    }


}
