package br.edu.utfpr.dv.siacoes.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class InternshipPosterRequestForm {
	
	@NonNull private Date date;
	@NonNull private Department department;
	@NonNull private User manager;
	@NonNull private User student;
	@NonNull private User supervisor;
	@NonNull private List<InternshipPosterAppraiserRequest> appraisers;
	@NonNull private String articles;


}
