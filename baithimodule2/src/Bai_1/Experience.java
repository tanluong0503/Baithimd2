package Bai_1;

public class Experience extends Candidate {
    private int ExpInYear;
    private String ProSkill;

    public Experience() {
    }

    public Experience(int certificatedID, String certificateName, int certificateRank, String certificatedDate, int ExpInYear, String ProSkill) {
        super(certificatedId, certificatedName, certificatedRank, certificatedDate);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int ExpInYear){
        this.expInYear() = expInYear;
    }

    public String getProSkills() {
        return proSkills;
    }

    public void setProSkills(String proSkills) {
        this.proSkills = proSkills;
    }

    @Override
    public void showMe() {

    }
}
