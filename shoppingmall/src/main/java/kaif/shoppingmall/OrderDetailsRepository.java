package kaif.shoppingmall;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    // Custom query methods (if any)
}
