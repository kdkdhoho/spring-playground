package test.session;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.member.Member;
import test.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class SessionLoginService {

    private final MemberRepository memberRepository;

    public Member login(String name, String password) {
        Member member = memberRepository.getByName(name);

        if (member.isSamePassword(password)) {
            return member;
        }
        throw new RuntimeException("비밀번호가 틀립니다.");
    }
}
