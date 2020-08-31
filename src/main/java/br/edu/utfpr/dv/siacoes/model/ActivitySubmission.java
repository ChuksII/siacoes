package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.util.Date;

import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.*;

@Getter @Setter @NoArgsConstructor
public class ActivitySubmission implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum ActivityFeedback{
		NONE(0), APPROVED(1), DISAPPROVED(2);
		
		private final int value; 
		ActivityFeedback(int value){ 
			this.value = value; 
		}
		
		public int getValue(){ 
			return value;
		}
		
		public static ActivityFeedback valueOf(int value){
			for(ActivityFeedback p : ActivityFeedback.values()){
				if(p.getValue() == value){
					return p;
				}
			}
			
			return null;
		}
		
		public String toString(){
			switch(this){
			case NONE:
				return "Nenhum";
			case APPROVED:
				return "Aceita";
			case DISAPPROVED:
				return "Não aceita";
			default:
				return "";
			}
		}
	}
	
	@NonNull private int idActivitySubmission;
	@NonNull private User student;
	@NonNull private User feedbackUser;
	@NonNull private Department department;
	@NonNull private Activity activity;
	@NonNull private int semester;
	@NonNull private int year;
	@NonNull private Date submissionDate;
	private transient byte[] file;
	@NonNull private double amount;
	@NonNull private ActivityFeedback feedback;
	private Date feedbackDate;
	@NonNull private double validatedAmount;
	@NonNull private String comments;
	@NonNull private String description;
	@NonNull private int stage;
	@NonNull private String feedbackReason;

	public double getScore() {
		double score = 0;
		
		if(this.getFeedback() == ActivityFeedback.APPROVED) {
			if(this.getActivity().getUnit().isFillAmount()) {
				score = this.getActivity().getScore() * this.getValidatedAmount();
			} else {
				score = this.getActivity().getScore();
			}
			
			if((this.getActivity().getMaximumInSemester() > 0) && (score > this.getActivity().getMaximumInSemester())) {
				score = this.getActivity().getMaximumInSemester();
			}
		}
		
		return score;
	}

}
