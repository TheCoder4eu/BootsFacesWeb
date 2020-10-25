package net.bootsfaces.issues.issue78;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class SoccerTeamBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Player> team;
    private Player goalkeeper;

    public void init(ComponentSystemEvent e) {
        this.team = new ArrayList<>();
        this.team.add(new Player("Marc-André ter Stegen"));
        this.team.add(new Player("Jordi Masip"));
        this.team.add(new Player("Jordi Alba"));
        this.team.add(new Player("Marc Batra"));
    }

    public List<Player> getTeam() {
        return team;
    }

    public void setTeam(List<Player> team) {
        this.team = team;
    }

    public Player getGoalkeeper() {
        return goalkeeper;
    }

    public void setGoalkeeper(Player goalkeeper) {
        this.goalkeeper = goalkeeper;
    }
}
