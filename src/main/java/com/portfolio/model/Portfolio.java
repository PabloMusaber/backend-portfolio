
package com.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Portfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_portfolio;
    
    private String name;
    private String title;
    private String introduction;
    private String footer;
    private String imagen;
}
