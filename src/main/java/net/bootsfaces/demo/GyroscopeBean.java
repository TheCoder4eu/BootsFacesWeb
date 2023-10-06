package net.bootsfaces.demo;

import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class GyroscopeBean implements Serializable {

    private int alpha;
    private int beta;
    private int gamma;
    private int calls = 0;

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
        calls++;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public int getGamma() {
        return gamma;
    }

    public void setGamma(int gamma) {
        this.gamma = gamma;
    }

    public void onRotation() {
        System.out.println("Rotate! " + System.currentTimeMillis());
    }

    public int getCalls() {
        return calls;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

}
