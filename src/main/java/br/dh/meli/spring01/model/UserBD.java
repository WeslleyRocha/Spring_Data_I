package br.dh.meli.spring01.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity //dizendo p JPA que ela vai consumir o BD
@Table(name = "tb_user") //personalizando nome da tabelan, não utilizando o nome da classe no bando de dados
public class UserBD {

    @Id //dizendo que ID é uma PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ele gera um ID automático e sequencial
    private long id;

    //dizendo que é uma coluna e eu poderia dar um nome personalizado, caso quisesse um nome diferente
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    //unique = true quer dizer que não pode ter dois e-mails iguais
    @Column(length = 80, nullable = false, unique = true)
    private String email;

}
