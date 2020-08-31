package br.edu.utfpr.dv.siacoes.model;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @ToString @NoArgsConstructor
public class Campus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idCampus;
	private String name;
	private String address;
	@NonNull private transient byte[] logo;
	private boolean active;
	private String site;
	private String initials;

}
