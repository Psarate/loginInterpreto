package br.com.interpreto.controller;

import br.com.interpreto.infra.security.DadosTokenJWT;
import br.com.interpreto.infra.security.TokenService;
import br.com.interpreto.model.usuario.Usuario;
import jakarta.validation.Valid;
import br.com.interpreto.model.usuario.DadosAutenticacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
        System.out.println("Entrou no controller");
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        System.out.println(dados.login());
        System.out.println(dados.senha());
        System.out.println(authenticationToken);
        var authentication = manager.authenticate(authenticationToken);
        System.out.println("Passou pelo método authenticate");
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
