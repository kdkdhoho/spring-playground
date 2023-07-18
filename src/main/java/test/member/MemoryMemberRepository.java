package test.member;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();
    private long id = 1L;

    @Override
    public Long save(Member member) {
        store.put(id, member);
        return ++id;
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public Member getByName(String name) {
        return store.values().stream()
                .filter(member -> member.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }
}
