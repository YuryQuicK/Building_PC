package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "OrderedDetails")
public class OrderedDetail {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_id")
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "Id")
    private Detail detail;

    public OrderedDetail() {}

    public OrderedDetail(Order order, Detail detail) {
        this.order = order;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }
}
