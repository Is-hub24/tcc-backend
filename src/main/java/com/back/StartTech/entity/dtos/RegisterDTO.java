package com.back.StartTech.entity.dtos;

import com.back.StartTech.entity.ClienteRole;
import org.apache.catalina.User;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

public record RegisterDTO(String login, String password, ClienteRole role) {
}
