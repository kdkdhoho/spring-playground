package test.member;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {

    Long save(Member member);

    Member findById(Long id);

    Member getByName(String name);
}
