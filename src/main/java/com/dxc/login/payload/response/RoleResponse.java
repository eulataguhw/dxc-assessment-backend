package com.dxc.login.payload.response;

import java.util.List;

public class RoleResponse {
    private List<String> roles;

    public RoleResponse(List<String> roles) {
        this.roles = roles;
    }
    
    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


}
