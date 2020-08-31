package br.edu.utfpr.dv.siacoes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class ThemeSuggestion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idThemeSuggestion;
	@NonNull private Department department;
	@NonNull private User user;
	@NonNull private String title;
	@NonNull private String proponent;
	@NonNull private String objectives;
	@NonNull private String proposal;
	@NonNull private Date submissionDate;
	@NonNull private boolean active;

}
