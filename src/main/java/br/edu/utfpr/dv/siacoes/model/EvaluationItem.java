package br.edu.utfpr.dv.siacoes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.annotation.Nonnull;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class EvaluationItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum EvaluationItemType{
		WRITING(0), ORAL(1), ARGUMENTATION(2);
		
		private final int value; 
		EvaluationItemType(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public String toString(){
			switch(this){
			case WRITING:
				return "Escrita";
			case ORAL:
				return "Apresentação";
			case ARGUMENTATION:
				return "Arguição";
			default:
				return "";
			}
		}
		
		public static EvaluationItemType valueOf(int value){
			for(EvaluationItemType d : EvaluationItemType.values()){
				if(d.getValue() == value){
					return d;
				}
			}
			
			return null;
		}
		
		public static EvaluationItemType fromString(String value){
			for(EvaluationItemType d : EvaluationItemType.values()){
				if(d.toString().equals(value)){
					return d;
				}
			}
			
			return null;
		}
	}

	@NonNull private int idEvaluationItem;
	@Nonnull private String description;
	@NonNull private double ponderosity;
	@Nonnull private int stage;
	@NonNull private boolean active;
	@Nonnull private int sequence;
	@Nonnull  private EvaluationItemType type;
	@Nonnull private Department department;

	public boolean isActive() {
		return active;
	}
	}
