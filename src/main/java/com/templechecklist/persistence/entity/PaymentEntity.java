package com.templechecklist.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private String uuid;
    private Date date;
    private Double amount;
    private String travelerId;
    private String methodId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "travelerId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private TravelerEntity traveler;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "methodId", referencedColumnName = "uuid", insertable = false, updatable = false)
    private MethodEntity method;

}
