package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;

import br.edu.utfpr.dv.siacoes.model.User.UserProfile;
import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserDepartment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idUserDepartment;
	@NonNull private User user;
	@NonNull private Department department;
	@NonNull private UserProfile profile;
	private boolean sigacManager;
	private boolean sigesManager;
	private boolean sigetManager;
	private boolean departmentManager;
	@NonNull private int registerSemester;
	@NonNull private int registerYear;

}
