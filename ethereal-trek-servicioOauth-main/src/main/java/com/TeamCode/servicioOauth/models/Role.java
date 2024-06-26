package com.TeamCode.servicioOauth.models;

import com.TeamCode.servicioOauth.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    private String id;
    private Roles nombre;
}
