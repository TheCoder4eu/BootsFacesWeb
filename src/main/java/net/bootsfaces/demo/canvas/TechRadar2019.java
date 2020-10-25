package net.bootsfaces.demo.canvas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.bootsfaces.component.canvas.Drawing;

@ManagedBean
@RequestScoped
public class TechRadar2019 extends Drawing {

    {
        text((150), (40), "Tech Radar by BeyondJava", "32px Arial");
        text((150), (70), "August 2019", "24px Arial");
        circle((800), (450), 420);
        circle((800), (450), 315);
        circle((800), (450), 210);
        circle((800), (450), 105);
        line((800 - 450), (450), (800 + 450), 450);
        line((800), (0), (800), 900);

        text((805 + 10), (470), "deprecated", "16px Arial");
        text((805 + 105 + 20), (470), "proven", "16px Arial");
        text((805 + 210 + 10), (470), "innovative", "16px Arial");
        text((805 + 315), (470), "experimental", "16px Arial");

        text((805 + 315), (470 - 315), "frameworks", "24px Arial");
        text((805 + 315), (470 + 315), "languages", "24px Arial");
        text((805 - 315 - 80), (470 - 315), "techniques", "24px Arial");
        text((805 - 315 - 60), (470 + 315), "tools", "24px Arial");

        drawFramework(55, 140, "BootsFaces", "green");
        drawFramework(75, 170, "Angular", "green");
        drawFramework(25, 150, "React", "green");
        drawFramework(10, 220, "Vue.js", "green");

    }

    private void drawFramework(double angle, double distance, String name, String color) {
        int dx = (int) (Math.cos(angle * Math.PI / 180.0) * distance);
        int dy = (int) (Math.sin(angle * Math.PI / 180.0) * distance);

        filledCircle((805 + dx), (450 - dy), 5, color);
        text((800 + 20 + dx), (458 - dy), name, "24px Arial");
    }
}
