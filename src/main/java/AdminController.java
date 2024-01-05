
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@ViewScoped
public class AdminController implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Admin> admins = new ArrayList<>();

    private Admin selectedAdmin = null;

    public AdminController() {
        admins.add(new Admin("Hugo"));
        admins.add(new Admin("Erwin"));
        admins.add(new Admin("Helga"));
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public void onSelect(Admin admin) {
        this.selectedAdmin = admin;
    }

    public List<AdminSkill> getAdminSkills() {
        if (null == selectedAdmin) {
            return new ArrayList<>();
        }
        return selectedAdmin.getSkills();
    }

}
