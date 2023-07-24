package com.templechecklist.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "traveler")
public class TravelerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private String uuid;
    private String documentTypeId;
    private String document;
    private String travelId;
    private String travelerTypeId;
    private String name;
    private String lastName;
    private Integer age;
    private String cellPhone;
    private Date creationDate;
    private Boolean leader;

    @ManyToOne
    @JoinColumn(name = "documentTypeId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private DocumentTypeEntity documentType;

    @ManyToOne
    @JoinColumn(name = "travelId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private TravelEntity travel;

    @ManyToOne
    @JoinColumn(name = "travelerTypeId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private TravelerTypeEntity travelerType;

    @OneToMany(mappedBy = "traveler", orphanRemoval = true, cascade = {
            CascadeType.ALL
    }, fetch = FetchType.LAZY)
    private List<PaymentEntity> payments;

}
