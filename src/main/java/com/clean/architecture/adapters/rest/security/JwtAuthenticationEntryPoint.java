package com.clean.architecture.adapters.rest.security;

import com.clean.architecture.application.util.JsonFacade;
import com.generated.swaggerCodegen.model.BackendErrorResponse;
import com.generated.swaggerCodegen.model.MetaData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

@Component
@AllArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final JsonFacade jsonFacade;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        BackendErrorResponse resp = getErrorResponse(request, authException.getMessage(), "UNAUTHORIZED");

        String jsonResponse = this.jsonFacade.pojoToJson(resp);
        response.setContentType("application/json");
        response.setStatus(401);
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }

    public static BackendErrorResponse getErrorResponse(final WebRequest request, final String msg, final String errorCode) {
        BackendErrorResponse response = new BackendErrorResponse();
        MetaData meta = new MetaData();
        meta.setTimestamp(Instant.now().toString());
        meta.setPath(((ServletWebRequest) request).getRequest().getServletPath());

        response.setMeta(meta);
        response.setErrorCode(errorCode);
        response.setDescription(msg);
        return response;
    }

    public static BackendErrorResponse getErrorResponse(final HttpServletRequest request, final String msg, final String errorCode) {
        BackendErrorResponse response = new BackendErrorResponse();
        MetaData meta = new MetaData();
        meta.setTimestamp(Instant.now().toString());
        meta.setPath(request.getServletPath());

        response.setMeta(meta);
        response.setErrorCode(errorCode);
        response.setDescription(msg);
        return response;
    }

}
