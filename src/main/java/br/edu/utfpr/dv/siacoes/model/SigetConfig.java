package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;

import br.edu.utfpr.dv.siacoes.util.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class SigetConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum SupervisorFilter {
		DEPARTMENT(0), CAMPUS(1), INSTITUTION(2), EVERYONE(3);
		
		private final int value; 
		SupervisorFilter(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static SupervisorFilter valueOf(int value){
			for(SupervisorFilter u : SupervisorFilter.values()){
				if(u.getValue() == value){
					return u;
				}
			}
			
			return null;
		}
		
		public String toString(){
			switch(this){
				case DEPARTMENT:
					return "Departamento/Coordenação";
				case CAMPUS:
					return "Câmpus";
				case INSTITUTION:
					return "Instituição";
				case EVERYONE:
					return "Todos";
				default:
					return "";
			}
		}
	}
	
	public enum AttendanceFrequency {
		WEEKLY(0), BIWEEKLY(1), MONTHLY(2), BIMONTHLY(3), QUARTERLY(4);
		
		private final int value; 
		AttendanceFrequency(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static AttendanceFrequency valueOf(int value){
			for(AttendanceFrequency u : AttendanceFrequency.values()){
				if(u.getValue() == value){
					return u;
				}
			}
			
			return null;
		}
		
		public String toString(){
			switch(this){
				case WEEKLY:
					return "Semanal";
				case BIWEEKLY:
					return "Quinzenal";
				case MONTHLY:
					return "Mensal";
				case BIMONTHLY:
					return "Bimestral";
				case QUARTERLY:
					return "Trimestral";
				default:
					return "";
			}
		}
	}
	
	@NonNull private Department department;
	@NonNull private double minimumScore;
	private boolean registerProposal;
	private boolean showGradesToStudent;
	@NonNull private SupervisorFilter supervisorFilter;
	@NonNull private SupervisorFilter cosupervisorFilter;
	private int supervisorIndication;
	private int maxTutoredStage1;
	private int maxTutoredStage2;
	private boolean requestFinalDocumentStage1;
	@NonNull private String repositoryLink;
	private boolean supervisorJuryRequest;
	private boolean supervisorAgreement;
	private boolean supervisorJuryAgreement;
	private boolean validateAttendances;
	@NonNull private AttendanceFrequency attendanceFrequency;
	private int maxFileSize;
	private int minimumJuryMembers;
	private int minimumJurySubstitutes;
	private int juryTimeStage1;
	private int juryTimeStage2;
	private boolean supervisorAssignsGrades;
	private boolean appraiserFillsGrades;
	private boolean useDigitalSignature;

	public String getMaxFileSizeAsString() {
		if(this.getMaxFileSize() <= 0) {
			return "Tamanho Ilimitado";
		} else {
			return "Tam. Máx. " + StringUtils.getFormattedBytes(this.getMaxFileSize());
		}
	}

}
