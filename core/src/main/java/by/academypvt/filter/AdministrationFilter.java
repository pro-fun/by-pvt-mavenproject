package by.academypvt.filter;

import by.academypvt.api.dto.user.Role;
import by.academypvt.api.dto.user.UserResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class AdministrationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);
        if(httpSession == null) {
            httpServletRequest.setAttribute("message", "Необходимо пройти аутентификацию.");
            httpServletRequest.getRequestDispatcher("errorAuthorise.jsp").forward(servletRequest, servletResponse);
        }
        UserResponse userResponse = (UserResponse) httpSession.getAttribute("userAuthentication");
        if(userResponse.getRole().equals(Role.CLIENT)) {
            httpServletRequest.setAttribute("message", "У вас недостаточно прав для просмотра!");
            httpServletRequest.getRequestDispatcher("error.jsp").forward(servletRequest, servletResponse);
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
