package test.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping("/join")
    ResponseEntity<Void> join(@RequestBody JoinRequest request) {
        Member member = new Member(null, request.name(), request.password(), Grade.BASIC);
        memberRepository.save(member);
        return ResponseEntity.ok().build();
    }
}
