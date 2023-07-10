package test.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public void join(Member member) {
        repository.save(member);
    }

    public Member find(Long id) {
        return repository.findById(id);
    }
}
