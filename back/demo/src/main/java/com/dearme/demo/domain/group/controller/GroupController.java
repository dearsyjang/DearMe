package com.dearme.demo.domain.group.controller;

import com.dearme.demo.domain.group.dto.CreateGroupRequestDto;
import com.dearme.demo.domain.group.service.GroupServiceImpl;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupServiceImpl groupService;

    @PostMapping
    public ResponseEntity<CommonResponse> createGroup(HttpServletRequest request, @RequestBody CreateGroupRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(groupService.createGroup(id, dto)), HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<CommonResponse> getGroupInfo(@PathVariable(value = "groupId") Long groupId){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(groupService.getGroupInfo(groupId)), HttpStatus.OK);
    }
}
