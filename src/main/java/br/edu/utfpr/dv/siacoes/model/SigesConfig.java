package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;

import br.edu.utfpr.dv.siacoes.model.SigetConfig.SupervisorFilter;
import br.edu.utfpr.dv.siacoes.util.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class SigesConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum JuryFormat {
		INDIVIDUAL(0), SESSION(1);
		
		private final int value; 
		JuryFormat(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static JuryFormat valueOf(int value){
			for(JuryFormat u : JuryFormat.values()){
				if(u.getValue() == value){
					return u;
				}
			}
			
			return null;
		}
		
		public String toString(){
			switch(this){
				case INDIVIDUAL:
					return "Banca Individual";
				case SESSION:
					return "Apresentação de Pôster/Seminário";
				default:
					return "";
			}
		}
	}
	
	@NonNull private Department department;
	@NonNull private double minimumScore;
	@NonNull private double supervisorPonderosity;
	@NonNull private double companySupervisorPonderosity;
	private boolean showGradesToStudent;
	@NonNull private SupervisorFilter supervisorFilter;
	private boolean supervisorFillJuryForm;
	private int maxFileSize;
	private int juryTime;
	private boolean fillOnlyTotalHours;
	@NonNull private JuryFormat juryFormat;
	private boolean appraiserFillsGrades;
	private boolean useDigitalSignature;
	private int minimumJuryMembers;
	private int minimumJurySubstitutes;


	public String getMaxFileSizeAsString() {
		if(this.getMaxFileSize() <= 0) {
			return "Tamanho Ilimitado";
		} else {
			return "Tam. Máx. " + StringUtils.getFormattedBytes(this.getMaxFileSize());
		}
	}

}
