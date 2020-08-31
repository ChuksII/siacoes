package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.util.Date;

import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;

@Getter @Setter @NoArgsConstructor
public class FinalSubmission implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Nonnull private int idFinalSubmission;
	@Nonnull private Department department;
	@Nonnull private User student;
	@Nonnull private double finalScore;
	@Nonnull private User feedbackUser;
	@Nonnull private Date date;
	private transient byte[] report;

}
