package net.bootsfaces.demo.canvas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.bootsfaces.component.canvas.Drawing;

@ManagedBean
@RequestScoped
public class TechRadar extends Drawing {

    {
        text(150, 40, "Tech Radar by BeyondJava", "24px Arial");
        text(150, 70, "April 2016", "24px Arial");
        circle(800, 450, 420);
        circle(800, 450, 315);
        circle(800, 450, 210);
        circle(800, 450, 105);
        line(800 - 450, 450, 800 + 450, 450);
        line(800, 0, 800, 900);

        text(805 + 10, 470, "deprecated", "16px Arial");
        text(805 + 105 + 20, 470, "proven", "16px Arial");
        text(805 + 210 + 10, 470, "innovative", "16px Arial");
        text(805 + 315, 470, "experimental", "16px Arial");

        text(805 + 315, 470 - 315, "frameworks", "16px Arial");
        text(805 + 315, 470 + 315, "languages", "16px Arial");
        text(805 - 315 - 80, 470 - 315, "techniques", "16px Arial");
        text(805 - 315 - 60, 470 + 315, "tools", "16px Arial");

        filledCircle(805 + 40 + 70, 470 - 105 - 20, 5, "green");
        text(805 + 20 + 60, 470 - 100, "BootsFaces", "14px Arial");

        filledCircle(805 + 70 + 105, 470 - 210 - 10, 5, "blue");
        text(800 + 40 + 105, 470 - 195, "AngularFaces", "14px Arial");
    }
}
