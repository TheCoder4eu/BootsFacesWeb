package net.bootsfaces.issues.issue78;

import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
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
