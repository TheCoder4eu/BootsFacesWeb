/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bootsfaces.issues.issue918;

import java.util.List;

public class HazardType_
{

    private String code;
    private String text;
    private List<HazardOrigin_> hazardOrigins;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public List<HazardOrigin_> getHazardOrigins()
    {
        return hazardOrigins;
    }

    public void setHazardOrigins(List<HazardOrigin_> hazardOrigins)
    {
        this.hazardOrigins = hazardOrigins;
    }

}
