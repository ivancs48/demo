package com.example.demo.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	private static final String SECRET = Sha512DigestUtils.shaHex("123456");
	private final int jwtExpirationInMs = 3600000;
	private Logger logger = LoggerFactory.getLogger("Autenticacion");

	@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

		String token = getJWTToken(username);
		User user = new User();
		user.setUsername(username);
		user.setToken(token);
		return user;
	}

	private String getJWTToken(String username) {
		Date expiryDate = new Date(System.currentTimeMillis() + jwtExpirationInMs);
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();

		logger.info("Bearer " + token);
		return "Bearer " + token;
	}
	/*
	 * Generar de nuevo
Los roles que puedes agregar dependen completamente de las necesidades de tu aplicación. En general, los roles representan los diferentes niveles de acceso o permisos que un usuario puede tener en tu aplicación. Algunos ejemplos comunes de roles podrían ser:

"ROLE_USER": Un usuario regular con permisos básicos.
"ROLE_ADMIN": Un administrador con permisos para realizar tareas de administración, como agregar o eliminar usuarios.
"ROLE_MODERATOR": Un moderador con permisos para moderar contenido, como comentarios o publicaciones de usuarios.
"ROLE_GUEST": Un invitado con permisos limitados, tal vez solo pueda ver cierto contenido pero no interactuar con él.
Estos son solo ejemplos y los roles que uses en tu aplicación pueden ser completamente diferentes. Lo importante es que cada rol represente un conjunto distinto de permisos o niveles de acceso.
	 * */
}
