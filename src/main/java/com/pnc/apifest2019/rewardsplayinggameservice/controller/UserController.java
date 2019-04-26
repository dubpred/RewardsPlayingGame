package com.pnc.apifest2019.rewardsplayinggameservice.controller;

import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.request.CreateUserDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.DemoResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.TableResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.model.dto.response.UserResponseDto;
import com.pnc.apifest2019.rewardsplayinggameservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//TODO: determine proper rest endpoints:
// - should product be identified in dto, be a PathParam or PathVariable?
// - should endpoint be product/user?
@RestController
@RequestMapping(value = "api/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser (@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }

    public ResponseEntity<DemoResponseDto> getDemo (@RequestParam long userId){
        return ResponseEntity.ok(userService.getDemo(userId));
    }
}
