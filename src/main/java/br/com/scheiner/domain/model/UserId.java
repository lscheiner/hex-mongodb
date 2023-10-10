package br.com.scheiner.domain.model;

public class UserId {

	private String document;
	private String email;

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserId [document=" + document + ", email=" + email + "]";
	}
}
