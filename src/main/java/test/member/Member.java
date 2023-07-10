package test.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Grade grade() {
        return grade;
    }
}
