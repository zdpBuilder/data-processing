package com.ruoyi.system.vo;

import com.ruoyi.system.domain.PortalUser;
import com.ruoyi.system.domain.PortalUserEdue;
import com.ruoyi.system.domain.PortalUserFamily;

import java.util.List;

public class PortalUserVo extends PortalUser {

    private List<PortalUserEdue> portalUserEdue ;
    private List<PortalUserFamily> portalUserFamily ;

    public List<PortalUserEdue> getPortalUserEdue() {
        return portalUserEdue;
    }

    public void setPortalUserEdue(List<PortalUserEdue> portalUserEdue) {
        this.portalUserEdue = portalUserEdue;
    }

    public List<PortalUserFamily> getPortalUserFamily() {
        return portalUserFamily;
    }

    public void setPortalUserFamily(List<PortalUserFamily> portalUserFamily) {
        this.portalUserFamily = portalUserFamily;
    }
}
