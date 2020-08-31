package br.edu.utfpr.dv.siacoes.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.edu.utfpr.dv.siacoes.model.ProposalAppraiser.ProposalFeedback;
import br.edu.utfpr.dv.siacoes.util.DateUtils;
import lombok.*;

@Getter @Setter @NoArgsConstructor @ToString
public class Proposal implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NonNull private int idProposal;
	@NonNull private String title;
	@NonNull private String subarea;
	@NonNull private User student;
	@NonNull private User supervisor;
	private User cosupervisor;
	private transient byte[] file;
	private List<ProposalAppraiser> appraisers;
	@NonNull private int semester;
	@NonNull private int year;
	@NonNull private Date submissionDate;
	@NonNull private Department department;
	private boolean invalidated;
	@NonNull private ProposalFeedback supervisorFeedback;
	private Date supervisorFeedbackDate;
	@NonNull private String supervisorComments;
	private transient boolean fileUploaded;

	
	public Proposal(User student){
		this.setIdProposal(0);
		this.setTitle("");
		this.setSubarea("");
		this.setStudent(student);
		this.setSupervisor(new User());
		this.setCosupervisor(null);
		this.setFile(null);
		this.setAppraisers(null);
		this.setSemester(DateUtils.getSemester());
		this.setYear(DateUtils.getYear());
		this.setSubmissionDate(DateUtils.getToday().getTime());
		this.setDepartment(new Department());
		this.setInvalidated(false);
		this.setSupervisorFeedback(ProposalFeedback.NONE);
		this.setSupervisorFeedbackDate(null);
		this.setSupervisorComments("");
		this.setFileUploaded(false);
	}
	
	public boolean isInvalidated() {
		return invalidated;
	}
	public boolean isFileUploaded() {
		return fileUploaded;
	}

}
