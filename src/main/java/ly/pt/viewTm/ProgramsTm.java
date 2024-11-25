package ly.pt.viewTm;

public class ProgramsTm {
    private String programId;
    private String programName;
    private String duration;
    private String fee;

    public ProgramsTm() {
    }

    public ProgramsTm(String programId, String programName, String duration, String fee) {
        this.programId = programId;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
