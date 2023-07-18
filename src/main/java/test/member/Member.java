package test.member;

public record Member(
        Long id,
        String name,
        String password,
        Grade grade
) {

    public boolean isSamePassword(String password) {
        return this.password.equals(password);
    }
}
