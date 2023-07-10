package test.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("MemoryMemberRepository 은(는)")
@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class MemoryMemberRepositoryTest {

    private MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void 회원을_저장한다() {
        // given
        Member expect = new Member(1L, "도기", Grade.BASIC);

        // when
        memberRepository.save(expect);

        // then
        Member result = memberRepository.findById(1L);
        assertThat(expect).isEqualTo(result);
    }

    @Test
    void 회원을_아이디로_찾는다() {
        // given
        Member expect = new Member(1L, "도기", Grade.BASIC);
        memberRepository.save(expect);

        // when
        Member result = memberRepository.findById(1L);

        // then
        assertThat(expect).isEqualTo(result);
    }
}
