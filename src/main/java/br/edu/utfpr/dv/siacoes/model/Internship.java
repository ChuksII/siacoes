package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;

@Getter @Setter @NoArgsConstructor
public class Internship implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum InternshipStatus{
		CURRENT(0), FINISHED(1);
		
		private final int value; 
		InternshipStatus(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static InternshipStatus valueOf(int value){
			for(InternshipStatus d : InternshipStatus.values()){
				if(d.getValue() == value){
					return d;
				}
			}
			
			return null;
		}
		
		public String toString(){
			return this.getDescription();
		}
		
		public String getDescription(){
			switch(this){
				case CURRENT:
					return "Em Andamento";
				case FINISHED:
					return "Finalizado";
				default:
					return "";
			}
		}
	}
	
	public enum InternshipType{
		NONREQUIRED(0), REQUIRED(1);
		
		private final int value; 
		InternshipType(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static InternshipType valueOf(int value){
			for(InternshipType d : InternshipType.values()){
				if(d.getValue() == value){
					return d;
				}
			}
			
			return null;
		}
		
		public String toString(){
			return this.getDescription();
		}
		
		public String getDescription(){
			switch(this){
				case NONREQUIRED:
					return "Não Obrigatório";
				case REQUIRED:
					return "Obrigatório";
				default:
					return "Não Obrigatório";
			}
		}
	}
	
	public enum InternshipRequiredType{
		UNIVERSITY(0), EXTERNAL(1), SCHOLARSHIP(2), PROFESSIONAL(3), VALIDATION(4);
		
		private final int value; 
		InternshipRequiredType(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static InternshipRequiredType valueOf(int value){
			for(InternshipRequiredType d : InternshipRequiredType.values()){
				if(d.getValue() == value){
					return d;
				}
			}
			
			return null;
		}
		
		public String toString(){
			return this.getDescription();
		}
		
		public String getDescription(){
			switch(this){
				case UNIVERSITY:
					return "UTFPR como UCE";
				case EXTERNAL:
					return "UCE Externa";
				case SCHOLARSHIP:
					return "Bolsista";
				case PROFESSIONAL:
					return "Atividade Profissional";
				case VALIDATION:
					return "Validação";
				default:
					return "UTFPR como UCE";
			}
		}
	}
	
	@Nonnull private int idInternship;
	@Nonnull private Department department;
	@Nonnull private Company company;
	@Nonnull private User companySupervisor;
	@Nonnull private User supervisor;
	@Nonnull private User student;
	@Nonnull private InternshipType type;
	@Nonnull private InternshipRequiredType requiredType;
	@Nonnull private String comments;
	@Nonnull private Date startDate;
	@Nonnull private Date endDate;
	@Nonnull private String reportTitle;
	@Nonnull private String term;
	@Nonnull private double weekHours;
	@Nonnull private int weekDays;
	@Nonnull private int totalHours;
	private transient byte[] internshipPlan;
	private transient byte[] finalReport;
	@Nonnull private List<InternshipReport> reports;
	private boolean fillOnlyTotalHours;

	public InternshipStatus getStatus(){
		if((this.getEndDate() == null) || (this.getEndDate().after(DateUtils.getToday().getTime()))){
			return InternshipStatus.CURRENT;
		}else{
			return InternshipStatus.FINISHED;
		}
	}

}
