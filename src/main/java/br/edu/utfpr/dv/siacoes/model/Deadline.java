package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.util.Date;

import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.atmosphere.config.service.Get;


@Getter @Setter @NoArgsConstructor
public class Deadline implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NonNull private int idDeadline;
	@NonNull private int semester;
	@NonNull private int year;
	@NonNull private Date proposalDeadline;
	@NonNull private Date projectDeadline;
	@NonNull private Date thesisDeadline;
	@NonNull private Date projectFinalDocumentDeadline;
	@NonNull private Date thesisFinalDocumentDeadline;
	@NonNull private Department department;

}
