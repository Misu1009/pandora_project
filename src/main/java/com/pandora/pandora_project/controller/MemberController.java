package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/pandora")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PutMapping("/ratemember")
    public boolean rateMember(@RequestParam long senderId, @RequestParam long memberId, @RequestParam String period, @RequestParam double custFocus,
                              @RequestParam double integrity, @RequestParam double teamwork,
                              @RequestParam double cpoe) {
        return memberService.rate(senderId, memberId, period, custFocus, integrity, teamwork, cpoe);
    }
}
