package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;

import br.edu.utfpr.dv.siacoes.model.EvaluationItem.EvaluationItemType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.annotation.Nonnull;

@Setter @Getter @NoArgsConstructor
public class InternshipEvaluationItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NonNull private int idInternshipEvaluationItem;
	@Nonnull private String description;
	@NonNull private double ponderosity;
	@Nonnull private boolean active;
	@NonNull private int sequence;
	@Nonnull private EvaluationItemType type;
	@NonNull private Department department;

	public boolean isActive() {
		return active;
	}

}
