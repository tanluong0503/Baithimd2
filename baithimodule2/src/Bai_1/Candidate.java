package Bai_1;

public class Candidate {
    private long candidateID;
    private String fullName;
    private String birthday;
    private String phone;
    private String email;
    private String candidateType;

    public Candidate() {
    }

    public Candidate(String fullName, String birthday, String phone, String email, String candidateType) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }
}
