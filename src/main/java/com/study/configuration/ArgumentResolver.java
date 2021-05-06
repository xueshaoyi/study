package com.study.configuration;

import com.study.model.User;
import com.study.model.UserModel;
import com.study.service.TokenService;
import com.study.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xsy
 * @date 2021-04-29 9:57 下午
 */
public class ArgumentResolver implements HandlerMethodArgumentResolver {
    private TokenService tokenService;
    private UserService userService;

    public ArgumentResolver(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return User.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
            throws Exception {
        User user = new User();
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String token = request.getHeader("token");

        token = StringUtils.isNotEmpty(token) ? token : request.getHeader("AuthorizationV2");
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        long userId = tokenService.getUserIdByToken(token);
        UserModel userModel = userService.getUserById(userId);
        if (user != null) {
            user.setId(userId);
            user.setName(userModel.getUserName());
            user.setLoginName(userModel.getLoginName());
        }

        return user;
    }
}
