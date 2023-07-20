package com.templechecklist.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "traveler")
public class TravelerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private String uuid;
    private String documentTypeId;
    private String travelId;
    private String travelerTypeId;
    private String name;
    private String lastName;
    private Integer age;
    private String cellPhone;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "documentTypeId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private DocumentTypeEntity documentType;

    @ManyToOne
    @JoinColumn(name = "travelId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private TravelEntity travelEntity;

    @ManyToOne
    @JoinColumn(name = "travelerTypeId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private TravelerTypeEntity travelerTypeEntity;



}
