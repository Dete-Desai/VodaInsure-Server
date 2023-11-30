package io.springboot.Voda.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "SelfmedicalClaims")
public class SelfmedicalClaims {

  @Id
  private Integer selfmedicalClaimId;

 @Column(name = "SelfId")
  private Integer SelfId;
    
  @ManyToOne
  @JoinColumn(name="SelfId")
private SelfmedicalCover selfmedicalCover;
    
  @ManyToOne
  @JoinColumn(name = "NationalId")  
   private User user;
    
    @Column(name = "claimdate")
    private LocalDateTime claimdate;

    @Column(name = "claimstatus")
    private String ClaimStatus;

    @Column(name = "ClaimAmount")
    private float ClaimAmount;

    @Column(name = "ClaimDescription")
    private String ClaimDescription;

    @Column(name = "ClaimType")
    private String ClaimType;

    @Column(name = "DocumentLink")
    private String DocumentLink;

    @Column(name = "policy_number", unique = true) // Assuming you want policy_number to be unique
    private String policy_number;

    
   @PrePersist
  public void generateUniqueThreeDigitIdAndPolicyNumber() {
   this.selfmedicalClaimId = generateUniqueThreeDigitId();
   this.policy_number = generateUniquePolicyNumber();
    }

    private static Set<Integer> generatedNumbers = new HashSet<>();
    private static Set<String> generatedPolicyNumbers = new HashSet<>();

    private Integer generateUniqueThreeDigitId() {
        int uniqueNumber;
        do {
            uniqueNumber = ThreadLocalRandom.current().nextInt(1000, 9999);
        } while (!generatedNumbers.add(uniqueNumber));
        return uniqueNumber;
    }

    static String generateUniquePolicyNumber() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String generatedPolicyNumber;

        do {
            StringBuilder policyNumber = new StringBuilder();

          
            for (int i = 0; i < 4; i++) {
                char randomLetter = letters.charAt(ThreadLocalRandom.current().nextInt(letters.length()));
                policyNumber.append(randomLetter);
            }

            for (int i = 0; i < 3; i++) {
                int randomNumber = ThreadLocalRandom.current().nextInt(0, 10);
                policyNumber.append(randomNumber);
            }

            generatedPolicyNumber = policyNumber.toString();
        } while (!generatedPolicyNumbers.add(generatedPolicyNumber));

        return generatedPolicyNumber;
    }

	public static String getGeneratedPolicyNumber() {
		
		return null;
	}
}
