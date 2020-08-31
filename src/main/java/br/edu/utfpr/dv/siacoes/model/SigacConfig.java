package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;

import br.edu.utfpr.dv.siacoes.util.StringUtils;
import lombok.*;

@Setter @Getter @NoArgsConstructor
public class SigacConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 private Department department;
	 private double minimumScore;
	 private int maxFileSize;

	public String getMaxFileSizeAsString() {
		if(this.getMaxFileSize() <= 0) {
			return "Tamanho Ilimitado";
		} else {
			return "Tam. Máx. " + StringUtils.getFormattedBytes(this.getMaxFileSize());
		}
	}

}
