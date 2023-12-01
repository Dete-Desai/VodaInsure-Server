package io.springboot.Voda.Entity;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="CorporatemedicalCover")

public class CorporatemedicalCover {

	
	

	@Id		    
	private Long CorporateID;
	
	@Column(name="CompanyName")
	private String CompanyName;
	
	@Column(name="contact_person_name")
	private String contact_person_name;
	
	@Column(name="contact_person_phone")
	private String contact_person_phone;
	
	@Column(name="medical_cover_type")
	private String medical_cover_type;
	
	@Column(name="policy_number")
	private String policy_number;
	
	@Column(name="NationalId")
	private int NationalId;

	public Long getCorporateID() {
		return CorporateID;
	}

	public void setCorporateID(Long corporateID) {
		CorporateID = corporateID;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getContact_person_name() {
		return contact_person_name;
	}

	public void setContact_person_name(String contact_person_name) {
		this.contact_person_name = contact_person_name;
	}

	public String getContact_person_phone() {
		return contact_person_phone;
	}

	public void setContact_person_phone(String contact_person_phone) {
		this.contact_person_phone = contact_person_phone;
	}

	public String getMedical_cover_type() {
		return medical_cover_type;
	}

	public void setMedical_cover_type(String medical_cover_type) {
		this.medical_cover_type = medical_cover_type;
	}

	public String getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(String policy_number) {
		this.policy_number = policy_number;
	}

	public int getNationalId() {
		return NationalId;
	}

	public void setNationalId(int i) {
		NationalId = i;
	}

	public CorporatemedicalCover(Long corporatID, String companyName, String contact_person_name,
			String contact_person_phone, String medical_cover_type, String policy_number, int nationalId) {
		super();
		CorporateID = getCorporateID();
		CompanyName = companyName;
		this.contact_person_name = contact_person_name;
		this.contact_person_phone = contact_person_phone;
		this.medical_cover_type = medical_cover_type;
		this.policy_number = policy_number;
		NationalId = nationalId;
	}
	
	public CorporatemedicalCover() {
		
	}

	@Override
	public String toString() {
		return "CorporatemedicalCover [CorporateID=" + CorporateID + ", CompanyName=" + CompanyName
				+ ", contact_person_name=" + contact_person_name + ", contact_person_phone=" + contact_person_phone
				+ ", medical_cover_type=" + medical_cover_type + ", policy_number=" + policy_number + ", NationalId="
				+ NationalId + "]";
	}
	  @PrePersist
	    public void generateUniqueSixDigitId1() {
	        this.CorporateID = generateUniqueSixDigitId();
	    }

	  private static long generateUniqueSixDigitId() {
		    return Long.parseLong(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6));
	  }
	  


			}


