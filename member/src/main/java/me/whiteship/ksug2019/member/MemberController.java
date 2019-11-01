package me.whiteship.ksug2019.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/member/join/{username}")
    public Member join(@PathVariable String username) {
        Member member = Member.builder().username(username).build();
        return memberRepository.save(member);
    }

    @GetMapping("/member/{username}")
    public Member byUsername(@PathVariable String username) {
        return memberRepository.findByUsername(username);
    }

    @GetMapping("/member/id/{id}")
    public Member byId(@PathVariable Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

}
