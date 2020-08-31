package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.util.Date;

import br.edu.utfpr.dv.siacoes.model.Module.SystemModule;
import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Certificate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull private int idCertificate;
	@NonNull private Department department;
	@NonNull private User user;
	@NonNull private SystemModule module;
	@NonNull private Date date;
	@NonNull private String guid;
	private transient byte[] file;

}
