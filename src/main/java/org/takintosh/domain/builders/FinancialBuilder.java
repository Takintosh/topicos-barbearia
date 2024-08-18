package org.takintosh.domain.builders;

import org.takintosh.domain.models.Barber;
import org.takintosh.domain.models.Client;
import org.takintosh.domain.models.Financial;
import org.takintosh.domain.models.Product;

public class FinancialBuilder {
    private Long id;
    private double saleValue;
    private Product product;
    private Barber barber;
    private Client client;

    public FinancialBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FinancialBuilder withSaleValue(double saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public FinancialBuilder withProduct(Product product) {
        this.product = product;
        return this;
    }

    public FinancialBuilder withBarber(Barber barber) {
        this.barber = barber;
        return this;
    }

    public FinancialBuilder withClient(Client client) {
        this.client = client;
        return this;
    }

    public Financial build() {
        return new Financial(id, saleValue, product, barber, client);
    }
}