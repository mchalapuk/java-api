package net.quedex.client.account;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class LimitOrderSpec {

    private final long clientOrderId;
    private final int instrumentId;
    private final OrderSide side;
    private final int quantity;
    private final BigDecimal limitPrice;

    /**
     * @param clientOrderId id of an order given by the client, has to be different than ids of all other pending orders
     * @param instrumentId id of an instrument this order is for
     * @param side side of the order
     * @param quantity quantity of the order, has to be positive
     * @param limitPrice limit price of the order, has to be positive
     * @throws IllegalArgumentException if {@code quantity} or {@code limitPrice} is not positive
     * @throws NullPointerException if any of nullable arguments is null
     */
    public LimitOrderSpec(long clientOrderId, int instrumentId, OrderSide side, int quantity, BigDecimal limitPrice) {
        checkArgument(quantity > 0, "quantity=%s <= 0", quantity);
        checkArgument(limitPrice.compareTo(BigDecimal.ZERO) > 0, "limitPrice=%s <= 0", limitPrice);
        this.clientOrderId = clientOrderId;
        this.instrumentId = instrumentId;
        this.side = checkNotNull(side, "null side");
        this.quantity = quantity;
        this.limitPrice = limitPrice;
    }

    public long getClientOrderId() {
        return clientOrderId;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public OrderSide getSide() {
        return side;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LimitOrderSpec that = (LimitOrderSpec) o;
        return clientOrderId == that.clientOrderId &&
                instrumentId == that.instrumentId &&
                quantity == that.quantity &&
                side == that.side &&
                Objects.equal(limitPrice, that.limitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clientOrderId, instrumentId, side, quantity, limitPrice);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("clientOrderId", clientOrderId)
                .add("instrumentId", instrumentId)
                .add("side", side)
                .add("quantity", quantity)
                .add("limitPrice", limitPrice)
                .toString();
    }
}
