package com.train.app.model.entity;

import com.train.app.model.marker.HasId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tax")
public class Tax implements HasId<Integer> {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_base_ticket_id")
    private BaseTicket taxBaseTicket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_expense_id")
    private Expense taxExpense;

}