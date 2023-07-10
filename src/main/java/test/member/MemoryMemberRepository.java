package test.member;

import java.util.HashMap;
import java.util.Map;

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
}
