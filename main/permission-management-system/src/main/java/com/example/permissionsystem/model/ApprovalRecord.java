package com.example.permissionsystem.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "approval_record")
public class ApprovalRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "form_data_id", nullable = false)
  private FormData formData;

  @ManyToOne
  @JoinColumn(name = "approver_id", nullable = false)
  private User approver;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status;

  private String comments;

  @Column(name = "created_at", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  public enum Status {
    APPROVED,
    REJECTED
  }

  // Getters and Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FormData getFormData() {
    return formData;
  }

  public void setFormData(FormData formData) {
    this.formData = formData;
  }

  public User getApprover() {
    return approver;
  }

  public void setApprover(User approver) {
    this.approver = approver;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
