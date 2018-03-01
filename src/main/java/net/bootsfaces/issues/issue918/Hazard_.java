/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bootsfaces.issues.issue918;

public class Hazard_
{

    private HazardType_ type;
    private HazardOrigin_ origin;

    public HazardOrigin_ getOrigin()
    {
        return origin;
    }

    public void setOrigin(HazardOrigin_ origin)
    {
        this.origin = origin;
    }

    public HazardType_ getType()
    {
        return type;
    }

    public void setType(HazardType_ type)
    {
        this.type = type;
    }

}
