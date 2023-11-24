package com.example.demo.mapper;

import com.example.demo.dto.RoleDto;
import com.example.demo.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role mapToEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setRole(roleDto.getRole());
        role.setId(roleDto.getId());
        return role;
    }

    public RoleDto mapToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());
        return roleDto;
    }
}
