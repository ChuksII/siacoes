package br.edu.utfpr.dv.siacoes.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Activity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int idActivity;
	private ActivityGroup group;
	private ActivityUnit unit;
	private Department department;
	private String description;
	private double score;
	private double maximumInSemester;
	private boolean active;
	private int sequence;

}
