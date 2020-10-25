
import java.util.Arrays;
import java.util.List;

public class Admin {

    private String id;

    private List<AdminSkill> skills = Arrays.asList(new AdminSkill("sleep"), new AdminSkill("work"), new AdminSkill("drink coffee"));

    public Admin(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AdminSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<AdminSkill> skills) {
        this.skills = skills;
    }
}
