package msg.filters;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.ejb.Stateless;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class AuthorizationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authorizationValue = containerRequestContext.getHeaderString("Authorization");
        if (authorizationValue.startsWith("Bearer")) {
            Algorithm algorithm = Algorithm.HMAC256("harambe");
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
            DecodedJWT decodedJWT = verifier.verify(authorizationValue.split(" ")[1]);
            if (isTokenValid(decodedJWT)) {
                List<String> permissions = decodedJWT.getClaim("permissions").asList(String.class);
                String username = decodedJWT.getClaim("username").asString();
                containerRequestContext.setSecurityContext(new Authorization(permissions, username) {
                });
            }
        }
    }

    private boolean isTokenValid(DecodedJWT token) {
        return true;


    }

    private class Authorization implements SecurityContext {
        String userName;
        private List<String> permission;

        public Authorization(List<String> permission, String userName) {
            this.permission = permission;
            this.userName = userName;
        }

        @Override
        public Principal getUserPrincipal() {
            return new Principal() {
                @Override
                public String getName() {
                    return userName;
                }
            };
        }

        @Override
        public boolean isUserInRole(String s) {
            return permission.contains(s);
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public String getAuthenticationScheme() {
            return null;
        }
    }
}

